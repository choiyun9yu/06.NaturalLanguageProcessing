package nested.local;

import java.lang.reflect.Field;

public class LocalOuterV3 {

    private int outInstanceVar = 3;

    public Printer process(int paraVar) {

        int localVar = 1;   // 지역 변수는 스택 프레임이 종료되는 순간 함께 제거된다.

        class LocalPrinter implements Printer {
            int value = 0;

            @Override
            public void print() {
                System.out.println("value = " + value);

                // 인스턴스는 지역 변수보다 더 오래 살아남는다.
                System.out.println("localVar = " + localVar);
                System.out.println("paraVar = " + paraVar);
                System.out.println("outInstanceVar = " + outInstanceVar);
            }
        }

        LocalPrinter printer = new LocalPrinter();
        // localPrinter.print(); 를 여기서 실행하지 않고 Printer 인스턴스만 반환한다.
        return printer; // LocalPrinter 클래스는 Printer 인터페이스의 구현체라서 LocalPrinter 클래스를 반환해도 Printer 를 반환하는 것으로 인정해줌.
    }

    public static void main(String[] args) {
        LocalOuterV3 localOuter = new LocalOuterV3();
        Printer printer = localOuter.process(2);
        // printer.print() 를 나중에 실행한다. process() 의 스택 프레임이 사라진 이후 실행
        printer.print();

        // 추가
        System.out.println("필드 확인");
        Field[] fields = printer.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println("field = " + field);
        }
    }
}
