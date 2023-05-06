package JavaStudy;

public class ex29_생성자 {
	
//	생성자 선언
//	public class 클래스명 {				// 리턴 타입을 입력하지 않는다.
//		public 클래스명(매개변수 목록) {		// 매개변수 목록을 비워두면 기본 생성자이다. 
//			...							// 생성자를 따로 명시하지 않으면 컴파일러가 기본 생성자를 만든다. 
//										// 사용자가 생성자를 하나라도 만들면 기본 생성자는 컴파이러가 만들지 않는다.
//		}
//	}

	public static void main(String[] args) {
//		Car c1 = new Car();			
		Car c2 = new Car("소방차");

		System.out.println(c2.name);
	}

}
