package com.codecool.mogyorosibalin.typingameback.repository;

import com.codecool.mogyorosibalin.typingameback.model.TypingResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypingResultRepository extends JpaRepository<TypingResult, Long> {

    List<TypingResult> findByUserHashOrderByFinishedTimeDesc(String userHash);

    List<TypingResult> findByTextId(long id);

}
