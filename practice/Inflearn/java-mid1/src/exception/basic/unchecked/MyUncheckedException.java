package exception.basic.unchecked;


/*
 * RuntimeException 을 상속받은 예외는 언체크 예외가 된다.
 */
public class MyUncheckedException  extends RuntimeException {
    public MyUncheckedException(String message) {
        super(message);
    }
}
