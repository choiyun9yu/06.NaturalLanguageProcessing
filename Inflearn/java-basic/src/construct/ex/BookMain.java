package construct.ex;

/*
* 문제 -Book과 생성자
* BookMain 코드가 작동하도록 Book 클래스를 완성하세요.
* 특히 Book 클래스의 생성자 코드에 중복이 없도록 주의하세요.
*/

public class BookMain {

    public static void main(String[] args) {
        // 기본 생성자 사용
        Book book1 = new Book();
        book1.displayInfo();

        // title과 autor만ㅇ르 매개변수로 받는 생성자
        Book book2 = new Book("Hello Java", "Seo");
        book2.displayInfo();

        // 모든 필드를 매개변수로 받는 생성자
        Book book3 = new Book("JPA 프로그래밍", "Kim", 700);
        book3.displayInfo();
    }
}
