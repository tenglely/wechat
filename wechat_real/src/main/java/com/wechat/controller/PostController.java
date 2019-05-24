package com.wechat.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wechat.bean.Msg;
import com.wechat.bean.Post;
import com.wechat.service.PostService;
import com.wechat.util.Keyword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PostController {
	
	@Autowired
	private PostService postService;
	
	/**
	 * 前台获取8条贴子数据
	 * pn默认为第一页
	 * 获取的数据为由新到旧
	 * @param pn
	 * @return
	 */
	@RequestMapping("/wechat_findPost")
	@ResponseBody
	public Msg wechat_post(@RequestParam(value="pn",defaultValue="1") Integer pn){
		PageHelper.startPage(pn, 8);
		List<Post> posts=postService.getAll();
		PageInfo page=new PageInfo(posts,5);
		return Msg.success().add("pageInfo", page);
	}
	
	/**
	 * 1.添加一条贴子
	 * 内容为文字+图片
	 * 场景为：用户编写文字，然后添加图片，然后上传文字和上传图片
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping("/addPost")
	@ResponseBody
	public Msg addPost(HttpServletRequest request,
			@RequestParam(value="title")String title,
			@RequestParam(value="uid")Integer uid,
			@RequestParam(value="pcontent")String pcontent,
			@RequestParam("file") MultipartFile file) throws Exception{
		Post post=new Post();
		
		//关键词屏蔽
		String patha = request.getServletContext().getRealPath("/image/");
		title=Keyword.keyword(title, patha);
		post.setTitle(title);
		
		post.setUid(uid);
		post.setHits(0);
		post.setGoodnum(0);
		post.setBadnum(0);
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		post.setPdate(dateString);
		
		//关键词屏蔽
		pcontent=Keyword.keyword(pcontent, patha);
		post.setPcontent(pcontent);
		
		post.setPfile(null);
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
	            post.setPfile(filename);
	        } 
		 postService.addpost(post);
		 System.out.println("post添加成功");
		return Msg.success();
	}
	
	
	/**
	 * 2.后台根据贴子编号(pid)删除一条贴子
	 */
	//public Msg deletePost()
	@ResponseBody
	@RequestMapping(value = "/deletpostbypid/{pids}",method = RequestMethod.DELETE)
	public Msg deletePostByPid(@PathVariable("pids") String pid){
		if(pid.contains("-")){
			List<Integer> del_ids=new ArrayList<>();
			//批量删除
			String[] str_ids=pid.split("-");
			//组装ids的集合
			for(String string :str_ids){
				del_ids.add(Integer.parseInt(string));
			}
			postService.deleteBatch(del_ids);
		}else{
			//单个删除
			Integer id=Integer.parseInt(pid);
			postService.deleteone(id);
		}
		return Msg.success();
	}
	
	/**
	 * 3、后台根据贴子编号(pid)查找贴子,用于后台浏览
	 * 此为联表查询，同时查出发帖user数据
	 */
	//public Msg findPostByUid(int uid)
	@ResponseBody
	@RequestMapping(value = "findpostbypid",method = RequestMethod.GET)
	public Msg findPostBypid(@RequestParam("pid") Integer pid){
		Post post=postService.findPostByPid(pid);		
		return Msg.success().add("post", post);
	}

	/**
	 * 4、后台查找出所有贴子（升序：按最新）(分页)
	 */
	//public Msg findAllPost()
	@ResponseBody
	@RequestMapping(value = "findallpost",method = RequestMethod.GET)
	public Msg findAllPost(@RequestParam(value="pn",defaultValue="1") Integer pn,
						   @RequestParam("select_key") String select_key,
						   @RequestParam("select_value") String select_value){
		if(select_key.equals("最多点击")){
				PageHelper.startPage(pn, 5);
				List<Post> posts=postService.getAllByHot();
				PageInfo page=new PageInfo(posts,5);
				return Msg.success().add("pageInfo", page);
		}else if(select_key.equals("用户编号")){
				if(select_value==""){
					PageHelper.startPage(pn, 5);
					List<Post> posts=postService.getAll();
					PageInfo page=new PageInfo(posts,5);
					return Msg.success().add("pageInfo", page);
				}else{
					Integer uids=Integer.parseInt(select_value);
					PageHelper.startPage(pn, 5);
					List<Post> posts=postService.getPostByUid(uids);
					PageInfo page=new PageInfo(posts,5);
					return Msg.success().add("pageInfo", page);
				}
		}else if(select_key.equals("内容")){
			if(select_value==""){
				PageHelper.startPage(pn, 5);
				List<Post> posts=postService.getAll();
				PageInfo page=new PageInfo(posts,5);
				return Msg.success().add("pageInfo", page);
			}else{
				PageHelper.startPage(pn, 5);
				List<Post> posts=postService.getPostByPcontent(select_value);
				PageInfo page=new PageInfo(posts,5);
				return Msg.success().add("pageInfo", page);
			}
		}else{
			PageHelper.startPage(pn, 5);
			List<Post> posts=postService.getAll();
			PageInfo page=new PageInfo(posts,5);
			return Msg.success().add("pageInfo", page);
		}

	}
	
	/**
	 * 根据uid，查找出所有post数据
	 * @param pn
	 * @param uid
	 * @return
	 */
	@RequestMapping("/findpostByuid")
	@ResponseBody
	public Msg findpostByuid(@RequestParam(value="pn",defaultValue="1") Integer pn,@RequestParam("uid")Integer uid){
		PageHelper.startPage(pn, 5);
		List<Post> posts=postService.getPostByUid(uid);
		PageInfo page=new PageInfo(posts,5);
		return Msg.success().add("pageInfo", page);
	}

	/**
	 * 5、小程序根据贴子编号:pid查找一条数据(点击量：hits 数量加1)
	 */
	@RequestMapping("/addHits")
	@ResponseBody
	public Msg addHits(@RequestParam(value="pid")Integer pid){
		Post post=postService.findPostByPid(pid);
		int i=post.getHits()+1;
		post.setHits(i);
		postService.updatePost(post);
		return Msg.success().add("post", post);
	}
	
	/**
	 * 6、根据贴子编号:pid,点赞数：goodnum 数量加1
	 */
	@RequestMapping("/addGoodnum")
	@ResponseBody
	public Msg addGoodnum(@RequestParam(value="pid")Integer pid){
		Post post=postService.findPostByPid(pid);
		post.setGoodnum(post.getGoodnum()+1);
		postService.updatePost(post);
		System.out.println("success");
		return Msg.success().add("post", post);
	}
	
	/**
	 * 7、根据贴子编号:pid,点赞数：goodnum 数量减1
	 */
	@RequestMapping("/reduceGoodnum")
	@ResponseBody
	public Msg reduceGoodnum(@RequestParam(value="pid")Integer pid){
		Post post=postService.findPostByPid(pid);
		post.setGoodnum(post.getGoodnum()-1);
		postService.updatePost(post);
		return Msg.success().add("post", post);
	}
	
	/**
	 * 8、根据贴子编号:pid,坏赞数：badnum  数量加1
	 */
	@RequestMapping("/addbadnum")
	@ResponseBody
	public Msg addbadnum(@RequestParam(value="pid")Integer pid){
		Post post=postService.findPostByPid(pid);
		post.setBadnum(post.getBadnum()+1);
		postService.updatePost(post);
		System.out.println("success");
		return Msg.success().add("post", post);
	}
	
	/**
	 * 9、根据贴子编号:pid,坏赞数：badnum  数量减1
	 */
	@RequestMapping("/reducebadnum")
	@ResponseBody
	public Msg reducebadnum(@RequestParam(value="pid")Integer pid){
		Post post=postService.findPostByPid(pid);
		post.setBadnum(post.getBadnum()-1);
		postService.updatePost(post);
		return Msg.success().add("post", post);
	}
	
	/**
	 * 前台网页获取3条数据
	 * 按点击量高低
	 * @param pn
	 * @return
	 */
	@RequestMapping("/getpostbyhits")
	@ResponseBody
	public Msg getpost(@RequestParam(value="pn",defaultValue="1") Integer pn){
		PageHelper.startPage(pn, 3);
		List<Post> posts=postService.getAllByHot();
		PageInfo page=new PageInfo(posts,5);
		return Msg.success().add("pageInfo", page);
	}
	
	/**
	 * 网页版添加一条贴子
	 * 内容为文字+图片
	 * 场景为：用户编写文字，然后添加图片，然后上传文字和上传图片
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping("/useraddPost")
	public void useraddPost(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="title")String title,
			@RequestParam(value="uid")Integer uid,
			@RequestParam(value="pcontent")String pcontent,
			@RequestParam("file") MultipartFile file) throws Exception{
		Post post=new Post();
		
		//关键词屏蔽
		String patha = request.getServletContext().getRealPath("/image/");
		title=Keyword.keyword(title, patha);
		post.setTitle(title);
		
		post.setUid(uid);
		post.setHits(0);
		post.setGoodnum(0);
		post.setBadnum(0);
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		post.setPdate(dateString);
		
		//关键词屏蔽
		pcontent=Keyword.keyword(pcontent, patha);
		post.setPcontent(pcontent);
		
		post.setPfile(null);
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
	            post.setPfile(filename);
	        } 
		 postService.addpost(post);
		 System.out.println("post添加成功");
		 Post post2=postService.getAll().get(0);
		 request.getRequestDispatcher("/userview/seeonepost.jsp?pid="+post2.getPid()).forward(request, response);;
	}
}