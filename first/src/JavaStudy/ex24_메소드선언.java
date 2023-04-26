package JavaStudy;

public class ex24_메소드선언 {
	/**	객체지향언어 : 하나의 사물을 하나의 클래스로 설명한다.  
	 * 	사물은 상태와 행동을 가지고 있다. 필드가 물체의 상태라면 행동에 해당하는 것이 메소드이다. 
	 * 	메소드 : 입력값이 있고 일정한 처리 후 출력값을 내놓는다는 점에서 함수와 비슷하다. 
	 * 	이때, 입력값을 매개변수(파라미터), 인자(아큐먼트)라고 하고 출력값을 리턴값이라고 한다. 
	 *	매개변수 : 전달된 인자를 받아들이는 변수 
	 *	인자 : 어떤 함수를 호출시에 전달되는 값을 의미
	 */	
	
	// 메서드 : 클래스의 기능
	// public 리턴타입 메소드명 (매개변수들) { 구현 }
	
	// 1. 입력값도 없고 출력값도 없는 메소드 유형 
	public void method1() {
		System.out.println("m1이 실행됨..");
	}
	
	// 2. 정수 입력값 있고 출력값은 없는 메소드 유형
	public void method2(int x) {
		System.out.println(x+"를 이용한 m2가 실행됨..");
	}
	
	// 3. 입력값은 없지만 무언가를 수행해서 값을 출력하는 메소드 유형
	public int method3() {
		System.out.println("m3가 실행됨..");
		return 10;
	}
	
	// 4. 정수 입력값 2개 있고 리턴하지 않는 메소드 유형 
	public void method4(int x, int y) {
		System.out.println(x + y + "를 이용한 m4가 실행됨..");
	}
	
	// 5. 정수를 받아서 정수를 출력하는 메소드 유형 
	public int method5(int x) {
		System.out.println(x + "를 이용한 m5가 실행됨..");
		return x*10;
	}
	
	public static void main(String[] args) {
		
	}

}
