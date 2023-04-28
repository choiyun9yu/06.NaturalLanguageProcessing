package JavaStudy;

public class ex38_오버라이딩 {
//	오버라이딩 : 부모가 가지고 있는 메서드와 똑같은 모양의 메서드를 가지고 있는 것 
//	부모가 물려준 메소드를 자식클래스에서 재정의해서 사용하는 것 
	
//	public class Car {
//		public void run() {
//			System.out.println("달리다.");
//		}
//	}

//	public class Bus extends Car {
//		public void run() {
//			super.run();	슈퍼를 이용해 부모의 메소드를 사용할 수 있다. (오버라이딩해도 사라지지 않는다.)
//			System.out.println("버스 달리다.");
//		}
//	}
	
	
	public static void main(String[] args) {
		Bus bus = new Bus();
		bus.run();
	}
}
