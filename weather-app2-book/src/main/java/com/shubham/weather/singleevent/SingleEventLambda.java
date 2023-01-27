package com.shubham.weather.singleevent;

import com.amazonaws.services.lambda.runtime.events.SNSEvent;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shubham.weather.util.WeatherEvent;

import java.io.IOException;

public class SingleEventLambda {

    private final ObjectMapper mapper=new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
    private void handler(SNSEvent event){
        event.getRecords().forEach(this::processSNSRecord);
    }

    private void processSNSRecord(SNSEvent.SNSRecord snsRecord) {
        try{
            final WeatherEvent event=mapper.readValue(
                    snsRecord.getSNS().getMessage(),WeatherEvent.class
            );
            System.out.println("Received Weather Event");
            System.out.println(event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
