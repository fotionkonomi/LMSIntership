package org.lms.dao;

import java.util.List;

import org.lms.dto.CategoryDTO;
 
public interface CategoryDAO {
 
    public void addCategory(CategoryDTO category);
    public List<CategoryDTO> listCategory();
}