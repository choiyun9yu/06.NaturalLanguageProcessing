package pack;

import pack.a.User;


public class PackageMain3 {

    public static void main(String[] args) {
        User userA = new User();                // 다른 위치(import)
        pack.b.User userB = new pack.b.User();  // 다른위치(풀네임)
    }
}
