package iterable;

import java.util.Iterator;

public class MyArray implements Iterable<Integer> {
    // Iterable 인터페이스를 구현하여 반복가능한 객체라는 것을 알 수 있다.

    private int[] numbers;

    public MyArray(int[] numbers) {
        this.numbers = numbers;
    }

    // 반복 가능하다는 것은 반복자를 반환하는 것이다.
    @Override
    public Iterator<Integer> iterator() {
        return new MyArrayIterator(numbers);
    }
}
