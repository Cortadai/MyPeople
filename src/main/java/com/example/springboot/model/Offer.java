package com.example.springboot.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Offer {

    private Long offerId;
    private BigDecimal price;
    private Date initialDate;
    private Date finalDate;
    private String status;

    private ShareHolder shareHolder;        // belongs to 1 holder

    private Sale sale;                      // interest over 1 sale

}