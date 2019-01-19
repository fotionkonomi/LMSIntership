package org.lms.converter;

import org.lms.dto.CategoryDTO;
import org.lms.model.Category;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryConverterImpl implements CategoryConverter {

	public Category toModel(CategoryDTO categoryDTO) {
		Category category = new Category();
	//	category.setCategoryId(categoryDTO.getCategoryId());
		category.setCategoryName(categoryDTO.getCategoryName());
		category.setCategoryDescription(categoryDTO.getCategoryDescription());
		return category;
	}
	
	public CategoryDTO toDTO(Category category) {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setCategoryId(category.getCategoryId());
		categoryDTO.setCategoryName(category.getCategoryName());
		categoryDTO.setCategoryDescription(category.getCategoryDescription());
		return categoryDTO;
	}

}
