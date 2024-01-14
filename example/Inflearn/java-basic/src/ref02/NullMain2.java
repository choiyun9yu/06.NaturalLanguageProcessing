package ref02;

public class NullMain2 {
    public static void main(String[] args) {
        Data data = null;
        data.value = 10; // NullPointException 예외 발생
        System.out.println("data = " + data.value);
    }
}
