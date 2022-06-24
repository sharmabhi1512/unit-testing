package com.unittest.abhi.unittest1.business;

import com.unittest.abhi.unittest1.data.DataService;
import com.unittest.abhi.unittest1.model.Item;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.OptionalInt;

@Component
public class BusinessImpl {

    private DataService dataService;

    // Setter method to set a data
    public void setDataService(DataService dataService){
        this.dataService = dataService;
    }

    // Example 1 Simple case
    /*public int calculateSum(int[] data){
        int sum = 0;
        for(int val: data){
            sum += val;
        }
        return sum;
    }*/

    public int calculateSum(int[] data){
        return Arrays.stream(data).reduce(Integer::sum).orElse(0);
    }

    // Example 2 Via data Service
    public int calculateSumUsingDataService(){
        int sum = 0;
        int[] data = dataService.retreiveAllData();
        for(int val: data){
            sum += val;
        }
        return sum;
    }

    // Example 3
    public Item retreiveHardCodedItem() {
        return new Item(1, "Abhi", 10, 100);
    }
}
