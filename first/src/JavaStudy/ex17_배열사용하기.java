package JavaStudy;

public class ex17_배열사용하기 {

	public static void main(String[] args) {
		int [] iarray = new int[100];
		iarray[0] = 1;
		iarray[1] = 2;
		
		for (int i=0; i<iarray.length; i++) {
			iarray[i] = i+1;
		}
		
		int sum = 0;
		for (int i=0; i<iarray.length; i++) {
			sum += iarray[i];
		}
		System.out.println(sum);
	}

}
