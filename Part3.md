# Java Part3

## 1. 라이브러리와 모듈

### 1-1. 라이브러리

라이브러리는 프로그램 개발 시 활용할 수 있는 클래스와 인터페이스들을 모아놓은 것이다.
일반적으로 JAR(Java ARchive)압축파일 형태로 존재한다. JAR 파일에는 클래스와 인터페이스의 바이트 코드 파일(~.class)들이 압축되어 있다.

특정 클래스와 인터페이스가 여러 응용프로그램을 개발할 때 공통으로 자주 사용된다면 JAR 파일로 압축해서 라이브러리로 관리하는 것이 좋다. (참고 : 이클립스는 JavaProject를 생성해서 클래스와 인터페이스를 개발하고 최종 산출물로 JAR 파일을 만드는 기능이 있다.)

프로그램 개발 시 라이브러리를 사용하려면 라이브러리 JAR파일을 ClassPath에 추가해야한다. ClassPath란 말 그대로 클래스를 찾기 위한 경로이다. ClassPath에 라이브러리를 추가하는 방법은 다음과 같다.

-   콘솔에서 프로그램을 실행할 경우
    java 명령어를 실행할 때 -classpath로 제공
    CLASSPATH 환경 변수에 경로를 추가

-   이클립스 프로젝트에서 실행할 경우
    프로젝트의 Build Path에 추가

### 1-2. 모듈

Java 9부터 지원하는 모듈은 패키지 관리 기능까지 포함한 라이브러리다. 일반 라이브러리는 내부에 포함된 모든 패키지에 외부 프로그램에서 접근이 가능하지만, 모듈은 일부 패키지를 은닉하여 접근할 수 없게끔 할 수 있다.

또한 모듈은 자신이 실행할 때 필요로하는 의존 모듈을 모듈 기술자(module-info.java)에 기술할 수 있기 때문에 모듈 간의 의존 관계를 쉽게 파악할 수 있다.

모듈도 라이브러리이므로 JAR파일 형태로 배포할 수 있다. 응용프로그램을 개발할 때 원하는 기능을 모듈(JAR) 파일을 다운로드해서 이용하면 된다.

대규모 응용프로그램은 기능별로 모듈화(modulization)해서 개발할 수도 있다. 모듈별로 개발하고 조립하는 방식을 사용하면 재사용성 및 유지보수에 유리하다.

#### 응용프로그램 모듈화

응용프로그램은 하나의 프로젝트로도 개발 가능하지만, 이것을 기능별로 서브 프로젝트(모듈)로 쪼갠 다음 조합해서 개발할 수도 있다. 응용프로그램의 규모가 커질수록 협업과 유지보수 측면에서 서브 모듈로 쪼개서 개발하는 것이 유리하며, 이렇게 개발된 모듈들은 다른 응용프로그램에서도 재사용 가능하다.

#### 모듈 생성

-   모듈 소스 코드 작성
-   [마우스 오른쪽] - [ Export ] - [ Java ] - [JAR file] - [src폴더만 체크]

    // 의존성 설정 module-info.java
    module 모듈명 {
    requires 모듈명
    }

#### 패키지 은닉

모듈은 모듈 기술자(module-info.java)에서 export 키워드를 사용해 내부 패키지 중 외부에서 사용할 패키지를 지정한다. export되지 않은 패키지는 자동적으로 은닉된다.

    // module-info.java
    module 모듈명 {
        exprot 패키지명;
    }

#### 전이 의존

ㄱ이라는 모듈이 a, b라는 두 모듈에 의존하고 있다가  
ㄱ이 a를 a가 b를 의존하는 형태로 바뀐 경우,  
ㄱ이 b의 요소들을 더 이상 쓸 수 없어 컴파일오류가 발생할 수 있다.  
이런 경우 중간에 있는 a모듈에 trasitive 키워드 설정해 해결할 수 있다.

    // 의존성 설정 module-info.java
    module 모듈명 {
        requires transitive 모듈명
    }

#### 집합 모듈

집합 모듈은 여러 모듈을 모아놓은 모듈을 말한다. 자주 사용되는 모듈들을 일일이 requires하는 번거로움을 피하고 싶을 때 집합 모듈을 생성하면 편리하다. 집합 모듈은 자체적인 패키지를 가지지 않고, 모듈 기술자에 전이 의존 설정만 한다.
(집합 모듈이 여러 모듈들에게 의존하고 그것을 요구하는 모듈에게 넘겨주는 매커니즘인듯)

    module 집합모듈명 {
        requires transitive 모듈1
        requires transitive 모듈2
    }

#### 리플렉션 허용

은닉된 패키지는 기본적으로 다른 모듈에 의해 리플랙션을 허용하지 않는다. 리플렉션이란 실행 도중에 타입(클래스, 인터페이스 등)을 검사하고 구성 멤버를 조사하는 것을 말한다. 경우에 따라서는 은닉된 패키지도 리플랙션을 허용해야할 때가 있다.

    // 모듈 전체를 리플렉션 허용
    open module 모듈명 {
        ...
    }

    // 지정된 패키지에 대해 리플렉션 허용
    module 모듈명 {
        opens 패키지1;
        opens 패키지2;
    }

    // 지정된 패키지에 대해 특정 외부 모듈에서만 리플렉션 허용
    module 모듈명 {
        opens 패키지1 to 외부모듈명, 외무보듈명, ...;
        opens 패키지2 to 외부모둘명;
    }

### 1-3. API 도큐먼트
자바 표준 모듈에서 제공하는 라이브러리는 방대하기 때문에 쉽게 찾아서 사용할 수 있도록 도와주는 API(applicaiton Programming Interface) 도큐먼트가 있다. 라이브러리가 클래스와 인터페이스의 집합이라면, API 도큐먼트는 이를 사용하기 위한 방법을 기술한 것이다.

