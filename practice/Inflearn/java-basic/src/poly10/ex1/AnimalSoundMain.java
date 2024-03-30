package poly10.ex1;

public class AnimalSoundMain {

    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Caw caw = new Caw();

        // 2. 배열과 for 문을 통한 중복 제거 시도 -> 배열에 들어갈 요소의 타입이 달라서 안된다.
        // Caw[] cawArr = {dog, cat, caw};

        // 생성하는 부분은 당연히 필요하니 크게 상관 없지만, Dog, Cat, Caw를 사용해서 출력하는 부분은 객체가 늘어날 수록 중복이 증가한다.
        System.out.println("동물 소리 테스트 시작");
        dog.sound();
        System.out.println("동물 소리 테스트 종료");

        System.out.println("동물 소리 테스트 시작");
        cat.sound();
        System.out.println("동물 소리 테스트 종료");

        // System.out.println("동물 소리 테스트 시작");
        // caw.sound();
        // System.out.println("동물 소리 테스트 종료");
        soundCaw(caw);

    }

    // 1. 메서드로 증복 제거 시도 -> 하지만 caw 는 caw 에만 쓸 수 있고 cat 에는 쓸 수 없어서 의미가 없다. 동물이 추가될 때마다 메소드를 만들 수 없다.
    private static void soundCaw(Caw caw) {
        System.out.println("동물 소리 테스트 시작");
        caw.sound();
        System.out.println("동물 소리 테스트 종료");
    }

    // 문제 해결이 안되는 이유는 타입이 다르기 때문이다.
}
