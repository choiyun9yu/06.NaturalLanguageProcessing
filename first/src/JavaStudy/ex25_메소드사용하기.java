package JavaStudy;

public class ex25_메소드사용하기 {

	public static void main(String[] args) {
		// 메서드를 사용하기 위해서는 메소드가 정의된 클래스를 먼저 생성해야한다.
		MyClass obj = new MyClass();
		obj.method1();
		obj.method2(2);
		int value3 = obj.method3();
		obj.method4(1, 4);
		int value5 = obj.method5(5);
		
		System.out.println(value3);
		System.out.println(value5);
	}

}
