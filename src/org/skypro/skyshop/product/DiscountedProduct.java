package org.skypro.skyshop.product;

public class DiscountedProduct extends Product{
    private final int basePrice;
    private final int discountPercent;

    public DiscountedProduct (String name, int basePrice, int discountPercent) {
        super(name);
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Цена должна быть больше нуля");
        }

        if (discountPercent > 100 || discountPercent < 0) {
            throw new IllegalArgumentException("Процент должен быть числом в диапазоне от 0 до 100");
        }
        this.basePrice = basePrice;
        this.discountPercent = discountPercent;
    }

    @Override
    public int getPrice() {
        return basePrice * (100 - discountPercent) / 100;
    }
}
