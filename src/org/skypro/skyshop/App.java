package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

public class App {
    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket();
        basket.addProduct(new Product("Яблоко", 50));
        basket.addProduct(new Product("Хлеб", 40));
        basket.addProduct(new Product("Молоко", 80));
        basket.addProduct(new Product("Сыр", 200));
        basket.addProduct(new Product("Масло", 150));
        basket.addProduct(new Product("Сок", 90));

        basket.printBasket();
        System.out.println(basket.getTotalPrice());
        System.out.println(basket.containsProductByName("Сыр"));
        System.out.println(basket.containsProductByName("Арбуз"));

        basket.clear();
        basket.printBasket();
        System.out.println(basket.getTotalPrice());
        System.out.println(basket.containsProductByName("Сыр"));


        SearchEngine engine = new SearchEngine(10);
        engine.add(new Product("Ноутбук", 50000));
        engine.add(new Product("Мышь", 1500));
        engine.add(new Article("Обзор ноутбуков", "Лучшие модели 2024 года"));

        Searchable[] results = engine.search("ноутбук");

        for (Searchable item : results) {
            if (item != null) {
                System.out.println(item.getContentType() + ": " + item.getSearchTerm());
            }
        }
    }
}