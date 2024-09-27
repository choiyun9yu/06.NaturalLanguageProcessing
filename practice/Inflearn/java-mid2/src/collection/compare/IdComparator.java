package collection.compare;

import java.util.Comparator;

public class IdComparator implements Comparator<MyUser> {

    @Override
    public int compare(MyUser o1, MyUser o2) {
        return o1.getId().compareTo(o2.getId());    // .compareTo() 자바에서 문자를 비교하기 위해 구현해놓은 메소드
    }
}
