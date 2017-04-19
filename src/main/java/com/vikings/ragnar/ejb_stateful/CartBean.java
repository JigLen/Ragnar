package com.vikings.ragnar.ejb_stateful;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 13-Apr-17.
 */
@Stateful
public class CartBean implements Cart {
    private ArrayList items;

    @PostConstruct
    public void initialize(){
        items = new ArrayList();
    }

    @Override
    public void addItem(String item) {
        items.add(item);
    }

    @Override
    public void removeItem(String item) {
        items.remove(item);
    }

    @Override
    public List getItems() {
        return items;
    }
}
