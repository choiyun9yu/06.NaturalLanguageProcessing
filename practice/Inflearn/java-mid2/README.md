# JAVA MIDDLE 2

### 단축키
- Shift + F6 : 리네임 단축키
- Ctrl + R : 한번에 제거 또는 바꾸기
- Ctrl + O : 오버라이딩할 메소드 목록

### Linux
- Ctrl + Alt + Shift + T : 인라인 베리어블

### MacOS
- ^T : 인라이 베리어블

![img.png](./img.png)
#### 자료구조의 이해
- 자바 컬렉션의 기능을 아는 것을 넘어 자료 구조 자체의 기본기를 다지고  
  실무에 필요한 자료 구조를 제대로 활용할 수 있게되는 것이 이 강의 목표이다.

## 1. 제네릭 - Generic1
### 1-1. 프로젝트 환경 구성 
- Eclipse Temurin 21


### 1-2 제네릭이 필요한 이유
- 대부분의 최신 프로그래밍 언어는 제네릭(Generic) 개념을 제공한다.
- 처음 제네릭을 접하는 경우 내용을 이해하기 쉽지 않을 수 있다. 제네릭이 왜 필요한지 지금부터 코드로 알아보자.

#### 
    public class IntegerBox {
    
        private Integer value;
    
        public void set(Integer value) {
            this.value = value;
        }
    
        public Integer get() {
            return value;
        }
    }
- IntegerBox 는 숫자를 보관하고 꺼낼 수 있는 단순한 기능을 제공한다.

#### 
    public class StringBox {
    
        private String value;
    
        public void set(String object) {
            this.value = object;
        }
    
        public String get(){
            return this.value;
        }
    }
- StringBox 는 문자열을 보관하고 꺼낼 수 있는 단순한 기능을 제공한다.

####
    public class BoxMain1 {
    
        public static void main(String[] args) {
            IntegerBox integerBox = new IntegerBox();
            integerBox.set(10); // 오토 박싱
            Integer integer = integerBox.get();
            System.out.println("integer = " + integer);
    
            StringBox stringBox = new StringBox();
            stringBox.set("hello");
            String string = stringBox.get();
            System.out.println("string = " + string);
        }
    }
- 코드를 보면 먼저 숫자를 보관하는 IntegerBox 를 생성하고, 숫자 10을 보관하고, 꺼낸다 음 출력했다.  
  (참고로 오토 박싱에 의해 int 가 Integer 로 자동 변환 된다.)
- 다음으로 문자열을 보관하는 StringBox 를 생성하고 그곳에 문자열 "hello" 를 보관하고, 꺼낸 다음 출력했다.

#### 문제
- 이후에 Double, Boolean 을 포함한 다양한 타입을 담는 박스가 필요하다면 각각의 타입별로 박스를 새로 만들어야 한다.
- 담는 타입이 수십개라면, 수십개의 XxxBox 클래스를 만들어야 한다. 이 문제를 어떻게 해결할 수 있을까?
- 타입 안정성은 높지만 코드 재사용성(다형성)이 떨어진다.

> !복습 - int 대신 integer 를 사용하는 이유  
> int 는 기본 자료형이라서 null 을 가질 수 없지만 integer 는 object 의 자식이라 가질 수 있다.

### 1-3. 다형성을 통한 중복 해결 시도 
- Object 는 모든 타입의 부모이다. 따라서 다형성(다형적 참조)를 사용해서 이 문제를 해결할 수 있을 것 같다.
####
    public class ObjectBox {
    
        private Object value;
        
        public void set(Object object) {
            this.value = object;
        }
        
        public Object get() {
            return value;
        }
    }
- 내부에 Object value 를 가지고 있다. Object 는 모든 타입의 부모이다.  
  부모는 자식을 담을 수 있으므로 세상의 모든 타입을 ObjectBox 에 보관할 수 있다.
####
    public class BoxMain2 {
    
        public static void main(String[] args) {
            ObjectBox integerBox = new ObjectBox();
            integerBox.set(10);
            Integer integer = (Integer) integerBox.get(); // 그대로 못받으니까 다운 캐스팅
            System.out.println("integer = " + integer);
    
            ObjectBox stringBox = new ObjectBox();
            stringBox.set("hello");
            String string = (String) stringBox.get();   // 그대로 못받으니까 다운 캐스팅
            System.out.println("string = " + string);
        }
    }

