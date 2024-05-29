package time;

import java.time.LocalTime;

public class LocalTimeMain {

    public static void main(String[] args) {
        LocalTime nowTime = LocalTime.now();
        LocalTime ofTime = LocalTime.of(9, 10, 30);

        System.out.println("현재 시간 = " + nowTime);
        System.out.println("지정 시간 = " + ofTime);

        // 계산(불변)
        LocalTime ofTimePlus1 = ofTime.plusHours(1);
        LocalTime ofTimePlus2 = ofTimePlus1.plusMinutes(5);
        LocalTime ofTimePlus3 = ofTimePlus2.plusSeconds(10);
        System.out.println("지정 시간 +1: +5: +10 = " + ofTimePlus3);
    }
}
