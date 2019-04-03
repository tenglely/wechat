package com.wechat.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wechat.bean.Msg;
import com.wechat.bean.Post;
import com.wechat.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
	
	@Autowired
	private PostService postService;
	
	/**
	 * 1.添加一条贴子
	 * 内容为文字+图片
	 * 场景为：用户编写文字，然后添加图片，然后上传文字和上传图片
	 * 内容:pcontent：文字+<img src=上传的图片地址 />
	 * 邓权，这个方法先不写，写下面的
	 */
	//public Msg addPost()
	
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
	 * 3、根据用户编号(uid)查找所有贴子
	 */
	//public Msg findPostByUid(int uid)
	@ResponseBody
	@RequestMapping(value = "findpostbyuid",method = RequestMethod.GET)
	public Msg findPostByuid(@RequestParam("uid") String uid){
		Integer uids=Integer.parseInt(uid);
		PageHelper.startPage(1, 5);
		List<Post> posts=postService.getPostByUid(uids);
		PageInfo page = new PageInfo(posts,5);
		return Msg.success().add("pageInfo", page);
	}

	/**
	 * 4、查找出所有贴子（升序：按最新）(分页)
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
	 * 5、根据贴子编号:pid,点击量：hits 数量加1
	 */
	//public Msg addHits()
	
	/**
	 * 6、根据贴子编号:pid,点赞数：goodnum 数量加1
	 */
	//public Msg addGoodnum()
	
	/**
	 * 7、根据贴子编号:pid,点赞数：goodnum 数量减1
	 */
	//public Msg reduceGoodnum()
	
	/**
	 * 8、根据贴子编号:pid,坏赞数：badnum  数量加1
	 */
	//public Msg addGoodnum()
	
	/**
	 * 9、根据贴子编号:pid,坏赞数：badnum  数量减1
	 */
	//public Msg reduceGoodnum()
}