#### 문제 
    public class BoxMain2 {
    
        public static void main(String[] args) {
            ObjectBox integerBox = new ObjectBox();
            integerBox.set(10);
            // 반환 타입이 Object 라서 다운 캐스팅을 해줘야 한다.
            Integer integer = (Integer) integerBox.get(); // 다운 캐스팅
            System.out.println("integer = " + integer);
    
            ObjectBox stringBox = new ObjectBox();
            stringBox.set("hello");
            String string = (String) stringBox.get();   // 다운 캐스팅
            System.out.println("string = " + string);
    
            // 잘못된 타입의 인수 전달시 다운 캐스팅이 제대로 되지 않는다.
            // integerBox.set("문자100");
            // Integer result = (Integer) integerBox.get();
            // System.out.println("result = " + result);
        }
    }
- 반환 타입이 맞지 않는 문제: 반환 타입이 Object 라서 다운 캐스팅을 해줘야 한다.
- 잘못된 타입의 인수 전달 문제: 잘못된 타입의 인수 전달시 다운 캐스팅이 제대로 되지 않는다.
- 코드 재사용성(다형성)은 높아지지만 타입 안전성이 떨어진다.


### 1-4. 제네릭 적용
- 제네릭을 사용하면 코드 재사용과 타입 안정성이라는 두 마리 토끼를 한 번에 잡을 수 있다.
####
    public class GenericBox<T> {
        private T value;
    
        public void set(T value) {
            this.value = value;
        }
    
        public T get() {
            return value;
        }
    }
- <>를 사용한 클래스를 제네릭 클래스라고 한다. 이 기호를 보통 다이아몬드라고 한다.
- 제네릭 클래스를 사용할 때는 Integer, String 같은 타입을 미리 결정하지 않는다.
- 대신에 클래스명 오른쪽에 <T> 와 같이 선언하면 제네릭 클래스가 된다.  
  여기서 T를 **타입 매개변수**라 한다. 이 타입 매개변수는 이후에 Integer, String 으로 변환할 수 있다.
- 그리고 클래스 내부에 T 타입이 필요한 곳에 T value 와 같이 타입 매개 변수를 적어두면 된다.
####
    public class BoxMain3 {
    
        public static void main(String[] args) {
            GenericBox<Integer> integerBox = new GenericBox<Integer>(); // 생성 시점에 T의 타입 결정
            integerBox.set(10); // T의 타입을 integer 로 정의 했기 때문에 inter 만 입력 가능
            // integerBox.set("10");    // 타입 안정성 상승
            Integer integer = integerBox.get(); // 더불어 다운 캐스팅 할 필요 없음
            System.out.println("integer = " + integer);
    
            // 원하는 모든 타입 사용 가능
            GenericBox<Double> doubleBox = new GenericBox<Double>();
            doubleBox.set(10.5);
            Double doubleValue = doubleBox.get();
            System.out.println("doubleValue = " + doubleValue);
    
            // 타입 추론: 생성하는 제네릭 타입 생략 가능
            GenericBox<Integer> integerBox2 = new GenericBox<>();
        }
    }
- 제네릭 클래스는 생성하는 시점에 <> 사이에 원하는 타입을 지정한다.
- 이렇게 하면 앞서 정의한 GenericBox 의 T 가 다음과 같이 지정한 타입으로 변한 다음 생성된다.
- 즉 제네릭을 사용하면 재사용과 타입 안정성이라는 두마리 토끼를 모두 잡을 수 있다.

> !참고 - 제네릭을 도입한다고 해서 앞서 설명한 GenericBox<String>, Generic<Integer> 와 같은 코드가  
> 실제 만들어지는 것은 아니다. 대신에 자바 컴파일러가 우리가 입력한 타입 정보를 기반으로 이런 코드가 있다고  
> 가정하고 컴파일 과정에서 타입 정보를 반영한다. 이 과정에서 타입이 맞지 않으면 컴파일 오류가 발생한다.

