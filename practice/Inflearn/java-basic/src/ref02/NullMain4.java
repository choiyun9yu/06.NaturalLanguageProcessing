package ref02;

public class NullMain4 {
    public static void main(String[] args) {
        BigData bigData = new BigData();
        bigData.data = new Data(); // 참조형 변수에 null 이 아닌 인스턴스를 할당하 해결
        System.out.println("bigData.count=" + bigData.count);
        System.out.println("bigData.data=" + bigData.data);

        // NullPointException
        System.out.println("bigData.data.value=" + bigData.data.value);
    }
}
