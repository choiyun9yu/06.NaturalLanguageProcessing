package JavaStudy;

public class ex08_연산자우선순위 {
	
	public static void main(String[] args) {

		int a = 5;
		int b = 10;
		int c = 15;
		
//	 	1. 최우선 연산자 . [] ()
		
//		2. 단항 연산자 ++ -- ! ~ +/- :
		System.out.println(++a - 5);
		System.out.println(a);
		
		a = 5;
		
		System.out.println(a++ - 5);
		System.out.println(a);		
//		3. 산술 연산 * / % > _ - > shift 시프트 연산자 >> << >>>
		
//		4. 비교 연산자
		
//		5. 비트 연산자 & | ^ ~
		
//		6. 논리 연산자 && || > ! (and 연산자가 or보다우선순위가 높)
		
//		7. 삼항 연산자
	
//		8. 대입 연산 = *= /= %= += -=
	}

}
