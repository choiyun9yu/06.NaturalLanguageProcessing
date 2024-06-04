package nested.nested;

public class NestedOuterMain {

    public static void main(String[] args) {
        NestedOuter outer = new NestedOuter();
        NestedOuter.Nested nested = new NestedOuter.Nested();
        nested.print();

        System.out.println("nestedClass = " + nested.getClass());   // nestedClass = class nested.NestedOuter$Nested 자바에서는 내부 안쪽 클래스를 $ 표시로 구분한다.

    }
}
