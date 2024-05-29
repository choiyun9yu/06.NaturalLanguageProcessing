package time;

import java.time.LocalDate;

public class LocalDateMain {

    public static void main(String[] args) {
        LocalDate nowDate = LocalDate.now();
        LocalDate ofDate = LocalDate.of(2019, 1, 1);
        System.out.println("오늘 날짜 = " + nowDate);
        System.out.println("지정 날짜 = " + ofDate);

        // 계산(불변 객체이기 때문에 반환값을 받아야한다.)
        ofDate = ofDate.plusDays(10);
        System.out.println("ofDate + 10 = " + ofDate);
    }
}
