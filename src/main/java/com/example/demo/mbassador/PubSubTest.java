package com.example.demo.mbassador;

import java.io.File;

/**
 * @author wxq
 * @date 2018-10-31
 */
public class PubSubTest {
    public static void main(String[] args) {
        PubAndSub ps = new PubAndSub();
        ps.addListener(new CustomListener()).publish(new File("a.txt"));
    }
}
