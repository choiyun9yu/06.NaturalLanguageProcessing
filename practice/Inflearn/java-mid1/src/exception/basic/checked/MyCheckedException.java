package exception.basic.checked;

/*
 * Exception 을 상속 받는 예외는 체크 예외가 된다.
 */
public class MyCheckedException extends Exception {
    public MyCheckedException(String message) {
        super(message); // 부모클레스에 메시지 보관?
    }
}
