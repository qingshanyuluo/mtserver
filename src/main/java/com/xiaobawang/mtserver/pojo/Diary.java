package com.xiaobawang.mtserver.pojo;



import java.util.Date;

public class Diary {
    private Integer userId;
    private Integer diaryId;
    private String content;
    private String title;
    private Integer view;
    private Integer likeNumber;
    private Integer open;
    private Date createDate;
    private Integer commentCount;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Integer getOpen() {
        return open;
    }

    public void setOpen(Integer open) {
        this.open = open;
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

    @Override
    public String toString() {
        return "Diary{" +
                "userId=" + userId +
                ", diaryId=" + diaryId +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", view=" + view +
                ", likeNumber=" + likeNumber +
                ", open=" + open +
                ", createDate=" + createDate +
                ", commentCount=" + commentCount +
                '}';
    }
}
