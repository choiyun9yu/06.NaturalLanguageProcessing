package JavaStudy;

import java.util.Scanner;

public class ex14_dowhile문 {

	public static void main(String[] args) {
		int value = 0;
		Scanner scan = new Scanner (System.in);		// Scanner클래스는 값을 입력받고 싶을 때 사용, 
													// System.in은 키보드로 부터 입력을 의미
		
		do {
			//반복할 문장들
			value = scan.nextInt();					// nextInt()는 정수값을 입력받는 메소드
			System.out.println("입력받은 값 :"+value);
		} while(value != 10);
		
		System.out.println("반복문 종료!!");

	}

}