#### 타입 추론 
    GenericBox<Integer> integerBox = new GenericBox<Integer>();   // 타입 직접 입력
    GenericBox<Integer> integerBox2 = new GenricBox<>();          // 타입 추론
- 첫 번째 줄의 코드를 보면 변수를 선언할 때와 객체를 생성할 때 <Integer> 가 두 번 나온다.
- 자바는 왼쪽에 있는 변수를 선언할 때의 <Integer> 를 보고 오른쪽에 있는 객체를 생성할 때 필요한 타입 정보를 얻을 수 있다.
- 따라서 두번째 줄의 오른쪽 코드 new GenericBox<>() 와 같이 타입 정보를 생략할 수 있다.  
  이렇게 자바가 스스로 타입 정보를 추론해서 개발자가 타입 정보를 생략할 수 있는 것을 타입 추론이라 한다.
    

### 1-5. 제네릭 용어와 관례
- 제네릭의 핵심은 사용할 타입을 미리 결정하지 않는다는 점이다. 클래스 내부에서 사용하는 타입을   
  클래스를 정의하는 시점에서 결정하는 것이 아니라 실제 사용하는 생성 시점에 타입을 결정하는 것이다.
- 이것을 쉽게 비유하자면 메서드의 매개변수와 인자의 관계와 유사하다.

#### 메서드에 필요한 값을 메서드 정의 시점에 미리 결정 
    void methoid1() {
      println("hello");
    }
- 메서드에 필요한 값을 이렇게 메서드 정의 시점에 미리 결정하게 되면,  
  이 메서드는 오직 "hello" 라는 값만 출력할 수 있어 재사용성이 떨어진다.

#### 메서드에 필요한 값을 인자를 통해 매개변수로 전달해서 결정 
    void method2(String param) {
      println(param);
    }

    void main() {
      method2("hello");
      method2("hi");
    }
- 메서드에 필요한 값을 메서드를 정의하는 시점에 미리 결정하는 것이 아니라, 메서드를 실제 사용하는 시점으로 미룰 수 있다.
- 메서드에 매개변수를 지정하고, 메서드를 사용할 때 원하는 값을 인자로 전달하면 된다.

#### 다양한 값을 처리하는 메서드
    // method2("hello") 호출 예 
    void method2(String param="hello") {
      println(param); 
    }

    // moethod2("hi") 호출 예
    void method2(String param="hi") {
      println(param); 
    }
- 매개 변수를 정의하고, 실행하는 시점에 인자를 통해 원하는 값을 매개변수에 전달했다.
- 이렇게 하면 이 메서드는 실행 시점에 얼마든지 다른 값을 받아서 처리할 수 있다. 따라서 재사용성이 크게 늘어난다.

#### 매서드의 매개변수와 인자 
    void method(String param) // 매개변수

    void main() {
      String arg = "hello";
      call(arg) // 인수 전달
    }
- 매개변수(Parameter): String param (메소드 안에 있는 것으로 어디선가 넘어오는 것)
- 인자, 인수(Arguemnt): arg (메소드 안에 넣어주는 것)


#### 제네릭의 타입 매개변수와 타입 인자
- 제네릭도 앞서 설명한 메서드의 매개변수와 인자의 관계와 비슷하게 작동한다.
- 제네릭 클래스를 정의할 때 내부에서 사용할 타입ㅇ르 미리 결정하는 것이 아니라,  
  해당 클래스를 실제로 사용하는 생성 시점에 내부에서 상요할 타입을 결정하는 것이다.
- 차이가 있다면 메서드의 매개변수는 사용할 값에 대한 결정을 나중으로 미루는 것이고,  
  제네릭의 타입 매개변수는 사용할 타입에 대한 결정을 나중으로 미루는 것이다.
- 정리하면 다음과 같다.
  - 메서드는 매개변수의 인자를 전달해서 사용할 값을 결정한다.
  - 제네릭 클래스는 타입 매개변수에 타입 인자를 전달해서 사용할 타입을 결정한다.
- 제네릭에서 사용하는 용어도 매개변수 인자의 용어를 그대로 가져다 사용한다.  
  다만 값이 아니라 타입을 결정하는 것이기 때문에 앞에 타입을 붙인다.
  - 타입 매개변수: GenericBox<T> 에서 T
  - 타입 인자:  
      GenericBox<Integer> 에서 Integer  
      GenericBox<String> 에서 String
