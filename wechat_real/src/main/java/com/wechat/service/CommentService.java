package com.wechat.service;

import com.wechat.bean.Comment;
import com.wechat.bean.CommentExample;
import com.wechat.dao.CommentMapper;
import com.wechat.bean.CommentExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
	
	@Autowired
	private CommentMapper commentMapper;
	
	/**
	 * 添加评论
	 * @param comment1
	 */
    public void insertComment(Comment comment1) {
        commentMapper.insertSelective(comment1);
    }
    
    /**
     * 降序查询全部
     * @return
     */
    public List<Comment> findAll() {
        CommentExample commentExample=new CommentExample();
        commentExample.setOrderByClause("cid DESC");
        return commentMapper.selectByExample(commentExample);
    }
    
    /**
     * 根据cid删除一个数据
     * @param cidid
     */
    public void delectByCid(Integer cidid) {
        commentMapper.deleteByPrimaryKey(cidid);
    }
    
    /**
     * 批量删除评论
     * @param del_cids
     */
    public void deleteBatch(List<Integer> del_cids) {
        CommentExample commentExample=new CommentExample();
        Criteria criteria=commentExample.createCriteria();
        criteria.andCidIn(del_cids);
        commentMapper.deleteByExample(commentExample);
    }
    
    /**
     * 根据用户编号查找全部评论
     * @param cuid
     * @return
     */
    public List<Comment> findAllByUid(Integer cuid) {
        CommentExample commentExample=new CommentExample();
        Criteria criteria=commentExample.createCriteria();
        criteria.andUidEqualTo(cuid);
        return commentMapper.selectByExample(commentExample);
    }
    
    /**
     * 根据类型ctype查找全部评论
     * @param ctype
     * @return
     */
    public List<Comment> findAllByCtype(String ctype) {
        CommentExample commentExample=new CommentExample();
        Criteria criteria=commentExample.createCriteria();
        criteria.andCtypeLike("%"+ctype+"%");
        return commentMapper.selectByExample(commentExample);
    }
    
    /**
     * 根据type和typeid查找所有评论及其user数据
     * @param commentExample
     * @return
     */
	public List<Comment> findAllByTypeAndTypeid(CommentExample commentExample) {
		return commentMapper.selectByExampleWithUser(commentExample);
	}
}