package access06;

public class SpeakerMain {
    public static void main(String[] args) {
        Speaker speaker = new Speaker(90);
        speaker.showVolumne();

        speaker.volumeUp();
        speaker.showVolumne();

        speaker.volumeUp();
        speaker.showVolumne();

        // 필드에 직접 접근
        System.out.println("volume 필드 직접 접근 수정");
        // speaker.volumne = 200;  // private access 컴파일 에러 뜬다.
        speaker.showVolumne();
    }
}