[JAVA](https://docs.oracle.com/en/java/javase/index.html)  
[JAVA17](https://docs.oracle.com/en/java/javase/17/docs/api/index.html)

SUMMARY
- NESTED : 중첩 클래스/중첩 인터페이스 목록으로 이동하는 링크
- FIELD : 필드 목록으로 이동하는 링크
- CONSTR : 생성자 목록으로 이동하는 링크
- METHOD : 메소드 목록을 이동하는 링크	
    - All Methods : 모든 메소드 목록을 보여준다.
    - Static Methods : 정적 메소드 목록을 보여준다.
    - Instance Methods : 인스턴스 메소드 목록을 보여준다.
    - Concreate Methods : 완전한 실행부를 갖춘 메소드 목록을 보여준다.
    - Deprecated Methods : 향후 제거될 메소드 목록을 보여준다. 

### 1-4. java.base 모듈
java.base는 모든 모듈이 의존하는 기본 모듈로, 모듈 중 유일하게 requires하지 않아도 사용할 수 있다. 

|패키지|용도|
|----|----|
|java.lang|자바 언어의 기본 클래스를 제공|
|java.util|자료 구조와 관련된 컬렉션 클래스를 제공|
|java.text|날짜 및 숫자를 원하는 형태의 문자열로 만들어 주는 포맷 클래스를 제공|
|java.time|날짜 및 시간을 조작하거나 연산하는 클래스를 제공|
|java.io|입출력 시트름 클래스를 제공|
|java.net|네트워크 통신과 관련된 클래스를 제공|
|java.nio|데이터 저장을 위한 Buffer 및 새로운 입출력 클래스 제공|

<br>

|클래스|용도|
|----|----|
|Obejct|자바 클래스의 최상위 클래스로 사용|
|System|- 키보드로부터 데이터를 입력받을 때 사용|
||- 모니터(콘솔)로 출력하기 위해 사용|
||- 프로세스를 종료 시킬 때 사용|
||- 진행 시간을 읽을 때 사용|
||- 시스템 속성(프로퍼티)을 읽을 때 사용|
|String|문자열을 저장하고 조작할 때 사용|
|StringBuilder|효율적인 문자열 조작 기능이 필요할 때 사용|
|java.util.StringTokenizer|구분자로 연결된 문자열을 분리할 때 사용|
|Byte, Short, Character, Integer, Float, Double, Boolean,|- 기본타입 값을 포장할 때 사용|
||- 문자열을 포장할 때 사용|
|Math|수학 계산이 필요할 때 사용|
|Class|클래스의 메타정보(이름, 구성 멤버) 드을 조사할 때 사용|

### objec 클래스
클래스를 선언할 때 extends 키워드로 다른 클래스를 상속하지 않으면 암시적으로 java.lang.Obejct 클래스를 상속하게 된다. 따라서 모든 클래스는 Object의 자식이거나 자손이다. 따라서 Object가 가진 메소드는 모든 객체에서 사용할 수 있다.
- boolean equals(Object obj); : 객체의 번지를 비교하여 결과 리턴
- int hashCode(); : 객체의 해시코드 리턴
- String toString(); : 객체 문자 정보 리턴
'클래스명@16진수해시코드'로 구성된 문자열 리턴

### 레코드 선언
데이터 전달을 위한 DTO를 작성할 때 반복적으로 사용되는 코드를 줄이기 위해 Java 14부터 레코드(record)가 도입되었다. 

    // 원래 코드
    public class Person {
      private final String name;
        private finalt int age;
        
        public Person(String name, int age) {
          this.name = name;
            this.age = age;
        }
        
        public String name() { return this.name; }
        public String age() { return this.age; }
      
        @Override
        public int hashCode() {...}
        @Override
        public boolean equals(Object obj) {...}
        @Override
        public String toString() {...}
    }

위와 동일한 코드를 생성하는 레코드 선언   
(1) 클래스 대신 record 키워드 쓰고,  
(2) 클래스명 뒤에 괄호를 작성하고 저장할 데이터 종류 변수 선언  

    public record Person(String name, int age) {
    }

이렇게 선언하면 컴파일하면서 변수 타입과 이름을 이용해 자동으로 private final피드가 생성되고, 생성자 및 Getter 메소드가 자동으로 추가된다. 그리고 hasCode(), equals(), toString() 메소드를 재정의한 코드도 자동으로 추가된다.

#### 롬복(Lombok) 사용하기
롬복은 JDK에 포함된 표준 라이브러리는 아니지만 개발자들이 즐겨쓰는 자동 생성 라이브러리이다.
롬복은 레코드와 마찬가지로 DTO 클래스를 작성할 때 Getter, Setter, hashCode(), equals(), toString()메소드를 자동 생성하기 때문에 작성할 코드의 양을 줄여준다.  
  
레코드와의 차이점은 필드가 final이 아니며, 값을 읽는 Getter는 getXxx(또는 isXxx)로, 값을 변경하는 Setter는 setXxx로 생성된다는 것이다.

- 롬복을 설치
(1) https://projectlombok.org/dowload에서 다운
(2) 터미널창에서 다운 받음 lombok.jar 파일이 있는 곳을 이동
(3) java -jar lombok.jar
(4) 다운로드한 lombok.jar 파일을 lib 폴더로 복사
(5) 마우스 우클릭 - Build Path - Add to Build Path

      import lombok.Data;

      @Data
      public class Member {
        private String id;
          private String name;
          private int age;
      }

@Data가 붙게 되면 컴파일 과정에서 기본 생성자와 함께 Getter, Setter, hasCode(), equals(), toString()메소드가 자동 생성된다.

@Data 외에도 다양한 어노티에션을 사용할 수 있다.

|어노테이션|설명|
|----|----|
|@NoArgsConstructor|기본(매개변수가 없는) 생성자 포함|
|@AllArgsConstructor|모든 필드를 초기화시키는 생성자 포함|
|@RequiredArgsConstructor|기본적으로 매개변수가 없는 생성자 포함, 만약 final 또는 @NonNull이 붙은 필드가 있다면 이 필드만 초기화 시키는 생성자 포함|
|@Getter|Getter 메소드 포함|
|@Setter|Seter 메소드 포함|
|@EqualsAndHashCode|equals()와 hashCode() 메소드 포함|
|@ToString|toString()메소드 포함|

<br>

### 1-5. System 클래스
운영체제의 일부기능을 사용할 수 있도록 도와주는 클래스

|정적멤버||용도|
|-|-|-|
|필드|out|콘솔(모니터)에 문자 출력|
||err|콘솔(모니터)에 에러 내용 출력|
||in|키보드 입력|
|메소드|exit(int status)|프로세스 종료|
||currentTimeMills()|현재 시간을 미리초 단위의 long 값으로 리턴|
||nanotime()|현재 시간을 나노초 단위의 long 값으로 리턴|
||getProperty()|운영체제와 사용자 정보 제공|
||getenv()|운영체제의 환경 변수 정보 제공|

<br>

#### 콘솔 출력 (에러 출력)
err필드도 out필드와 동일한데 콘솔의 종류에 따라 내용이 빨간색으로 출력되기도 한다.

    public staic void main(String[] args) {
      try {
          int vlaue = Integer.parseInt("1oo");
        } catch(NumberFormatException e) {
          System.err.println("[에러 내용]");
            System.err.println(e.getMessage());
        }
    }

#### 키보드 입력
in 필드를 통해 read() 메소드를 호출하면 입려된 키의 코드값을 얻을 수 있다. (키보드 입력 값 그대로 읽히는 것 아님)
  
메소드 호출과 동시에 키값을 받아오는 것이 아니라 enter 키를 누르기 전까지는 대기하다가 enter 키를 누르면 입력했던 키들을 하나씩 읽기 시작한다.   
  
단, read() 메소드는 IOException이 발생할 수 있는 코드이므로 예외 처리가 필요하다.

    int keyCode = System.in.read();


#### 프로세스 종료
운영체제는 실행 중인 프로그램을 프로세스(process)로 관리한다. 자바 프로그램을 시작하면 JVM 프로세스가 생성되고, 이 프로세스가 main() 메소드를 호출한다. 프로세스를 강제 종료하고 싶다면 System.exit()메소드를 사용한다.  
  
exit() 메소드는 int 매개값이 필요한데, 이 값을 종료 상태값이라고 한다. 종료 상태값으로 어떤 값을 주더라도 프로세스는 종료되는데 정상 종료일 경우 0, 비정상 종료는 1 또는 -1로 주는 것이 관례이다.  

    System.exit(int status)

#### 진행 시간 읽기
#### 시스템 프로퍼티 일기

<br>

## 1-6. 문자열 클래스
#### String 클래스
#### StringBuilder 클래스
#### StringTokenizer 클래스

<br>

## 1-7. 포장 클래스
자바는 기본 타입의 값을 갖는 객체를 생성할 수 있는데 이런 객체를 포장(wrapper)객체라고 한다. 포장 객체는 char, int타입이 각각 Character와 Integer인 것만을 제외하곤 기본 타입의 첫 글자를 대문자로 바꾼 이름을 가지고 있다. 

포장 객체는 포장하고 있는 기본 타입의 값을 변경할 수 없고, 단지 객체로 생성하는 데 목적있다.

#### 박싱과 언박싱
기본 타입의 값을 포장 객체로 만드는 과정을 박싱이라고하고, 반대로 포장 객체에서 기본 타입의 값을 얻어내는 과정을 언박싱 이라고 한다.
  
박싱은 포장 클래스 변수에 기본 타입이 대입될 때 발생한다. 반대로 언박싱은 기본 타입 변수에 포장 객체가 대입될 때 발생한다. (언박싱은 박싱된 객체를 연산하는 과정에서도 발생한다)

    Integer obj = 100;	// 박싱
    int value1 = obj;	// 언박싱
    int value2 = obj + 50; 	// 언박싱 후 연산 

#### 포장 값 비교
포장 값은 비교하기 위해 ==와 !=연산자를 사용할 수 없다. 이 연산은 내부의 값을 비교하는 것이 아니라 포장 객체의 번지를 비교하기 때문이다.

<br>

### 1-8. 수학 클래스

    자료형 변수명 = Math.abs(숫자);	// 절대값
    자료형 변수명 = Math.ceil(숫자);	// 올림값 
    자료형 변수명 = Math.floor(숫자);	// 버림값
    자료형 변수명 = Math.round(숫자);	// 반올림 값
    자료형 변수명 = Math.random();	// 랜덤 값
    자료형 변수명 = Math.max(숫자1, 숫자2, ...);	// 최대값
    자료형 변수명 = Math.min(숫자1, 숫자2, ...);	// 최소값 

<br>

### 1-9. 날짜와 시간 클래스

    Calendar now = Calendar.getInstance();      // Calendar 객체 얻기

    int year = now.get(Calendar.YEAR);          // 연
    int month = now.get(Calendar.MONTH)+1;      // 월(1~12)
    int day = now.get(Calendar.DAY_OF_MONTH);   // 일
    int week = now.get(Calendar.DAY_OF_WEEK);   // 요일(1~7)
    int amPm = now.get(Calender.AM_PM);			// 오전,오후 리턴
    int hour = now.get(Calendar.HOUR);          // 시간
    int minute = now.get(Calendar.MINUTE);      // 분
    int second = now.get(Calendar.SECOND);      // 초

<br>

### 1-10. 형식 클래스
형식 클래스는 숫자 또는 날짜를 원하는 형태의 문자열로 변환해주는 기능을 제공한다. Format클래스는 java.text 패키지에 포함되어 있다.

- DecimalFormat : 숫자를 형식화된 문자열로 변환

|기호|의미|패턴 예|1234567.89 -> 변환결과|
|---|---|------|---------------------|
|0|10진수(빈자리는 0으로 채움)|0|123456789|
|||0.0|1234567.0|
|||0000000000.00000|0001234567.89000|
|#|10진수(빈자리는 채우지 않음)|##########.#####|1234567.89|
|.|소수점|#.0|12345678.9|
|-|음수 기호|+#.0|+1234567.9|
|||-#.0|-1234567.9|
|,|단위 구분|#,###.0|1,234,567.9|
|E|지수 문자|0.0E0|1.2E6|
|;|양수와 음수의 패턴을 모두 기술할 경우, 패턴구분자|+#,###; -#,###|+1,234,568(양수일때)|
||||-1,234,568(음수일때)|
|%|%문자|#.# %|123456789%|
|\u00A4|통화 기호|\u00A4 #.###|1,234,568|


    DecimalFormat df = new DecimalFormat("#,###.0");
    String result = df.format(1234567.89);	//1,234,567.9

- SimpleDateFormat : 날짜를 형식화된 문자열로 변환

|패턴문자|의미|패턴 문자|의미|
|------|---|--------|----|
|y|년|||
|M|월|||
|d|일|||
|D|월 구분 없는 일(1~365)|||
|E|요일|||
|a|오전/오후|||
|w|년의 몇 번째 주|||
|W|월의 몇 번째 주|||

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
    String strDate = sdf.format(new Date());	// 2021년 11월 28일

<br>

#@# 2-8. 정규표현식(Regular Expression) 클래스
문자열이 정해져 있는 형식으로 구성되어 있는지 검증해야 하는 경우 정규 표현식을 이용해서 문자열이 올바르게 구성되어 있는지 검증한다.

![](https://velog.velcdn.com/images/yun9yu/post/5de2a64f-bf7a-4b65-9272-c95078424f71/image.png)

#### Pattern 클래스로 검증
java.util.regex 패키지의 Pattern 클래스는 정규 표현식으로 문자열을 검증하는 matches() 메소드를 제공한다. 

    boolean result = Pattern.matches("정규식", "검증할 문자열");

### 1-11. 리플렉션(reflection)
자바는 클래스와 인터페이스의 메타 정보를 Class 객체로 관리한다. 여기서 메타 정보란 패키지 정보, 타입 정보, 멤버(생성자, 필드, 메소드) 정보 등을 말한다. 이러한 메타 정보를 프로그램에서 읽고 수정하는 행위를 리플랙션 이라고 한다.

    // 클래스로부터 얻는 방법1
    Class clazz1 = 클래스이름.class;

    // 클래스로부터 얻는 방법2
    Class clazz2 = Class.forName("패키지...클래스명");

    // 객체로부터 얻는 방법
    Class clazz3 = 객체참조변수.getClass();

#### 패키지와 타입 정보 얻기
#### 멤버 정보 얻기
#### 리소스 경로 얻기

<br>

### 1-12. 어노테이션(Annotation)
코드에서 @으로 작성되는 요소를 어노테이션이라고 한다. 어노테이션은 클래스 또는 인터페이스를 컴파일하거나 실행할 때 어떻게 처리해야 할 것인지를 알려주는 설정 정보이다. 
- 컴파일 시 사용하는 정보 전달
- 빌드 툴이 코드를 자동으로 생성할 때 사용하는 정보 전달
- 실행 시 특정 기능을 처리할 때 사용하는 정보 전달

#### 어노테이션 타입 정의와 적용

    // 정의
    public @interface AnnotationName {
        ...
    }
    
    //적용
    @AnnotationName

<br>
<br>
<br>

## 2. 제네릭(Generic)
제네릭이란 결정되지 않은 타입을 파라미터로 처리하고 실제 사용할 때 파라미터를 구체적인 타입으로 대체시키는 기능이다.

    // 박스에 어떤 자료가 담길지 몰라 타입을 특정할 수 없다.
    public class Box {
        public ? content;	
    }
    
    // 모든 클래스의 최상위 부모인 Object 클래스로 하면 된다.
    public class Box {
        public Object content;
    }

    Box box = new Box();
    box.content = 모든 객체;

문제는 Box안에서 내용물을 얻을 때다. content는 Object 타입이므로 어떤 객체가 대입되어 있는지 확실하지 않다. 따라서 Box를 생성할 때 저장할 내용물의 타입을 미리 알려주면 Box는 content에 무엇이 대입되고, 읽을 때 어떤 타입으로 제공할지를 알게 된다. 이것이 제네릭이다.


다음은 Box 클래스에서 결정되지 않은 content의 타입을 T라는 타입 파라미터로 정의한 것이다.

    public class Box <T> {
        public T content;
    }

< T >는 T가 타입 파라미터임을 뜻하는 기호로, 타입이 필요한 자리에 T를 사용할 수 있음을 알려주는 역할을 한다. 여기에 Box클래스는 T를 content 필드의 타입으로 사용하였다. 즉, Box 클래스는 T가 무엇인지 모르지만, Box 객체가 생성될 시점에 다른 타입으로 대체된다는 것을 알고있다.(T 대신 A~Z 어떤 것이든 가능)

만약 Box의 내용물로 String을 저장하고 싶다면 다음과 같이 Box를 생성할 때 타입 파라미터 T 대신 String으로 대체하면 된다. Integer역시 마찬가지이다.

    Box<String> box = new Box<String>();
    box.content = "안녕하세요";
    // 강제타입 변환 없이 바로 얻을 수 있다.
    String content = box.content;	
    
    Box<Integer> box = new Box<Integer>();
    box.content = "100";
    // 강제타입 변환 없이 바로 얻을 수 있다.
    int content = box.content;

**주의!** 타입 파라미터를 대체하는 타입은 클래스 및 인터페이스 이다. 바로 위 코드에서 Box<int>라고 하지 않은 이유는 기본 타입은 타입 파라미터의 대체 타입이 될 수 없기 때문이다.

그리고 변수를 선언할 때와 동일한 타입으로 호출하고 싶다면 생성자 호출 시 생성자에는 타입을 명시하지 않고 <>만 붙일 수 있다.


    Box<String> box = new Box<String>();
    -> Box<String> box = new Box(); 
    
    Box<Integer> box = new Box<Integer>();
    -> Box<Integer> box = new Box();

### 2-1. 제네릭 타입
제네릭 타입은 결정되지 않은 타입을 파라미터로 가지는 클래스와 인터페이스를 말한다. 제네릭 타입은 선언부에 '<>'부호가 붙고 그 사이에 타입 파라미터들이 위치한다. 
 
    public class 클래스명<A, B, ...> {...}
    public interface 인터페이스명<A, B, ...> {...}
  
외부에서 제네릭 타입을 사용하려면 타입 파라미터에 구체적인 타입을 지정해야한다. 만약 지정하지 않으면 Object 타입이 암묵적으로 사용된다.
  
      // 제네릭 타입
      public class Product<K, M> {	// 타입 파라미터로 K, M 사용
        // 필드
        private K kind;
        private M model;
  
        // 메소드
        // 타입파라미터를 리턴 타입과 매개변수 타입으로 사용
        public K getKind() { return this.kind; }
        public M getModel() { return this.model; }
        public void setKind(K kind) {this.kind = kind; }
        public vlid setModel(M model) {this.model = model; }
      }
  

#### 제네릭 메소드
  제네릭 메소드는 타입 파라미터를 가지고 있는 메소드를 말한다. 타입 파라미터가 메소드 선언부에 정의된다는 점에서 제네릭 타입과 차이가 있다. 
  
	public <A, B, ...> 리턴타입 메소드명(매개변수, ...) {...}

<br>
<br>
<br>

## 3. 멀티 스레드
스레드는 코드의 실행흐름을 말하는데, 프로세스 내에 스레드가 두 개라면 두 개의 코드 실행 흐름이 생긴다는 의미이다. 멀티 프로세스가 프로그램 단위의 멀티 태스킹이라면, 멀티 스레드는 프로그램 내부에서의 멀티 태스킹이라 볼 수 있다. 
  
멀티 프로세스들은 서로 독립적이므로 하나의 프로세스에서 오류가 발생해도 다른 프로세스에게 영향을 미치지 않는다. 하지만 멀티 스레드는 프로세스 내부에서 생성되기 때문에 하나의 스레드가 예외를 발생시키면 프로스세가 종료되므로 다른 스레드에게 영향을 미친다. 그렇기 때문에 멀티 스레드를 사용할 경우에는 예외 처리에 만전을 기해야 한다.

####  메인 스레드
모든 자바 프로그램은 메인 스레드가 main() 메소드를 실행하면서 시작된다. 메인 스레드는 main() 메소드의 첫 코드부터 순차적으로 실행하고, main() 메소드의 마지막 코드를 실행하거나 return 문을 만나면 실행을 종료한다. 
  
메인 스레드는 필요에 따라 추가 작업 스레드들을 만들어서 실행시킬 수 있다. 싱글 스레드에서는 메인 스레드가 종료되면 프로세스도 종료된다. 하지만 멀티 스레드에서는 실행중인 스레드가 하나라도 있다면 프로세스는 종료되지 않는다. 메인 스레드가 작업 스레드보다 먼저 종료되더라도 작업 스레드가 계속 실행 중이라면 프로세스는 종료되지 않는다.
  
### 3-1. 작업 스레드 생성과 실행
멀티 스레드로 실행하는 프로그램을 개발하려면 먼저 몇 개의 작업을 병렬로 실행할지 결정하고 각 작업별로 스레드를 생성해야 한다. 자바 프로그램은 메인 스레드가 반드시 존재하기 때문에 메인 작업 이외에 추가적인 작업 수만큼 스레드를 생성하면 된다. 
  
자바는 작업 스레드도 객체로 관리하므로 클래스가 필요하다. Thread 클래스로 직접 객체를 생성해도 되지만, 하위 클래스를 만들어 생성할 수도 있다.
  
#### Thread 클래스로 직접 생성
java.lang 패키지에 있는 Thread 클래스로부터 작업 스레드 객체를 직접 생성하려면 다음과 같이 Runnable 구현 객체를 매개값으로 갖는 생성자를 호출하면 된다. 

    Thread thread = new Thread(Runnable target);

Runnable은 스레드가 작업을 실행할 때 사용하는 인터페이스이다. Runnable에는 run() 메소드가 정의되어 있는데, 구현 클래스는 run()을 재정의해서 스레드가 실행할 코드를 가지고 있어야 한다.
  
    class Task implements Runable {
      @Override
      public void run() { 
        // 스레드가 실행할 코드		
      }
    }
  
Runnable 구현 클래스는 작업 내용을 정의한 것이므로, 스레드에게 전달해야 한다. Runnable 구현 객체를 생성한 후 Thread 생성자 매개값으로 Runnable 객체를 다음과 같이 전달하면 된다.
  
  	Runnable task = new Task();
  	Thread thread = new Thread(task);

  
명시적인 Runnable 구현 클래스를 작성하지 않고 Thread 생성자를 호출할 때 Runnable 익명 구현 개체를 매개값으로 사용할 수 있다.
(오히려 이 방법이 더 많이 사용된다.)
  
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        // 스레드가 실행할 코드
      }
    });
    
    // 작업 스레드 실행
    thread.start();
  
