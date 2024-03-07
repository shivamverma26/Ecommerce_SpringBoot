package ecommerce.sprinboot.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryDto {
    private Long categoryId;
    private String categoryName;
    private String categoryDescription;
    private Long numberOfProduct;
}