- 제네릭 타입의 타입 매개변수 <T> 에 타입 인자를 전달해서 제네릭의 사용 타입을 결정한다.  

#### 용어 정리
- 제네릭(Generic) 
  - 제네릭이라는 단어는 일반적인, 범용적인이라는 영어 단어 뜻이다.
  - 풀어보면 특정 타입에 속한 것이 아니라 일반적으로, 범용적으로 사용할 수 있다는 뜻이다.
- 제네릭 타입(Generic Type) 
  - 클래스나 인터페이스를 정의할 때 타입 매개변수를 사용하는 것을 말한다.
  - 제네릭 클래스, 제네릭 인터페이스를 모두 합쳐서 제네릭 타입이라 한다.
    - 타입은 클래스, 인터페이스, 기본형(int 등)을 모두 합쳐서 부르는 말이다.  
      예: class GenericBox<T> { private T t; }  
      여기에서 GenericBox<T> 를 제네릭 타입이라 한다. 
- 타입 매개변수(Type Parameter)
  - 제네릭 타입이나 메서드에서 사요되는 변수로, 실제 타입으로 대체된다.
- 타입 인자(Type Argument)
  - 제네릭 타입을 사용할 때 제공되는 실제 타입니다.

#### 제네릭 명명 관례 
- 타입 매개변수는 일반적인 변수명처럼 소문자로 사용해도 문제는 없다.
- 하지만 일반적으로 대문자를 사용하고 용도에 맞는 단어의 첫글자를 사용하는 관례를 따른다.
- 주로 사용하는 키워드는 다음과 같다
  - E: Element
  - K: Key
  - N: Number
  - T: Type
  - V: Value
  - S,U,V etc.: 2nd, 3rd, 4th types

#### 제네릭 기타
- 다음과 같이 한 번에 여러 타입 매개변수를 선언할 수 있다.
        
      class Data<K, V> {}
- 타입 인자로 기본형(int, double ...)은 사용할 수 없다. 대신에 래퍼 클래스(Integer, Double ...) 을 사용하면 된다.

####  로 타입(row Type)
    public class RowTypeMain {
    
        public static void main(String[] args) {
            GenericBox integerBox = new GenericBox(); // 로 타입
            //  GenericBox<Object> integerBox = new GenericBox<>();  // 권장
            integerBox.set(10);
            Integer result = (Integer) integerBox.get();
            System.out.println("result = " + result);
        }
    }
- 제네릭 타입을 사용할 때는 항상 <> 를 사용해서 사용시점에 원하는 타입을 지정해야 한다.
- 그런데 다음과 같이 <>를 지정하지 않을 수 있는데, 이것을 로 타입(row type), 또는 원시 타입이라 한다.

      GenericBox integerBox = new GenericBox();
- 원시 타입을 사용하면 내부의 타입 매개변수가 Object 로 사용된다고 이해하면 된다.
- 제네릭 타입을 사용할 때는 항상 <> 를 사용해서 사용시점에 타입을 지정해야 한다.  
  그런데 왜 이런 로 타입을 지원하는 것일까?
- 자바의 제네릭이 자바가 처음 등장할 때 부터 있던것이 아니라 자바가 오랜기간 사용된 이후에 등장했기 때문에  
  제네릭이 없던 시절의 과거 코드와의 하위 호환 때문에 어쩔 수 없이 로 타입을 지원하게 되었다.


### 1-6. 제네릭 활용 예제 
![img_1.png](img_1.png)

    public class Animal {
        private String name;
        private int size;
    
        public Animal(String name, int size) {
            this.name = name;
            this.size = size;
        }
    
        public String getName() {
            return name;
        }
    
        public int getSize() {
            return size;
        }
    
        public void sound() {
            System.out.println("동물 울음 소리");
        }
    
        @Override
        public String toString() {
            return "Animal{" +
                    "name='" + name + '\'' +
                    ", size=" + size +
                    '}';
        }
    }

####
    public class Dog extends Animal {
    
    
        public Dog(String name, int size) {
            super(name, size);
        }
    
        @Override
        public void sound() {
            System.out.println("멍멍");
        }
    }

