package com.wechat.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wechat.bean.Greens;
import com.wechat.bean.GreensExample;
import com.wechat.bean.GreensExample.Criteria;
import com.wechat.bean.Msg;
import com.wechat.service.GreensService;

@Controller
public class GreensController {
	
	@Autowired
	private GreensService greensService;
	
	/**
	 * 前端根据标签进行查询，需传两个值（pn,glabel）
	 * 分页（一页8个）
	 * @param pn
	 * @param glabel
	 * @return
	 */
	@RequestMapping("/wchat_findByGlabel")
	@ResponseBody
	public Msg wchat_findByGlabel(@RequestParam(value="pn",defaultValue="1")Integer pn,
			@RequestParam(value="glabel")String glabel){
		GreensExample greensExample=new GreensExample();
		Criteria criteria=greensExample.createCriteria();
		criteria.andGlabelLike("%"+glabel+"%");
		PageHelper.startPage(pn, 8);
		List<Greens> list=greensService.findByGlabel(greensExample);
		System.out.println("标签值为"+glabel+"，模糊查询");
		PageInfo page=new PageInfo(list,5);
		return Msg.success().add("pageInfo", page);
	}
	
	/**
	 * 前端根据rule进行查找，需传两个值（pn,rule）
	 * rule有两个值：hot,new
	 * hot:查询点击量最多的菜品（分页 8个一页）
	 * new:查询最新更新的菜品（分页8个一页）
	 * @param pn
	 * @param rule
	 * @return
	 */
	@RequestMapping("/wechat_findByHits")
	@ResponseBody
	public Msg wechat_findByHits(@RequestParam(value="pn",defaultValue="1")Integer pn,
			@RequestParam(value="rule")String rule){
		if(rule.equals("hot")){
			GreensExample greensExample=new GreensExample();
			greensExample.setOrderByClause("ghits DESC,gid DESC");
			PageHelper.startPage(pn, 8);
			List<Greens> list=greensService.findByGhits(greensExample);
			System.out.println("点击量最多进行排序");
			PageInfo page=new PageInfo(list,5);
			return Msg.success().add("pageInfo", page);
		}else{
			GreensExample greensExample=new GreensExample();
			greensExample.setOrderByClause("gid DESC");
			PageHelper.startPage(pn, 8);
			List<Greens> list=greensService.findByGhits(greensExample);
			System.out.println("最新进行排序");
			PageInfo page=new PageInfo(list,5);
			return Msg.success().add("pageInfo", page);
		}
	}
	
	/**
	 * 前端根据菜系(gstyle)查找（分页，8个一页）
	 * 需要传入 pn(默认为第一页)，gstyle (菜系值不能为空)
	 * 查询的数据按点击量高低排序
	 * @param pn
	 * @param gstyle
	 * @return
	 */
	@RequestMapping("/wechat_findByGstyle")
	@ResponseBody
	public Msg wechat_findByGstyle(@RequestParam(value="pn",defaultValue="1")Integer pn,
			@RequestParam(value="gstyle")String gstyle){
		GreensExample greensExample=new GreensExample();
		greensExample.setOrderByClause("ghits DESC,gid DESC");
		Criteria criteria=greensExample.createCriteria();
		criteria.andGstyleLike("%"+gstyle+"%");
		PageHelper.startPage(pn, 8);
		List<Greens> list=greensService.findByGstyle(greensExample);
		System.out.println("所属菜系值为"+gstyle+"，模糊查询");
		PageInfo page=new PageInfo(list,5);
		return Msg.success().add("pageInfo", page);
		
	}
	
	/**
	 * 前端获取所有greens数据（分页，8个一页）
	 * 需传入值 pn(默认为1)
	 * 从新到旧排序
	 * @param pn
	 * @return
	 */
	@RequestMapping("/wechat_allgreens")
	@ResponseBody
	public Msg wechat_allgreens(@RequestParam(value="pn",defaultValue="1")Integer pn){
		GreensExample greensExample=new GreensExample();
		greensExample.setOrderByClause("gid DESC");
		PageHelper.startPage(pn, 8);
		List<Greens> list=greensService.findAll(greensExample);
		PageInfo page=new PageInfo(list,5);
		return Msg.success().add("pageInfo", page);
	}
	