#### Thread 자식 클래스로 생성
Thread 클래스를 상속한 다음 run() 메소드를 재정의해서 스레드가 실행할 코드를작성하고 객체를 생성하면 된다.
  
    public class WorkerThread extends Thread {
      @Override
      public void run() {
        // 스레드가 실행할 코드
      }
    }
    
      //스레드 객체 생성
      Thread thread = new WorkerThread();
    
      //스레드 실행
      thread.start();

명시적인 자식 클래스를 정의하지 않고, 다음과 같이 Thread 익명 자식 객체를 사용할 수도 있다. (오히려 이 방법이 더 많이 사용된다.)
  
    Thread thread = new Thread() {
      @Overried
      public void run() {
        // 실행할 코드
      }
    }
    thread.start();


#### 스레드 이름
스레드는 자신의 이름을 가지고 있다. 메인 스레드는 'main'이라는 이름을 가지고 있고, 작업 스레드는 자동적으로 'Thread-n'이라는 이름을 가진다. 작업 스레드의 이름을 Thread-n 대신 다른 이름으로 설정하고 싶다면 Thread 클래스의 setName() 메소드를 사용하면 된다.
  
    thread.setName("스레드 이름");

스레드 이름은 디버깅할 때 어떤 스레드가 작업을 하는지 조사할 목적으로 주로 사용된다. 현재 코드를 어떤 스레드가 실행하고 있는지 확인하려면 정적 메소드인 currentThread()로 스레드 객체의 참조를 얻은 다음 getName() 메소드로 이름을 출력해보면 된다.
  
    Thread thread = Thread.currentThread();
    System.out.println(thread.getName());
  
