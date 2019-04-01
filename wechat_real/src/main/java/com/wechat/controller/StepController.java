package com.wechat.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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

import com.wechat.bean.Msg;
import com.wechat.bean.Step;
import com.wechat.bean.StepExample;
import com.wechat.bean.StepExample.Criteria;
import com.wechat.service.StepService;

@Controller
public class StepController {
	
	@Autowired
	private StepService stepService;
	
	/**
	 * 根据sid查找一条step数据
	 * @param sid
	 * @return
	 */
	@RequestMapping(value="/findStepBySid")
	@ResponseBody
	public Msg findStepBySid(@RequestParam(value="sid")Integer sid){
		Step step=stepService.findStepBySid(sid);
		System.out.println(step);
		return Msg.success().add("step",step);
	}
	
	/**
	 * 后台的跳转方法，跳去添加步骤
	 * @param request
	 * @param response
	 * @param gid
	 * @throws Exception
	 */
	@RequestMapping(value="/jump_addStep")
	@ResponseBody
	public void jump_addStep(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="gid")Integer gid)throws Exception{
		int num=stepService.countStep(gid);
		System.out.println(num);
		request.setAttribute("step", num+1);
		request.setAttribute("gid", gid);
		request.getRequestDispatcher("/view/addstep.jsp").forward(request,response);
	}
	
	/**
	 * 后台修改一条step数据
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping(value="/updateStep",method=RequestMethod.POST)
	@ResponseBody
	public void updateStep(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="sid")Integer sid,
			@RequestParam(value="describe")String describe,
			@RequestParam("file") MultipartFile file,
			@RequestParam("timing") int timing) throws Exception{
		Step step=stepService.findStepBySid(sid);
		System.out.println(step);
		step.setSdescribe(describe);
		step.setTiming(timing);
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
	            String before_photo=step.getSphoto();
	            step.setSphoto(filename);
	            //删除原图片
	            File file1=new File(path+before_photo);
	            boolean a=file1.delete();
	        } 
		 stepService.updateStep(step);
		 Step step2=stepService.findStepBySid(sid);
		System.out.println(step2);
		request.getRequestDispatcher("/view/updateStep.jsp?gid="+step.getGid()).forward(request, response);
	}
	
	/**
	 * 后台根据sid删除一条菜品步骤
	 * @param sid
	 * @return
	 */
	@RequestMapping(value="/deleteStep/{sid}",method=RequestMethod.DELETE)
	@ResponseBody
	public Msg deleteStep(HttpServletRequest request,@PathVariable(value="sid")Integer sid){
		Step step=stepService.findStepBySid(sid);
		String path = request.getServletContext().getRealPath("/image/");
		 //删除原图片
        File file1=new File(path+step.getSphoto());
        boolean a=file1.delete();
        //删除数据
		stepService.deleteone(sid);
		return Msg.success();
	}
	
	/**
	 * 根据gid,取出所有step数据
	 * @param request
	 * @param response
	 * @param gid
	 * @throws Exception
	 */
	@RequestMapping(value="/stepByGid")
	@ResponseBody
	public Msg stepByGid(@RequestParam("gid") int gid){
		StepExample stepExample=new StepExample();
		Criteria criteria=stepExample.createCriteria();
		criteria.andGidEqualTo(gid);
		List<Step> list=stepService.findAllByGid(stepExample);
		System.out.println(list);
		return Msg.success().add("list", list); 
	}
	
	/**
	 * 添加做菜步骤
	 * @param request
	 * @param file
	 * @param describe
	 * @param gid
	 * @param timing
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/addStep",method=RequestMethod.POST)
	@ResponseBody
	public void addStep(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("file") MultipartFile file,
			@RequestParam("describe") String describe,
			@RequestParam("step") int step,
			@RequestParam("gid") int gid,
			@RequestParam("timing") int timing) throws Exception{
		String sphoto=null;
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
	            sphoto=filename;
	        } 
		 Step step2=new Step();
		 step2.setGid(gid);
		 step2.setStep(step);
		 step2.setTiming(timing);
		 step2.setSdescribe(describe);;
		 step2.setSphoto(sphoto);
		 step2.setVoice("空");
		 stepService.addStep(step2);
		 request.setAttribute("gid", gid);
		 request.setAttribute("step", step+1);
		 request.getRequestDispatcher("/view/addstep.jsp").forward(request,response);
	}
}
