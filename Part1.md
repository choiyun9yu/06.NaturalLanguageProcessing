# JAVA Part1

### 자바 런타임 환경(JRE;Java Runtime Environment)

자바프로그램을 실행할 때 필요한 환경을 제공하는 프로그램이다. JRE에는 JVM, 클래스 라이브러리, 런타임 환경 등이 포함되어 있다. 런타임 환경은 소프트웨어가 실행되는 환경이다. 소프트웨어가 실행될 때 필요한 라이브러리, 런타임 시스템 데이터, 메모리 등이 모두 포함된 환경이다.

### 자바 개발 도구(JDK;Java Developmetn Kit)

자바 프로그램을 개발하기 위해 필요한 모든 도구와 라이브러리가 포함된 패키지이다. JDK에는 Java Compiler, JVM, 클래스 라이브러리, 디버깅 도구 등이 포함되어 있다.

### 자바 가상 머신(JVM;Java Virtual Machine)

자바 프로그램을 실행하기 위한 가상머신이다. JVM은 운영체제나 하드웨어와 상관없이 동일한 실행환경을 제공한다. Java는 JVM에 설치된 컴퓨터에서 실행되며, JVM은 자바 바이트 코드를 해당 운영체제에서 실행가능한 기계어로 변환하여 실행한다.

### 자바 컴파일 과정

① 소스코드를 작성하면 *파일명.java*로 저장  
② *javac 파일명.java*로 컴파일  
③ *파일명.class*라는 바이트 코드 파일 생성  
④ *java 파일명.java*로 자바 가상 머신이 바이트 코드 파일 실행

### 패키지(Package)

자바는 소스 파일 및 컴파일된 바이트코드 파일을 쉽게 관리하기 위해 패키지를 사용한다. 패키지는 파일 시스템에서의 디렉토리와 비슷하다.

<br>
<br>

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

컴파일러는 기본적으로 int로 간주하기 때문에 l을 붙여서 long type 임을 컴파일러에게 알려줘야 한다.

    int var1 = 1000000000000;   // 허용 범위 초과 컴파일 오류
    long var1 = 1000000000000;  // 리터럴 컴파일 오류,
    long var2 = 1000000000000l; // long 타입 인식 (l or L 모두 가능)

### 1-2. 문자 타입(사실은 정수 타입)

