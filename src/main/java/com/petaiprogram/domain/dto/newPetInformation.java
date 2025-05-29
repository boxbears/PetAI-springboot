package com.petaiprogram.domain.dto;

/**
 * 功能描述
 *
 * @author 27609
 * @date 2024/03/01  15:35
 */
public class newPetInformation {
    private int id;
    private int masterid;
    private String photourl;
    private String name;
    private String sex;
    private String birthday;
    // 其他信息
    private String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMasterid() {
        return masterid;
    }

    public void setMasterid(int masterid) {
        this.masterid = masterid;
    }

    public String getPhotourl() {
        return photourl;
    }

    public void setPhotourl(String photourl) {
        this.photourl = photourl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public newPetInformation(int id, int masterid, String photourl, String name, String sex, String birthday, String text) {
        this.id = id;
        this.masterid = masterid;
        this.photourl = photourl;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.text = text;
    }

    @Override
    public String toString() {
        return "newPetInformation{" +
                "id=" + id +
                ", masterid=" + masterid +
                ", photourl='" + photourl + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
