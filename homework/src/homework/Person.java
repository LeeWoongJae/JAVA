package homework;

public class Person {

	// 필드
	String name;
	public int money;

	// 생성자
	Person(String name, int money) {
		this.name = name;
		this.money = money;

	}

	// 메소드
	int buyCoffee(StarCafe starCafe) {
		money -= 4000;
		return money;
	}
	int buyCoffee(BeanCafe beanCafe) {
		money -= 4500;
		return money;
	}
	 void showInfo(){
		 System.out.println(name+"고객님의 잔액은 "+money+"입니다");
		}

}
