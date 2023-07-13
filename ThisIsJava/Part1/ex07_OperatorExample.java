package Part1;

public class ex07_OperatorExample {
    public static void main(String[] args) {
        byte b = 100;
        //byte result = -b; // 컴파일 에러 이유 (정수타입인 byte, short, int 연산의 결과는 int 타입,
        //                                      따라서 부호변산도 연산의 결과이므로 int로 선언해야)
        int result = -b;

        // 비교연산자 반환 값
        int n = 65;
        int m = 64;
        System.out.println(n==m);

        // 문자열의 비교
        String str1 = "학교";
        String str2 = "가방";
        boolean result1 = str1.equals(str2); // 문자열이 같은지 검사
        boolean result2 = !str1.equals(str2);
        System.out.println(result1);
        System.out.println(result2);
    }
}
