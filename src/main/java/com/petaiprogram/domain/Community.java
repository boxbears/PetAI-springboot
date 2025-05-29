package com.petaiprogram.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 
 * @TableName community
 */
@TableName(value ="community")
public class Community implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String comAva;

    /**
     * 
     */
    private String comName;

    /**
     * 
     */
    private String comIntro;

    /**
     * 
     */
    private String titlecontent;

    /**
     * 
     */
    private String text;

    /**
     * 
     */
    private String comPic;

    /**
     * 
     */
    private Integer concern;

    /**
     * 用户的ID
     */
    private Integer userid;

    /**
     * 
     */
    private Integer choosepetid;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     */
    public String getComAva() {
        return comAva;
    }

    /**
     * 
     */
    public void setComAva(String comAva) {
        this.comAva = comAva;
    }

    /**
     * 
     */
    public String getComName() {
        return comName;
    }

    /**
     * 
     */
    public void setComName(String comName) {
        this.comName = comName;
    }

    /**
     * 
     */
    public String getComIntro() {
        return comIntro;
    }

    /**
     * 
     */
    public void setComIntro(String comIntro) {
        this.comIntro = comIntro;
    }

    /**
     * 
     */
    public String getTitlecontent() {
        return titlecontent;
    }

    /**
     * 
     */
    public void setTitlecontent(String titlecontent) {
        this.titlecontent = titlecontent;
    }

    /**
     * 
     */
    public String getText() {
        return text;
    }

    /**
     * 
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * 
     */
    public String getComPic() {
        return comPic;
    }

    /**
     * 
     */
    public void setComPic(String comPic) {
        this.comPic = comPic;
    }

    /**
     * 
     */
    public Integer getConcern() {
        return concern;
    }

    /**
     * 
     */
    public void setConcern(Integer concern) {
        this.concern = concern;
    }

    /**
     * 用户的ID
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * 用户的ID
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * 
     */
    public Integer getChoosepetid() {
        return choosepetid;
    }

    /**
     * 
     */
    public void setChoosepetid(Integer choosepetid) {
        this.choosepetid = choosepetid;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Community other = (Community) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getComAva() == null ? other.getComAva() == null : this.getComAva().equals(other.getComAva()))
            && (this.getComName() == null ? other.getComName() == null : this.getComName().equals(other.getComName()))
            && (this.getComIntro() == null ? other.getComIntro() == null : this.getComIntro().equals(other.getComIntro()))
            && (this.getTitlecontent() == null ? other.getTitlecontent() == null : this.getTitlecontent().equals(other.getTitlecontent()))
            && (this.getText() == null ? other.getText() == null : this.getText().equals(other.getText()))
            && (this.getComPic() == null ? other.getComPic() == null : this.getComPic().equals(other.getComPic()))
            && (this.getConcern() == null ? other.getConcern() == null : this.getConcern().equals(other.getConcern()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getChoosepetid() == null ? other.getChoosepetid() == null : this.getChoosepetid().equals(other.getChoosepetid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getComAva() == null) ? 0 : getComAva().hashCode());
        result = prime * result + ((getComName() == null) ? 0 : getComName().hashCode());
        result = prime * result + ((getComIntro() == null) ? 0 : getComIntro().hashCode());
        result = prime * result + ((getTitlecontent() == null) ? 0 : getTitlecontent().hashCode());
        result = prime * result + ((getText() == null) ? 0 : getText().hashCode());
        result = prime * result + ((getComPic() == null) ? 0 : getComPic().hashCode());
        result = prime * result + ((getConcern() == null) ? 0 : getConcern().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getChoosepetid() == null) ? 0 : getChoosepetid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", comAva=").append(comAva);
        sb.append(", comName=").append(comName);
        sb.append(", comIntro=").append(comIntro);
        sb.append(", titlecontent=").append(titlecontent);
        sb.append(", text=").append(text);
        sb.append(", comPic=").append(comPic);
        sb.append(", concern=").append(concern);
        sb.append(", userid=").append(userid);
        sb.append(", choosepetid=").append(choosepetid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}