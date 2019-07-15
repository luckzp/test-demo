package com.example.demo;

import java.util.Date;

/**
 * @author ZhangP
 * @Description
 * @since 2019-01-31 15:53
 */
public class User {

    private Integer userId;
    /**
     * 姓名
     */
    String userName;

    /**
     * 日期
     */
    Date date;

    /**
     * Gets the value of userId
     *
     * @return the value of userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * Sets the userId
     * <p>You can use getUserId() to get the value of userId</p>
     *
     * @param userId userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
