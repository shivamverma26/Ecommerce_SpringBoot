package ecommerce.sprinboot.library.service;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import ecommerce.sprinboot.library.dto.ProductDto;
import ecommerce.sprinboot.library.model.Product;

import java.util.List;

public interface ProductService {
    /*Admin*/
    List<ProductDto> findAll();
    Product save(MultipartFile imageProduct, ProductDto productDto);
    Product update(MultipartFile imageProduct, ProductDto productDto);
    void hideById(Long id);
    void enableById(Long id);
    ProductDto getById(Long id);
    void deleteById(Long id);
    Product findById(Long id);

    Page<ProductDto> pageProducts(int pageNo);

    Page<ProductDto> searchProducts(int pageNo, String keyword);


    /*Customer*/
    List<Product> getAllProducts();

    List<Product> listViewProducts();

    Product getProductById(Long id);

    List<Product> getRelatedProducts(Long categoryId);

    List<Product> getProductsInCategory(Long categoryId);

    List<Product> filterHighPrice();

    List<Product> filterLowPrice();
}
