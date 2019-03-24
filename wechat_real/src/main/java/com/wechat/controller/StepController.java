package com.wechat.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wechat.bean.Msg;
import com.wechat.bean.Step;
import com.wechat.service.StepService;

@Controller
public class StepController {
	
	@Autowired
	private StepService stepService;
	
	/**
	 * 添加做菜步骤
	 * @param request
	 * @param file
	 * @param describe
	 * @param gid
	 * @param timing
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/addStep",method=RequestMethod.POST)
	@ResponseBody
	public void addStep(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("file") MultipartFile file,
			@RequestParam("describe") String describe,
			@RequestParam("step") int step,
			@RequestParam("gid") int gid,
			@RequestParam("timing") int timing) throws Exception{
		String sphoto=null;
		//如果文件不为空，写入上传路径
		 if(!file.isEmpty()) {
	            //上传文件路径:Tomcat虚拟路径
	            String path = request.getServletContext().getRealPath("/image/");
	            //上传文件名
	            String filename = file.getOriginalFilename();
	            File filepath = new File(path,filename);
	            //判断路径是否存在，如果不存在就创建一个
	            if (!filepath.getParentFile().exists()) { 
	                filepath.getParentFile().mkdirs();
	            }
	            //将上传文件保存到一个目标文件当中
	            file.transferTo(new File(path + File.separator + filename));
	            System.out.println(path+"   "+filename);
	            sphoto=filename;
	        } 
		 Step step2=new Step();
		 step2.setGid(gid);
		 step2.setStep(step);
		 step2.setTiming(timing);
		 step2.setSdescribe(describe);;
		 step2.setSphoto(sphoto);
		 step2.setVoice("空");
		 stepService.addStep(step2);
		 request.setAttribute("gid", gid);
		 request.setAttribute("step", step+1);
		 request.getRequestDispatcher("/view/addstep.jsp").forward(request,response);
	}
}
