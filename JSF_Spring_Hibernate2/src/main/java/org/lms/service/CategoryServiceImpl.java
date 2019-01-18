package org.lms.service;

import java.util.List;

import org.lms.dao.CategoryDAO;
import org.lms.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDAO categoryDAO;
	
    public void setCategoryDAO(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }
    
    public CategoryDAO getCategoryDAO() {
    	return categoryDAO;
    }
 
    @Override
    @Transactional
    public void addCategory(Category category) {
        this.categoryDAO.addCategory(category);
    }
 
    @Override
    @Transactional
    public List<Category> listCategory() {
        return this.categoryDAO.listCategory();
    }
 
}
