package com.liu.springtest.start.restservice;

import com.liu.springtest.start.consumingrest.ConsumingRest;
import com.liu.springtest.start.consumingrest.Quote;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello,%s";
    private AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greet greeting(@RequestParam(value = "name",defaultValue = "World")String name){
        return new Greet(counter.incrementAndGet(),String.format(template,name));
    }

    @RequestMapping("/quote")
    public Quote retrieveQuote(){
        ConsumingRest consumingRest = new ConsumingRest();
        Quote quote = consumingRest.run();
        return quote;
    }
}
