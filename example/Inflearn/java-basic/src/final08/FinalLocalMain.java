package final08;

public class FinalLocalMain {

    public static void main(String[] args) {
        // final 지역 변수
        final int data1;
        data1 = 10;     // 최초 한 번만 할당 가능
        // data1 = 20;  // 컴파일 오류

        final int data2 = 10;   // 선언하면서 할당
        // data2 = 20;  // 컴파이 오류
    }

    static void method(final int parameter) {
        // 매개 변수에 final 키워드를 부여하면 파라미터의 값을 내부 스코프에서 수정 불가
        // parameter = 20;
    }
}
