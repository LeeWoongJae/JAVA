package homework;

public class StarCafe {
//필드
	String cafeName;
	String coffee;
	static int money;
	int cnt=0;
	
	//생성자
	
	StarCafe(String cafeName){
		this(cafeName, money, "아메리카노");
	}
	StarCafe(String cafeName,int money,String coffee){
		this.cafeName = cafeName;
		this.money = money;
		this.coffee =coffee;
	}
	//메소드
	
	void ShowInfo(){
		++cnt;
		money+=4000;
		System.out.println(cafeName+"의 현재고객은 "+cnt+"명이고 "+coffee+"를 주문, 누적액은 "+money+"입니다");
	}
}
