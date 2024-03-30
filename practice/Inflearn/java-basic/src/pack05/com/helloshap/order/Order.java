package pack05.com.helloshap.order;

import com.helloshap.product.Product;
import com.helloshap.user.User;

public class Order {
    User user;
    Product product;

    public Order(User user, Product product) {
        this.user = user;
        this.product = product;
    }
}
