package com.petaiprogram.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 
 * @TableName shop
 */
@TableName(value ="shop")
public class Shop implements Serializable {
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
     * 
     */
    private String picture;

    /**
     * 商品名字
     */
    private String shopName;

    /**
     * 
     */
    private String shopAddress;

    /**
     * 商品联系电话
     */
    private String shopPhonenumber;

    /**
     * 商品介绍
     */
    private String productDesciption;

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
     * 
     */
    public String getPicture() {
        return picture;
    }

    /**
     * 
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * 商品名字
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * 商品名字
     */
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    /**
     * 
     */
    public String getShopAddress() {
        return shopAddress;
    }

    /**
     * 
     */
    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    /**
     * 商品联系电话
     */
    public String getShopPhonenumber() {
        return shopPhonenumber;
    }

    /**
     * 商品联系电话
     */
    public void setShopPhonenumber(String shopPhonenumber) {
        this.shopPhonenumber = shopPhonenumber;
    }

    /**
     * 商品介绍
     */
    public String getProductDesciption() {
        return productDesciption;
    }

    /**
     * 商品介绍
     */
    public void setProductDesciption(String productDesciption) {
        this.productDesciption = productDesciption;
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
        Shop other = (Shop) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getPicture() == null ? other.getPicture() == null : this.getPicture().equals(other.getPicture()))
            && (this.getShopName() == null ? other.getShopName() == null : this.getShopName().equals(other.getShopName()))
            && (this.getShopAddress() == null ? other.getShopAddress() == null : this.getShopAddress().equals(other.getShopAddress()))
            && (this.getShopPhonenumber() == null ? other.getShopPhonenumber() == null : this.getShopPhonenumber().equals(other.getShopPhonenumber()))
            && (this.getProductDesciption() == null ? other.getProductDesciption() == null : this.getProductDesciption().equals(other.getProductDesciption()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getPicture() == null) ? 0 : getPicture().hashCode());
        result = prime * result + ((getShopName() == null) ? 0 : getShopName().hashCode());
        result = prime * result + ((getShopAddress() == null) ? 0 : getShopAddress().hashCode());
        result = prime * result + ((getShopPhonenumber() == null) ? 0 : getShopPhonenumber().hashCode());
        result = prime * result + ((getProductDesciption() == null) ? 0 : getProductDesciption().hashCode());
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
        sb.append(", picture=").append(picture);
        sb.append(", shopName=").append(shopName);
        sb.append(", shopAddress=").append(shopAddress);
        sb.append(", shopPhonenumber=").append(shopPhonenumber);
        sb.append(", productDesciption=").append(productDesciption);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}