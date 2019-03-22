package com.wechat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wechat.dao.GreensMapper;

@Service
public class GreensService {
	
	@Autowired
	private GreensMapper greensMapper;
}
