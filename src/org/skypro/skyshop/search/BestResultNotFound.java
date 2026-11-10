package org.skypro.skyshop.search;

public class BestResultNotFound  extends Exception{
    public BestResultNotFound (String search) {
        super("Не найден подходящий объект для запроса: " + search);
    }
}
