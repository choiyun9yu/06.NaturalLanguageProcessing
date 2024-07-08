package exception.basic.checked;

public class Client {
    public void call() throws MyCheckedException {  // throws 는 예외 발생시 던지는 것
        // 문제 상황 발생
        throw new MyCheckedException("ex"); // throw 는 예외 발생 시키는 것
    }
}
