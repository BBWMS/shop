package com.bbw.shop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(ProductRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Product("Wilson Tennisball 5x", 100)));
            log.info("Preloading " + repository.save(new Product("Wilson Tennisball 10x", 190)));
            log.info("Preloading " + repository.save(new Product("Dunlop Tennisball 5x", 120)));
            log.info("Preloading " + repository.save(new Product("Dunlop Tennisball 10x", 200)));
            log.info("Preloading " + repository.save(new Product("Head Tennisball 5x", 110)));
            log.info("Preloading " + repository.save(new Product("Head Tennisball 10x", 205)));
            log.info("Preloading " + repository.save(new Product("Dunlop Tennisball 20x", 390)));
            log.info("Preloading " + repository.save(new Product("Wilson Tennisball 20x", 370)));
            log.info("Preloading " + repository.save(new Product("Head Tennisball 20x", 395)));
            log.info("Preloading " + repository.save(new Product("Babolat Tennisball 5x", 100)));
        };
    }
    @Bean
    CommandLineRunner initCart(CartRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Cart()));
        };
    }
}