import a.User;

public class PackageMain3 {

    public static void main(String[] args) {
        User userA = new User(); // 다른 위치(import)
        b.User userB = new b.User(); // 다른위치(풀네임)
    }
}
