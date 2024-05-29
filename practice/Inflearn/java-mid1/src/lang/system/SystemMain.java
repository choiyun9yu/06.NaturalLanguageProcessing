package lang.system;

import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

public class SystemMain {

    public static void main(String[] args) {
        // 현재 시간(밀리초)
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("currentTimeMillis = " + currentTimeMillis);

        // 현재 시간(나노초)
        long currentTimeNano = System.nanoTime();
        System.out.println("currentNano = " + currentTimeNano);

        // 환경 변수 읽기 (운영체제가 사용하는 환경 변수)
        Map<String, String> getenv = System.getenv();
        System.out.println("getenv = " + getenv);

        // 시스템 속성 읽기 (자바가 사용하는 시스템의 환경)
        Properties properties = System.getProperties();
        System.out.println("properties = " + properties);
        System.out.println("Java version: " + properties.getProperty("java.version"));

        // 배열 고속 복사
        char[] originalArray = {'h', 'e', 'l', 'l', 'o'};
        char[] copiedArray = new char[5];
        System.arraycopy(originalArray, 0, copiedArray, 0, originalArray.length);   // 자바에서 루프돌면서 복사하는게 아니라 운영체제에서 통채로 복사한다.

        // 배열 출력
        System.out.println("copiedArray = " + copiedArray); // 배열은 그냥 출력하면 배열의 참조값이 나온다. [C@6b884d57 [ 이 배열이란 뜻, C 가 char 란 뜻, @ 이가 참조값이란 뜻 이다.
        System.out.println("Arrays.toString = " + Arrays.toString(copiedArray));

        // 프로그램 종료
        System.exit(0);

    }
}
