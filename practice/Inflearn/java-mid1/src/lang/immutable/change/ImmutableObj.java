package lang.immutable.change;

public class ImmutableObj {

    private final int value;

    public ImmutableObj(int value) {
        this.value = value;
    }

    public ImmutableObj add (int addValue) {
        int result = value + addValue;
        // value 값을 바꾸지 않고 바꿔야하는 상황이 오면 새로운 객체를 만들어서 반환한다.
        return new ImmutableObj(result);
    }

    public int getValue() {
        return value;
    }
}
