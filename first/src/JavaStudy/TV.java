package JavaStudy;

public interface TV {
//	인터페이스에선 final 쓰지않고 상수 설정해서 사용할 수 있다.
	public int MIN_VOLUME = 0;
	public int MAX_VOLUME = 100;
	
	public void turnOn();		// interface 는 abstract 붙이지 않아도 된다. 인터페이스 자체가 구현안하기 때문에 
	public void turnOff();
	public void changeColumne(int volume);
	public void changeChannel(int channel);
}
