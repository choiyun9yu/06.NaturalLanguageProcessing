package JavaStudy;

public class ex05_TypeCastingExam {

	public static void main(String[] args) {
		/** 기본형 타입 변환   
		 *  byte < short, char < int < long < float < double 
		 *  더 작은 타입에서 큰 타입으론 가능
		 *  더 큰 타입에서 작은 타입으로 가능은하지만 들어있는 값 자체 더 큰 경우에는 불가능  
		 */
		
		int x = 50000;
		long y = x;  // 묵시형변환  

		long x2 = 5;
//		int y2 = x2;  큰 그릇에 있지만 작은 그릇에 담을 수 있는 경우 형변환으로 담음
		int y2 = (int) x2;  // 강제형변환 
		
	}
}
