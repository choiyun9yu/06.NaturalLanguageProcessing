package lang.wrapper;

/*
 * 기본형의 한계를 이해하기 위해, 두 값을 비교해서 다음과 같은 결과를 출력하는 코드를 작성해보자.
 * 왼쪽 값이 더 크다 1
 * 두 값이 같다 0
 * 왼쪽 값이 더 작다 -1
 */

public class MyIntegerMethodMain0 {
    public static void main(String[] args) {
        int value = 10;
        int i1 = compareTo(value, 5);
        int i2 = compareTo(value, 10);
        int i3 = compareTo(value, 20);

        System.out.println("i1 = " + i1);
        System.out.println("i2 = " + i2);
        System.out.println("i3 = " + i3);

    }

    public static int compareTo(int a, int b) {
        if (a < b) {
            return -1;
        } else if (a > b) {
            return 1;
        } else {
            return 0;
        }
    }
}
