package ecommerce.sprinboot.library.service;

import java.util.List;

import ecommerce.sprinboot.library.dto.CategoryDto;
import ecommerce.sprinboot.library.model.Category;

public interface CategoryService {
    /*Admin*/
    List<Category> findAll();
    Category save(Category category);
    Category findById(Long id);
    Category update(Category category);
    void hideById(Long id);
    void enabledById(Long id);
    List<Category> findAllByActivated();
    void deleteById(Long id);

    /*Customer*/
    List<CategoryDto> getCategoryAndProduct();


}
