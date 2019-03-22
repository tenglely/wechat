package com.wechat.bean;

/**
 * 用户关注表 attention
		编号 aid;
		用户编号 uid;
		被关注用户编号 nid;(被关注用户的uid) 
 * @author liten
 *
 */
public class Attention {
    private Integer aid;

    private Integer uid;

    private Integer nid;
    
    
    
    public Attention() {
		super();
	}

	public Attention(Integer aid, Integer uid, Integer nid) {
		super();
		this.aid = aid;
		this.uid = uid;
		this.nid = nid;
	}

	public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

	@Override
	public String toString() {
		return "Attention [aid=" + aid + ", uid=" + uid + ", nid=" + nid + "]";
	}
    
    
}