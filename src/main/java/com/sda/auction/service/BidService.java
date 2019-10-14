package com.sda.auction.service;

import com.sda.auction.dto.BidForm;

public interface BidService {
    
    void save (BidForm bidForm,String itemId);
}
