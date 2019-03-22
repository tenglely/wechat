package com.wechat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wechat.dao.AttentionMapper;

@Service
public class AttentionService {
	
	@Autowired
	private AttentionMapper attentionMapper;
}
