package com.ranjit.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.text.NumberFormat;

public class MyBean {

    public MyBean() {
        System.out.println("MyBean instance created");
    }

    @Autowired
    public void setProperty(NumberFormat nf){
        System.out.println("set property");
    }

    @PostConstruct
    private void init() {
        System.out.println("Verifying Resources");
    }

    @PreDestroy
    private void shutdown() {
        System.out.println("Shutdown All Resources");
    }

    public void close() {
        System.out.println("Closing All Resources");
    }
}
