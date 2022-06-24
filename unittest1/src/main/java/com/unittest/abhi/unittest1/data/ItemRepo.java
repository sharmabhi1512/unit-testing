package com.unittest.abhi.unittest1.data;

import com.unittest.abhi.unittest1.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item, Integer> {

}
