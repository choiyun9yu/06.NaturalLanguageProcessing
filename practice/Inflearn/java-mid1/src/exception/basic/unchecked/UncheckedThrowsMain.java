package exception.basic.unchecked;

public class UncheckedThrowsMain {

    public static void main(String[] args) {
        Service service = new Service();
        service.callThrow();
        System.out.println("정상 종료");
    }
}
