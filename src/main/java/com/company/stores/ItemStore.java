package com.company.stores;

import com.company.models.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemStore {

  Item item1 = new Item(2L, "Furby", "robot toy", 56);
  Item item2 = new Item(3L, "Hydralisk", "Zerg", 33);
  Item item3 = new Item(4L, "Marine", "Terran", 44);
  Item item4 = new Item(5L, "Zealot", "Protoss", 33);

  List<Item> items;

  public ItemStore() {
    items = new ArrayList<Item>();

    items.add(item1);
    items.add(item2);
    items.add(item3);
    items.add(item4);
  }

  public List readAllItems() {
    return items;
  }

  public Item findById(long id) {
    for (Item item : items) {
      if (item.getId() == id)
        return item;
    }
    return null;
  }
}
