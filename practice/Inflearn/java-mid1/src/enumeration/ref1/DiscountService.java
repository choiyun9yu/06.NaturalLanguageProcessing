package enumeration.ref1;

public class DiscountService {

    public int discount(ClassGrade classGrade, int price){
        return price * classGrade.getDiscountPercent() /100;
    }

}
