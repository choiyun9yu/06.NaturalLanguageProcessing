package enumeration.ex0;

/*
 * 회원 등급과 가격을 입력하면 할임 금액을 계싼해주는 클래스를 만들어보자.
 * 예를 들어서 GOLD, 10000원을 입력하면 할인 대상 금액인 2000원을 반환한다.
 */

public class DiscountService {

    public int discount(String grade, int price){
        int dicountPercent = 0;

        if (grade.equals("BASIC")){
            dicountPercent = 10;
        } else if (grade.equals("GOLD")){
            dicountPercent = 20;
        } else if (grade.equals("DIAMOND")){
            dicountPercent = 30;
        } else {
            System.out.println(grade + " : 할인X");
        }

        return price * dicountPercent/100;
    }
}
