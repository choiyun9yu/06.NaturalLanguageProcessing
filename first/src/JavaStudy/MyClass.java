package JavaStudy;

public class MyClass {
	
	// 1. 입력값도 없고 출력값도 없는 메소드 유형 
	public void method1() {
		System.out.println("m1이 실행됨..");
	}
	
	// 2. 정수 입력값 있고 출력값은 없는 메소드 유형
	public void method2(int x) {
		System.out.println(x + "를 이용한 m2가 실행됨..");
	}
	
	// 3. 입력값은 없지만 무언가를 수행해서 값을 출력하는 메소드 유형
	public int method3() {
		System.out.println("m3가 실행됨..");
		return 10;
	}
	
	// 4. 정수 입력값 2개 있고 리턴하지 않는 메소드 유형 
	public void method4(int x, int y) {
		System.out.println(x + "," + y + "를 이용한 m4가 실행됨..");
	}
	
	// 5. 정수를 받아서 정수를 출력하는 메소드 s유형 
	public int method5(int x) {
		System.out.println(x + "를 이용한 m5가 실행됨..");
		return x*10;
	}
}
