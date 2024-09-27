package collection.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EmptyListMain {

    public static void main(String[] args) {
        // 빈 가변 리스트 생성
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        // 빈 불변 리스트 생성
        List<Integer> list3 = Collections.emptyList();  // 자바5
        List<Integer> list4 = List.of();    // 자바9

        System.out.println("list3.getClass() = " + list3.getClass());
        System.out.println("list4.getClass() = " + list4.getClass());

        Integer[] arr = {1, 2, 3, 4, 5};
        List<Integer> arrList = Arrays.asList(arr);
        arrList.set(0, 100);    // 0번 인덱스의 값을 100으로 변경
        System.out.println("arr = " + Arrays.toString(arr)); // arrList 값을 변경했는데 같이 바뀜
        System.out.println("arrList = " + arrList);
    }
}
