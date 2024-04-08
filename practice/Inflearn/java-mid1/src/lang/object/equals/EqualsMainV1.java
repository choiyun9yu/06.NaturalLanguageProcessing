package lang.object.equals;

public class EqualsMainV1 {

    public static void main(String[] args) {
        UservV1 user1 = new UservV1("id-100");
        UservV1 user2 = new UservV1("id-100");

        System.out.println("Identity = " + (user1 == user2));
        System.out.println("equality = " + (user1.equals(user2)));
    }
}
