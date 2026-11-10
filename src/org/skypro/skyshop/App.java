package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

public class App {
    public static void main(String[] args) {
        try { new SimpleProduct(null, 100); } catch (IllegalArgumentException e) { System.out.println(e.getMessage()); }
        try { new SimpleProduct("   ", 100); } catch (IllegalArgumentException e) { System.out.println(e.getMessage()); }
        try { new SimpleProduct("Товар", 0); } catch (IllegalArgumentException e) { System.out.println(e.getMessage()); }
        try { new SimpleProduct("Товар", -50); } catch (IllegalArgumentException e) { System.out.println(e.getMessage()); }
        try { new DiscountedProduct("Товар", 0, 10); } catch (IllegalArgumentException e) { System.out.println(e.getMessage()); }
        try { new DiscountedProduct("Товар", 1000, -5); } catch (IllegalArgumentException e) { System.out.println(e.getMessage()); }
        try { new DiscountedProduct("Товар", 1000, 101); } catch (IllegalArgumentException e) { System.out.println(e.getMessage()); }

        SearchEngine engine = new SearchEngine(10);
        engine.add(new SimpleProduct("Игровая мышь", 2000));
        engine.add(new Article("Обзор", "Мышь мышь мышь - лучший выбор"));

        try {
            Searchable best = engine.findBestMatch("мышь");
            System.out.println(best.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        try {
            Searchable best = engine.findBestMatch("клавиатура");
            System.out.println(best.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
    }
}