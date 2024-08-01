package generic.ex4;

import generic.animal.Dog;

public class MethodMain1 {

    public static void main(String[] args) {
        Integer i = 10;
        Object object = GenericMethod.objMethod(i);
        // integer 로 받고 싶으면 다운캐스팅 해야한다.
        // Integer result = (Integer) GenericMethod.objMethod(i);

        // 타입 인자(Type Argument) 명시적 전달
        System.out.println("명시적 타입 인자 전달");
        Integer result = GenericMethod.<Integer>genericMethod(i); // 제네릭은 타입 매개변수를 무슨 타입으로 할지 정해줘야 한다.
        Integer integerValue = GenericMethod.<Integer>numberMethod(10);
        Double doubleValue = GenericMethod.<Double>numberMethod(20.0);

    }
}
