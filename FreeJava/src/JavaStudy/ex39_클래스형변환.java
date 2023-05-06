package JavaStudy;

public class ex39_클래스형변환 {

//	public class car {
//		public void run() {
//			System.out.run();
//		}
//	}
//	
//	public class Bus extends Car {
//		public void ppangppang() {
//			System.out.println("빵빵");
//		}
	
	public static void main(String[] args) {
		Car c = new Bus();	// 부모 타입으로 자식객체를 생성할 수 있다. 
//		c.ppangppang();		// 그러나 부모 타입으로 자식 객체를 생성하면 부모 클래스에 있는 메소드만 사용할 수 있다. 

//		클래스 끼리도 형변환이 가능하다. 
//		기본 타입에서도 더 작은 객체에서 더 큰 객체로 형변환이 가능했듯이 클래스도 형변환이 가능하다. 
//		부모클래스가 더 큰 클래스이고 자식 클래스가 더 작은 클래스라고 생각할 수 있다. 
		
		Bus bus = (Bus)c;	// bus로 형 변환하기, Car 처음 참조한 객체가 bus여서 이것이 가능.
		bus.ppangppang();	// 만약 처음 생성했을 때 참조한 객체가 Bus가 아니었으면 불가능
	}

}
