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

	/**
	 * 查找出所有贴子（升序：按最新）(分页)
	 * @return
	 */
    public List<Post> getAll() {
        PostExample postExample=new PostExample();
        postExample.setOrderByClause("pid DESC");
        return postMapper.selectByExample(postExample);
    }
   
    /**
     * 后台根据贴子编号pid集合批量删除贴子
     * @param del_ids
     */
    public void deleteBatch(List<Integer> del_ids) {
        PostExample postExample=new PostExample();
        Criteria criteria=postExample.createCriteria();
        criteria.andPidIn(del_ids);
        postMapper.deleteByExample(postExample);
    }
   
    /**
     * 后台根据贴子编号(pid)删除一条贴子
     * @param id
     */
    public void deleteone(Integer id) {
        postMapper.deleteByPrimaryKey(id);
    }
  
    /**
     * 根据用户编号(uid)查找所有贴子
     * @param uids
     * @return
     */
    public List<Post> getPostByUid(Integer uids) {
        PostExample postExample=new PostExample();
        postExample.setOrderByClause("pid DESC");
        Criteria criteria=postExample.createCriteria();
        criteria.andUidEqualTo(uids);
        return postMapper.selectByExample(postExample);
    }

    /**
     * 按点击量的从高往低查找出所有贴子（分页）
     * @return
     */
    public List<Post> getAllByHot() {
        PostExample postExample=new PostExample();
        postExample.setOrderByClause("hits DESC");
        return postMapper.selectByExample(postExample);
    }
   
    /**
     * 根据传过来pcontent，模糊查询所有评论
     * @param pcontents
     * @return
     */
    public List<Post> getPostByPcontent(String pcontents) {
        PostExample postExample=new PostExample();
        Criteria criteria=postExample.createCriteria();
        criteria.andPcontentLike("%"+pcontents+"%");
        return postMapper.selectByExample(postExample);
    }
    
    /**
     * 添加一条post数据
     * @param post
     */
	public void addpost(Post post) {
		postMapper.insert(post);
	}
	
	/**
	 * 根据pid查找一条post数据,同时找出user数据
	 * @param pid
	 * @return
	 */
	public Post findPostByPid(Integer pid) {
		return postMapper.selectByPrimaryKeyWithUser(pid);
	}
	
	/**
	 * 修改一条post数据
	 * @param post
	 */
	public void updatePost(Post post) {
		postMapper.updateByPrimaryKey(post);
	}
	
	/**
	 * 按点击量高到低查询
	 * @return
	 */
	public List<Post> getAllByHits() {
		PostExample postExample=new PostExample();
        postExample.setOrderByClause("hits DESC,pid DESC");
        return postMapper.selectByExample(postExample);
	}
}