package com.sda.auction.mapper;

import com.sda.auction.dto.ItemForm;
import com.sda.auction.model.Item;
import com.sda.auction.util.DateConverter;
import com.sda.auction.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


//daca nu puneam Component dadea eroare ca nu are beans in service
@Component
public class ItemMapper {

    private DateConverter dateConverter;

    @Autowired
    public ItemMapper(DateConverter dateConverter) {
        this.dateConverter = dateConverter;

    }

    public Item map(ItemForm itemForm) {
        Item item = new Item();

        item.setName(itemForm.getName());
        //Mapperul transforma intr-un model ItemForm ce il luam de la jsp
        item.setDescription(itemForm.getDescription());
        //Am convertit folosind DateConverter  prin care transformam Stringul in Date, ptr ca se asteapta tipul date
        item.setStartingPrice(itemForm.getStartingPrice());
        item.setStartDate(dateConverter.convertDate(itemForm.getStartDate()));
        item.setEndDate(dateConverter.convertDate(itemForm.getEndDate()));
        item.setCategory(itemForm.getCategory());

        item.setImage(ImageUtil.toBlob(itemForm.getMultipartFile()));


        return item;
    }

    public ItemForm map(Item item) {
        ItemForm itemForm = new ItemForm();
        itemForm.setName(item.getName());
        itemForm.setDescription(item.getDescription());
        itemForm.setStartingPrice(item.getStartingPrice());
        itemForm.setCategory(item.getCategory());
        itemForm.setId(item.getId());
        itemForm.setCurrentPrice(item.currentPrice());
        //seteaza ca e auctioned , lista de bids fiind populata
        itemForm.setAuctioned(!item.getBids().isEmpty());
        //seteaza ca numele ownerului numele utilizatorului logat
        itemForm.setOwnerName(item.getUserName());


        String startDate = dateConverter.format(item.getStartDate());
        itemForm.setStartDate(startDate);

        String endDate = dateConverter.format(item.getEndDate());
        itemForm.setEndDate(endDate);

        return itemForm;
    }

    public List<ItemForm> map(List<Item> itemList) {
        List<ItemForm> result = new ArrayList<>();
        //primeste Lista si itereaza prin lsta pe baza itemului primit
        for (Item item : itemList) {
            ItemForm itemForm = map(item);
            result.add(itemForm);
        }
        return result;
    }
}

