package poly10.ex4;

public class Dog extends AbstractAnimal{
    @Override
    public void sound() {
        System.out.println("멍멍");
    }

    @Override
    public void move() {
        System.out.println("개가 움직입니다.");
    }
}
