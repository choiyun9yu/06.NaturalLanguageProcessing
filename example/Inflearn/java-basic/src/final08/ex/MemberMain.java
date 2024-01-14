package final08.ex;

public class MemberMain {

    public static void main(String[] args) {
        Member member = new Member("myId", "choi");
        member.print();
        member.changeData("seo");
        member.print();
    }
}
