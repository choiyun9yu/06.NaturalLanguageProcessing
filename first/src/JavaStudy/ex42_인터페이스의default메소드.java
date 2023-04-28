package JavaStudy;

public class ex42_인터페이스의default메소드 {
	
//	기존에는 인터페이스가 추상메서드만 가질 수 있엇다. 
//	그러나 Java8 부터 default method와 static method도 가질 수 있다.  
//	defaul라는 키워드로 인터페이스에서도 구현할 수 있음 
	
//	public interface Calculator {
//		public int plus(int x, int y);
//		public int minus(int x, int y);
//		default int multiple(int x, int y) {
//			return x*y ;
//		}
//		public static int div(int x, int y) {
//			return x/y;
//		}
//	}
	
//	public class CasioCal implements Calculator {
//		@Override
//		public int plus(int x, int y) {
//			return x+y;
//		}
//		@Override
//		public int minus(int x, int y) {
//			return x-y;
//		}
//	}

	public static void main(String[] args) {
		Calculator cal = new CasioCal();
		System.out.println(cal.plus(3, 4));
		System.out.println(cal.minus(4, 3));
		System.out.println(cal.multiple(2, 3));
		
//		인터페이스의 스태틱은 반드시 인터페이스명.메소드 형식으로만 호출해야한다. 
//		cal.did(4, 2);
		System.out.println(Calculator.div(4, 2));

	}

}
