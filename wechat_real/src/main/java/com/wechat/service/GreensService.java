package com.wechat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wechat.bean.Greens;
import com.wechat.dao.GreensMapper;

@Service
public class GreensService {
	
	@Autowired
	private GreensMapper greensMapper;

	public void addGreens(Greens greens) {
		greensMapper.insert(greens);
	}

	public List<Greens> findAll() {
		
		return greensMapper.selectByExample(null);
	}
}
