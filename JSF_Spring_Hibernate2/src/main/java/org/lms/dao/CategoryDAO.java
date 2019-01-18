package org.lms.dao;

import java.util.List;

import org.lms.model.Category;
 
public interface CategoryDAO {
 
    public void addCategory(Category category);
    public List<Category> listCategory();
}