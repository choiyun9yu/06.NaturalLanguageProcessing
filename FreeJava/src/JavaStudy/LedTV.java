package JavaStudy;

public class LedTV implements TV {

	@Override
	public void turnOn() {
		System.out.println("켰다.");
	}

	@Override
	public void turnOff() {
		System.out.println("껏다.");
	}

	@Override
	public void changeColumne(int volume) {
		System.out.println("볼륨변경");
	}

	@Override
	public void changeChannel(int channel) {
		System.out.println("채너변경");
	}

}