하나의 문자를 작은따옴표(')로 감싼 것을 문자 리터럴이라고 한다. **문자 리터럴은 유니코드로 변환되어 저장된다.** 유니코드는 세계 각국의 문자를 0~65535 숫자로 매핑한 국제 표준 규약이다.

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

## 3. 스코프(Scope)

메소드 블록에는 다른 중괄호({ })블록들이 작성될 수 있다. 이러한 중괄호({ })블록 내에서 선언된 변수는 해당 중괄호({ })블럭 내에서만 사용이 가능하고 밖에서는 사용할 수 없다.

만약 메소드 블록 전체에서 사용하고 싶다면 메소드 블록 첫머리에 선언하는 것이 좋고, 특정 블록 내부에서만 사용된다면 해당 블록 내에서 선언하는 것이 좋다.

<br>
<br>

## 4. 변수 값 입출력

### 4-1. 변수 출력

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

### 4-2. 키보드 입력

키보드로부터 입력된 데이터를 읽고 변수에 저장하는 가장 쉬운 방법은 Scanner를 사용하는 것이다. Scanner 타입 변수를 선언하고, 대입연산자(=)를 사용해서 new 연산자로 생성한 Scanner 객체를 변수에 대입한다. **nextLine( )** 은 Enter키가 입력되기 전까지 블로킹(대기) 상태가 되며, Enter키가 입력되면 지금까지 입력된 모든 내용을 문자열로 읽는다.

    Scanner scanner = new Scanner(System.in);
    Scanner inputData = scanner.nextLine();

<br>
<br>

## 5. 연산자(Operator)

### 5-1. 부호/증감 연산자

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

### 5-2. 산술 연산자

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

### 5-3. 비교연산자

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

### 5-4. 논리 연산자

> 종류 : &&(논리곱), ||(논리합), ^(배타적 논리합), !(부정)

> 반환 : boolean

논리연산은 주로 조건문, 반복문 등에서 이용한다.

### 5-5. 비트 논리 연산자

2진수로 저장되는 정수 타입(byte, short, int, long)만 피연산자가 될 수 있다.

### 5-6. 비트 이동 연산자(쉬프트 연산자)

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

### 5-7. 삼항 조건 연산자

    조건식 ? 참일때 : 거짓일때;

<br>

### 5-9. 연산자 우선순위

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

## 6. 제어문

자바 프로그램은 main( )메소드의 시작 중괄호에서 끝 중괄호 까지 위에서 아래로 실행하는 흐름을 가지고 있다. 제어문은 이러한 실행 흐름을 개발자가 원하는 방향으로 바꿀 수 있도록 해준다. 즉, 제어문을 사용할 경우 다양한 실행 흐름이 생성된다.

### 6-1. 조건문( if / switch )

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

### 6-2. 반복문( for / foreach / forEach / while / do-while )

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

## 7. 참조 타입

#### null 과 NullPointerException

참조 타입 변수는 아직 번지를 가지고 있지 않다는 뜻으로 null값을 가질 수 있다. null도 초기값으로 사용할 수 있기 때문에 null로 초기화된 참조 변수는 스택 영역에 생성된다.

NullPointerException은 참조 변수를 사용하면서 가장 많이 발생하는 예외 중 하나다. 변수가 null인 상태에서 객체의 데이터나 메소드를 사용하려할 때 발생한다. heap 영역에 생성된 객체가 어떤 변수도 참조하고 있지 않으면 쓰레기 객체가 되고, 이것은 Garbage Collector에 의해 제거된다.

### 7-1. 문자열(String)

자바에서 문자열은 String 객체로 생성된다.

#### 문자열 비교 : .equls("비교문자열")

자바는 문자열 리터럴이 동일하다면 String 객체를 공유하도록 설계되어 있다. 하지만 new연산자로 새로 객체를 만들면 리터이 같아도 다른 번지에 저장된다. 따라서 문자열 리터럴로 생성하느냐 new연산자로 생성하느냐에 따라 결과가 달라질 수 있다. (메모리 관리 측면에서 new 생성자를 사용하는 것은 비효율적이어서 거의 사용하지 않는다.)

    boolean result1 = srt1.equals(srt2);  // 문자열이 같은지 검사
    boolean result2 = !srt1.equals(srt2); // 문자열이 다른지 검사

    // 문자열 리터럴로 생성하는 경우, 같은 번지 참조
    String name1 = "홍길동";
    String name2 = "홍길동";
    boolean result3 = name1.equals(name2);  //  true

    // new 생성자로 생성하는 경우, 다른 번지 참조
    String name3 = "아무개";
    String name4 = new String("아무개");
    boolean result4 = name3.equals(name4)'  // false

#### 문자 추출 : charAt(인덱스번호)

문자열에서 특정위치 문자를 얻는 메소드이다. 매개값으로 주어진 인덱스번호의 문자를 반환한다.

    String subject = "자바 프로그래밍";
    cahr charValue = subject.charAt(3); // 반환 값 '프'

#### 문자열 길이 : length()

문자열에서 문자의 개수를 반환한다.(공백 포함)

    String subject = "자바 프로그래밍";
    int length = subject.length(); 	// 공백까지 카운트하여 8 반환

#### 문자열 대체 : replace(바꾸기전, 바뀐후)

문자열에서 특정 문자열을 다른 문자로 대체할 때 사용한다. String 객체는 변경이 불가능한 특성을 갖기 때문에 replace()가 반환하는 문자열은 원래 문자열의 수정본이 아니라 완전히 새로운 문자열이다.

    String oldStr = "자바 프로그래밍";
    String newStr = oldStr.replace("자바","Java");  // "Java 프로그래밍" 반환

#### 문자열 슬라이싱 : .substring(시작인덱스), .substring(이상,미만)

정수 한 개만 입력하면 시작 부분부터 끝까지 슬라이싱 해준다. 정수 두 개를 입력하면 해당 구간을 슬라이싱 해준다.

    String ssn = 880815-1234567;
    String fristNum = ssn.substring(0,6);	// 880815
    String secondNum = ssn.sustring(7);		// 1234567

#### 문자열 찾기 : indexOf("찾을문자열")

문자열에서 특정 문자열의 위치를 찾을 때 사용한다. 반환값은 문자열의 시작 인덱스이다. 만약 문자열이 포함되어 있지 않으면 -1을 반환한다.

    String subject = "자바 프로그래밍";
    int index = subct.indexOf("프로그래밍");		// 3

#### 문자열 분리 : split("구분자")

문자열이 구분자를 사용하여 여러 개의 문자열로 구성되어 있을 경우 분리할 때 사용한다.

    String board = "번호,제목,내용,성명";
    String[] arr = board.split(",");	// arr = [[번호],[제목],[내용],[성명]]

### 7-2. 배열

연속된 공간에 **동질적인 자료형을 나열**하고 인덱스를 부여한 자료구조이다. 자바에서 배열의 길이는 늘리거나 줄일 수 없다.

기본타입 배열은 각 요소에 값을 직접 저장하지만, 참조 타입(클래스, 인스턴스) 배열은 각 요소에 객체의 번지를 저장한다.

#### 배열의 생성, 대입, 수정

    // 배열의 선언과 대입(수정)
    타입[] 배열명;
    타입[] 배열명 = null;    // 참조할 배열이 없다면 null로 초기화 가능
    배열명[인덱스] = 값;      // 인덱스번호에 값을 대입 or 수정

    // 값 목록으로 배열 생성
    타입[] 배열명 = {값0, 값1, 값2 ... };

    // 주의 사항 : 배열 선언 뒤 값 목록을 변수에 대입할 수 없다.
    타입[] 배열명; 	            // 선언당
    배열명 = {값0, 값1, 값2 ...};  // 컴파일 에러

    // new연산자로 배열 선언
    타입[] 배열명 = new 타입[길이];  // 기본 타입 배열을 new 연산자로 생성하면 기본 값으로 초기화 된다. 정수형은 0, 실수형은 0.0, 문자형은 '\u0000', boolean은 false, 참조형은 null이다.
    배열명[인덱스번호] = 값;         // 데이터 할당

    // 배열 선언 뒤 new연산자로 대입은 가능하다.
    String[] names = null;
    names = new String[] {"홍길동", "아무개" ...};

#### 배열 길이(배열에 저장할 수 있는 항목 수) : length

    배열명.length;	// 다차원배열인 경우에는 1차원 배열의 길이를 반환

#### 다차원 배열

배열의 요소로 또 다른 배열이 대입된 경우

    // 값 목록으로 배열 생성
    타입[][] 배열명 = {
        {값1, 값2, 값3},	// 1차원 배열의 0인덱스
        {값4, 값5, 값6}	// 1차원 배열의 1인덱스
    };

    // new연산자로 다차원 배열 선언
    타입[][] 배열명 = new 타입[1차원수][2차원수];

    // 배열의 길이가 다른경우
    int[][] scores = new int[2][];	// 1차원은 고정2개인데 2차원은 다름
    scores[0] = new int[3];	        // 1차원 인덱스번호 0에 3칸 배열 생성
    scores[1] = new int[2];	        // 1차원 인덱스번호 1에 2칸 배열 생성

#### 배열 복사 : System.arraycopy(원본배열, 원본배열복사시작인덱스, 새 배열, 새 배열붙여넣기시작인덱스, 복사항목수)

배열은 한 번 생성하면 길이를 변경할 수 없다. 더 많은 저장 공간이 필요한 경우 더 큰 길이의 배열을 새로 만들고 이전 배열로 부터 항목들을 복사해야 한다.

    // 원본 배열이 arr1이고 새 배열이 arr2일 경우 arr1의 모드 항목을 arr2로 복사하는 코드
    System.arraycopy(arr1, 0, arr2, 0, arr1.length);

### 7-3. 열거 타입(Enum Type)

데이터 중에는 몇 가지로 한정된 값을 갖는 경우가 있다. 예를 들어 요일은 월요일부터 일요일까지 7개 값을, 계절은 봄, 여름, 가을, 겨울 4개의 값을 갖는다. 그리고 이와 같이 한정된 값을 갖는 타입을 열거 타입(enumeration type)이라 한다. 열거 타입을 사용하기 위해서는 먼저 열거 타입 이름으로 소스 파일(.java)을 생성하고 한정된 값을 코드로 정의해야 한다. 열거 타입 이름은 첫 문자를 대문자로하는 캐멀 스타일로 지어주는 것이 관례다.

#### WeekDay.java

    // 열거타입은 enum으로 선언
    public enum WeekDay {
        // 열거 상수 목록(열거 타입으로 사용할 수 있는 한정된 값)
        // 열거 상수는 관례상 언더바로 연결하는 스네이크 스타일로 지어주는 것이 관례다.
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }

    // 열거 타입도 하나의 데이터 타입으므로 변수를 선언하고 사용해야 한다.
    Week today;
    Week reservationDay;

    // 열거타입.열거상수 형태로 값을 대입한다.
    Week today = Week.SUNDAY;

<br>
<br>

## 8. 컬렉션(Collection)

배열은 같은 타입만 저장가능하고, 길이를 변경할 수 없다. 길이를 변경하기 위해서는 배열 복사해야한다.

컬렉션 자료 구조는 같은 타입만 저장가능하게 만들 수 있고, 다른 타입도 저장가능하게 만들 수 있다. 그러나 컬렉션 자료 구조는 길이가 고정되어 있지 않다. 그리고 자료 구조에 따라서 다양한 방법으로 자료를 저장할 수 있다(번지가 저장되는 것).

| 컬렉션 | 특징                                                | 구현클래스                                   |
| ------ | --------------------------------------------------- |-----------------------------------------|
| List   | 순서를 유지하고 저장, 중복 저장 가능                | ArrayList, Vector, LinkedList           |
| Set    | 순서를 유지하지 않고 저장, 중복 저장 불가           | HashSet, TreeSet                        |
| Map    | 키와 값으로 구성된 엔트리 저장, 키는 중복 저장 불가 | HashMap, HashTable, TreeMap, Properties |

### 8-1. List 컬렉션

객체를 인덱스로 관리한다. 때문에 인덱스로 객체를 검색하거나 삭제할 수 있다.
객체 중복 저장이 가능하다.

| 기능      | 메소드                            | 설명                                                   |
| --------- |--------------------------------| ------------------------------------------------------ |
| 객체 추가 | boolean add(E e)               | 주어진 객체를 맨 끝에 추가                             |
|           | void add(int index, E element) | 주어진 인덱스에 객체를 추가(한칸씩 뒤로 밈)            |
|           | set(int index, E elemetn)      | 주어진 인덱스의 객체를 새로운 객체로 바꿈              |
| 객체 검색 | boolean contains(Object o)     | 주어진 객체가 저장되어 있는지 여부                     |
|           | E get(int index)               | 주어진 인덱스에 저장된 객체를 리턴                     |
|           | isEmpty()                      | 컬렉션이 비어 있는지 조사                              |
|           | int size()                     | 저장되어 있는 전체 객체 수를 리턴                      |
| 객체 삭제 | void clear()                   | 저장된 모든 객체를 삭제                                |
|           | E remove(int index)            | 주어진 인덱스에 저장된 객체를 삭제(한칸씩 앞으로 당김) |
|           | boolean remove(Object o)       | 주어진 객체를 삭제                                     |

#### ArrayList

ArrayLis에 객체를 추가하면 내부 배열에 객체가 저장된다. 일반 배열과의 차이점은 ArrayList는 제한 없이 객체를 추가할 수 있다는 것이다.

빈번한 객체 삽입과 삭제가 일어나는 곳에서는 (메모리에 번지를 계속 바꿔야해서) ArrayList를 사용하는 것은 바람직하지 않다. 대신 이런 경우라면 LinkedList를 사용하는 것이 좋다.

    // ArrayList 컬렉션 생성
    List<E> list = new ArrayList<E>();  // E에 지정된 타입의 객체만 저장
    List<E> list = new ArrayList<>();   // E에 지정된 타입의 객체만 저장
    List list = new ArrayList();	    // 모든 타입의 객체를 저장


#### Vector

Vecotr는 ArrayList와 동일한 내부 구조를 가지고 있다. 차이점은 Vector는 동기화된 메소드로 구성되어 있기 때문에 멀티 스레드가 동시에 Vector() 메소드를 실행할 수 없다는 것이다. 그렇기 때문에 멀티 스레드 환경에서 안전하게 객체를 추가 또는 삭제할 수 있다.

    // Vector 컬렉션 생성
    List<E> list = new Vector<E>();   // E에 지정된 타입의 객체만 저장
    List<E> list = new Vector<>();    // E에 지정된 타입의 객체만 저장
    List list = new Vector();         // 모든 타입의 객체를 저장

#### LinkedList

LinkedList는 ArrayList와 사용 방법은 동일하지만 내부 구조는 완전히 다르다. ArrayList는 내부 배열에 객체를 저장하지만, LinkedList는 인접 객체를 체인처럼 연결해서 관리한다.
LinkedList는 특정 위치에서 객체를 삽입하거나 삭제하면 바로 앞뒤 링크만 변경하면 되므로 빈번한 객체 삭제와 삽입이 일어나느 곳에서는 ArrayList보다 좋은 성능을 발휘한다.

    // LinkedList 컬렉션 생성
    List<E> list = new LinkedList<E>(); // E에 지정된 타입의 객체만 저장
    List<E> list = new LinkedList<>();  // E에 지정된 타입의 객체만 저장
    List list = new LinkedList();       // 모든 타입의 객체를 저장

### 8-2 Set 컬렉션

List 컬렉션은 저장 순서를 유지하지만, Set 컬렉션은 저장 순서가 유지되지 않는다. 또한 객체를 중복해서 저장할 수 없다. null도 하나만 저장할 수 있다.

Set은 요소 수정이 불가능하므로 요소를 제거하고 새로운 요소를 추가해야 한다.

| 기능      | 메소드                     | 설명                                                       |
| --------- | -------------------------- | ---------------------------------------------------------- |
| 객체 추가 | boolean add(E e)           | 주어진 객체를 성공적으로 저장하면 true 중복이면 false 반환 |
| 객체 검색 | boolean contains(Object o) | 주어진 객체가 저장되어 있는지 여부                         |
|           | E get(int index)           | 주어진 인덱스에 저장된 객체를 리턴                         |
|           | isEmpty()                  | 컬렉션이 비어 있는지 조사                                  |
|           | Iterator< E > iterator()   | 저장된 객체를 한 번씩 가져오는 반복자 리턴                 |
|           | int size()                 | 저장되어 있는 전체 객체 수를 리턴                          |
| 객체 삭제 | void clear()               | 저장된 모든 객체를 삭제                                    |
|           | boolean remove(Object o)   | 주어진 객체를 삭제                                         |

#### HashSet

Set컬렉션 중 가장 많이 사용되는 것이다. HashSet은 다른 객체라도 HashCode() 메소드의 리턴 값이 같고, equals() 메소드가 true를 리턴하면 동일한 객체라고 판단하고 중복 저장하지 않는다.


    Set<E> set = new HashSet<E>();	    // E에 지정된 타입의 객체만 저장
    Set<E> set = new HashSet<>();	    // E에 지정된 타입의 객체만 저장
    Set<> set = new HashSet<>(); 	    // 모든 타입의 객체를 저장


Set 컬렉션은 인덱스로 객체를 검색해서 가져오는 메소드가 없다. 대신 객체를 한 개씩 반복해서 가져와야 하는데, 여기에는 두 가지 방법이 있다.

    // 1. for문을 이용해서 하나씩 가져오기
    Set<E> set = new HashSet<>();
    for(E e : set) {
        ...
    }

    // 2. Iterator() 메소드로 반복자를 얻어 객체를 하나씩 가져오기
    Set<E> set = new HashSet<>();
    Iterator<E> iterator = set.iterator();

iterator는 Set 컬렉션의 객체를 가져오거나 제거하기 위해 다음 메소드를 제공한다.

| 리턴타입 | 메소드명  | 설명                                                          |
| -------- | --------- | ------------------------------------------------------------- |
| boolean  | hasNext() | 가져올 객체가 있으면 true를 리턴하고 없으면 false를 리턴한다. |
| E        | next()    | 컬렉션에서 하나의 객체를 가져온다.                            |
| void     | remove()  | next()로 가져온 객체를 Set 컬렉셔에서 제거한다.               |

hasNext() 메소드로 가져올 객체가 있는지 먼저 확인하고, true를 리턴할 때만 next() 메소드로 객체를 가져온다.

    while(itterator.hasNext()) {
        E e = iterator.next();
    }

### 8-3. Map 컬렉션

Map 컬렉션은 키(key)와 값(value)으로 구성된 엔트리(Entry) 객체를 저장한다. 여기서 키와 값은 모두 객체이다. 키는 중복 저장할 수 없지만 값은 중복 저장할 수 있다.
기존에 저장된 키와 동일한 값으로 저장하면 기존의 값은 없어지고 새로운 값으로 대치된다.

| 기능      | 메소드                              | 설명                                                             |
| --------- | ----------------------------------- | ---------------------------------------------------------------- |
| 객체 추가 | V put(K key, V value)               | 주어진 키와 값을 추가, 저장이 되면 값을 리턴                     |
| 객체 검색 | boolean containsKey(Object key)     | 주어진 키가 있는지 여부                                          |
|           | boolean containsValue(Object value) | 주어진 값이 있는지 여부                                          |
|           | Set<Map.Entry<K,V>> entrySet()      | 키와 값의 쌍으로 구성된 모든 Map.Entry 객체를 set에 담아 서 리턴 |
|           | V get(Object key)                   | 주어진 키의 값을 리턴                                            |
|           | boolean isEmpty()                   | 컬렉션이 비어있는지 여부                                         |
|           | Set<K> keySet()                     | 모든 키를 Set 객체에 담아서 리턴                                 |
|           | int size()                          | 저장된 키의 총 수를 리턴                                         |
|           | Collection<V> values()              | 저장된 모든 값 Collection에 담아서 리턴                          |
| 객체 삭제 | void clear()                        | 모든 Map.Entry(키와 값) 삭제                                     |
|           | V remove(Object key)                | 주어진 키와 일치하는 Map.Entry 삭제, 삭제되면 리턴               |

#### HashMap

HashMap은 키로 사용할 객체가 hashCode() 메소드의 리턴값과 같고 equals()메소드가 true를 리턴할 경우 동일 키로 보고 중복 저장을 허용하지 않는다.

    // HashMap 생성
    Map<K, V> map = new HashMap<K, V>();	// 지정된 타입의 객체만 저장
    Map<K, V> map = new HashMap<>();		// 지정된 타입의 객체만 저장
    Map map = new HashMap();				// 모든 타입 객체를 저장

#### HashTable

Hashtable은 HashMap과 동일한 내부구조를 가지고 있다. 차이점은 HashTable은 동기화된 메소드로 구성되어 있기 때문에 멀티 스레드가 동시에 HashTable의 메소드들을 실행할 수 없다는 것이다. 따라서 멀티 스레드 환경에서도 안전하게 객체를 추가, 삭제 할 수 있다.

    Map<K, V> map = new Hashtable<K, V>();	// 지정된 타입의 객체만 저장
    Map<K, V> map = new Hashtable<>();		// 지정된 타입의 객체만 저장
    Map map = new Hashtable();				// 모든 타입 객체를 저장

#### Properties

Properties는 HashTable의 자식 클래스이기 때문에 HashTable의 특징을 그대로 가지고 있다. Properties는 키와 값을 String으로 제한한 컬렉션이다. Properties는 주로 확장자가 .properties인 프로퍼티 파일을 읽을 때 사용한다.

프로퍼티 파일은 다음과 같이 키와 값이 = 기호로 연결되어 있는 텍스트 파일이다. 일반 텍스트 파일과는 다르게 ISO- 8859-1 문자셋으로 저장되며, 한글일 경우에는 \u+유니코드로 표현되어 저장된다.

    파일명 : database.properties

    driver = oracle.jdbc.OracleDirver
    url = jdbc:oracle:thin:@localhost:1521:orcl
    username = scott
    password = tiger
    admin = \uD64D\uAE38\uB3D9

Properties를 사용하면 위와 같은 프로퍼티 파일의 내용을 코드에서 쉽게 읽을 수 있다.
먼저 Properties 객체를 생성하고, load() 메소드로 프로퍼티 파일의 내용을 메모리 로드한다.

    Properties properties = new Properties();
    properties.load(Xxx.class.getResourceAsStream("database.properties"));

일반적으로 프로퍼티 파일은 클래스 파일 (~.class)들과 함께 저장된다. 따라서 클래스 파일을 기준으로 상대 경로를 이용해서 읽는 것이 편리하다. Class 객체의 getResourceAsStream() 메소드는 주어진 상대 경로의 리소스 파일을 읽는 InputStream을 리턴한다.

### 8-4. 검색 기능을 강화시킨 컬렉션

#### TreeSet (Set 컬렉션)

TreeSet은 이진 트리(binary tree)를 기반으로 한 Set 컬렉션이다. 이진 트리는 여러 개의 노드(node)가 트리 형태로 연결된 구조로, 루트 노드(root node)라고 불리는 하나의 노드에서 시작해 각 노드에 최대 2개의 노드를 연결할 수 있는 구조를 가지고 있다.

TreeSet에 객체를 저장하면 부모 노드와 비교해서 낮은 것은 왼쪽 자식 노드에, 높은 것은 오른 쪽 자식 노드에 저장한다.

    // TreeSet 생성
    TreeSet<E> treeset = new TreeSet<E>();
    TreeSet<E> treeset = new TreeSet<>();

#### TreeSet에 정의된 검색 관련 메소드

| 리턴타입        | 메소드                                                                             | 설명                                                                                                                                |
| --------------- | ---------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------- |
| E               | fist()                                                                             | 제일 낮은 객체를 리턴                                                                                                               |
| E               | last()                                                                             | 제일 높은 객체를 리턴                                                                                                               |
| E               | lower(E e)                                                                         | 주어진 객체보다 바로 아래 객체를 리턴                                                                                               |
| E               | higher(E e)                                                                        | 주어진 객체보다 바로 위 객체를 리턴                                                                                                 |
| E               | floor(E e)                                                                         | 주어진 객체와 동등한 객체가 있으면 리턴, 만약 없다면 주어진 객체 바로 아래의 객체 리턴                                              |
| E               | ceiling(E e)                                                                       | 주어진 객체와 동등한 객체가 있으면 리턴, 만약 없다면 주어진 객체의 바로 위 객체 리턴                                                |
| E               | pollFirst()                                                                        | 제일 낮은 객체를 꺼내오고 컬렉션에서 제거                                                                                           |
| E               | pollLast()                                                                         | 제일 높은 객체를 꺼내오고 컬렉션에서 제거                                                                                           |
| Iterator<E>     | descendingIterator()                                                               | 내림차순으로 정렬된 Iterator를 리턴                                                                                                 |
| NavigableSet<E> | descendingSet()                                                                    | 내림차순으로 정렬된 NavigableSet을 리턴                                                                                             |
| NavigableSet<E> | headSet( E to Element, boolean inclusive )                                         | 주어진 객체보다 낮은 객체들을 NavigableSet으로 리턴, 주어진 객체 포함 여부는 두 번째 매개값에 따라 달라짐                           |
| NavigableSet<E> | tailSet( E fromElement, boolean inclusive )                                        | 주어진 객체보다 높은 객체들을 NavigableSet으로 리턴, 주어진 객체 포함 여부는 두 번째 매개값에 따라 달라짐                           |
| NavegableSet<E> | subSet ( E fromElement, boolean fromInclusive, E to Element, boolean toInclusive ) | 시작과 끝으로 주어진 객체 사이의 객체들을 NavigableSet으로 리턴, 시작과 끝 객체의 포함 여부는 두 번째, 네 번째 매개값에 따라 달라짐 |

#### TreeMap (Map 컬렉션)

TreeMap은 이진 트리를 기반으로 한 Map 컬렉션이다. TreeSet과의 차이점은 키와 값이 저장된 Entry를 저장한다는 점이다. TreeMap에 엔트리를 저장하면 키를 기준으로 자동 정렬되는데, 부모 키 값과 비교해서 낮은 것은 왼쪽, 높은 것은 오른쪽 자식 노드에 Entry 객체를 저장한다.

    // TreeMap 생성
    TreeMap<K, V> treemap = new TreeMap<K, V>();
    TreeMap<K, V> treemap = new TreeMap<>();

#### TreeMap에 정의된 검색 관련 메소드

| 리턴타입          | 메소드                                                                   | 설명                                                                                                                                                  |
| ----------------- | ------------------------------------------------------------------------ | ----------------------------------------------------------------------------------------------------------------------------------------------------- |
| Map.Entry<K,V>    | fistEntry()                                                              | 제일 낮은 Map.Entry를 리턴                                                                                                                            |
| Map.Entry<K,V>    | lastEntry()                                                              | 제일 높은 Map.Entry를 리턴                                                                                                                            |
| Map.Entry<K,V>    | lowerEntry(K key)                                                        | 주어진 키보다 바로 아래 Map.Entry를 리턴                                                                                                              |
| Map.Entry<K,V>    | higherEntry(K key)                                                       | 주어진 키보다 바로 위 Map.Entry를 리턴                                                                                                                |
| Map.Entry<K,V>    | floorEntry(K key)                                                        | 주어진 키와 동등한 키가 있으면 해당 Map.Entry를 리턴, 없다면 주어진 키 바로 아래의 Map.Entry를 리턴                                                   |
| Map.Entry<K,V>    | ceilingEntry(K key)                                                      | 주어진 키와 동등한 키가 있으면 해당 Map.Entry를 리턴, 없다면 주어진 키 바로 위의 Map.Entry를 리턴                                                     |
| Map.Entry<K,V>    | pollFirstEntry()                                                         | 제일 낮은 Map.Entry를 꺼내오고 컬렉션에서 제거                                                                                                        |
| Map.Entry<K,V>    | pollLastEntry()                                                          | 제일 높은 Map.Entry를 꺼내오고 컬렉션에서 제거                                                                                                        |
| NavigableSet<K>   | descendingKeySet()                                                       | 내림차순으로 정렬된 키의 NavigableSet을 리턴                                                                                                          |
| NavigableMap<K,V> | descendingMap()                                                          | 내림차순으로 정렬된 Map.Entry의 NavigableMap을 리턴                                                                                                   |
| NavigableMap<K,V> | headMap( K toKey, boolean inclusive )                                    | 주어진 키보다 낮은 Map.Entry들을 NavigableMap으로 리턴, 주어진 키의 Map.Entry 포함 여부는 두 번째 매개값에 따라 달라짐                                |
| NavigableMap<K,V> | tailmap( K fromKey, boolean inclusive )                                  | 주어진 객체보다 높은 Map.Entry들을 NavigableMap으로 리턴, 주어진 객체 포함 여부는 두 번째 매개값에 따라 달라짐                                        |
| NavigableMap<K,V> | subMap( K fromKey, boolean fromInclusive, K toKey, boolean toInclusive ) | 시작과 끝으로 주어진 키 사이의 Map.Entry들을 NavigableMap 컬렉션으로 반환, 시작과 끝 키의 Map.Entry 포함 여부는 두 번째, 네 번째 매개값에 따라 달라짐 |

#### Comparable과 Comparator

TreeSet에 저장되는 객체와 TreeMap에 저장되는 키 객체는 저장과 동시에 오름차순 정렬되는데, 어떤 객체든 정렬될 수 있는 것은 아니고 객체가 Comparable 인터페이스를 구현하고 있어야 가능하다. Integer, Double, String 타입은 모두 Comparable을 구현하고 있기 때문에 상관 없지만, 사용자 정의 객체를 저장할 때에는 반드시 Comparable을 구현하고 있어야 한다.

Comparable 인터페이스에는 compareTo() 메소드가 정의되어 있다. 따라서 사용자 정의 클래스에서 이 메소드를 재정의해서 비교 결과를 정수 값으로 리턴해야 한다.

| 리턴 타입 | 메소드                | 설명                                      |
| --------- | --------------------- | ----------------------------------------- |
| int       | compareTo(T o)        | -주어진 객체와 같으면 0을 리턴            |
|           |                       | -주어진 객체보다 적으면 음수를 리턴       |
|           |                       | -주어진 객체보다 크면 양수를 리턴         |
| int       | compareTo(T o1, T o2) | -o1과 o2가 동등하다면 0을 리턴            |
|           |                       | -o1이 o2보다 앞에 오게 하려면 음수를 리턴 |
|           |                       | -o1이 o2보다 뒤에 오게 하려면 양수를 리턴 |

    //Person.java
    public class Person implements Comparable<Person> {
      public String name;
      public int age;

      public Person(String name, int age) {
        this.name = name;
        this.age = age;
      }

      @Override
      public int compareTo(Person o) {
        if(age < o.age) return -1;
        else if(age == o.age) return 0;
        else return 1;
      }
    }

비교 기능이 이는 Comparable 구현 객체를 TreeSet에 저장하거나 TreeMap의 키로 저장하는 것이 원칙이지만, 비교 기능이 없는 Comparable 비구현 객체를 저장하고 싶다면 방법은 없진 않다.
TreeSet과 TreeMap을 생성할 때 비교자를 다음과 같이 제공하면 된다.

    TreeSet<E> treeSet = new TreeSet<E>( new ComparatorImpl() );
    TreeMap<K,V> treeMap = new TreeMap<K,V>( new ComparatorImpl() );

### 8-5. LIFO와 FIFO 컬렉션

스택을 응용한 대표적인 예가 JVM 스택 메모리이다. 스택 메모리에 저장된 변수는 나중에 저장된 것부터 제거된다. 큐를 응용한 대표적인 예가 스레드풀(ExecutorService)의 작업 큐이다. 작업큐는 먼저 들어온 작업부터 처리한다.

#### Stack(Last In First Out)

    Stack<E> stack = new Stack<E>();
    Stack<E> stack = new Stack<>();

| 리턴 타입 | 메소드       | 설명                         |
| --------- | ------------ | ---------------------------- |
| E         | push(E item) | 주어진 객체를 스택에 넣는다. |
| E         | pop()        | 스택의 맨 위 객체를 빼낸다.  |

#### Queue(First In First Out)

Queue 인터페이스를 구현하는 대표적인 클래스는 LinkedList이다. 그렇기 때문에 LinkedList 객체를 Queue 인터페이스 변수에 대입할 수 있다.

    Queue<E> queue = new LinkedList<E>();
    Queue<E> queue = new LinkedList<>();

| 리턴 타입 | 메소드     | 설명                       |
| --------- | ---------- | -------------------------- |
| boolean   | offer(E e) | 주어진 객체를 큐에 넣는다. |
| E         | poll()     | 큐에서 객체를 빼낸다.      |

### 8-6. 동기화된 컬렉션

컬렉션 프레임워크의 대부분의 클래스들은 싱글 스레드 환경에서 사용할 수 있도록 설계되었다. 그렇기 때문에 여러 스레드가 동시에 컬렉션에 접근한다면 의도하지 않게 요소가 변경될 수 있는 불안전한 상태가 된다.

Vector와 Hashtable은 동기화(synchronized) 메소드로 구성되어 있기 때문에 멀티 스레드 환경에서 안전하게 요소를 처리할 수 있지만, ArrayList와 HashSet, HashMap은 동기화된 메소드로 구성되어 있지 않아 멀티 스레드 환경에서 안전하지 않다.

경우에 따라서 ArrayList, HashSet, HashMap을 멀티 스레드 환경에서 사용하고 싶을 때가 있을 것이다. 이런 경우를 대비해서 컬렉션 프레임워크는 비동기화된 메소드를 동기화된 메소드로 래핑하는 Collections의 synchronizedXXX() 메소드를 제공한다.

| 리턴 타입 | 메소드(매개변수)               | 설명                        |
| --------- | ------------------------------ | --------------------------- |
| List<T>   | synchronizedList(List<T> list) | List를 동기화된 List로 리턴 |
| Set<T>    | synchronizedSet(Set<T> s)      | Set을 동기화된 Set으로 리턴 |
| Map<K,V>  | synchronizedMap(Map<K,V> m)    | Map을 동기화된 Map으로 리턴 |

    List<T> list = Collections.synchronizedList(new ArrayList<T>());
    Set<E> set = Collections.synchronizedSet(new HashSet<E>());
    Map<K,V> map = Collections.synchronizedMap( new HashMap<K,V>);

### 8-7. 수정할 수 없는 컬렉션

수정할 수 없는(unmodifiable) 컬렉션이란 요소를 추가, 삭제할 수 없는 컬렉션을 말한다. 컬렉션 생성 시 저장된 요소를 변경하고 싶지 않을 때 유용하다. 여러 가지 방법으로 만들 수 있다.

먼저 첫 번째 방법으로는 List, Set, Map 인터페이스의 정적 메소드인 of()로 생성하는 방법이 있다.

    List<E> immutableList = List.of(E... elements);
    Set<E> immutableSet = Set.of(E... elemtens);
    Map<K,V> immutableMap = Map.of(K k1, V v1, K k2, V v2, ...);

두 번째 방법은 List, Set, Map 인터페이스의 정적 메소드인 copyOf()를 이용해 기존 컬렉션을 복사하여 수정할 수 없는 컬렉션을 만드는 것이다.

    List<E> immutableList = List.copyOf(E... elements);
    Set<E> immutableSet = Set.copyOf(E... elemtens);
    Map<K,V> immutableMap = Map.copyOf(K k1, V v1, K k2, V v2, ...);

세 번째 방법은 배열로부터 수정할 수 없는 List 컬렉션을 만들 수 있다.

    String[] arr = { "A", "B", "C" };
    List<String> immutableList = Arrays.asList(arr);

<br>
<br>

## 5. 람다식

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

### 5-1. 매개변수가 없는 람다식

    // 실행문이 1개인 경우 중괄호 생략 가능
    ( ) -> 실행문

    // 실행문이 2개 이상인 경우 중괄호 생략 불가
    ( ) -> {
      실행문;
      실행문;
    }

### 5-2. 매개변수가 있는 람다식

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

### 5-3. 리턴값이 있는 람다식

    (매개변수, ...) -> {
      실행문;
      retrun 값;
    }

    // return문 하나만 있을 땐 return 생략 가능, 리턴 값으로 연산식 혹은 리턴값이 있는 메소드로 호출을 대체할 수 있다.
    (매개변수, ...) -> 값
