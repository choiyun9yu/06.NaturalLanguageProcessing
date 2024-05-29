package enumeration.ex0;

public class StringGradeEx0_2 {

    public static void main(String[] args) {
        int price = 10000;

        DiscountService discountService = new DiscountService();

        // 존재하지 않는 등급
        int vip = discountService.discount("VIP", price);
        System.out.println("VIP 등급의 할인 금액 = " + vip);

        // 오타
        int basic = discountService.discount("BASICC", price);
        System.out.println("BASICC 등급의 할인 금액 = " + basic);

        int god = discountService.discount("gold", price);
        System.out.println("gold 등급의 할인 금액 = " + god);
    }
}
