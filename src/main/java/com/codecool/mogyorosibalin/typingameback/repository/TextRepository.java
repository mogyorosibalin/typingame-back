package com.codecool.mogyorosibalin.typingameback.repository;

import com.codecool.mogyorosibalin.typingameback.model.Product;
import com.codecool.mogyorosibalin.typingameback.model.Text;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public interface TextRepository extends JpaRepository<Text, Long> {

    Text findById(long id);

    default Text findRandom() {
        List<Text> texts = new ArrayList<>(findAll());
        Random rand = new Random();
        return texts.get(rand.nextInt(texts.size()));
    }

    List<Text> findByProductOrderById(Product product);

}
