package fc.java.part3;
// object는 상태정보(멤버변수)와 행위정보(멤버메서드)로 이루어져있다.
public class Person {
    // 상태 정보
    public String name;
    public int age;
    public String phone;

    // 행위 정보
    public void play(){
        System.out.println("운동을 한다.");
    }
    public void eat(){
        System.out.println("음식을 먹다.");
    }
    public void walk() {
        System.out.println("걷다.");
    }
}

