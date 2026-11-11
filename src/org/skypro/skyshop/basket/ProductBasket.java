package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
    private final List<Product> products = new LinkedList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public int getTotalPrice() {
        int total = 0;
        for (Product product : products) {
            if (product != null) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public void printBasket() {
        boolean empty = true;
        for (Product product : products) {
            if (product != null) {
                System.out.println(product.getName() + ": " + product.getPrice());
                empty = false;
            }
        }
        if (empty) {
            System.out.println("в корзине пусто");
            return;
        }
        System.out.println("Итого: " + getTotalPrice());
    }

    public boolean containsProductByName(String name) {
        for (Product product : products) {
            if (product != null && product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        for (int i = 0; i < products.size(); i++) {
            products.set(i, null);
        }
    }

    public List<Product> removesAllProductsWithThatName (String name){
        List<Product> delProducts1 = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product elem = iterator.next();
            if (elem.equals(name)) {
                delProducts1.add(elem);
                products.remove((Product)elem);
            }
        }
        return delProducts1;
    }
}