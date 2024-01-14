package scanner;

import java.util.Scanner;

public class Scanner1 {
    public static void main(String[] args) {
        // System.in을 사용해서 사용자 입력을 편리하게 도와주는 객체 생성
        Scanner scanner = new Scanner(System.in);

        // 문자열 입력:
        // scanner.NextLine() : 엔터를 입력할 때 까지 문자를 가져온다.
        System.out.print("문자열을 입력하세요: ");
        String str = scanner.nextLine();        // 입력을 String으로 가져온다.
        System.out.println("입력한 문자열: " + str);

        // 정수 입력
        // scanner.NextInt() : 엔터를 입력할 때 까지 정수를 가져온다.
        System.out.print("정수를 입력하세요: ");
        int intValue = scanner.nextInt();
        System.out.println("입력한 정수: " + intValue);

        // 실수 입력
        // scanner.NextDouble() : 엔터를 입력할 때 까지 실수를 가져온다.
        System.out.print("정수를 입력하세요: ");
        double doubleValue = scanner.nextDouble();
        System.out.println("입력한 정수: " + doubleValue);
    }
}
