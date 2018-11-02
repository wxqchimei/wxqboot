package com.example.demo.fastdfs;

/**
 * @author wxq
 * @date 2018-11-02
 */
public class FastDFSException extends Exception {
    /**
     * 错误码
     */
    private String code;

    /**
     * 错误消息
     */
    private String message;

    public FastDFSException(){}

    public FastDFSException(String code, String message) {
        this.code = code;
        this.message = message;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
