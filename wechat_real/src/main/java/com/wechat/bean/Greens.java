package com.wechat.bean;

/**
 * 菜谱表: greens
	菜品编号 gid;
	菜品名 gname;
	所属菜系 gstyle;
	标签：glabel;(家常菜，甜品，汤，粥等)
	点击量 ghits;
	菜品发布者 gwriter;(默认为system，不然为用户编号uid)
	发布时间：gdate (String)(默认为null)
	菜品简介 gneed;

 * @author liten
 *
 */
public class Greens {
    private Integer gid;

    private String gname;

    private String gstyle;

    private String glabel;

    private Integer ghits;

    private String gwriter;

    private String gdate;

    private String gneed;
    
    
    
    public Greens() {
		super();
	}

	public Greens(Integer gid, String gname, String gstyle, String glabel, Integer ghits, String gwriter, String gdate,
			String gneed) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.gstyle = gstyle;
		this.glabel = glabel;
		this.ghits = ghits;
		this.gwriter = gwriter;
		this.gdate = gdate;
		this.gneed = gneed;
	}

	public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname == null ? null : gname.trim();
    }

    public String getGstyle() {
        return gstyle;
    }

    public void setGstyle(String gstyle) {
        this.gstyle = gstyle == null ? null : gstyle.trim();
    }

    public String getGlabel() {
        return glabel;
    }

    public void setGlabel(String glabel) {
        this.glabel = glabel == null ? null : glabel.trim();
    }

    public Integer getGhits() {
        return ghits;
    }

    public void setGhits(Integer ghits) {
        this.ghits = ghits;
    }

    public String getGwriter() {
        return gwriter;
    }

    public void setGwriter(String gwriter) {
        this.gwriter = gwriter == null ? null : gwriter.trim();
    }

    public String getGdate() {
        return gdate;
    }

    public void setGdate(String gdate) {
        this.gdate = gdate == null ? null : gdate.trim();
    }

    public String getGneed() {
        return gneed;
    }

    public void setGneed(String gneed) {
        this.gneed = gneed == null ? null : gneed.trim();
    }

	@Override
	public String toString() {
		return "Greens [gid=" + gid + ", gname=" + gname + ", gstyle=" + gstyle + ", glabel=" + glabel + ", ghits="
				+ ghits + ", gwriter=" + gwriter + ", gdate=" + gdate + ", gneed=" + gneed + "]";
	}
    
    
}