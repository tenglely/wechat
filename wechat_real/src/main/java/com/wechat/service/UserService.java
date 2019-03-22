package com.wechat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wechat.bean.User;
import com.wechat.dao.UserMapper;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;

	public void addUser(User user) {
		// TODO Auto-generated method stub
		userMapper.insert(user);
	}
}
