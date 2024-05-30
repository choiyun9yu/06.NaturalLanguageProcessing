package time;

import java.time.Instant;
import java.time.ZonedDateTime;

public class InstantMain {

    public static void main(String[] args) {
        // 생성
        Instant now = Instant.now();    // UTC 기준
        System.out.println("now = " + now);

        // ZonedDateTime -> Instant
        ZonedDateTime zdt = ZonedDateTime.now();
        Instant from = Instant.from(zdt);

        // 1970 년 1월 1일 0시 0분 0초 에서 파라미터로 전달한 값 만 큼의 초를 더한 값
        Instant epochStart = Instant.ofEpochSecond(0);
        System.out.println("epochStart = " + epochStart);

        // 계산 (세컨드, 밀리세컨드, 나노세컨드)
        Instant later = epochStart.plusSeconds(3600);
        System.out.println("later = " + later);

        // 조회 (Epoch 로 부터 흐른 초)
        long laterEpochSecond = later.getEpochSecond();
        System.out.println("laterepochSecond = " + laterEpochSecond);
    }
}
