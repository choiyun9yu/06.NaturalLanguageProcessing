package JavaStudy;

public class ex15_for문 {

	public static void main(String[] args) {
		int total = 0;
		for (int i=1; i<=100; i++) {
//			if (i % 2 != 0) {
//				continue;			//continue는 지금 반복 스킵하고 다음 반복으로 넘어가
//			}
			total = total + i;
			if(i ==50) {
				break;				//break는 반복문을 그만하기
			}
		}
		
		System.out.println(total);
	}

}
