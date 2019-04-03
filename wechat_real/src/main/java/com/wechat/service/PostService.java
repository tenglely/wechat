package com.wechat.service;

import com.wechat.bean.Post;
import com.wechat.bean.PostExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wechat.dao.PostMapper;

import java.util.List;

@Service
public class PostService {
   
   @Autowired
   private PostMapper postMapper;

    public List<Post> findAll() {
        PostExample postExample=new PostExample();
        return postMapper.selectByExample(postExample);
    }
}