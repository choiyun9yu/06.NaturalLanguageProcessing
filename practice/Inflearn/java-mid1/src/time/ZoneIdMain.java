package time;

import java.time.ZoneId;
import java.util.Set;

public class ZoneIdMain {

    public static void main(String[] args) {
        for (String availableZoneId : ZoneId.getAvailableZoneIds()) {
            ZoneId zoneId = ZoneId.of(availableZoneId);
            System.out.println(zoneId + "|" + zoneId.getRules());
        }

        ZoneId zoneIdSystemDefault = ZoneId.systemDefault();
        System.out.println("ZoneId.systemDefault = " + zoneIdSystemDefault);

        ZoneId seoulZoneId = ZoneId.of("Asia/Seoul");
        System.out.println("seoulZoneId = " + seoulZoneId);
    }
}
