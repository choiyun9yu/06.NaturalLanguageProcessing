package JavaStudy;

public class ex07_OperatorExam4 {

	public static void main(String[] args) {
//		비교 연산자의 결과 boolean 값

		int i = 10;
		int j = 10;
		
		System.out.println(i == j);
		System.out.println(i != j );
		System.out.println(i < j );
		System.out.println(i <= j );
		System.out.println(i > j );
		System.out.println(i >= j );
	
		i += 10; // 복합 대입 연산
		System.out.println(i);
		System.out.println(i -= 5);  // 복합 대입 연산
		System.out.println(i);
		
	}

}
