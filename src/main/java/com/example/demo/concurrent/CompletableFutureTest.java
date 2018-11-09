package com.example.demo.concurrent;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * @author wxq
 * @date 2018-11-09
 */
public class CompletableFutureTest {

    public static void main(String[] args) throws IOException {
//        thenApply();
        thenRun();
        System.in.read();
    }

    public static void thenApply() {
        String result = CompletableFuture.supplyAsync(()->"hello").thenApply(s->s.concat("world")).join();
        System.out.println(result);
    }

    public static void thenRun() {
        CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello");
            return "hello";
        }).thenRun(()-> System.out.println("hello world"));
    }

    public static void exceptionTest() {
        String result = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(true) {
                throw new RuntimeException("exception test!");
            }

            return "Hi Boy";
        }).exceptionally(e->{
            System.out.println(e.getMessage());
            return "Hello world!";
        }).join();
        System.out.println(result);
    }
}
