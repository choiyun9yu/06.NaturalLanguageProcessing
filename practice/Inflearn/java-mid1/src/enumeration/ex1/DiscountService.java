package enumeration.ex1;

public class DiscountService {

    public int discount(String grade, int price){
        int dicountPercent = 0;

        if (grade.equals(StringGrade.BASIC)){
            dicountPercent = 10;
        } else if (grade.equals(StringGrade.GOLD)){
            dicountPercent = 20;
        } else if (grade.equals(StringGrade.DIAMOND)){
            dicountPercent = 30;
        } else {
            System.out.println(grade + " : 할인X");
        }

        return price * dicountPercent/100;
    }

}
