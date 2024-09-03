package collection.link;

public class Node {

    Object item;
    Node next;

    public Node(Object item) {
        this.item = item;
    }

/*    // Generate 로 IDE 자동 생성 toString()
    @Override
    public String toString() {
        return "Node{" +
                "item=" + item +
                ", next=" + next +
                '}';
    }*/

    // [A -> B -> C]
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); // 루프에서 문자를 더해야 되기 때문에 스트링빌더 사용
        Node x = this;
        sb.append("[");
        while (x != null) {
            sb.append(x.item);
            if (x.next != null) {
                sb.append("->");
            }
            x = x.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
