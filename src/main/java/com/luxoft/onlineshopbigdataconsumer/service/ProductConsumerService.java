package com.luxoft.onlineshopbigdataconsumer.service;


import com.luxoft.onlineshopbigdataconsumer.messages.MessageListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class ProductConsumerService {
    private MessageListener listener;

    public ProductConsumerService(MessageListener listener) {
        this.listener = listener;
    }

    public void receiveMessages(){
        try {
            listener.getProductLatch().await(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
