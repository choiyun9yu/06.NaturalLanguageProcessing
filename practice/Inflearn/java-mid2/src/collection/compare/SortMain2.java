package collection.compare;

import java.util.Arrays;
import java.util.Comparator;

public class SortMain2 {

    public static void main(String[] args) {
        Integer[] array = {3, 2, 1};
        System.out.println(Arrays.toString(array));
        System.out.println("Comparator 비교");
        Arrays.sort(array, new AscComparator());
        System.out.println("AscComparator: " + Arrays.toString(array));

        Arrays.sort(array, new DescComparator());
        System.out.println("DescComparator: " + Arrays.toString(array));
        Arrays.sort(array, new AscComparator().reversed()); // Asc + reversed 는 Desc 와 같다.
        System.out.println("AscComparator.reversed: " + Arrays.toString(array));
    }

    // Asc 는 오름차순 Desc 는 내림차순
    static class AscComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            System.out.println("o1: " + o1 + ", o2: " + o2);
            return (o1 < o2) ? -1 : (o1 == o2) ? 0 : 1; // 3항 연산자
        }
    }

    static class DescComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            System.out.println("o1: " + o1 + ", o2: " + o2);
            return  ((o1 < o2) ? -1 : (o1 == o2) ? 0 : 1) * -1; // 최종 결과에 -1 을 곱하면 반대로 된다.
        }
    }
}
