package JavaStudy;

public class Car {
	// 타입 필드
	String name;
	int number;
	
	public Car() {
//		같은 코드를 반복해서 적기보다는 자기자신 생성자로 코드 중복 줄일 수 있음 
//		this.name ="이름없음";
//		this.number = 0; 
		
//		this()는 자기자신의 생성자 의미, super()은 부모 생성자 의미
		this("이름없음",0);
		System.out.println("Car의 기본생성자입니다.");
	}
	
	public Car(String name) {
//		name = name;	// 컴파일러는 자기랑 가까운 name으로 생각해서 String과 매개변수를 구분하지 못한다.
		this.name = name; // 대신 this를 써주면 클래스에서 선언한 name임을 알 수 있다.
	}
	
	public Car(String name, int num) {
		this.name = name;
		this.number = num;
	}
	
	public void run() {
		System.out.println("달리다.");
	}
}