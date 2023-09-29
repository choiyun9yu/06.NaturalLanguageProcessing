# 1. java.base 모듈

#### API 도큐먼트
자바 표준 모듈에서 제공하는 라이브러리는 방대하기 때문에 쉽게 찾아서 사용할 수 있도록 도와주는 API(applicaiton Programming Interface) 도큐먼트가 있다. 라이브러리가 클래스와 인터페이스의 집합이라면, API 도큐먼트는 이를 사용하기 위한 방법을 기술한 것이다.

https://docs.oracle.com/en/java/javase/index.html
https://docs.oracle.com/en/java/javase/17/docs/api/index.html

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

## 1) java.base 모듈
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

#### objec 클래스
클래스를 선언할 때 extends 키워드로 다른 클래스를 상속하지 않으면 암시적으로 java.lang.Obejct 클래스를 상속하게 된다. 따라서 모든 클래스는 Object의 자식이거나 자손이다. 따라서 Object가 가진 메소드는 모든 객체에서 사용할 수 있다.
- boolean equals(Object obj); : 객체의 번지를 비교하여 결과 리턴
- int hashCode(); : 객체의 해시코드 리턴
- String toString(); : 객체 문자 정보 리턴
'클래스명@16진수해시코드'로 구성된 문자열 리턴

#### 레코드 선언
데이터 전달을 위한 DTO를 작성할 때 반복적으로 사용되는 코드를 줄이기 위해 Java 14부터 레코드(record)가 도입되었다. 

>```java
// 원래 코드
public class Person {
	private final String name;
    private finalt int age;
    >
    public Person(String name, int age) {
    	this.name = name;
        this.age = age;
    }
    >
    public String name() { return this.name; }
    public String age() { return this.age; }
	>
    @Override
    public int hashCode() {...}
    @Override
    public boolean equals(Object obj) {...}
    @Override
    public String toString() {...}
}
```

위와 동일한 코드를 생성하는 레코드 선언 
(1) 클래스 대신 record 키워드 쓰고,
(2) 클래스명 뒤에 괄호를 작성하고 저장할 데이터 종류 변수 선언
>```java
public record Person(String name, int age) {
}
```

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

>```java
import lombok.Data;
>
@Data
public class Member {
	private String id;
    private String name;
    private int age;
}
```

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

## 2) System 클래스
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

>```java
public staic void main(String[] args) {
	try {
    	int vlaue = Integer.parseInt("1oo");
    } catch(NumberFormatException e) {
    	System.err.println("[에러 내용]");
        System.err.println(e.getMessage());
    }
}
```

#### 키보드 입력
in 필드를 통해 read() 메소드를 호출하면 입려된 키의 코드값을 얻을 수 있다. (키보드 입력 값 그대로 읽히는 것 아님)

메소드 호출과 동시에 키값을 받아오는 것이 아니라 enter 키를 누르기 전까지는 대기하다가 enter 키를 누르면 입력했던 키들을 하나씩 읽기 시작한다. 

단, read() 메소드는 IOException이 발생할 수 있는 코드이므로 예외 처리가 필요하다.

>```java
int keyCode = System.in.read();
```

#### 프로세스 종료
운영체제는 실행 중인 프로그램을 프로세스(process)로 관리한다. 자바 프로그램을 시작하면 JVM 프로세스가 생성되고, 이 프로세스가 main() 메소드를 호출한다. 프로세스를 강제 종료하고 싶다면 System.exit()메소드를 사용한다.

exit() 메소드는 int 매개값이 필요한데, 이 값을 종료 상태값이라고 한다. 종료 상태값으로 어떤 값을 주더라도 프로세스는 종료되는데 정상 종료일 경우 0, 비정상 종료는 1 또는 -1로 주는 것이 관례이다.

>```java
System.exit(int status)
```

#### 진행 시간 읽기
#### 시스템 프로퍼티 일기

<br>

## 3) 문자열 클래스
#### String 클래스
#### StringBuilder 클래스
#### StringTokenizer 클래스

<br>

## 4) 포장 클래스
자바는 기본 타입의 값을 갖는 객체를 생성할 수 있는데 이런 객체를 포장(wrapper)객체라고 한다. 포장 객체는 char, int타입이 각각 Character와 Integer인 것만을 제외하곤 기본 타입의 첫 글자를 대문자로 바꾼 이름을 가지고 있다. 

포장 객체는 포장하고 있는 기본 타입의 값을 변경할 수 없고, 단지 객체로 생성하는 데 목적있다.

#### 박싱과 언박싱
기본 타입의 값을 포장 객체로 만드는 과정을 박싱이라고하고, 반대로 포장 객체에서 기본 타입의 값을 얻어내는 과정을 언박싱 이라고 한다.

박싱은 포장 클래스 변수에 기본 타입이 대입될 때 발생한다. 반대로 언박싱은 기본 타입 변수에 포장 객체가 대입될 때 발생한다. (언박싱은 박싱된 객체를 연산하는 과정에서도 발생한다)

>```java
Integer obj = 100;	// 박싱
int value1 = obj;	// 언박싱
int value2 = obj + 50; 	// 언박싱 후 연산 
```

#### 포장 값 비교
포장 값은 비교하기 위해 ==와 !=연산자를 사용할 수 없다. 이 연산은 내부의 값을 비교하는 것이 아니라 포장 객체의 번지를 비교하기 때문이다.

<br>

## 5) 수학 클래스
>```java
자료형 변수명 = Math.abs(숫자);	// 절대값
자료형 변수명 = Math.ceil(숫자);	// 올림값 
자료형 변수명 = Math.floor(숫자);	// 버림값
자료형 변수명 = Math.round(숫자);	// 반올림 값
자료형 변수명 = Math.random();	// 랜덤 값
자료형 변수명 = Math.max(숫자1, 숫자2, ...);	// 최대값
자료형 변수명 = Math.min(숫자1, 숫자2, ...);	// 최소값 
```


<br>

## 6) 날짜와 시간 클래스

>```java
Calendar now = Calendar.getInstance();
>
int year = now.get(Calendar.YEAR);			// 년 리턴
int month = now.get(Calender.Month) + 1;	// 월 리턴
int day = now.get(Calender.DAY_OF_MONTH);	// 일 리턴
int week = now.get(Calender.DAY_OF_WEEK);	// 요일 리턴
int amPm = now.get(Calender.AM_PM);			// 오전,오후 리턴
int hour = now.get(Calender.HOUR);			// 시 리턴
int minute = now.get(Calender.MINUTE);		// 분 리턴
int second = now.get(Calender.SECOND);		// 초 리턴
```

<br>

## 7) 형식 클래스
형식 클래스는 숫자 또는 날짜를 원하는 형태의 문자열로 변환해주는 기능을 제공한다.
Format클래스는 java.text 패키지에 포함되어 있다.
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

>```java
DecimalFormat df = new DecimalFormat("#,###.0");
String result = df.format(1234567.89);	//1,234,567.9
```

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

>```java
SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
String strDate = sdf.format(new Date());	// 2021년 11월 28일
```

<br>

## 8) 정규표현식(Regular Expression) 클래스
문자열이 정해져 있는 형식으로 구성되어 있는지 검증해야 하는 경우 정규 표현식을 이용해서 문자열이 올바르게 구성되어 있는지 검증한다.

