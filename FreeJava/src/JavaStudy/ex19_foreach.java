package JavaStudy;

public class ex19_foreach {

	public static void main(String[] args) {
		// Java 1.5버전 부터 for each 추가되었음
		int [] iarr = {10,20,30,40,50};
		
		// 일반 for
		for (int i = 0; i < iarr.length; i++) {
			int value = iarr[i];
			System.out.println(value);
		}
		// for each문 파이썬에서 리스트에서 반복문 돌리는 것과 같
		for (int value:iarr) {
			System.out.println(value);
		}
			
	}

}
