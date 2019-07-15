package com.example.demo.dao;

import com.example.demo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ZhangP
 * @since 2019-04-03 18:09
 */
public interface CategoryDAO extends JpaRepository<Category,Integer> {

}
