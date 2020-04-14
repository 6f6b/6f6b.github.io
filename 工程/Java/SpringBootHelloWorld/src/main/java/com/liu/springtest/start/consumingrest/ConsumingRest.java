package com.liu.springtest.start.consumingrest;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class ConsumingRest {
    public Quote run(){
        RestTemplate restTemplate = new RestTemplate();
        try {
            Quote quote = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random",Quote.class);
            return quote;
        }catch (RestClientException e){
            System.out.println(e.toString());
        }
        return null;
    }
}
