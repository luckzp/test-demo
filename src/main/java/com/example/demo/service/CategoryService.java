package com.example.demo.service;

import com.example.demo.dao.CategoryDAO;
import com.example.demo.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangP
 * @since 2019-04-03 18:11
 */
@Service
public class CategoryService {
    @Autowired CategoryDAO categoryDAO;

    @Autowired UpdateService updateService;

    @Transactional(rollbackFor = RuntimeException.class)
    public List<Category> list() {
//        Sort sort = new Sort(Sort.Direction.DESC, "id");
//        Category category = new Category();
//        category.setName("zp");
//        categoryDAO.save(category);
//        updateService.update(category);
//        return categoryDAO.findAll(sort);
        return new ArrayList<>();
    }
}
