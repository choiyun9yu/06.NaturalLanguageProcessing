# JAVA Part1

## 1. 자바 기본 타입(Java Primitive Type)

| 타입    | 메모리 크기  | 저장되는 값의 허용 범위        |
| ------- | ------------ | ------------------------------ |
| boolean | 1byte(8bit)  | ture, false                    |
| char    | 2byte(16bit) | 유니코드 문자                  |
| byte    | 1byte(8bit)  | -128 ~ 127                     |
| short   | 2byte(16bit) | -32,768 ~ 32,767               |
| int     | 4byte(32bit) | -2,147,483,648 ~ 2,147,483,647 |
| long    | 8byte(64bit) | -2^63 ~ (2^63-1)               |
| float   | 4byte(32bit) | 유효 소수 이하자리 7자리       |
| double  | 8byte(64bit) | 유효 소수 이하자리 15자리      |

### 1-1. 정수 타입

변수에 대입할 정수 리터럴(literal)은 진수에 따라 작성법이 다르다.

    int deci = 13;	    // 10진수로 13 표현
    int bin = 0b1101;   // 2진수로 13 표현현
    int oct = 015;	    // 8진수로 13 표현
    int hex = 0xD;	    // 16진수로 13 표

long 타입으로 쓰고 싶은 경우 L을 붙여서 long type 임을 컴파일러에게 알려줘야 한다.

    int var1 = 1000000000000;   // 허용 범위 초과 컴파일 오류
    long var1 = 1000000000000;  // 리터럴 컴파일 오류,
    long var2 = 1000000000000l; // long 타입 인식 (l or L 모두 가능)

### 1-2. 문자 타입(사실은 정수 타입)

