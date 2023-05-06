package JavaStudy;

public class CasioCal implements Calculator {
	@Override
	public int plus(int x, int y) {
		return x+y;
	}
	@Override
	public int minus(int x, int y) {
		return x-y;
	}
}
