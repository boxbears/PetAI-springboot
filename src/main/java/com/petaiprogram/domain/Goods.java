package com.petaiprogram.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 
 * @TableName goods
 */
@TableName(value ="goods")
public class Goods implements Serializable {
    /**
     * 商品id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 商品所属分类id
     */
    private Integer productId;

    /**
     * 图片链接
     */
    private String picurl;

    /**
     * 商品名字
     */
    private String goodname;

    /**
     * 商品价格
     */
    private String goodprice;

    /**
     * 备注
     */
    private String text;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 商品id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 商品所属分类id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 商品所属分类id
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 图片链接
     */
    public String getPicurl() {
        return picurl;
    }

    /**
     * 图片链接
     */
    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    /**
     * 商品名字
     */
    public String getGoodname() {
        return goodname;
    }

    /**
     * 商品名字
     */
    public void setGoodname(String goodname) {
        this.goodname = goodname;
    }

    /**
     * 商品价格
     */
    public String getGoodprice() {
        return goodprice;
    }

    /**
     * 商品价格
     */
    public void setGoodprice(String goodprice) {
        this.goodprice = goodprice;
    }

    /**
     * 备注
     */
    public String getText() {
        return text;
    }

    /**
     * 备注
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
        Goods other = (Goods) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getPicurl() == null ? other.getPicurl() == null : this.getPicurl().equals(other.getPicurl()))
            && (this.getGoodname() == null ? other.getGoodname() == null : this.getGoodname().equals(other.getGoodname()))
            && (this.getGoodprice() == null ? other.getGoodprice() == null : this.getGoodprice().equals(other.getGoodprice()))
            && (this.getText() == null ? other.getText() == null : this.getText().equals(other.getText()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getPicurl() == null) ? 0 : getPicurl().hashCode());
        result = prime * result + ((getGoodname() == null) ? 0 : getGoodname().hashCode());
        result = prime * result + ((getGoodprice() == null) ? 0 : getGoodprice().hashCode());
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
        sb.append(", productId=").append(productId);
        sb.append(", picurl=").append(picurl);
        sb.append(", goodname=").append(goodname);
        sb.append(", goodprice=").append(goodprice);
        sb.append(", text=").append(text);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}