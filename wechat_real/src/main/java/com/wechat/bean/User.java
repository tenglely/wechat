package com.wechat.bean;

/**
 * 用户表:user
	用户编号 uid;
	用户名 uname;
	用户唯一标识 openid (String)
	用户头像 purl;
	用户性别 gender; （0,1,2）
	用户类型 uclass;
	用户状态 state;(默认为yes，被禁止发帖和评论为no)

 * @author liten
 *
 */
public class User {
    private Integer uid;

    private String uname;

    private String openid;

    private String purl;

    private Integer gender;

    private String uclass;

    private String state;
    
    

    public User() {
		super();
	}

	public User(Integer uid, String uname, String openid, String purl, Integer gender, String uclass, String state) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.openid = openid;
		this.purl = purl;
		this.gender = gender;
		this.uclass = uclass;
		this.state = state;
	}

	public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl == null ? null : purl.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getUclass() {
        return uclass;
    }

    public void setUclass(String uclass) {
        this.uclass = uclass == null ? null : uclass.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", openid=" + openid + ", purl=" + purl + ", gender=" + gender
				+ ", uclass=" + uclass + ", state=" + state + "]";
	}
    
    
}