package com.wechat.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wechat.bean.Comment;
import com.wechat.bean.CommentExample;
import com.wechat.bean.CommentExample.Criteria;
import com.wechat.bean.Greens;
import com.wechat.bean.Msg;
import com.wechat.bean.Post;
import com.wechat.service.CommentService;
import com.wechat.service.GreensService;
import com.wechat.service.PostService;
import com.wechat.util.Keyword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户评论控制类
 * @author liten
 *
 */
@Controller
public class CommentController {
	
	@Autowired
	private CommentService commentService;

	/**
	 * 1.添加一条评论
	 * 前台传入
	 * 	用户编号 uid;
		评论内容：comment;
		评论类型: ctype;(菜谱或帖子,greens,post)
		评论类型的编号：typeid;(gid或pid)
	 */
	//public Msg addComment()
	@ResponseBody
	@RequestMapping(value = "addcomment",method = RequestMethod.GET)
	public Msg addComment(HttpServletRequest request,
						  @RequestParam("uid") String uid,@RequestParam("ctype") String ctype,
						  @RequestParam("typeid") String typeid,@RequestParam("comment") String comment){
		Integer uids=Integer.parseInt(uid);
		Integer typeids=Integer.parseInt(typeid);
		Comment comment1=new Comment();
		comment1.setUid(uids);
		comment1.setCtype(ctype);
		comment1.setTypeid(typeids);
		//关键词屏蔽
		String path = request.getServletContext().getRealPath("/image/");
		comment=Keyword.keyword(comment, path);
		System.out.println(comment);
		comment1.setComment(comment);
		//评论时间
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		comment1.setCdate(dateString);
		commentService.insertComment(comment1);
		return Msg.success();
	}
	
	/**
	 * 网页用户添加菜品评论
	 * @param request
	 * @param response
	 * @param uid
	 * @param ctype
	 * @param typeid
	 * @param comment
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "useraddcomment",method = RequestMethod.GET)
	public void useraddComment(HttpServletRequest request,HttpServletResponse response,
						  @RequestParam("uid") String uid,@RequestParam("ctype") String ctype,
						  @RequestParam("typeid") String typeid,@RequestParam("editorValue") String comment) throws ServletException, IOException{
		Integer uids=Integer.parseInt(uid);
		Integer typeids=Integer.parseInt(typeid);
		Comment comment1=new Comment();
		comment1.setUid(uids);
		comment1.setCtype(ctype);
		comment1.setTypeid(typeids);
		//关键词屏蔽
		String path = request.getServletContext().getRealPath("/image/");
		comment=Keyword.keyword(comment, path);
		System.out.println(comment);
		comment1.setComment(comment);
		//评论时间
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		comment1.setCdate(dateString);
		commentService.insertComment(comment1);
		request.getRequestDispatcher("/userview/single.jsp?gid="+typeid).forward(request,response);
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
	public Msg findCommentByType(@RequestParam(value="pn",defaultValue="1") Integer pn,@RequestParam("ctype") String ctype){
		PageHelper.startPage(pn,5);
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
	public Msg findCommentByUid(@RequestParam(value="pn",defaultValue="1") Integer pn,@RequestParam("uid") String uid){
		Integer cuid=Integer.parseInt(uid);
		PageHelper.startPage(pn, 5);
		List<Comment> comments=commentService.findAllByUid(cuid);
		PageInfo page = new PageInfo(comments,5);
		return Msg.success().add("pageInfo", page);
	}
	
	/**
	 * 查找某一greens或post的评论及user数据（联表查询）
	 * 每次查10条一个分页
	 * @param ctype(greens或post)
	 * @param typeid (gid或pid)
	 * @return
	 */
	@RequestMapping("/findComment")
	@ResponseBody
	public Msg findComment(@RequestParam(value="pn",defaultValue="1") Integer pn,
			@RequestParam("ctype") String ctype,
			@RequestParam("typeid") Integer typeid){
		CommentExample commentExample=new CommentExample();
		commentExample.setOrderByClause("cid DESC");
		Criteria criteria=commentExample.createCriteria();
		criteria.andCtypeEqualTo(ctype);
		criteria.andTypeidEqualTo(typeid);
		PageHelper.startPage(pn, 10);
		List<Comment> list=commentService.findAllByTypeAndTypeid(commentExample);
		System.out.println(list);
		PageInfo page = new PageInfo(list,5);
		return Msg.success().add("pageInfo", page);
	}
	
}