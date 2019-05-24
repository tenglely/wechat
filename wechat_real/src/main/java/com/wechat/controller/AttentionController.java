package com.wechat.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wechat.bean.Attention;
import com.wechat.bean.Msg;
import com.wechat.bean.User;
import com.wechat.service.AttentionService;
import com.wechat.service.UserService;

/**
 * 用户关注的控制类
 * @author liten
 *
 */
@Controller
public class AttentionController {
	
	@Autowired
	private AttentionService attentionService;
	@Autowired
	private UserService userService;
	
	/**
	 * 1.添加一个用户关注
	 * 前台传入 
	 * 用户编号 uid;
	 * 类型 type,(greens,post,user)
	      被关注用户编号 nid;(被关注的id) 
	 */
	@ResponseBody
	@RequestMapping(value ="/addattention")
	public Msg addAttention(@RequestParam("uid") Integer uid,
			@RequestParam("type") String type,@RequestParam("nid") Integer nid){
		Attention a2=attentionService.findone(uid,nid,type);
		if(a2!=null){
			return Msg.fail().add("state", 0);
		}else{
		Attention attention=new Attention();
		attention.setType(type);
		attention.setUid(uid);
		attention.setNid(nid);
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		attention.setAdate(dateString);
		attentionService.addAttention(attention);
		return Msg.success().add("state", 1);
		}
	}
	
	/**
	 * 2.取消一个关注
	 */
	@ResponseBody
	@RequestMapping(value ="/deleteAttention")
	public Msg deleteAttentionByAid(@RequestParam("uid") Integer uid,
			@RequestParam("nid") Integer nid,@RequestParam("type") String type){
		Attention attention=attentionService.findone(uid,nid,type);
		System.out.println(attention);
		attentionService.deleteone(attention.getAid());
		return Msg.success();
	}
	
	/**
	 * 3.根据用户编号(uid)和类型查找所有被关注用户
	 */
	@ResponseBody
	@RequestMapping(value ="/findAllattention")
	public Msg findAllattention(@RequestParam("uid") Integer uid,
			@RequestParam("type") String type){
		List<Attention> list=attentionService.findall(uid,type);
		List<User> list2=new ArrayList<>();
		for(Attention attention:list){
			User user=userService.getUserByUid(attention.getNid());
			list2.add(user);
		}
		return Msg.success().add("list", list2);
	}
	
	
	/**
	 * 查询是否关注存在
	 * @param uid
	 * @param type
	 * @param nid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/panattention")
	public Msg panAttention(@RequestParam("uid") Integer uid,
			@RequestParam("type") String type,@RequestParam("nid") Integer nid){
		Attention a2=attentionService.findone(uid,nid,type);
		if(a2!=null){
			return Msg.fail().add("state", 0);
		}else{
			return Msg.success().add("state", 1);
		}
	}
}
