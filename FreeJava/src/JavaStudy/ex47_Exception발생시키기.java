package JavaStudy;

public class ex47_Exception발생시키기 {
//	Throw : 강제로 오류를 발생시킴 

	public static void main(String[] args) {
		int i = 10;
		int j = 0;

		try {
		int k = divide(i,j);
		System.out.println(k);
		}catch(IllegalArgumentException e) {
			System.out.println(e.toString());
		}
	}
	
	public static int divide(int i, int j) throws IllegalArgumentException{
		if(j == 0) {
//			System.out.println("2번째 매개변수는 0이면 안됩니다.");
//			return 0;	// 잘못된 값이 출력되는 것도 문제 
			throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
		}
		int k = i/j;
		return k;
	}
}