# JAVA MIDDLE 1

#### 단축어
- soutm: 클래스명을 출력하는 코드 자동완성
- soutv: 변수명을 출력하는 코드 자동완성

#### 단축키 for linux
- Ctrl + p: 메소드에 전달할 수 있는 파라미터를 보여준다.
- Alt + Insert: 제너레이트(생성자, toString ...)
- Ctrl + d: 현재줄 아래줄에 복사
- Shift + F6: 소스코드창에서 rename

#### for mac
- Cmd + n: 제너레이트(생성자, toString ...)

#### Java 버전 선택 
- 애플 실리콘칩의 경우 java 버전 뒤에 aarch4 가 붙어 있는 버전을 선택하면 된다.

#### 다운로드 받은 소스코드 사용법 
> [File] - [New] - [Project from Existing Source...] - 프로젝트 루트 디렉토리 선택

## 1. Object 클래스
### 1-1. java-lang(Language) 패키지 소개
- 자바가 기본으로 제공하는 라이브러리(클래스 모음) 중에 가장 기본이 되는 패키지
- 쉽게 말해 자바 언어를 이루는 가장 기본이 되는 클래스들을 보관하는 패키지 
- java.lang 패키지는 모든 자바 애플리케이션에서 자동으로 임포트 되기 때문에 생략 가능하다.

#### java.lang 패키지의 대표적인 클래스들 
- Object: 모든 자바 객체의 부모 클래스
- String: 문자열 
- Integer, Long, Double: 래퍼 타입, 기본형 데이터 타입을 객체로 만드는 것  
- Class: 클래스 메타 정보 
- System: 시스템과 관련된 기보 기능들을 제공 

### 1-2. Object 클래스 
- 클래스를 만들 때 부모 클래스를 지정하지 않으면 묵시적으로 Object 클래스를 상속 받는다.
- **toString()** 메서드는 Object 클래스의 메서드이다.  
  클래스.toString() 을 입력하면 객체에 대한 정보를 출력해준다.

#### 자바에서 Object 클래스가 최상위 부모 클래스인 이유
1. 공통 기능 제공
   - 모든 객체에 필요한 기본적인 기능들을 객체를 만들 때마다 항상 새로 메서드를 만들어 정의하는 번거로움을 줄여준다.
   - 또한 막상 만든다고 해도 개발자마다 서로 다른 이름의 메서드를 만들어서 일관성이 없을 것이다. 
   
   **Object가 제공하는 기능은 다음과 같다.**
    - toString(): 객체의 정보 제공
    - equals(): 객체가 같은지 비교 
    - getClass(): 객체의 클래스 정보를 제공 
    - 기타 여러가지 기능 


2. 다형성의 기본 구현
   - 부모는 자식을 담을 수 있다. Object 는 모든 클래스의 부모 클래스이다. 따라서 모든 객체를 참조할 수 있다.
   - Object 클래스는 다형성을 지원하는 기본적인 매커니즘을 제공한다.
   - 모든 자바 객체는 Object 타입으로 처리될 수 있으며 이는 다양한 타입의 객체를 통합적으로 처리할 수 있게 해준다.
   - 쉽게 말해 Object 는 모든 객체를 다 담을 수 있다. 타입이 다른 객체들을 같이 보관해야할 때 Object 에 보관하면 된다.

### 1-3. Object 다형성 
- Object 는 모든 클래스의 부모 클래스이다. 따라서 Object 는 모든 객체를 참조할 수 있다.
######
    public class ObjectPolyExample1 {
   
        public static void main(String[] args) {
            Dog dog = new Dog();
            Car car = new Car();
    
            action(dog);
            action(car);
        }
    
        private static void action(Object obj) {
            // obj.sound();     // 컴파일 오류, Object 는  sound() 가 없다.
            // obj.move();      // 컴파일 오류, Object 는 move() 가 없다.
    
            // 객체에 맞는 다운 캐스팅이 필요
            if (obj instanceof Dog dog) {   // 이렇게 하면 자동으로 다운 캐스팅이 된다.
                dog.sound();
            } else if (obj instanceof Car car) {
                car.move();
            }
        } 
    }
- Object 는 모든 타입의 부모이다. 부모는 자식을 담을 수 있으므로 위 코드를 아래와 같이 변경할 수 있다.
######
    Object dog = new Dog();   // Dob -> Object
    Object car = new Car();   // Car -> Object

- Object 다형성의 장점: Object 는 모든 객체의 부모이기 때문에 어떤 객체든지 인자로 전달할 수 있다. 
- Object 다형성의 한계: Object 인자로 받은 후 함수에서 자식이 새로 정의한 메소드를 호출하면 컴파일 오류가 발생한다.
![img.png](img.png)
- 따라서 Object를 통해 전달받은 객체를 호출하려면 다운 캐스팅을 해야한다. 
![img_1.png](img_1.png)
- **!주의 새로 정의한 메소드는 컴파일 오류, 오버라이딩한 메소드는 오버라이딩 하는 메소드가 출력**

### 1-4. Object 배열
- Object 는 모든 타입의 객체를 담을 수 있기 때문에 Object[ ] 는  모든 객체를 담을 수 있는 배열이다.
![img_2.png](img_2.png)

       public static void main(String[] args) {
           Dog dog = new Dog();
           Car car = new Car();
           Object object = new Object();   // Object 인스턴스도 만들 수 있다.
   
           Object[] objects = {dog, car, object};
   
           size(objects);
       }

       private static void size(Object[] objects) {
           System.out.println("전달된 객체의 수는: " + objects.length);
       }
- size() 메서드는 메서드 배열에 담긴 객체의 수를 세는 역할을 한다.
- 이 메서드는 Object 타입만 사용한다. Object 타입의 배열은 세상의 모든 객체를 담을 수 있기 때문에  
  새로운 클래스가 추가되거나 변경되더라도 이 메서드를 수정하지 않아도 된다.  
  size() 는 자바를 사용하는 곳이라면 어디서든지 다 사용할 수 있다.

#### Object 가 없다면?
- void action(Object obj) 와 같이 모든 객체를 받을 수 있는 메서드를 만들 수 없다.
- Object[ ] objects 처럼 모든 객체를 젖아할 수 있는 배열을 만들 수 없다.

### 1-5. toString()
- Object.toSting() 메서드는 객체의 정보를 문자열 형태로 제공한다. 그래서 디버깅과 로깅에 유용하게 사용된다.
- 이 메서드는 Object 클래스에 정의되므로 모든 클래스에서 상속받아 사용할 수 있다.

      public static void main(String[] args) {
          Object object = new Object();
          String string = object.toString();
    
          // toString() 반환값 출력
          System.out.println(string);     // java.lang.Object@8efb846
    
          // object 직접 출력
          System.out.println(object);     // java.lang.Object@8efb846
      }

- Object 가 제공하는 toString() 메서드는 기본적으로 패키지를 포함한 객체의 이름과 객체의 참조값(해시코드)을 16진수로 제공한다.

#### println() 과 toString() 
- 그런데 toString() 의 결과를 출력한 코드와 object 를 println() 에 직접 출력한 코드의 결과가 완전히 같다.
- System.out.println() 메서드는 사실 내부에서 toString() 을 호출한다.

#### toString() 오버라이딩
- Object.toString() 메서드가 클래스 정보와 참조값을 제공하지만 이 정보만으로는 객체의 상태를 적절히 나타내지 못한다.
- 그래서 보통 toString()을 재정의(오버라이딩)해서 보다 유용한 정보를 제공하는 것이 일반적이다.


    public class ToStringMain2 {
    
        public static void main(String[] args) {
            Car car = new Car("Model Y");
            Dog dog1 = new Dog("멍멍이1", 2);
            Dog dog2 = new Dog("멍멍이2", 5);
    
            System.out.println("1. 단순 toString 호출");
            System.out.println(car.toString());
            System.out.println(dog1.toString());
            System.out.println(dog2.toString());
    
            System.out.println("2. println 내부에서 toString 호출");
            System.out.println(car);
            System.out.println(dog1);
            System.out.println(dog2);
    
            System.out.println("3. Object 다형성 활용");
            Objectprinter.print(car);
            Objectprinter.print(dog1);
            Objectprinter.print(dog2);
        }
    }
######
    public class Objectprinter {

        public static void print(Object obj) {
            String string = "객체 정보 출럭: " + obj.toString();
            System.out.println(string);
        }
    }
- Car 인스턴스는 toString( ) 을 재정의 하지 않아 Object 가 제공하는 기본 toString( ) 메서드를 사용한다.
- Dog 인스턴스는 toString( ) 을 재정의 한 덕분에 객체의 상태를 명확하게 확인할 수 있다.
- 오버라이딩된 메서드가 항상 우선권을 가지기 때문에 Objectprinter.print 메소드가 Object 타입으로   
  인자를 받아도 오버라이딩된 toString( ) 이 실행된다.

#### 참고 - 객체의 참조값 직접 출력 
- toString() 은 기본적으로 객체의 참조값을 출력한다. 
- 그런데 toString() 이나 hashCode() 를 재정의하면 객체의 참조값을 출력할 수 없다.
- 재정의한 출력을 내보내기 때문이다.
- 이때 아래 코드를 사용하여 객체의 참조값을 출력할 수 있다. 

        String refValue = Integer.toHexString(System.identityHashVode(dog1));
        System.out.println("refValue = " + refValue);
        

