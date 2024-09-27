package collection.compare;

import java.util.LinkedList;
import java.util.List;

public class SortMain4 {

    public static void main(String[] args) {
        MyUser myUser1 = new MyUser("a", 30);
        MyUser myUser2 = new MyUser("b", 20);
        MyUser myUser3 = new MyUser("c", 10);

        List<MyUser> list = new LinkedList<MyUser>();
        list.add(myUser1);
        list.add(myUser2);
        list.add(myUser3);
        System.out.println("기본 데이터");
        System.out.println(list);

        System.out.println("Comparable 기본 정렬");
        //Collections.sort(list);   // 이렇게 해도 정렬이된다. 그래도 list.sort() 를 쓰는게 더 낫
        list.sort(null);    // Comparator 파라미터를 null 로 입력하면 기본 정렬 된다. (자기 자신을 정렬할 거라서 list 는 안넣어도 된다.)
        System.out.println(list);

        System.out.println("IdComparator 정렬");
        //Collections.sort(list, new IdComparator());
        list.sort(new IdComparator());
        System.out.println(list);

        System.out.println("IdComparator().reversed() 정렬");
        list.sort(new IdComparator().reversed());
        System.out.println(list);
    }
}
