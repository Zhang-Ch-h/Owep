package com.kclm.owep.entity;

/*******************
 * @Author zch
 * @Description
 */
public class Result {

    private String status;

    private String message;

    private Object data;

    public Result(String status, String message, Object data) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public Result() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Result{");
        sb.append("status='").append(status).append('\'');
        sb.append(", message='").append(message).append('\'');
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
