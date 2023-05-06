package JavaStudy;

public class ex26_String클래스의메소드 {
	
	

	public static void main(String[] args) {
//		String str = new String("hello");
		String str = "hello";
		
//		1. length() : 문자열 길이 나타내는 메소드(공백도 카운트함) 
		System.out.println(str.length());
		
//		2. concat() : 문자열 결합해주는 메소드 
		System.out.println(str.concat(" world"));	// 새로운 hello world라는 객체를 만들어서 출력하는 
		System.out.println(str);	// concat을 해도 String클래스는 바뀌지 않는다 (참조오류가 발생할 수 있기 때문에) > 불변 클래스
		str=str.concat(" world");	// 이렇게 assign 해줘야지만 str이 가리키는 것이 변한다.
		
//		3. substring() : 문자열 해당 인덱스 이상 출
		System.out.println(str.substring(3));		// 인자 한 개 넣은 경우 
		System.out.println(str.substring(3, 6));	// 인자 두 개 넣은 경우 
	}

}
