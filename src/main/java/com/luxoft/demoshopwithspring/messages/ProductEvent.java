package com.luxoft.demoshopwithspring.messages;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class ProductEvent {
    private String name;
    private String brand;
    private Quality quality;
    private Long stock;
    private Event event;

    @JsonIgnore
    public String getKey(){
        return name+brand+quality.name();
    }

    public enum Event{
        ADD,REMOVE,UNKNOWN
    }
    public enum Quality {
        NEW,PERFECT,GOOD,BAD
    }
}
