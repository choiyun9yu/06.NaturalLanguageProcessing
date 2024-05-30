package time;

import java.time.Duration;
import java.time.LocalTime;

public class DurationMain {

    public static void main(String[] args) {
        // 생성
        Duration duration = Duration.ofMinutes(30);
        System.out.println("duration = " + duration);

        LocalTime lt = LocalTime.of(1, 0);
        System.out.println("lt = " + lt);

        // 시점에 기간 더하기(시점 + 기간)
        LocalTime plusTime = lt.plus(duration);
        System.out.println("더한 시간: " + plusTime);

        // 시점간 기간 차이(시점 - 시점)
        LocalTime start = LocalTime.of(9, 0);
        LocalTime end = LocalTime.of(10, 0);
        Duration between = Duration.between(start, end);
        System.out.println("차이: " + between.getSeconds() + "초");
        System.out.println("근무 시간: " + between.toHours() + "시간 " + between.toMillisPart() + "분");
        // toMinutes( ): 전체 분 표현, toMinutesPart( ): 시간을 제외한 분만 표현
    }
}
