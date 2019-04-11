package com.swust.question.common.restful;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: question
 * @description: 统一返回json格式
 * @author: pang
 * @create: 2019-03-21 18:14
 * @version: v1.0
 **/
public class ResponseJSON<T> {

    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 返回的数据
     */
    private Map data=new HashMap();
    /**
     * 错误码
     */
    private String errCode;
    /**
     * 错误说明
     */
    private String errMsg;

    public ResponseJSON(){}

    public ResponseJSON(boolean success, T data) {
        super();
        this.success = success;
        this.data.put("data",data);
    }

    @Override
    public String toString() {
        return "ResponseJSON{" +
                "success=" + success +
                ", data=" + data +
                ", errCode='" + errCode + '\'' +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }

    public ResponseJSON(boolean success, T data, String errCode, String errMsg) {
        super();
        this.success = success;
        this.data.put("data",data);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public ResponseJSON(boolean success, String errCode, String errMsg) {
        this.success = success;
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
    public ResponseJSON(boolean success,UnicomResponseEnums enums){
        this.success=success;
        this.errCode=enums.getCode();
        this.errMsg=enums.getMsg();
    }
    public ResponseJSON(boolean success,T data,UnicomResponseEnums enums){
        this.success=success;
        this.data.put("data",data);
        this.errCode=enums.getCode();
        this.errMsg=enums.getMsg();
    }
    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
    public Map getData() {
        return data;
    }
    public void setData(T data) {
        this.data.put("data",data);
    }
    public String getErrCode() {
        return errCode;
    }
    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }
    public String getErrMsg() {
        return errMsg;
    }
    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
    public ResponseJSON<T> setTotal(int total){
        data.put("total",total);
        return this;
    }

    public ResponseJSON<T> setTotalPage(int totalPage){
        data.put("totalPage",totalPage);
        return this;
    }

    public ResponseJSON<T> setPageNumber(int pageNumber){
        data.put("pageNumber",pageNumber);
        return this;
    }

    public ResponseJSON<T> setPageSize(int pageSize){
        data.put("pageSize",pageSize);
        return this;
    }
}
