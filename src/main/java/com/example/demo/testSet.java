package com.example.demo;

import cn.hutool.core.convert.Convert;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author ZhangP
 * @Description
 * @since 2019-01-22 14:54
 */
public class testSet {

    public static void main(String[] args) {

        /**
         * list.get(null)会报NULLPOINTER
         */
//        BigDecimal goodsTotal = BigDecimal.ZERO;
//        BigDecimal a = new BigDecimal(30.00);
//        for (int i = 0; i < 2; i++){
//            goodsTotal = goodsTotal.add(a);
//        }


        Timestamp ts = new Timestamp(System.currentTimeMillis());
        Date date = new Date();
        try {
            date = ts;
            System.out.println(new Timestamp(System.currentTimeMillis()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Long> list = new ArrayList<>();
        list.addAll(null);
//        Integer a = 1;
//        System.out.println(a);
//        changeValue(a);
//        System.out.println(goodsTotal);
//aStr为"1"
        // hutool工具类测试
//        String aStr = Convert.toStr(a);
//        System.out.println(aStr);

//        /**
////         * &&条件执行顺序
////         */
////        Map map = new HashMap();
////        map = null;
////        if (map != null && map.get(1) != null){
////            System.out.println("非空");
////        }else{
////            System.out.println("空");
////        }

    }

    private static void changeValue(Integer a) {
        a = 2;
    }

}
