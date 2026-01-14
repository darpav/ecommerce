package com.drc.ecommerce;

import com.drc.ecommerce.model.Category;
import com.drc.ecommerce.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner dataSeeder(CategoryRepository categoryRepository) {
        return args -> {
            Category category = new Category();
            category.setName("Electronics");
            categoryRepository.save(category);

            Category category2 = new Category();
            category2.setName("Clothing");
            categoryRepository.save(category2);

            Category category3 = new Category();
            category3.setName("Books");
            categoryRepository.save(category3);

            Category category4 = new Category();
            category4.setName("Home & Garden");
            categoryRepository.save(category4);
        };
    }
}
