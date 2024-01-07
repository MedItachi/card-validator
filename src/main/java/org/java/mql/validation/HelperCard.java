package org.java.mql.validation;

public class HelperCard {
	
	public static boolean validateCardNumber(String cardNumber) {
		String cleanedCardNumber = cardNumber.replaceAll("[^0-9]", "");

        // Reverse the card number
        StringBuilder reversedCardNumber = new StringBuilder(cleanedCardNumber).reverse();

        int sum = 0;
        boolean alternate = false;

        for (int i = 0; i < reversedCardNumber.length(); i++) {
            int digit = Character.getNumericValue(reversedCardNumber.charAt(i));

            if (alternate) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }

            sum += digit;
            alternate = !alternate;
        }

        return (sum % 10 == 0);
	}
	

}
