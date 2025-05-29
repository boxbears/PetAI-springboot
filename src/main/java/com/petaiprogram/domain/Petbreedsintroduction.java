package com.petaiprogram.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 
 * @TableName petbreedsintroduction
 */
@TableName(value ="petbreedsintroduction")
public class Petbreedsintroduction implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 宠物种类标识
     */
    private Integer uid;

    /**
     * 第一张图片
     */
    private String petImagefirst;

    /**
     * 第二张图片
     */
    private String petImagesecond;

    /**
     * 
     */
    private String petFeature;

    /**
     * 
     */
    private String petKind;

    /**
     * 
     */
    private String petDesc;

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
     * 宠物种类标识
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * 宠物种类标识
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * 第一张图片
     */
    public String getPetImagefirst() {
        return petImagefirst;
    }

    /**
     * 第一张图片
     */
    public void setPetImagefirst(String petImagefirst) {
        this.petImagefirst = petImagefirst;
    }

    /**
     * 第二张图片
     */
    public String getPetImagesecond() {
        return petImagesecond;
    }

    /**
     * 第二张图片
     */
    public void setPetImagesecond(String petImagesecond) {
        this.petImagesecond = petImagesecond;
    }

    /**
     * 
     */
    public String getPetFeature() {
        return petFeature;
    }

    /**
     * 
     */
    public void setPetFeature(String petFeature) {
        this.petFeature = petFeature;
    }

    /**
     * 
     */
    public String getPetKind() {
        return petKind;
    }

    /**
     * 
     */
    public void setPetKind(String petKind) {
        this.petKind = petKind;
    }

    /**
     * 
     */
    public String getPetDesc() {
        return petDesc;
    }

    /**
     * 
     */
    public void setPetDesc(String petDesc) {
        this.petDesc = petDesc;
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
        Petbreedsintroduction other = (Petbreedsintroduction) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getPetImagefirst() == null ? other.getPetImagefirst() == null : this.getPetImagefirst().equals(other.getPetImagefirst()))
            && (this.getPetImagesecond() == null ? other.getPetImagesecond() == null : this.getPetImagesecond().equals(other.getPetImagesecond()))
            && (this.getPetFeature() == null ? other.getPetFeature() == null : this.getPetFeature().equals(other.getPetFeature()))
            && (this.getPetKind() == null ? other.getPetKind() == null : this.getPetKind().equals(other.getPetKind()))
            && (this.getPetDesc() == null ? other.getPetDesc() == null : this.getPetDesc().equals(other.getPetDesc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getPetImagefirst() == null) ? 0 : getPetImagefirst().hashCode());
        result = prime * result + ((getPetImagesecond() == null) ? 0 : getPetImagesecond().hashCode());
        result = prime * result + ((getPetFeature() == null) ? 0 : getPetFeature().hashCode());
        result = prime * result + ((getPetKind() == null) ? 0 : getPetKind().hashCode());
        result = prime * result + ((getPetDesc() == null) ? 0 : getPetDesc().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", uid=").append(uid);
        sb.append(", petImagefirst=").append(petImagefirst);
        sb.append(", petImagesecond=").append(petImagesecond);
        sb.append(", petFeature=").append(petFeature);
        sb.append(", petKind=").append(petKind);
        sb.append(", petDesc=").append(petDesc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}