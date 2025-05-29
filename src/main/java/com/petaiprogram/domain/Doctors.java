package com.petaiprogram.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 
 * @TableName doctors
 */
@TableName(value ="doctors")
public class Doctors implements Serializable {
    /**
     * 序号
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 头像
     */
    private String comava;

    /**
     * 名称
     */
    private String comname;

    /**
     * 医生等级
     */
    private String comgrade;

    /**
     * 所在医院
     */
    private String comaddress;

    /**
     * 主治
     */
    private String commain;

    /**
     * 诊断病例
     */
    private Integer cases;

    /**
     * 好评
     */
    private Integer acclaim;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 序号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 头像
     */
    public String getComava() {
        return comava;
    }

    /**
     * 头像
     */
    public void setComava(String comava) {
        this.comava = comava;
    }

    /**
     * 名称
     */
    public String getComname() {
        return comname;
    }

    /**
     * 名称
     */
    public void setComname(String comname) {
        this.comname = comname;
    }

    /**
     * 医生等级
     */
    public String getComgrade() {
        return comgrade;
    }

    /**
     * 医生等级
     */
    public void setComgrade(String comgrade) {
        this.comgrade = comgrade;
    }

    /**
     * 所在医院
     */
    public String getComaddress() {
        return comaddress;
    }

    /**
     * 所在医院
     */
    public void setComaddress(String comaddress) {
        this.comaddress = comaddress;
    }

    /**
     * 主治
     */
    public String getCommain() {
        return commain;
    }

    /**
     * 主治
     */
    public void setCommain(String commain) {
        this.commain = commain;
    }

    /**
     * 诊断病例
     */
    public Integer getCases() {
        return cases;
    }

    /**
     * 诊断病例
     */
    public void setCases(Integer cases) {
        this.cases = cases;
    }

    /**
     * 好评
     */
    public Integer getAcclaim() {
        return acclaim;
    }

    /**
     * 好评
     */
    public void setAcclaim(Integer acclaim) {
        this.acclaim = acclaim;
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
        Doctors other = (Doctors) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getComava() == null ? other.getComava() == null : this.getComava().equals(other.getComava()))
            && (this.getComname() == null ? other.getComname() == null : this.getComname().equals(other.getComname()))
            && (this.getComgrade() == null ? other.getComgrade() == null : this.getComgrade().equals(other.getComgrade()))
            && (this.getComaddress() == null ? other.getComaddress() == null : this.getComaddress().equals(other.getComaddress()))
            && (this.getCommain() == null ? other.getCommain() == null : this.getCommain().equals(other.getCommain()))
            && (this.getCases() == null ? other.getCases() == null : this.getCases().equals(other.getCases()))
            && (this.getAcclaim() == null ? other.getAcclaim() == null : this.getAcclaim().equals(other.getAcclaim()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getComava() == null) ? 0 : getComava().hashCode());
        result = prime * result + ((getComname() == null) ? 0 : getComname().hashCode());
        result = prime * result + ((getComgrade() == null) ? 0 : getComgrade().hashCode());
        result = prime * result + ((getComaddress() == null) ? 0 : getComaddress().hashCode());
        result = prime * result + ((getCommain() == null) ? 0 : getCommain().hashCode());
        result = prime * result + ((getCases() == null) ? 0 : getCases().hashCode());
        result = prime * result + ((getAcclaim() == null) ? 0 : getAcclaim().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", comava=").append(comava);
        sb.append(", comname=").append(comname);
        sb.append(", comgrade=").append(comgrade);
        sb.append(", comaddress=").append(comaddress);
        sb.append(", commain=").append(commain);
        sb.append(", cases=").append(cases);
        sb.append(", acclaim=").append(acclaim);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}