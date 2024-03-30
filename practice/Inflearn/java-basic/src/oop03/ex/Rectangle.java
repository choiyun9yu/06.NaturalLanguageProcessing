package oop03.ex;

public class Rectangle {
    int width;
    int height;

    int calculateArea() {
        int area = width * height;
        System.out.println("넓이: " + area);
        return area;
    }

    int calcuatePerimeter() {
        int perimeter = 2 * (width + height);
        System.out.println("둘레 길이: " + perimeter);
        return perimeter;
    }

    boolean isSquare() {
        boolean square = width == height;
        System.out.println("정사각형 여부: " + square);
        return square;
    }
}
