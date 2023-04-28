package JavaStudy;

public class ex34_상속 {
//	상속은 부모 클래스가 가지고 있던것을 자식이 사용할 수 있게 되는 것
// 	그러나 부모는 자식클래스가 가지고 있는 것을 사용할 수 없다. 
	
//	public class Car {
//		public void run() {
//			System.out.println("달리다.");
//		}
//	}
//	
//	public class Bus extends Car {
//	}

	public static void main(String[] args) {
		Bus bus = new Bus();
		bus.run();

	}

}
