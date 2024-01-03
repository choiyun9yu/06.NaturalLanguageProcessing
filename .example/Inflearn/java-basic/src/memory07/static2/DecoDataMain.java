package memory07.static2;

import static memory07.static2.DecoData.staticCall;
import static memory07.static2.DecoData.*;  // 모든 static 가져오기

public class DecoDataMain {

    public static void main(String[] args) {
        System.out.println("1. 정적 호출");
        DecoData.staticCall();
        staticCall();   // import static으로 생략 가능

        System.out.println("2. 인스턴스 호출(1)");
        DecoData data1 = new DecoData();
        data1.instanceCall();

        System.out.println("3. 인스턴스 호출(2)");
        DecoData data2 = new DecoData();
        data2.instanceCall();

        // 추가
        // 인스턴스를 통한 접근
        DecoData data3 = new DecoData();
        data3.staticCall();

        // 클래스를 통한 접근
        DecoData.staticCall();
    }
}
