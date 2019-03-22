package com.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.wechat.service.StepService;

@Controller
public class StepController {
	
	@Autowired
	private StepService stepService;
}
