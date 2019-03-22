package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author ZhangP
 * @Description
 * @since 2019-01-31 15:52
 */
public class OptionalDemo {

    public static void main(String[] args) {
        User user = null;
        Map<String,Integer> map = new HashMap<>();
        map.put("one",1);
        map.put("two",2);
        map = null;
        Integer goodsNoIndex = null;
        Integer skuNameIndex = 1;
        Integer erpGoodSkuInfoDTO = null;
        Boolean existed = (goodsNoIndex == null || skuNameIndex == null) && erpGoodSkuInfoDTO == null;
        System.out.println(existed);
        Optional<Map<String,Integer>> mapOpt = Optional.ofNullable(map);
        Integer a = mapOpt.map(e->e.get("one")).orElse(null);
        System.out.println(a);
        Optional<User> userOpt = Optional.ofNullable(user);
        String name = userOpt.map(User::getUserName).map(String::toUpperCase)
                .orElse(null);
        System.out.println(name);
        return ;
    }
}