### 3-2. 스레드 상태
스레드 객체를 생성(NEW)하고, start() 메소드를 호출하면 곧바로 스레드가 실행되는 것이 아니라 실행 대기 상태(RUNNABLE)가 된다.

실행 대기하는 스레드는 CPU 스케쥴링에 따라 CPU를 점유하고 run() 메소드를 실행한다. 이때를 실행(RUNNING) 상태라고 한다. 실행 스레드는 run() 메소드를 모두 실행하기 전에 스케줄링에 의해 다시 실행 대기 상태로 돌아갈 수 있다. 그리고 다른 스레드가 실행 상태가 된다.

이렇게 스레드는 실행 대기 상태와 실행 상태를 번갈아 가면서 자신의 run() 메소드를 조금씩 실행한다. 실행 상태에서 run() 메소드가 종료되면 더 이상 실행할 코드가 없기 때문에 스레드의 실행은 멈추게 된다. 이 상태를 종료 상태(TERMINATED)라고 한다.
  
실행 상태에서 일시정지 상태로 가기도 하는데, 일시정지 상태는 스레드가 실행할 수 없는 상태를 말한다.
  
|메소드|설명|
|-----|---|
|sleep(long millis)|주어진 시간 동안 스레드를 일시정지로 만든다. 주어진 시간이 지나면 자동적으로 실행 대기 상태가 된다.|
|join()|join()메소드를 호출한 스레드는 일시 정지 상태가 된다. 실행 대기 상태가 되려면, join() 메소드를 가진 스레드가 종료되어야한다. |
|wait()|동기화 블록 내에서 스레드를 일시 정지 상태로 만든다.|
|interrupt()|일시 정지 상태일 경우, InterruptedException을 발생시켜 실행 대기 상태 또는종료 상태로 만든다.|
|notify(), notifyAll()|wait()메소드로 인해 일시정지 상태인 스레드를 다시 실행 대기 상태로 만든다.|
|yield()|실행 상태에서 다른 스레드에게 실행을 양보하고 실행 대기 상태가 된다.|
  
