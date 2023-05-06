package JavaStudy;

public class ex36_추상클래스 {
//	추상클래스 : 범위가 넓고 모호한 개념 새, 음식, 이런 것들은 부모역할은 수행할 수 있지만 객체는 되지 못한다.
//	구체적인 클래스만 객체가 될 수 있다. 
	
//	public abstract class Bird {	
//			중괄호는 구현되었다고 보는데 이건 구현된건 아니니까 중괄호 사용X
//			추상 메소드는 abstract를 붙여준다. 
//			클래스의 메소드중 하나라도 추상 메소드이면 그 클래스는 전체가 추상 클래스로 봐서 클래스 앞에도 abstract 붙여준다. 
//		public abstract void sing(); 
//			그러나 추상 클래스가 추상 메소드만 갖는 것은 아니다 일반 클래스도 가질 수 있다.
//		public void fly() {
//			System.out.println("날다.");
//		}
//	}
	
//	public class Duck extends Bird {
//		@Override
//		public void sing() {
//			System.out.println("꽥꽥!!");
//		}//
//	}

	public static void main(String[] args) {
		Duck duck = new Duck();
		duck.sing();
		duck.fly();
		
//		Bird b = new Brid();	추상 클래스는 부모로서 역할은 가능하지만 객체를 생성할순 없다.

	}

}
