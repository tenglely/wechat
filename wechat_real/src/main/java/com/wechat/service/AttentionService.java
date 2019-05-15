package com.wechat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wechat.bean.Attention;
import com.wechat.dao.AttentionMapper;

@Service
public class AttentionService {
	
	@Autowired
	private AttentionMapper attentionMapper;
	
//	//添加关注
//	public void addAttention(Attention attention)
//	
//	//根据nuid和uid取消一个关注
//	public void deleAttention(int uid,int nid)
//	
//	//根据用户编号uid查询全部
//	public List<Attention> findByUid(int uid)
//	
//	//根据被关注用户编号nid查询全部
//	public List<Attention> findByNid(int nid)
}
