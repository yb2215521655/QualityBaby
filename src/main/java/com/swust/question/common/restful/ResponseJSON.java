package com.swust.question.common.restful;

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
    private T data;
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
        this.data = data;
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
        this.data = data;
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
        this.data=data;
        this.errCode=enums.getCode();
        this.errMsg=enums.getMsg();
    }
    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
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

}
