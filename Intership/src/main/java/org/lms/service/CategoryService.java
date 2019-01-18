package com.journaldev.springhibernate.service;

import java.util.List;

import com.journaldev.springhibernate.model.Category;
 
public interface CategoryService {
 
    public void addCategory(Category category);
    public List<Category> listCategory();
     
}