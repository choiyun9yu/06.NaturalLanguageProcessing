package access06;

/* 접근 제어자 이해 1
 * 음량이 절대로 100을 넘으면 안되는 요구사항이 있는 스피커 만들기
 */
public class Speaker {
    private int volumne;

    Speaker (int volumne) {
        this.volumne = volumne;
    }

    void volumeUp() {
        if (volumne >= 100) {
            System.out.println("음량을 증가할 수 없습니다. 최대 음량입니다.");
        } else {
            volumne += 10;
            System.out.println("음량을 10 증가합니다.");
        }
    }

    void volumeDown() {
        volumne -= 10;
        System.out.println("음량을 10 감소합니다.");
    }

    void showVolumne() {
        System.out.println("현재 음량: " + volumne);
    }
}