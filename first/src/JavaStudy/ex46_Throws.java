package JavaStudy;

public class ex46_Throws {
//	Throws : exception 처리를 무시하는 키워드, 오류를 내가 처리하는게 아니고 호출한 쪽에서 처리하라고 떠넘기는 것, 여러개 가능
//	thorows exception이라고 선언하면 어떤 오류도 호출한 쪽에서 처리하게 된다. 

	public static void main(String[] args) {
		int i = 10;
		int j = 0;
		try {
		int k = divide(i,j);
		System.out.println(k);
		}catch(ArithmeticException e) {
			System.out.println(e.toString());
		}
	}
	
	public static int divide(int i, int j) throws ArithmeticException, ClassCastException{
		int k = i/j;
		return k;
	}
}
