package nested.ex1;

// 이 객체는 Network 객체 안에서만 사용할 것이다.
public class NetworkMessage {

    private String content;

    public NetworkMessage(String content) {
        this.content = content;
    }

    public void print() {
        System.out.println(content);
    }

}
