package com.wechat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wechat.dao.StepMapper;

@Service
public class StepService {
	
	@Autowired
	private StepMapper stepMapper;
}
