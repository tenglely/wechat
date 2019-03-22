package com.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.wechat.bean.Msg;
import com.wechat.service.CommentService;

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
		评论时间 cdate;(String)
	 */
	//public Msg addComment()
	
	/**
	 * 2.根据评论编号(cid)删除一条评论
	 */
	//public Msg deleteCommentByCid(int cid)
	
	/**
	 * 3.根据评论类型: ctype,评论类型的编号(typeid)查找出所有评论（分页）
	 */
	//public Msg findCommentByTypeid()
	
	/**
	 * 4.后台根据用户编号(uid)查找出所有评论（10个一分页）
	 */
	//public Msg findCommentByUid()
}
