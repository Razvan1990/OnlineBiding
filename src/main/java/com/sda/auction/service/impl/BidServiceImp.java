package com.sda.auction.service.impl;

import com.sda.auction.dto.BidForm;
import com.sda.auction.model.Bid;
import com.sda.auction.model.Item;
import com.sda.auction.model.User;
import com.sda.auction.repository.BidRepository;
import com.sda.auction.service.BidService;
import com.sda.auction.service.ItemService;
import com.sda.auction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//trebuie Service ca sa stie spring ca face parte din serviciu

@Service
public class BidServiceImp implements BidService {

    //aici implementam metoda

    private ItemService itemService;
    private UserService userService;
    private BidRepository bidRepository;

    @Autowired
    public BidServiceImp(ItemService itemService,UserService userService,BidRepository bidRepository){
        this.itemService = itemService;
        this.userService = userService;
        this.bidRepository = bidRepository;
    }





    //salvam bidul si gasim itemul pe baza idului
    @Override
    public void save(BidForm bidForm,String itemId) {
        Bid bid = new Bid();
        bid.setValue(bidForm.getValue());

        User user = userService.getLoggedInUser();
        bid.setUser(user);

        Item item = itemService.findItemById(itemId);
        bid.setItem(item);

        bidRepository.save(bid);
    }
}
