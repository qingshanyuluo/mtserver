package com.xiaobawang.mtserver.pojo;

public class UserHobby {
    private Integer userId;
    private Integer objId;
    private Integer tag;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getObjId() {
        return objId;
    }

    public void setObjId(Integer objId) {
        this.objId = objId;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "UserHobby{" +
                "userId=" + userId +
                ", objId=" + objId +
                ", tag=" + tag +
                '}';
    }
}
