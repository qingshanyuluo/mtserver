package com.xiaobawang.mtserver.pojo;

import java.util.Date;

public class DiaryCommentObj {
    private String nickName;
    private String headImage;
    private String content;
    private Date createDate;
    private Integer commentId;

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

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    @Override
    public String toString() {
        return "DiaryCommentObj{" +
                "nickName=" + nickName +
                ", headImage='" + headImage + '\'' +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                ", commentId=" + commentId +
                '}';
    }
}
