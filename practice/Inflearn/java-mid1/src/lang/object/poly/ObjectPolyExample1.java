package lang.object.poly;

public class ObjectPolyExample1 {

    public static void main(String[] args) {
        Dog dog = new Dog();
        Car car = new Car();

        action(dog);
        action(car);
    }

    private static void action(Object obj) {
        // obj.sound();     // 컴파일 오류, Object 는  sound() 가 없다.
        // obj.move();      // 컴파일 오류, Object 는 move() 가 없다.

        // 객체에 맞는 다운 캐스팅이 필요
        if (obj instanceof Dog dog) {   // 이렇게 하면 자동으로 다운 캐스팅이 된다.
            dog.sound();
        } else if (obj instanceof Car car) {
            car.move();
        }
    }
}
