package final08;

public class FinalRefMain {
    public static void main(String[] args) {
        final Data data = new Data();
        // data = new Data();    참조 값을 이미 할당 했기 때문에 컴파일 오류

        // 참조 대상의 값은 변경 가능
        data.value = 10;
        System.out.println(data.value);
        data.value = 20;
        System.out.println(data.value);
    }
}
