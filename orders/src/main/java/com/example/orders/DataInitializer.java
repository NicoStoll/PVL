package com.example.orders;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.orders.adapter.out.db.ItemEntity;
import com.example.orders.adapter.out.db.ItemRepository;

import lombok.extern.java.Log;

@Log
@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(ItemRepository itemRepository) {
        return args -> {

            // Only load sample data if DB is empty
            if (itemRepository.count() == 0) {
                itemRepository.save(new ItemEntity("Apple"));
                itemRepository.save(new ItemEntity("Banana"));
                itemRepository.save(new ItemEntity("Carrot"));
                itemRepository.save(new ItemEntity("Donut"));

                log.info("Sample items inserted into database");
            } else {
                log.severe("Database already contains items, skipping sample data");
            }
        };
    }
}
