package collection.set;

public class StringHashMain {

    static final int CAPACITY = 10;

    public static void main(String[] args) {
        // char
        char charA = 'A';
        char charB = 'B';
        System.out.println("charA = " + (int)charA);
        System.out.println("charB = " + (int)charB);

        // hashCode
        System.out.println();
        System.out.println("hashCode('A') = " + hashCode("A"));
        System.out.println("hashCode('B') = " + hashCode("B"));
        System.out.println("hashCode('AB') = " + hashCode("AB"));

        // hashIndex
        System.out.println();
        System.out.println("hashIndex('A') = " + hashIndex(hashCode("A")));
        System.out.println("hashIndex('B') = " + hashIndex(hashCode("B")));
        System.out.println("hashIndex('AB') = " + hashIndex(hashCode("AB")));
    }

    static int hashCode(String str) {
        char[] charArray = str.toCharArray();   // 문자열을 char 배열로 바꾼다.
        int sum = 0;
        // 여러 문자가 오면 단순히 더하기
        for (char c : charArray) {
            sum = sum + (int)c;
        }
        return sum;
    }

    static int hashIndex(int value) {
        return value % CAPACITY;
    }
}
