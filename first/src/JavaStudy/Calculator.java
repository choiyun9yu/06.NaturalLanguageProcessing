package JavaStudy;

public interface Calculator {
	public int plus(int x, int y);
	public int minus(int x, int y);
	
	default int multiple(int x, int y) {
		return x*y ;
	}
	public static int div(int x, int y) {
		return x/y;
	}
}
