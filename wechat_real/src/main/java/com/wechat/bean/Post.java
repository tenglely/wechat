package com.wechat.bean;

/**
 * 分享贴表:post
	贴子编号:pid;
	贴子标题：title;
	用户编号:uid;
	内容:pcontent;
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

    private String hits;

    private Integer goodnum;

    private Integer badnum;

    private String pdate;
    
    

    public Post() {
		super();
	}

	public Post(Integer pid, String title, Integer uid, String pcontent, String hits, Integer goodnum, Integer badnum,
			String pdate) {
		super();
		this.pid = pid;
		this.title = title;
		this.uid = uid;
		this.pcontent = pcontent;
		this.hits = hits;
		this.goodnum = goodnum;
		this.badnum = badnum;
		this.pdate = pdate;
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
        this.title = title == null ? null : title.trim();
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
        this.pcontent = pcontent == null ? null : pcontent.trim();
    }

    public String getHits() {
        return hits;
    }

    public void setHits(String hits) {
        this.hits = hits == null ? null : hits.trim();
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
        this.pdate = pdate == null ? null : pdate.trim();
    }

	@Override
	public String toString() {
		return "Post [pid=" + pid + ", title=" + title + ", uid=" + uid + ", pcontent=" + pcontent + ", hits=" + hits
				+ ", goodnum=" + goodnum + ", badnum=" + badnum + ", pdate=" + pdate + "]";
	}
    
    
}