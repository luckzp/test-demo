package com.example.demo.service;

import com.example.demo.dao.CategoryDAO;
import com.example.demo.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZhangP
 * @since 2019-07-01 15:58
 */
@Service
public class UpdateService {
    @Autowired
    CategoryDAO categoryDAO;
    public void update(Category category)  {
        category.setName("zpTest1");
        categoryDAO.save(category);
        throw new RuntimeException("runtime e");
    }
}
