package com.Ch1satooo.AgeOfCelebrities;

//Generic class
public class Response<T> {

    private T data; // backend provided data: DTO class
    private boolean success;
    private String errorMsg;

    // success response msg
    public static <T> Response<T> newSuccess(T data) {
        Response<T> response = new Response<>();
        response.setData(data);
        response.setSuccess(true);
        return response;
    }

    // failure response msg
    public static Response<Void> newFailure(String errorMsg) {
        Response<Void> response = new Response<>();
        response.setSuccess(false);
        response.setErrorMsg(errorMsg);
        return response;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
