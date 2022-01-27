package homework;

public class MainHomework220105 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("==========문제1번");
		Person kim = new Person("Kim", 8000);
		Person lee = new Person("Lee", 9800);

		StarCafe starCafe = new StarCafe("별다방 1호점");
		kim.buyCoffee(starCafe);
		starCafe.ShowInfo();

		System.out.println();
		BeanCafe beanCafe = new BeanCafe("콩다방 동성로점");
		lee.buyCoffee(beanCafe);
		beanCafe.ShowInfo();

		System.out.println();
		kim.showInfo();
		lee.showInfo();

		System.out.println("==========문제2번");
		Card kbCard = new Card();
		Card kdbCard = new Card();

		System.out.println("kbCard : " + kbCard.getCardNo());
		System.out.println("kdbCard : " + kdbCard.getCardNo());

		System.out.println("==========문제3번");
		CardCompany company = CardCompany.getInstance();

		Card firstCard = company.createCard();
		Card secondCard = company.createCard();
		System.out.println("첫번째 카드 : " + firstCard.getCardNo());
		System.out.println("두번째 카드 : " + secondCard.getCardNo());

	}

}