	/**
	 * 随机推荐菜品
	 * @return
	 */
	@RequestMapping("/random_greens")
	@ResponseBody
	public Msg random_greens(){
		int num=greensService.countNum();
		System.out.println("总数："+num);
		List<Greens> list=new ArrayList<>();
		while(list.size()<8){
			int i=(int)(Math.random()*num)+1;
			System.out.println("随机的gid为："+i);
			Greens greens=greensService.findOneByGid(i);
			if(greens!=null){
				list.add(greens);
			}
		}
		System.out.println(list);
		return Msg.success().add("list", list);
	}
	
	/**
	 * 前端根据gid查找一条greens对象
	 * 并增加一次点击量
	 * @param gid
	 * @return
	 */
	@RequestMapping("/wechat_findgreens")
	@ResponseBody
	public Msg wechat_findgreens(@RequestParam(value="gid")Integer gid){
		Greens greens=greensService.findOneByGid(gid);
		greens.setGhits(greens.getGhits()+1);
		greensService.update(greens);
		return Msg.success().add("greens",greens);
	}
	
	/**
	 * 修改一条greens数据
	 * @param gname
	 * @param gid
	 * @param gstyle
	 * @param glabel
	 * @param editorValue
	 * @return
	 */
	@RequestMapping("/updateGreens")
	@ResponseBody
	public void updateGreens(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="gname")String gname,
			@RequestParam(value="gid")Integer gid,
			@RequestParam(value="gstyle")String gstyle,
			@RequestParam(value="glabel")String glabel,
			@RequestParam("file") MultipartFile file,
			@RequestParam(value="editorValue")String editorValue)throws Exception{
		Greens greens=greensService.findOneByGid(gid);
		greens.setGname(gname);
		greens.setGstyle(gstyle);
		greens.setGlabel(glabel);
		greens.setGneed(editorValue);
		//如果文件不为空，写入上传路径
		 if(!file.isEmpty()) {
	            //上传文件路径:Tomcat虚拟路径
	            String path = request.getServletContext().getRealPath("/image/");
	            //上传文件名
	            String filename = file.getOriginalFilename();
	            File filepath = new File(path,filename);
	            //判断路径是否存在，如果不存在就创建一个
	            if (!filepath.getParentFile().exists()) { 
	                filepath.getParentFile().mkdirs();
	            }
	            //将上传文件保存到一个目标文件当中
	            file.transferTo(new File(path + File.separator + filename));
	            System.out.println(path+"   "+filename);
	            String before_photo=greens.getGcover();
	            greens.setGcover(filename);
	            //删除原图片
	            if(!before_photo.equals("1231.jpg")){
		            File file1=new File(path+before_photo);
		            boolean a=file1.delete();
	            }
	        } 
		System.out.println(greens);
		greensService.update(greens);
		request.getRequestDispatcher("/view/greensManager.jsp").forward(request, response);
	}
	
	/**
	 * 根据gid查找一条菜品信息，传去updateGreens.jsp
	 * @param request
	 * @param response
	 * @param gid
	 * @throws Exception
	 */
	@RequestMapping("/findone")
	@ResponseBody
	public void findone(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="gid")Integer gid) throws Exception{
		Greens greens=greensService.findOneByGid(gid);
		request.setAttribute("greens", greens);
		request.getRequestDispatcher("/view/updateGreens.jsp").forward(request, response);
	}
	
	/**
	 * 根据gid删除一条菜品
	 * @param gid
	 * @return
	 */
	@RequestMapping(value="/deleteGreens/{gid}",method=RequestMethod.DELETE)
	@ResponseBody
	public Msg deleteGreens(@PathVariable(value="gid")Integer gid){
		greensService.deleteOne(gid);
		return Msg.success();
	}
	
	/**
	 * 后台对菜品进行查询
	 * 查询全部、菜品编号、菜品名（模糊查询）
	 * 所属菜系（模糊查询）、标签（模糊查询）、点击量（从高到低）
	 * @param pn
	 * @param select_way
	 * @param find_value
	 * @return
	 */
	@RequestMapping("/findAllgreens")
	@ResponseBody
	public Msg findAllgreens(@RequestParam(value="pn",defaultValue="1")Integer pn,
			@RequestParam(value="select_way")String select_way,
			@RequestParam(value="find_value")String find_value){
		System.out.println(select_way+" "+find_value);
		if(select_way.equals("全部")){
			GreensExample greensExample=new GreensExample();
			greensExample.setOrderByClause("gid DESC");
			PageHelper.startPage(pn, 5);
			List<Greens> list=greensService.findAll(greensExample);
			System.out.println(list);
			PageInfo page=new PageInfo(list,5);
			return Msg.success().add("pageInfo", page);
		}else if (select_way.equals("菜品编号")) {
			if(find_value==""){
				GreensExample greensExample=new GreensExample();
				greensExample.setOrderByClause("gid DESC");
				PageHelper.startPage(pn, 5);
				List<Greens> list=greensService.findAll(greensExample);
				System.out.println("菜品编号值为空，查全部");
				PageInfo page=new PageInfo(list,5);
				return Msg.success().add("pageInfo", page);
			}else{
				PageHelper.startPage(pn, 5);
				List<Greens> list=greensService.findByGid(Integer.valueOf(find_value));
				System.out.println("查询菜品编号值为‘"+find_value+"’的对象");
				PageInfo page=new PageInfo(list,5);
				return Msg.success().add("pageInfo", page);
			}
		}else if (select_way.equals("菜品名")){
			if(find_value==""){
				GreensExample greensExample=new GreensExample();
				greensExample.setOrderByClause("gid DESC");
				PageHelper.startPage(pn, 5);
				List<Greens> list=greensService.findAll(greensExample);
				System.out.println("菜品名值为空，查全部");
				PageInfo page=new PageInfo(list,5);
				return Msg.success().add("pageInfo", page);
			}else{
				GreensExample greensExample=new GreensExample();
				Criteria criteria=greensExample.createCriteria();
				criteria.andGnameLike("%"+find_value+"%");
				PageHelper.startPage(pn, 5);
				List<Greens> list=greensService.findByGname(greensExample);
				System.out.println("菜品名值为"+find_value+"，模糊查询");
				PageInfo page=new PageInfo(list,5);
				return Msg.success().add("pageInfo", page);

			}
		}else if (select_way.equals("所属菜系")){
			if(find_value==""){
				GreensExample greensExample=new GreensExample();
				greensExample.setOrderByClause("gid DESC");
				PageHelper.startPage(pn, 5);
				List<Greens> list=greensService.findAll(greensExample);
				System.out.println("所属菜系值为空，查全部");
				PageInfo page=new PageInfo(list,5);
				return Msg.success().add("pageInfo", page);
			}else{
				GreensExample greensExample=new GreensExample();
				Criteria criteria=greensExample.createCriteria();
				criteria.andGstyleLike("%"+find_value+"%");
				PageHelper.startPage(pn, 5);
				List<Greens> list=greensService.findByGstyle(greensExample);
				System.out.println("所属菜系值为"+find_value+"，模糊查询");
				PageInfo page=new PageInfo(list,5);
				return Msg.success().add("pageInfo", page);
			}
		}else if (select_way.equals("标签")){
			if(find_value==""){
				GreensExample greensExample=new GreensExample();
				greensExample.setOrderByClause("gid DESC");
				PageHelper.startPage(pn, 5);
				List<Greens> list=greensService.findAll(greensExample);
				System.out.println("标签值为空，查全部");
				PageInfo page=new PageInfo(list,5);
				return Msg.success().add("pageInfo", page);
			}else{
				GreensExample greensExample=new GreensExample();
				Criteria criteria=greensExample.createCriteria();
				criteria.andGlabelLike("%"+find_value+"%");
				PageHelper.startPage(pn, 5);
				List<Greens> list=greensService.findByGlabel(greensExample);
				System.out.println("标签值为"+find_value+"，模糊查询");
				PageInfo page=new PageInfo(list,5);
				return Msg.success().add("pageInfo", page);
			}
		}else{	
			GreensExample greensExample=new GreensExample();
			greensExample.setOrderByClause("ghits DESC,gid DESC");
			PageHelper.startPage(pn, 5);
			List<Greens> list=greensService.findByGhits(greensExample);
			System.out.println("点击量升序");
			PageInfo page=new PageInfo(list,5);
			return Msg.success().add("pageInfo", page);
		}
	}
	
	/**
	 * 添加greens对象，并跳去添加步骤的页面 addstep.jsp
	 * @param gname
	 * @param gstyle
	 * @param glabel
	 * @param editorValue
	 * @return
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping("/addGreens_next")
	@ResponseBody
	public void addGreens_next(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="gname")String gname,
			@RequestParam(value="gstyle")String gstyle,
			@RequestParam(value="glabel")String glabel,
			@RequestParam("file") MultipartFile file,
			@RequestParam(value="editorValue")String editorValue) throws ServletException, IOException{
		Greens greens=new Greens();
		greens.setGname(gname);
		greens.setGstyle(gstyle);
		greens.setGlabel(glabel);
		greens.setGwriter("system");
		String gcover=null;
		//如果文件不为空，写入上传路径
		 if(!file.isEmpty()) {
	            //上传文件路径:Tomcat虚拟路径
	            String path = request.getServletContext().getRealPath("/image/");
	            //上传文件名
	            String filename = file.getOriginalFilename();
	            File filepath = new File(path,filename);
	            //判断路径是否存在，如果不存在就创建一个
	            if (!filepath.getParentFile().exists()) { 
	                filepath.getParentFile().mkdirs();
	            }
	            //将上传文件保存到一个目标文件当中
	            file.transferTo(new File(path + File.separator + filename));
	            System.out.println(path+"   "+filename);
	            gcover=filename;
	        } 
		greens.setGcover(gcover);
		greens.setGneed(editorValue);
		greens.setGhits(0);
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		System.out.println(dateString);
		greens.setGdate(dateString);
		greensService.addGreens(greens);
		List<Greens> one=greensService.findAll();
		request.setAttribute("gid", one.get(one.size()-1).getGid());
		request.setAttribute("step",1);
		System.out.println(one.get(one.size()-1).getGid());
		request.getRequestDispatcher("/view/addstep.jsp").forward(request,response);
	}
	
	/**
	 * 只添加greens对象
	 * @param gname
	 * @param gstyle
	 * @param glabel
	 * @param editorValue
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping("/addGreens_last")
	@ResponseBody
	public void addGreens_last(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="gname")String gname,
			@RequestParam(value="gstyle")String gstyle,
			@RequestParam(value="glabel")String glabel,
			@RequestParam("file") MultipartFile file,
			@RequestParam(value="editorValue")String editorValue) throws Exception{
		Greens greens=new Greens();
		greens.setGname(gname);
		greens.setGstyle(gstyle);
		greens.setGlabel(glabel);
		greens.setGwriter("system");
		String gcover=null;
		//如果文件不为空，写入上传路径
		 if(!file.isEmpty()) {
	            //上传文件路径:Tomcat虚拟路径
	            String path = request.getServletContext().getRealPath("/image/");
	            //上传文件名
	            String filename = file.getOriginalFilename();
	            File filepath = new File(path,filename);
	            //判断路径是否存在，如果不存在就创建一个
	            if (!filepath.getParentFile().exists()) { 
	                filepath.getParentFile().mkdirs();
	            }
	            //将上传文件保存到一个目标文件当中
	            file.transferTo(new File(path + File.separator + filename));
	            System.out.println(path+"   "+filename);
	            gcover=filename;
	        } 
		greens.setGcover(gcover);
		greens.setGneed(editorValue);
		greens.setGhits(0);
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		System.out.println(dateString);
		greens.setGdate(dateString);
		greensService.addGreens(greens);
		System.out.println(greens);
		request.getRequestDispatcher("/view/greensManager.jsp").forward(request,response);
	}
}
