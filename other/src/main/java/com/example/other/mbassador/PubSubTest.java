package com.example.other.mbassador;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author wxq
 * @date 2018-10-31
 */
public class PubSubTest {
    public static void main(String[] args) throws IOException {
        PubAndSub ps = new PubAndSub();
        ps.addListener(new CustomListener()).addListener(new CustomListener2()).puclishAsync(new File("a.txt"));

//        PubAndSub ps2 = new PubAndSub();
//        ps.addListener(new CustomListener2()).publish(new File("b.txt"));
        System.in.read();
    }
}
