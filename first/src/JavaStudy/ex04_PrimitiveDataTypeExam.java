package JavaStudy;

public class ex04_PrimitiveDataTypeExam {

	public static void main(String[] args) {
	/** 기본형 타입  
	 *  논리형 bool	1byte
	 *  문자형 char	2byte 
	 *  정수형 short	2byte (-32,768 ~ 32, 767)
	 *  정수형 int    4byte (-2147483648 : 2147483647)
	 *  정수형 long   8byte 
	 *  실수형 float 	4byte (-3.4e038 ~ 3.4E038)
	 *  실수형 double	8byte (-1.7E308 ~ 1.7E308)
	 */
		
//		리터럴 : 데이터(값) 그 자체를 의미한다. 즉 변수에 넣는 변하지 않는 데이터를 의 
		boolean isFun = true;
		
		char c = 'f';  // (문자 하나만, 그리고 변수명은 소문자로)
	
		int x = 59;
		
		long bring = 345455433L;  // (롱 타입은 L을 마지막에 붙여줘야함)
		
		float f = 32.4f;  // (뒤에f 표시해줘야)
		
		double d = 344454.5;  // float 보다 더 큰 실수 표현하고 싶을 때 사용 
		
	}

}