#### 주어진 시간동안 일시정지
일시 정지 상태에서는 InterruptedExcoption이 발생할 수 있기 때문에 sleep()은 예외 처리가 필요한 메소드이다.
  
    try { 
      Thread.sleep(1000); 
    } catch(InterruptedException e) {
        // interrupt() 메소드가 호출되면 실행  
    } 
  
#### 다른 스레드의 종료를 기다림
스레드는 다른 스레드와 독립적으로 실행하지만 다른 스레드가 종료될 때까지 기다렸다가 실행을 해야 하는 경우도 있다. 이를 위해 스레드는 join() 메소드를 제공한다. 

    // ThreadA
      threadB.start();
      threadB.join();	//ThreadB 완료 전까지 ThreadA 일시정지
    
    // ThreadB
      run()  
  
#### 다른 스레드에게 실행 양보
스레드가 처리하는 작업은 반복적인 실행을 위해 for 문이나 while 문을 포함하는 경우가 많은데, 가끔 반복문이 무의미한 반복을 하는 경우가 있다. 아래 코드에서 work의 값이 false 면 while 문은 어떠한 실행문도 실행하지 않고 무의미한 반복을 한다. 
  
    public void run() {
      while(true) {
        if(work) {
            System.out.println("ThreadA 작업 내용");
        }
      }	  
    }
  
