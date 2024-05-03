package lang.immutable.string.chaining;

public class ValueAdder {

    private int value;

    public ValueAdder add(int addValue) {
        value += addValue;
        return this;    // 자기 자신을 반환
    }

    public int getValue() {
        return value;
    }

}
