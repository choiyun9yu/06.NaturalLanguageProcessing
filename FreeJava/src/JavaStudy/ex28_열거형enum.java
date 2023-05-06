package JavaStudy;

public class ex28_열거형enum {

	public static final String MALE = "MALE";	// final은 상수를 선언할 때 씀(변수명을 전체 대문자로 쓰는게 관례)
	public static final String FEMALE = "FEMALE";
	
	public static void main(String[] args) {
		String gender1;		// gender1 MALE or FEMALE만 넣고 싶은데 스트링이라 아무거나 들어갈 수 있음
		gender1 = ex28_열거형enum.MALE;
		gender1 = ex28_열거형enum.FEMALE;
		gender1 = "boy"; 	// 이런 문제가 발생하지 않게하기 위해 열거형 사용한다.
		
		Gender gender2;
		gender2 = Gender.MALE;
		gender2 = Gender.FEMALE;
//		gender2 = "boy";	// 정의하지 않은 값 넣으면 컴파일 오류 발생 
//							   즉, 열거형은 특정 타입만 쓰고 싶을 때 사		
	}

}
// 열거형 선언 
// enum 열거명 { 들어게하고싶은 타입1, 타입2 ... }

enum Gender{
	MALE,FEMALE;
}