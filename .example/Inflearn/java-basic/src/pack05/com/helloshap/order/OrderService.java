package com.helloshap.order;

import com.helloshap.product.Product;
import com.helloshap.user.User;

public class OrderService {

    public void order() {
        User user = new User();
        Product product = new Product();
        Order order = new Order(user, product);
    }
}
