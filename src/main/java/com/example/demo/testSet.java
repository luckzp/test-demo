package com.example.demo;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author ZhangP
 * @Description
 * @since 2019-01-22 14:54
 */
public class testSet {

    public static void main(String[] args) {


        String ak = "13754521545";
        if(!ak.equals(null)){
            System.out.println("11");
        }

        String newNum = ak.substring(0,3);

        Set<Integer> a = new HashSet<>();
        a.add(1);
        a.add(2);
        a.stream().filter(null).collect(Collectors.toList());
        
        Set<Integer> b = new HashSet<>();
        b.add(1);
        b.add(3);
        a.addAll(b);
        for (int i= 0; i < 5; i++){
            System.out.println(i);
            for (int j = 0; j < 5; j++){
                System.out.println(j);
                return;
            }
        }
        System.out.println(a);
//        List<Integer> b = new ArrayList<>();
//        b.add(3);
//        a.retainAll(b);
//        System.out.println(1);
        long  cc = a.stream().filter(e -> e.equals(1)).count();
        System.out.println(cc);
        long  ca = a.stream().filter(e -> e.equals(4)).count();
        System.out.println(ca);
        try {
            functionA();
        }catch (Exception e){

        }
    }

    private static void functionA() throws Exception {
        throw new Exception("122");
    }


}
