package collection.link;

public class NodeMain1 {

    public static void main(String[] args) {
        // 노드 생성하고 연결하기:  A -> B -> C
        Node first = new Node("A");
        first.next = new Node("B");
        first.next.next = new Node("C");

        Node x = first;
        while (x != null) {
            System.out.println(x.item);
            x = x.next;
        }
    }
}
