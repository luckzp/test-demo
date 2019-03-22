package com.example.demo; /**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */


import java.security.MessageDigest;
import java.util.*;
import java.util.stream.Collectors;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import com.example.demo.util.ExcelUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @since 2018年10月25日 上午9:44:00
 * @author YuanMingEn
 *
 */
public class GetCacheGoods {

    /**
     * @param args
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {

//        Integer rowIndex = 0;
//        // 读取EXCEL获取一列数据
//        List<List<String>> dataList = ExcelUtil.readExcel("C:\\Users\\differ\\Desktop\\无标题.xlsx",rowIndex);
//        // 去重
//        Set<String> dataSet  = new HashSet(dataList);
//        List<String> skuIdList = new ArrayList<>(dataSet);
//        // 分页查询
//        List<List<String>> skuIdGroup = Lists.partition(skuIdList, 1000);

        //
        // for (String[] dataArray : dataList) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        Map<String, String> params = new LinkedHashMap<String, String>();
        params.put("appkey", "jackyun_esapi");
        params.put("origin_name", "esapi");
        params.put("target_member_name", "420001");
//        params.put("bizStockString", "[{\"warehouseId\":" + "525914119171867904" + ",\"skuId\":" + "391674003746882176" + ",\"quantity\":" + "-2"
//                + ",\"inouttype\":201,\"createUserId\":0,\"createUserName\":\"系统自动\",\"memo\":\"系统修复多扣减可用库存部分\"}]");
        params.put("blockUp", "0");
        params.put("packageGood", "0");
        params.put("pageIndex", "0");
        params.put("pageSize", "50");
        params.put("timestamp", System.currentTimeMillis() + "");
        params = getSign(params);

        MultiValueMap<String, String> params1 = new LinkedMultiValueMap<String, String>();
        for (String key : params.keySet()) {
            params1.add(key, params.get(key));
        }
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params1, headers);

        //
        // String gateway = "http://47.99.17.46/interlink";
        // String gateway = "http://118.178.57.172/interlink";
        String gateway = "http://192.168.88.186:31088/interlink";

//        for (List<String> skuIds : skuIdGroup) {
//            String skuIdStr = skuIds.stream().collect(Collectors.joining(","));
//            System.out.println(skuIdStr);
//            // 1.查询数据
//            // 2.插入数据
//        }
        ResponseEntity<String> response = restTemplate.exchange(gateway + "/erp/goodsstockquantity/searchstockquantity", HttpMethod.POST, requestEntity, String.class);
        System.out.println(response.getBody());
        // }

    }

    private static byte[] Ase(byte[] byteData, byte[] byteKey, int opmode) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKeySpec skeySpec = new SecretKeySpec(byteKey, "AES");
        cipher.init(opmode, skeySpec);
        byte[] decrypted = cipher.doFinal(byteData);
        return decrypted;
    }

    public static Map getSign(Map param) {
        TreeMap<Object, Object> map = new TreeMap<Object, Object>(param);
        String secret = "jackyun_esapi_secret";

        final StringBuilder builder = new StringBuilder(secret);

        Iterator<Map.Entry<Object, Object>> it = map.entrySet().iterator();
        Map.Entry<Object, Object> entry;
        Object key;
        Object value;

        while (it.hasNext()) {
            entry = it.next();
            key = entry.getKey();
            value = entry.getValue();
            if (key == null || value == null || value.equals("") || value.equals(" ")) {
                param.remove(key);
                continue;
            }
            if (value instanceof byte[] || key.equals("sign")) {
                continue;
            }
            builder.append(key).append(value);
        }
        builder.append(secret);
        String signStr = getMd5Value(builder.toString());
        if (null == signStr) {
            return null;
        }
        param.put("sign", signStr.toUpperCase());
        return param;
    }

    static String getMd5Value(String sSecret) {
        try {
            MessageDigest bmd5 = MessageDigest.getInstance("MD5");
            bmd5.update(sSecret.getBytes("UTF-8"));
            int i;
            StringBuffer buf = new StringBuffer();
            byte[] b = bmd5.digest();
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            return buf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
