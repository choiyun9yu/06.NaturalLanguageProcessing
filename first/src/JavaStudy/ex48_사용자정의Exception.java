package JavaStudy;

public class ex48_사용자정의Exception {
//	Exception 클래스 이미 자바에서 정리해놓은 것 사용할 수 있고 사용자가 직접 정의해서 사용할 수 도 있다.
//	public class 클래스이름 extends Exception{
//	}

//	Exception이나 Exception의 후손을 상속받아 만들어진 클래스
//	클래스의 이름만으로 어떤 오류가 발생했는지 알려주어 코드의 직관성을 높이기 위함 
	
//	Exception을 상속받은 것을 Checked Exception이라고 하고 예외처리하지 않으면 컴파일 에러 발생한다. 
	
//	그 외 Runtime Exception은 예외처리하지 않아도 컴파일상에선 에러가 발생하지 않는다. 그리고 이걸 Unchecked Exception이라 한다.  
//	그러나 모든 예외상황에 대해서는 적잘한 처리를 해주는 것이 프로그램 수행에 안정적이다. 
	
//	public class BizException extends RuntimeException {
//		이미 부모클래스에 해당 생성자 있기 때문에 전달만 해주면 됨 
//		public BizException(String msg) {
//			super(msg);
//		}
//		public BizException(Exception ex) {
//			super(ex);
//		}
//	}
	
//	public  void bizMethod(int i) throws BizException{
//		System.out.println("비즈니스 메소드 시작");
//		if(i<0)
//			throw new BizException("매개변수 i는 0이상이어야 합니다.");
//		System.out.println("비즈니스 메소드 종료");
//	}

	public static void main(String[] args) {
		BizService biz = new BizService();
		biz.bizMethod(5);
		try {
			biz.bizMethod(-3);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
