package collection.array;

import java.util.Arrays;

public class MyArrayListV1 {

    private static final int DEFAULT_CAPACITY = 5;

    private Object[] elementData;
    private int size = 0;

    // 기본 생성자
    public MyArrayListV1() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    // 직접 크기를 정하는 생성자
    public MyArrayListV1(int initialCapacity) {
        elementData = new Object[initialCapacity];
    }

    public int size() {
        return size;
    }

    public void add(Object e) {
        elementData[size] = e;
        size++;
    }

    public Object get(int index) {
        return elementData[index];
    }

    public Object set(int index, Object element) {
        Object oldValue = get(index);
        elementData[index] = element;
        return oldValue;
    }

    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(o)) {
                return i;
            }
        }
        return -1;  // 못찾은 경우
    }

    // 오버라이딩
    public String toString() {
        // [1, 2, 3, null, null] size=3
        // [1, 2, 3] size=3
        return Arrays.toString(Arrays.copyOf(elementData, size)) +
                " size=" + size + ", capacity=" + elementData.length;
    }
}
