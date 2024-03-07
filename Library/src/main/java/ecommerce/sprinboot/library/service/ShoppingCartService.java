package ecommerce.sprinboot.library.service;

import ecommerce.sprinboot.library.model.Customer;
import ecommerce.sprinboot.library.model.Product;
import ecommerce.sprinboot.library.model.ShoppingCart;

public interface ShoppingCartService {
    ShoppingCart addItemToCart(Product product, int quantity, Customer customer);

    ShoppingCart updateItemInCart(Product product, int quantity, Customer customer);

    ShoppingCart deleteItemFromCart(Product product, Customer customer);

}
