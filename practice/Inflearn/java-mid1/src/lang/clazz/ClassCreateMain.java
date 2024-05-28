package lang.clazz;

public class ClassCreateMain {

    public static void main(String[] args) throws Exception {
        Class helloClass = Hello.class;
        // Class helloClass = Class.forName("lang.clazz.Hello");

        Hello hello = (Hello) helloClass.getDeclaredConstructor().newInstance();   // hello 클래스가 가진 생성자를 얻어서 객체를 생성한다. 반환하면 Object 니까 Hello 로 캐스팅 한다.
        String result = hello.hello();
        System.out.println("hello: " + hello);
        System.out.println("result: " + result);
    }
}
