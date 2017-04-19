package com.vikings.ragnar.ejb_stateful;
import java.util.List;

/**
 * Created by User on 13-Apr-17.
 */
public interface Cart {

    public void addItem(String item);
    public void removeItem(String item);
    public List getItems();
}
