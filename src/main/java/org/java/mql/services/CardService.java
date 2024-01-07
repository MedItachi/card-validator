package org.java.mql.services;

import java.util.List;

import org.java.mql.models.Card;

public interface CardService {

	public boolean isCardNumberExists(String cardNumber);

	public void saveCard(Card card);

	public List<Card> getAll();

}
