package enumeration.ex3;

public class DiscountService {

    public int discount(Grade grade, int price){
        int dicountPercent = 0;

        if (grade == Grade.BASIC) {
            dicountPercent = 10;
        } else if (grade == Grade.GOLD) {
            dicountPercent = 20;
        } else if (grade == Grade.DIAMOND) {
            dicountPercent = 30;
        } else {
            System.out.println(grade + " : 할인X");
        }

        return price * dicountPercent/100;
    }

}
