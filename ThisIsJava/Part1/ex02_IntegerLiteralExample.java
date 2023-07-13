package Part1;

public class ex02_IntegerLiteralExample {
    public static void main(String[] args) {
        int var2 = 0b1101;  // 2진법
        int var8 = 015;     // 8진법
        int var10 = 13;     // 10진법
        int var16 = 0xD;    // 16진컴파일러는 int로 간주하기 때문에 에러 발생 라이릳갸아다갸ㅓㅓ
//      System.out.println(var2, var8, var10, var16); 자바는 파이썬 처럼 ,로 프린트 할 수 없음
        System.out.println(var2 + "," + var8 + "," + var10 + "," + var16);

//      long var1 = 1000000000000;    컴파일러는 in로 간주하기 때문에 l을 붙여서 long type 임을 컴파일러에게 알려줘야 한다.
        long var11 = 1000000000000L;

        float f1 = (float) 3.14;   //  컴파일러가 double로 인식
        float f2 = 3.14f;  // 컴파일러가 fㅣoat으로 인식
    }
}
