package API;

import com.google.gson.JsonObject;

/**
 * Created by rafael on 23/03/17.
 */

public class BaseRequest {

    private Boolean op = false;

    private String msg = "";

    private JsonObject data = null;

    public Boolean getOp() {
        return op;
    }

    public void setOp(Boolean op) {
        this.op = op;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public JsonObject getData() {
        return data;
    }

    public void setData(JsonObject data) {
        this.data = data;
    }

    @Override
    public String toString() {
            return "BaseRequest{" +
                    "op=" + op +
                    ", msg='" + msg + '\'' +
                    ", data=" + data +
                    '}';

    }
}
