package com.example.springboot.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Sale {

    private Long saleId;
    private BigDecimal minPrice;
    private Integer quantity;
    private Date publicationDate;
    private Date expirationDate;
    private String status;

    private StockShare stockShare;      // belongs to 1 stock

    private List<Offer> offers;         // has multiple offers from different holders

}
