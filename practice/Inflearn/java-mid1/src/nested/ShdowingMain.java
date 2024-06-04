package nested;

public class ShdowingMain {

    public int value = 1;

    class Inner {
        public int value = 2;

        void go() {
            int value = 3;
            System.out.println("value = " + value); // 3 (메소드 안의 value)
            System.out.println("this.value = " + this.value);   // 2 (내부 클래스의 value)
            System.out.println("ShdowingMain.this.value = " + ShdowingMain.this.value); // 1 (바깥 클래스의 value)
        }
    }

    public static void main(String[] args) {
        ShdowingMain main = new ShdowingMain();
        Inner inner = main.new Inner();
        inner.go();
    }
}
