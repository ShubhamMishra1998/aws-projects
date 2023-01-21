package com.shubham.lambda;

public class ApiGatewayResponse {
    public Integer statusCode;
    public String body;

    public ApiGatewayResponse(Integer statusCode, String body) {
        this.statusCode = statusCode;
        this.body = body;
    }
}
