package JavaStudy;

public class ex27_변수의scope와static {

//	변수의 사용 범위 : 일반적으론 변수가 선언된 블록{ } 
	int globalScope = 10;	// 클래스 블록 안에서 선 되었으니까 클래스 안 어디서든 참조 가능
	
//	static한 변수 설정
	static int staticVal = 7;
	
	public void scopeTest(int value) {
		int localScope = 20;	// 메소드 블록 안에서 선언했으니까 이 메소드 안에서만 사용 가능 
		System.out.println(globalScope);
		System.out.println(localScope);
		System.out.println(value);	// 비록 메소드 밖에 존재하는 값이지만 매개변수로 받아서 사용 가능 
	}
	
	public void scopeTest2(int value2) {
		System.out.println(globalScope);
//		System.out.println(localScope);	 
	}
	
	public static void main(String[] args) {
//		같은 클래스 블록 안에 있어도 main안에서 사용하지 못함
//		이유는 static 때문 -> 모든 클래스는 인스턴스화 하지 않은채로 사용할 수 없다.
//		static은 class가 인스턴스화 하지 않아도 사용할 수 있다.
//		따라서 static한 영역안에서 static하지 않은 것을 사용하려하면 
//		static하지 않은 것이 인스턴스화 되기전에 호출되 수 있어서 사용 못
//		
//		System.out.println(globalScope);
//		System.out.println(localScope);
//		System.out.println(value);	
		
		System.out.println(staticVal);
		
//		static하지 않은 객체를 사용하려면 객체를 new로 생성하고 사용해야한다.
		ex27_변수의scope와static v1 = new ex27_변수의scope와static();
		System.out.println(v1.globalScope);
		
		ex27_변수의scope와static v2 = new ex27_변수의scope와static();
		
//		인스턴스 내부 변수명이 같아도 인스턴스가 다르면 다른 객체 
		v1.globalScope = 10;
		v2.globalScope = 20;
		System.out.println(v1.globalScope);
		System.out.println(v2.globalScope);
		
//		그러나 스태틱은 객체가 달라도 변수명이 같으면 같은 곳을 참조한다.
		v1.staticVal = 50;
		v2.staticVal = 100;
		System.out.println(v1.staticVal);
		System.out.println(v2.staticVal);
	}
	
}
