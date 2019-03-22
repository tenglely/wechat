package com.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.wechat.service.PostService;

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
	
	/**
	 * 3、根据用户编号(uid)查找所有贴子
	 */
	//public Msg findPostByUid(int uid)
	
	/**
	 * 4、查找出所有贴子（升序：按最新）(分页)
	 */
	//public Msg findAllPost()
	
	/**
	 * 10、按点击量的从高往低查找出所有贴子（分页）
	 */
	//public Msg findPostByHot()
	
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
