package com.microservice.account.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author ruihui.li
 * @version V1.0
 * @Title: dolores
 * @Package com.microservice.account.entity.vo
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2018/7/1
 */
@Data
@Entity
@Table(name = "user_info")
public class UserInfo implements Serializable{
    private static final long serialVersionUID = -6371904180613484045L;

    @Id
    private String id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String passWord;

    @Column(name = "openid")
    private String openId;

    private Integer role;//1买家2卖家

    private Date createTime;

    private Date updateTime;
}
