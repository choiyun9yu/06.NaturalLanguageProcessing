package time;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class ChangeTimeWithMain {

    public static void main(String[] args) {
        LocalDateTime dt = LocalDateTime.of(2018, 1, 1, 13, 30, 59);
        System.out.println("dt = " + dt);

        // with( ) 는 불변 타입일 때 기존 값의 일부를 바꾸고 새로운 걸 만들 때 쓴다. 기존의 거에다가 뭔가 살짝 하나를 바꿔서 이 새로 넘어온 애로 바꾸는 것
        LocalDateTime changeDt1 = dt.with(ChronoField.YEAR, 2020);  // 여기서는 년도만 2018 에서 2020 으로 변경
        System.out.println("changeDt1 = " + changeDt1);

        // 편의 메서드
        LocalDateTime changeDt2 = dt.withYear(2020);
        System.out.println("changeDt2 = " + changeDt2);

        // TemporalAdjuster 사용
        // 다음주 금요일
        LocalDateTime with1 = dt.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        System.out.println("기준 날짜: " + dt);
        System.out.println("다음 금요일: " + with1);

        // 이번 달의 마지막 일요일
        LocalDateTime with2 = dt.with(TemporalAdjusters.lastInMonth(DayOfWeek.SUNDAY));
        System.out.println("같은 달의 마지막 일요일 = " + with2);
    }
}
