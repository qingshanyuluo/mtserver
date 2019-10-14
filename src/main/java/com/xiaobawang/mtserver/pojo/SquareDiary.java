package com.xiaobawang.mtserver.pojo;

import java.util.Date;

public class SquareDiary {
    private Integer userId;
    private Integer diaryId;
    private String title;
    private Integer view;
    private Integer likeNumber;
    private Date createDate;
    private Integer commentCount;
    private String nickName;
    private String headImage;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDiaryId() {
        return diaryId;
    }

    public void setDiaryId(Integer diaryId) {
        this.diaryId = diaryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }

    public Integer getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(Integer likeNumber) {
        this.likeNumber = likeNumber;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    @Override
    public String toString() {
        return "SquareDiary{" +
                "userId=" + userId +
                ", diaryId=" + diaryId +
                ", title='" + title + '\'' +
                ", view=" + view +
                ", likeNumber=" + likeNumber +
                ", createDate=" + createDate +
                ", commentCount=" + commentCount +
                ", nickName='" + nickName + '\'' +
                ", headImage='" + headImage + '\'' +
                '}';
    }
}
