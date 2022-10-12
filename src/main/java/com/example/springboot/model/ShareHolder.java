package com.example.springboot.model;

import java.util.List;

import lombok.Data;

@Data
public class ShareHolder {

    private long shareHolderId;
    private String firstName;
    private String lastName;
    private String email;

    private StockShare stockShare;      // has one type of stock

    private List<Offer> offers;         // multiple offers made to buy

}
