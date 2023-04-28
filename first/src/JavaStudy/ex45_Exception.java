package JavaStudy;

public class ex45_Exception {
//	예외처리 : 예기치 못한 예외상황 처리 try-catch-finally
	
//	try {
//		수행할코드, 예외발생 가능성이 있는 블록 
//		예외 발생 이전까지 실행되고 이후는 캐치블록으로 넘김 
//	}catch(예외클래스 변수명) {
//		발생한 예외와 내가 선언해놓은 예외와 같은 경우 캐치블록 실행
//		catch 블록 여러개 사용 가능 
//		exception 클래스 사용하면 어떤 오류든지 처리하는 블록생성 가능 
//	}finally {
//		파이널리블록은 존재하면 예외 실행하든 안하든 무조건 실행되는 블록 
//	}
	

	public static void main(String[] args) {
		int i = 10;
		int j = 0;
		
		try {
		int k = i/j;					// 정수를 0으로 나눌 때 에러 발생시킨다.  <- 예기치못한 예외 상황
		System.out.println(k);
		}catch(ArithmeticException e){
			System.out.println("0으로 나눌 수 없습니다."+e.toString());	
									   // 예외크래스변수명.toString()" 예외의 정보 알려주는 메소드 
		}finally{
		System.out.println("main end!!");
		}
	}
}
