package com.example.ebsadmin.volleysample;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class News implements Serializable{

    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("createdBy")
    @Expose
    private String createdBy;
    @SerializedName("numberOfComments")
    @Expose
    private String numberOfComments;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("GroupTitle")
    @Expose
    private String groupTitle;
    @SerializedName("UserImageUrl")
    @Expose
    private String userImageUrl;
    @SerializedName("GroupId")
    @Expose
    private String groupId;
    @SerializedName("comments")
    @Expose
    private ArrayList<Comment> comments = null;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("NewsId")
    @Expose
    private String newsId;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getNumberOfComments() {
        return numberOfComments;
    }

    public void setNumberOfComments(String numberOfComments) {
        this.numberOfComments = numberOfComments;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getGroupTitle() {
        return groupTitle;
    }

    public void setGroupTitle(String groupTitle) {
        this.groupTitle = groupTitle;
    }

    public String getUserImageUrl() {
        return userImageUrl;
    }

    public void setUserImageUrl(String userImageUrl) {
        this.userImageUrl = userImageUrl;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

}

