package JavaStudy;

public class ex21_참조타입 {

	public static void main(String[] args) {
		/** 자바의 변수 타 
		 *  기본형 타입 : 논리형, 문자형, 정수형, 실수 (기본형 타입은 클래스가 아님)
		 *  참조형 타입 : 기본형 타입을 제외한 모든 데이터 타입 (클래스도, 배열도 참조형 타입)
		 */
		
		int i = 4;
		
		String str = new String("hello"); 	// 참조한다, 레퍼런스한다는 것은 변수가 인스턴스를 가지고 있는 것이 아니다.
											// str은 메모리 어딘가에 로드된 hello를 참조하고 있을 뿐이다.
											// str이란 변수에는 메모리의 위치값이 저장된어 있을 뿐이다.

	}

}
