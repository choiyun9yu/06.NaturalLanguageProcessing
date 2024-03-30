# Java Part2

## 1. 참조 타입

#### null 과 NullPointerException

참조 타입 변수는 아직 번지를 가지고 있지 않다는 뜻으로 null값을 가질 수 있다. null도 초기값으로 사용할 수 있기 때문에 null로 초기화된 참조 변수는 스택 영역에 생성된다.

NullPointerException은 참조 변수를 사용하면서 가장 많이 발생하는 예외 중 하나다. 변수가 null인 상태에서 객체의 데이터나 메소드를 사용하려할 때 발생한다. heap 영역에 생성된 객체가 어떤 변수도 참조하고 있지 않으면 쓰레기 객체가 되고, 이것은 Garbage Collector에 의해 제거된다.

### 1-1. 문자열(String)

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

### 1-2. 배열

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

### 1-3. 열거 타입(Enum Type)

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

## 2. 컬렉션(Collection)

배열은 같은 타입만 저장가능하고, 길이를 변경할 수 없다. 길이를 변경하기 위해서는 배열 복사해야한다.

컬렉션 자료 구조는 같은 타입만 저장가능하게 만들 수 있고, 다른 타입도 저장가능하게 만들 수 있다. 그러나 컬렉션 자료 구조는 길이가 고정되어 있지 않다. 그리고 자료 구조에 따라서 다양한 방법으로 자료를 저장할 수 있다(번지가 저장되는 것).

| 컬렉션 | 특징                                                | 구현클래스                                   |
| ------ | --------------------------------------------------- |-----------------------------------------|
| List   | 순서를 유지하고 저장, 중복 저장 가능                | ArrayList, Vector, LinkedList           |
| Set    | 순서를 유지하지 않고 저장, 중복 저장 불가           | HashSet, TreeSet                        |
| Map    | 키와 값으로 구성된 엔트리 저장, 키는 중복 저장 불가 | HashMap, HashTable, TreeMap, Properties |

### 2-1. List 컬렉션

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

### 2-2 Set 컬렉션

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

### 2-3. Map 컬렉션

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

### 2-4. 검색 기능을 강화시킨 컬렉션

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

### 2-5. LIFO와 FIFO 컬렉션

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

### 2-6. 동기화된 컬렉션

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

### 2-7. 수정할 수 없는 컬렉션

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

## 3. 자료구조

<br>
<br>

## 4. Java에서 파라미터 전달 방법
Java는 오로지 Call by Value로만 동작한다.

### 4-1. JVM 메모리에 변수가 저장되는 위치
Java에서 변수를 선언하면 Stack 영역에 할당된다. 기본형은 Stack 영역에 변수와 함께 저장된다.  
참조형은 객체는 Heap 영역에 저장되고, Stack 영역에 있는 변수는 Heap의 주소를 저장한다.
![img.png](../.img/img_0.png)

### 4-2. 기본 타입 전달
기본 타입은 Stack 영역에 위치한다. 메서드 호출 시 넘겨받는 파라미터들도 기본 타입이라면 Stack 영역에 생성된다.

    public calss PrimitiveTypeTest {
        @Test
        @DisplayName("Primitive Type 은 Stack 메모리에 저장되어서 변경해도 원본 변수에 영향이 없다.")
        void test() {
            int a = 1;
            int b = 2;

            // Befroe
            assertEquals(a, 1);
            assertEquals(b, 2);

            modify(a, b);

            // After: modify(a, b) 호출 후에도 값이 변하지 않음
            assertEquals(a, 1);
            assertEquals(b, 2);
        }

        private void modify(int a, int b) {
            // 여기 있는 파라미터 a, b는 이름만 같을 뿐 test() 에 있는 a, b와 다른 변수
            a = 5;
            b = 10;
        }
    }

![img_1.png](../.img/img_1.png)

Stack 내부에 test()와 modify()라는 영역이 나뉘어져 있고 거기에 동일한 이름을 가진 변수 a, b가 존재한다.

그래서 modify() 영역의 값을 바꿔도 test() 영역의 변수는 변화가 없다.

**즉, 기본 타입의 전달은 값만 전달하는 Call by Value로 동작한다.**

### 4-3. 참조 타입 전달
참조 타입은 기본 타입과 조금 다르다. 변수 자체는 Stack 영역에 생성되지만 실제 객체는 Heap 영역에 위치한다.

그리고 Stack에 있는 변수가 Heap 영역에 있는 객체의 주소값을 가지고 있는 형태다.

    class User {
        public int age;

        public User(int age) {
            this.age = age;
        }
    }

    public class ReferenceTypeTest {
        
        @Test
        @DisplayName("Reference Type 은 주소값을 넘겨 받아서 같은 객체를 바라본다" +
                     "그래서 변경하려면 원본 변수에도 영향이 있다.)
        void test() {
            User a = new User (10);
            User b = new User (20);

            // Before
            assertEquals(a.age, 10);
            assertEqulas(b.age, 20);

            modify(a, b);

            // After
            assertEquals(a.age, 11);
            assertEquals(b.age, 20);
        }
        
        private void modify(User a, User b) {
            // a, b와 이름이 같고 같은 객체를 바라본다.
            // 하지만 test 에 있는 변수와 확실히 다른 변수다.
        
            // modify 의 a와 test의 a는 같은 객체를 바라봐서 영향이 있다.
            a.age++;

            // b에 새로운 객체를 할당하면 가리키는 객체가 달라지고 원본에는 영향이 없다.
            b = new User(30);
            b.age++;
        }
    }

![img_2.png](../.img/img_2.png)  
![img_3.png](../.img/img_3.png)  
![img_4.png](../.img/img_4.png)   
![img_5.png](../.img/img_5.png)

### Conclusion

주소값을 넘기는 게 결국 Call by Reference 같지만

Call by Reference 는 참조 자체를 넘기기 때문에 새로운 객체를 할당하면 원본 변수도 영향을 받는다.

가장 큰 핵심은 호출자 변수와 수산지 파라미터는 Stack 영역 내에서 각각 존재하는 다른 변수라는 점이다.