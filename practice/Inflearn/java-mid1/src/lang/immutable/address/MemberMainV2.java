package lang.immutable.address;

public class MemberMainV2 {

    public static void main(String[] args) {
        ImmutableAddress address = new ImmutableAddress("서울");
        MemberV2 memberA = new MemberV2("회원A", address);
        MemberV2 memberB = new MemberV2("회원A", address);

        // 회원 A, 회원 B의 처음 주소는 모두 서울
        System.out.println("memberA: " + memberA);
        System.out.println("memberB: " + memberB);

        // 회원 B의 주소를 부산으로 변경 (B가 불변인게 아니라 B가 가진 address 가 불변인 것이다.)
        // memberB.getAddress().setValue("부산");
        memberB.setAddress(new ImmutableAddress("부산"));
        System.out.println("memberA: " + memberA);
        System.out.println("memberB: " + memberB);
    }
}
