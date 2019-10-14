package com.sda.auction.model;

import com.oracle.jrockit.jfr.EventDefinition;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name ="item")
@EqualsAndHashCode(exclude = "user")

public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="item_id")
    private int id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Date startDate;

    @Column
    private int startingPrice;

    @Column
    private Date endDate;


    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private String category;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private Set<Bid> bids = new HashSet<>();

    @Column(name ="image")
    private Blob image;

    public int currentPrice() {
        if (bids.isEmpty()) {
            return startingPrice;
        }
        int maxBid = startingPrice;
        for (Bid bid : bids) {
            if (bid.getValue() > maxBid) {
                maxBid = bid.getValue();
            }
        }
        return maxBid;
    }

    public int getHighestBidValueFor(String userEmail) {
        int result = 0;
        for (Bid bid : bids) {
            /**
             * metoda de compareTo returneaza 0 daca sunt egale
             * 1 - if string 1 > string2
             * -1 if string 1 < string2
             */
            //practic asa vedem ca e mailul userului
            User user = bid.getUser();
            if (user.getEmail().compareTo(userEmail) == 0) {
                result = Math.max(result, bid.getValue());
            }
        }
        return result;
    }

    public String getUserName() {
        return user.getFirstName() + " " + user.getLastName();
    }

}
