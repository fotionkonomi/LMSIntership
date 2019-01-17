package com.journaldev.springhibernate.dao;

import java.util.List;

import com.journaldev.springhibernate.model.Category;
 
public interface CategoryDAO {
 
    public void addCategory(Category category);
    public List<Category> listCategory();
}