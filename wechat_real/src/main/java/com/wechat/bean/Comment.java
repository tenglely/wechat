package com.wechat.bean;

/**
 * 用户评论表：comment
	评论编号 cid;
	用户编号 uid;
	评论内容：comment;
	评论类型: ctype;(菜谱或帖子)
	评论类型的编号：typeid;(gid或pid)
	评论时间 cdate;(String)

 * @author liten
 *
 */
public class Comment {
    private Integer cid;

    private Integer uid;

    private String comment;

    private String ctype;

    private Integer typeid;

    private String cdate;
    
    private User user;

    public Comment() {
		super();
	}

	public Comment(Integer cid, Integer uid, String comment, String ctype, Integer typeid, String cdate) {
		super();
		this.cid = cid;
		this.uid = uid;
		this.comment = comment;
		this.ctype = ctype;
		this.typeid = typeid;
		this.cdate = cdate;
	}

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype == null ? null : ctype.trim();
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate == null ? null : cdate.trim();
    }

	@Override
	public String toString() {
		return "Comment [cid=" + cid + ", uid=" + uid + ", comment=" + comment + ", ctype=" + ctype + ", typeid="
				+ typeid + ", cdate=" + cdate + ", user=" + user + "]";
	}

}
