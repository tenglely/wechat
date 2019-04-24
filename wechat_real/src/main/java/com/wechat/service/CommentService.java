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

    public void insertComment(Comment comment1) {
        commentMapper.insertSelective(comment1);
    }

    public List<Comment> findAll() {
        CommentExample commentExample=new CommentExample();
        commentExample.setOrderByClause("cid DESC");
        return commentMapper.selectByExample(commentExample);
    }

    public void delectByCid(Integer cidid) {
        commentMapper.deleteByPrimaryKey(cidid);
    }

    public void deleteBatch(List<Integer> del_cids) {
        CommentExample commentExample=new CommentExample();
        Criteria criteria=commentExample.createCriteria();
        criteria.andCidIn(del_cids);
        commentMapper.deleteByExample(commentExample);
    }

    public List<Comment> findAllByUid(Integer cuid) {
        CommentExample commentExample=new CommentExample();
        Criteria criteria=commentExample.createCriteria();
        criteria.andUidEqualTo(cuid);
        return commentMapper.selectByExample(commentExample);
    }

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