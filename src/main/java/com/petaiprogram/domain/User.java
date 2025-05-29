package com.petaiprogram.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;/** 用户ID */
    private String avatar;/** 头像  */
    private String account;/** 账户名  */
    private String nickname;/** 昵称 */

    private String mobile;/** 手机号 */

    private String token;/** 登录凭证 */

}
