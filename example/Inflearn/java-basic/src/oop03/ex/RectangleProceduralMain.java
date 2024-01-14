package oop03.ex;

/*
* 문제1 - 절차 지향 직사각형 프로그램을 객체 지향으로 변경하기
*
* 절차 지향 프로그래밍 방식으로 되어 있는 코드를 객체 지향 프로그래밍 방식으로 변경해라.
* Rectangle 클래스를 만들어라.
* RectangleOopMain 에 해당 클래스를 사용하는 main() 코드를 만들어라.
*
* */

public class RectangleProceduralMain {

    public static void main(String[] args) {
        int width = 5;
        int height = 8;

        int area = calculateArea(width, height);
        System.out.println("넓이: " + area);

        int perimeter = calcuatePerimeter(width, height);
        System.out.println("둘레 길이: " + perimeter);

        boolean square = isSquare(width, height);
        System.out.println("정사각형 여부: " + square);
    }

    static int calculateArea(int width, int height) {
        return width * height;
    }

    static int calcuatePerimeter(int width, int height) {
        return 2 * (width + height);
    }

    static boolean isSquare(int width, int height) {
        return width == height;
    }
}
