package com.tencent.wxcloudrun.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class RestResponse<T> implements Serializable {

    private Integer resultCode;
    private String resultMsg;
    private T data;
    public static final Integer RESULT_SUCCESS = 100;
    public static final Integer RESULT_FAILURE = 101;
    public static final Integer SUCCESS_NO_CHANGE = 110;

    public RestResponse(Integer resultCode, String resultMsg, T data) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.data = data;
    }

    public static <T> RestResponse Success(T data) {
        return new RestResponse(RestResponse.RESULT_SUCCESS, data);
    }

    public static <T> RestResponse Success() {
        return new RestResponse(RestResponse.RESULT_SUCCESS, (String)null);
    }

    public RestResponse(Integer resultCode, T data) {
        this(resultCode, "", data);
    }

    public Integer getResultCode() {
        return this.resultCode;
    }

    public String getResultMsg() {
        return this.resultMsg;
    }

    public T getData() {
        return this.data;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof RestResponse)) {
            return false;
        } else {
            RestResponse<?> other = (RestResponse)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$resultCode = this.getResultCode();
                    Object other$resultCode = other.getResultCode();
                    if (this$resultCode == null) {
                        if (other$resultCode == null) {
                            break label47;
                        }
                    } else if (this$resultCode.equals(other$resultCode)) {
                        break label47;
                    }

                    return false;
                }

                Object this$resultMsg = this.getResultMsg();
                Object other$resultMsg = other.getResultMsg();
                if (this$resultMsg == null) {
                    if (other$resultMsg != null) {
                        return false;
                    }
                } else if (!this$resultMsg.equals(other$resultMsg)) {
                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof RestResponse;
    }

    public int hashCode() {
        int result = 1;
        Object $resultCode = this.getResultCode();
        result = result * 59 + ($resultCode == null ? 43 : $resultCode.hashCode());
        Object $resultMsg = this.getResultMsg();
        result = result * 59 + ($resultMsg == null ? 43 : $resultMsg.hashCode());
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    public String toString() {
        return "RestResponse(resultCode=" + this.getResultCode() + ", resultMsg=" + this.getResultMsg() + ", data=" + this.getData() + ")";
    }
}
