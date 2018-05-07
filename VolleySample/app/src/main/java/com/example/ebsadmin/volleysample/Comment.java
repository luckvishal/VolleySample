package com.example.ebsadmin.volleysample;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Comment implements Serializable {

    @SerializedName("CommentUserImage")
    @Expose
    private String commentUserImage;
    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("comment_id")
    @Expose
    private String commentId;
    @SerializedName("comment_user_name")
    @Expose
    private String commentUserName;
    @SerializedName("comment_desc")
    @Expose
    private String commentDesc;
    @SerializedName("created")
    @Expose
    private String created;

    public String getCommentUserImage() {
        return commentUserImage;
    }

    public void setCommentUserImage(String commentUserImage) {
        this.commentUserImage = commentUserImage;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getCommentUserName() {
        return commentUserName;
    }

    public void setCommentUserName(String commentUserName) {
        this.commentUserName = commentUserName;
    }

    public String getCommentDesc() {
        return commentDesc;
    }

    public void setCommentDesc(String commentDesc) {
        this.commentDesc = commentDesc;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

}

