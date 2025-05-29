package com.petaiprogram.domain.dto;

/**
 * 功能描述
 *
 * @author 27609
 * @date 2024/02/01  22:13
 */
public class PictureAsFour {
    private String first;
    private String second;
    private String third;
    private String forth;

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getThird() {
        return third;
    }

    public void setThird(String third) {
        this.third = third;
    }

    public String getForth() {
        return forth;
    }

    public void setForth(String forth) {
        this.forth = forth;
    }

    @Override
    public String toString() {
        return "PictureAsFour{" +
                "first='" + first + '\'' +
                ", second='" + second + '\'' +
                ", third='" + third + '\'' +
                ", forth='" + forth + '\'' +
                '}';
    }
}
