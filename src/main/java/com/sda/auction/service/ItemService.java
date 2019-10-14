package com.sda.auction.service;

import com.sda.auction.dto.ItemForm;
import com.sda.auction.model.Item;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface ItemService {

    //a dat doi parametri ca sa foloseasca si authenticatedEmail
    void saveItem(ItemForm itemForm);

    List<ItemForm> findAll();

    List<ItemForm> findAvailableItems();

    Item findItemById(String itemId);

    ItemForm findItemFormById(String itemId);

    byte[] getItemImageByItemId(Integer itemId) throws  SQLException;

}
