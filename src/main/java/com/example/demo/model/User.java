package com.example.demo.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhangP
 * @since 2019-07-02 17:27
 */
public class User {
    private String userId;
    private String name;
    private Date creationDate = new Date();
    private Map<String, String> userSettings = new HashMap<>();

    /**
     * Gets the value of userId
     *
     * @return the value of userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the userId
     * <p>You can use getUserId() to get the value of userId</p>
     *
     * @param userId userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Gets the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name
     * <p>You can use getName() to get the value of name</p>
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the value of creationDate
     *
     * @return the value of creationDate
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the creationDate
     * <p>You can use getCreationDate() to get the value of creationDate</p>
     *
     * @param creationDate creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets the value of userSettings
     *
     * @return the value of userSettings
     */
    public Map<String, String> getUserSettings() {
        return userSettings;
    }

    /**
     * Sets the userSettings
     * <p>You can use getUserSettings() to get the value of userSettings</p>
     *
     * @param userSettings userSettings
     */
    public void setUserSettings(Map<String, String> userSettings) {
        this.userSettings = userSettings;
    }
}
