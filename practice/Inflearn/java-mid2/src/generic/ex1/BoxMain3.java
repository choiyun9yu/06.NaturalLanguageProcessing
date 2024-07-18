package generic.ex1;

public class BoxMain3 {

    public static void main(String[] args) {
        GenericBox<Integer> integerBox = new GenericBox<Integer>(); // 생성 시점에 T의 타입 결정
        integerBox.set(10); // T의 타입을 integer 로 정의 했기 때문에 inter 만 입력 가능
        // integerBox.set("10");    // 타입 안정성 상승
        Integer integer = integerBox.get(); // 더불어 다운 캐스팅 할 필요 없음
        System.out.println("integer = " + integer);

        // 생성 시점에 타입을 결정하기 때문에 코드 재사용성(다형성) 상승
        GenericBox<String> stringBox = new GenericBox<String>();
        stringBox.set("Hello");
        String str = stringBox.get();
        System.out.println("str = " + str);

        // 원하는 모든 타입 사용 가능
        GenericBox<Double> doubleBox = new GenericBox<Double>();
        doubleBox.set(10.5);
        Double doubleValue = doubleBox.get();
        System.out.println("doubleValue = " + doubleValue);

        // 타입 추론: 생성하는 제네릭 타입 생략 가능
        GenericBox<Integer> integerBox2 = new GenericBox<>();
    }
}
