package collection.set.member;

public class JavaHashCodeMain {

    public static void main(String[] args) {
        // Object 의 기본 hasCode 는 객체의 참조값을 기반으로 생성 (여기선 참조값 16진수 -> 해시 코드 10진수 변환해서 다르게 보임)
        Object obj1 = new Object();
        Object obj2 = new Object();
        System.out.println("obj1.hashCode() = " + obj1.hashCode());
        System.out.println("obj2.hashCode() = " + obj2.hashCode());

        // 각 클래스마다 hashCode 를 이미 오버라이딩 해두었다.
        Integer i = 10;
        String strA = "A";
        String strAB = "AB";
        System.out.println("i.hashCode() = " + i.hashCode());
        System.out.println("strA.hashCode() = " + strA.hashCode());
        System.out.println("strAB.hashCode() = " + strAB.hashCode());

        // hashCode 에 마이너스 값이 들어올 수 있다.
        System.out.println("-1.hashCode() = " + Integer.valueOf(-1).hashCode());

        // 둘은 같을까?, 인스턴스는 다르지만 equals 는 같다. (물리적으론 다르지만 논리적으로 같은 경우 )
        Member member1 = new Member("idA");
        Member member2 = new Member("idA");

        // equals, hashCode를 오버라이딩 하지 않는 경우와, 한 경우를 비교
        System.out.println("(member1 == member2) = " + (member1 == member2));       // 인스턴스가 다르기 때문에 다르다. (참조하는 주소가 다름)
        System.out.println("member1.equals(member2) = " + member1.equals(member2)); // 인스턴스가 달라도 논리적으로 같아서 true
        System.out.println("member1.hashCode() = " + member1.hashCode());   // 해시코드가 있으면 참조값이 같게 나온다.
        System.out.println("member2.hashCode() = " + member2.hashCode());
    }
}
