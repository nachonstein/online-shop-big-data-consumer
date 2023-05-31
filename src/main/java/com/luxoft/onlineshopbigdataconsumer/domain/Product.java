package com.luxoft.onlineshopbigdataconsumer.domain;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class Product {
    private String name;
    private String brand;
    private Quality quality;
    private Long stock;
    public enum Quality {
        NEW,PERFECT,GOOD,BAD
    }

}
