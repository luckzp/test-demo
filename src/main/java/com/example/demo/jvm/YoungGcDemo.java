package com.example.demo.jvm;

public class YoungGcDemo {

    public static void main(String[] args) {
        byte[] array1 = new byte[1024*1024];
        array1 = new byte[1024*1024];
        array1 = new byte[1024*1024];
        array1 = null;
        byte[] array2 = new byte[2*1024*1024];
    }
}