하나의 문자를 작은따옴표(')로 감싼 것을 문자 리터럴이라고 한다. **문자 리터럴은 유니코드로 변환되어 저장된다.**   
(유니코드는 세계 각국의 문자를 0~65535 숫자로 매핑한 국제 표준 규약이다.)

    char var1 = 'A';    // 유니코드 65로 대입
    char var2 = '가';   // 유니코드 44032로 대입

**유니코드도 정수이므로 char 타입도 정수 타입에 속한다.** 따라서 char 변수에 작은 따옴표로 감싼 문자가 아니라 유니코드 숫자를 직접 대입할 수도 있다.

    char var3 = 65;	    // 문자 'A'
    char var4 = 0x0041  // 문자 'A'

자바는 ' '; 빈 문자를 대입하면 컴파일 에러가 발생한다.

    char var5 = '';    // 빈문자 컴파일 에러

### 1-3. 실수 타입

실수 타입에는 float과 double이 있다. 그리고 **정밀도(precision)** 라는 개념이 존재한다. 정밀도는 소수점 이하 숫자의 자리수를 의미한다. float의 정밀도는 6~7자리 정도이고, double의 정밀도는 15자리 정도이다. 그러나 정밀도는 상황에 따라서 떨어질 수 있다.

자바는 _IEEE 754_ 표준에 근거해서 float타입과 double타입의 값을 **부동 소수점 방식** 으로 메모리에 저장한다. 부동 소수점 표현은 실수를 정확하게 표현하기 위해 **가수**와 **지수**를 이용하여 값을 근사적으로 표현한다.

**가수**는 소수점 앞 또는 뒤에 있는 유효숫자를 의미한다. 예를 들어, 123.45라는 수를 부동소수점 형식으로 표현하면 1.2345 x 10^2와 같이 표현할 수 있고 이때 12345가 가수에 해당한다.

**지수**는 10의 몇제곱인지를 나타내는 숫자로, 가수에서 소수점의 위치를 조절하는 역할을 한다. 지수는 양수일 수도 있고, 음수일 수도 있다. 음수일 경우 소수점을 앞으로 이동시키고 양수일 경우 소수점을 뒤로 이동시킨다. 이를 **지수 표기법**으로 나타내면 1.2345e+2 이다.

**부호**는 음수인지 양수인지 결정하는 것으로 최상위 1bit가 결정한다.  
![](https://velog.velcdn.com/images/yun9yu/post/957333e7-f181-4906-9c88-fd1e830cbcf0/image.png)

실수 타입도 정수 타입의 long와 비슷한 경우가 있다. 컴파일러는 기본적으로 double로 인식하기 때문에 float 인 경우 'f'로 컴파이러에게 알려줘야 한다.

    float f1 = 3.14;   // 컴파일러가 double로 인식
    float f2 = 3.14f;  // 컴파일러가 float으로 인식

### 1-4. 논리 타입

참과 거짓을 의미하는 논리 리터럴은 true와 false이다. 논리 리터럴은 boolean 타입 변수에 다음과 같이 대입할 수 있다. 연산식 중에서 비교 및 논리 연산의 산출값은 true 또는 false이므로 boolean 타입 변수에 다음과 같이 대입할 수 있다.

    boolean var1 = true;
    boolean var2 = false;

### 1-5. 문자열 타입

작은따옴표(')로 감싼 한 개의 문자는 char타입이지만, 큰따옴표(")로 감싼 한 개의 문자나 작은따옴표(')로 감싼 여러 개의 문자들은 유니코드로 변환되지 않는다.

문자들의 모임을 문자열이라 하고 문자열은 큰따옴표(")로 감싼다. 문자열을 변수에 저장하고 싶다면 String타입을 사용해야 한다.

**String은 자바 기본 타입에 속하지 않는 '참조 타입'이다.**

    char var1 = "a";    // 컴파일 에러
    char var2 = 'abc';  // 컴파일 에러
    String var3 = "abc";

<br>
<br>

## 2. 자바 데이터 타입 변환

> 데이터 타입의 크기  
> byte < short, char < int < long < float < double

### 2-1. 자동 타입 변환

자동 타입 변환은 값의 허용 범위가 작은 타입이 큰 타입으로 대입될 때 자동으로 발생한다.

#### int ➡️ float

    // 정수 타입이 실수 타입으로 대입되는 경우 무조건 자동 타입 변환된다.

    long longValue = 5000000000L;
    float floatValue = longValue;	// 5.0e9f로 저장됨
    double doubleValue = longValue;	// 5.0e9로 저장됨

#### char ➡️ int

    // char 타입의 경우 int 타입으로 자동 변환되면 유니코드 값이 int타입에 대입된다.
    char charValue = 'A';
    int intValue = charValue;       // 65가 저장됨

    // char 타입의 문자를 정수로 반환하려면 ASCII 코드 값을 반환 받은 다음 거기에 - '0'을 해줘야 한다.
    char charValue = 'A';
    int intValue = Integer.valueOf(charValue - '0')

### 2-2. 강제 타입 변환

허용 범위가 큰 타입은 더 작은 타입으로 자동 타입 변환될 수 없다. 하지만 강제 타입 변환은 가능하다.

#### int ➡️ byte

    int intValue = 10
    byte byteValue = (byte) intValue;   // 캐스팅으로 강제 변환

    // 이때 int의 리터럴이 byte의 할당값을 초과하면 오버플로우가 발생할 수 있음

#### long ➡️ int

    long longValue = 300;
    int intValue = (int) longValue;	    // 강제타입 변환후 300 그대로 유지

#### int ➡️ char

    int int Value = 65;
    char charValue = (char) intValue;   // 'A'

#### double ➡️ int

    double doubleValue = 3.14;
    int intValue = (int) doubleValue;   // 정수 부분인 3만 저장우

### 2-3. 문자열을 기본 타입으로 변환

참조 타입인 문자열을 기본 타입으로 바꾸기 위해서는 parse를 사용해야한다.  
(다만, 기본타입을 문자열로 바꾸려면 String.valueOf(기본타입)을 사용한다.)

#### String ➡️ byte

    String str = "10";
    byte value = Byte.parseByte(str);

#### String ➡️ short

    String str = "200";
    short value = Short.parseShort(str);

#### String ➡️ int

    String str = "300000";
    int value = Integer.parseInt(str);

#### String ➡️ long

    String str = "40000000000";
    long value = Long.parseLong(str);

#### String ➡️ float

    String str = "12.345";
    float value = Float.parseFloat(str);

#### String ➡️ double

    String str = "12.345";
    double value = Double.parseDouble(str);

#### String ➡️ boolean

    String str = "true";
    boolean value = Boolean.parseBoolean(str);

#### 기본 타입 값 ➡️ String

    String str = String.valueOf(기본 타입 값);

### 2-4. 오버플로우와 언더플로우

오버플로우나 언더플로우 발생시 최대값을 벗어나면 최소값이되고, 최소값을 벗어나면 최대값이된다.

-   **오버플로우** : 타입이 허용하는 최대값을 벗어나는 것
-   **언더플로우** : 타입이 허용하는 최소값을 벗어나는 것

<br>
<br>

## 3. 변수 값 입출력

### 3-1. 변수 출력

    System.out.print();	               // 출력
    System.out.println();                  // 출력하고 개행
    System.out.printf("형식문자열", 값1 ..);  // 포맷 스트링

    String name = "홍길동";
    String job = "도적";
    System.out.printf("%s는 %s이다.\n", name, job);
    System.out.printf("반지름이 %d인 원의 넓이:%10.2\n",10,3.14159*10^2);

#### 형식 문자열

| 형식     | 형식    | 설명                                           | 출력형태       |
| -------- | ------- | ---------------------------------------------- | -------------- |
| 정수     | %d      | 정수                                           | 123            |
|          | %6d     | 6자리정수.왼쪽 빈자리 공백                     | \_\_\_123      |
|          | %-6d    | 6자리정수.오른쪽 빈자리 공백                   | 123\_\_\_      |
|          | %06d    | 6자리 정수.왼쪽 빈자리0채움                    | 000123         |
| 실수     | %10.2f  | 정수 7자리+소수점+소수2자리.왼쪽 빈자리 공백   | \_\_\_\_123.45 |
|          | %-10.2f | 정수 7자리+소수점+소수2자리.오른쪽 빈자리 공백 | 123.45\_\_\_\_ |
|          | %010.2f | 정수 7자리+소수점+소수2자리.왼쪽 빈자리 0채움  | 0000123.45     |
| 문자열   | %s      | 문자열                                         | abc            |
|          | %6s     | 6자리 문자열.왼쪽 빈자리 공백                  | \_\_\_abc      |
|          | %-6s    | 6자리 문자열. 오른쪽 빈자리 공백               | abc\_\_\_      |
| 특수문자 | \t      | 탭(tab)                                        |                |
|          | \n      | 개행                                           |                |
|          | %%      | %                                              | %              |

### 3-2. 키보드 입력

키보드로부터 입력된 데이터를 읽고 변수에 저장하는 가장 쉬운 방법은 Scanner를 사용하는 것이다. Scanner 타입 변수를 선언하고, 대입연산자(=)를 사용해서 new 연산자로 생성한 Scanner 객체를 변수에 대입한다. **nextLine( )** 은 Enter키가 입력되기 전까지 블로킹(대기) 상태가 되며, Enter키가 입력되면 지금까지 입력된 모든 내용을 문자열로 읽는다.

    Scanner scanner = new Scanner(System.in);
    Scanner inputData = scanner.nextLine();

<br>
<br>

## 4. 연산자(Operator)

### 4-1. 부호/증감 연산자

    // 후위형
    int x = 5;
    int y = x++;    // 대입 후 x를 1증가
    System.out.println("x=" + x + ", y=" + y);
        >> x=6, y=5

    // 전위형
    int a = 10;
    int b = ++a;    // 대입 전 a를 1증가
    System.out.println("a=" + a + ", b=" + b);
        >> a=6, b=6

-   부호 연산자는 변수의 부호를 변경할 때 사용된다.
-   증감연산자는 ++로 1씩 증가시키거나 --로 1씩 감소시킨다.
-   --또한 감소하는 것을 제외하고는 같다.

### 4-2. 산술 연산자

> 종류 : +(더하기), -(빼기), \*(곱하기), /(나누기), %(나머지)

    short var1 = 1;
    int var2 = 2;
    int var3 = var1 + var2; // 더 큰 그릇으로

    int var4 = 12 / 0;     // 예외 에러 (ArithmeticException)
    int var5 = 12 % 0;     // 예외 에러 (ArithmeticException)

    float var6 = 12 / 0.0f;   // Infinity
    float var7 = 12 % 0.0f;    // NaN

-   피연산자 중 더 큰 그릇을 가진 자료형을 따라간다.
-   정확한 연산을 위해서는 정수를 사용하는 것이 좋다.  
    (부동소수점 연산은 정확한 값을 출력하지 못하는 경우가 존재한다.)
-   나눗셈, 나머지 연산에서 0으로 나눌 경우 예외(ArithmeticException)가 발생한다.  
    (무한대의 값을 정수로 표현할 수 없기 때문이다.)
-   하지만 0이 아닌 0.0이나 0.0f인 경우 예외가 발생하지않고 무한대(inf) or NaN이 된다.
-   inf or NaN 값을 가지고 연산을 하면 안된다. 어떤 연산을 하더라도 결과는 계속 inf와 NaN이 되기 때문이다.

### 4-3. 비교연산자

> 종류 : ==(같다), !=(다르다), >, >=, <. <=

> 반환 : boolean

#### 실수 비교 연산

float와 dobule의 정밀도 차이로 인해 같은 수여도 컴퓨터는 다르다고 인식한다.

    flost var1 = 0.1f;
    double var2 = 0.1;
    boolean res = var1 == var2; // false

#### 문자열 비교 연산

    boolean result1 = srt1.equals(srt2);  // 문자열이 같은지 검사
    boolean result2 = !srt1.equals(srt2); // 문자열이 다른지 검사

### 4-4. 논리 연산자

> 종류 : &&(논리곱), ||(논리합), ^(배타적 논리합), !(부정)

> 반환 : boolean

논리연산은 주로 조건문, 반복문 등에서 이용한다.

### 4-5. 비트 논리 연산자

2진수로 저장되는 정수 타입(byte, short, int, long)만 피연산자가 될 수 있다.

### 4-6. 비트 이동 연산자(쉬프트 연산자)

비트를 좌측 또는 우측으로 밀어서 이동시키는 연산자

#### 왼쪽 쉬프트(<<)

    // a << b = a x 2^b
    int num = 8;            // 2진수로는 1000
    int shifted = num << 2; // 왼쪽으로 2비트 쉬프트, 오른쪽 빈자리는 0으로 채운다.
    System.out.println(shifted); // 출력 결과: 32 (2진수로는 100000)

#### 오른쪽 쉬프트(>>)

    // a >> b = a / 2^b
    int num = 16; // 2진수로는 10000
    int shifted = num >> 2; // 오른쪽으로 2비트 쉬프트, 왼쪽 빈자리는 음수면 1, 양수면 0으로 채운다.
    System.out.println(shifted); // 출력 결과: 4 (2진수로는 100)

#### 오른쪽 쉬프트(>>>)

오른쪽 쉬프트(>>)와 비슷하지만 왼쪽 빈자리를 0으로 채워서 항상 양수가 나온다는 점이 다르다.  
(왼쪽 쉬프트(<<<)는 없다.)

### 4-7. 삼항 조건 연산자

    조건식 ? 참일때 : 거짓일때;

### 4-8. 연산자 우선순위

-   1순위 : 증감 연산자
-   2순위 : 산술 연산자
-   3순위 : 시프트 연산자
-   4순위 : 비교 연산자
-   5순위 : 비트 연산자(~만 1순위)
-   6순위 : 논리 연산자(!만 1순위)
-   7순위 : 조건(삼항) 연산자
-   8순위 : 대입 연산자

<br>
<br>

## 5. 제어문

자바 프로그램은 main( )메소드의 시작 중괄호에서 끝 중괄호 까지 위에서 아래로 실행하는 흐름을 가지고 있다. 제어문은 이러한 실행 흐름을 개발자가 원하는 방향으로 바꿀 수 있도록 해준다. 즉, 제어문을 사용할 경우 다양한 실행 흐름이 생성된다.

### 5-1. 조건문( if / switch )

#### if문

조건식의 결과에 따라 블록 실행 여부가 결정된다.

    if 문
        if (조건식) {
            실행문
        }

######

    else if 문
        if (조건식1) {
            실행문1
        } else if (조건식2) {
            실행문2
        } else if (조건식3) {
            실행문3
        } else {
            실행문4
        }

#### switch문

if문은 true/false 두 가지만의 결과만으로 흐름을 만들어 경우의 수가 많이질 경우 복잡해 질 수 있다.  
그러나 switch문은 다양한 결과로 흐름을 만들어 코드가 간결해질 수 있다.

    switch(변수) {
        case 값1 :
            실행문1     // 변수가 값1일 때 실행
            break;    // 브레이크 없으면 밑으로 쭉내려감
        case 값2 :
            실행문2    // 변수가 값2일 때 실행
            break;
        default:
            실행문3    // case에 변수 값과 같은 값이 없으면 실행
    }

<br>

### 5-2. 반복문( for / foreach / forEach / while / do-while )

#### for문

    for (초기화식; 조건식; 증감식) {
        실행문     // 조건식이 true일 경우 실행
    }

    // 반복문에서 요소와 인덱스 번호를 같이 확인하는 방법
    for (int i = 0; i < myList.size(); i++) {
      String element = myList.get(i);
      System.out.println("인덱스 "+ i + ":" + element);
    }

#### 확장 for문(foreach)

    for (elementType element : collection) {
        실행문     // collection 요소들을 element로 하나씩 받아와서 실행
    }            // collection은 박복할 컬렉션으로 배열, 리스트, 맵 등을 의미

#### forEach문(Java8 부터 추가)

    collection.forEach(element -> 함수(element));
    // 함수형 프로그래밍 사용 시 유용하다.

#### while문

    while (조건식) {
        실행문     // 조건식이 true일 경우 실행
    }

#### do-while문

    do {
        실행문     // 먼저 실행한 번 하고
    } while (조건식);  // 조건식이 true일 경우 다시 실행

#### break문

반복문의 실행을 중지하거나 조건문인 switch문을 종료할 때 사용한다.

#### continue문

반복문 블록 내부에서 continue를 만나면 바로 다음 반복으로 스킵한다.

<br>
<br>

## 6. 예외 처리

**에러(Error)** 는 컴퓨터 하드웨어 고장으로 인해 응용프로그램 실행 오류가 발생하는 것이고, **예외(Exception)** 는 잘못된 사용 또는 코딩으로 인한 오류이다. 예외가 발생되면 프로그램이 종료되지만 예외처리를 통해 실행상태를 유지할 수도 있다.

### 6-1. 예외의 종류

#### 일반 예외(Exception)

java.lang.Exception 클래스를 상속받은 예외들로, 컴파일러가 예외 처리를 검사해서 강제한다.

#### 실행 예외(Runtime Exception)

java.lang.RuntimeException 클래스를 상속받은 예외들로, 컴파일러가 예외 처리를 강제하지 않는다. 개발자의 실수에 의한 예외나 런타임 환경에서 발생하는 예외이다. NullPointerException, ArrayIndexOutOfBoundsException, ArithmeticException 등이 있다.

### 6-2. 예외 처리하기

예외가 발생했을 때 프로그램의 갑작스러운 종료를 막고 정상 실행을 유지할 수 있도록 처리하는 코드를 예외 처리 코드라고 한다. 예외 처리는 try - catch - finally 블록으로 구성된다. (try문과 catch문에서 return문이 실행되더라도 finally는 항상 실행된다.)

    try {
        // 예외 발생 가능 코드
    } catch {
        // 예외 처리 : 예외 발생한 경우 실행
    } finally {
        // 항상 실행 : 항상 실행(생략가능)
    }

    // NullPointerException 에러 발생
    public class ExceptionHandlingExample1 {
        public static void printLength(String data) {
            int result = data.lengthh();
            System.out.println("문자 수: " + result);
        }

        public static void main(String[] args) {
            System.out.println("[프로그램 시작]\n");
            printLength("ThisIsJava");
            printLength(null);
            System.out.println("[프로그램 종료]")
        }
    }

    // 예외 처리
    public class ExceptionHandlingExample2 {
        public static void printLength(String data) {
            try {
                int result = data.length();
                System.out.println("문자 수:" + result)
            } catch(NullPointerException e) {
                // 예외 정보 얻는 방법 3가지
                System.out.println(e.getMessage());
                System.out.println(e.toString());
                e.printStackTrace();
            } finally {
                System.out.println("[마무리 실행]\n")
            }
        }

        public static void main(String[] args) {
            System.out.println("[프로그램 시작]\n");
            printLength("ThisIsJava");
            printLength(null);
            System.out.println("[프로그램 종료]")
        }
    }

    e.getMessage()는 예외가 발생한 이유만 리턴
    e.toString()은 예외 발생 이유와 종류 리턴
    e.printStackTrace()는 예외가 어디서 발생했는지 추적한 내용까지 출력

#### 예외 종류에 따른 처리

try 블록에는 다양한 종류의 예외가 발생할 수 있다. 이 때 다중 catch를 사용하면 예외에 따라 예외 처리 코드를 다르게 작성할 수 있다. catch 블록의 예외 클래스는 try블록에서 발생된 예외의 종류를 말하는데, 해당 타입의 예외가 발생하면 catch 블록이 선택되어 실행된다.

    try {
        // ArrayIndexOutofBoundsException 발생
        // NumberFormatException 발생
    } catch(ArrayIndexOutofBoundsException e) {
        // 예외처리 1
    } catch(NumberFormatException e) {
        // 예외처리 2
    }

!주의 catch블록이 여러 개일지라도 catch블록은 하나만 실행된다. try블록에서 동시다발적으로 예외가 발생하지 않으며, 하나의 예외가 발생하면 즉시 catch블록으로 이동하기 때문이다.

따라서 처리해야할 예외 클래스들이 상속관계에 있을 땐 하위 클래스 catch블록을 먼저 작성하고 상위 클래스 catch 블록을 나중에 작성해야한다. 예외가 발생하면 cath블록은 위에서부터 차례로 검사 대상이 되는데, 하위 예외도 상위 클래스 타입이므로 상위 클래스 cath블록이 먼저 검사 대상이 되면 안된다.

#### 다수의 예외를 하나의 catch 블록으로 처리하기

두 개 이상의 예외를 하나의 catch 블록으로 동일하게 예외 처리하고 싶은 경우 catch블록에 예외 클래스를 기호 |로 연결하면 된다.

    try{
        // 예외가 일어날 수 있는 코드
    } catch(NullPointerException | NumberFormatException e) {
        // 예외 처리
    } finally {
        // 항상 실행
    }

#### 리소스 자동 닫기

리소스(resource)란 데이터를 제공하는 객체를 말한다. 리소스는 사용하기 위해 열어야(open)하며, 사용한 다음에는 닫아야(close) 한다. 리소스를 사용하다가 예외가 발생될 경우에도 안전하게 닫는 것이 중요하다. 그렇지 않으면 리소스가 불안정한 상태로 남아있게 된다.

아래 코드는 file.txt파일의 내용을 읽기 위해 FileINputStream 리소스를 사용하는데, 예외 발생 여부와 상관없이 finally 블록에서 안전하게 close한다.

    FileInputStream fis = null;
    try {
        fis = new FileInputStream("file.txt"); 	// 파일 열기
        ...
    } catch(IOException e) {
        ...
    } finally {
        fis.close();	                        // 파일 닫기
    }

좀 더 간단한 방법으로 자동으로 닫아줄 수 있다. 그러나 이 방법을 사용하기 위한 조건이 있다.
리소소가 java.lang.AutoCloseable 인터페이스를 구현해서 AutoCloseable 인터페이스의 close() 메소드를 오버라이딩 해야한다.

    public class FileInputStream implements AutoCloseable {
        ...
        @Override
        public void close() throws Exception {...}
    }

    try(FileInputStream fis = new FileInputStream("file.txt")) {
        ...
    } catch(IOException e) {
        ...
    }

복수 개의 리소스를 사용해야 한다면 다음과 같이 try() 괄호 안에 세미콜론으로 그분해서 리소스를 여는 코드를 복수 개 작성하면 된다 .

    try(
        FileInputStream fis1 = new FileInputStream("file1.txt");
        FileInputStream fis2 = new FileInputStream("file2.txt")
        ) {
        ...
    } catch(IOException e) {
        ...
    }

Java 8 이전 버전은 반드시 try 괄호 안에서 리소스 변수를 선언해야 했지만,  
Java 9 부터는 외부 리소스 변수를 사용할 수 있다.

    FileInputStream fis1 = new FileInputStream("file1.txt");
    FileInputStream fis2 = new FileInputStream("file2.txt");
    try(fis1; fis2) {
        ...
    } catch(IOException e) {
        ...
    }

### 6-3. 예외 떠넘기기 : throws

메소드 내부에서 예외가 발생할 때 try-catch 블록으로 예외를 처리하는 것이 기본이지만, 메소드를 호출한 곳으로 예외를 떠넘길 수도 있다. 이때 사용하는 키워드가 throws이다. throws는 메소드 선언부 끝에 작성하는데, 떠넘길 예외 클래스를 쉼표(,)로 구분해서 나열해주면 된다.

    리턴타입 메소드명(매개변수, ...) throws 예외클래스1, 예외클래스2, ... {
        ...
    }

throws키워드가 붙어 있는 메소드에서 해당 예외를 처리하지 않고 떠넘겼기 때문에 이 메소드를 호출하는 곳에서 예외를 처리해야한다. 예를 들어 아래 코드는 ClassNotFoundException을 throws하는 method2()의 예외를 method1()에서 호출할 때 처리하고 있다.

    public void method1() {
        try {
            method2();	// method2 호출
        } catch(ClassNotFoundException e) {
            Sysytem.out.println("예외 처리: " + e.getMessage());
        }
    }

    public void method2() throws ClassNotFoundException {
        Class.forName("java.lang.String2");	// 던졌으니 호출할 때 처리
    }

나열해야 할 예외가 많을 경우 throws Exception 또는 throws Throwable 만으로 모든 예외를 간단히 떠넘길 수 있다.

    리턴타입 메소드명(매개변수,...) throws Exception {
        ...
    }

main() 메소드에서도 throws 키워드를 사용해서 예외를 떠넘길 수 있는데, 결국 JVM이 최종적으로 예외 처리를 하게 된다. JVM은 예외의 내용을 콘솔에 출력하는 것으로 예외 처리를 한다.

    public static void main(String[] args) throws Exception {
        ...
    }

### 6-4. 사용자 정의 예외

은행의 뱅킹 프로그램에서 잔고보다 더 많은 출금 요청이 들어온 경우 잔고 부족 예외를 발생시킬 필요가 있다. 그러나 잔고 부족 예외는 표준 라이브러리에는 존재하지 않기 때문에 직접 예외 클래스를 정의해서 사용해야 한다. 이것을 사용자 정의 예외라고 한다.

사용자 정의 예외는 컴파일러가 체크하는 일반 예외로 선언할 수도 있고, 컴파일러가 체크하지 않는 실행 예외로 선언할 수도 있다.

사용자 정의 예외 클래스에는 기본 생성자와 예외 메시지를 입력받는 생성자를 선언한다. 예외 메시지는 부모 생성자 매개값으로 넘겨주는데, 그 이유는 예외 객체의 공통 메소드인 getMessage()의 리턴값으로 사용하기 위해서이다.

    // 일반 예외는 Exception의 자식 클래스로 선언하고, 실행 예외는 RuntimeException의 자식 클래스로 선언한다.
    public class XXXException extends [Exception | RuntimeException] {
        public XXXException { 
            // 기본 생성자
        }

        public XXXException(String messgage) { 
            // 예외 메시지 입력받는 생성자
            super(message);
        }
    }

#### 예외 발생시키기 : throw

자바에서 제공하는 표준 예외뿐만 아니라 사용자 정의 예외를 직접 코드에서 발생시키려면 throw키워드와 함께 예외 객체를 제공하면 된다. 예외의 원인에 해당하는 메시지를 제공하고 싶다면 생성자 매개값으로 전달한다.

    throw new Exception("예외 메시지")
    throw new RuntimeException("예외 메시지");
    throw new InsufficientException("예외 메시지");

throw된 예외는 직접 try-catch블록으로 예외를 처리할 수도 있지만,

    void method() {
        try {
            ...
            throw new Exception("예외 메시지")
            ...
        } catch(Exception e) {
            String message = e.getMessage();
        }
    }

대부분은 메소드를 호출한 곳에서 예외를 처리하도록 throws 키워드로 예외를 떠넘긴다.

    void method() throws Exception {
        ...
        throw new Exception("예외 메시지")
        ...
    }

<br>
<br>

## 7. 람다식

[함수형 프로그래밍(functional programming)](https://github.com/choiyun9yu/ComputerScience/blob/main/FunctionalProgramming.md)이란 함수를 정의하고 이 함수를 데이터 처리부로 보내 데이터를 처리하는 기법을 말한다. 데이터 처리부는 데이터만 가지고 있을 뿐, 처리 방법이 정해져 있지 않아 외부에서 제공된 함수에 의존한다.

데이터 처리부는 제공된 함수의 입력값으로 데이터를 넣고 함수에 정의된 처리 내용을 실행한다. 동일한 데이터라도 함수A를 제공해서 처리하는 결과와 함수B를 제공해서 처리하는 결과는 다를 수 있다. 이것이 함수형 프로그래밍의 특징으로, 데이터 처리의 다형성이라 볼 수 있다.

자바는 함수형 프로그래밍을 위해 Java 8부터 람다식(Lambda Expressions)을 지원한다. 람다식은 데이터 처리부에 제공되는 함수 역할을 하는 매개변수를 가진 중괄호 블록이다. 데이터 처리부는 람다식을 받아 매개변수에 데이터를 대입하고 중괄호를 실행시켜 처리한다.

    (매개변수, ...) -> { 처리 내용 }

자바는 람다식을 익명 구현 객체로 변환한다. 익명 구현 객체란 이름이 없는 인터페이스 구현 객체를 말한다.

예를 들어 다음과 같이 Calculable 인터페이스가 있다고 가정해보자.

    public interface Calculable {
      // 추상 메소드
      void calculate(int x, int y);
    }

    new Calculable() {
        @Override
        public void calculate(int x, int y) { 처리 내용 }
    }

이것을 람다식으로 표현하면 다음과 같다. 추상 메소드인 calculate()는 두 개의 매개변수를 가지므로 (x, y)로 표현되었고, 화살표 -> 뒤에 calculate()의 실행 블록이 온다.

    (x, y) -> { 처리 내용 }

람다식은 인터페이스의 익명 구현 객체이므로 인터페이스 타입의 매개변수에 대입될 수 있다. 예를 들어 아래와 같이 Calculable 매개변수를 가지고 있는 action() 메소드가 있다고 가정해보자.

    public void action(Calculable calculable) {
      int x = 10;
      int y = 4;
      calculable.calculate(x, y);	// 데이터 제공하고 추상 메소드 호출
    }

action() 메소드를 호출할 때 매개값으로 다음과 같이 람다식을 제공할 수 있다. action() 메소드에서 calculable.calculate(x, y)를 실행하면 람다식의 중괄호 블록이 실행되면서 데이터가 처리된다. 여기서 action() 메소드는 제공된 람다식을 이용해서 내부 데이터를 처리하는 처리부 역할을 한다.

    action( (x,y) -> {
      int result = x + y;
      System.out.println(result);
    });

**주의!** 인터페이스의 익명 구현 객체를 람다식으로 표현하려면 인터페이스가 단 하나의 추상 메소드만 가져야 한다. (두 개 이상의 추상 메소드를 가진 인터페이스는 람다식으로 표현할 수 없다.)

    // 인터페이스
    @FunctionalInterface	// 추상 메소드가 1개인지 컴파일 할 때 검사한다.
    public interface calculable {
        void calculate(int x, int y);
    }

    // 람다식
    (x, y) -> { ... }

### 7-1. 매개변수가 없는 람다식

    // 실행문이 1개인 경우 중괄호 생략 가능
    ( ) -> 실행문

    // 실행문이 2개 이상인 경우 중괄호 생략 불가
    ( ) -> {
      실행문;
      실행문;
    }

### 7-2. 매개변수가 있는 람다식

    // 매개 변수 타입 명시
    (타입 매개변수, ...) -> {
      실행문;
      실행문;
    }

    // 구체적인 타입 대신 var 사용
    (var 매개변수, ...) -> {
      실행문;
      실행문;
    }

    // 타입 생략
    (매개변수, ...) -> {
      실행문;
      실행문;
    }

    // 매개변수가 하나일 경우에는 괄호를 생략할 수 있다.
    매개변수 -> {
      실행문;
      실행문;
    }

### 7-3. 리턴값이 있는 람다식

    (매개변수, ...) -> {
      실행문;
      retrun 값;
    }

    // return문 하나만 있을 땐 return 생략 가능, 리턴 값으로 연산식 혹은 리턴값이 있는 메소드로 호출을 대체할 수 있다.
    (매개변수, ...) -> 값
