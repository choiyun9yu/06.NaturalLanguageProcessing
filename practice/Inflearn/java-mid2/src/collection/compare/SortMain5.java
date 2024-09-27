package collection.compare;

import java.util.TreeSet;

public class SortMain5 {

    public static void main(String[] args) {
        MyUser myUser1 = new MyUser("a", 30);
        MyUser myUser2 = new MyUser("b", 20);
        MyUser myUser3 = new MyUser("c", 10);

        TreeSet<MyUser> treeSet1 = new TreeSet<>();
        treeSet1.add(myUser1);
        treeSet1.add(myUser2);
        treeSet1.add(myUser3);
        System.out.println("Comparable 기본 정렬");
        System.out.println(treeSet1);   // 데이터를 추가할 때 기본 정렬로 정렬되어 추가된다. (Comparable, Comparator 모두 없으면 예외 에러 발생)

        System.out.println("IdComparator 정렬");
        TreeSet<MyUser> treeSet2 = new TreeSet<>(new IdComparator());  // TreeSet 생성자에 비교자를 넣으면 정렬 기준이 바뀐다.
        treeSet2.add(myUser1);
        treeSet2.add(myUser2);
        treeSet2.add(myUser3);
        System.out.println(treeSet2);
    }
}
