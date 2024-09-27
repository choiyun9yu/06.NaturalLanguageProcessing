package collection.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeStackMain {

    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();

        // 데이터 추가
        deque.push(1);
        deque.push(2);
        deque.push(3);
        System.out.println("collection.deque = " + deque);

        System.out.println("collection.deque.peek() = " + deque.peek());

        System.out.println("collection.deque.pop() = " + deque.pop());
        System.out.println("collection.deque.pop() = " + deque.pop());
        System.out.println("collection.deque.pop() = " + deque.pop());
        System.out.println("collection.deque = " + deque);
    }
}
