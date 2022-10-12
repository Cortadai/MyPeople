package com.example.springboot.model;

import java.util.List;

import lombok.Data;

@Data
public class StockShare {

    private long stockShareId;
    private int numTotal;
    private String stockType;

    private ShareHolder shareHolder;        // belongs to 1 holder

    private List<Sale> Sales;               // has multiple sales

}