package ref02;

public class NullMain3 {
    public static void main(String[] args) {
        BigData bigData = new BigData();
        System.out.println("bigData.count=" + bigData.count);
        System.out.println("bigData.data=" + bigData.data);

        // NullPointException
        System.out.println("bigData.data.value=" + bigData.data.value);
    }
}
