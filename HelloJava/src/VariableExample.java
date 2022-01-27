
public class VariableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		long var1 = 2L;
//		float var2 = 1.8f;
//		double var3 = 2.5;
//		String var4 = "3.9";
//		int result = (int)(var1+(int)var2+var3+Double.parseDouble(var4));
//		System.out.println(result);

		int x = -5;
		int y = 10;
		int result;
		// 1-1) 부호연산자를 이용하여 변수 x의 값을 양수로 출력하세요. 단, 변수 x의 값은 변하지 말아야한다.
		result = -x;
		System.out.println("문제 1-1 ) result : " + result);
		// 1-2) 변수 x의 값을 증가시킨 후 변수 y의 값과 더한 다음 변수 y의 값을 감소시키는 연산식을 한줄로 작성하세요.
		result = ++x + y--; // x=6 ,y=9
		System.out.println("문제 1-2 ) result : " + result);
		// 1-3) 변수 x와 y의 값을 더한 값이 5가 되도록 증감연산자를 사용하여 연산식을 한줄로 작성하세요.
		System.out.println("현재 x 값: " + x + ", 현재 y 값: " + y);
		result = x + y;
		System.out.println("문제 1-3 ) result : " + result);

		int m = 10;
		int n = 5;
		System.out.print("문제 2-1 )");
		System.out.println(!(m * 2 == n * 4) || !(n <= 5));
		// m==20 , n==20
		System.out.print("문제 2-2 )");
		System.out.println(!(m / 2 > 5) && !(n % 2 < 1));

		int val = 0;
		val += 10;
		val -= 5;
		val *= 3;
		val /= 5;
		System.out.println("문제 3-1) 현재 val 값: "+val);		

		int su = (val > 0) ? val : 0;
		
		int a = 10;
		int b= -8;
		if((a<0) | (b<0)){
			System.out.println("One of a or b is negative number");
			
		}else {
			System.out.println("both a and b are zero or more");
		}
		
		
	}

}
