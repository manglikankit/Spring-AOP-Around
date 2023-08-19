package com.manglik.aopdemo.Service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceIml implements TrafficFortuneService{
    @Override
    public String getFortune() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Expect hevy traffic this morning";
    }

    @Override
    public String getFortune(boolean tripwire) {
        if (tripwire){
            throw new  RuntimeException("Major accident! Highway is cloded");
        }
        return getFortune();
    }

}
