package com.wechat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wechat.bean.Greens;
import com.wechat.bean.GreensExample;
import com.wechat.dao.GreensMapper;

@Service
public class GreensService {
	
	@Autowired
	private GreensMapper greensMapper;
	
	/**
	 * 添加一个greens对象
	 * @param greens
	 */
	public void addGreens(Greens greens) {
		greensMapper.insert(greens);
	}
	
	/**
	 * 查找全部greens对象
	 * @return
	 */
	public List<Greens> findAll() {
		return greensMapper.selectByExample(null);
	}
	
	/**
	 * 后台根据gid查询，返回list
	 * @param value
	 * @return
	 */
	public List<Greens> findByGid(Integer value) {
		List<Greens> list=new ArrayList<>();
		list.add(greensMapper.selectByPrimaryKey(value));
		return list;
	}
	
	/**
	 * 根据gname进行模糊查询
	 * @param greensExample
	 * @return
	 */
	public List<Greens> findByGname(GreensExample greensExample) {
		return greensMapper.selectByExample(greensExample);
	}
	
	/**
	 * 根据gstyle进行模糊查询
	 * @param greensExample
	 * @return
	 */
	public List<Greens> findByGstyle(GreensExample greensExample) {
		return greensMapper.selectByExample(greensExample);
	}
	
	/**
	 * 根据glabel进行模糊查询
	 * @param greensExample
	 * @return
	 */
	public List<Greens> findByGlabel(GreensExample greensExample) {
		return greensMapper.selectByExample(greensExample);
	}
	
	/**
	 * 根据点击量查找全部
	 * @param greensExample
	 * @return
	 */
	public List<Greens> findByGhits(GreensExample greensExample) {
		return greensMapper.selectByExample(greensExample);
	}
	
	/**
	 * 根据gid删除一条菜品
	 * @param gid
	 */
	public void deleteOne(Integer gid) {
		greensMapper.deleteByPrimaryKey(gid);
	}
	
	/**
	 * 根据gid查找一条greens对象
	 * @param gid
	 * @return
	 */
	public Greens findOneByGid(Integer gid) {
		return greensMapper.selectByPrimaryKey(gid);
	}
	
	/**
	 * 修改一条greens数据
	 * @param greens
	 */
	public void update(Greens greens) {
		greensMapper.updateByPrimaryKey(greens);
	}
	
	/**
	 * 前台查找全部
	 * @param greensExample
	 * @return
	 */
	public List<Greens> findAll(GreensExample greensExample) {
		return greensMapper.selectByExample(greensExample);
	}
	
	/**
	 * 统计菜品数量
	 * @return
	 */
	public int countNum() {
		return (int) greensMapper.countByExample(null);
	}
	
	
}
