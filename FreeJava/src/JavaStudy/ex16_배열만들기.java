package JavaStudy;

public class ex16_배열만들기 {

	public static void main(String[] args) {
		int[] array1 = new int[100];	// 배열은 자료형[] 으로 선언, 배열은 new를 통해 생성해야함
		
		array1[0] = 50;		// 인덱스는 0부터 시작, 값을 지정하지 않았다면 0으로 초기화되어 있음
		array1[90]= 100;
		
		int[] array2 = new int[] {1,2,3,4};	// 개수를 선언하지 않고 값을 적은 경우 값의 개수만큼 배열이 만들어짐 
		
		int[] array3 = {1,2,3,4}; 	// 이렇게 선언할수도 있음 
		
		System.out.println(array3[3]);
	}

}
