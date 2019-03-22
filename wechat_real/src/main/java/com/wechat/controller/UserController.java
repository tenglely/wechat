package com.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wechat.bean.Msg;
import com.wechat.bean.User;
import com.wechat.service.UserService;

/**
 * 用户控制类
 * @author liten
 *
 */
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 1.前台传过来
	 *  用户名 uname;
		用户唯一标识 openid (String)
		用户头像 purl;
		用户性别 gender; （0,1,2）
		上面这4个值靠前台拿；
		用户编号 uid;这个是自动递增的，不用理
		用户类型 uclass;(默认为用户)
		用户状态 state;(默认为yes)
		注意：拿过来先进行判断，判断数据库是否有这个用户（根据openid），
		没有就添加，
		有就取出这个对象,并update这个对象（修改uname和purl),再取出这对象,并放到session(session就叫user)
	 */
	//public Msg addUser()
	
	/**
	 * 2、根据session,拿出user对象到前台
	 * 	    场景使用：用户点击“我的”或进行评论，调用此方法直接拿到用户信息
	 */
	//public Msg getUserMessage()
	
	/**
	 * 3、后台根据uid直接删除一条数据
	 */
	//public Msg deleteUser()
	
	/**
	 * 4、后台查询所有用户信息
	 * 分页 5个一页
	 */
	//public Msg findAllUser()
	
	/**
	 * 5、根据用户(uid)查询一条用户信息
	 */
	//public Msg findUserByUid
	
	/**
	 * 6、根据用户名查询一条用户信息
	 */
	//public Msg findUserByUname
	
	/**
	 * 7、根据用户状态查询所有用户
	 *    分页 5个一页
	 */
	//public Msg findUserByState
	
	/**
	 * 8.根据用户性别(usex)
	 *   查询所有用户(分页)
	 */
	//public Msg findUserByUsex
}
