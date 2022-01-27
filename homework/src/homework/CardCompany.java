package homework;

public class CardCompany {
	private static CardCompany company = new CardCompany();
	
	private CardCompany() {
		
	}

	static CardCompany getInstance() {

		return company;
	}

	Card createCard() {
		Card card = new Card();
		return card;
	}
}
