package com.xiaobawang.mtserver.pojo;

public class UploadImage {
    private boolean ok;
    private String url;

    @Override
    public String toString() {
        return "UploadImage{" +
                "ok=" + ok +
                ", url='" + url + '\'' +
                '}';
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
