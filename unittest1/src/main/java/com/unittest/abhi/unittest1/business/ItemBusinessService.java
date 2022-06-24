package com.unittest.abhi.unittest1.business;

import com.unittest.abhi.unittest1.data.ItemRepo;
import com.unittest.abhi.unittest1.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemBusinessService {

    @Autowired
    private ItemRepo itemRepo;
    // Example 4
    public Item retreiveHardCodedItem() {
        return new Item(1, "Abhi", 10, 100);
    }

    public List<Item> retriveAllItem(){
        List<Item> items = itemRepo.findAll();
        for(Item item: items){
            item.setValue(item.getPrice()*item.getQuantity());
        }
        return items;
    }

}
