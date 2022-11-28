package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class ProductDto {

    private String title;

    private String content;

    private int count;

    private int price;

    /*
    int getPrice()
    {
        return this.price;
    }

    void setPrice(int price)
    {
        this.price = price;
    }
    */
}
