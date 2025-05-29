package com.petaiprogram.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 
 * @TableName guesslike
 */
@TableName(value ="guesslike")
public class Guesslike implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 食谱名称
     */
    private String name;

    /**
     * 图片
     */
    private String picture;

    /**
     * 菜谱描述
     */
    private String textDec;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    public Integer getId() {
        return id;
    }

    /**
     * id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 食谱名称
     */
    public String getName() {
        return name;
    }

    /**
     * 食谱名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 图片
     */
    public String getPicture() {
        return picture;
    }

    /**
     * 图片
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * 菜谱描述
     */
    public String getTextDec() {
        return textDec;
    }

    /**
     * 菜谱描述
     */
    public void setTextDec(String textDec) {
        this.textDec = textDec;
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
        Guesslike other = (Guesslike) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPicture() == null ? other.getPicture() == null : this.getPicture().equals(other.getPicture()))
            && (this.getTextDec() == null ? other.getTextDec() == null : this.getTextDec().equals(other.getTextDec()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPicture() == null) ? 0 : getPicture().hashCode());
        result = prime * result + ((getTextDec() == null) ? 0 : getTextDec().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", picture=").append(picture);
        sb.append(", textDec=").append(textDec);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}