![](https://velog.velcdn.com/images/yun9yu/post/5de2a64f-bf7a-4b65-9272-c95078424f71/image.png)

#### Pattern 클래스로 검증
java.util.regex 패키지의 Pattern 클래스는 정규 표현식으로 문자열을 검증하는 matches() 메소드를 제공한다. 

>```java
boolean result = Pattern.matches("정규식", "검증할 문자열");
```

## 9) 리플렉션(reflection)
자바는 클래스와 인터페이스의 메타 정보를 Class 객체로 관리한다. 여기서 메타 정보란 패키지 정보, 타입 정보, 멤버(생성자, 필드, 메소드) 정보 등을 말한다. 이러한 메타 정보를 프로그램에서 읽고 수정하는 행위를 리플랙션 이라고 한다.

>```java
// 클래스로부터 얻는 방법1
Class clazz1 = 클래스이름.class;
// 클래스로부터 얻는 방법2
Class clazz2 = Class.forName("패키지...클래스명");
// 객체로부터 얻는 방법
Class clazz3 = 객체참조변수.getClass();
```

#### 패키지와 타입 정보 얻기
#### 멤버 정보 얻기
#### 리소스 경로 얻기

<br>

## 10) 어노테이션(Annotation)
코드에서 @으로 작성되는 요소를 어노테이션이라고 한다. 어노테이션은 클래스 또는 인터페이스를 컴파일하거나 실행할 때 어떻게 처리해야 할 것인지를 알려주는 설정 정보이다. 
- 컴파일 시 사용하는 정보 전달
- 빌드 툴이 코드를 자동으로 생성할 때 사용하는 정보 전달
- 실행 시 특정 기능을 처리할 때 사용하는 정보 전달

#### 어노테이션 타입 정의와 적용

>```java
// 정의
public @interface AnnotationName {
	...
}
>
//적용
@AnnotationName
```

<br>

# 2. 제네릭(Generic)
제네릭이란 결정되지 않은 타입을 파라미터로 처리하고 실제 사용할 때 파라미터를 구체적인 타입으로 대체시키는 기능이다.

>```java
// 박스에 어떤 자료가 담길지 몰라 타입을 특정할 수 없다.
public class Box {
	public ? content;	
}
>
// 모든 클래스의 최상위 부모인 Object 클래스로 하면 된다.
public class Box {
	public Object content;
}
Box box = new Box();
box.content = 모든 객체;
>
```

문제는 Box안에서 내용물을 얻을 때다. content는 Object 타입이므로 어떤 객체가 대입되어 있는지 확실하지 않다.

따라서 Box를 생성할 때 저장할 내용물의 타입을 미리 알려주면 Box는 content에 무엇이 대입되고, 읽을 때 어떤 타입으로 제공할지를 알게 된다. 이것이 제네릭이다.


다음은 Box 클래스에서 결정되지 않은 content의 타입을 T라는 타입 파라미터로 정의한 것이다.
>```java
public class Box <T> {
	public T content;
}
```

< T >는 T가 타입 파라미터임을 뜻하는 기호로, 타입이 필요한 자리에 T를 사용할 수 있음을 알려주는 역할을 한다. 여기에 Box클래스는 T를 content 필드의 타입으로 사용하였다. 즉, Box 클래스는 T가 무엇인지 모르지만, Box 객체가 생성될 시점에 다른 타입으로 대체된다는 것을 알고있다.(T 대신 A~Z 어떤 것이든 가능)

만약 Box의 내용물로 String을 저장하고 싶다면 다음과 같이 Box를 생성할 때 타입 파라미터 T 대신 String으로 대체하면 된다. Integer역시 마찬가지이다.

>```java
Box<String> box = new Box<String>();
box.content = "안녕하세요";
// 강제타입 변환 없이 바로 얻을 수 있다.
String content = box.content;	
>
Box<Integer> box = new Box<Integer>();
box.content = "100";
// 강제타입 변환 없이 바로 얻을 수 있다.
int content = box.content;
```

**주의!** 타입 파라미터를 대체하는 타입은 클래스 및 인터페이스 이다. 바로 위 코드에서 Box<int>라고 하지 않은 이유는 기본 타입은 타입 파라미터의 대체 타입이 될 수 없기 때문이다.

그리고 변수를 선언할 때와 동일한 타입으로 호출하고 싶다면 생성자 호출 시 생성자에는 타입을 명시하지 않고 <>만 붙일 수 있다.

>```java
Box<String> box = new Box<String>();
-> Box<String> box = new Box(); 
>
Box<Integer> box = new Box<Integer>();
-> Box<Integer> box = new Box();
```

#### 제네릭 타입
제네릭 타입은 결정되지 않은 타입을 파라미터로 가지는 클래스와 인터페이스를 말한다. 제네릭 타입은 선언부에 '<>'부호가 붙고 그 사이에 타입 파라미터들이 위치한다. 
 
>```java
public class 클래스명<A, B, ...> {...}
public interface 인터페이스명<A, B, ...> {...}
```
  
외부에서 제네릭 타입을 사용하려면 타입 파라미터에 구체적인 타입을 지정해야한다. 만약 지정하지 않으면 Object 타입이 암묵적으로 사용된다.
  
  >```java
  // 제네릭 타입
  public class Product<K, M> {	// 타입 파라미터로 K, M 사용
  	// 필드
  	private K kind;
  	private M model;
  >
  	// 메소드
  	// 타입파라미터를 리턴 타입과 매개변수 타입으로 사용
  	public K getKind() { return this.kind; }
  	public M getModel() { return this.model; }
  	public void setKind(K kind) {this.kind = kind; }
  	public vlid setModel(M model) {this.model = model; }
  }
  ```

  #### 제네릭 메소드
  제네릭 메소드는 타입 파라미터를 가지고 있는 메소드를 말한다. 타입 파라미터가 메소드 선언부에 정의된다는 점에서 제네릭 타입과 차이가 있다. 
  
>```java
	public <A, B, ...> 리턴타입 메소드명(매개변수, ...) {...}
```

<br>

# 3. 멀티 스레드
스레드는 코드의 실행흐름을 말하는데, 프로세스 내에 스레드가 두 개라면 두 개의 코드 실행 흐름이 생긴다는 의미이다. 멀티 프로세스가 프로그램 단위의 멀티 태스킹이라면, 멀티 스레드는 프로그램 내부에서의 멀티 태스킹이라 볼 수 있다. 
  
멀티 프로세스들은 서로 독립적이므로 하나의 프로세스에서 오류가 발생해도 다른 프로세스에게 영향을 미치지 않는다. 하지만 멀티 스레드는 프로세스 내부에서 생성되기 때문에 하나의 스레드가 예외를 발생시키면 프로스세가 종료되므로 다른 스레드에게 영향을 미친다. 그렇기 때문에 멀티 스레드를 사용할 경우에는 예외 처리에 만전을 기해야 한다.
  
<br>

### (0) 메인 스레드
모든 자바 프로그램은 메인 스레드가 main() 메소드를 실행하면서 시작된다. 메인 스레드는 main() 메소드의 첫 코드부터 순차적으로 실행하고, main() 메소드의 마지막 코드를 실행하거나 return 문을 만나면 실행을 종료한다. 
  
메인 스레드는 필요에 따라 추가 작업 스레드들을 만들어서 실행시킬 수 있다. 싱글 스레드에서는 메인 스레드가 종료되면 프로세스도 종료된다. 하지만 멀티 스레드에서는 실행중인 스레드가 하나라도 있다면 프로세스는 종료되지 않는다. 메인 스레드가 작업 스레드보다 먼저 종료되더라도 작업 스레드가 계속 실행 중이라면 프로세스는 종료되지 않는다.
  
### (1) 작업 스레드 생성과 실행
멀티 스레드로 실행하는 프로그램을 개발하려면 먼저 몇 개의 작업을 병렬로 실행할지 결정하고 각 작업별로 스레드를 생성해야 한다. 자바 프로그램은 메인 스레드가 반드시 존재하기 때문에 메인 작업 이외에 추가적인 작업 수만큼 스레드를 생성하면 된다. 
  
자바는 작업 스레드도 객체로 관리하므로 클래스가 필요하다. Thread 클래스로 직접 객체를 생성해도 되지만, 하위 클래스를 만들어 생성할 수도 있다.
  
#### Thread 클래스로 직접 생성
java.lang 패키지에 있는 Thread 클래스로부터 작업 스레드 객체를 직접 생성하려면 다음과 같이 Runnable 구현 객체를 매개값으로 갖는 생성자를 호출하면 된다. 

>```java
Thread thread = new Thread(Runnable target);
```

Runnable은 스레드가 작업을 실행할 때 사용하는 인터페이스이다. Runnable에는 run() 메소드가 정의되어 있는데, 구현 클래스는 run()을 재정의해서 스레드가 실행할 코드를 가지고 있어야 한다.
  
>```java
class Task implements Runable {
  @Override
  public void run() { 
  	// 스레드가 실행할 코드		
  }
}
  
Runnable 구현 클래스는 작업 내용을 정의한 것이므로, 스레드에게 전달해야 한다. Runnable 구현 객체를 생성한 후 Thread 생성자 매개값으로 Runnable 객체를 다음과 같이 전달하면 된다.
  
  >```java
  	Runnable task = new Task();
  	Thread thread = new Thread(task);
  ```
  
명시적인 Runnable 구현 클래스를 작성하지 않고 Thread 생성자를 호출할 때 Runnable 익명 구현 개체를 매개값으로 사용할 수 있다.
(오히려 이 방법이 더 많이 사용된다.)
  
>```java
Thread thread = new Thread(new Runnable() {
  @Override
  public void run() {
  	// 스레드가 실행할 코드
  }
});
>
// 작업 스레드 실행
thread.start();
```
  
#### Thread 자식 클래스로 생성
Thread 클래스를 상속한 다음 run() 메소드를 재정의해서 스레드가 실행할 코드를작성하고 객체를 생성하면 된다.
  
>```java
public class WorkerThread extends Thread {
  @Override
  public void run() {
  	// 스레드가 실행할 코드
  }
}
>
  //스레드 객체 생성
  Thread thread = new WorkerThread();
>
  //스레드 실행
  thread.start();
```

명시적인 자식 클래스를 정의하지 않고, 다음과 같이 Thread 익명 자식 객체를 사용할 수도 있다. (오히려 이 방법이 더 많이 사용된다.)
  
>```java
Thread thread = new Thread() {
  @Overried
  public void run() {
  	// 실행할 코드
  }
}
thread.start();
```

#### 스레드 이름
스레드는 자신의 이름을 가지고 있다. 메인 스레드는 'main'이라는 이름을 가지고 있고, 작업 스레드는 자동적으로 'Thread-n'이라는 이름을 가진다. 작업 스레드의 이름을 Thread-n 대신 다른 이름으로 설정하고 싶다면 Thread 클래스의 setName() 메소드를 사용하면 된다.
  
>```java
thread.setName("스레드 이름");
```

스레드 이름은 디버깅할 때 어떤 스레드가 작업을 하는지 조사할 목적으로 주로 사용된다. 현재 코드를 어떤 스레드가 실행하고 있는지 확인하려면 정적 메소드인 currentThread()로 스레드 객체의 참조를 얻은 다음 getName() 메소드로 이름을 출력해보면 된다.
  
>```java
Thread thread = Thread.currentThread();
System.out.println(thread.getName());
```
  
### (2) 스레드 상태
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
  
>```
try { 
  Thread.sleep(1000); 
} catch(InterruptedException e) {
	// interrupt() 메소드가 호출되면 실행  
} 
```
  
#### 다른 스레드의 종료를 기다림
스레드는 다른 스레드와 독립적으로 실행하지만 다른 스레드가 종료될 때까지 기다렸다가 실행을 해야 하는 경우도 있다. 이를 위해 스레드는 join() 메소드를 제공한다. 

>```java
// ThreadA
  threadB.start();
  threadB.join();	//ThreadB 완료 전까지 ThreadA 일시정지
>
// ThreadB
  run()  
```
  
#### 다른 스레드에게 실행 양보
스레드가 처리하는 작업은 반복적인 실행을 위해 for 문이나 while 문을 포함하는 경우가 많은데, 가끔 반복문이 무의미한 반복을 하는 경우가 있다. 아래 코드에서 work의 값이 false 면 while 문은 어떠한 실행문도 실행하지 않고 무의미한 반복을 한다. 
  
>```java
public void run() {
  while(true) {
  	if(work) {
    	System.out.println("ThreadA 작업 내용");
  	}
  }	  
}
```
  
이때는 다른 스레드에게 실행을 양보하고 자신은 실행 대기 상태로 가는 것이 프로그램 성능에 도움이 된다. 이런 기능을 위해 Thread는 yield() 메소드를 제공한다. yield()를 호출한 스레드는 실행 대기 상태로 돌오가고, 다른 스레드가 실행 상태가 된다. 
  
>```java
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
```
  
### (3) 스레드 동기화
멀티 스레드는 하나의 객체를 공유해서 작업할 수도 있다. 이 경우, 다른 스레드에 의해 객체 내부 데이터가 쉽게 변경될 수 있기 때문에 의도했던 것과는 다른 결과가 나올 수 있다. 

스레드가 사용 중인 객체를 다른 스레드가 변경할 수 없도록 하려면 스레드 작업이 끝날 때까지 객체에 잠금을 걸면 된다. 이를 위해 자바는 동기화(synchronized) 메소드와 블록을 제공한다.
  
객체 내부에 동기화 메소드와 동기화 블록이 여러 개가 있다면 스레드가 이들 중 하나를 실행할 때, 다른 스레드는 해당 메소드는 물론이고 다른 동기화 메소드 및 블록도 실행할 수 없다. 하지만 일반 메소드는 실행이 가능하다. 

#### 동기화 메소드 및 블록 선언
동기화 메소드를 선언하는 방법은 다음과 같이 synchronized 키워드를 붙이면 된다. synchronized 키워드는 인스턴스와 정적 메소드 어디든 붙일 수 있다.  
  
>```java
public synchronized void method() {
	// 단 하나의 스레드만 실행하는 영역
}
```
  
스레드가 동기화 메소드를 실행하는 즉시 객체는 잠금이 일어나고, 메소드 실행이 끝나면 잠금이 풀린다. 메소드 전체가 아닌 일부 영역을 실행할 때만 객체 잠금을 걸고 싶다면 아래와 같이 동기화 블록을 만들면 된다.
  
>```java
public void method() {
  // 여러 스레드가 실행할 수 있는 영역
  synchronized(공유객체) {
  	// 단 하나의 스레드만 실행하는 영역
  }
  //여러 스레드가 실행할 수 있는 영역
}
```

#### wait()과 notify()를 이용한 스레드 제어
경우에 따라서는 두 개의 스레드를 교대로 번갈아가며 실행할 때도 있다. 정확한 교대 작업이 필요할 경우, 자신의 작업이 끝나면 상대방 쓰레드를 일시 정지 상태에서 풀어주고 자신은 일시 정지 상태로 만들면 된다.
  
이 방법의 핵심은 공유 객체에 있다. 공유 객체는 두 스레드가 작업할 내용을 각각 동기화 메소드로 정해놓는다. 한 스레드가 작업을 완료하면 notify() 메소드를 호출해서 일시 정지 상태에 있는 다른 스레드를 실행 대기 상태로 만들고, 자신은 두 번 작업을 하지 않도록 (wait) 메소드를 호출하여 일시 정지 상태로 만든다.
  
### (3) 스레드 안전 종료
스레드는 자신의 run() 메소드가 모두 실행되면 자동적으로 종료되지만, 경우에 따라서는 실행 중인 스레드를 즉시 종료시킬 필요가 있다. 스레드를 강제 종료시키기 위해 Thread는 stop() 메소드를 제공하고 있으나 이 메소드는 deprecated(더 이상 사용하지 않음)되었다. 그 이유는 스레드를 갑자기 종료하게 되면 사용 중이던 리소스들이 불안전한 상태로 남겨지기 때문이다. 여기에서 리소스란 파일, 네트워크 연결 등을 말한다.
  
스레드를 안전하게 종료하는 방법은 사용하던 리소스들을 정리하고 run() 메소드를 빨리 종료하는 것이다. 주로 조건 이용 방법과 interrupt() 메소드 이용 방법을 사용한다.
  
#### 조건 이용
스레드가 while 문으로 반복 실행할 경우, 조건을 이용해서 run() 메소드의 조건을 유도할 수 있다. 다음 코드는 stop 필드 조건에 따라서 run() 메소드의 종료를 유도한다.

>```java
public class XXXThread extends Thrad {
  private boolearn stop;	// stop 필드 선언  
>
  public void run() {
  	while (!stop) {
  	// 스레드가 반복실행하는 코드  
  	}
  	// 스레드가 사용한 리소스 정리
  }
}
```
  
#### interrupt() 메소드 이용
interrupt() 메소드는 스레드가 일시 정지 상태에 있을 때 InterruptedException 예외를 발생시키는 역할을 한다. 이것을 이용하면 예외 처리를 통해 run()메소드를 정상종료시킬 수 있다. 

>```java
public void run() {
try {
  while(true) {
   ...
  Thread.sleep(1); 	// 일시 정지 
  } catch(InterruptedException e){
  }
  //스레드가 사용한 리소스 정리
}
>
XThread thread = new XThread();
thread.start();			//(1)
...
thread.interrupt();		//(2)
```
  
XThread를 생성해서 start() 메소드를 실행한 후 XThread의 interrupt() 메소드를 실행하면 XThread가 일시 정지 상태가 될 때 InterruptedException이 발생하여 예외 처리 블록으로 이동한다. 
  
### (4) 데몬 스레드
데몬(daeman) 스레드는 주 스레드의 작업을 돕는 보조적인 역할을 수행하는 스레드이다. 주 스레드 종료되면 데몬 스레드도 따라서 자동으로 종료된다.
  
스레드를 데몬으로 만들기 위해서는 주 스레드가 데몬이 될 스레드의 (setDaemon(true)를 호출하면 된다.

>```java
public static void main(Strin[] args) {
  AutoSaveThread thread = new AutoSaveThread();
  thread.setDaemon(ture);
  thread.start();
}
```
  
### (5) 스레드풀(ThreadPool)
병렬 작업 처리가 많아지면 스레드의 개수가 폭증하여 CPU가 바빠지고 메모리 사용량이 늘어난다. 이에 따라 애플리케이션의 성능 또한 급격히 저하된다. 이렇게 병렬 작업 증가로 인한 스레드의 폭증을 막으려면 스레드풀을 사용하는 것이 좋다. (스레드를 만드는 시간도 줄이자)
  
스레드풀은 작업 처리에 사용되는 스레드를 제한된 개수만큼 정해 놓고 작업 큐에 들어오는 작업들을 스레드가 하나씩 맡아 처리하는 방식이다. 작업 처리가 끝난 스레드는 다시 작업 큐에서 새로운 작업을 가져와 처리한다. 이렇게 하면 작업량이 증가해도 스레드의 개수가 늘어나지 않아 애플리케이션의 성능이 급격히 저하되지 않는다.
  
  ![](https://velog.velcdn.com/images/yun9yu/post/99c9f989-b279-4b42-9d54-4b1941d131f2/image.png)
  
#### 스레드풀 생성
자바는 스레드풀을 생성하고 사용할 수 있도록 java.until.concurrent 패키지에서 ExecutorService인터페이스와 Executors 클래스를 공유하고 있다. Executors의 다음 두 정적 메소드를 이용하면 간단하게 스레드풀인 ExecutorService 구현 객체를 만들 수 있다. 
  - newCachedThreadPool() 
  - newFixedThreadPool(int nThreads)

아래 메소드로 생성된 스레드풀의 초기 수와 코어 수는 0개이고, 작업 개수가 많아지면 새 스레드를 생성시켜 작업을 처리한다. 60초 동안 스레드가 아무 작업을 하지 않으면 스레드를 풀에서 제거한다.(작업량이 많아질 수 록 스레드 많아져서 메모리 사용량 예측이 어려워 잘 사용안함)
>```java
ExecutorService excutorService = Executors.newCachedThreadPool();
```

아래는 메소드로 생성된 스래드풀의 초기 수는 0개이고, 작업 개수가 많아지면 최대 n개 까지 스레드를 생성시켜 작업을 처리한다. 이 스레드 풀의 특징은 생성된 스레드를 제거하지 않는다는 것이다.(제한된 스레드를 써서 메모리 예측은 쉽지만, 대기시간이 길 수 있다.)
>```java
ExecutorService execuotrserive = Executorsl.newFixedThreadPool(n);
```

위 두 메소드를 사용하지 않고 직접 ThreadPoolExecutor로 스레드풀을 생성할 수도 있다. 다음 예시는 초기 수 0개, 코어 수3개, 최대 수 100개인 스레드풀을 생성하는 코드이다. 그리고 추가된 스레드가 120초 동안 놀고 있을 경우 해당 스레드를 풀에서 제거한다.
  
>```java
ExecutorService threadPool = new ThreadPoolExecutor(
  3,								// 코어 스레드 개수
  100,								// 최대 스레드 개수
  120 L,								// 놀고 있는 시간
  TimeUnit.SECONDS,					// 놀고 있는 시간 단위
  new SynchronousQueue<Runnable>()	// 작업 큐
);
```
  
#### 스레드풀 종료
스레드풀의 스레드는 기본적으로 데몬 스레드가 아니기 때문에 main 스레드가 종료되더라도 작업을 처리하기 위해 계속 실행 상태로 남아 있다. 스레드풀의 모든 스레드를 종료하려면 ExecutorSerivce의 다음 두 메소드 중 하나를 실행해야 한다.

|리턴타입|메소드명(매개변수)|설명|
|-------|---------------|---|
|void|shutdown()|현재 처리 중인 작업뿐만 아니라 작업 큐에 대기하고 있는 모든 작업을 처리한 뒤에 스레드풀을 종료시킨다.|
|List< Runnable >|shutdownNow()|현재 작업 처리 중인 스레드를 interrupt해서 작업을 중지시키고 스레드푸을 종료시킨다. 리턴값은 작업 큐에 있는 미처리된 작업(Runnable)의 목록이다.|
 
  
#### 작업 생성과 처리 요청
하나의 작업은 Runnable 또는 Callable 구현 객체로 표현한다. Runnable과 Callable의 차이점은 작업 처리 완료 후 리턴 값이 있는냐 없느냐이다. call()의 리턴 타입은 Callable< T >에서 지정한 T 타입 파리미터와 동일한 타입이어야 한다.  
  
>```java
// Runnable 익명 구현 객체
new Runnable() {
  @Override
  public void run() {
  	// 스레드가 처리할 작업 내용
  }
}
>
// Callable 익명 구현 객체
new Callable<t>() {
  @Override
  public T call() throws Exception {
  	// 스레드가 처리할 작업 내용
  	return T;
  }
}
```
  
|리턴 타입|메소드명(매개변수)|설명|
|--------|---------------|---|
|void|execute(Runnable command)|- Runable을 작업 큐에 저장|
|||- 작업 처리 결과를리턴하지 않음|
|Future< T >|submit(Callable< T > task)|- Callable을 작업 큐에 저장|
|||- 작업 처리 결과를 얻을 수 있도록 Future를 리턴|

Runable 또는 Callable 객체가 ExecutorService의 작업 큐에 들어가면 ExecutorService는 처리할 스레드가 있는지 보고, 없다면 스레드를 새로 생성시킨다. 스레드는 작업 큐에서 Runnable 또는 Callable 객체를 꺼내와 run() 또는 call() 메소드를 실행하면서 작업을 처리한다. 

<br>

# 4. 컬렉션 자료구조
배열은 같은 타입만 저장가능하고, 길이를 변경할 수 없다. 길이를 변경하기 위해서는 배열 복사해야한다.

컬렉션 자료 구조는 같은 타입만 저장가능하게 만들 수 있고, 다른 타입도 저장가능하게 만들 수 있다. 그러나 컬렉션 자료 구조는 길이가 고정되어 있지 않다. 그리고 자료 구조에 따라서 다양한 방법으로 자료를 저장할 수 있다(번지가 저장되는 것).
  
우리의 학습 목표는 각 인터페이스의 특징과 그 인터페이스안의 메소드이다.
  
#### 컬렉션 프레임워크

|인터페이스 분류||특징|구현클래스|
|-------------|-|---|--------|
|Collection|List|-순서를 유지하고 저장|ArrayList,Vector, LinkedList|
|||-중복 저장 가능||
||Set|-순서를 유지하지 않고 저장|HashSet, TreeSet|
|||-중복 저장 불가||
|Map||-키와 값으로 구성된 엔트리 저장|HashMap, Hashtable, TreeMap, Properties|
|||-키는 중복 저장 안됨||

## 1) List 컬렉션
객체를 인덱스로 관리한다. 때문에 인덱스로 객체를 검색하거나 삭제할 수 있다.
객체 중복 저장이 가능하다. 

|기능|메소드|설명|
|---|-----|----|
|객체 추가|boolean add(E e)|주어진 객체를 맨 끝에 추가|
||void add(int index, E element|주어진 인덱스에 객체를 추가(한칸씩 뒤로 밈)|
||set(int index, E elemetn|주어진 인덱스의 객체를 새로운 객체로 바꿈|
|객체 검색|boolean contains(Object o)|주어진 객체가 저장되어 있는지 여부|
||E get(int index)|주어진 인덱스에 저장된 객체를 리턴|
||isEmpty()|컬렉션이 비어 있는지 조사|
||int size()|저장되어 있는 전체 객체 수를 리턴|
|객체 삭제|void clear()|저장된 모든 객체를 삭제|
||E remove(int index)|주어진 인덱스에 저장된 객체를 삭제(한칸씩 앞으로 당김)|
||boolean remove(Object o)|주어진 객체를 삭제|
  
### (1) ArrayList
ArrayLis에 객체를 추가하면 내부 배열에 객체가 저장된다. 일반 배열과의 차이점은 ArrayList는 제한 없이 객체를 추가할 수 있다는 것이다.
  
>```java
// ArrayList 컬렉션 생성
List<E> list = new ArrayList<E>();	// E에 지정된 타입의 객체만 저장
List<E> list = new ArrayList<>();	// E에 지정된 타입의 객체만 저장
List list = new ArrayList();		// 모든 타입의 객체를 저장
```

빈번한 객체 삽입과 삭제가 일어나는 곳에서는 (메모리에 번지를 계속 바꿔야해서) ArrayList를 사용하는 것은 바람직하지 않다. 대신 이런 경우라면 LinkedList를 사용하는 것이 좋다.
  
### (2) Vector
Vecotr는 ArrayList와 동일한 내부 구조를 가지고 있다. 차이점은 Vector는 동기화된 메소드로 구성되어 있기 때문에 멀티 스레드가 동시에 Vector() 메소드를 실행할 수 없다는 것이다. 그렇기 때문에 멀티 스레드 환경에서 안전하게 객체를 추가 또는 삭제할 수 있다.
  
>```java
// Vector 컬렉션 생성
List<E> list = new Vector<E>();	// E에 지정된 타입의 객체만 저장
List<E> list = new Vector<>();	// E에 지정된 타입의 객체만 저장
List list = new Vector();		// 모든 타입의 객체를 저장
```

### (3) LinkedList
LinkedList는 ArrayList와 사용 방법은 동일하지만 내부 구조는 완전히 다르다. ArrayList는 내부 배열에 객체를 저장하지만, LinkedList는 인접 객체를 체인처럼 연결해서 관리한다.
LinkedList는 특정 위치에서 객체를 삽입하거나 삭제하면 바로 앞뒤 링크만 변경하면 되므로 빈번한 객체 삭제와 삽입이 일어나느 곳에서는 ArrayList보다 좋은 성능을 발휘한다.
  
>```java
// LinkedList 컬렉션 생성
List<E> list = new LinkedList<E>();	// E에 지정된 타입의 객체만 저장
List<E> list = new LinkedList<>();	// E에 지정된 타입의 객체만 저장
List list = new LinkedList();		// 모든 타입의 객체를 저장
```

## 2) Set 컬렉션
List 컬렉션은 저장 순서를 유지하지만, Set 컬렉션은 저장 순서가 유지되지 않는다. 또한 객체를 중복해서 저장할 수 없고, 하나의 null만 저장할 수 있다. 
  
|기능|메소드|설명|
|---|-----|----|
|객체 추가|boolean add(E e)|주어진 객체를 성공적으로 저장하면 true 중복이면 false 반환|
|객체 검색|boolean contains(Object o)|주어진 객체가 저장되어 있는지 여부|
||E get(int index)|주어진 인덱스에 저장된 객체를 리턴|
||isEmpty()|컬렉션이 비어 있는지 조사|
||Iterator< E > iterator()|저장된 객체를 한 번씩 가져오는 반복자 리턴|
||int size()|저장되어 있는 전체 객체 수를 리턴|
|객체 삭제|void clear()|저장된 모든 객체를 삭제|
||boolean remove(Object o)|주어진 객체를 삭제|
  
### (1) HashSet
Set컬렉션 중 가장 많이 사용되는 것이다. 
  
>```java
Set<E> set = new HashSet<E>();		// E에 지정된 타입의 객체만 저장
Set<E> set = new HashSet<>();		// E에 지정된 타입의 객체만 저장
Set<> set = new HashSet<>(); 		// 모든 타입의 객체를 저장
```
  
HashSet은 다른 객체라도 HashCode() 메소드의 리턴 값이 같고, equals() 메소드가 true를 리턴하면 동일한 객체라고 판단하고 중복 저장하지 않는다.
  
Set 컬렉션은 인덱스로 객체를 검색해서 가져오는 메소드가 없다. 대신 객체를 한 개씩 반복해서 가져와야 하는데, 여기에는 두 가지 방법이 있다. 

>```java
// 1. for문을 이용해서 하나씩 가져오기
Set<E> set = new HashSet<>();
for(E e : set) {
	...
}
>
// 2. Iterator() 메소드로 반복자를 얻어 객체를 하나씩 가져오기
Set<E> set = new HashSet<>();
Iterator<E> iterator = set.iterator();
```

iterator는 Set 컬렉션의 객체를 가져오거나 제거하기 위해 다음 메소드를 제공한다.

|리턴타입|메소드명|설명|
|-------|------|----|
|boolean|hasNext()|가져올 객체가 있으면 true를 리턴하고 없으면 false를 리턴한다.|
|E|next()|컬렉션에서 하나의 객체를 가져온다.|
|void|remove()|next()로 가져온 객체를 Set 컬렉셔에서 제거한다.|

hasNext() 메소드로 가져올 객체가 있는지 먼저 확인하고, true를 리턴할 때만 next() 메소드로 객체를 가져온다.
  
>```java 
while(itterator.hasNext()) {
	E e = iterator.next();  
}
```
  
## 3) Map 컬렉션
Map 컬렉션은 키(key)와 값(value)으로 구성된 엔트리(Entry) 객체를 저장한다. 여기서 키와 값은 모두 객체이다. 키는 중복 저장할 수 없지만 값은 중복 저장할 수 있다. 
기존에 저장된 키와 동일한 값으로 저장하면 기존의 값은 없어지고 새로운 값으로 대치된다.
  
|기능|메소드|설명|
|---|-----|----|
|객체 추가|V put(K key, V value)|주어진 키와 값을 추가, 저장이 되면 값을 리턴 |
|객체 검색|boolean containsKey(Object key)|주어진 키가 있는지 여부|
||boolean containsValue(Object value)|주어진 값이 있는지 여부|
||Set<Map.Entry<K,V>> entrySet()|키와 값의 쌍으로 구성된 모든 Map.Entry 객체를 set에 담아 서 리턴|
||V get(Object key)|주어진 키의 값을 리턴|
||boolean isEmpty()|컬렉션이 비어있는지 여부|
||Set<K> keySet()|모든 키를 Set 객체에 담아서 리턴|
||int size()|저장된 키의 총 수를 리턴|
||Collection<V> values()|저장된 모든 값 Collection에 담아서 리턴|
|객체 삭제|void clear()|모든 Map.Entry(키와 값) 삭제|
||V remove(Object key)|주어진 키와 일치하는 Map.Entry 삭제, 삭제되면 리턴|
  
### (1) HashMap
HashMap은 키로 사용할 객체가 hashCode() 메소드의 리턴값과 같고 equals()메소드가 true를 리턴할 경우 동일 키로 보고 중복 저장을 허용하지 않는다.
  
>```java
// HashMap 생성
Map<K, V> map = new HashMap<K, V>();	// 지정된 타입의 객체만 저장
Map<K, V> map = new HashMap<>();		// 지정된 타입의 객체만 저장
Map map = new HashMap();				// 모든 타입 객체를 저장
```
  
### (2) Hashtable
Hashtable은 HashMap과 동일한 내부구조를 가지고 있다. 차이점은 Hashtable은 동기화된 메소드로 구성되어 있기 때문에 멀티 스레드가 동시에 Hashtable의 메소드들을 실행할 수 없다는 것이다. 따라서 멀티 스레드 환경에서도 안전하게 객체를 추가, 삭제 할 수 있다.
  
>```java
Map<K, V> map = new Hashtable<K, V>();	// 지정된 타입의 객체만 저장
Map<K, V> map = new Hashtable<>();		// 지정된 타입의 객체만 저장
Map map = new Hashtable();				// 모든 타입 객체를 저장
```
  
### (3) Properties
Properties는 Hashtable의 자식 클래스이기 때문에 Hashtable의 특징을 그대로 가지고 있다. Properties는 키와 값을 String으로 제한한 컬렉션이다. Properties는 주로 확장자가 .properties인 프로퍼티 파일을 읽을 때 사용한다.
  
프로퍼티 파일은 다음과 같이 키와 값이 = 기호로 연결되어 있는 텍스트 파일이다. 일반 텍스트 파일과는 다르게 ISO- 8859-1 문자셋으로 저장되며, 한글일 경우에는 \u+유니코드로 표현되어 저장된다. 
  
>```
파일명 : database.properties
>
driver = oracle.jdbc.OracleDirver 
url = jdbc:oracle:thin:@localhost:1521:orcl
username = scott
password = tiger
admin = \uD64D\uAE38\uB3D9
```
  
Properties를 사용하면 위와 같은 프로퍼티 파일의 내용을 코드에서 쉽게 읽을 수 있다.
먼저 Properties 객체를 생성하고, load() 메소드로 프로퍼티 파일의 내용을 메모리 로드한다.
  
>```java
Properties properties = new Properties();
properties.load(Xxx.class.getResourceAsStream("database.properties"));
```
  
일반적으로 프로퍼티 파일은 클래스 파일 (~.class)들과 함께 저장된다. 따라서 클래스 파일을 기준으로 상대 경로를 이용해서 읽는 것이 편리하다. Class 객체의 getResourceAsStream() 메소드는 주어진 상대 경로의 리소스 파일을 읽는 InputStream을 리턴한다. 
  
## 4) 검색 기능을 강화시킨 컬렉션
### (1) TreeSet (Set 컬렉션)
TreeSet은 이진 트리(binary tree)를 기반으로 한 Set 컬렉션이다. 이진 트리는 여러 개의 노드(node)가 트리 형태로 연결된 구조로, 루트 노드(root node)라고 불리는 하나의 노드에서 시작해 각 노드에 최대 2개의 노드를 연결할 수 있는 구조를 가지고 있다.

TreeSet에 객체를 저장하면 부모 노드와 비교해서 낮은 것은 왼쪽 자식 노드에, 높은 것은 오른 쪽 자식 노드에 저장한다.
  
>```java
// TreeSet 생성
TreeSet<E> treeset = new TreeSet<E>();
TreeSet<E> treeset = new TreeSet<>();
``` 

#### TreeSet에 정의된 검색 관련 메소드

|리턴타입|메소드|설명|
|-------|-----|---|
|E|fist()|제일 낮은 객체를 리턴|
|E|last()|제일 높은 객체를 리턴|
|E|lower(E e)|주어진 객체보다 바로 아래 객체를 리턴|
|E|higher(E e)|주어진 객체보다 바로 위 객체를 리턴|
|E|floor(E e)|주어진 객체와 동등한 객체가 있으면 리턴, 만약 없다면 주어진 객체 바로 아래의 객체 리턴|
|E|ceiling(E e)|주어진 객체와 동등한 객체가 있으면 리턴, 만약 없다면 주어진 객체의 바로 위 객체 리턴|
|E|pollFirst()|제일 낮은 객체를 꺼내오고 컬렉션에서 제거|
|E|pollLast()|제일 높은 객체를 꺼내오고 컬렉션에서 제거|
|Iterator<E>|descendingIterator()|내림차순으로 정렬된 Iterator를 리턴|
|NavigableSet<E>|descendingSet()|내림차순으로 정렬된 NavigableSet을 리턴|
|NavigableSet<E>|headSet( E to Element, boolean inclusive )|주어진 객체보다 낮은 객체들을 NavigableSet으로 리턴, 주어진 객체 포함 여부는 두 번째 매개값에 따라 달라짐|
|NavigableSet<E>|tailSet( E fromElement, boolean inclusive )|주어진 객체보다 높은 객체들을 NavigableSet으로 리턴, 주어진 객체 포함 여부는 두 번째 매개값에 따라 달라짐|
|NavegableSet<E>|subSet ( E fromElement, boolean fromInclusive, E to Element, boolean toInclusive )|시작과 끝으로 주어진 객체 사이의 객체들을 NavigableSet으로 리턴, 시작과 끝 객체의 포함 여부는 두 번째, 네 번째 매개값에 따라 달라짐|
  
### (2) TreeMap (Map 컬렉션)
TreeMap은 이진 트리를 기반으로 한 Map 컬렉션이다. TreeSet과의 차이점은 키와 값이 저장된 Entry를 저장한다는 점이다. TreeMap에 엔트리를 저장하면 키를 기준으로 자동 정렬되는데, 부모 키 값과 비교해서 낮은 것은 왼쪽, 높은 것은 오른쪽 자식 노드에 Entry 객체를 저장한다.
  
>```java
// TreeMap 생성
TreeMap<K, V> treemap = new TreeMap<K, V>();
TreeMap<K, V> treemap = new TreeMap<>();
```

#### TreeMap에 정의된 검색 관련 메소드

|리턴타입|메소드|설명|
|-------|-----|---|
|Map.Entry<K,V>|fistEntry()|제일 낮은 Map.Entry를 리턴|
|Map.Entry<K,V>|lastEntry()|제일 높은 Map.Entry를 리턴|
|Map.Entry<K,V>|lowerEntry(K key)|주어진 키보다 바로 아래 Map.Entry를 리턴|
|Map.Entry<K,V>|higherEntry(K key)|주어진 키보다 바로 위 Map.Entry를 리턴|
|Map.Entry<K,V>|floorEntry(K key)|주어진 키와 동등한 키가 있으면 해당 Map.Entry를 리턴, 없다면 주어진 키 바로 아래의 Map.Entry를 리턴|
|Map.Entry<K,V>|ceilingEntry(K key)|주어진 키와 동등한 키가 있으면 해당 Map.Entry를 리턴, 없다면 주어진 키 바로 위의 Map.Entry를 리턴|
|Map.Entry<K,V>|pollFirstEntry()|제일 낮은 Map.Entry를 꺼내오고 컬렉션에서 제거|
|Map.Entry<K,V>|pollLastEntry()|제일 높은 Map.Entry를 꺼내오고 컬렉션에서 제거|
|NavigableSet<K>|descendingKeySet()|내림차순으로 정렬된 키의 NavigableSet을 리턴|
|NavigableMap<K,V>|descendingMap()|내림차순으로 정렬된 Map.Entry의 NavigableMap을 리턴|
|NavigableMap<K,V>|headMap( K toKey, boolean inclusive )|주어진 키보다 낮은 Map.Entry들을 NavigableMap으로 리턴, 주어진 키의 Map.Entry 포함 여부는 두 번째 매개값에 따라 달라짐|
|NavigableMap<K,V>|tailmap( K fromKey, boolean inclusive )|주어진 객체보다 높은 Map.Entry들을 NavigableMap으로 리턴, 주어진 객체 포함 여부는 두 번째 매개값에 따라 달라짐|
|NavigableMap<K,V>|subMap( K fromKey, boolean fromInclusive, K toKey, boolean toInclusive )|시작과 끝으로 주어진 키 사이의 Map.Entry들을 NavigableMap 컬렉션으로 반환, 시작과 끝 키의 Map.Entry 포함 여부는 두 번째, 네 번째 매개값에 따라 달라짐|

### (3) Comparable과 Comparator
TreeSet에 저장되는 객체와 TreeMap에 저장되는 키 객체는 저장과 동시에 오름차순 정렬되는데, 어떤 객체든 정렬될 수 있는 것은 아니고 객체가 Comparable 인터페이스를 구현하고 있어야 가능하다. Integer, Double, String 타입은 모두 Comparable을 구현하고 있기 때문에 상관 없지만, 사용자 정의 객체를 저장할 때에는 반드시 Comparable을 구현하고 있어야 한다.
  
Comparable 인터페이스에는 compareTo() 메소드가 정의되어 있다. 따라서 사용자 정의 클래스에서 이 메소드를 재정의해서 비교 결과를 정수 값으로 리턴해야 한다.

|리턴 타입|메소드|설명|
|--------|-----|---|
|int|compareTo(T o)|-주어진 객체와 같으면 0을 리턴|
|||-주어진 객체보다 적으면 음수를 리턴|
|||-주어진 객체보다 크면 양수를 리턴|
|int|compareTo(T o1, T o2)|-o1과 o2가 동등하다면 0을 리턴|
|||-o1이 o2보다 앞에 오게 하려면 음수를 리턴|
|||-o1이 o2보다 뒤에 오게 하려면 양수를 리턴|
  
>```java 
//Person.java
public class Person implements Comparable<Person> {
  public String name;
  public int age;
>
  public Person(String name, int age) {
  	this.name = name;
  	this.age = age;
  }
>
  @Override
  public int compareTo(Person o) {
  	if(age < o.age) return -1;
    else if(age == o.age) return 0;
    else return 1;
  }
} 
```

비교 기능이 이는 Comparable 구현 객체를 TreeSet에 저장하거나 TreeMap의 키로 저장하는 것이 원칙이지만, 비교 기능이 없는 Comparable 비구현 객체를 저장하고 싶다면 방법은 없진 않다.
TreeSet과 TreeMap을 생성할 때 비교자를 다음과 같이 제공하면 된다.

>```java
TreeSet<E> treeSet = new TreeSet<E>( new ComparatorImpl() );
TreeMap<K,V> treeMap = new TreeMap<K,V>( new ComparatorImpl() );
```
                   
## 5) LIFO와 FIFO 컬렉션
스택을 응용한 대표적인 예가 JVM 스택 메모리이다. 스택 메모리에 저장된 변수는 나중에 저장된 것부터 제거된다. 큐를 응용한 대표적인 예가 스레드풀(ExecutorService)의 작업 큐이다. 작업큐는 먼저 들어온 작업부터 처리한다. 

### (1) Stack(Last In First Out)

>```
Stack<E> stack = new Stack<E>();
Stack<E> stack = new Stack<>();
```

|리턴 타입|메소드|설명|
|--------|----|----|
|E|push(E item)|주어진 객체를 스택에 넣는다.|
|E|pop()|스택의 맨 위 객체를 빼낸다.|
  
### (2) Queue(First In First Out)
Queue 인터페이스를 구현하는 대표적인 클래스는 LinkedList이다. 그렇기 때문에 LinkedList 객체를 Queue 인터페이스 변수에 대입할 수 있다.
  
>```java
Queue<E> queue = new LinkedList<E>();
Queue<E> queue = new LinkedList<>();
```

|리턴 타입|메소드|설명|
|--------|----|----|
|boolean|offer(E e)|주어진 객체를 큐에 넣는다.|
|E|poll()|큐에서 객체를 빼낸다.|

## 6) 동기화된 컬렉션
컬렉션 프레임워크의 대부분의 클래스들은 싱글 스레드 환경에서 사용할 수 있도록 설계되었다. 그렇기 때문에 여러 스레드가 동시에 컬렉션에 접근한다면 의도하지 않게 요소가 변경될 수 있는 불안전한 상태가 된다.
  
Vector와 Hashtable은 동기화(synchronized) 메소드로 구성되어 있기 때문에 멀티 스레드 환경에서 안전하게 요소를 처리할 수 있지만, ArrayList와 HashSet, HashMap은 동기화된 메소드로 구성되어 있지 않아 멀티 스레드 환경에서 안전하지 않다. 
  
경우에 따라서 ArrayList, HashSet, HashMap을 멀티 스레드 환경에서 사용하고 싶을 때가 있을 것이다. 이런 경우를 대비해서 컬렉션 프레임워크는 비동기화된 메소드를 동기화된 메소드로 래핑하는 Collections의 synchronizedXXX() 메소드를 제공한다.
  
|리턴 타입|메소드(매개변수)|설명|
|--------|-------------|----|
|List<T>|synchronizedList(List<T> list)|List를 동기화된 List로 리턴|
|Set<T>|synchronizedSet(Set<T> s)|Set을 동기화된 Set으로 리턴|
|Map<K,V>|synchronizedMap(Map<K,V> m)|Map을 동기화된 Map으로 리턴|
  
>```java
List<T> list = Collections.synchronizedList(new ArrayList<T>());
Set<E> set = Collections.synchronizedSet(new HashSet<E>());
Map<K,V> map = Collections.synchronizedMap( new HashMap<K,V>);
```  
  
## 7) 수정할 수 없는 컬렉션
수정할 수 없는(unmodifiable) 컬렉션이란 요소를 추가, 삭제할 수 없는 컬렉션을 말한다. 컬렉션 생성 시 저장된 요소를 변경하고 싶지 않을 때 유용하다. 여러 가지 방법으로 만들 수 있다.
  
먼저 첫 번째 방법으로는 List, Set, Map 인터페이스의 정적 메소드인 of()로 생성하는 방법이 있다.
  
>```java
List<E> immutableList = List.of(E... elements);
Set<E> immutableSet = Set.of(E... elemtens);
Map<K,V> immutableMap = Map.of(K k1, V v1, K k2, V v2, ...);
```
  
두 번째 방법은 List, Set, Map 인터페이스의 정적 메소드인 copyOf()를 이용해 기존 컬렉션을 복사하여 수정할 수 없는 컬렉션을 만드는 것이다. 

>```java
List<E> immutableList = List.copyOf(E... elements);
Set<E> immutableSet = Set.copyOf(E... elemtens);
Map<K,V> immutableMap = Map.copyOf(K k1, V v1, K k2, V v2, ...);
```

세 번째 방법은 배열로부터 수정할 수 없는 List 컬렉션을 만들 수 있다.

>```java
String[] arr = { "A", "B", "C" };
List<String> immutableList = Arrays.asList(arr);
```
  
  
# 5. 람다식
함수형 프로그래밍(functional programming)이란 함수를 정의하고 이 함수를 데이터 처리부로 보내 데이터를 처리하는 기법을 말한다. 데이터 처리부는 데이터만 가지고 있을 뿐, 처리 방법이 정해져 있지 않아 외부에서 제공된 함수에 의존한다. 

데이터 처리부는 제공된 함수의 입력값으로 데이터를 넣고 함수에 정의된 처리 내용을 실해한다. 동일한 데이터라도 함수A를 제공해서 처리하는 결과와 함수B를 제공해서 처리하는 결과는 다를 수 있다. 이것이 함수형 프로그래밍의 특징으로, 데이터 처리의 다형성이라 볼 수 있다.
  
자바는 함수형 프로그래밍을 위해 Java 8부터 람다식(Lambda Expressions)을 지원한다. 람다식은 데이터 처리부에 제공되는 함수 역할을 하는 매개변수를 가진 중괄호 블록이다. 데이터 처리부는 람다식을 받아 매개변수에 데이터를 대입하고 중괄호를 실행시켜 처리한다.
  
!함수를 매개변수로 받는 방법?
  
>```java
람다식: (매개변수, ...) -> { 처리 내용 }
```
  
자바는 람다식을 익명 구현 객체로 변환한다. 익명 구현 객체란 이름이 없는 인터페이스 구현 객체를 말한다. 

예를 들어 다음과 같이 Calculable 인터페이스가 있다고 가정해보자.
  
>```java
public interface Calculable {
  // 추상 메소드
  void calculate(int x, int y);
}
```

Calcuable 인터페이스의 익명 구현 객체는 다음과 같이 생성할 수 있다.
  
>```java
new Calculable() {
	@Override
  	public void calculate(int x, int y) { 처리 내용 }
}
```

이것을 람다식으로 표현하면 다음과 같다. 추상 메소드인 calculate()는 두 개의 매개변수를 가지므로 (x, y)로 표현되었고, 화살표 -> 뒤에 calculate()의 실행 블록이 온다.
  
>```
(x, y) -> { 처리 내용 }
```
  
람다식은 인터페이스의 익명 구현 객체이므로 인터페이스 타입의 매개변수에 대입될 수 있다. 예를 들어 아래와 같이 Calculable 매개변수를 가지고 있는 action() 메소드가 있다고 가정해보자.
  
>```java
public void action(Calculable calculable) {
  int x = 10;
  int y = 4;
  calculable.calculate(x, y);	// 데이터 제공하고 추상 메소드 호출
}
```
  
action() 메소드를 호출할 때 매개값으로 다음과 같이 람다식을 제공할 수 있다. action() 메소드에서 calculable.calculate(x, y)를 실행하면 람다식의 중괄호 블록이 실행되면서 데이터가 처리된다. 여기서 action() 메소드는 제공된 람다식을 이용해서 내부 데이터를 처리하는 처리부 역할을 한다.
  
>```java
action( (x,y) -> {
  int result = x + y;
  System.out.println(result);
});  
```
  
**주의!** 인터페이스의 익명 구현 객체를 람다식으로 표현하려면 인터페이스가 단 하나의 추상 메소드만 가져야 한다. (두 개 이상의 추상 메소드를 가진 인터페이스는 람다식으로 표현할 수 없다.)
  
>```java
// 인터페이스1
public interface Runable {
	void run();
}
// 람다식1
( ) -> { ... }
>  
// 인터페이스2
@FunctionalInterface	// 추상 메소드가 1개인지 컴파일 할 때 검사한다.
public interface calculable {
	void calculate(int x, int y);
}
// 람다식2
(x, y) -> { ... }
```

  (매개변수의 자료형은 상관없다 개수만 맞게 적어주면 된다.)

  
#### 매개변수가 없는 람다식
함수형 인터페이스의 추상 메소드에 매개변수가 없을 경우 람다식은 다음과 같이 작성할 수 있다. 실행문이 두 개 이상일 경우에는 중괄호를 생략할 수 없고, 하나일 경우에만 생략할 수 있다.
  
>```java
( ) -> {
  실행문;
  실행문;
}
>
( ) -> 실행문
```
  
#### 매개변수가 있는 람다식
함수형 인터페이스의 추상 메소드에 매개변수가 있을 경우 람다식은 다음과 같이 작성할 수 있다. 매개변수를 선언할 때 타입은 생략할 수 있고, 구체적인 타입 대신에 var를 사용할 수도 있다. 하지만 타입을 생략하고 작성하는 것이 일반적이다.
  
>```java
(타입 매개변수, ...) -> {
  실행문;
  실행문;
}
>  
(var 매개변수, ...) -> {
  실행문;
  실행문;
}
>
(매개변수, ...) -> {
  실행문;
  실행문;
}
```
  
매개변수가 하나일 경우에는 괄호를 생략할 수 있다.
  
>```java
매개변수 -> {
  실행문;
  실행문;
}
```
  
#### 리턴값이 있는 람다식
return문 하나만 있을 경우에는 중괄호와 함께 return을 생략할 수 있다. 리턴값은 연산식 또는 리턴값 있는 메소드 호출로 대체할 수 있다.

>```java
(매개변수, ...) -> {
  실행문;
  retrun 값;
}
>
(매개변수, ...) -> 값
```
  
### 메소드 참조
메소드 참조는 말 그대로 메소드를 참조해서 매개변수의 정보 및 리턴 타입을 알아내 람다식에서 불필요한 매개변수를 제거하는 것을 목적으로 한다. 예를 들어 두 개의 값을 받아 큰 수를 리턴하는 Math 클래스의 max() 정적 메소드를 호출하는 람다식은 다음과 같다.

>```java
(left, right) -> Math.max(left,right);
```

람다식은 단순히 두 개의 값을 Match.max() 메소드의 매개값으로 전달하는 역할만 하기 때문에 다소 불편해 보인다. 이 경우에는 다음과 같이 메소드 참조를 이용하면 매우 깔끔하게 처리할 수 있다.

>```java
Math :: max;
```

#### 정적 메소드와 인스턴스 메소드 참조
정적 메소드를 참조할 경우에는 클래스 이름 뒤에:: 기호를 붙이고 정적 메소드 이름을 기술한다.

>```java
클래스 :: 메소드
```

인스턴스 메소드일 경우에는 먼저 객체를 생성한 다음 참조 변수 뒤에 :: 기호를 붙이고 인스턴스 메소드 이름을 기술한다.
  
>```java
참조변수 :: 메소드
```
![](https://velog.velcdn.com/images/yun9yu/post/06a37df2-5ed4-4185-95d5-4a29cdfd2c3e/image.png)

### 생성자 참조

  
  
# 6. 스트림 요소 처리
지금까지 컬렉션 및 배열에 저장된 요소를 반복 처리하기 위해서는 for문을 이용하거나 Iterator(반복자)를 이용했다. 
>```java
// 1. List 컬렉션에서 요소를 하나씩 처리하는 for 문
List<String> list = ...;
for (int i=0; i<list.size(); i++)
  String item = List.get(i);
  // item 처리
>
// 2. Set 클렉션에서 요소를 하나씩 처리하기 위해 Iterator를 사용
Set<String> set = ...;
Iterator<String> iterator = set.iterator();
while(iterator.hasNext()) {
  String item = iterator.nex();
  // 요소 처리
}
```

Java 8 부터는 또 다른 방법으로 컬렉션 및 배열의 요소를 반복 처리하기 위해 스트림을 사용할 수 있다. 스트림은 요소들이 하나씩 흘러가면서 처리된다는 의미를 가지고 있다. List 컬렉션에서 요소를 반복 처리하기 위해 스트림을 사용하면 다음과 같다.

>```java
Stream<String> stream = list.stram();
stream.forEach( item -> // item처리 );
```

List 컬렉션의 stream() 메소드로 Stream 객체를 얻고, 
forEach() 메소드로 요소를 어떻게 처리할지를 람다식으로 제공한다. 
  
>```java
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Stream;
>
public class StreamExample {
  public static void main(Strina[] args) {
  	//Set 컬렉션 생성
	Set<String> set = new HashSet<>();
	set.add("홍길동");
	set.add("신용권");
	set.add("감자바");
  >
  	//Strema을 이용한 요소 반복 처리
	Stream<String> stream = set.stream();	// 스트림 요소 얻기
  	stream.forEach( name -> System.out.println(name) );	// 람다식 요소 처리
  } 
}
```
  
**즉, 스트림은 컬렉션 또는 배열의 저장 요소를 하나씩 참조해서 람다식으로 처리할 수 있도록 해주는 반복자**라고 할 수 있다. 

#### Stream과 Iterator의 차이점
- 내부 반복자이므로 처리 속도가 빠르고 병렬 처리에 효율적
- 람다식으로 다양한 요소 처리를 정의 가능
- 중간 처리와 최종 처리를 수행하도록 파이프 라인 형성 가능

#### 내부 반복자
for문과 Iterator는 컬렉션의 요소를 컬렉션 바깥쪽으로 반복해서 가져와 처리하는데, 이것을 외부 반복자라고 한다.
반면 스트림은 요소 처리 방법을 컬렉션 내부로 주입시켜 요소를 반복 처리하는데, 이것을 내부 반복자라고 한다. 
  
외부 반복자일 경우는 컬렉션의 요소를 외부로 가져오는 코드와 처리하는 코드를 모두 개발자 코드가 가지고 있어야 한다. 
반면 내부 반복자일 경우는 개발자 코드에서 제공한 데이터 처리 코드(람다식)를 가지고 컬렉션 내부에서 요소를 반복 처리한다.
내부 반복자는 멀티 코어 CPU를 최대한 활용하기 위해 요소들을 분배시켜 병렬 작업을 할 수 있다. **하나씩 처리하는 순차적 외부 반복자보다는 효율적을 요소를 반복시킬 수 있다는 장점**이 있다.
  
![](https://velog.velcdn.com/images/yun9yu/post/35c16472-2b7b-4984-b28f-b044a85497ed/image.png)
###### 참조 : https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=qkrghdud0&logNo=220702640712

#### 중간 처리와 최종 처리
스트림은 하나 이상 연결될 수 있다. 아래 그림을 보면 컬렉션의 오리지널 스트림 뒤에 필터링 중간 스트림이 연결될 수 있고, 그 뒤에 매핑 중간 스트림이 연결될 수 있다. 이와 같이 스트림이 연결되어 있는 것을 '스트림 파이프라인'이라고 한다.

![](https://velog.velcdn.com/images/yun9yu/post/0e498822-128a-4ba7-8292-b3ddd08d0fb7/image.png)
###### 참조 : https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=qkrghdud0&logNo=220702640712

- 중간처리 : 최종 처리하기 전에 컬렉션 요소들을 필터링, 매핑, 정렬 등의 작업을 수행하는 것
- 최종처리 : 컬렉션의 오리지널 요소들이나 중간처리에서 정제된 요소들을 반복, 집계 작업을 수행하는 것
  
**!주의** 스트림 파이프라인을 구성할 때 파이프라인의 맨 끝에는 반드시 최종 처리 부분이 있어야 한다. 최종 처리(집계 처리)가 없다면 오리지널 및 중간 처리 스트림은 동작하지 않는다. 
  
### 1) 리소스부터 스트림 얻기
반드시 컬렉션이 아니더라도 데이터를 가지고 있는 객체로 부터 스트림을 얻을 수 있다.  
  
java.util.stream 패키지에는 스트림 인터페이스 들이 있다. BaseStream인터페이를 부모로 한 자식 인터페이스 들은 다음과 같은 상속 관계를 이루고 있다.  
  
![](https://velog.velcdn.com/images/yun9yu/post/5f03037f-d5fb-4c8e-a245-e5df0f198f02/image.png)
###### 참조 : https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=qkrghdud0&logNo=220702640712

BaseStream에는 모든 스트림에서 사용할 수 있는 공통 메소드들이 정의되어 있다. Stream은 객체 요소를 처리하는 스트림이고, IntStream, LongStream, DoubleStream은 각각 기본 타입인 int, long, double 요소를 처리하는 스트림이다. 

![](https://velog.velcdn.com/images/yun9yu/post/1cb7543c-31e7-4f9a-81c1-16b36fee8f11/image.png)
###### 참조 : https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=qkrghdud0&logNo=220702640712
  
#### 컬렉션으로부터 스트림 얻기
java.util.Collection 인터페이스는 스트림과 parallelStream() 메소드를 가지고 있기 때문에 자식 인터페이스인 List와 Set 인터페이스를 구현한 모든 컬렉션에서 객체 스트림을 얻을 수 있다. (parallelStream은 병렬 스트림이다.)
  
#### 배열로부터 스트림 얻기
#### 숫자 범위로부터 스트림 얻기
  
#### 파일로부터 스트림 얻기
- 통합 자원 식별자(URI; Uniform Resource Identifier)를 의미
- 통합 자원 위치(URL; Uniform Resource Location)
  컴퓨터 네트워크 상에서 리소스가 어디 있는지 알려주기 위한 규약
  
### 2) 요소 걸러내기
### 3) 요소 변환(매핑)
#### 요소를 다른 요소로 변환
#### 요소를 복수 개의 요소로 변환
### 4) 요소 정렬
#### Comparable 구현 객체의 정의
#### Comparator를 이용한 정렬
### 5) 요소를 하나씩 처리(루핑)
### 6) 요소 조건 만족 여부(매칭)
### 7) 요소 기본 집계
#### 스트림이 제공하는 기본 집계
#### Optional 클래스
### 8) 요소 커스텀 집계
### 9) 요소 수집
#### 필터링한 요소 수집
#### 요소 그룹핑
### 10) 요소 병렬처리
#### 동시성과 병렬성
#### 포크조인 프레임워크
#### 병렬 스트림 사용
#### 병렬 처리 성능
