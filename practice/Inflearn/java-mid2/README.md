# JAVA MIDDLE 2

### 단축키
- Shift + F6 : 리네임 단축키

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
- StromgBox 는 문자열을 보관하고 꺼낼 수 있는 단순한 기능을 제공한다.

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
            Integer integer = (Integer) integerBox.get(); // 다운 캐스팅
            System.out.println("integer = " + integer);
    
            ObjectBox stringBox = new ObjectBox();
            stringBox.set("hello");
            String string = (String) stringBox.get();   // 다운 캐스팅
            System.out.println("string = " + string);
        }
    }

#### 문제 
public class BoxMain2 {

    public static void main(String[] args) {
        ObjectBox integerBox = new ObjectBox();
        integerBox.set(10);
        Integer integer = (Integer) integerBox.get(); // 다운 캐스팅
        System.out.println("integer = " + integer);

        ObjectBox stringBox = new ObjectBox();
        stringBox.set("hello");
        String string = (String) stringBox.get();   // 다운 캐스팅
        System.out.println("string = " + string);

        // 잘못된 타입의 인수 전달시 
        integerBox.set("문자100");
    }
}

### 1-4. 제네릭 적용

### 1-5. 제네릭 용어와 관례

### 1-6. 제네릭 활용 예제 

### 1-7 문제와 풀이1

<br>

## 2. 제네릭 -Generic2

### 2-1. 타입 매개변수 제한1 - 시작

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