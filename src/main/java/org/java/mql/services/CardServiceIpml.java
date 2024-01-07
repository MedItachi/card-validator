package org.java.mql.services;

import java.util.List;
import java.util.Optional;

import org.java.mql.models.Card;
import org.java.mql.models.User;
import org.java.mql.repository.CardRepository;
import org.java.mql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CardServiceIpml implements CardService {
	@Autowired
	private CardRepository cardRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean isCardNumberExists(String cardNumber) {
		Optional<Card> existingCard = cardRepository.findByCardNumber(cardNumber);
		return existingCard.isPresent();
	}

	@Override
	public void saveCard(Card card) {
		User u = getCurentAuthenticated();
		card.setUser(getCurentAuthenticated());
		cardRepository.save(card);

	}

	@Override
	public List<Card> getAll() {
          
		return cardRepository.findByUser_Username(getUsername());
	}
	
	private User getCurentAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getName());
        return userRepository.findByUsername(authentication.getName());
	}
	
	private String getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (authentication.getName());
	}
	
	
	

}