이때는 다른 스레드에게 실행을 양보하고 자신은 실행 대기 상태로 가는 것이 프로그램 성능에 도움이 된다. 이런 기능을 위해 Thread는 yield() 메소드를 제공한다. yield()를 호출한 스레드는 실행 대기 상태로 돌오가고, 다른 스레드가 실행 상태가 된다. 
  
    // 무의미한 반복을 하지 않도록 앞의 코드를 수정
    public void run() {
      while(ture) {
        if(work) {
            System.out.println("ThreadA 작업내용");
        } else {
          Thread.yiel();
        }	
      }  
    }
  
### 3-3. 스레드 동기화
멀티 스레드는 하나의 객체를 공유해서 작업할 수도 있다. 이 경우, 다른 스레드에 의해 객체 내부 데이터가 쉽게 변경될 수 있기 때문에 의도했던 것과는 다른 결과가 나올 수 있다. 

스레드가 사용 중인 객체를 다른 스레드가 변경할 수 없도록 하려면 스레드 작업이 끝날 때까지 객체에 잠금을 걸면 된다. 이를 위해 자바는 동기화(synchronized) 메소드와 블록을 제공한다.
  
객체 내부에 동기화 메소드와 동기화 블록이 여러 개가 있다면 스레드가 이들 중 하나를 실행할 때, 다른 스레드는 해당 메소드는 물론이고 다른 동기화 메소드 및 블록도 실행할 수 없다. 하지만 일반 메소드는 실행이 가능하다. 

