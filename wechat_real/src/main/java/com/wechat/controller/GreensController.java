package com.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.wechat.service.GreensService;

@Controller
public class GreensController {
	
	@Autowired
	private GreensService greensService;
}
