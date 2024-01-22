package pack05;

import pack05.com.helloshap.Data;

public class PackageMain1 {

    public static void main(String[] args) {
        Data data = new Data(); // 같은 위치
        pack05.a.User user = new pack05.a.User(); // 다른 위치(풀 네임)
    }
}
