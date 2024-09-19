package collection.set;

import java.util.Arrays;
import java.util.LinkedList;

public class HashStart5 {

    static final int CAPACITY = 10;

    public static void main(String[] args) {
        // {1, 2, 5, 8, 14, 99}
        LinkedList<Integer>[] buckets = new LinkedList[CAPACITY];   // 이건 LinkedList 를 만든게 아니라 LinkedList 를 넣을 수 있는 배열을 만든 것이다.
        System.out.println("buckets = " + Arrays.toString(buckets));

        for (int i = 0; i < CAPACITY; i++) {
            buckets[i] = new LinkedList<>();    // 여기서 LinkedList 를 각 배열에 담아 주었다.
        }
        System.out.println("buckets = " + Arrays.toString(buckets));

        // 추가
        add(buckets, 1);
        add(buckets, 2);
        add(buckets, 5);
        add(buckets, 8);
        add(buckets, 14);
        add(buckets, 99);
        add(buckets, 9);    // 중복
        System.out.println("buckets = " + Arrays.toString(buckets));

        // 검색
        int searchValue = 9;
        boolean contains = contains(buckets, searchValue);
        System.out.println("bucket.contains = " + contains);
    }

    // 검색
    private static boolean contains(LinkedList<Integer>[] buckets, int searchValue) {
        int hashIndex = hashIndex(searchValue);
        LinkedList<Integer> bucket = buckets[hashIndex];    // O(1)
        return bucket.contains(searchValue);    // O(n)

        //원래는 전체다 도는 코드를 만들어야하지만 LinkedList 에 이미 contains 가 있으니 그것을 사용
        //for (Integer integer : bucket) {
        //    if (integer == searchValue) {
        //        return true;
        //    }
        //    return false;
        //}
    }

    // 추가
    private static void add(LinkedList<Integer>[] buckets, int value) {
        int hashIndex = hashIndex(value);
        LinkedList<Integer> bucket = buckets[hashIndex];    // O(1)

        // 중복 체크
        if (!bucket.contains(value)) {
            bucket.add(value);
        }
    }

    static int hashIndex(int value) {
        return value % CAPACITY;
    }
}
