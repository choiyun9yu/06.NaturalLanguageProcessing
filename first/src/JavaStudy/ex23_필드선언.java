package JavaStudy;

public class ex23_필드선언 {
	// 필드 : 클래스가 가지고 있는 속성 학생 클래스의 학번, 이름 같은 것이 속성
	// 타입 필드명; 으로 선언
	
//public class Car{
//	String name;
//	int number;
//}
	
	public static void main(String[] args) {
		Car c1 = new Car();
		Car c2 = new Car();
	
		c1.name = "소방차";	// 참조변수 다음에 나오는 . 은 참조변수가 가지고 있는 것을 사용할 때 표시
		c1.number = 1234;
		
		c2.name = "구급차";
		c2.number = 5678;

		System.out.println(c1.name);
		System.out.println(c1.number);
	}

}
