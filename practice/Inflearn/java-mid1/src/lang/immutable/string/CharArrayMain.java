package lang.immutable.string;

public class CharArrayMain {

    public static void main(String[] args) {
        // char 는 문자 하나만 다룰 수 있다.
        char a = '가';
        System.out.println(a);

        // 문자 여러개를 다루기 위해서는 char[] 배열을 사용해야 한다.
        char[] charArr = new char[]{'h', 'e', 'l', 'l', 'o'};
        System.out.println(charArr);

        // String 을 사용하면 편하다.
        String str = "hello";
        System.out.println(str);
    }
}
