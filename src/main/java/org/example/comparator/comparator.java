package org.example.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

record Item(int count, String name, double individualPrice) {}
public class comparator {

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();

        items.add(new Item(2, "Clock", 230));
        items.add(new Item(1, "Phone", 1550));
        items.add(new Item(3, "Keyring", 15));
        items.add(new Item(2, "Chair", 340));
        items.add(new Item(1, "Hat", 149));

        double total = computeTotalValueItemWithMaxCount(items);

        System.out.format("The total value of the item with most item count is %f", total);
    }

    private static Double computeTotalValueItemWithMaxCount(List<Item> items) {
        //Comparator<Item> itemComparator = Comparator.comparing(item -> item.count());
        Comparator<Item> itemComparator = (Item i1, Item i2) -> (i1.count() > i2.count())? 1:-1;
        return items.stream()
                .max(itemComparator)
                .map(item -> item.count() * item.individualPrice())
                .orElse(0.0);
    }
}
