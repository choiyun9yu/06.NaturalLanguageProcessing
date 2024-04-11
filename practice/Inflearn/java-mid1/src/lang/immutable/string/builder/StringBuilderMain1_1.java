package lang.immutable.string.builder;

public class StringBuilderMain1_1{
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        // append: 맨 뒤에 추가
        sb.append("A");
        sb.append("B");
        sb.append("C");
        sb.append("D");
        System.out.println("sb.append = " + sb);

        // insert: 특정 인덱스 위치에 추가
        sb.insert(4, "Java");
        System.out.println("sb.insert = " + sb);

        // delete: 부분 삭제
        sb.delete(4, 8);
        System.out.println("sb.delete = " + sb);

        // reverse: 역순 정렬
        sb.reverse();
        System.out.println("sb.reverse = " + sb);

        // StringBuilder -> String
        String string = sb.toString();
        System.out.println("sb.toString = " + string.getClass());
    }
}
