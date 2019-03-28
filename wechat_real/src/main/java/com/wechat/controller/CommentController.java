package com.wechat.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wechat.bean.Comment;
import com.wechat.bean.Greens;
import com.wechat.bean.Msg;
import com.wechat.bean.Post;
import com.wechat.service.CommentService;
import com.wechat.service.GreensService;
import com.wechat.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户评论控制类
 * @author liten
 *
 */
@Controller
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	@Autowired
	private GreensService greensService;
	@Autowired
	private PostService postService;
	/**
	 * 1.添加一条评论
	 * 前台传入
	 * 	用户编号 uid;
		评论内容：comment;
		评论类型: ctype;(菜谱或帖子,greens,post)
		评论类型的编号：typeid;(gid或pid)
		评论时间 cdate;(String)
	 */
	//public Msg addComment()
	@ResponseBody
	@RequestMapping(value = "addcomment",method = RequestMethod.GET)
	public Msg addComment(@RequestParam("uid") String uid,@RequestParam("ctype") String ctype,
						  @RequestParam("typeid") String typeid,@RequestParam("comment") String comment,
						  @RequestParam("cdate") String cdate){
		Integer uids=Integer.parseInt(uid);
		Integer typeids=Integer.parseInt(typeid);
		Comment comment1=new Comment();
		comment1.setUid(uids);
		comment1.setCtype(ctype);
		comment1.setTypeid(typeids);
		comment1.setComment(comment);
		comment1.setCdate(cdate);
		commentService.insertComment(comment1);
		return Msg.success();

	}

	/**
	 * 2.查出所有评论记录
	 */
	//public Msg findAllComment(int pn)
	@ResponseBody
	@RequestMapping(value = "findallcomment",method = RequestMethod.GET)
	public Msg findAllComment(@RequestParam(value="pn",defaultValue="1") Integer pn){
		PageHelper.startPage(pn, 5);
		List<Comment> comments=commentService.findAll();
		PageInfo page = new PageInfo(comments,5);
		return Msg.success().add("pageInfo", page);
	}

	/**
	 * 2.根据评论编号(cid)删除一条评论
	 */
	//public Msg deleteCommentByCid(int cid)
	@ResponseBody
	@RequestMapping(value = "deletecommentbycid/{cids}",method =RequestMethod.DELETE)
	public Msg deleteCommentByCid(@PathVariable("cids") String cid){
		//字符串中有"-"是批量删除，没有是根据id单个删除
		if(cid.contains("-")){
			System.out.println("1111");
			List<Integer> del_ids=new ArrayList<>();
			//批量删除
			String[] str_ids=cid.split("-");
			//组装ids的集合
			for(String string :str_ids){
				del_ids.add(Integer.parseInt(string));
			}
			commentService.deleteBatch(del_ids);
		}else{
			//单个删除
			Integer id=Integer.parseInt(cid);
			commentService.delectByCid(id);
		}
		return Msg.success();
	}

	/**
	 * 3.根据评论类型: ctype,评论类型查找出所有评论（分页）
	 */
	//public Msg findCommentByType()
	@ResponseBody
	@RequestMapping(value = "findcommentbytype",method = RequestMethod.GET)
	public Msg findCommentByType(@RequestParam("ctype") String ctype){
		PageHelper.startPage(1, 5);
		List<Comment> comments=commentService.findAllByCtype(ctype);
		PageInfo page = new PageInfo(comments,5);
		return Msg.success().add("pageInfo", page);
	}
	
	/**
	 * 4.后台根据用户编号(uid)查找出所有评论（10个一分页）
	 */
	//public Msg findCommentByUid()
	@ResponseBody
	@RequestMapping(value = "findcommentbyuid",method = RequestMethod.GET)
	public Msg findCommentByUid(@RequestParam("uid") String uid){
		Integer cuid=Integer.parseInt(uid);
		PageHelper.startPage(1, 5);
		List<Comment> comments=commentService.findAllByUid(cuid);
		PageInfo page = new PageInfo(comments,5);
		return Msg.success().add("pageInfo", page);
	}
	/**
	 * 测试
	 * */
	@ResponseBody
	@RequestMapping(value = "select_greens",method = RequestMethod.GET)
	public Msg findGid(){
		List<Greens> greens=greensService.findAll();
		return Msg.success().add("green",greens);
	}
	@ResponseBody
	@RequestMapping(value = "select_post",method = RequestMethod.GET)
	public Msg findPid(){
		List<Post> posts=postService.findAll();
		return Msg.success().add("post",posts);
	}
}
