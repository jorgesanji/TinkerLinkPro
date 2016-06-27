package com.cronosgroup.tinkerlink.model.dataacess.rest.model;

import com.cronosgroup.core.rest.RestBase;
import com.cronosgroup.core.rest.RestError;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jorgesanmartin on 15/10/15.
 */
public class RestResponse extends RestBase {

    @SerializedName("data")
    private String data = "";

    @SerializedName("error")
    private RestError error = null;

    @SerializedName("funcName")
    private String funcName = "";

    @SerializedName("token")
    private String token = "";

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public RestError getError() {
        return this.error;
    }

    public void setError(RestError error) {
        this.error = error;
    }

    public String getFuncName() {
        return this.funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
