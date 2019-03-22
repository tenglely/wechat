package com.wechat.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wechat.bean.User;
import com.wechat.dao.CommentMapper;
import com.wechat.dao.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:applicationContext.xml")
public class MapperTest {
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	CommentMapper commentMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	@Test
	public void testCRUD(){
		System.out.println(userMapper);
		userMapper.insert(new User(null, "test","ssf","sffs",1,"sfs","fsfsf"));
	}
}