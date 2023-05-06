package JavaStudy;

public class ex11_삼항연산자 {

	public static void main(String[] args) {
		int b1 = (5 < 4) ? 50 : 40;  // (조건) ? 참일 때 실행 : 거짓일 때 실행;
		
		System.out.println(b1);
		
		int b2 = 0;
		
		if(5 > 4) {
			b2 = 50;
		}else {
			b2 = 40;
		}
		
		System.out.println(b2);
	}

}
