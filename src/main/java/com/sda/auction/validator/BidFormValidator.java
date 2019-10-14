package com.sda.auction.validator;


import com.sda.auction.dto.BidForm;
import com.sda.auction.dto.ItemForm;
import com.sda.auction.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BidFormValidator {

    @Autowired
    private ItemService itemService;

    public boolean isValid(BidForm bidForm, String itemId){
        ItemForm itemForm = itemService.findItemFormById(itemId);
        if(itemForm.isAuctioned()){
            return bidForm.getValue() >itemForm.getCurrentPrice();
        }
        /**
         *  practic daca nu e auctioned nu poti introduce o valoare mai mica de
         *  valoarea pe care o are itemul
         */


        return bidForm.getValue()>= itemForm.getCurrentPrice();
    }
}