### 1-6. Object 와 OCP
- 만약 Object 도 없고, Object 가 제공하는 toString( ) 도 없다면 공통의 부모가 없는 객체의 정보를 출력하기 어려울 것이다. 
- 각각의 클래스마다 별도의 객체 출력 정보를 제공하는 객체를 만들어야 하기 때문이다. 

        public class BadObjectPrinter {
            public static void print(Car car) {
                String string = "객체 정보 출력: " + car.carInfo();
                System.out.println(string);
            }

            public static void print(Dog dog) {
                String string = "객체 정보 출력: " + dog.dongInfo();
                System.out.println(string);
            }
        }
- 이후 출력해야할 구체적인 클래스가 10개로 늘어나면 구체적인 클래스에 맞춰 메서드도 10개로 늘어나야 한다.
- BadObjectPrinter 클래스가 구체적인 특정 클래스인 Car, Dog 를 사용하는 것을  
  BadObjectPrinter 클래스가 Car, Dog 에 의존한다고 표현한다.
- 앞서 만든 ObjectPrinter 클래스는 Car, Dog 같은 구체적은 클래스를 사용하는 것이 아니라 추상적인 Obejct 클래스를 사용한다.   
  이것은 ObjectPrinter 클래스가 Object 클래스에 의존한다고 표현한다.
- ObjectPrinter 는 구체적인 것이 아니라 추상적인 것에 의존한다.  

    ![img_3.png](img_3.png)

- ObjectPrinter 와 Object 를 사용하는 구조는 다형성을 매우 잘 활용하고 있다.
- 다형성을 잘 활용한다는 것은 다형적 참조와 메서드 오버라이딩을 적절하게 사용한다는 뜻이다.
  - 다형적 참조: print(Object obj), Object 타입을 매개변수로 사용해서 다형적 참조를 사용한다.
  - 메서드 오버라이딩: toString( ) 메서드를 오버라이딩 하고 있다.
  
#### OCP 원칙 
- Open: 새로운 클래스를 추가하고, toSTring( ) 을 오버라이딩해서 기능을 확장할 수 있다.
- Close: 새로운 클래스를 추가해도 Object toString( ) 을 사용하는 클라이언트 코드인 ObjectPrinter 는 변경하지 않아도 된다.
######
- 다형적 참조, 메서드 오버라이딩 그리고 클라이언트 코드가 구체적인 Car, Dog에 의존하는 것이 아니라 추상적인 Object 에 의존하면서 OCP 원칙을 지킬 수 있다. 
- 덕분에 새로운 클래스를 추가하고 toString( ) 메서드를 새롭게 오버라이딩해서 기능을 확장할 수 있다.
- 이러한 변화에도 불구하고 클라잉너트 코드인 ObjectPrinter 는 변경할 필요가 없다.

#### System.out.println( )
- 지금까지 설명한 ObjectPrinter.print( ) 는 사실 System.out.println( ) 의 작동 방식을 설명하기 위해 만든 것이다.
- System.out.println( ) 메서드도 Object 매개변수를 사용하고 내부에서 toString( ) 을 호출한다.
- 따라서 System.out.println( ) 를 사용하면서 세상의 모든 객체 정보를 편리하게 출력할 수 있다.

#### 참고 - 정적 의존관계 vs 동적 의존관계 
- 정적 의존관계는 컴파일 시간에 결정되며, 주로 클래스 간의 관계를 의미한다. 앞서 보여준 클래스 의존관계 그림이 정적 의존관계이다.  
  (ObjectPrinter 는 Object 에 의존한다. 와 같은 의존 관계)
- 쉽게 말해, 프로그램을 실행하지 않고, 클래스 내에서 사용하는 타입들만 보면 쉽게 의존 관계를 파악할 수 있다.
- 동적 의존관계는 프로그램을 실행하는 런타임에 확인할 수 있는 의존관계이다. 앞서 ObjectPrint.print(Object obj) 에 인자로 어떤 객체가 전달 될 지는 프로그램을 실행해봐야 알 수 있다.
- 어떤 경우에는 Car 인스턴스가 넘어오고, 어떤 경우에는 Dog 인스턴스가 넘어온다. 이렇게 런타임에 어떤 인스턴스를 사용하는지를 나타내는 것이 동적 의존관계이다.


### 1-7. equals() - 1. 동일성과 동등성 
- Java 는 두 객체가 같다는 표현을 2가지로 분리해서 제공한다.
  - 동일성(Identity): == 연산자를 사용해서 두 객체의 참조가 동일한 객체를 가리키고 있는지 확인 
  - 동등성(Equality): equals( ) 메서드를 사용해 두 객체가 논리적으로 동등한지 확인
- 동일성은 물리적으로 같은 메모리에 있는 객체인지 참조값을 확인하는 것이다. (물리적 기준)
- 동등성은 논리적으로 같은지 확인하는 것이다. (논리적 기준)


    // 물리적으로 다르지만 논리적으로 같은 객체
    User a = new User("id-100")     // 참조 x001
    User b = new User("id-100")     // 참조 x002

#### Object 가 기본으로 제공하는 equals( ) 는 == 을 사용한다.
    public boolean equals(Object obj) {
      return (this == obj);   // 넘어온 것과 object 로 받은 것을 비교 
    }  
- 동등성이라는 개념은 각각의 클래스마다 다르다. 
- 어떤 클래스는 주민등록번호를 기반으로 동등성을 처리할 수 있고, 어떤 클래스는 연락처를 기반으로 동등성을 처리할 수 있다.
- 따라서 동등성 비교를 사용하고 싶으면 equal( ) 메서드를 재정의해야한다. 그렇지 않으면 Object 는 동일성 비교를 기본제공 한다.


### 1-8. equals() - 2. 구현
#### 예제 - id(고객번호)가 같으면 논리적으로 같은 UserV2 클래스 정의 

    public class UserV2 {
        private String id;
    
        public UserV2(String id) {
            this.id = id;
        }
    
        @Override
        public boolean equals(Object obj) {
            UserV2 user = (UserV2) obj;      // 다운 캐스팅하지 않으면 Object 타입에는 id 필드가 없어서 비교할 수 없다.
            return this.id.equals(user.id);  // String 간의 비교는 == 이 아니라 equals( ) 써야한다.
        }
    }

#### 정확한 equals( ) 구현 
- 앞서 UserV2 에서 구현한 equals( ) 는 이해를 돕기 위해 매우 간단히 만든 버전이고, 실제로 정확하게 동작하려면 더 복잡하다.
- 정확한 equals( ) 메서드를 구현하는 것은 생각보다 쉽지 않다. 복잡한 룰이 많기 때문이다.
- IntelliJ 를 포함한 대부분의 IDE 는 정확한 equals( ) 코드를 자동으로 만들어 준다.
> Generate(Alt + Insert) -> equals n-hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserV2 userV2 = (UserV2) o;
        return Objects.equals(id, userV2.id);
    }

#### equals( ) 메서드를 구현할 때 지켜야 하는 규칙 
- 반사성(Reflexivity): 객체는 자기 자신과 동등해야 한다.
- 대칭성(Symmetry): 두 객체가 서로에 대해 동일하다고 판단하면, 이는 양방향으로 동일해야 한다.
- 추이성(Transitivity): 만약 한 객체가 두 번째 객체와 동일하고, 두 번째 객체가 세 번째 객체와 동일하다면, 첫 번째 객체는 세번째 객체와도 동일해야 한다.
- 일관성(Consistency): 두 객체의 상태가 변경되지 않는 한, equals( ) 메소드는 항상 동일한 값을 반환해야 한다.
- null 에 대한 비교: 모든 객체는 null 과 비교했을 때 false 를 반환해야 한다.  
- !주의 그러나 동일성 비교가 항상 필요한 것은 아니다. 필요한 경우에만 equals( ) 메소드를 재정의 하면 된다.

### 1-9. 문제와 풀이
#### 문제 - toString( ), equals( ) 구현하기
- 다음 코드와 실행 결과를 참고해서 Rectangle 클래스를 만들어라.
- Reactangle 클래스에 IDE 기능을 사용해서 toString(), equals() 메서드를 실행 결과에 맞도록 재정의 해라.
- rect1 과 recr2 는 넓이와 높이를 가진다. 넓이와 높이가 모두 같다면 동등성 비교에 성공해야 한다.


### 1-10. 정리 
#### Object 의 나머지 메서드 
- clone( ): 객체를 복사할 때 사용한다. 잘 사용하지 않으므로 다루지 않는다.
- hashCode( ): equals( ) 와 hasCode( ) 는 종종 함께 사용된다. hashCode( ) 는 컬렉션 프레임워크에서 설명한다.
- getClass( ): 뒤에 Class 에서 설명 
- notify( ), notifyAll( ), wait( ): 멀티쓰레드용 메서드이다. 멀티쓰레드에서 다룬다. 


<br>

## 2. 불변 객체
### 2-1. 기본형과 참조형의 공유
- 자바의 데이터 타입을 가장 크게 보면 기본형(Primitive Type)과 참조형(Reference Type)으로 나눌 수 있다.
  - 기본형: 하나의 값을 여러 변수에서 절대로 공유하지 않는다.
  - 참조형: 하나의 객체를 참조값을 통해 여러 변수에서 공유할 수 있다.

