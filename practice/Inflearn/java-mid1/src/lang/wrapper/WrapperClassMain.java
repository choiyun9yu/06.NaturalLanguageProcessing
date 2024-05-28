package lang.wrapper;

public class WrapperClassMain {

    public static void main(String[] args) {
        Integer newInteger = new Integer(10);   // 미래에 삭제 예정, 대신에 valueOf() 사용, -128 ~ 127 는 자바가 미리 만들어 둬서 new 로 새로 만들지 말 것을 권장
        Integer integerObj = Integer.valueOf(10);   // Integer integerObj = 10; 과 같음,
        Long longObj = Long.valueOf(100);
        Double doubleOjb = Double.valueOf(10.5);

        System.out.println("newInteger = " + newInteger.toString());    // toString() 이 기본적으로 오버라이딩 되어 있음
        System.out.println("integerObj = " + integerObj);
        System.out.println("longObj = " + longObj);
        System.out.println("doubleOjb = " + doubleOjb);

        System.out.println("내부 값 읽기");
        int intValue = integerObj.intValue();
        System.out.println("intValue = " + intValue);
        long longValue = longObj.longValue();
        System.out.println("longValue = " + longValue);

        System.out.println("비교");
        System.out.println("==: " + (newInteger == integerObj));    // false, 참조값이 달라서 false, 미리 만들어 둔 valueOf 로 만드 경우 참조값이 같아서 true
        System.out.println("equals( ): " + (newInteger.equals(integerObj)));    // true
    }
}
