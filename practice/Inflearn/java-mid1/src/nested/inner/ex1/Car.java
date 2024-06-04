package nested.inner.ex1;

public class Car {
    private String model;
    private int chargeLevel;
    private Engine engine;

    public Car(String model, int chargeLevel) {
        this.model = model;
        this.chargeLevel = chargeLevel;
        this.engine = new Engine(this); // 자신에 대한 정보를 넘겨서 Engine 인스턴스 생성
    }

    // Engine 에서만 사용할 메서드
    public String getModel() {
        return model;
    }

    // Engine 에서만 사용할 메서드
    public int getChargeLevel() {
        return chargeLevel;
    }

    public void start() {
        engine.start();
        System.out.println(model + " 시작 완료");
    }
}
