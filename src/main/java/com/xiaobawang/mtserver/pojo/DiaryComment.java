package com.xiaobawang.mtserver.pojo;

import java.util.Date;

public class DiaryComment {
    private Integer diaryId;
    private Integer userId;
    private String content;
    private Date createDate;
    private Integer commentId;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getDiaryId() {
        return diaryId;
    }

    public void setDiaryId(Integer diaryId) {
        this.diaryId = diaryId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "DiaryComment{" +
                "diaryId=" + diaryId +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                ", commentId=" + commentId +
                '}';
    }
}
