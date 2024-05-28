package lang.wrapper;

public class AutoboxingMain1 {

    public static void main(String[] args) {
        // Primitive -> Wrapper
        int value = 7;
        Integer boxedVlaue = Integer.valueOf(value);

        // Wrapper -> Primitive
        int unboxedVlaue = boxedVlaue.intValue();

        System.out.println("boxedVlaue = " + boxedVlaue);
        System.out.println("unboxedVlaue = " + unboxedVlaue);
    }
}
