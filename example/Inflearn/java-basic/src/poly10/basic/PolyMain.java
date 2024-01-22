package poly10.basic;

import java.sql.SQLOutput;

public class PolyMain {

    public static void main(String[] args) {
        // 부모 타입 변수가 부모 인스턴스 참조
        System.out.println("Parent -> Parent");
        Parent parent = new Parent();
        parent.parentMethod();

        // 자식 변수가 자식 인스턴스 참조
        System.out.println("Child -> Child");
        Child child = new Child();
        child.parentMethod();
        child.childMethod();

        // 부모 변수가 자식 인스턴스 참조(다형적 참조)
        System.out.println("Parent -> Child");
        Parent poly = new Child();  // poly는 부모타입인데 자식 타입을 넣었다.
        poly.parentMethod();

        // 그러나 자식은 부모를 담을 수 없다.
        // Child child1 = new Parent();

        // 부모 타입 선언된 변수의 child 인스턴스로는  childMothod는 호출할 수 없다.
        // poly.childMethod();      // Parent에는 상속 받은 객체에 대한 어떠한 정보도 없으므로 본인만 호출할 수 있다.

    }
}
