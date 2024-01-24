package poly10.ex4;

public class Caw extends AbstractAnimal{
    @Override
    public void sound() {
        System.out.println("음매");
    }

    @Override
    public void move() {
        System.out.println("소가 움직입니다.");
    }
}
