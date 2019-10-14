package com.sda.auction.service.impl;

import com.sda.auction.dto.ItemForm;
import com.sda.auction.mapper.ItemMapper;
import com.sda.auction.model.Item;
import com.sda.auction.model.User;
import com.sda.auction.repository.ItemRepository;
import com.sda.auction.service.ItemService;
import com.sda.auction.service.UserService;
import com.sda.auction.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImp implements ItemService {

    private ItemRepository itemRepository;
    private ItemMapper itemMapper;
    //mai avem nevoie de un UserService sa vedem care user este logat
    private UserService userService;


    @Autowired
    public ItemServiceImp(ItemRepository itemRepository, ItemMapper itemMapper,UserService userService) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
        this.userService= userService;
    }

@Override
public void saveItem(ItemForm itemForm){
    Item item = itemMapper.map(itemForm);
    //a setat user pe baza mail-ului care l-a luat si l-a gasit folosind userService
    //userService apeleaza userRepository, care implementand jpaRepository are built-in metoda saveEmail
    String authentificatedEmail = userService.getAuthenticatedEmail();
    setUserByMail(authentificatedEmail,item);

    itemRepository.save(item);

    }

    private void setUserByMail(String authentificatedEmail, Item item){
        User user = userService.findByEmail(authentificatedEmail);
        item.setUser(user);
    }
    @Override
    public List<ItemForm> findAll(){
        List<Item> itemList =itemRepository.findAll();
        List<ItemForm> itemFormList = itemMapper.map(itemList);
        return itemFormList;
    }

    @Override
    public List<ItemForm> findAvailableItems() {
        List<Item> itemList =itemRepository.findAvailable();
        List<ItemForm> itemFormList = itemMapper.map(itemList);
        return itemFormList;
    }

    @Override
    public Item findItemById(String itemId) {
        //trebuie parsat in int
        Integer id = Integer.parseInt(itemId);
        //folosim Optional ca sa incerce sa continue mai departed in caz de eroare
        Optional<Item> optionalItem = itemRepository.findById(id);
        //verifica daca acest obiect este prezent
        if(optionalItem.isPresent()){
            return  optionalItem.get();
            //trebuie sa returneze un ItemForm si folosim mapper
            //e de tip itemForm
        }
        throw new RuntimeException();
        //trebuie musai un itemForm ptr else, folosim o exceptie in caz de nu e bun id

    }

    @Override
    public ItemForm findItemFormById(String itemId) {
        Item item = findItemById(itemId);
        //transformam in itemForm cu mapperu;
        ItemForm itemForm = itemMapper.map(item);

        String userEmail = userService.getAuthenticatedEmail();
        //practic ia bidul cel mai mare al utilizatorului autentificat
        int highestBidValue = item.getHighestBidValueFor(userEmail);
        //aici practic a setat aceasta valoare userFormului
        itemForm.setLoggedUserBidValue(highestBidValue);
        return itemForm;
    }

    @Override
    public byte[] getItemImageByItemId(Integer itemId) throws SQLException {
        Item item = findItemById(itemId.toString());
        return ImageUtil.getByteArray(item.getImage());

    }
    private void setUserByEmail(String authenticatedEmail, Item item){
        //practic a luat userul logat si l-am atribuit ca is user
        User user = userService.findByEmail(authenticatedEmail);
        item.setUser(user);
    }



}


