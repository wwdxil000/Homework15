package org.skypro.skyshop.search;

public class SearchEngine {
    private final Searchable[] items;

    public SearchEngine(int size) {
        this.items = new Searchable[size];
    }

    public void add(Searchable item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                return;
            }
        }
    }

    public Searchable[] search(String query) {
        Searchable[] result = new Searchable[5];
        int count = 0;

        for (Searchable item : items) {
            if (item != null && item.getSearchTerm().contains(query)) {
                result[count] = item;
                count++;
                if (count == 5) {
                    break;
                }
            }
        }
        return result;
    }
}