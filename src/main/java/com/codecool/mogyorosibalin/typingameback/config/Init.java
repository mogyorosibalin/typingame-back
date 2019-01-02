package com.codecool.mogyorosibalin.typingameback.config;

import com.codecool.mogyorosibalin.typingameback.model.Product;
import com.codecool.mogyorosibalin.typingameback.model.ProductType;
import com.codecool.mogyorosibalin.typingameback.model.Text;
import com.codecool.mogyorosibalin.typingameback.repository.ProductRepository;
import com.codecool.mogyorosibalin.typingameback.repository.ProductTypeRepository;
import com.codecool.mogyorosibalin.typingameback.repository.TextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class Init {

    @Autowired
    private ProductTypeRepository productTypeRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private TextRepository textRepository;

    @Bean
    @Order(1)
    public CommandLineRunner initDb() {
        return args -> {
            initProductTypeRepository();
            initProductRepository();
            initTextRepository();
        };
    }

    private void initProductTypeRepository() {
        productTypeRepository.save(new ProductType("Book"));
    }

    private void initProductRepository() {
        productRepository.save(new Product("Rich Dad Poor Dad", "Robert Kiyosaki", "https://www.amazon.com/Rich-Dad-Poor-Teach-Middle/dp/1543626610", productTypeRepository.findByType("Book")));
        productRepository.save(new Product("The Power of Habit", "Charles Duhigg", "", productTypeRepository.findByType("Book")));
    }

    private void initTextRepository() {
        textRepository.save(new Text(productRepository.findByName("Rich Dad Poor Dad"), "After you've taken the time and invested in and built your own business, you are now ready to learn the biggest secret of the rich - the secret that puts the rich way ahead of the pack."));
        textRepository.save(new Text(productRepository.findByName("Rich Dad Poor Dad"), "To become financially secure, a person needs to mind their own business. Your business revolves around your asset column, not your income column. As stated earlier, the number-one rule is to know the difference between an asset and a liability, and to buy assets."));
        textRepository.save(new Text(productRepository.findByName("Rich Dad Poor Dad"), "Instead, I recommend to young people to seek work for what they will learn, more than what they will earn. Look down the road at what skills they want to acquire before choosing a specific profession and before getting trapped in the Rat Race."));
        textRepository.save(new Text(productRepository.findByName("The Power of Habit"), "So what, exactly, did Hopkins do? He created a craving. And that craving, it turns out, is what makes cues and rewards work. That craving is what powers the habit loop."));
        textRepository.save(new Text(productRepository.findByName("The Power of Habit"), "That's the rule: If you use the same cue, and provide the same reward, you can shift the routine and change the habit. Almost any behavior can be transformed if the cue and reward stay the same."));
    }

}
