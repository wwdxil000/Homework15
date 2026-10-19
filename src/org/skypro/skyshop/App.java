package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        basket.addProduct(new Product("Книга", 500));
        basket.addProduct(new Product("Ручка", 50));
        basket.addProduct(new Product("Тетрадь", 100));
        basket.addProduct(new Product("Ластик", 30));
        basket.addProduct(new Product("Линейка", 70));

        basket.addProduct(new Product("Блокнот", 150));

        basket.printBasket();
        System.out.println(basket.getTotalPrice());
        System.out.println(basket.containsProductByName("Тетрадь"));
        System.out.println(basket.containsProductByName("Пенал"));

        basket.clear();
        basket.printBasket();
        System.out.println(basket.getTotalPrice());
        System.out.println(basket.containsProductByName("Тетрадь"));
    }
}