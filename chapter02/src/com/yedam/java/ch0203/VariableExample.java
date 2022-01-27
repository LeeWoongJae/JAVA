package com.yedam.java.ch0203;

public class VariableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 자동 타입 변환 : 값의 유효범위 小 > 大
		byte byteValue  = 10;
		int intValue = byteValue;
		System.out.println("intValue : "+intValue);
		
		char charValue = '가';
		intValue = charValue;
		System.out.println("가 의 유니코드 "+intValue);
		
		intValue = 50;
		long longValue = intValue;
		System.out.println("longValue : "+longValue);
		 
		longValue =100;
		float floatValue = longValue;
		System.out.println("floatValue : "+floatValue);
		
		floatValue =100.5F;
		double doubleValue = floatValue;
		System.out.println("doubleValue : "+doubleValue);
		
		//강제 타입 변환
		longValue = 500;
		intValue = (int)longValue;
		System.out.println(intValue);
		
		doubleValue = 3.14;
		intValue=(int)doubleValue;
		System.out.println(intValue);
		System.out.println(" ");
		
		//정수 타입의 연산
		byte result = 10+20;
		System.out.println(result);
		byte x = 10;
		byte y =20;
//		byte result1 = x+y;
		int result2 = x+y;
		System.out.println(result2);
		System.out.println(" ");
		
		byte value1 = 10;
		int value2 = 100;
		long value3 = 1000L;
		
		long result3 = value1 + value2 + value3;
		System.out.println(result3);
		System.out.println(" ");
		
		//실수 타입 
		int intV1 = 10;
		double doubleV1 = 22.2;
		double result4 = intV1 + doubleV1;
		System.out.println(result4);
		
		//여산에서 자동 타입변환
		byte byteValue1 = 10;
		byte byteValue2 = 20;
		
		int resultValue1 = byteValue1 + byteValue2;
		
		char charValue1 = 'A';
		char charValue2 = 1;
		int  resultValue2 = charValue1 + charValue2;
		
		System.out.println("유니코드 : "+resultValue2);
		System.out.println("츌력문자 : "+(char)resultValue2);
		System.out.println(" ");
		
		int intValue3 = 10;
		int intValue4 = intValue3/4;
		System.out.println(intValue4);
		double doubleValue1 = intValue3/4.0;
		System.out.println(doubleValue1);
		System.out.println(" ");
		
		int x1 = 1;
		int y1 = 2;
		
		double result1 = x1/y1;
		System.out.println(result1);
		System.out.println(" ");
		
		//문자열 결합
		int value = 11+22+33+44;
		System.out.println(value);
		
		String str1 = 10 + 2 + "3";
		System.out.println(str1);
		//123
		String str2 = 10 + "2"+3;
		System.out.println(str2);
		//1023
		String str3 = "10"+2+3;
		System.out.println(str3);
		//1023
		
		String str4 = "10"+2+8; //1010나오게 수정
		str4 = 8+2+"10";
		System.out.println(str4);
		System.out.println(" ");
		
		//기본 타입과 문자열간의 변환
		int var1 = Integer.parseInt("10");
		double var2 = Double.parseDouble("3.14");
		boolean var3 = Boolean.parseBoolean("true");
		
		System.out.println("int : "+var1);
		System.out.println("double: "+var2);
		System.out.println("boolean : "+var3);
		System.out.println("");
		
		String strValue1 = String.valueOf(10);
		String strValue2 = String.valueOf(3.14);
		String strValue3 = String.valueOf(true);
		
		System.out.println("strValue1 : "+strValue1);
		System.out.println("strValue2 : "+strValue2);
		System.out.println("strValue3 : "+strValue3);
		
		
		
		
		
		
	}

}
