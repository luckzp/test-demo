package com.example.demo.controller;

import com.example.demo.async.EventProducer;
import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ZhangP
 * @since 2019-04-04 12:44
 */
/**
 * 表示这是一个控制器，并且对每个方法的返回值都会直接转换为 json 数据格式。
  */
@RestController
@RequestMapping(value = "/test")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    private EventProducer eventProducer;

    @GetMapping("/categories")
    public List<Category> list() throws Exception {
//        eventProducer.fireEvent(new EventModel(EventType.LOGIN)
//                .setActorId(1)
//                .setExt("username", "zp").setExt("email", "zjuyxy@qq.com"));
        return categoryService.list();
    }
}