#### 기본형 예제
- 기본형 변수 a 와 b 는 절대로 하나의 값을 공유하지 않는다. b = a 라고 하면 **Java 는 항상 값을 복사해서 대입한다.** 
- 이 경우 a 에 있는 10 을 복사해서 b 에 대입한다. 따라서 a 의 10 과 b 의 10 은 다른 곳에 저장된 다른 값이다.

      public class PrimitiveMain {
      
          public static void main(String[] args) {
              // 기본형은 절대로 같은 값을 공유하지 않는다.
              int a = 10;
              int b = a;  // a -> b, 값 복사 후 대입
              System.out.println("a = " + a); // 10
              System.out.println("b = " + b); // 10
      
              b = 20;
              System.out.println("a = " + a); // 10
              System.out.println("b = " + b); // 20
      
          }
      }

#### 참조형 예제 
- 참조형 변수들은 같은 참조값을 통해 같은 인스턴스를 참조할 수 있다.
- b = a 라고 하면 a 에 있는 참조값 x001 을 복사해서 b 에 전달한다.

      public class RefMain1_1 {
      
          public static void main(String[] args) {
              // 참조형 변수는 하나의 인스턴스를 공유할 수 있다.
              Address a = new Address("서울");
              Address b = a;
              System.out.println("a = " + a); // 서울
              System.out.println("b = " + b); // 서울 
      
              b.setValue("부산");   
              System.out.println("a = " + a); // 부산
              System.out.println("b = " + b); // 부산 
          }
      }

- **!자바에서 모든 값 대입은 변수가 가지고 있는 값을 복사해서 전달한다.**  
  기본형 값을 가지고 있으면 값을 복사해서 전달하고, 주소인 참조 값을 가지고 있으면 주소를 복사해서 전달한다.


### 2-2. 공유 참조와 사이드 이펙트
- 사이드 이펙트(Side Effect)는 프로그래밍에서 어떤 계산이 주된 작업 외에 추가적인 부수 효과를 일으키는 것을 말한다.
- 앞에서 b 의 값을 부산으로 변경했지만 a 의 값 역시 부산으로 함께 변경되는 것 역시 부수 효과라고 할 수 있다.
- 프로그래밍에서 사이드 이펙트는 보통 부정적인 의미로 사용된다. 
- 사이드 이펙트로 인해 디버깅이 어려워지고 코드의 안정성이 저하될 수 있기 때문이다.

#### 사이드 이펙트 해결 방안 
- 생각해보면 문제의 해결방안은 아주 단순하다. 처음부터 a 와 b 가 서로 다른 인스턴스를 참조하면 된다.

      public class RefMain1_2 {

          public static void main(String[] args) {
              Address a = new Address("서울");
              Address b = new Address("서울");
              System.out.println("a = " + a); // 서울
              System.out.println("b = " + b); // 서울
        
              b.setValue("부산");
              System.out.println("a = " + a); // 서울
              System.out.println("b = " + b); // 부산
          }
      }

#### 그러나 여러 변수가 하나의 객체를 공유하는 것을 막을 방법은 없다.
- 객체의 공유가 반드시 필요할 때도 있찌만, 때로는 공유하는 것이 사이드 이펙트를 만드는 경우도 있다.
- 그러나 하나의 객체를 여러 변수가 공유하지 않도록 강제로 막을 수 있는 방법은 없다.
- Address 를 사용하는 개발자 입장에서 실수로 b = a 라고 해도 아무런 오류가 발생하지 않는다.


      Address a = new Address("서울");
      Address b = a;  // 참조값 대입을 막을 수 있는 방법이 없다.


### 2-3. 불변 객체 - 도입
- 지금까지 발생한 문제를 잘 생각해보면 공유하면 안되는 객체를 여러 변수에서 공유했기 때문에 발생한 문제이다.
- 하지만 앞서 살펴보았듯이 객체의 공유를 막을 수 있는 방법은 없다.
- 그런데 사이드 이펙트의 더 근본적인 원인을 고려해보면, 객체를 공유하는 것 자체는 문제가 아니다. 
- 객체를 공유한다고 바로 사이드 이펙트가 발생하지 않는다. 오히려 단순 공유 참조는 메모리를 절약할 수 있다.
- **문제의 직접적인 원인은 공유된 객체의 값을 변경한 것에 있다.**
- 따라서 공유된 객체의 값을 변경하지 못하게 설계했다면 이런 사이드 이펙트 자체가 발생하지 않을 것이다.

