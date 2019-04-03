package com.wechat.service;

import com.wechat.bean.Post;
import com.wechat.bean.PostExample;
import com.wechat.bean.PostExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wechat.dao.PostMapper;

import java.util.List;

@Service
public class PostService {
	
	@Autowired
	private PostMapper postMapper;

    //查找出所有贴子（升序：按最新）(分页)
    public List<Post> getAll() {
        PostExample postExample=new PostExample();
        postExample.setOrderByClause("pid DESC");
        return postMapper.selectByExample(postExample);
    }
    //后台根据贴子编号pid集合批量删除贴子
    public void deleteBatch(List<Integer> del_ids) {
        PostExample postExample=new PostExample();
        Criteria criteria=postExample.createCriteria();
        criteria.andPidIn(del_ids);
        postMapper.deleteByExample(postExample);
    }
    //后台根据贴子编号(pid)删除一条贴子
    public void deleteone(Integer id) {
        postMapper.deleteByPrimaryKey(id);
    }
    //根据用户编号(uid)查找所有贴子
    public List<Post> getPostByUid(Integer uids) {
        PostExample postExample=new PostExample();
        Criteria criteria=postExample.createCriteria();
        criteria.andUidEqualTo(uids);
        return postMapper.selectByExample(postExample);
    }

    //按点击量的从高往低查找出所有贴子（分页）
    public List<Post> getAllByHot() {
        PostExample postExample=new PostExample();
        postExample.setOrderByClause("hits DESC,pid DESC");
        return postMapper.selectByExample(postExample);
    }
    //根据传过来pcontent，模糊查询所有评论
    public List<Post> getPostByPcontent(String pcontents) {
        PostExample postExample=new PostExample();
        Criteria criteria=postExample.createCriteria();
        criteria.andPcontentLike("%"+pcontents+"%");
        return postMapper.selectByExample(postExample);
    }
}
