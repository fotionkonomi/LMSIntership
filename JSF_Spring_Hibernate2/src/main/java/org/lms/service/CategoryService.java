package org.lms.service;

import java.util.List;

import org.lms.model.Category;
 
public interface CategoryService {
 
    public void addCategory(Category category);
    public List<Category> listCategory();
     
}