#### 불변 객체 도입
- 객체의 상태(객체 내부의 값, 필드, 멤버 변수)가 변하지 않는 객체를 불변 객체(Immutable Object)라고 한다.
- 앞에서 만든 Address 클래스를 불변 객체로 다시 만들면 아래와 같다.

  
      public class ImmutableAddress {

        private final String value;
    
        public ImmutableAddress(String value) {
            this.value = value;
        }
    
        public String getValue() {
            return value;
        }
    
        // 불변객체라서 setValue() 는 존재할 수 없다.
    
        @Override
        public String toString() {
            return "ImmutableAddress{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }
- 이 클래스는 생성자를 통해서만 값을 설정할 수 있고, 이후에는 값을 변경하는 것이 불가능하다.
- 불변 클래스를 만드는 방법은 아주 단순하다. 어떻게든 필드값을 변경할 수 없게 클래스를 설계하면 된다.
- 불변이라는 단순한 제약을 사용해서 사이드 이펙트라는 큰 문제를 막을 수 있다.

#### 가변 vs 불변 
- 하나를 바꿨을 때 다른 게 바뀌면 안되는 상황이라면 불변으로 만든다.
- 하나를 바꿨을 때 같이 바뀌어야 되는 상황이라면 가변으로 만든다.

### 2-4. 불변 객체 - 예제 

    public class MemberMainV2 {
    
        public static void main(String[] args) {
            ImmutableAddress address = new ImmutableAddress("서울");
            MemberV2 memberA = new MemberV2("회원A", address);
            MemberV2 memberB = new MemberV2("회원A", address);
    
            // 회원 A, 회원 B의 처음 주소는 모두 서울
            System.out.println("memberA: " + memberA);
            System.out.println("memberB: " + memberB);
    
            // 회원 B의 주소를 부산으로 변경 (B가 불변인게 아니라 B가 가진 address 가 불변인 것이다.)
            // memberB.getAddress().setValue("부산");
            memberB.setAddress(new ImmutableAddress("부산"));
            System.out.println("memberA: " + memberA);
            System.out.println("memberB: " + memberB);
        }
    }

### 2-5. 불변 객체 - 값 변경 
#### 가변 객체 값 변경 
    public class MutableObj {

        private int value;
    
        public MutableObj(int value) {
            this.value = value;
        }
    
        public void add (int addValue) {
            this.value = this.value + addValue;
        }
    
        public int getValue() {
            return this.value;
        }
    
        public void setValue(int value) {
            this.value = value;
        }
    }
######
    public class MutableMain {

        public static void main(String[] args) {
            MutableObj obj = new MutableObj(10);
            obj.add(20);
    
            // 계산 이후 기존 값은 사라짐
            System.out.println("obj = " + obj.getValue());
        }
    }
#### 불변 객체 값 변경 
    public class ImmutableObj {

        private final int value;
    
        public ImmutableObj(int value) {
            this.value = value;
        }
    
        public ImmutableObj add (int addValue) {
            int result = value + addValue;
            // value 값을 바꾸지 않고 바꿔야하는 상황이 오면 새로운 객체를 만들어서 반환한다.
            return new ImmutableObj(result);
        }
    
        public int getValue() {
            return value;
        }
    }
- 여기서 핵심은 add( ) 메서드이다.
- 불변 객체는 값을 변경하면 안된다! 그러면 이미 불변 객체가 아니기 때문이다.
- 하지만 여기서는 기존 값에 새로운 값을 더해야 한다.
- 불변 객체는 기존 값은 변경하지 않고 대신에 계산 결과를 바탕으로 새로운 객체를 만들어서 반환한다.
- 이렇게 하면 불변도 유지하면 새로운 결과도 만들 수 있다.
######
    public class ImmutableMain1 {

        public static void main(String[] args) {
            ImmutableObj obj1 = new ImmutableObj(10);
            ImmutableObj obj2 = obj1.add(20);
    
            // 계산 이후에도 기존 값과 신규 값 모두 확인 가능
            System.out.println("obj1 = " + obj1.getValue());
            System.out.println("obj2 = " + obj2.getValue());
        }
    }
- 불변 객체를 설계할 때 기존 값을 변경해야 하는 메서드가 필요할 수 있다. 
- 이때는 기존 객체의 값을 그대로 두고 대신에 변경된 결과를 새로운 객체에 담아서 반환하면 된다.
- 결과를 보면 기존 값이 그대로 유지되는 것을 확인할 수 있다.
- 불변 객체의 단점은 값이 바뀌면 계속 새로운 객체를 생성해야 한다는 것이다.
- 그래서 값이 계속 바뀌어야되는 상황이라면 가변 객체를 사용하는게 더 나은 선택일 수 있다.
 
### 2-6. 문제와 풀이


### 2-7. 정리
- 지금까지 왜 이렇게 불변 객체 이야기를 많이 했을까?
- 자바에서 가장 많이 사용되는 String 클래스가 바로 불변 객체이기 때문이다. 
- 뿐만 아니라 자바가 기본적으로 제공하는 Interger, LocalData 등 의 수많은 클래스가 불변으로 설계되어 있다.
- 따라서 불변 객체가 필요한 이유와 원리를 제대로 이해해야, 이런 기본 클래스들도 제대로 이해할 수 있다.

#### 모든 클래스를 불변으로 만드는 것은 아니다.
- 우리가 만드는 대부분의 클래스는 값을 변경할 수 있게 만들어진다. 
- 가변 클래스가 더 일반적이고, 불변 클래스는 값을 변경하면 안되는 특별한 경우에 만들어서 사용한다고 생각하면 된다.
- 때로는 같은 기능을 하는 클래스를 하나는 불변으로 하나는 가변으로 만드는 경우도 있다.

#### 클래스를 불변으로 설계하는 이유는 더 많다.
- 캐시 안정성
- 멀티 쓰레드 안정성
- 엔티티의 값 타입

<br>

## 3. String 클래스
### 3-1. String 클래스 -기본
    public class CharArrayMain {
    
        public static void main(String[] args) {
            // char 는 문자 하나만 다룰 수 있다.
            char a = '가';
            System.out.println(a);
    
            // 문자 여러개를 다루기 위해서는 char[] 배열을 사용해야 한다.
            char[] charArr = new char[]{'h', 'e', 'l', 'l', 'o'};
            System.out.println(charArr);
    
            // String 을 사용하면 편하다.
            String str = "hello";
            System.out.println(str);
        }
    }
#### String 을 사용해서 문자열 만드는 2가지 방법 
    public class StringBasicMain {
        // 데이터 타입  int, double, boolean 등은 소문자로 시작하며 기본형 데이터 타입이다.
        // 그러나 대문자로 시작하는 데이터 타입들은 객체 즉, 참조형 데이터 타입이다.
        
        public static void main(String[] args) {
            // 방법1. 쌍따옴표 사용 
            String str1 = "hello";
            // 방법2. 객체 생성 
            String str2 = new String("hello");
    
            System.out.println("str1: " + str1);
            System.out.println("str2: " + str2);
        }
    }

#### String 클래스 구조 

    public final class String {
      
      // 문자열 보관 
      private final char[] value; // 자바 9 이전 
      private final byte[] value; // 자바 9 이후 

      // 여러 메서드
      public String contact(String str) {...}
      public int length() {...}
      ...

    }

#### String 클래스와 참조형
- String은 클래스이다. 따라서 기본형이 아니라 참조형이다. 
- 참조형은 변수에 계산할 수 있는 값이 들어있는 것이 아니라 x001 과 같이 계산할 수 없는 주소 값이 들어있다.
- 따라서 원칙적으로 + 와 같은 연산을 사용할 수 없다.
- 원래 자바에서 문자열을 더할 때는 String 이 제공하는 concat( ) 과 같은 메서드를 사용해야 한다.
- 하지만 문자열은 너무 자주 다루어지기 때문에 자바 언어에서 편의상 특별히 + 연산을 제공한다.


### 3-2. String 클래스 - 비교
- String 클래스 비교를 비교할 때는 == 비교가 아니라 항상 equals( ) 비교를 해야한다.
  - 동일성(Identity): == 연산자를 사용해서 두 객체의 참조가 동일한 객체를 가리키고 있는지 확인 
  - 동등성(Equality): equals( ) 메서드를 사용하여 두 객체가 논리적으로 같은지 확인
- Object 의 equals( ) 비교는 == 비교가 default 이지만, String 객체에서 오버라이딩을 해두었다.


    public class StringEqualsMain1 {
    
        public static void main(String[] args) {
            String str1 = new String("hello");
            String str2 = new String("hello");
            System.out.println("str1 == str2: " + (str1 == str2));            // false
            System.out.println("str1.equals(str2): " + str1.equals(str2));    // true
    
            String str3 = "hello";
            String str4 = "hello";
            System.out.println("리터럴 == 비교: " + str3 == str4);               // true
            System.out.println("리터럴 equals( ) 비교: " + str3.equals(str4));   // true
    
        }
    }

![img_4.png](img_4.png)  
- str1 과 str2 는 new String( ) 을 사용해서 각각 인스턴스를 생성했다. 서로 다른 인스턴스이므로 동일성비교(==)는 실패한다.
- 그러나 둘은 내부에 같은 "hello" 값을 가지고 있기 때문에 논리적으로 같다 따라서 동등성 비교(equals( )) 비교는 성공한다.  

![img_5.png](img_5.png)
- str3 과 str4 는 문자열 리터럴을 사용하여 생성하였다. 이런 경우 자바에서 자동으로 new String("hello"); 로 String 객체를 생성한다.
- 또한 문자열 리터럴을 사용하여 생성하는 경우 자바는 메모리 효율성과 성능 최적화를 위해 문자열 풀을 사용한다.
- 자바가 실행되는 시점에 클래스에 문자열 리터럴이 있으면 문자열 풀에 String 인스턴스를 미리 만들어 둔다. 이때 같은 문자열이 있으면 만들지 않는다.
- 문자열 풀 덕분에 같은 문자를 사용하는 경우 메모리 사용량을 줄이고 문자를 만드는 시간도 줄어들기 때문에 성능 최적화 할 수 있다.
- 따라서 str3 과 str4 는 같은 객체를 참조하고 있기 때문에 동일성(==) 비교에서 true 를 반환한다.
- 그럼에도 String 객체를 비교할 때는 항상 equals( ) 비교를 해야한다. 
  

    public class StringEqualsMain2 {
  
        public static void main(String[] args) {
            String str1 = new String("hello");
            String str2 = new String("hello");
            System.out.println("메서드 호출 비교1: " + isSame(str1, str2));    // false
  
            String str3 = "hello";
            String str4 = "hello";
            System.out.println("메서드 호출 비교1: " + isSame(str3, str4));    // true
  
        }
  
        private static boolean isSame(String x, String y) {
            return x == y;
        }
    }
- isSame 메서드를 만드는 개발자 입장에서는 x, y 값으로 리터럴 문자열이 들어올지, new 로 생성한 문자열이 들어올지 알 수 없기 때문이다.

    
#### Pool 이란?
- 프로그래밍에서 풀은 공용 자원을 모아둔 곳을 의미한다. 여러곳에서 함께 사용할 수 있는 객체를 필요할 때 마다 생성하고, 제거하는 것은 비효율 적이다.
- 대신에 이렇게 풀에 필요한 인스턴스를 미리 만들어 두고 여러곳에서 재사용할 수 있다면 성능과 메모리를더 최적화 할 수 있다.
- 참고로 문자열 풀은 힙 영역을 사용한다. 그리고 문자열 풀에서 문자를 찾을 때는 해시 알고리즘을 사용하기 때문에 매운 빠른 속도로 원하는 String 인스턴스를 찾을 수 있다.


### 3-3. String 클래스 - 불변 객체
- String 은 불변 객체이다. 따라서 생성 이후에 절대로 내부의 문자열 값을 변경할 수 없다.
- 따라서 수정 변경을 가한 결과를 return 으로 받아야 한다.

  
    public class StringImmutable1 {
    
        public static void main(String[] args) {
            String str1 = "hello";
            str.concat(" java");
            System.out.println(str);    // hello 출력 

            String str2 = "hello";
            String result = str.concat(" java");
            System.out.println(result);    // hello java 출력 
        }
    }

#### String 이 불변으로 설계된 이유
- 문자열 풀에 있는 String 인스턴스의 값이 중간에 변경되면 같은 문자열을 참고하는 다른 변수도 함께 변경되기 때문이다.


### 3-4. String 클래스 - 주요 메서드
- String 클래스는 문자열을 편리하게 다루기 위한 다양한 메서드를 제공한다. 여기서는 자주 사용되는 기능 위주로 나열한다.  
  (기능이 너무 많기 때문에 메서드를 외우기 보다는 주로 사용하는 메서드가 이런 것이구나 대략 알아두고 필요할 때 검색하거나 API 문서를 통해 원하는 기능을 찾는 것이 좋다.)

#### 문자열 정보 조회
- length(): 문자열의 길이를 반환한다.
- isEmpty(): 문자열이 비어있는지 확인한다. (길이가 0)
- isBlank(): 문자열이 비어있는지 확인한다. (길이가 0이거나 공백(Whitespace)만 있는 경우), Java 11
- charAt(int index): 지정된 인덱스에 있는 문자를 반환한다.

#### 문자열 비교
- equals(Object anObject): 두 문자열이 동등한지 비교한다.
- equalsIgnoreCase(String anotherString): 두 문자열을 대소문자 구분 없이 비교한다.
- compareTo(String anotherSTring): 두 문자열을 사전 순으로 비교한다.
- compareToIgnoreCase(String str): 두 문자열을 대소문자 구분 없이 사전적으로 비교한다.
- startsWith(String prefix): 문자열이 특정 접두사로 시작하는지 확인한다.
- endsWith(String suffix): 문자열이 특정 접미사로 끝나는지 확인한다.

#### 문자열 검색 
- contains(CharSequence s): 문자열이 특정 문자열을 포함하고 있는지 확인한다.
- indexOf(String ch) / indexOf(String ch, int fromIndex): 문자열이 처음 등장하는 위치를 반환한다.
- lastIndexOf(String ch): 문자열이 마지막으로 등장하는 위치를 반환한다. 

#### 문자열 조작 및 변환 -> 모두 반환 값을 받아서 사용해야 한다.
- substring(int beginIndex) / substring(int beginIndex, int endIndex): 문자열의 부분 문자열을 반환한다.
- concat(String str): 문자열의 끝에 다른 문자열을 붙인다.
- replace(CharSequence target, CharSequence replacement): 특정 문자열을 새 문자열로 대체한다.
- replaceAll(String regex, String replacement): 문자열에서 정규 표현식과 일치하는 부분을 새 문자열로 대체한다.
- replaceFist(String regex, String replacement): 문자열에서 정규 표현식과 일치하는 첫 번째 부분을 새 문자열로 대체한다.
- toLowerCase() / toUpperCase(): 문자열을 소문자나 대문자로 변환한다.
- trim(): 문자열 양쪽 끝의 공백을 제거한다. 단순 Whitespace 만 제거할 수 있다.
- strip(): Whitespace 와 유니코드 공백을 포함해서 제거한다. Java 11

#### 문자열 분할 및 조합
- split(String regex): 문자열을 정규 표현식 기준으로 분할한다.
- join(CharSequence delimiter, CharSequence... elements): 주어진 구분자로 여러 문자열을 결합한다.

#### 기타 유틸리티 
- valueOf(Object obj): 다양한 타입을 문자열로 변환한다.
- toCharArray(): 문자열을 문자 배열로 변환한다.
- format(String format, Object ... args): 형식 문자열과 인자를 사용하여 새로운 문자열을 생성한다.
- matches(String regex): 문자열이 주어진 정규 표현식과 일치하는지 확인한다.

    
    // format 메서드 
    int num = 100;
    boolean = bool = true;
    String str = "Hello, Java!";
    str.format("num: %d, bool: %b, str: %s", num, bool, str)

    >> num: 100, bool: true, str: Hello, Java!

#### 문자 + x 
- Java 에서 문자열에 다른 데이터 타입을 더하면 문자열이 된다.


### 3-6. String 클래스 - 가변 String 
#### 불변인 String 클래스의 단점 
- 불변인 String 의 내부 값은 변경할 수 없다. 따라서 변경된 값을 기반으로 새로운 String 객체를 생성한다.
- 예를 들어 "A" + "B" + "C" + "D" 라는 작업을 한다고 가정해보자. "ABCD" 라는 String 객체를 얻기 위해 "AB", "ABC" 를 거쳐서 "ABCD" 를 얻게 된다.
- 문제는 중간에 만들어진 "AB" 와 "ABC" 는  사용되지 않고 GC 의 대상이 된다.
- 즉, 불변인 String 클래스의 단점은 문자를 더하거나 변경할 때마다 계속 새로운 객체를 생성해야 한다는 것이다.
- 결과적으로 컴퓨터의 CPU, 메모리 자원을 더 많이 사용하게 되고 문자열의 크기가 크고 더 자주 변경될 수록 시스템의 자원을 더 많이 소모한다. 
> !참고 실제로는 문자열을 다룰 때 자바가 내부에서 최적화를 적용하는데, 이 부분은 뒤에서 다룬다.

#### StringBuilder
- 위의 문제를 해결하는 방법은 단순하다. 가변 String이 존재하면 된다. 이를 위해 Java 는 StringBuilder 라는 가변 String 을 제공한다.   
  (물론 가변의 경우 사이드 이펙트에 주의해서 사용해야 한다.)
- StringBuilder 는 내부에 final 이 아닌 변경할 수 있는 byte[ ] 를 가지고 있다.

      public final class StringBuilder {
          byte[] value;

          // 여러 메서드
          public StringBuilder append(String str) {...}
          public int length() {...}
          ...
      }
######
- StringBuilder 사용 예: 문자열 변경이 있을 때 사용하다가 변경이 끝나면 다시 String 으로 바꿔준다.

      public class StringBuilderMain1_1{

          public static void main(String[] args) {
              StringBuilder sb = new StringBuilder();

              // append: 맨 뒤에 추가
              sb.append("A");
              sb.append("B");
              sb.append("C");
              sb.append("D");
              System.out.println("sb.append = " + sb);

              // insert: 특정 인덱스 위치에 추가
              sb.insert(4, "Java");
              System.out.println("sb.insert = " + sb);

              // delete: 부분 삭제
              sb.delete(4, 8);
              System.out.println("sb.delete = " + sb);

              // reverse: 역순 정렬
              sb.reverse();
              System.out.println("sb.reverse = " + sb);

              // StringBuilder -> String
              String string = sb.toString();
              System.out.println("sb.toString = " + string.getClass());
          }
      }


### 3-7. String 최적화
#### 문자열 리터럴 최적화 
- Java 컴파일러는 문자열 리터럴을 더하는 부분을 자동으로 합쳐준다.
- 따라서 런타임에 별도의 문자열 결합 연산을 수행하지 않기 때문에 성능이 향상된다.

      // 컴파일 전
      String hellowWorld = "Hello, " + "World!"; 
  
      // 컴파일 후
      String helloWorld = "Hello, World!";

#### String 변수 최적화
- 문자열 변수의 경우 그 안에 어떤 값이 들어 있는지 컴파일 시점에서는 알 수 없기 때문에 단순하게 합칠 수 없다.
- 이런 경우 다음과 같이 최적화를 수행한다. (최적화 방식은 자바 버전에 따라 달라진다.)
  
      String result = str1 + str2;

      String result = new StringBuilder().append(str1).append(str2).toString();
  > !참고 - Java 9 부터는 StringConcatFactory 를 사용해서 최적화를 수행한다.

- 이렇듯 Java 가 최적화 처리를 해주기 때문에 지금처럼 간단한 경우에는 StringBuilder 를 사용하지 않아도 된다.
- 대신에 문자열 더하기 연산(+)을 사용하면 충분하다.

#### String 최적화가 어려운 경우 
- 문자열을 루프안에서 더하는 경우에는 최적화가 이루어지지지 않는다.   
  반복문의 루프 내부에서는 최적화가 되는 것 처럼 보이지만 반복 횟수만큼 객체를 생성해야한다. 
- 반복문 내에서의 문자열 연결은 런타임에 연결할 문자열의 개수와 내용이 결정된다.  
  이런 경우, 컴파일러는 얼마나 많은 반복이 일어날지, 각 반복에서 문자열이 어떻게 변할지 예측할 수 없다. 
- StringBuilder 는 물론이고 반복횟수 만큼의 String 객체를 생성했을 것이다. 이런 상황에서는 컴파일러가 최적화하기 어렵다.
    
      // 컴파일 전 
      public class LoopStringMain {
  
          public static void main(String[] args) {
              long startTime = System.currentTimeMillis();
      
              String result = "";
              for (int i = 0; i < 100000; i++) {
                  result += "Hello Java";
              }
      
              long endTime = System.currentTimeMillis();
      
              System.out.println("time = " + (endTime - startTime) + "ms");   // 2.5초
          }
      }
  
      // 컴파일 후 
            ...
              String result = "";
              for (int i = 0; i < 100000; i++) {
                result = new StringBuilder().append(result).append("Hello Java ").toString();
              }

######
- 이런 경우 우리가 직접 StringBuilder 사용하여 최적화하는 것이 좋다.  
  아래와 같이 Builder 를 반복문 밖에 정의 함으로 어느정도 해결할 수 있다.  
  (성능 700 ~ 800배 개선)

      public class LoopStringBuilderMain {
  
          public static void main(String[] args) {
              long startTime = System.currentTimeMillis();
      
              StringBuilder sb = new StringBuilder();
              for (int i = 0; i < 100000; i++) {
                  sb.append("Hello Java");
              }
      
              long endTime = System.currentTimeMillis();
      
              System.out.println("time = " + (endTime - startTime) + "ms");   // 0.003초
          }
      }

#### StringBuilder 정리
- 문자열을 합칠 때 대부분의 경우 최적화가 되므로 + 연산을 사용하면 된다.
- 그럼에도 StringBuilder 를 직접 사용하면 더 좋은 경우
  - 반복문에서 반복해서 문자를 연결할 때 (몇 십번은 그냥 써도 되는데 몇 백번 돌면 builder 사용)
  - 조건문을 통해 동적으로 문자열을 조합할 때
  - 복잡한 문자열의 특정 부분을 변경해야 할 때
  - 매우 긴 대용량 문자열을 다룰 때

> ! 참고 - StringBuilder vs StringBuffer
> - StringBuilder 와 똑같은 기능을 수행하는 StringBuffer 클래스도 있다.
> - StringBuffer 는 내부에 동기화가 되어 있어서, 멀티 스레드 상황에 안전하지만 동기화 오버헤드로 인해 성능이 느리다.
> - StringBuilder 는 멀티 쓰레드 상황에서 안전하지 않지만 동기화 오버헤드가 없으므로 속도가 빠르다.


### 3-8. 메서드 체인닝 - Method Chaining
    public class ValueAdder {
    
        private int value;
    
        public ValueAdder add(int addValue) {
            value += addValue;
            return this;    // 자기 자신을 반환
        }
    
        public int getValue() {
            return value;
        }
    
    }
- 단순히 값을 누적해서 더하는 기능을 제공하는 클래스다.
- add( ) 메서드를 호출할 때 마다 내부의 value 에 값을 누적한다.
- add( ) 메서드를 보면 자기자신(this)의 참조값을 반환한다. 이 부분에 유의하자!
######
    public class MethodChainingMain1 {
    
        public static void main(String[] args) {
            ValueAdder adder = new ValueAdder();
            adder.add(1);
            adder.add(2);
            adder.add(3);
    
            int result = adder.getValue();
            System.out.println("result = " + result);
        }
    }
- add() 메서드를 여러번 호출해서 누적합을 구한다. 여기서는 add() 메서드의 반환값은 사용하지 않았다. 
- 그럼 add() 메서드의 반환 값을 사용하면 어떻게 될까?
######
    public class MethodChainingMain2 {
    
        public static void main(String[] args) {
            ValueAdder adder = new ValueAdder();
            ValueAdder adder1 = adder.add(1);
            ValueAdder adder2 = adder1.add(2);
            ValueAdder adder3 = adder2.add(3);
    
            int result = adder3.getValue();
            System.out.println("result = " + result);
    
            System.out.println("adder1 = " + adder1);
            System.out.println("adder2 = " + adder2);
            System.out.println("adder3 = " + adder3);
        }
    }

    /* 출력 결과
     * result = 6
     * adder1 = lang.immutable.string.chaining.ValueAdder@23fc625e
     * adder2 = lang.immutable.string.chaining.ValueAdder@23fc625e
     * adder3 = lang.immutable.string.chaining.ValueAdder@23fc625e
     */
- 실행 결과는 기존과 같지만, 자기 자신을 반환하기 때문에 같은 참조값을 가지고 있다.
![img_6.png](img_6.png)  
![img_7.png](img_7.png)  
- add( ) 메서드는 자기 자신(this)의 참조값을 반환한다. 이 반환 값을 adder1, adder2, adder3에 보관 했다.
- 따라서 adder, adder1, adder2, adder3 는 모두 같은 참조값을 사용한다.
- 그런데 이 방식은 처음 방식보다 더 불편하고 코드도 잘 읽히지 않는다.
######
    public class MethodChainingMain3 {
    
        public static void main(String[] args) {
            ValueAdder adder = new ValueAdder();
            int result = adder.add(1).add(2).add(3).getValue();
            System.out.println("result = " + result);
        }
    }
- add( ) 메서드가 자기 자신을 반환하기 때문에 체인 처럼 메서드를 연결해서 호출할 수 있다.
- 반환된 참조값을 변수에 담아두지 않아도 된다. 
- 대신 반환된 참조값을 즉시 사용해서 바로 메서드를 호출할 수 있다.
- 메서드 체이닝 기법은 코드를 간결하고 읽기 쉽게 만들어준다.

> !다음과 같은 순서로 실행 (참조값을 x001 이라고 가정)  
> adder.add(1).add(2).add(3).getValue()  
> x001.add(2).add(3).getValue()  
> x001.add(3).getValue()  
> x001.getValue()  

#### StringBuilder 와 메서드 체인 
- StringBuilder 는 메서드 체이닝 기법을 제공한다.
- StringBuilder 의 append() 메서드를 보면 자기 자신의 참조값을 반환한다.
- StringBuilder 에서 문자열을 변경하는 대부분의 메서드도 메서드 체이닝 기법을 제공하기 위해 자기 자신을 반환한다.  
  예: insert( ), delete( ), reverse( )

      public StringBuilder append(String str) {
        super.append(str);
        return this;
      }

#### 정리
- 만드는 사람이 수고스러우면 쓰는 사람이 편하고, 만드는 사람이 편하면 쓰는 사람이 수고롭다.
- 메서드 체이닝은 구현하는 입장에서는 번거롭지만 사용하는 개발자는 편리해진다.
- 참고로 자바의 라이브러리와 오픈 소소들은 메서드 체이닝 방식을 종종 사용한다.


### 3-9. 문제와 풀이 1


### 3-10. 문제와 풀이 2

### 정리
- 문자열 비교에서는 equals( ) 를 사용한다.
- 문자열은 불변객체이기 때문에 concat( ) 같은 메소드 사용 시 반환값을 받아서 사용한다.
- StringBuilder 는 가변 String 이다. 변경이 끝나면 다시 String 으로 바꾼다.
- 자바 컴파일러가 String 최적화를 하기 때문에 StringBuilder 를 사용할 일이 별로 없다.  
- 그러나 반복문, 조건문에서 동적으로 문자열 조합, 매우 긴 문자열 다룰 땐 StringBuilder 를 사용한다.
- 메서드 체이닝은 자기 자신의 값을 반환하기 때문에 연결해서 쭉 쓸 수 있다.

<br>

## 4. Wrapper Class
### 4-1. 래퍼 클래스 - 기본형의 한계1
- 자바는 객체 지향 언어이다. 그러나 int, double 같은 기본형(Primitive Type) 은 객체가 아니다.
- 기본형은 객체가 아니기 때문에 다음과 같은 한계가 있다.
- 객체 아님: 기본형 데이터는 객체가 아니기 때문에, 객체 지향 프로그래밍의 장점을 살릴 수 없다.  
  예를 들어 객체는 유용한 메서드를 제공할 수 있는데, 기본형은 객체가 아니므로 메서드를 제공할 수 없다.
- null 값을 가질 수 없음: 기본형 데이터 타입은 null 값을 가질 수 없다. 그리고 제네릭도 사용할 수 없다.

      /* 
       * 기본형의 한계를 이해하기 위해, 두 값을 비교해서 다음과 같은 결과를 출력하는 코드를 작성해보자.
       * 왼쪽 값이 더 크다 1
       * 두 값이 같다 0
       * 왼쪽 값이 더 작다 -1
       */
  
      public class MyIntegerMethodMain0 {
          public static void main(String[] args) {
              int value = 10;
              int i1 = compareTo(value, 5);
              int i2 = compareTo(value, 10);
              int i3 = compareTo(value, 20);
            
              System.out.println("i1 = " + i1);
              System.out.println("i2 = " + i2);
              System.out.println("i3 = " + i3);
        
          }
        
          public static int compareTo(int value, int target) {
              if (value < target) {
                  return -1;
              } else if (value > target) {
                  return 1;
              } else {
                  return 0;
              }
          }
      }

- 여기서는 value 와 비교 대상 값을 compareTo( ) 라는 외부 메서드를 사용해서 비교한다.
- 그런데 자기 자신인 value 와 다른 값을 연산하는 것이기 때문에 항상 자기 자신의 값인 value 가 사용된다.
- 만약 value 가 객체라면 value 스스로 자기 자신의 값과 다른 값을 비교하는 메서드를 만드는 것이 더 유용하다.
    
#### 직접 만든 래퍼 클래스
- int 를 클래스로 만들어보자, int 는 클래스가 아니지만, int 값을 가지고 클래스를 만들면 된다.
- 다음 코드는 마치 int 를 클래스로 감싸서 만드는 것 처럼 보인다.
- 이렇게 특정 기본형을 감싸서(Wrap) 만드는 클래스를 래퍼 클래스(Wrapper class)라고 한다.

      public class MyInteger {
          private final int value;
      
          public MyInteger(int value) {
              this.value = value;
          }
      
          public int getValue() {
              return value;
          }
      
          public int compareTo(int target) {
              if (value < target) {
                  return -1;
              } else if (value > target) {
                  return 1;
              } else {
                  return 0;
              }
          }
        
          @Override
          public String toString() {
              return String.valueOf(value);
          }
      }

      public class MyIntegerMain1 {
          public static void main(String[] args) {
              MyInteger myInteger = new MyInteger(10);
            
                  int i1 = myInteger.compareTo(5);
                  int i2 = myInteger.compareTo(10);
                  int i3 = myInteger.compareTo(20);
          
                  System.out.println("i1 = " + i1);
                  System.out.println("i2 = " + i2);
                  System.out.println("i3 = " + i3);
          }
      }
- myInteger.compareTo( ) 는 자기 자산의 값을 외부의 값과 비교한다.
- MyInteger 는 객체이므로 자기 자신이 가진 메서드를 편리하게 호출할 수 있다.

### 4-2. 래퍼 클래스 - 기본형의 한계2
- 기본형은 항상 값을 가져야한다. 선언만 해도 해당 타입의 default 값이 들어 있다.
- 하지만 때로는 데이터가 '없음'이라는 상태가 필요할 수 있다.

      public class MyIntegerNullMain0 {

          public static void main(String[] args) {
              int[] intArr = {-1, 0, 1, 2, 3};
              System.out.println(findValue(intArr, -1));    // -1
              System.out.println(findValue(intArr, 0));     // 0
              System.out.println(findValue(intArr, 1));     // 1
              System.out.println(findValue(intArr, 100));   // -1
          }
            
          public static int findValue(int[] intArr, int target){
              for (int value : intArr) {
                  if (value == target) {
                    return value;
                  }
              }
              return -1;  // 반환 타입이 int  이기 때문에 뭐라도 반환해야한다. 이런 경우 실패인 경우 -1 이나 0 을 반환한다.
          }
      }
- findValue( )는 배열에 찾는 값이 있으면 해당 값을 반환하고, 없으면 -1 을 반환한다.
- findValue( )는 결과로 int 를 반환한다. int 와 같은 기본형은 항상 값이 있어야한다.  
  여기서도 값을 반환할 때 값을 찾지 못하면 숫자 중에 하나를 반환해야 하는데 보통 -1 또는 0 을 사용한다.
- 그런데 여기서 -1을 찾아도 -1을 반환하고 100을 못찾아도 -1을 반환한다.  
  못찾았다라는 것도 숫자로 반환해야하는 문제이다.
- 그러나 객체의 경우에는 null 을 반환할 수 있다.

      public class MyIntegerNullMain1 {
    
          public static void main(String[] args) {
              MyInteger[] intArr = {new MyInteger(-1), new MyInteger(0), new MyInteger(1), new MyInteger(2), new MyInteger(3)};
              System.out.println(findValue(intArr, -1));
              System.out.println(findValue(intArr, 0));
              System.out.println(findValue(intArr, 1));
              System.out.println(findValue(intArr, 100));
          }
            
          public static MyInteger findValue(MyInteger[] intArr, int target){
              for (MyInteger myInteger : intArr) {
                  if (myInteger.getValue() == target) {
                      return myInteger;
                  }
              }
              return null;
          }
      }
- 물론 null 값을 반환하는 경우 잘못하면 NullPointException 이 발생할 수 있기 때문에 주의해서 사용해야 한다.  
  (null 에 . 을 찍으면 발생)

### 4-3. 래퍼 클래스 - 자바 래퍼 클래스 
- 자바는 기본형에 대응하는 래퍼클래스를 기본적으로 제공한다.
  - byte -> Byte
  - short -> Short
  - int -> Integer
  - long -> Long
  - float -> Float
  - double -> Double
  - char -> Character
  - boolean -> Boolean
- 그리고 자바가 제공하는 기본 래퍼 클래스는 다음과 같은 특징을 가지고 있다.
  - 불변이다.
  - equals( ) 로 비교해야한다.

#### 래퍼 클래스 생성 - 박싱(Boxing)
- 기본형을 래퍼 클래스로 변경하는 것을 마치 박스에 물건을 넣은 것 같다고 해서 박싱이라고 한다.
- new Integer(10) 은 직접 사용하면 안된다. 작동은 하지만, 향후 자바에서 제거될 예정이다.
- 대신에 Integer.valueOf(10) 을 사용하면 된다.
- 추가로 Integer.valueOf( )에는 성능 최적화 기능이 있다.  
  개발자들이 일반적으로 자주 사용햐는 -128 ~ 127 범위의 Integer 클래스를 미리 생성해준다.
- **inValue( ) - 언박싱**: 래퍼 클래스에 들어있는 기본형 값을 다시 꺼내는 메서드이다.
- **equals( ) - 비교**: 래퍼 클래스 내부 값을 비교하는 메서드 이다.

      public class WrapperClassMain {
      
          public static void main(String[] args) {
              Integer newInteger = new Integer(10);   // 미래에 삭제 예정, 대신에 valueOf() 사용, -128 ~ 127 는 자바가 미리 만들어 둬서 new 로 새로 만들지 말 것을 권장
              Integer integerObj = Integer.valueOf(10);   // Integer integerObj = 10; 과 같음,
              Long longObj = Long.valueOf(100);
              Double doubleOjb = Double.valueOf(10.5);
      
              System.out.println("newInteger = " + newInteger.toString());    // toString() 이 기본적으로 오버라이딩 되어 있음
              System.out.println("integerObj = " + integerObj);
              System.out.println("longObj = " + longObj);
              System.out.println("doubleOjb = " + doubleOjb);
      
              System.out.println("내부 값 읽기");
              int intValue = integerObj.intValue();
              System.out.println("intValue = " + intValue);
              long longValue = longObj.longValue();
              System.out.println("longValue = " + longValue);
      
              System.out.println("비교");
              System.out.println("==: " + (newInteger == integerObj));    // false, 참조값이 달라서 false, 미리 만들어 둔 valueOf 로 만드 경우 참조값이 같아서 true
              System.out.println("equals( ): " + (newInteger.equals(integerObj)));    // true
          }
      }


### 4-4. 래퍼 클래스 - 오토 박싱
- 오토 박싱(Auto Boxing): 자바에서 int 를 Integer 로 변환하거나 Integer 를 int 로 변환할 때,
  valueOf( ) 와 intValue( ) 메서드를 사용하면 된다.
  - 박싱: valueOf( )
  - 언박싱: xxxValue( )
- 개발자들이 오랜기간 개발을 하다 보니 기본형을 래퍼 클래스로 변환하거나 또는 래퍼 클래스를 기본형으로 변환하는 일이 자주 발생 했다.
- 자바는 이런 문제를 해결하기 위해 Java 5 부터 오토 박싱과 오토 언박싱을 지원한다.  
  즉, 컴파일러가 개발자 대신 valueOf( ), xxxValue( ) 등의 코드를 추가해주는 것이다.

#### 오토 박싱 & 오토 언박싱
    public class AutoboxingMain2 {
    
        public static void main(String[] args) {
            // Auto-boxing
            int value = 7;
            Integer boxedVlaue = value;
    
            // Auto-unboxing
            int unboxedVlaue = boxedVlaue;
    
            System.out.println("boxedVlaue = " + boxedVlaue);
            System.out.println("unboxedVlaue = " + unboxedVlaue);
        }
    }


### 4-5. 주요 메서드와 성능 
    public class WrapperUtilsMain {
    
        public static void main(String[] args) {
            // 변환
            Integer i1 = Integer.valueOf(10);       // 숫자, 래퍼 객체 변환
            Integer i2 = Integer.valueOf("10");     // 문자열, 래퍼 객체 변환
            int intValue = Integer.parseInt("10");  // 문자열 전용, 기본형 변환
    
            // 비교
            int compareResult = i1.compareTo(20);   // i1 이 20 에 비해 더 작으니까 -1 반환
            System.out.println("compareResult = " + compareResult);
    
            // 산술 연산
            System.out.println("sum: " + Integer.sum(10, 20));
            System.out.println("min: " + Integer.min(10, 20));
            System.out.println("max: " + Integer.max(10, 20));
        }
    }
- valueOf( ): 래퍼 타입을 반환한다. 숫자, 문자열 모두 지원한다.
- parseInt( ): 문자열을 기본형으로 변환한다.
- compateTo( ): 내 값과 인수로 넘어온 값을 비교한다. 내 값이 크면 1, 같으면 0, 내 값이 작으면 -1을 반환한다.
- Integer.sum( ), Integer.min( ), Integer.max( ): static 메서드이다. 간단한 덧셈, 최소값, 최대값 연산을 수행한다.

#### parseInt( ) vs valueOf( )
- valueOf("10") 은 래퍼 타입을 반환한다.
- parseInt("10") 은 기본형을 반환한다. Long.parseLong( ) 처럼 parseXxx( ) 가 존재한다.

#### 래퍼 클래스와 성능 
- 래퍼 클래스는 객체이기 때문에 기본형보다 다양한 기능을 제공한다.
- 그렇다면 더 좋은 래퍼 클래스만 제공하면 되지 기본형을 제공하는 이유는 기본형이 성능이 더 좋기 때문이다.

      public class WrapperVsPrimitive {
      
          public static void main(String[] args) {
              int iterations = 1_000_000_000; // 반복 횟수 설정 10억
              long startTime, endTime;
      
              // 기본형 long 사용
              long sumPrimitive = 0;
              startTime = System.currentTimeMillis();
              for (int i = 0; i < iterations; i++) {
                  sumPrimitive += i;
              }
              endTime = System.currentTimeMillis();
              System.out.println("sumPrimitive = " + sumPrimitive);
              System.out.println("기본 자료형 long 실행 시간: " + (endTime - startTime) + "ms");   // 227ms
      
              // 기본형 long 사용
              Long sumWrapper = 0L;
              startTime = System.currentTimeMillis();
              for (int i = 0; i < iterations; i++) {
                  sumWrapper += i;
              }
              endTime = System.currentTimeMillis();
              System.out.println("sumPrimitive = " + sumPrimitive);
              System.out.println("래퍼 자료형 long 실행 시간: " + (endTime - startTime) + "ms");   // 2978ms
      
          }
      }
- 기본형은 메모리에서 단순히 그 크기만큼의 공간을 차지한다. 예를 들어 int 는 보통 4byte 의 메모리를 사용한다.
- 래퍼 클래스의 인스턴스는 내부 필드로 가지고 있는 기본형의 값 뿐만 아니라 자바에서 객체 자체를 다루는데 필요한 객체 메타 데이터를 포함하므로 더 많은 메모리를 사용한다, 자바 버전과 시스템마다 다르지만 대략 8-16byte 의 메모리를 추가로 사용한다.
- CPU 연산을 아주 많이 수행하는 특수한 경우이거나, 수만-수십만 이상 연속해서 연산을 수행해야 하는 경우라면 기본형을 사용해서 최적화를 고려한다.
- 그렇지 않은 일반적인 경우라면 코드를 유지보수하기 더 나은 것을 선택하면 된다.

#### 유지보수 vs 최적화
- 유지보수와 최적화가 이율배반적이라면 유지보수하기 좋은 코드를 먼저 고민해야 한다.
- 특히 최신 컴퓨터는 매우 빠르기 때문에 메모리 상에서 발생하는 연산을 몇 번 줄인다고해도 실질적인 도움이 되지 않는 경우가 많다.
- 코드 변경 없이 성능 최적화를 하면 가장 좋겠지만, 성능 최적화는 대부분 단순함 보다는 복잡함을 요구하고, 더 많은 코드를 추가로 만들어야 한다.
- 이는 최적화를 위해 유지보수 해야하는 코드가 더 늘어나는 것이다.
- 그런데 진짜 문제는 최적화를 한다고 했지만 전체 애플리케이션의 성능 관점에서 보면 불필요한 최적화를 할 가능성이 있다.
- 특히 웹 애플리케이션의 경우 메모리 안에서 발생하는 연산 하나보다 네트워크 호출 한 번이 많게는 수십만배 더 오래 걸린다.
- 자바 메모리 내부에서 발생하는 연산을 수천번에서 한 번으로 줄이는 것 보다, 네트워크 호출 한 번을 더 줄이는 것이 효과적이다.


### 4-6. Class 클래스 
- 자바에서 Class 클래스는 클래스의 정보(메타데이터)를 다루는데 사용된다.
- Class 클래스를 통해 실행 중인 자바 애플리케이션 내에서 필요한 클래스의 속성과 메소드에 대한 정보를 조회하고 조작할 수 있다.
  - **타입 정보 얻기**: 클래스의 이름, 슈퍼 클래스, 인터페이스, 접근 제한자 등과 같은 정보를 조회할 수 있다.
  - **리플렉션**: 클래스에 정의된 메소드, 필드, 생성자 등을 조회하고, 이들을 통해 객체 인스턴스를 생성하거나 메소드를 호출하는 등의 작업을 할 수 있다. 
  - **동적 로딩과 생성**: Class.forName( ) 메서드를 사용하여 클래스를 동적으로 로드하고, newInstance( ) 메서드를 통해 새로운 인스턴스를 생성할 수 있다.
  - **어노테이션 처리**: 클래스에 적용된 어노테이션을 조회하고 처리하는 기능을 제공한다.
- 예를 들어, String.class 는 String 클래스에 대한 Class 객체를 나타내며, 이를 통해 String 클래스에 대한 메타데이터를 조회하거나 조작할 수 있다.

      public class ClassMetaMain {

          // main( ) 옆에 throws Exception 이 추가된 부분에 주의하자. 이 코드가 없으면 컴파일 오류가 발생한다. 자세한 내용은 예외처리에서 학습한다.
          public static void main(String[] args) throws Exception {
              // Class 조회
              Class clazz = String.class; // 1. 클래스에서 조회
              // Class clazz1 = new String().getClass();   // 2. 인스턴스에서 조회
              // Class clazz2 = Class.forName("java.lang.String");   // 3. 문자열로 조회
              
              // 모든 필드 출력
              Field[] fields = clazz.getDeclaredFields();
              for (Field field : fields) {
                  System.out.println("field = " + field);
              }
      
              // 모든 메서드 출력
              Method[] declaredMethods = clazz.getDeclaredMethods();
              for (Method method : declaredMethods) {
                  System.out.println("method = " + method);
              }
      
              // 상위 클래스 정보 출력
              System.out.println("Superclass = " + clazz.getSuperclass());
      
              // 인터페이스 정보 출력
              Class[] interfaces = clazz.getInterfaces();
              for (Class i : interfaces) {
                  System.out.println("Interfaces = " + i);
              }
          }
      }

#### Class 클래스의 주요 기능
- getDeclaredFields( ): 클래스의 모든 필드를 조회한다.
- getDeclaredMethods( ): 클래스의 모든 메서드를 조회한다.
- getSuperclass( ): 클래스의 부모 클래스를 조회한다.
- getInterfaces( ): 클래스의 인터페이스들을 조회한다.

#### 클래스 생성하기
- Class 클래스에는 클래스의 모든 정보가 들어있다. 이 정보를 기반으로 인스터스를 생성하거나, 메서드를 호출하고, 필드의 값도 변경할 수 있다.

      public class Hello {
          public String hello() {
              return "Hello!";
          }
      }


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

- getDeclaredConstructor( ): 생성자를 선택한다.
- newInstance( ) 는 선택된 생성자를 기반으로 인스턴스를 생성한다.

#### 리플랙션 - reflection
- Class 를 사용하면 클래스의 메타 정보를 기반으로 클래스에 정의된 메소드, 필드, 생성자 등을 조회하고,  
  이들을 통해 객체 인스턴스를 생성하거나 메소드를 호출하는 작업을 할 수 있다.
- 이런 작업을 리플렉션이라 한다. 추가로 어노테이션 정보를 읽어서 특별한 기능을 수행할 수 도 있다.  
  최신 프레임워크들은 이런 기능을 적극 활용한다.
- 지금은 Class 가 뭔지, 그리고 대략 어떤 기능들을 제공하는지만 알아두면 충분하다.


### 4-7. System 클래스 


### 4-8. Math, Random 클래스


### 4-9. 문제와 풀이1


### 4-10. 문제와 풀이2


### 4-11. 정리 


<br>

## 5. 열거형 - ENUM
### 5-1. 문자열과 타입 안정성1


### 5-2. 문자열과 타입 안정성2


### 5-3. 타입 안전 열거형 패턴 


### 5-4. 열거형 - Enum Type


### 5-5. 열거형 - 주요 메서드 


### 5-6. 열거형- 리팩토링1


### 5-7. 열거형 - 리팩토링2


### 5-8. 열거형 - 리팩토링3


### 5-9. 문제와 풀이1


### 5-10. 문제와 풀이2


### 5-11. 정리 


<br>

## 6. 날짜와 시간
### 6-1. 날짜와 시간 라이브러리가 필요한 이유


### 6-2. 자바 날짜와 시간 라이브러리 소개


### 6-3. 기본 날짜와 시간 - LocalDateTime


### 6-4. 타임존 - ZonedDateTime


### 6-5. 기계 중심의 시간 - Instant


### 6-6. 기간, 시간의 간격 - Duration, Period


### 6-7. 날짜와 시간의 핵심 인터페이스


### 6-8. 날짜와 시간 조회하고 조작하기1


### 6-9. 날짜와 시간 조회하고 조작하기2


### 6-10. 날짜와 시간 문자열 파싱과 포맷팅


### 6-11. 문제와 풀이1


### 6-12. 문제와 풀이2


### 6-13. 정리 


<br>

## 7. 중첩 클래스, 내부 클래스 1
### 7-1. 중첩 클래스, 내부 클래스란?


### 7-2. 정적 중첩 클래스 


### 7-3. 정적 중첩 클래스의 활용 


### 7-4. 내부 클래스


### 7-5. 내부 클래스의 활용 


### 7-6. 같은 이름의 바깥 변수 접근 


<br>

## 8. 중첩 클래스, 내부 클래스 2
### 8-1. 지역 클래스 - 시작


### 8-2. 지역 클래스 - 지역 변수 캡처1


### 8-3. 지역 클래스 - 지역 변수 캡처2


### 8-4. 지역 클래스 - 지역 변수 캡처3


### 8-5. 익명 클래스 - 시작 


### 8-6. 익명 클래스 활용1


### 8-7. 익명 클래스 활용2


### 8-8. 익명 클래스 활용3


### 8-9. 문제와 풀이1


### 8-10. 문제와 풀이2


### 8-11. 정리 


<br>

## 9. 예외 처리 1 - 이론
### 9-1. 예외 처리가 필요한 이유1 - 시작


### 9-2. 예외 처리가 필요한 이유2 - 오류 상황 만들기


### 9-3. 예외 처리가 필요한 이유3 - 반환 값으로 예외 처리


### 9-4. 자바 예외 처리1 - 예외 계층 


### 9-5. 자바 예외 처리2 - 예외 기본 규칙 


### 9-6. 자바 예외 처리3 - 체크 예외


### 9-7. 자바 예외 처리4 - 언체크 예외


<br>

## 10. 예외 처리 2 - 실습 
### 10-1. 예외 처리 도입1 - 시작


### 10-2. 예외 처리 도입2 - 예외 복구 


### 10-3. 예외 처리 도입3 - 정상, 예외 흐름 분리 


### 10-4. 예외 처리 도입4 - 리소스 반환 문제 


### 10-5. 예외 처리 도입5 - finally


### 10-6. 예외 계층1 - 시작


### 10-7. 예외 계층2 - 활용 


### 10-8. 실무 예외 처리 방안1 - 설명 


### 10-9. 실무 예외 처리 방안2 - 구현 


### 10-10. try-with-resources


### 10-11. 정리 


<br>

## 다음으로