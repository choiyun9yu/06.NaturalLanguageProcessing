package lang.object.equals;

public class EqaulsMain2 {

    public static void main(String[] args) {
        UserV2 user1 = new UserV2("id-100");
        UserV2 user2 = new UserV2("id-100");

        System.out.println("Identity = " + (user1 == user2));
        System.out.println("Equality = " + user1.equals(user2));
    }
}
