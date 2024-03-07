package ecommerce.sprinboot.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ecommerce.sprinboot.library.dto.CategoryDto;
import ecommerce.sprinboot.library.model.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("select c from Category c where c.is_activated = true and c.is_deleted = false")
    List<Category> findAllByActivated();


    /*Customer*/
    @Query("select new bd.edu.diu.cis.library.dto.CategoryDto(c.id, c.name, c.description, count(p.category.id)) from Category c inner join Product p on p.category.id = c.id " +
            " where c.is_activated = true and c.is_deleted = false group by c.id")
    List<CategoryDto> getCategoryAndProduct();
}
