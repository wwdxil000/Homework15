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

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        if (search == null || search.isBlank()) {
            throw new BestResultNotFound(search);
        }

        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable item : items) {
            if (item != null) {
                int count = countOccurrences(item.getSearchTerm(), search);
                if (count > maxCount) {
                    maxCount = count;
                    bestMatch = item;
                }
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound(search);
        }
        return bestMatch;
    }

    private int countOccurrences(String text, String search) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(search, index)) != -1) {
            count++;
            index += search.length();
        }
        return count;
    }
}