#### 동기화 메소드 및 블록 선언
동기화 메소드를 선언하는 방법은 다음과 같이 synchronized 키워드를 붙이면 된다. synchronized 키워드는 인스턴스와 정적 메소드 어디든 붙일 수 있다.  
  
    public synchronized void method() {
        // 단 하나의 스레드만 실행하는 영역
    }
  
스레드가 동기화 메소드를 실행하는 즉시 객체는 잠금이 일어나고, 메소드 실행이 끝나면 잠금이 풀린다. 메소드 전체가 아닌 일부 영역을 실행할 때만 객체 잠금을 걸고 싶다면 아래와 같이 동기화 블록을 만들면 된다.
  
    public void method() {
      // 여러 스레드가 실행할 수 있는 영역
      synchronized(공유객체) {
        // 단 하나의 스레드만 실행하는 영역
      }
      //여러 스레드가 실행할 수 있는 영역
    }

#### wait()과 notify()를 이용한 스레드 제어
경우에 따라서는 두 개의 스레드를 교대로 번갈아가며 실행할 때도 있다. 정확한 교대 작업이 필요할 경우, 자신의 작업이 끝나면 상대방 쓰레드를 일시 정지 상태에서 풀어주고 자신은 일시 정지 상태로 만들면 된다.
  
이 방법의 핵심은 공유 객체에 있다. 공유 객체는 두 스레드가 작업할 내용을 각각 동기화 메소드로 정해놓는다. 한 스레드가 작업을 완료하면 notify() 메소드를 호출해서 일시 정지 상태에 있는 다른 스레드를 실행 대기 상태로 만들고, 자신은 두 번 작업을 하지 않도록 (wait) 메소드를 호출하여 일시 정지 상태로 만든다.
  
### 3-4. 스레드 안전 종료
스레드는 자신의 run() 메소드가 모두 실행되면 자동적으로 종료되지만, 경우에 따라서는 실행 중인 스레드를 즉시 종료시킬 필요가 있다. 스레드를 강제 종료시키기 위해 Thread는 stop() 메소드를 제공하고 있으나 이 메소드는 deprecated(더 이상 사용하지 않음)되었다. 그 이유는 스레드를 갑자기 종료하게 되면 사용 중이던 리소스들이 불안전한 상태로 남겨지기 때문이다. 여기에서 리소스란 파일, 네트워크 연결 등을 말한다.
  
스레드를 안전하게 종료하는 방법은 사용하던 리소스들을 정리하고 run() 메소드를 빨리 종료하는 것이다. 주로 조건 이용 방법과 interrupt() 메소드 이용 방법을 사용한다.
  
#### 조건 이용
스레드가 while 문으로 반복 실행할 경우, 조건을 이용해서 run() 메소드의 조건을 유도할 수 있다. 다음 코드는 stop 필드 조건에 따라서 run() 메소드의 종료를 유도한다.

    public class XXXThread extends Thrad {
      private boolearn stop;	// stop 필드 선언  
    
      public void run() {
        while (!stop) {
        // 스레드가 반복실행하는 코드  
        }
        // 스레드가 사용한 리소스 정리
      }
    }
  