#### 
    public class Cat extends Animal {
    
        public Cat(String name, int size) {
            super(name, size);
        }
    
        @Override
        public void sound() {
            System.out.println("냐옹");
        }
    }

#### 
    public class Box<T> {
    
        private T value;
    
        public void set(T value) {
            this.value = value;
        }
    
        public T get() {
            return value;
        }
    }

#### 
    public class AnimalMain1 {
    
        public static void main(String[] args) {
            Animal animal = new Animal("동물", 0);
            Dog dog = new Dog("멍멍이", 100);
            Cat cat = new Cat("냐옹이", 50);
    
            Box<Dog> dogBox = new Box<>();
            dogBox.set(dog);
            Dog findDog = dogBox.get();
            System.out.println("findDog = " + findDog);
            
            Box<Cat> catBox = new Box<>();
            catBox.set(cat);
            Cat findCat = catBox.get();
            System.out.println("findCat = " + findCat);
    
            Box<Animal> animalBox = new Box<>();
            animalBox.set(animal);
            Animal findAnimal = animalBox.get();
            System.out.println("findAnimal = " + findAnimal);
        }
    }
- Box 제네릭 클래스에 각각의 타입에 맞는 동물을 보관하고 꺼낸다.
- Box<Dog> dogBox: Dog 타입을 보관할 수 있다.
- Box<Cat> catBox: Cat 타입을 보관할 수 있다.
- Box<Animal> animalBox: Animal 타입을 보관할 수 있다.

여기서 Box<Animal> 의 경우 타입 매개변수 T 에 타입 인자 Animal 을 대입하면 다음 코드와 같다.

    public class Box<Animal> {
    
        pirvate Animal value;
    
        public void set(Animal value) {
            this.value = value;
        }
    
        public Animal get() {
            return value;
        }
    }
- 따라서 set(Animal value) 이므로 set( )에 Animal 의 하위 타입인 Dog, Cat 도 전달할 수 있따.
- 물론 이 경우 꺼낼 때는 Animal 타입으로만 꺼낼 수 있다.
####
    public class AnimalMain2 {

        public static void main(String[] args) {
            Animal animal = new Animal("동물", 0);
            Dog dog = new Dog("멍멍이", 100);
            Cat cat = new Cat("냐옹이", 50);
    
            Box<Animal> animalBox = new Box<>();
            animalBox.set(animal);
            animalBox.set(dog);
            animalBox.set(cat);
    
            Animal findAnimal = animalBox.get();
            System.out.println("findAnimal = " + findAnimal);
        }
    }


<br>

## 2. 제네릭 - Generic2
### 2-1. 타입 매개변수 제한1 - 시작
- 요구사항: 개 병원은 개만 받을 수 있고, 고양이 병원은 고양이만 받을 수 있어야 한다.
####
    public class DogHospital {
    
        private Dog animal;
    
        public void set (Dog animal) {
            this.animal = animal;
        }
    
        public void checkup() {
            System.out.println("동물 이름: " + animal.getName());
            System.out.println("동물 크기: " + animal.getSize());
            animal.sound();
        }
    
        public Dog bigger(Dog target) {
            return animal.getSize() > target.getSize() ? animal : target;
        }
    }
- 개 병원 내부에 Dog 타입을 가진다.
- checkup( ): 개의 이름과 크기를 출력하고, 개의 sound( ) 메서드를 호출한다.

      

### 2-2. 타입 매개변수 제한2 - 다형성 시도


### 2-3. 타입 매개변수 제한3 - 제네릭 도입과 실패


### 2-4. 타입 매개변수 제한4 - 타입 매개변수 제한 


### 2-5. 제네릭 메서드


### 2-6. 제네릭 메서드 활용


### 2-7. 와일드카드1


### 2-8. 와일드카드2


### 2-9. 타입 이레이저


### 2-10. 문제와 풀이2


<br>

## 3. 컬렉션 프레임워크 - ArrayList
### 3-1. 배열의 특징1 - 배열과 인덱스


### 3-2. 빅오 표기법


### 3-3. 배열의 특징2 - 데이터 추가


### 3-4. 직접 구현하는 배열 리스트1 - 시작


### 3-5. 직접 구현하는 배열 리스트2 - 동적 배열 


