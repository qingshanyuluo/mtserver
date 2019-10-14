package com.xiaobawang.mtserver.pojo;

public class JsonResult {
    private String errorcode , status ;
    private Object results ;

    public JsonResult(){}

    public JsonResult(String errorcode, String status, Object results) {
        this.errorcode = errorcode;
        this.status = status;
        this.results = results;
    }

    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getResults() {
        return results;
    }

    public void setResults(Object results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "errorcode='" + errorcode + '\'' +
                ", status='" + status + '\'' +
                ", results='" + results + '\'' +
                '}';
    }
}
