package com.wechat.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicInterface2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wechat.bean.Greens;
import com.wechat.bean.Msg;
import com.wechat.service.GreensService;

@Controller
public class GreensController {
	
	@Autowired
	private GreensService greensService;
	
	/**
	 * 添加greens对象，并跳去添加步骤的页面 addstep.jsp
	 * @param gname
	 * @param gstyle
	 * @param glabel
	 * @param editorValue
	 * @return
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping("/addGreens_next")
	@ResponseBody
	public void addGreens_next(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="gname")String gname,
			@RequestParam(value="gstyle")String gstyle,
			@RequestParam(value="glabel")String glabel,
			@RequestParam(value="editorValue")String editorValue) throws ServletException, IOException{
		Greens greens=new Greens();
		greens.setGname(gname);
		greens.setGstyle(gstyle);
		greens.setGlabel(glabel);
		greens.setGwriter("system");
		greens.setGneed(editorValue);
		greens.setGhits(0);
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		System.out.println(dateString);
		greens.setGdate(dateString);
		greensService.addGreens(greens);
		List<Greens> one=greensService.findAll();
		request.setAttribute("gid", one.get(one.size()-1).getGid());
		request.setAttribute("step",1);
		System.out.println(one.get(one.size()-1).getGid());
		request.getRequestDispatcher("/view/addstep.jsp").forward(request,response);
	}
	
	/**
	 * 只添加greens对象
	 * @param gname
	 * @param gstyle
	 * @param glabel
	 * @param editorValue
	 * @return
	 */
	@RequestMapping("/addGreens_last")
	@ResponseBody
	public Msg addGreens_last(@RequestParam(value="gname")String gname,
			@RequestParam(value="gstyle")String gstyle,
			@RequestParam(value="glabel")String glabel,
			@RequestParam(value="editorValue")String editorValue){
		Greens greens=new Greens();
		greens.setGname(gname);
		greens.setGstyle(gstyle);
		greens.setGlabel(glabel);
		greens.setGwriter("system");
		greens.setGneed(editorValue);
		greens.setGhits(0);
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		System.out.println(dateString);
		greens.setGdate(dateString);
		greensService.addGreens(greens);
		System.out.println(greens);
		return Msg.success();
	}
}
