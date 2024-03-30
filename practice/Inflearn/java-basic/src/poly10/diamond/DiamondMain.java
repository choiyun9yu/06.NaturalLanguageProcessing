package poly10.diamond;

public class DiamondMain {

    public static void main(String[] args) {
        InterfaceA a = new Child();
        a.methodA();
        // a.methodB();     InterfaceA 타입으로 접근했는데 거기엔 methodB 가 없어서 자식이 methodB 를 오버라이딩 했다고 하더라도 찾아갈 수 없다.
        a.methodCommon();

        InterfaceB b = new Child();
        b.methodB();
        // b.methodA();     InterfaceB 타입으로 접근했는데 거기엔 methodA 가 없어서 자식이 methodA 를 오버라이딩 했다고 하더라도 찾아갈 수 없다.
        b.methodCommon();
    }
}
