package com.sda.auction.dto;


import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.Date;

@Data
@ToString
public class ItemForm {


    private int id;

    @NotEmpty(message = "{error.item.name.empty}")
    private String name;

    @NotEmpty(message = "{error.item.description.empty}")
    private String description;

    @Positive(message = "{error.item.startingPrice.positive}")
    private int startingPrice;


    @NotEmpty(message = "{error.item.startingDate.emtpy}")
    private String startDate;


    @NotEmpty(message = "{error.item.endingDate.empty}")
    private String endDate;

    private String category;

    private int loggedUserBidValue;

    private int currentPrice;

    private boolean auctioned;

    private String ownerName;

    private MultipartFile multipartFile;

}


