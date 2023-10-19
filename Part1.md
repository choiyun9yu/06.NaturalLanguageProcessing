# JAVA Part1

### 자바 런타임 환경(JRE;Java Runtime Environment)
자바프로그램을 실행할 때 필요한 환경을 제공하는 프로그램이다. JRE에는 JVM, 클래스 라이브러리, 런타임 환경 등이 포함되어 있다. 런타임 환경은 소프트웨어가 실행되는 환경이다. 소프트웨어가 실행될 때 필요한 라이브러리, 런타임 시스템 데이터, 메모리 등이 모두 포함된 환경이다.

### 자바 개발 도구(JDK;Java Developmetn Kit)
자바 프로그램을 개발하기 위해 필요한 모든 도구와 라이브러리가 포함된 패키지이다. JDK에는 Java Compiler, JVM, 클래스 라이브러리, 디버깅 도구 등이 포함되어 있다.

### 자바 가상 머신(JVM;Java Virtual Machine)
자바 프로그램을 실행하기 위한 가상머신이다. JVM은 운영체제나 하드웨어와 상관없이 동일한 실행환경을 제공한다. Java는 JVM에 설치된 컴퓨터에서 실행되며, JVM은 자바 바이트 코드를 해당 운영체제에서 실행가능한 기계어로 변환하여 실행한다.

### 자바 컴파일 과정
① 소스코드를 작성하면 _파일명.java_로 저장   
② _javac 파일명.java_로 컴파일  
③ _파일명.class_라는 바이트 코드 파일 생성  
④ _java 파일명.java_로 자바 가상 머신이 바이트 코드 파일 실행  

### 패키지(Package)
자바는 소스 파일 및 컴파일된 바이트코드 파일을 쉽게 관리하기 위해 패키지를 사용한다. 패키지는 파일 시스템에서의 디렉토리와 비슷하다.

<br>
<br>

## 1. 자바 기본 타입(Java Primitive Type)
|타입|메모리 크기|저장되는 값의 허용 범위|
|---|--------|------------------|
|boolean |1byte(8bit)|ture, false|
|char    |2byte(16bit)|유니코드 문자|
|byte    |1byte(8bit)|-128 ~ 127|
|short   |2byte(16bit)|-32,768 ~ 32,767|
|int     |4byte(32bit)|-2,147,483,648 ~ 2,147,483,647|
|long    |8byte(64bit)|-2^63 ~ (2^63-1)|
|float   |4byte(32bit)|유효 소수 이하자리 7자리|
|double  |8byte(64bit)|유효 소수 이하자리 15자리|

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
    //char 타입의 경우 int 타입으로 자동 변환되면 유니코드 값이 int타입에 대입된다.
  
	char charValue = 'A';
	int intValue = charValue;       // 65가 저장됨

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
- **오버플로우** : 타입이 허용하는 최대값을 벗어나는 것
- **언더플로우** : 타입이 허용하는 최소값을 벗어나는 것

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

|형식|형식|설명|출력형태|
|--|----|--|----|
|정수|%d|정수|123|
|  |%6d|6자리정수.왼쪽 빈자리 공백|___123|
|  |%-6d|6자리정수.오른쪽 빈자리 공백|123___|
|  |%06d|6자리 정수.왼쪽 빈자리0채움|000123|
| 실수 |%10.2f|정수 7자리+소수점+소수2자리.왼쪽 빈자리 공백|____123.45|
|  |%-10.2f|정수 7자리+소수점+소수2자리.오른쪽 빈자리 공백|123.45____|
|  |%010.2f|정수 7자리+소수점+소수2자리.왼쪽 빈자리 0채움|0000123.45|
|문자열|%s|문자열|abc|
|  |%6s|6자리 문자열.왼쪽 빈자리 공백|___abc|
|  |%-6s|6자리 문자열. 오른쪽 빈자리 공백|abc___|
|특수문자|\t|탭(tab)||
|  |\n|개행||
|  |%%|%|%|

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
- 부호 연산자는 변수의 부호를 변경할 때 사용된다. 
- 증감연산자는 ++로 1씩 증가시키거나 --로 1씩 감소시킨다.
- --또한 감소하는 것을 제외하고는 같다.



### 5-2. 산술 연산자
> 종류 : +(더하기), -(빼기), *(곱하기), /(나누기), %(나머지)  

    short var1 = 1;
    int var2 = 2;
    int var3 = var1 + var2; // 더 큰 그릇으로

    int var4 = 12 / 0;     // 예외 에러 (ArithmeticException)
    int var5 = 12 % 0;     // 예외 에러 (ArithmeticException)
    
    float var6 = 12 / 0.0f;   // Infinity
    float var7 = 12 % 0.0f;    // NaN
- 피연산자 중 더 큰 그릇을 가진 자료형을 따라간다.
- 정확한 연산을 위해서는 정수를 사용하는 것이 좋다.  
  (부동소수점 연산은 정확한 값을 출력하지 못하는 경우가 존재한다.)
- 나눗셈, 나머지 연산에서 0으로 나눌 경우 예외(ArithmeticException)가 발생한다.  
  (무한대의 값을 정수로 표현할 수 없기 때문이다.)
- 하지만 0이 아닌 0.0이나 0.0f인 경우 예외가 발생하지않고 무한대(inf) or NaN이 된다.
- inf or NaN 값을 가지고 연산을 하면 안된다. 어떤 연산을 하더라도 결과는 계속 inf와 NaN이 되기 때문이다.

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
- 1순위 : 증감 연산자  
- 2순위 : 산술 연산자  
- 3순위 : 시프트 연산자  
- 4순위 : 비교 연산자  
- 5순위 : 비트 연산자(~만 1순위)  
- 6순위 : 논리 연산자(!만 1순위)  
- 7순위 : 조건(삼항) 연산자  
- 8순위 : 대입 연산자  

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

