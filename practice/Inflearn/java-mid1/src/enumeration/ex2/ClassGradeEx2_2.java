package enumeration.ex2;

public class ClassGradeEx2_2 {

    public static void main(String[] args) {
        int price = 10000;

        DiscountService discountService = new DiscountService();

        // 외부에서 ClassGrade 를 생성하면 안된다.
        // ClassGrade newClassGrade = new ClassGrade();

        // int result = discountService.discount(newClassGrade, price);
        // System.out.println(" newClassGrade 등급의 할인 금액 : " + result);
    }
}
