package com.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.wechat.service.AttentionService;

/**
 * 用户关注的控制类
 * @author liten
 *
 */
@Controller
public class AttentionController {
	
	@Autowired
	private AttentionService attentionService;
	
	/**
	 * 1.添加一个用户关注
	 * 前台传入 
	 * 用户编号 uid;
	      被关注用户编号 nid;(被关注用户的uid) 
	 */
	//public Msg addAttention()
	
	/**
	 * 2.根据用户关注编号(aid)取消一个用户关注
	 */
	//public Msg deleteAttentionByAid()
	
	/**
	 * 3.根据用户编号(uid)查找所有被关注用户
	 */
	//public Msg findAttentionByUid()
}
