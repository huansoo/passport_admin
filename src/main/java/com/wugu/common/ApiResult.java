package com.wugu.common;

import java.io.Serializable;

import com.wugu.utils.Constants;



/**
 * @ClassName: ApiResult
 * @Description: 存储结果工具类
 * @author yangch
 * @date 2014-11-26 
 *
 */
public class ApiResult<T> implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private int status;//200正常  500服务器内部错误
    private int success;//是否成功
    private String exception;//异常信息
    private String code;//异常码
    private T data;
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public int getSuccess() {
        return success;
    }
    public void setSuccess(int success) {
        this.success = success;
    }
    public String getException() {
        return exception;
    }
    public void setException(String exception) {
        this.exception = exception;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    /**
     * 
      * @Title: setSuccessData
      * @Description:设置成功返回数据
      * @author yangch
      * @date 2014-11-26 
      * @param data
      * @throws
     */
    public void setSuccessData(T data){
        this.setData(data);
        this.setStatus(200);
        this.setSuccess(1);
        this.setCode(Constants.SUCCESS);
    }
    /**
     * 
      * @Title: setExceptionData
      * @Description: 处理数据失败
      * @author yangch
      * @date 2014-11-26 
      * @param code
      * @param exception
      * @throws
     */
    public void setExceptionData(String exception){
        this.setStatus(500);
        this.setSuccess(0);
        this.setData(null);
        this.setException(exception);
    }
}
