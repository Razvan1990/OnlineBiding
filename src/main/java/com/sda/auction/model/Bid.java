package com.sda.auction.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="bid")
@Data
//nu vrem ca Lombok sa genereze hasCode ptr user si item
@EqualsAndHashCode(exclude ={"user","item"})

public class Bid {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="bid_id")
    private int id;

    @Column
    private int value;

    @ToString.Exclude
    @ManyToOne(fetch =FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name="user_id")
    private User user;

    @ToString.Exclude
    @ManyToOne(fetch =FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name ="item_id")
    private Item item;


}
