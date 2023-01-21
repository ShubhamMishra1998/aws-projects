package com.shubham.lambda;

import java.util.HashMap;
import java.util.Map;

public class ApiGatewayRequest {
    public String body;
    public Map<String,String> queryStringParameters = new HashMap<>();
}
