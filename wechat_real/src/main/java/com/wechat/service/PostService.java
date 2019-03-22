package com.wechat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wechat.dao.PostMapper;

@Service
public class PostService {
	
	@Autowired
	private PostMapper postMapper;
}
