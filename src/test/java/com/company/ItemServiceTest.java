package com.company;

import com.company.models.Item;
import com.company.services.ItemService;
import com.company.stores.ItemStore;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ItemServiceTest {

  private ItemStore itemStore;

  private ItemService itemService;

  @BeforeEach
  public void setUp() throws Exception {
    itemStore = mock(ItemStore.class);

    Item mockedItemA = new Item(1L, "Item 1", "Item 1 Desc", 2000);
    when(itemStore.findById(1L)).thenReturn(mockedItemA);

    Item mockedItemB = new Item(1L, "Item 2", "Item 2 Desc", 4000);
    when(itemStore.findById(2L)).thenReturn(mockedItemB);

    Item mockedItem1 = new Item(1L, "Item 1", "Item 1 Desc", 2000);
    Item mockedItem2 = new Item(2L, "Item 2", "Item 2 Desc", 4000);
    List<Item> mockedItems = new ArrayList<>();
    mockedItems.add(mockedItem1);
    mockedItems.add(mockedItem2);

    when(itemStore.readAllItems()).thenReturn(mockedItems);

    itemService = new ItemService(itemStore);
  }

  @Test
  public void getItemById() {
    //
    // When
    //
    Item result = itemService.getById(1L);

    //
    // Verify
    //
    verify(itemStore, times(1)).findById(1L);
    assertEquals(result.getName(), "Item 1");
  }

  @Test
  public void getItemNameUpperCase() {
    //
    // Test
    //
    String result = itemService.getItemNameUpperCase(1L);

    //
    // Assert
    //
    verify(itemStore, times(1)).findById(1L);
    assertEquals(result, "ITEM 1");
  }

  @Test
  public void getAveragePrice() {
    //
    // Test
    //
    int result = itemService.getAveragePrice();

    //
    // Assert
    //
    verify(itemStore, times(1)).readAllItems();
    assertEquals(3000, result);
  }
}
