package com.actuator.endpoints;

import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.WebEndpointResponse;
import org.springframework.boot.actuate.endpoint.web.annotation.EndpointWebExtension;
import org.springframework.boot.actuate.info.InfoEndpoint;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "point", enableByDefault = true)
public class MyEndPoint {
     
    @ReadOperation
    public String wordOfTheDay() {
        return "{\"word\": \"Brilliant\"}";
    }
 
}