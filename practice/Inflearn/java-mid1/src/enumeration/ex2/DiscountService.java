package enumeration.ex2;

public class DiscountService {

    public int discount(ClassGrade classGrade, int price){
        int dicountPercent = 0;

        if (classGrade == ClassGrade.BASIC) {
            dicountPercent = 10;
        } else if (classGrade == ClassGrade.GOLD) {
            dicountPercent = 20;
        } else if (classGrade == ClassGrade.DIAMOND) {
            dicountPercent = 30;
        } else {
            System.out.println(classGrade + " : 할인X");
        }

        return price * dicountPercent/100;
    }

}
