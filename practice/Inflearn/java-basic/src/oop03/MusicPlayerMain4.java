package oop03;

// 속성과 기능을 하나로 묶어 객체 지향 프로그래밍으로 작성된 음악 플레이어

public class MusicPlayerMain4 {

    public static void main(String[] args) {
        MusicPlayerData data = new MusicPlayerData();

        data.on();
        data.volumeUp();
        data.volumeUp();
        data.volumeDown();
        data.status();
        data.off();
    }
}
