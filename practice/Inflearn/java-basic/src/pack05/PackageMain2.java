package pack05;

import pack05.a.*; // *를 사용하면 패키지 안에 모든 것을 다 가져온다.
import pack05.com.helloshap.Data;

public class PackageMain2 {

    public static void main(String[] args) {
        Data data = new Data(); // 같은 위치
        User user = new User(); // 다른 위치(import)
        User2 user2 = new User2();
    }
}
