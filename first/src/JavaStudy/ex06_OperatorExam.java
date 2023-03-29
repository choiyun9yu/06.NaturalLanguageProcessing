package JavaStudy;

public class ex06_OperatorExam {

	public static void main(String[] args) {
		/** 연산자  
		 *  부호 연산자(+, -)
		 *  산술 연산자(+, -, *, /, %)
		 *  증감 연산자(++, --)
		 *  피연산자가 1개인 연산자를 단항연산자라고 한다 (부호, 증감 연산)
		 */
		
//		부호 연산자 
		int i1 = -5; 
		int i2 = +i1;
		int i3 = -i1;
		
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(i3);
		
//		증감 연산자
		int i4 = ++i3;  // i3 = i3+1;
		System.out.println(i4);
		System.out.println(i3);
		// 증감연산자가 뒤에 있으면 먼저 대입한 후 대입된 것말고 대입되 것에 증감을 해준다.		
		int i5 = i3++;  // i3 = i3+1;
		System.out.println(i5);
		System.out.println(i3);
		
//		산술 연산자
		int i = 5;
		int j = 2;
		System.out.println(i+j);
		System.out.println(i-j);
		System.out.println(i*j);
		System.out.println(i/j);  // 정수끼리 나누면 정수만 출력된다.
		System.out.println(i/(float)j);  // 실수값을 알고 싶으면 둘 중하나는 실수여야 한다.
		System.out.println(i%j);  // 나머지 연산자 
		
	}
	
}
