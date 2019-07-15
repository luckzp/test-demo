package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ZhangP
 * @since 2019-04-03 18:15
 */
@Controller
public class AdminPageController {

    @GetMapping(value="/admin")
    public String admin(){
        return "admin/listCategory";
    }

    @GetMapping(value="/admin_category_list")
    public String listCategory(){
        return "admin/listCategory";
    }

}
