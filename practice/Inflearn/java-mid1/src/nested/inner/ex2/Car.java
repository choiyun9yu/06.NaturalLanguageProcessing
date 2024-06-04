package nested.inner.ex2;

public class Car {
    private String model;
    private int chargeLevel;
    private Engine engine;

    public Car(String model, int chargeLevel) {
        this.model = model;
        this.chargeLevel = chargeLevel;
        this.engine = new Engine();
    }

    public void start() {
        engine.start();
        System.out.println(model + " 시작 완료");
    }

    private class Engine {

        // 내부 클래스는 car 에 정보가 없어도 바깥 클래스의 정보를 알 수 있다.
        // private Car car;

        // public Engine(Car car) {
        //    this.car = car;
        //}

        public void start() {
            // getter 메서드가 없어도 바로 바깥 클래스의 필드 값에 접근할 수 있다.
            System.out.println("충전 레벨 확인: " + chargeLevel);
            System.out.println(model + "의 엔진을 구동합니다.");
        }
    }
}
