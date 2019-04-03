package com.wechat.service;

import com.wechat.bean.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wechat.bean.UserExample.Criteria;
import com.wechat.bean.User;
import com.wechat.dao.UserMapper;

import java.util.List;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;

	public void addUser(User user) {
		// TODO Auto-generated method stub
		userMapper.insertSelective(user);
	}

	//查询表中是否存在openid
    public boolean checkopenid(String openid) {
		UserExample userExample=new UserExample();
		Criteria criteria=userExample.createCriteria();
		criteria.andOpenidEqualTo(openid);
		long count=userMapper.countByExample(userExample);
		return count==0;
    }

    //根据openid取对象
	public List<User> getUser(String openid) {
		UserExample userExample=new UserExample();
		Criteria criteria=userExample.createCriteria();
		criteria.andOpenidEqualTo(openid);
		List<User> userList = userMapper.selectByExample(userExample);
		return userList;
	}


	public void update(User user) {
		userMapper.updateByPrimaryKeySelective(user);
	}

	public List<User> getAll() {
		return  userMapper.selectByExample(null);
	}

	public User getUserByUid(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}

	public void updatUser(User user) {
		userMapper.updateByPrimaryKey(user);
	}

	public void deleteEmp(Integer id) {
		userMapper.deleteByPrimaryKey(id);
	}

	public void deleteBatch(List<Integer> ids) {
		UserExample userExample=new UserExample();
		Criteria criteria=userExample.createCriteria();
		//delete from xxx where emp_id in(1,2,3)
		criteria.andUidIn(ids);
		userMapper.deleteByExample(userExample);
	}

	public List<User> findByUname(String uname) {
		UserExample userExample=new UserExample();
		Criteria criteria=userExample.createCriteria();
		criteria.andUnameLike("%"+uname+"%");
		return userMapper.selectByExample(userExample);
	}

	public List<User> findByState(String state) {
		UserExample userExample=new UserExample();
		Criteria criteria=userExample.createCriteria();
		criteria.andStateLike("%"+state+"%");
		return userMapper.selectByExample(userExample);
	}

	public List<User> findByGender(Integer genders) {
		UserExample userExample=new UserExample();
		Criteria criteria=userExample.createCriteria();
		criteria.andGenderEqualTo(genders);
		return userMapper.selectByExample(userExample);
	}

	public List<User> findByOpenid(String openid) {
		UserExample userExample=new UserExample();
		Criteria criteria=userExample.createCriteria();
		criteria.andOpenidEqualTo(openid);
		return userMapper.selectByExample(userExample);
	}
	
	/**
	 * 管理员登录
	 * @param uname
	 * @param openid
	 * @return
	 */
	public User loging(String uname, String openid) {
		UserExample userExample=new UserExample();
		Criteria criteria=userExample.createCriteria();
		criteria.andUnameEqualTo(uname);
		criteria.andOpenidEqualTo(openid);
		List<User> list=userMapper.selectByExample(userExample);
		System.out.println(list);
		if(list.isEmpty()){
			return null;
		}
		return list.get(0);
	}
	
	/**
	 * 查找所有管理员数据
	 * @return
	 */
	public List<User> findAllAdmin() {
		UserExample userExample=new UserExample();
		Criteria criteria=userExample.createCriteria();
		criteria.andUclassNotEqualTo("用户");
		List<User> list=userMapper.selectByExample(userExample);
		return list;
	}
	
}