package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();
        basket.addProduct(new SimpleProduct("Яблоко", 50));
        basket.addProduct(new SimpleProduct("Хлеб", 40));
        basket.addProduct(new SimpleProduct("Яблоко", 60));

        List<Product> removed = basket.removesAllProductsWithThatName("Яблоко");
        for (Product p : removed) {
            System.out.println(p.getName() + ": " + p.getPrice());
        }
        basket.printBasket();

        List<Product> emptyRemoved = basket.removesAllProductsWithThatName("Арбуз");
        if (emptyRemoved.isEmpty()) {
            System.out.println("Список пуст");
        }
        basket.printBasket();
    }
}