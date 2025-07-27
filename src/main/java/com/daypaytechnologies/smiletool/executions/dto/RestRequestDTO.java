package com.daypaytechnologies.smiletool.executions.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class RestRequestDTO implements Serializable {

    private String httpMethod;

    private String restURL;

    private String requestBody;
}
