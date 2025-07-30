package com.daypaytechnologies.smiletool.executions.dto;

import java.io.Serializable;


public class RestRequestDTO implements Serializable {

    private String httpMethod;

    private String restURL;

    private String requestBody;

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getRestURL() {
        return restURL;
    }

    public void setRestURL(String restURL) {
        this.restURL = restURL;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }
}
