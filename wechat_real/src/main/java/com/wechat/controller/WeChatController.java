package com.wechat.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.wechat.bean.Msg;
import com.wechat.service.UserService;
import com.wechat.util.HttpClientUtil;
import com.wechat.util.JsonUtils;
import com.wechat.util.Keyword;
import com.wechat.util.WXSessionModel;

/**
 * 用于处理用户登录获取openid
 * @author liten
 *
 */
@Controller
public class WeChatController {
	@Autowired
	private UserService userService;
	
	/**
	 * 用于获取用户openid
	 * @param code
	 * @param appid
	 * @param secret
	 * @return
	 */
	@RequestMapping(value = "/loginuser", produces = {"application/json;charset=UTF-8" })
    @ResponseBody
    public WXSessionModel wxLogin(@RequestParam(value="code") String code,
    		@RequestParam(value = "appid") String appid,
    		@RequestParam(value = "secret") String secret){
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        Map<String, String> param = new HashMap<>();
        param.put("appid", appid);
        param.put("secret", secret);
        param.put("js_code", code);
        param.put("grant_type", "authorization_code");

        String wxResult = HttpClientUtil.doGet(url, param);
        WXSessionModel model = JsonUtils.jsonToPojo(wxResult, WXSessionModel.class);
        System.out.println(wxResult);
        System.out.println(model);
        System.out.println(code);
        return model;
    }
	
	/**
	 * 检查是否授权
	 * @param code
	 * @param appid
	 * @param secret
	 * @return
	 */
	@RequestMapping(value = "/checkuser", produces = {"application/json;charset=UTF-8" })
    @ResponseBody
    public String wxcheck(@RequestParam(value="code") String code,
    		@RequestParam(value = "appid") String appid,
    		@RequestParam(value = "secret") String secret){
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        Map<String, String> param = new HashMap<>();
        param.put("appid", appid);
        param.put("secret", secret);
        param.put("js_code", code);
        param.put("grant_type", "authorization_code");
        String wxResult = HttpClientUtil.doGet(url, param);
        WXSessionModel model = JsonUtils.jsonToPojo(wxResult, WXSessionModel.class);
        System.out.println(wxResult);
        System.out.println(model);
        System.out.println(code);
        System.out.println(model.getOpenid());
        boolean result=userService.checkopenid(model.getOpenid());
        if(!result)
        	return "true";
        else
        	return "false";
    }
	
	
	/**
	 * 添加需屏蔽的关键词
	 * @param request
	 * @param word
	 * @return
	 */
	@RequestMapping("/addkeyword")
    @ResponseBody
	public Msg keyword(HttpServletRequest request,
			@RequestParam(value="word") String word){
		//添加关键词
		String path = request.getServletContext().getRealPath("/image/");
		System.out.println(path+" "+word);
		try {
			Keyword keyword=new Keyword();
			keyword.addKeyword(word, path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Msg.success();
	}
	
	/**
	 * 查看所有需屏蔽的关键词
	 * @param request
	 * @return
	 */
	@RequestMapping("/seekeyword")
    @ResponseBody
	public Msg seekeyword(HttpServletRequest request){
		String path = request.getServletContext().getRealPath("/image/");
		String string=Keyword.allkeyword(path);
		return Msg.success().add("keyword",string);
	}
}
