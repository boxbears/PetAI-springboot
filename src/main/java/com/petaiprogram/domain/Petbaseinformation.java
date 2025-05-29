package com.petaiprogram.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 宠物基本信息
 * @TableName petbaseinformation
 */
@TableName(value ="petbaseinformation")
public class Petbaseinformation implements Serializable {
    /**
     * 编号
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 主人id
     */
    private Integer masterid;

    /**
     * 名字
     */
    private String name;

    /**
     * 照片链接
     */
    private String photourl;

    /**
     * 性别
     */
    private String sex;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 其他信息
     */
    private String text;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 主人id
     */
    public Integer getMasterid() {
        return masterid;
    }

    /**
     * 主人id
     */
    public void setMasterid(Integer masterid) {
        this.masterid = masterid;
    }

    /**
     * 名字
     */
    public String getName() {
        return name;
    }

    /**
     * 名字
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 照片链接
     */
    public String getPhotourl() {
        return photourl;
    }

    /**
     * 照片链接
     */
    public void setPhotourl(String photourl) {
        this.photourl = photourl;
    }

    /**
     * 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 生日
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * 生日
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * 其他信息
     */
    public String getText() {
        return text;
    }

    /**
     * 其他信息
     */
    public void setText(String text) {
        this.text = text;
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
        Petbaseinformation other = (Petbaseinformation) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMasterid() == null ? other.getMasterid() == null : this.getMasterid().equals(other.getMasterid()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPhotourl() == null ? other.getPhotourl() == null : this.getPhotourl().equals(other.getPhotourl()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getText() == null ? other.getText() == null : this.getText().equals(other.getText()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMasterid() == null) ? 0 : getMasterid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPhotourl() == null) ? 0 : getPhotourl().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getText() == null) ? 0 : getText().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", masterid=").append(masterid);
        sb.append(", name=").append(name);
        sb.append(", photourl=").append(photourl);
        sb.append(", sex=").append(sex);
        sb.append(", birthday=").append(birthday);
        sb.append(", text=").append(text);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}