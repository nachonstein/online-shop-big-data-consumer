package com.luxoft.onlineshopbigdataconsumer;

import com.luxoft.onlineshopbigdataconsumer.configuration.KafkaProperties;
import com.luxoft.onlineshopbigdataconsumer.service.ProductConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MainApplicationRunner implements ApplicationRunner {
    private ProductConsumerService listener;

    public MainApplicationRunner(ProductConsumerService listener) {
        this.listener = listener;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
//        log.info("\u001B[1m");
//        log.info("{} ROJO {}",ANSI_RED, ANSI_RESET);
//
//
//        log.info("BBBBBBBBBB"+ANSI_BOLD+"BBBBBBBBBB"+ANSI_UNDERLINE+"BBBBBBBBBB"+ANSI_YELLOW_BACKGROUND+ANSI_BLACK+"BBBBB"+ANSI_RESET);
//        log.info("{} VERDE {}",ANSI_GREEN, ANSI_RESET);
//        log.info("BBBBBBBBBBBBBBBBBBBB");
//        log.info("{} AZUL",ANSI_BLUE);//notice ansi si not reset
//        log.info("BBBBBBBBBBBBBBBBBBBB");
//        log.info("BBBBBBBBBBBBBBBBBBBB");
//        log.info("BBBBBBBBBBBBBBBBBBBB");

        listener.receiveMessages();
//    log.info(kafkaProperties.getBootstrapAddress());
    }
}
