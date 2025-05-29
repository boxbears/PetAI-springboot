package com.petaiprogram.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {
    private Integer id;/** 用户ID */
    private String avatar;/** 头像  */
    private String account;/** 账户名  */
    private String nickname;/** 昵称 */
    private String sex;/** 性别 */
    private String birthday;/** 生日 */
    private String city;/** 省市区 */
    private String provinceCode;/** 省份编码 */
    private String cityCode;/** 城市编码 */
    private String countyCode;/** 区/县编码 */
}
