package JavaStudy;

public class ex37_super와부모생성자 {

//	자신을 가르키는 게 this 였다면 부모를 가르키는 건 super다. 부모 생성자는 super();로 호출 
//	그러나 부모 클래스에 기본 생성자가 없다면 자식 클래스에서 부모의 생성자에 파라미터를 넣어서 호출하는 내용을 반드시 삽입해야한다.  
	
	
//		public class Car {
//		public Car() {
//			System.out.println("Car의 기본생성자입니다.");
//		}

//	public class Truck extends Car {
//		public Truck() {
//			System.out.println("Truck의 기본생성자 입니다.");
//		}
//	}
	
	public static void main(String[] args) {
		Truck t = new Truck();	// 객체가 실행될 때 생성자를 실행하고 객체가 실행된다.
								// 자식 생성자가 생성되기 전에 부모의 생성자가 먼저 생성되어야 한다! (부모가 있어야 자식이 날수있음)
	}

}