### 3-6. 직접 구현하는 배열 리스트3 - 기능 추가 


### 3-7. 직접 구현하는 배열 리스트4 - 제네릭1


### 3-8. 직접 구현하는 배열 리스트5 - 제네릭2


<br>

## 4. 컬렉션 프레임워크 - LinkedList
### 4-1. 노드와 연결1


### 4-2. 노드와 연결2


### 4-3. 노드와 연결3


### 4-4. 직접 구현하는 연결 리스트1 - 시작


### 4-5. 직접 구현하는 연결 리스트2 - 추가와 삭제1


### 4-6. 직접 구현하는 연결 리스트3 - 추가와 삭제2


### 4-7. 직접 구현하는 연결 리스트4 - 제네릭 도입 


<br>

## 5. 컬렉션 프레임워크 - List
### 5-1. 리스트 추상화1 - 인터페이스 도입

### 5-2. 리스트 추상화2 - 의존관계 주입

### 5-3. 리스트 추상화3 - 컴파일 타임, 런타임 의존관계

### 5-4. 직접 구현한 리스트의 성능 비교 

### 5-5. 자바 리스트

### 5-6. 자바 리스트의 성능 비교 

### 5-7. 문제와 풀이1

### 5-8. 문제와 풀이2

<br>

## 6. 컬렉션 프레임워크 - Hash

### 6-1. 리스트 vs 세트 

### 6-2. 직접 구현하는 Set0 - 시작

### 6-3. 해시 알고리즘1 - 시작 

### 6-4. 해시 알고리즘2 - index 사용 

### 6-5. 해시 알고리즘3 - 메모리 낭비

### 6-6. 해시 알고리즘4 - 나머지 연산 

### 6-7. 해시 알고리즘5 - 해시 충돌 설명 

### 6-8. 해시 알고리즘6 - 해시 충돌 구현 

<br>

## 7. 컬렉션 프레임워크 - HashSet

### 7-1. 직접 구현하는 Set1 - MyHashSetV1

### 7-2. 문자열 해시 코드 

### 7-3. 자바의 hashCode()

### 7-4. 직접 구현하는 Set2 - MyHashSetV2

### 7-5. 직접 구현하는 Set3 - 직접 만든 객체 보관

### 7-6. equals, hashCode 의 중요성1 

### 7-7. equals, hashCode 의 중요성2

### 7-8. 직접 구현하는 Set4 - 제네릭과 인터페이스 도입

<br>

## 8. 컬렉션 프레임워크 - Set

### 8-1. 자바가 제공하는 Set1 - HashSet, LinkedHashSet

### 8-2. 자바가 제공하는 Set2 - TreeSet

### 8-3. 자바가 제공하는 Set3 - 예제 

### 8-4. 자바가 제공하는 Set4 - 최적화

### 8-5. 문제와 풀이1

### 8-6. 문제와 풀이2

<br>

## 9. 컬렉션 프레임워크 - Map, Stack, Queue

### 9-1. 컬렉션 프레임워크 - Map 소개1 

### 9-2. 컬렉션 프레임워크 - Map 소개2 

### 9-3. 컬렉션 프레임워크 - Map 구현체  

### 9-4. 스택 자료 구조 

### 9-5. 큐 자료 구조 

### 9-6. Deque 자료 구조

### 9-7. Deque 와 Stack, Queue

### 9-8. 문제와 풀이1 - Map1

### 9-9. 문제와 풀이2 - Map2

### 9-10. 문제와 풀이3 - Stack

### 9-11. 문제와 풀이4 - Queue

<br>

## 10. 컬렉션 프레임워크 - 순회, 정렬, 전체 정리

### 10-1. 순회1 - 직접 구현하는 Iterable, Iterator 

### 10-2. 순회2 - 향상된 for 문

### 10-3. 순회3 - 자바가 제공하는 Iterable, Iterator

### 10-4. 정렬1 - Comparable, Comparator

### 10-5. 정렬2 - Comparable, Comparator

### 10-6. 정렬3 - Comparable, Comparator

### 10-7. 컬렉션 유틸 

### 10-8. 컬렉션 프레임워크 전체 정리 

### 10-9. 문제와 풀이

<br>

## 11. 다음으로