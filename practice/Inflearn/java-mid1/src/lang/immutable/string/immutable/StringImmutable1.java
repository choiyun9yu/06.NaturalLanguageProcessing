package lang.immutable.string.immutable;

public class StringImmutable1 {

    public static void main(String[] args) {
        String str1 = "hello";
        str1.concat("java");
        System.out.println(str1);    // hello 출력

        String str2 = "hello";
        String result = str2.concat(" java");
        System.out.println(result);    // hellojava 출력
    }
}
