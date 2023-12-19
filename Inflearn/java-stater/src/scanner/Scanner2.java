package scanner;

/*
* 두 수를 입력받고 그 합을 출력하는 예제
*/

import java.util.Scanner;

public class Scanner2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력하세요: ");
        int int1 = scanner.nextInt();

        System.out.print("두 번째 숫자를 입력하세요:");
        int int2 = scanner.nextInt();

        int sum = int1 + int2;
        System.out.println("두 수의 합: " + sum);
    }
}
