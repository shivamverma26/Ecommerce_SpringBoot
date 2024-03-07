package ecommerce.sprinboot.library.service;

import java.util.List;

import ecommerce.sprinboot.library.model.Order;
import ecommerce.sprinboot.library.model.ShoppingCart;

public interface OrderService {
    List<Order> listAll();
    Order get(long id);
    void saveOrder(ShoppingCart cart);
    void acceptOrder(Long id);
    void cancelOrder(Long id);
    void updatePayment(Order order);
}
