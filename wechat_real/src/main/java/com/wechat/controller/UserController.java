package com.wechat.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wechat.bean.Msg;
import com.wechat.bean.User;
import com.wechat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
	@RequestMapping(value ="/adduser")
	public Msg addUser(@RequestParam("uname") String uname,@RequestParam("purl") String purl,
					   @RequestParam("openid") String openid,@RequestParam("gender") Integer gender,HttpSession httpSession){
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
	@ResponseBody
	@RequestMapping(value ="/getuser")
	public Msg getUserMessage(HttpSession httpSession){
		User user=(User) httpSession.getAttribute("user");
		return Msg.success().add("user", user);
	}

	/**
	 * 3、后台查询所有用户信息
	 * 传入一个页数pn，从该页开始查询
	 * 分页 5个一页
	 */
	//public Msg findAllUser()
	@ResponseBody
	@RequestMapping(value = "/findalluser",method = RequestMethod.GET)
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
	 * 前台传过来一个uid
	 */
	//public Msg findUserByUid
	@ResponseBody
	@RequestMapping(value = "/finduserbyuid",method = RequestMethod.GET)
	public  Msg findUserByUid(@RequestParam(value="uid") Integer uid){
		User user=userService.getUserByUid(uid);
		return Msg.success().add("user",user);
	}
	
	/**
	 * 5、根据uid保存一条用户信息
	 */
	@ResponseBody
	@RequestMapping(value = "/saveuserbyuid/{uid}",method = RequestMethod.PUT)
	public Msg saveUserByUid(User user){
		System.out.println("将要更新的员工是"+user);
		userService.update(user);
		return Msg.success();
	}



	/**
	 * 6、单个批量二合一
	 * 传过来的String若是带有"-"是批量删除，没有则是单个删除
	 * 比如：批量删除：1-2-3
	 * 比如：单个删除：1
	 */
	//public Msg deleteUser()
	@ResponseBody
	@RequestMapping(value = "/deleteuser/{ids}",method = RequestMethod.DELETE)
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
	 * 7、根据用户名uname查询一条用户信息
	 */
	//public Msg findUserByUname
	@ResponseBody
	@RequestMapping(value = "finduserbyuname",method = RequestMethod.GET)
	public Msg findUserByUname(@RequestParam(value="pn",defaultValue="1") Integer pn,@RequestParam("uname") String uname){
		PageHelper.startPage(pn, 5);
		List<User> list=userService.findByUname(uname);
		PageInfo page = new PageInfo(list,5);
		return Msg.success().add("pageInfo", page);
	}
	
	/**
	 * 8、根据用户状态state查询所有用户
	 *    分页 5个一页
	 */
	//public Msg findUserByState
	@ResponseBody
	@RequestMapping(value = "finduserbystate",method = RequestMethod.GET)
	public Msg findUserByState(@RequestParam(value="pn",defaultValue="1") Integer pn,@RequestParam("state") String state){
		PageHelper.startPage(pn, 5);
		List<User> list=userService.findByState(state);
		PageInfo page = new PageInfo(list,5);
		return Msg.success().add("pageInfo", page);
	}
	/**
	 * 9.根据用户性别(gender)查询所有用户
	 *   查询所有用户(分页)
	 */
	//public Msg findUserByGender
	@ResponseBody
	@RequestMapping(value = "finduserbygender",method = RequestMethod.GET)
	public Msg findUserByGender(@RequestParam(value="pn",defaultValue="1") Integer pn,@RequestParam("gender") String gender){
		Integer genders;
		if(gender.equals("女")){
			genders=1;
		}else{
			genders=0;
		}
		PageHelper.startPage(pn, 5);
		List<User> list=userService.findByGender(genders);
		PageInfo page = new PageInfo(list,5);
		return Msg.success().add("pageInfo", page);
	}
	/**
	 * 10.根据用户openid查询所有用户
	 *   查询所有用户(分页)
	 */
	//public Msg findUserByOpenid()
	@ResponseBody
	@RequestMapping(value = "finduserbyopenid",method = RequestMethod.GET)
	public Msg findUserByOpenid(@RequestParam("openid") String openid){
		List<User> list=userService.findByOpenid(openid);
		PageHelper.startPage(1, 5);
		PageInfo page = new PageInfo(list,5);
		return Msg.success().add("pageInfo", page);
	}
  
	/**
	 * /管理员登录
	 * @param request
	 * @param response
	 * @param uname
	 * @param openid
	 * @throws ServletException
	 * @throws IOException
	 */
  @RequestMapping(value="userlogin")
  public void userlogin(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("uname") String uname,
			@RequestParam("openid") String openid) throws ServletException, IOException{
	  User user=userService.loging(uname,openid);
	  if(user!=null){
		  HttpSession session=request.getSession();
		  session.setAttribute("login", user);
		  request.getRequestDispatcher("/index.jsp").forward(request, response);
	  }else{
		  HttpSession session=request.getSession();
		  session.setAttribute("date", "登录失败，请重新登录");
		  request.getRequestDispatcher("/view/login.jsp").forward(request, response);
	  }
  }
  
  /**
   * 用户登录
   * @param request
   * @param response
   * @param uname
   * @param openid
   * @throws ServletException
   * @throws IOException
   */
  @RequestMapping(value="peoplelogin")
  public void peoplelogin(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("uname") String uname,
			@RequestParam("openid") String openid) throws ServletException, IOException{
	  User user=userService.loging(uname,openid);
	  if(user!=null){
		  HttpSession session=request.getSession();
		  session.setAttribute("user", user);
		  request.getRequestDispatcher("/userview/myset.jsp").forward(request, response);
	  }else{
		  HttpSession session=request.getSession();
		  session.setAttribute("state", "登录失败，请重新登录");
		  request.getRequestDispatcher("/userview/myset.jsp").forward(request, response);
	  }
  }
  
  /**
   * 查找所有管理员数据
   * @return
   */
  @ResponseBody
  @RequestMapping(value="userAdmin",method=RequestMethod.GET)
  public Msg userAdmin(){
	  List<User> list=userService.findAllAdmin();
	  return Msg.success().add("list", list);
  }
  
  /**
   * 修改管理员个人设置
   * @param request
   * @param response
   * @param uid
   * @param file
   * @param uname
   * @param openid
   * @throws Exception
   */
  @RequestMapping(value="updateAdmin")
  public void updateAdmin(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="uid")Integer uid,
			@RequestParam("file") MultipartFile file,
			@RequestParam(value="uname")String uname,
			@RequestParam(value="openid")String openid
			)throws Exception{
	  User user=userService.getUserByUid(uid);
	  user.setOpenid(openid);
	  user.setUname(uname);
	  if(!file.isEmpty()) {
          //上传文件路径:Tomcat虚拟路径
          String path = request.getServletContext().getRealPath("/image/");
          //上传文件名
          String uuid=UUID.randomUUID().toString().substring(0, 5);
          String filename =uuid+file.getOriginalFilename();
          File filepath = new File(path,filename);
          //判断路径是否存在，如果不存在就创建一个
          if (!filepath.getParentFile().exists()) { 
              filepath.getParentFile().mkdirs();
          }
          //将上传文件保存到一个目标文件当中
          file.transferTo(new File(path + File.separator + filename));
          System.out.println(path+"   "+filename);
          //删除原图片
          String before_photo=user.getPurl();
          if(!before_photo.equals("manager.jpg")){
          File file1=new File(path+before_photo);
          boolean a=file1.delete();
          }
          user.setPurl(filename);
      }
	  userService.updatUser(user);
	  HttpSession session=request.getSession();
	  session.setAttribute("login", user);
	  request.getRequestDispatcher("/view/admin.jsp").forward(request, response);
  }
  
  /**
   * 超级管理员添加管理员
   * @param uname
   * @param openid
   * @return
   */
  @RequestMapping("/addAdmin")
  @ResponseBody
  public Msg addAdmin(@RequestParam(value="uname")String uname,
			@RequestParam(value="openid")String openid){
	  User user=new User();
	  user.setOpenid(openid);
	  user.setUname(uname);
	  user.setPurl("manager.jpg");
	  user.setGender(1);
	  user.setState("yes");
	  user.setUclass("管理员");
	  userService.addUser(user);
	  return Msg.success();
  }
  
  /**
   * 修改用户个人设置
   * @param request
   * @param response
   * @param uid
   * @param file
   * @param uname
   * @param openid
   * @throws Exception
   */
  @RequestMapping(value="updateuser")
  public void updateuser(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="uid")Integer uid,
			@RequestParam("file") MultipartFile file,
			@RequestParam(value="uname")String uname,
			@RequestParam(value="openid")String openid
			)throws Exception{
	  User user=userService.getUserByUid(uid);
	  user.setOpenid(openid);
	  user.setUname(uname);
	  if(!file.isEmpty()) {
          //上传文件路径:Tomcat虚拟路径
          String path = request.getServletContext().getRealPath("/image/");
          //上传文件名
          String uuid=UUID.randomUUID().toString().substring(0, 5);
          String filename =uuid+file.getOriginalFilename();
          File filepath = new File(path,filename);
          //判断路径是否存在，如果不存在就创建一个
          if (!filepath.getParentFile().exists()) { 
              filepath.getParentFile().mkdirs();
          }
          //将上传文件保存到一个目标文件当中
          file.transferTo(new File(path + File.separator + filename));
          System.out.println(path+"   "+filename);
          //删除原图片
          String before_photo=user.getPurl();
          if(!before_photo.equals("manager.jpg")&&!before_photo.equals("user01.jpg")&&!before_photo.equals("user02.jpg")){
          File file1=new File(path+before_photo);
          boolean a=file1.delete();
          }
          user.setPurl(filename);
      }
	  userService.updatUser(user);
	  HttpSession session=request.getSession();
	  session.setAttribute("user", user);
	  request.getRequestDispatcher("/userview/myset.jsp").forward(request, response);
  }
  
}