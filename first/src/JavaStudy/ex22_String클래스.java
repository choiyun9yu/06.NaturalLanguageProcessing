package JavaStudy;

public class ex22_String클래스 {

	public static void main(String[] args) {
		// String 클래스는 문자열을 표현하는 자바에서 가장 많이 사용하는 클래스이다.
		// new라는 연산자를 이용하지 않고도 인스턴스를 만들 수 있다.
		// (그러나 다른 클래스는 new라는 연산자가 있어야 인스턴스 생성이 가능하다.)
		
		String str1 = "hello";	// 대신 new를 쓰지 않고 만들면, 상수영역에 값이 생성된다.
		String str2 = "hello"; 	// 즉, str1과 str2는 같은 인스턴스인 hello를 가르키고 있다.				
		
		
		String str3 = new String("hello");	// 그러나 new로 생성하면 상수영역이 아닌 힙영역에 값을 만든다.
		String str4 = new String("hello");	// 각각 만들기 때문에 str3와 str4가 서로 다른 인스턴스를 가르킨다.
		
		// 기본형일  == 연산자는 서로 같은지 나타내지만, 참조형인 경우에는 같은 주소를 참조하고 있는지 연산한다.
		if (str1==str2) {
			System.out.println("같은 레퍼런스 입니다.");
		}
		if (str3==str4) {
			System.out.println("같은 레퍼런스 입니다.");
		}
		
		// String 클래스 특징 한 번 생성된 클래스는 변하지 않는다.
		System.out.println(str1.substring(3)); 	// substring(n)은 n번째 문자열부터 출력하는 메소드
		System.out.println(str1);				// 스트링 내부 값이 변하지 않았음
												// String 클래스 메소드들이 새로운 값을 만들어서 반환하고 원래값 안건듬. 
				
				

	}

}
