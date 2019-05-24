package com.wechat.bean;

/**
 * 用户关注表 attention
		编号 aid;
		用户编号 uid;
		被关注 nid;(被关注用户、贴子、菜品的id) 
		类型：atype
		日期: adate
 * @author liten
 *
 */
public class Attention {
    private Integer aid;

    private Integer uid;

    private Integer nid;
    
    private String type;
    
    private String adate;
    
    
    
    public Attention() {
		super();
	}



	public Attention(Integer aid, Integer uid, Integer nid, String type, String adate) {
		super();
		this.aid = aid;
		this.uid = uid;
		this.nid = nid;
		this.type = type;
		this.adate = adate;
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



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getAdate() {
		return adate;
	}



	public void setAdate(String adate) {
		this.adate = adate;
	}



	@Override
	public String toString() {
		return "Attention [aid=" + aid + ", uid=" + uid + ", nid=" + nid + ", type=" + type + ", adate=" + adate + "]";
	}

    
}