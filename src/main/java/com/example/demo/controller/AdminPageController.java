package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZhangP
 * @since 2019-04-03 18:15
 */
@RestController
public class AdminPageController {

    @GetMapping(value="/admin")
    public Integer admin(){
        return 1;
    }

    @GetMapping(value="/admin_category_list")
    public String listCategory(){
        return "admin/listCategory";
    }

}
