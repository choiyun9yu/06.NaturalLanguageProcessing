package JavaStudy;

public class ex32_생성자오버로딩과this {
//	생성자 오버로딩 : 매소드와 마찬가지로 매개변수의 수와 타입이 다르다면 여러개의 생성자를 선언할 수 있다.
	
	
	public static void main(String[] args) {
		Car c1 = new Car();
		Car c2 = new Car("소방차");
		Car c3 = new Car("구급차", 1111);
	}

}
