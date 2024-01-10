package extends09.super2;

public class ClassC  extends ClassB {

    public ClassC() {
        super(10, 20);  // ClassC의 부모 클래스인 ClassB는 기본 생성자가 없다.(파라미터를 갖는 생성자를 정의 했기 때문)
        System.out.println("ClassC 생성자");
    }
}
