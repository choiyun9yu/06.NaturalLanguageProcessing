package JavaStudy;

public class MyClass2 {
//	메소드 오버로딩 : 매개변수의 수, 타입이 다른 경우 동이한 이름으로 메소드를 여러개 정의
	
//	1. 정수 2개 받아서 정수 하나 반환하는 메소드 
	public int plus(int x, int y) {
		return x + y;
	}
	
//	2. 정수 3개 받아서 정수 하나 반환하는 메소드  
	public int plus(int x, int y, int z) {
		return x + y + z;
	}
	
//	3. 문자열 2개 받아서 문자열 하나 반환하는 메소드 
	public String plus(String x, String y) {
		return x + y;
	}
}
