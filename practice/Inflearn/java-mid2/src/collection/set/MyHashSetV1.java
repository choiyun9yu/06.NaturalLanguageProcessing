package collection.set;

import java.util.Arrays;
import java.util.LinkedList;

public class MyHashSetV1 {

    static final int DEFAULT_INITIAL_CAPACITY = 16;

    LinkedList<Integer>[] buckets;

    private int size = 0;   // 이 Set 에 들어오 전체 데이터가 몇개 인지
    private int capacity = DEFAULT_INITIAL_CAPACITY;    // 기본 배열의 크기

    public MyHashSetV1() {
        initBuckets();
    }

    public MyHashSetV1(int capacity) {
        this.capacity = capacity;
        initBuckets();
    }

    private void initBuckets() {
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public boolean add(int value) {
        int hashIndex = hashIndex(value);
        LinkedList<Integer> bucket = buckets[hashIndex];
        if (bucket.contains(value)) {
            return false;
        }
        bucket.add(value);
        size++;
        return true;
    }

    public boolean contains(int searchValue) {
        int hashIndex = hashIndex(searchValue);
        LinkedList<Integer> bucket = buckets[hashIndex];
        return bucket.contains(searchValue);
    }

    public boolean remove(int value) {
        int hashIndex = hashIndex(value);
        LinkedList<Integer> bucket = buckets[hashIndex];
        boolean result = bucket.remove(Integer.valueOf(value));
        // remove 가 2가지 종류가 있다.
            // 1. 인덱스를 입력하면 인덱스 번호로 지우는 remove(int)
            // 2. 값을 입력하면 그 값을 지우는 remove(Object) -> 우리는 지울 값이 int 라서 조심해야 한다. -> Object 타입으로 넘기기 위해 래퍼타입으로 감싸줘야함
        if (result) {
            size--;
            return true  ;
        } else {
            return false;
        }
    }

    private int hashIndex(int value) {
        return value % capacity;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "MyHashSetV1{" +
                "buckets=" + Arrays.toString(buckets) +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }
}
