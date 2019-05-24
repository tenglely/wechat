package com.wechat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wechat.bean.Attention;
import com.wechat.bean.AttentionExample;
import com.wechat.bean.AttentionExample.Criteria;
import com.wechat.dao.AttentionMapper;

@Service
public class AttentionService {
	
	@Autowired
	private AttentionMapper attentionMapper;
	
	/**
	 * 添加关注
	 * @param attention
	 */
	public void addAttention(Attention attention) {
		attentionMapper.insert(attention);
	}
	
	/**
	 * 取消一个关注
	 * @param aid
	 */
	public void deleteone(Integer aid) {
		attentionMapper.deleteByPrimaryKey(aid);
	}
	
	/**
	 * 根据 uid ，type
	 * 查找全部数据
	 * @param uid
	 * @param type
	 * @return
	 */
	public List<Attention> findall(Integer uid, String type) {
		AttentionExample attentionExample=new AttentionExample();
		Criteria criteria=attentionExample.createCriteria();
		criteria.andUidEqualTo(uid);
		criteria.andTypeEqualTo(type);
		List<Attention> list=attentionMapper.selectByExample(attentionExample);
		return list;
	}
	
	/**
	 * 查找一个
	 * @param uid
	 * @param nid
	 * @param type
	 * @return
	 */
	public Attention findone(Integer uid, Integer nid, String type) {
		AttentionExample attentionExample=new AttentionExample();
		Criteria criteria=attentionExample.createCriteria();
		criteria.andUidEqualTo(uid);
		criteria.andNidEqualTo(nid);
		criteria.andTypeEqualTo(type);
		List<Attention> attention=attentionMapper.selectByExample(attentionExample);
		if(attention.size()==0){
			return null;
		}
		Attention attention2=attention.get(0);
		return attention2;
	}
	

}
