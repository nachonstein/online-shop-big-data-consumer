package com.luxoft.onlineshopbigdataconsumer.messages;


import com.luxoft.demoshopwithspring.messages.ProductEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

@Service
@Slf4j
public class MessageListener {
    private CountDownLatch productLatch = new CountDownLatch(1);

    private Map<String, ProductEvent> eventMap = new HashMap<>();


    @KafkaListener(topics = "${product.topic.name}", containerFactory = "productKafkaListenerContainerFactory")
    public void productListener(ProductEvent product) {
//        System.out.println("Received product message: " + product);


        ProductEvent productEvent = eventMap.get(product.getKey());

        if (productEvent == null) {
            eventMap.put(product.getKey(),product);
            productEvent = product;
        } else {
            switch (product.getEvent()) {
                case ADD:
                    productEvent.setStock(productEvent.getStock() + product.getStock());
                break;

                case REMOVE:
                    productEvent.setStock(productEvent.getStock() - product.getStock());
                break;
            }
        }

        log.info(productEvent.toString());




        this.getProductLatch().countDown();
    }

    public CountDownLatch getProductLatch() {
        return productLatch;
    }
}
