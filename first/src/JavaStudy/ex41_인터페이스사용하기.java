package JavaStudy;

public class ex41_인터페이스사용하기 {

//	public interface TV {
//		public int MIN_VOLUME = 0;
//		public int MAX_VOLUME = 100;
//		public void turnOn();	 
//		public void turnOff();
//		public void changeColumne(int volume);
//		public void changeChannel(int channel);
	
//	public class LedTV implements TV {				// 인터페이스에선 extends 대신 implements 사용한다. 
//		@Override
//		public void turnOn() {
//			System.out.println("켰다.");
//		}
//
//		@Override
//		public void turnOff() {
//			System.out.println("껏다.");
//		}
//
//		@Override
//		public void changeColumne(int volume) {
//			System.out.println("볼륨변경");
//		}
//
//		@Override
//		public void changeChannel(int channel) {
//			System.out.println("채너변경");
//		}
//	}
	
//	인터페이스 구현에서 모든 메소드 구현해야지 된다. 
		
	public static void main(String[] args) {
		TV tv = new LedTV();
		tv.turnOn();
		tv.turnOff();

	}

}
