package pack;

public class PackageMain1 {

    public static void main(String[] args) {
        Data data = new Data();                 // 같은 위치
        pack.a.User user = new pack.a.User();   // 다른 위치(풀 네임)
    }
}
