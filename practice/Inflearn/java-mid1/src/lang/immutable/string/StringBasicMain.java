package lang.immutable.string;

public class StringBasicMain {

    public static void main(String[] args) {
        // 데이터 타입  int, double, boolean 등은 소문자로 시작하며 기본형 데이터 타입이다.
        String str1 = "hello";
        // 그러나 대문자로 시작하는 데이터 타입들은 객체 즉, 참조형 데이터 타입이다.
        String str2 = new String("hello");

        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);
    }
}
