package lang.wrapper;

public class MyIntegerNullMain0 {

    public static void main(String[] args) {
        int[] intArr = {-1, 0, 1, 2, 3};
        System.out.println(findValue(intArr, -1));
        System.out.println(findValue(intArr, 0));
        System.out.println(findValue(intArr, 1));
        System.out.println(findValue(intArr, 100));
    }

    public static int findValue(int[] intArr, int target){
        for (int value : intArr) {
            if (value == target) {
                return value;
            }
        }
        return -1;  // 반환 타입이 int  이기 때문에 뭐라도 반환해야한다. 이런 경우 실패인 경우 -1 이나 0 을 반환한다.
    }
}
