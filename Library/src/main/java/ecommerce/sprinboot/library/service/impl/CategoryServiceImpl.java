package ecommerce.sprinboot.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.sprinboot.library.dto.CategoryDto;
import ecommerce.sprinboot.library.model.Category;
import ecommerce.sprinboot.library.repository.CategoryRepository;
import ecommerce.sprinboot.library.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository repo;

    @Override
    public List<Category> findAll() {
        return repo.findAll();
    }

    @Override
    public Category save(Category category) {
        Category categorySave = new Category(category.getName(), category.getDescription());
        return repo.save(categorySave);
    }

    @Override
    public void deleteById(Long id) {
        repo.delete(findById(id));
    }

    @Override
    public Category findById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public Category update(Category category) {
        Category categoryUpdate = null;
        try {
            categoryUpdate = repo.findById(category.getId()).get();
            categoryUpdate.setName(category.getName());
            categoryUpdate.setDescription(category.getDescription());
//            categoryUpdate.set_activated(category.is_activated());
//            categoryUpdate.set_deleted(category.is_deleted());
        }catch (Exception e){
            e.printStackTrace();
        }
        return repo.save(categoryUpdate);
    }

    @Override
    public void hideById(Long id) {
        Category category = repo.getById(id);
        category.set_deleted(true);
        category.set_activated(false);
        repo.save(category);
    }

    @Override
    public void enabledById(Long id) {
        Category category = repo.getById(id);
        category.set_activated(true);
        category.set_deleted(false);
        repo.save(category);
    }

    @Override
    public List<Category> findAllByActivated() {
        return repo.findAllByActivated();
    }

    @Override
    public List<CategoryDto> getCategoryAndProduct() {
        return repo.getCategoryAndProduct();
    }
}
