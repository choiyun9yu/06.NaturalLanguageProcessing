package fc.java.part3;

public class PersonAccessTest {
    public static void main(String[] args) {
        // Q. Person 클래스의 이름과 나이와 전화번호를 저장하고 출력하시오.
        Person p = new Person();
        p.name = "";
        p.age = 1000;   // ?
        p.phone = "010-1111-1111";
        System.out.println(p.name+"\t"+p.age+"\t"+p.phone);
    }
}
