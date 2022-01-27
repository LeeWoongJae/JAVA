package homework;

public class Card {
	//필드
	public static int serialNum = 33;
	int cardNum;
	
	//생성자
	public Card(){
		
	}

	//메서드
	int getCardNo(){
		cardNum = serialNum;
		serialNum++;
		return cardNum;
	}
}
