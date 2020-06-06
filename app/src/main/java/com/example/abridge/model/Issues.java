package com.example.abridge.model;

import com.google.gson.annotations.SerializedName;

public class Issues {
    @SerializedName("title")
    private String title;

    @SerializedName("number")
    private String issueID;

    @SerializedName("created_at")
    private String issueCreationDate;

    @SerializedName("user")
    private User user;

    public String getTitle() {
        return title;
    }

    public String getIssueID() {
        return issueID;
    }

    public String getIssueCreationDate() {
        return issueCreationDate;
    }

    public User getUser() {
        return user;
    }

    public static class User {
        @SerializedName("login")
        private String userName;

        public String getUserName() {
            return userName;
        }
    }
}
