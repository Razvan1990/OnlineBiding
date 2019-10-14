package com.sda.auction.repository;

import com.sda.auction.model.Bid;
import org.springframework.data.jpa.repository.JpaRepository;


//JpaRepository are implementate metodele de save, findAll etc
public interface BidRepository  extends JpaRepository<Bid, Integer>{

}
