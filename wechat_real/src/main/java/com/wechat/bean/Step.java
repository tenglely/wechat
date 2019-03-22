package com.wechat.bean;

/**
 * 菜品步骤表:step
	步骤编号 sid;
	第几步骤 step;(int)
	菜品编号 gid;
	步骤语音 voice;
   	文字描述：describe;
	定时：timing (默认为0分钟)
	步骤配图名 sphoto;

 * @author liten
 *
 */
public class Step {
    private Integer sid;

    private Integer step;

    private Integer gid;

    private String voice;

    private String describe;

    private Integer timing;

    private String sphoto;
    
    

    public Step() {
		super();
	}

	public Step(Integer sid, Integer step, Integer gid, String voice, String describe, Integer timing, String sphoto) {
		super();
		this.sid = sid;
		this.step = step;
		this.gid = gid;
		this.voice = voice;
		this.describe = describe;
		this.timing = timing;
		this.sphoto = sphoto;
	}

	public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice == null ? null : voice.trim();
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

    public Integer getTiming() {
        return timing;
    }

    public void setTiming(Integer timing) {
        this.timing = timing;
    }

    public String getSphoto() {
        return sphoto;
    }

    public void setSphoto(String sphoto) {
        this.sphoto = sphoto == null ? null : sphoto.trim();
    }

	@Override
	public String toString() {
		return "Step [sid=" + sid + ", step=" + step + ", gid=" + gid + ", voice=" + voice + ", describe=" + describe
				+ ", timing=" + timing + ", sphoto=" + sphoto + "]";
	}
    
    
}