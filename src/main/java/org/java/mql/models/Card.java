package org.java.mql.models;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cards")
public class Card {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String fullName;
	private LocalDate expirationDate;
	private String cardNumber;
	private String cvc;
	@ManyToOne
	private User user;

	public Card() {
		// TODO Auto-generated constructor stub
	}

	public Card(String fullName, LocalDate expirationDate, String cvc) {
		this.fullName = fullName;
		this.expirationDate = expirationDate;
		this.cvc = cvc;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getCvc() {
		return cvc;
	}

	public void setCvc(String cvc) {
		this.cvc = cvc;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", fullName=" + fullName + ", expirationDate=" + expirationDate + ", cardNumber="
				+ cardNumber + ", cvc=" + cvc + "]";
	}

}
