package com.unittest.abhi.unittest1.controller;

import com.unittest.abhi.unittest1.business.BusinessImpl;
import com.unittest.abhi.unittest1.business.ItemBusinessService;
import com.unittest.abhi.unittest1.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemBusinessService itemBusinessService;

    @GetMapping("/dummy-item")
    public Item dummyItem(){
        return new Item(1, "Abhi", 10, 100);
    }

    @GetMapping("/item-from-business-service")
    public Item itemFromBusinessService(){
        return itemBusinessService.retreiveHardCodedItem();
    }

    @GetMapping("/all-item-from-database")
    public List<Item> itemFromDatabase(){
        return itemBusinessService.retriveAllItem();
    }

}
