package pack05;

import pack05.a.User;

public class PackageMain3 {

    public static void main(String[] args) {
        User userA = new User(); // 다른 위치(import)
        pack05.b.User userB = new pack05.b.User(); // 다른위치(풀네임)
    }
}
