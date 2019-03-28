package com.wechat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wechat.bean.Step;
import com.wechat.bean.StepExample;
import com.wechat.bean.StepExample.Criteria;
import com.wechat.dao.StepMapper;

@Service
public class StepService {
	
	@Autowired
	private StepMapper stepMapper;
	
	/**
	 * 添加一条步骤信息
	 * @param step2
	 */
	public void addStep(Step step2) {
		stepMapper.insert(step2);
	}
	
	/**
	 * 根据gid查询所有step
	 * @param stepExample
	 * @return
	 */
	public List<Step> findAllByGid(StepExample stepExample) {
		return stepMapper.selectByExample(stepExample);
	}
	
	/**
	 * 根据sid删除一条菜品步骤
	 * @param sid
	 */
	public void deleteone(Integer sid) {
		stepMapper.deleteByPrimaryKey(sid);
	}
	
	/**
	 * 根据sid查找一条step数据
	 * @param sid
	 * @return
	 */
	public Step findStepBySid(Integer sid) {
		return stepMapper.selectByPrimaryKey(sid);
	}

	/**
	 * 修改一条步骤数据
	 * @param step
	 */
	public void updateStep(Step step) {
		stepMapper.updateByPrimaryKey(step);
	}

	public int countStep(Integer gid) {
		StepExample stepExample=new StepExample();
		Criteria criteria=stepExample.createCriteria();
		criteria.andGidEqualTo(gid);
		return (int) stepMapper.countByExample(stepExample);
	}

	
}
