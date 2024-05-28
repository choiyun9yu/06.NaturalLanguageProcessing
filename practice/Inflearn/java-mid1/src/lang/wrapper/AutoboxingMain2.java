package lang.wrapper;

public class AutoboxingMain2 {

    public static void main(String[] args) {
        // Primitive -> Wrapper
        int value = 7;
        Integer boxedVlaue = value;

        // Wrapper -> Primitive
        int unboxedVlaue = boxedVlaue;

        System.out.println("boxedVlaue = " + boxedVlaue);
        System.out.println("unboxedVlaue = " + unboxedVlaue);
    }
}
