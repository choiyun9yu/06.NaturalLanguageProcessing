package collection.link;

public class NodeMain3 {

    public static void main(String[] args) {
        // 노드 생성하고 연결하기: A -> B -> C
        Node first = new Node("A"); // x01
        first.next = new Node("B"); // x02
        first.next.next = new Node("C");  // x03

        System.out.println(first);

        // 모든 노드 탐색하기
        System.out.println("모든 노드 탐색하기");
        printAll(first);

        // 마지막 노드 조회하기
        Node lastNode = getLastNode(first);
        System.out.println("lastNode = " + lastNode);

        // 특정 index 의 노드 조회하기


    }

    private static void printAll(Node node) {
        Node x = node;
        while (x != null) {
            System.out.println(x.item);
            x = x.next;
        }

    }

    private static Node getLastNode(Node node) {
        Node x = node;
        // 다음 노드가 null 이면, 현재 노드가 마지막 노드임을 알 수 있음
        while (x.next != null) {
            x = x.next;
        }
        return x;
    }

}
