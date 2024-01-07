package org.java.mql.repository;

import java.util.List;
import java.util.Optional;

import org.java.mql.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
    Optional<Card> findByCardNumber(String cardNumber);
    List<Card> findByUser_Username(String username);

}
