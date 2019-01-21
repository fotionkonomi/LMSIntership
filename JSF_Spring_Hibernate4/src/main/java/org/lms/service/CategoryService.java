package org.lms.service;

import java.util.List;

import org.lms.dto.CategoryDTO;
 
public interface CategoryService {
 
    public void addCategory(CategoryDTO category);
    public List<CategoryDTO> listCategory();
     
}