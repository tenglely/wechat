package com.wechat.bean;

/**
 * 分享贴表:post
	贴子编号:pid;
	贴子标题：title;
	用户编号:uid;
	内容:pcontent;
	图片:pfile;
	点击量：hits;
	点赞数：goodnum (默认为0)
	坏赞数：badnum （默认为0）
	发表时间:pdate; (String)

 * @author liten
 *
 */
public class Post {
    private Integer pid;

    private String title;

    private Integer uid;

    private String pcontent;
    
    private String pfile;

    private Integer hits;

    private Integer goodnum;

    private Integer badnum;

    private String pdate;

    private User user;
    
	public Post() {
		super();
	}

	public Post(Integer pid, String title, Integer uid, String pcontent, String pfile, Integer hits, Integer goodnum,
			Integer badnum, String pdate, User user) {
		super();
		this.pid = pid;
		this.title = title;
		this.uid = uid;
		this.pcontent = pcontent;
		this.pfile = pfile;
		this.hits = hits;
		this.goodnum = goodnum;
		this.badnum = badnum;
		this.pdate = pdate;
		this.user = user;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getPcontent() {
		return pcontent;
	}

	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}

	public String getPfile() {
		return pfile;
	}

	public void setPfile(String pfile) {
		this.pfile = pfile;
	}

	public Integer getHits() {
		return hits;
	}

	public void setHits(Integer hits) {
		this.hits = hits;
	}

	public Integer getGoodnum() {
		return goodnum;
	}

	public void setGoodnum(Integer goodnum) {
		this.goodnum = goodnum;
	}

	public Integer getBadnum() {
		return badnum;
	}

	public void setBadnum(Integer badnum) {
		this.badnum = badnum;
	}

	public String getPdate() {
		return pdate;
	}

	public void setPdate(String pdate) {
		this.pdate = pdate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Post [pid=" + pid + ", title=" + title + ", uid=" + uid + ", pcontent=" + pcontent + ", pfile=" + pfile
				+ ", hits=" + hits + ", goodnum=" + goodnum + ", badnum=" + badnum + ", pdate=" + pdate + ", user="
				+ user + "]";
	}
	
	

}