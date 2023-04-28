package JavaStudy;

public class BizException extends RuntimeException {
//	이미 부모클래스에 해당 생성자 있기 때문에 전달만 해주면 됨 
	public BizException(String msg) {
		super(msg);
	}
	public BizException(Exception ex) {
		super(ex);
	}
}
