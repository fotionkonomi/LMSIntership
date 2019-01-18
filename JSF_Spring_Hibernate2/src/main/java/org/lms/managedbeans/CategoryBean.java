package org.lms.managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.lms.model.Category;
import org.lms.service.CategoryService;

@ManagedBean(name = "categoryBean")
@ViewScoped
public class CategoryBean {

	@ManagedProperty(value = "#{categoryService}")
	private CategoryService categoryService;
	
	private String categoryName;

	private String categoryDescription;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	
	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public String addCategory() {
		Category category = new Category();
		category.setCategoryName(categoryName);
		category.setCategoryDescription(categoryDescription);
		categoryService.addCategory(category);
		return ("success.xhtml");
	}
	
	public List<Category> listCategory() {
		return categoryService.listCategory();
	}

}
