package JavaStudy;

import java.util.Scanner;

public class ex14_dowhile문 {

	public static void main(String[] args) {
		int value = 0;
		Scanner scan = new Scanner (System.in);
		
		do {
			//반복할 문장들
			value = scan.nextInt();
			System.out.println("입력받은 값 :"+value);
		} while(value != 10);
		
		System.out.println("반복문 종료!!");

	}

}
