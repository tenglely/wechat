package com.wechat.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wechat.bean.Msg;
import com.wechat.bean.User;
import com.wechat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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
	@ResponseBody
	@RequestMapping(value ="/user" ,method = RequestMethod.PUT)
	public Msg addUser(@RequestParam("uname") String uname,@RequestParam("purl") String purl,
					   @RequestParam("openid") String openid,HttpSession httpSession){
		System.out.println(openid);
		System.out.println(uname);
		System.out.println(purl);
		int gender=123;
		String uclass="用户";
		String state="yes";
		User user=new User();
		//查询用户表中是否已经存在openid
		boolean result=userService.checkopenid(openid);
		if(result){
			System.out.println("用户不存在，可以进行添加");
			user.setUname(uname);
			user.setOpenid(openid);
			user.setGender(gender);
			user.setPurl(purl);
			user.setUclass(uclass);
			user.setState(state);
			//把用户加入到用户表中
			userService.addUser(user);
			System.out.println("添加成功");
			List<User> users=userService.getUser(openid);
			User user1 = users.get(0);
			//将对象放入session中
			httpSession.setAttribute("user", user1);
			return Msg.success();
		}else{
			List<User> users=userService.getUser(openid);
			User user2 = users.get(0);
			user2.setUname(uname);
			user2.setOpenid(openid);
			user2.setGender(gender);
			user2.setPurl(purl);
			user2.setUclass(uclass);
			user2.setState(state);
			userService.update(user2);
			System.out.println("更新成功");
			//将对象放入session中
			httpSession.setAttribute("user", user2);
			return Msg.success();
		}
	}
	/**
	 * 2、根据session,拿出user对象到前台
	 * 	    场景使用：用户点击“我的”或进行评论，调用此方法直接拿到用户信息
	 */
	//public Msg getUserMessage()

	/**
	 * 3、后台查询所有用户信息
	 * 分页 5个一页
	 */
	//public Msg findAllUser()
	@ResponseBody
	@RequestMapping(value = "/check",method = RequestMethod.GET)
	public Msg findAllUser(@RequestParam(value="pn",defaultValue="1") Integer pn){
		//引入pageHelper插件
		PageHelper.startPage(pn, 5);
		//startPage后紧跟的查询就是分页查询
		List<User> users = userService.getAll();
		//使用PageInfo包装查询后的结果
		//PageInfo封装了详细的分页信息包括查询出的数据，只需将pageInfo交给页面即可
		//参数5表示连续显示5页
		PageInfo page = new PageInfo(users,5);
		//JSONObject jsonObject = new JSONObject(page);
		return Msg.success().add("pageInfo", page);
	}
	/**
	 * 4、根据用户(uid)查询一条用户信息
	 */
	//public Msg findUserByUid
	@ResponseBody
	@RequestMapping(value = "/emp/{id}",method = RequestMethod.GET)
	public  Msg findUserByUid(@PathVariable("id") Integer id){
		User user=userService.getUserByUid(id);
		return Msg.success().add("emp",user);
	}
	/**
	 * 5、根据uid保存一条用户信息
	 */
	@ResponseBody
	@RequestMapping(value = "/emp/{uid}",method = RequestMethod.PUT)
	public Msg saveUserByUid(User user){
		System.out.println("将要更新的员工是"+user);
		userService.updatUser(user);
		return Msg.success();
	}



	/**
	 * 6、单个批量二合一
	 * 批量删除：1-2-3
	 * 单个删除：1
	 */
	//public Msg deleteUser()
	@ResponseBody
	@RequestMapping(value = "/emp/{ids}",method = RequestMethod.DELETE)
	public Msg deleteUser(@PathVariable("ids") String ids){
		//字符串中有"-"是批量删除，没有是根据id单个删除
		if(ids.contains("-")){
			List<Integer> del_ids=new ArrayList<>();
			//批量删除
			String[] str_ids=ids.split("-");
			//组装ids的集合
			for(String string :str_ids){
				del_ids.add(Integer.parseInt(string));
			}
			userService.deleteBatch(del_ids);
		}else{
			//单个删除
			Integer id=Integer.parseInt(ids);
			userService.deleteEmp(id);

		}
		return Msg.success();
	}

	/**
	 * 7、根据用户名查询一条用户信息
	 */
	//public Msg findUserByUname
	@ResponseBody
	@RequestMapping(value = "sel_uname",method = RequestMethod.GET)
	public Msg findUserByUname(@RequestParam("uname") String uname){
		List<User> list=userService.findByUname(uname);
		PageHelper.startPage(1, 5);
		PageInfo page = new PageInfo(list,5);
		return Msg.success().add("pageInfo", page);
	}
	
	/**
	 * 8、根据用户状态查询所有用户
	 *    分页 5个一页
	 */
	//public Msg findUserByState
	@ResponseBody
	@RequestMapping(value = "sel_state",method = RequestMethod.GET)
	public Msg findUserByState(@RequestParam("state") String state){
		List<User> list=userService.findByState(state);
		PageHelper.startPage(1, 5);
		PageInfo page = new PageInfo(list,5);
		return Msg.success().add("pageInfo", page);
	}
	/**
	 * 9.根据用户性别(usex)
	 *   查询所有用户(分页)
	 */
	//public Msg findUserByGender
	@ResponseBody
	@RequestMapping(value = "sel_gender",method = RequestMethod.GET)
	public Msg findUserByGender(@RequestParam("gender") String gender){
		Integer genders;
		if(gender.equals("女")){
			genders=1;
		}else{
			genders=0;
		}
		System.out.println("性别为："+genders);
		List<User> list=userService.findByGender(genders);
		System.out.println(list.size());
		PageHelper.startPage(1, 5);
		PageInfo page = new PageInfo(list,5);
		return Msg.success().add("pageInfo", page);
	}
	/**
	 * 10.根据用户openid
	 *   查询所有用户(分页)
	 */
	//public Msg findUserByOpenid()
	@ResponseBody
	@RequestMapping(value = "sel_openid",method = RequestMethod.GET)
	public Msg findUserByOpenid(@RequestParam("openid") String openid){
		List<User> list=userService.findByOpenid(openid);
		PageHelper.startPage(1, 5);
		PageInfo page = new PageInfo(list,5);
		return Msg.success().add("pageInfo", page);
	}

}
