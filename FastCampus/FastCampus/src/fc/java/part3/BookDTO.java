package fc.java.part3; // package 선언문
import java.lang.*; // 이건 기본으로 임포트 되는 것이라서 자바 랭의 클래스인 스트링은 그냥 쓸 수 있음

// 외부에서 사용하기 위해서는 패키지.클래스 의 풀네임을 알아야한다.
// fc.java.part3.BookDTO
public class BookDTO {
    public String title;
    public int price;
    public String company;
    public String author;
    public int page;
    public String isbn;
}
