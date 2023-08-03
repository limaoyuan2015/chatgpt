package com.szmengran.chatgpt;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class TestApplication {
    public void method() {
        try {
            System.out.println("try");
            System.exit(0);
            
            return;
        } catch (Exception ex) {
            System.out.println("异常发生了");
        } finally {
            System.out.println("finally");
        }
        
        System.out.println("异常处理后续的代码");
    }
    
    public static void main(String[] args) {
        TestApplication test = new TestApplication();
        test.method();
    }
}
