package collection.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapMain1 {

    public static void main(String[] args) {
        Map<String, Integer> studentMap = new HashMap<>();

        // 학생 성적 데이터 추가
        studentMap.put("studentA", 90);
        studentMap.put("studentB", 80);
        studentMap.put("studentC", 80);
        studentMap.put("studentD", 100);
        System.out.println(studentMap);

        // 특정 학생의 값 조회
        Integer result = studentMap.get("studentD");
        System.out.println("result = " + result);

        // KeySet 활용
        System.out.println("KeySet 활용");
        Set<String> keySet = studentMap.keySet();   // keySet()은 key 만 꺼낸다. key 는 사실 Set 과 같은 자료 구조로 저장된다.
        for (String key : keySet) {
            Integer value = studentMap.get(key);
            System.out.println("key= "+ key + ", valu = " + value);
        }

        // entrySet 활용
        System.out.println("entrySet 활용");
        Set<Map.Entry<String, Integer>> entries = studentMap.entrySet();    // Entry 는 key 와 value 를 저장하는 객체이다.
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println("key= " + entry.getKey() + ", value= " + entry.getValue());
        }


        // values 활용
        System.out.println("values 활용");
        Collection<Integer> values = studentMap.values();   // values()는 value 만 꺼낸다. values 는 중복이될 수 있어서 Collection 으로 나온다. (순서를 보장하지 않아서 List 로 나오지 않음)
        for (Integer value : values) {
            System.out.println("value= " + value);
        }
    }
}