#### interrupt() 메소드 이용
interrupt() 메소드는 스레드가 일시 정지 상태에 있을 때 InterruptedException 예외를 발생시키는 역할을 한다. 이것을 이용하면 예외 처리를 통해 run()메소드를 정상종료시킬 수 있다. 

    public void run() {
    try {
      while(true) {
       ...
      Thread.sleep(1); 	// 일시 정지 
      } catch(InterruptedException e){
      }
      //스레드가 사용한 리소스 정리
    }
    
    XThread thread = new XThread();
    thread.start();			//(1)
    ...
    thread.interrupt();		//(2)
  
XThread를 생성해서 start() 메소드를 실행한 후 XThread의 interrupt() 메소드를 실행하면 XThread가 일시 정지 상태가 될 때 InterruptedException이 발생하여 예외 처리 블록으로 이동한다. 
  
### 3-5. 데몬 스레드
데몬(daeman) 스레드는 주 스레드의 작업을 돕는 보조적인 역할을 수행하는 스레드이다. 주 스레드 종료되면 데몬 스레드도 따라서 자동으로 종료된다.
  
스레드를 데몬으로 만들기 위해서는 주 스레드가 데몬이 될 스레드의 (setDaemon(true)를 호출하면 된다.

    public static void main(Strin[] args) {
      AutoSaveThread thread = new AutoSaveThread();
      thread.setDaemon(ture);
      thread.start();
    }
  
### 3-6. 스레드풀(ThreadPool)
병렬 작업 처리가 많아지면 스레드의 개수가 폭증하여 CPU가 바빠지고 메모리 사용량이 늘어난다. 이에 따라 애플리케이션의 성능 또한 급격히 저하된다. 이렇게 병렬 작업 증가로 인한 스레드의 폭증을 막으려면 스레드풀을 사용하는 것이 좋다. (스레드를 만드는 시간도 줄이자)
  
스레드풀은 작업 처리에 사용되는 스레드를 제한된 개수만큼 정해 놓고 작업 큐에 들어오는 작업들을 스레드가 하나씩 맡아 처리하는 방식이다. 작업 처리가 끝난 스레드는 다시 작업 큐에서 새로운 작업을 가져와 처리한다. 이렇게 하면 작업량이 증가해도 스레드의 개수가 늘어나지 않아 애플리케이션의 성능이 급격히 저하되지 않는다.
  
  ![](https://velog.velcdn.com/images/yun9yu/post/99c9f989-b279-4b42-9d54-4b1941d131f2/image.png)
  
#### 스레드풀 생성
자바는 스레드풀을 생성하고 사용할 수 있도록 java.until.concurrent 패키지에서 ExecutorService인터페이스와 Executors 클래스를 공유하고 있다. Executors의 다음 두 정적 메소드를 이용하면 간단하게 스레드풀인 ExecutorService 구현 객체를 만들 수 있다. 
  - newCachedThreadPool() 
  - newFixedThreadPool(int nThreads)

아래 메소드로 생성된 스레드풀의 초기 수와 코어 수는 0개이고, 작업 개수가 많아지면 새 스레드를 생성시켜 작업을 처리한다. 60초 동안 스레드가 아무 작업을 하지 않으면 스레드를 풀에서 제거한다.(작업량이 많아질 수 록 스레드 많아져서 메모리 사용량 예측이 어려워 잘 사용안함)

    ExecutorService excutorService = Executors.newCachedThreadPool();

아래는 메소드로 생성된 스래드풀의 초기 수는 0개이고, 작업 개수가 많아지면 최대 n개 까지 스레드를 생성시켜 작업을 처리한다. 이 스레드 풀의 특징은 생성된 스레드를 제거하지 않는다는 것이다.(제한된 스레드를 써서 메모리 예측은 쉽지만, 대기시간이 길 수 있다.)

    ExecutorService execuotrserive = Executorsl.newFixedThreadPool(n);

위 두 메소드를 사용하지 않고 직접 ThreadPoolExecutor로 스레드풀을 생성할 수도 있다. 다음 예시는 초기 수 0개, 코어 수3개, 최대 수 100개인 스레드풀을 생성하는 코드이다. 그리고 추가된 스레드가 120초 동안 놀고 있을 경우 해당 스레드를 풀에서 제거한다.
  
    ExecutorService threadPool = new ThreadPoolExecutor(
      3,								// 코어 스레드 개수
      100,								// 최대 스레드 개수
      120 L,							// 놀고 있는 시간
      TimeUnit.SECONDS,					// 놀고 있는 시간 단위
      new SynchronousQueue<Runnable>()	// 작업 큐
    );
  
#### 스레드풀 종료
스레드풀의 스레드는 기본적으로 데몬 스레드가 아니기 때문에 main 스레드가 종료되더라도 작업을 처리하기 위해 계속 실행 상태로 남아 있다. 스레드풀의 모든 스레드를 종료하려면 ExecutorSerivce의 다음 두 메소드 중 하나를 실행해야 한다.

| 리턴타입            |메소드명(매개변수)|설명|
|-----------------|---------------|---|
| void            |shutdown()|현재 처리 중인 작업뿐만 아니라 작업 큐에 대기하고 있는 모든 작업을 처리한 뒤에 스레드풀을 종료시킨다.|
| List\<Runnable> |shutdownNow()|현재 작업 처리 중인 스레드를 interrupt해서 작업을 중지시키고 스레드푸을 종료시킨다. 리턴값은 작업 큐에 있는 미처리된 작업(Runnable)의 목록이다.|
 
  
#### 작업 생성과 처리 요청
하나의 작업은 Runnable 또는 Callable 구현 객체로 표현한다. Runnable과 Callable의 차이점은 작업 처리 완료 후 리턴 값이 있는냐 없느냐이다. call()의 리턴 타입은 Callable< T >에서 지정한 T 타입 파리미터와 동일한 타입이어야 한다.  

    // Runnable 익명 구현 객체
    new Runnable() {
      @Override
      public void run() {
        // 스레드가 처리할 작업 내용
      }
    }
    
    // Callable 익명 구현 객체
    new Callable<t>() {
      @Override
      public T call() throws Exception {
        // 스레드가 처리할 작업 내용
        return T;
      }
    }
  
|리턴 타입|메소드명(매개변수)|설명|
|--------|---------------|---|
|void|execute(Runnable command)|- Runable을 작업 큐에 저장|
|||- 작업 처리 결과를리턴하지 않음|
|Future< T >|submit(Callable< T > task)|- Callable을 작업 큐에 저장|
|||- 작업 처리 결과를 얻을 수 있도록 Future를 리턴|

Runable 또는 Callable 객체가 ExecutorService의 작업 큐에 들어가면 ExecutorService는 처리할 스레드가 있는지 보고, 없다면 스레드를 새로 생성시킨다. 스레드는 작업 큐에서 Runnable 또는 Callable 객체를 꺼내와 run() 또는 call() 메소드를 실행하면서 작업을 처리한다. 
