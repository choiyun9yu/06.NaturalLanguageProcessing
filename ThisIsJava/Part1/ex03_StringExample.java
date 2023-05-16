package Part1;

public class ex03_StringExample {
    public static void main(String args) {
//      char var1 = "A";    큰따옴표로 감싸면 char 컴파일 에러
//      char var2 = 'abc';
        char var1 = 'A';

        String name = "홍길동";
        String job = "프로그래머";
        System.out.println(name);
        System.out.println(job);

        String str = "나는 \"자바\"를 배웁니다.";
        System.out.println(str);

        str = "번호\t이\t직업";
        System.out.println(str);

        System.out.print("나는\n");
        System.out.print("자바를\n");
        System.out.print("배웁니다.\n");

//  Java 13부터 큰따옴표 3개로 감싸면 이스케이프하거나 라인피드 할 필요 없이 작성된 그대로 저장된다.
        String str1 = ""+
        "{\n"+
        "\t\"id\":\"winter\",\n"+
        "\t\"name\":\"눈송이\"\n"+
        "}";

        String str2 = """
          {
            "id":"winter",
            "name":"눈송이"
          }
          """;
        System.out.println(str1);
        System.out.println(str2);

        String str3 = """
                나는 자바를 \
                학습합니다.
                나는 자바 고수가 될 겁니다.
                """;
        System.out.println(str3);
    }
}
