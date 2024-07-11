package generic.ex1;

public class BoxMain2 {

    public static void main(String[] args) {
        ObjectBox integerBox = new ObjectBox();
        integerBox.set(10);
        Integer integer = (Integer) integerBox.get(); // 다운 캐스팅
        System.out.println("integer = " + integer);

        ObjectBox stringBox = new ObjectBox();
        stringBox.set("hello");
        String string = (String) stringBox.get();   // 다운 캐스팅
        System.out.println("string = " + string);

        // 잘못된 타입의 인수 전달시
        integerBox.set("문자100");
    }
}
