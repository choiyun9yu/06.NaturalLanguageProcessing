# 1. 데이터 입출력

입력 스트림과 출력 스트림은 독립적으로 작용한다. 
스트림은단방향으로 데이터가 흐르는 것을 말한다. 따라서 출발지에서 나와 도착지로 흘러가는 흐름이다.

- 입력 스트림
출발지 : 키보드, 파일, 프로그램
도착지 : 프로그램
- 출력 스트림
출발지 : 프로그램
도착지 : 모니터, 파일, 프로그램


어떤 데이터를 입추력하느냐에 따라 스트림은 두 종류로 구분할 수 있다.
- 바이트 스트림 : 그림, 멀티미디어, 문자 등 모든 종류의 데이터를 입출력할 때 사용
- 문자 스트림 : 문자만 입력할 때 사용
(프로그램 입장에서 문자일 뿐 실제 주고 받는 데이터는 모두 byte다.)

java.io 패키지는 바이트 스트림과 문자 스트림을 구분해서 제공한다.

|구분|바이트 스트림|문자 스트림|
|---|-----------|----------|
|최상위 클래스|InputStream, OutputStream|Reader, Writer|
|하위 클래스|XXXInputStream, XXXOutputStream|XXXReader, XXXWriter|
* 접미사만 보고도 바이트 스트림인자 문자 스트림인지 알 수 있다.

### (1) 바이트 출력 스트림

|리턴 타입|메소드|설명|
|--------|-----|---|
|void|write(int b)|1byte를 출력|
|void|write(byte[]b)|매개값으로 주어진 배열 b의 모든 바이트 출력|
|void|write(byte[]b, int off, int len)|매개값으로 주어진 배열b[off]부터 len개의 바이트 출력|
|void|flush()|출력 버퍼에 잔류하는 모든 바이트 출력|
|void|close()|출력 스트림을닫고 사용 메모리 해제|

>```java
package Part4;
>
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
>
public class ex01_WriteExample {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir");   // 현재 경로
        OutputStream os = null; // 선언을 위에 올려놔야 블럭단위 지역 변수를 try에서도 쓰고 finally 에서도 쓸 수 있음
        try {
            // 파일 열기
            os = new FileOutputStream(path + "\\ThisIsJava\\temp\\test1.db"); // 기존 파일 있으면 덮어쓰기
            os = new FileOutputStream(path + "\\ThisIsJava\\temp\\test1.db", ture); // 기존 파일에 추가하기
            os = new FileOutputStream(path + "\\ThisIsJava\\temp\\test1.db", false); // 기존 파일에 덮어쓰기
>
            // 저장할 데이터
            byte a = 10;
            byte b = 20;
            byte c = 30;
>
            // 1바이트 쓰기
            os.write(a);
            os.write(b);
            os.write(c);
>
            // 실제 출력
            os.flush();
>
            System.out.println("저장 성공");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close(); // close도 예외가 발생할 수 있어서 예외 처리 따로 해줘야한다.
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
```

#### 바이트 배열 출력

>```java
// FileOutputStream은 Autocloseable 기능을 지원하기 때문에 명시적으로 닫아주지 않아도 된다.
        try(OutputStream os = new FileOutputStream(path + "\\ThisIsJava\\temp\\test2.db")) {
            // 바이트 배열
            byte[] array = {10, 20, 30};
>
            os.write(array);
>
            os.flush();
>
            System.out.println("저장 성공");
        } catch (IOException e) {
            e.printStackTrace();
        }
```

#### 바이트 배열 부분 출력
>``` java
        try(OutputStream os = new FileOutputStream(path + "\\ThisIsJava\\temp\\test3.db")) {
            // 저장할 데이터 (바이트 배열)
            byte[] array = {10, 20, 30, 40, 50};
>
            // 일부분 출력 (1번 인덱스 부터 3번 인덱스 까지 출력)
            os.write(array, 1, 3);
>
            // 실제 출력
            os.flush();
>
            System.out.println("저장 성공");
        } catch (IOException e) {
            e.printStackTrace();
        }
```

### (2) 바이트 출력 스트림

|리턴 타입|메소드|설명|
|--------|-----|---|
|int|read()|1byte를 읽은 후 읽은 파이트 리턴|
|int|read(byte[]b)|읽은 바이트를 매개값으로 주어진 배열에 저장 후 읽은 바이트 수를 리턴|
|void|close()|입력 스트림을 닫고 사용 메모리 해제|

#### 1바이트 읽기
1줄 씩 읽다가 더 이상 읽을 값이 없을 때 read()를 호출하면 메소드는 -1을 리턴한다.
이것을 이용하면 읽을 수 있는 마지막 바이트까지 반복해서 한 바이트씩 읽을 수 있다.

>```java
InputSTream is = ...;
while (true) {
  int data = is.read();		// 1 바이트 읽고 리턴
  if (data == -1) break;	// -1을 리턴했을 경우 while문 종료
}
```

>```java
public class ex02_ReadExample {
          try (InputStream is = new FileInputStream(path + "\\ThisIsJava\\temp\\test1.db")) {
>
            while (true) {
                int data = is.read();
                if (data == -1) break;
                System.out.println(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
}
```

#### 바이트 배열 읽기
입력 스트림으로부터 주어진 데이터를 가지고 있는 배열의 길이만큼 읽고 배열에 저장한 다음 읽은 바이트 수를 리턴 한다. (주의! 읽은 값이 아니라 읽은 수를 리턴하는 것, 데이터는 배열에 저장)
아직 더 남아있다면 다스 가지고 있던 배열의 길이만큼 읽는다. 이때, 이전에 읽은 배열과 같은 배열이므로 새로 읽은 바이트가 가지고 있던 배열을 가득 채우지 못한 경우, 이전에 읽은 바이트가 남아 있을 수 있다. 따라서 실제 읽은 데이터만 출력하기 위해서는 리턴한 개수 만큼만 출력해야 한다.

>```java
InputStream is = ...;
byte[] data = new byte[100];
while (true) {
  int num = is.read(data);	// 최대 100byte를 읽고, 
  							// 읽은 바이트는 배열 data에 저장 
                            // 읽은 수 리턴
  if (num == -1) break;
}
```

>```java
        try (InputStream is = new FileInputStream(path + "\\ThisIsJava\\temp\\test1.db")) {
>
            // 한 번에 읽을 바이트 배열 크기
            byte[] data = new byte[100];
>
            while (true) {
                // 한 번에 읽은 바이트 수
                int num = is.read(data);
>
                // 더 이상 읽은 수 없으면 종료
                if (num == -1) break;
>
                // 읽은 만큼 출력
                for (int i = 0; i < num; i++) {
                    System.out.println(data[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
```

#### 복사 프로그램 만들기
모든 파일은 바이트로 읽고 바이트로 쓸 수 있다.

>```java
public class ex03_CopyExample {
    public static void main(String[] args) throws Exception{
        String originalFileName = "C:\\Users\\yun9y\\Documents\\내 문서\\Java\\ThisIsJava\\temp\\karina.jpg.jpg";
        String targetFileName = "C:\\Users\\yun9y\\Documents\\내 문서\\Java\\ThisIsJava\\temp\\copy.jpg.jpg";
>
        InputStream is = new FileInputStream(originalFileName);
        OutputStream os = new FileOutputStream(targetFileName);
>
//        byte[] data = new byte[1024];	// 원본에서 읽은 데이터 저장할 목적
//        while (true) {
//            int num = is.read(data);
//            if (num==-1) break;
//            os.write(data, 0, num);
//        }
>
//        Java 9 부터 입력 스트림에서 출력 스트림으로 복사하는 메소드 추가
        is.transferTo(os);
>
        os.flush();
        os.close();
        is.close();
>
        System.out.println("복사가 잘 되었습니다.");
    }
}
```

### (3) 문자 입출력 스트림
문자 입출력 스트림으로 Reader와 Writer가 있다. 입출력되는 단위가 문자인 것을 제외하고는 바이트 입출력 스트림과 사용 방법은 동일하다.

|리턴 타입|메소드|설명|
|--------|-----|---|
|void|write(int c)|매개값으로 주어진 한 문자를 출력|
|void|wirte(char[] cbuf)|매개값으로 주어진 배열의 모든 문자를 출력|
|void|wirte(char[] cbuf, int off, int len)|매개값으로 주어진 배열에서 cbuf[off]부터 len개까지의 문자 출력|
|void|wirte(String str)|매개값으로 주어진 문자열을 출력|
|void|wirte(STring str, int off, int len)|매개값으로 주어진 문자열에서 off 순번부터 len개까지의 문자를 출력|
|void|flush()|버퍼에 잔류하는 모든 문자를 출력|
|void|close()|출력 스트림을 닫고 사용 메모리를 해제|

#### 문자 출력
*char 타입은 정수타입이어서 int 매개값 제공 가능

>```java
public class ex04_strWriteExample {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        try {
            // 문자 기반 출력 스트림 생성
            Writer writer = new FileWriter(path + "\\ThisIsJava\\temp\\test4.db");
>
            // 한 문자씩 출력
            char a = 'A';
            writer.write(a);
>
            char b = 'B';
            writer.write(b);
>
            // char 배열 출력
            char[] arr = {'C', 'D', 'E'};
            writer.write(arr);
>
            // 문자열 출력
            writer.write("FGH");
>
            writer.flush();
            writer.close();
>
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
```

#### 문자 읽기

|리턴 타입|메소드|설명|
|-------|-----|----|
|int|read()|1개의 문자를 읽고 리턴|
|int|read(char[] cbuf)|읽은 문자들을 매개값으로 주어진 문자 배열에 저장하고 읽은 문자 수를 리턴|
|void|close()|입력 스트림을 닫고, 사용 메모리 해제|

>```java
public class ex05_strReadExample {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        Reader reader = null;
        try {
            // 한 문자씩 읽기
            reader = new FileReader(path + "\\ThisIsJava\\temp\\test4.db");
            while (true) {
                int data = reader.read();   // 한 문자를 읽음
                if (data == -1) break;
                System.out.print((char) data);   // 읽은 문자 출력
            }
            reader.close();
            System.out.println();
>
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
```

#### 문자 배열로 읽기

>```java
        try {
            reader = new FileReader(path + "\\ThisIsJava\\temp\\test4.db");
            char[] data = new char[100];
            while (true) {
                int num = reader.read(data);
                if (num == -1) break;
                for (int i = 0; i < num; i++) {
                    System.out.print(data[i]);
                }
            }
            reader.close();
>     
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
```

### (4) 보조 스트림
보조 스트림이란 다른 스트림과 연결되어 여러 가지 편리한 기능을 제공해주는 스트림이다. 

보조 스트림은 자체적으로 입출력을 수행할 수 없기 때문에 입출력 소스로부터 직접생성된 입출력스트림에 연결해서 사용해야한다.

주 스트림을 보조 스트림이 쓰고, 프로그램에서는 보조 스트림을 쓰는 구조

보조 스트림 쓰는 이유
- 보조 스트림을 붙이면 int값 double 값을 바로 쓸 수 있다.
- 보조 스트림을 붙이면 성능이 향상 된다.

입출력 스트림에 보조 스트림을 연결하려면 보조 스트림을 생성할 때 생성자 매개값으로 입출력 스트림을 제공하면 된다.

>```java
주스트림 변수명 = new 주스트림(); // 주스트림 생성
보조스트림 변수명 = new 보조스트림(주스트림);
// 프로그램에서는 보조스트림을 사용
```

- 바이트 입력스트림인 FileInputStream에 InputStreamReader 보조 스트림을 연결하기

>```java
InputStream is = new FileInputStream("...");
InputSTreamReader reader = new InputStreamReder(is);
```

! 보조 스트림은 또 다른 보조 스트림과 연결되어 스트림 체인을 구성할 수 있다.

- 문자 변환 보조 스트림인 InputStreamReader에 BufferedRaader 보조 스트림 연결하기

>```java
InputSream is = new FileStream("...");
InputSTreamReader  reader = new InputStreamReader( is );
BufferedReader br = new BufferedReader( reader );
```

#### 자주 사용되는 보조 스트림
|보조 스트림|기능|
|---------|----|
|InputStreamReader|바이트 스트림을 문자 스트림으로 변환|
|BufferedInputStream, BufferedOutputStream, BufferedReader, BufferedWriter|입출력 성능 향상|
|DataInputStream, DataOutputStream|기본 타입 데이터 입출력|
|PrintStream, PrintWriter|줄바꿈 처리 및 형식화된 문자열 출력|
|ObjectInputStream, ObjectOutputStream|객체 입출력|

#### 문자 변환 스트림
바이트 스트림에서 입출력할 데이터가 문자라면 문자 스트림으로 변환해서 사용하는 것이 좋다. 그 이유는 문자로 바로 입출력하는 편리함이 있고, 문자셋의 종류를 지정할 수 있기 때문이다.

- InputStream을 Reader로 변환

>```java
InputStream is = new FileInputSTream("파일경로");
Reader reader = new InputStreamReader(is);
```

##### ! FileReader의 원리 (FileWriter도 같다.)
FileInputSTream에 InputStreamReader를 연결하지 않고, FileReader를 직접 생성할 수 있다. FileReader는 InputStreamReader의 자식 클래스이다. 이것은 FileReader가 내부적으로 FileInputStream에 InputStreamReader 보조 스트림을 연결한 것이라고 볼 수 있다.

- OutputStream을 Writer로 변환

>```java
OutputStream os = new FileOutputStream("파일경로");
Writer writer = new OutputStreamWriter(os);
```

### (5) 성능 향상 스트림
CPU의 메모리가 뛰어나도 하드 디스크의 입출력이 느리면 프로그램의 실행 성능은 하드 디스크의 처리 속도에 맞춰 느려진다. 네트워크로 데이터를 전송할 때도 느린 네트워크 환경이라면 컴퓨터 사양이 아무리 좋아도 느릴 수 밖에 없다.

이 문제의 부분적인 해법은 프로그램이 입출력 소스와 직접 작업하지않고 중간에 메모리 버퍼와 작업함으로써 실행 성능을 향상시키는 것이다. 

'출력 스트림'의 경우 직접 하드 디스크에 데이터를 보내지 않고 메모리 버퍼에 데이터를 보냄으로써 출력 속도를 향상시킬 수 있다. 버퍼는 데이터가 쌓이기를 기다렸다가 꽉 차게 되면 데이터를 한꺼번에 하드 디스크로 보냄으로 써 출력 횟수를 줄여준다.

'입력 스트림'에서도 버퍼를 사용하면 읽기 성능이 좋아진다. 하드 디스크로부터 직접 읽는 것 보다는 메모리 버퍼로부터 읽는 것이 빠르기 때문이다.

>```java
BufferedInputStream bis = new BufferedInputStream(바이트 입력 스트림);
BufferedOutputStream bos = new BufferedOutputStream(바이트 출력 스트림);
>
BufferedReader br = new BufferedRader(문자 입력 스트림);
BufferedWriter bw = new BufferedWriter(문자 출력 스트림);
```

>```java
package Part4;
>
import java.io.*;
>
public class ex06_BufferExample {
    public static void main(String[] args) throws Exception {
        // 입출력 스트림 생성
        String originalFilePath1 =             
        "C:\\Users\\yun9y\\Documents\\내 문서\\Java\\out\\production\\Java\\Part4\\temp2\\karina.jpg";
        String targetFilePath1 =
        "C:\\Users\\yun9y\\Documents\\내 문서\\Java\\out\\production\\Java\\Part4\\temp2\\target.jpg";
>
        FileInputStream fis1 = new FileInputStream(originalFilePath1);
        FileOutputStream fos1 = new FileOutputStream(targetFilePath1);
>
        // 입출력 스트림 + 버퍼 스트림 생성
        String originalPath2 = "C:\\Users\\yun9y\\Documents\\내 문서\\Java\\out\\production\\Java\\Part4\\temp2\\karina.jpg";
        String targetFilePath2 = "C:\\Users\\yun9y\\Documents\\내 문서\\Java\\out\\production\\Java\\Part4\\temp2\\target2.jpg";
>
        FileInputStream fis2 = new FileInputStream(originalPath2);
        FileOutputStream fos2 = new FileOutputStream(targetFilePath2);
        BufferedInputStream bis = new BufferedInputStream(fis2);
        BufferedOutputStream bos = new BufferedOutputStream(fos2);
>
        // 버퍼를 사용하지 않고 복사
        long nonBufferTime = copy(fis1, fos1);
        System.out.println("버퍼 미사용:\t" + nonBufferTime + "ns");
>
        // 버퍼 사용하고 복사
        long bufferTime = copy(bis, bos);
        System.out.println("버퍼 사용:\t" + bufferTime + "ns");
>
        fis1.close();
        fos1.close();
        bis.close();
        bos.close();
    }
>
    public static long copy(InputStream is, OutputStream os) throws Exception {
        // 시작 시간 저장
        long start = System.nanoTime();
        // 1 바이트 읽고 1 바이트 출력
        while (true) {
            int data = is.read();
            if (data==-1) break;
            os.write(data);
        }
        os.flush();
        // 끝 시간 저장
        long end = System.nanoTime();
        // 복사 시간 리턴
        return (end - start);
    }
}
```


### (6) 기본타입 스트림
바이트 스트림에 DataInputStream과 DataOutputStream 보조 스트림을 연결하면 기본 타입인 boolean, char, short, int, long, float, double 값을 입출력할 수 있다. 

>```java
DataInputStream dis = new DataInputStream(바이트 입력 스트림);
DataOutputStream dos = new DataOutputStream(바이트 출력 스트림);
```

#### DataInputStream과 DataOutputStream이 제공하는 메소드

|DataInputStream||DataOutputStream||
|--------|-------|--------|--------|
|boolean|readBoolean()|void|wirteBoolean(boolean v)|
|byte|readByte()|void|writeByte(int v)|
|char|readChar()|void|writeChar(int v)|
|double|readDouble()|void|writeDouble(double v)|
|float|readFloat()|void|writeFloat(float v)|
|int|readInt()|void|writeInt(int v)|
|long|readLong()|void|writeLong(long v)|
|short|readShort()|void|writeShort(int v)|
|String|readUTF()|void|wirteUTF(String str)|

!주의
(1) DataInputStream으로 프로그램이 받았으면 DataOutputStream으로 프로그램이 내보내야한다.
(2) DataOutputStream으로 내보낸 자료형 순서대로 DataInputStream이 그대로 읽어들여야 한다.

### (7) 프린트 스트림
PrintStream과 PrintWriter는 콘솔창에 찍히는 프린트문과 유사하게 출력하는 print(), println(), printf() 메소드를 가지고 있는 보조 스트림이다. PrintStream은 바이트 출력 스트림과 연결되고, PrintWriter는 문자 출력 스트림과 연결된다.

>```java
PrintStream ps = new PrintStream(바이트 출력 스트림);
PrintWriter pw = new PrintWriter(문자 출력 스트림);
```

#### 가지고 있는 메소드
|PrintStream/PrintWriter||||
|-|-|-|-|
|void|print(boolean b)|void|println(boolean b)|
|void|print(char c)|void|println(char c)|
|void|print(double d)|void|println(double d)|
|void|print(float f)|void|println(float f)|
|void|print(int i)|void|println(int i)|
|void|print(long l)|void|println(long l)|
|void|print(Object obj)|void|println(Object obj)|
|void|print(String s)|void|println(String s)|
|||void|println()|
- printf() 메소드는 형식화된 문자열(format string)을 출력한다. 


### (8) 객체 스트림
자바는 메모리에 생성된 객체를 파일 또는 네트워크로 출력할 수 있다. 객체를 출력하려면 필드값을 일렬로 늘어선 바이트 변경해야 하는데, 이것을 직렬화(serialization)라고 한다. 반대로 직렬화된 바이트를 객체의 필드값으로 복원하는 것을 역직렬화(deserialization)라고 한다.

ObjectInputStream과 ObjectOutputStream은 객체를 입출력할 수 있는 보조 스트림이다. ObjectOutputStream은 바이트 출력 스트림과 연결되어 객체를 직렬화하고, ObjectInputStream은 바이트 입력 스트림과 연결되어 객체로 복원하는 역직렬화를 한다.

>```java
ObjectInputStream ois = new ObjectInputStream(바이트 입력 스트림);
ObjectOutputStream oos = new ObjectOutputStream(바이트 출력 스트림);
```

ObjectOutputStream으로 객체를 직렬화 하기 위해서는 writeObject() 메소드를 사용한다.
반대로 ObjectInputStream의 readObject() 메소드는 읽은 바이트를 역직렬화해서 객체로 생성한다. 이때 리턴 타입은 Object이므로 구체적인 타입으로 강제변환 해줘야 한다.

>```java
oos.writeObject(객체);	// 직렬화
객체타입 변수명 = (객체타입) ois.readObject();	// 역직렬화, 경로는 파일인풋스트림에서지정
```

**!주의** 모든 객체를 직렬화할 수 있는 것은 아니다. Serializable 인터페이스를 구현한 클래스만 직렬화 할 수 있다.

>```java
public class XXX implements Serializable {...}
```

#### serialVersionUID 필드
직렬화 할 때 사용된 클래스와 역직렬화 할 때 사용된 클래스는 기본적으로 동일한 클래스여야 한다. 그럼 두 클래스가 동일한지는 어떻게 알 수 있을까? 바로 상수 값으로 주어진 serialVersionUID 필드 값이 같으면 둘을 같은 객체로 본다. (단, 직렬화 할때 갖고 있는 필드를 역직렬화하는 객체에서도 갖고 있어야 한다.)

>```java
// 직렬화 객체
public class Member implements Serializable {
  Serializable{
  static final long serialVersionUID = 1;
  int field1;
  int field2;
  }
}
>
// 역직렬화 객체
public class Member implements Serializable {
  Serializable{
  static final long serialVersionUID = 1;
  int field1;
  int field2;
  int field3;
  }
}
```

### (9) File과 Files 클래스
java.io 패키지와 java.nio.file 패키지는 파일과 디렉토리 정보를 가지고 있는 File과 Files 클래스를 제공한다. Files는 File을 개선한 클래스로, 좀 더 많은 기능을 가지고 있다.

#### File 클래스

>```java
File file = new File("경로");
```

경로 구분자는 운영체제마다 조금씩 다르다. 윈도우에서는 \\ 또는 /를 둘 다 사용할 수 있고, 맥OS 및 리눅스에서는 /를 사용한다. 

>```java
File file = new File("C:/Temp/file.txt")
File file = new File("C:\\)
```

File 객체를 생성했다고 해서 파일이나 디렉토리가 생성되는 것은 아니다. 그리고 경로에 실제 파일이나 디렉토리가 없더라도 예외가 발생하지 않는다. 파일이나 디렉토리가 실제 있는지 확인하고 싶다면 File 객체를 생성하고 나서 exists() 메소드를 호출해서 확인할 수 있다.

>```java
boolean isExist = file.exists();	// 파일이나 폴더가 존재한다면 true를 리턴
```

exists() 메소드가 false를 리턴할 경우, 다음 메소드로 파일 또는 폴더를 생성할 수 있다.

|리턴 타입|메소드|설명|
|-|-|-|
|boolean|createNewFile()|새로운 파일을 생성|
|boolean|mkdir()|새로운 디렉토리를 생성|
|boolean|mkdirs()|경로상에 없는 모든 디렉토리를 생성|

exists() 메소드가 true를 리턴할 경우, 다음 메소드를 사용할 수 있다.

|리턴 타입|메소드|설명|
|-|-|-|
|boolean|delete()|파일 또는 디렉토리 삭제|
|boolean|canExecute()|실행할 수 있는 파일인지 여부|
|boolean|canRead()|읽을 수 있는 파일인지 여부|
|boolean|canWrite()|수정 및 저장할 수 있는 파일인지 여부|
|String|getName()|파일의 이름을 리턴|
|String|getParent()|부모 디렉토리를 리턴|
|File|getParentFile()|부모 디렉토리를 File 객체로 생성후 리턴|
|String|getPath()|전체 경로를 리턴|
|boolean|isDirectory()|디렉토리인지 여부|
|boolean|isFile()|파일인지 여부|
|boolean|isHidden()|숨김 파일인지 여부|
|long|lastModified()|마지막 수정 날짜 및 시간을 리턴|
|long|length()|파일의 크기 리턴|
|String[]|list()|디렉토리에 포함된 파일 및 서브 디렉토리 목록 전부를 String 배열로 리턴|
|String[]|list(FilenameFilter filter)|디렉토리에 포함된 파일 및 서브 디렉토리 목록 중에 FilenameFilter에 맞는 것만 String 배열로 리턴|
|File[]|listFiles()|디렉토리에 포함된 파일 및 서브 디렉토리 목록 전부를 File 배열로 리턴|
|File[]|listFiles(FilenameFilter filter)|디렉토리에 포함된 파일 및 서브 디렉토리 목록 중에 FilenameFilter에 맞는 것만 File 배열로 리턴|

#### Files 클래스
Files 클래스는 정적 메소드로 구성되어 있기 때문에 File 클래스처럼 객체로 만들 필요가 없다. Files의 정적 메소드는 운영체제의 파일 시스템에게 파일 작업을 수행하도록 위임한다.

|기능|관련 메소드|
|-|-|
|복사|copy|
|생성|createDirectories, createDirectory, createFile, createLink, cretaeSymbolicLink, createTempDirectory, createTempFile|
|이동|move|
|삭제|delete, deleteExists|
|존재, 검색, 비교|exists, notExists, find, mismatch|
|속성|getLastModifiedTime, getOwner, getPosixFilePermissions, isDirectory, isExecuable, isHidden, isReadable, isSymbolicLink, isWritable, size, SetAttribute, setLastModifiedTime, setOwner, setPosixFilePermissions, probeContentType|
|디렉토리 탐색|list, newDirectoryStream, walk|
|데이터 입출력|newInputStream, newOutputStream, newBufferedReader, newBufferedWriter, readAllBytes, lines, readAllFines, readString, readSymbolicLink, write, writeString|

이 메소드들은 매개값으로 Path 객체를 받는다. Path 객체는 파일이나 디렉토리를 찾기 위한 경로 정보를 가지고 있는데, 정적 메소드인 get() 메소드로 다음과 같이 얻을 수 있다.

```java
Path path = Paths.get(String first, STring ... more)
```

get() 메소드의 매개값은 파일 경로인데, 전체 경로를 한꺼번에 지정해도 좋고 상위 디렉토리와 하위 디렉토리를 나열해서 지정해도 좋다. 다음은 "C:\Temp\dir\file.txt"경로를 이용해서 Path 객체를 얻는 방법을 보여준다. 

>```java
Path path = Paths.get("C:\Temp\dir\file.txt");
Path path = Paths.get("C:\Temp\dir", "file.txt");
Path patt = Paths.get("C:", "Temp", "dir", "file.txt")
```

현재 위치가 ""C:\Temp\dir1" 이라면 "C:\Temp\dir2\file.txt"는 다음과 같이 지정 가능하다.
>```java
Path path = Paths.get("../dir2/file.txt")
```

<br>

# 2. 네트워크 입출력

### 1) 네트워크 기초
네트워크는 여러 컴퓨터들을 통신 회선으로 연결한 것이다. LAN은 가정, 회사, 건물, 특정 영역에 존재하는 컴퓨터를 연결한 것이고, WAN은 LAN을 연결한 것이다. WAN이 우리가 흔히 말하는 인터넷이다.

#### IP 주소
컴퓨터에 고유한 주소가 IP(Internet Protocol)주소 이다. IP 주소는 네트워크 어댑터(LAN 카드)마다 할당된다. 만약 컴퓨터에 두 개의 네트워크 어댑터가 장착되어 있다면, 두 개의 IP주소를 할당받을 수 있다.
연결할 상대방 컴퓨터의 IP 주소를 모르면 프로그램들은 서로 통신할 수 없다. 프로그램은 DNS(Domain Name System)를 이용해서 컴퓨터의 IP 주소를 검색한다. 여기에서 DNS는 도메인 이름으로, IP를 등록하는 저장소이다. 대중에게 서비스를 제공하는 대부분의 컴퓨터는 도메인 이름으로 IP를 DNS에 미리 등록해 놓는다.
웹 브라우저는 웹 서버와 통신하는 클라이언트로, 사용자가 입력한 도메인 이름으로 DNS에서 IP주소를 검색해 찾은 다음 웹 서버와 연결해서 웹 페이지를 받는다.

#### Port 번호
한 대의 컴퓨터에는 다양한 서버 프로그램들이 실행될 수 있다. 예를 들어 웹 서버, 데이터베이스 관리 시스템, FTP 서버 등이 하나의 IP 주소를 갖는 컴퓨터에서 동시에 실행될 수 있다. 이 경우 클라이언트는 어떤 서버와 통신해야 할지 결정해야 한다. IP는 컴퓨터의 네트워크 어댑터 까지만 갈 수 있는 정보이기 때문에, 컴퓨터 내부에ㅓ 실행하는 서버를 선택하기 위해서는 추가적인 Port 번호가 필요하다.
Port는 운영체제가 관리하는 서버 프로그램의 연결 번호다. 서버는 시작할 때 특정 Port 번호에 바인딩한다.  클라이언트도 서버에서 보낸 정보를 받기 위해서는 Port 번호가 필요한데, 서버와 같이 고정적인 Port번호에 바인딩하는 것이 아니라 운영체제가 자동으로 부여하는 번호를 사용한다. 이 번호는 클라이언트가 서버로 요청할 때 함께 전송되어 서버가 클라이언트로 데이터를 보낼 때 사용된다.

|구분명|범위|설명|
|-|-|-|
|Well Know Port Numbers|0~1023|국제인터넷주소관리기구가 특정 애플리케이션용으로 미리 예약한 Port|
|Registered Port Numbers|1024~49151|회사에서 등록해서 사용할 수 있는 Port|
|Dynamic Or Private Port Numbers|49152~65535|운영체제가 부여하는 동적 Port 또는 개인적 목적으로 사용할 수 이는 Port|

#### IP 주소 얻기
자바는 IP 주소를 java.net 패키지의 InetAddress로 표현한다. InetAddress를 이용하면 로컬 컴퓨터의 IP 주소를 얻을 수 있고, 도메인 이름으로 DNS에서 검색한 후 IP 주소를 가져올 수도 있다. 
로컬 컴퓨터의 InetAddress를 얻고 싶다면 InetAddress.getLocalHost() 메소드를 호출하면 된다.
만약 컴퓨터의 도메인 이름을 알고 있다면 InetAddress 객체를 얻을 수 있다.
이렇게 얻은 InetAddress 객체에서 IP 주소를 얻으려면 getHostAddress() 메소드를 호출하면 문자열로된 IP 주소가 반환된다.
>```java
// 로컬 컴퓨터의 InetAddress 얻고 싶을 때
InetAddress ia = InetAddress.getLocalHost();
// 컴퓨터의 도메인 이름 알고 있을 때
InetAddress ia = InetAddress.getByName(String domainName);	// 등록된 IP 하나 반환
InetAddress[] iaArr = InetAddress.getAllByName(String domainName);  // 등록된 IP 모두 반환
// InetAddress 객체에서 IP주소 추출
String ip = InetAdress.getHostAddress();
```

#### TCP 네트워킹 
IP 주소로 프로그램들이 통신할 때는 약속된 데이터 전송 규약이 있다. 이것을 전송용 프로토콜이라고 부른다. 인터넷에서 전송용 프로토콜은 TCP(transmission Control Protocol)와 UDP(User Datagram Protocol)가 있다.

TCP는 연결형 프로토코로, 상대방이 연결된 상태에서 데이터를 주고 받는다. 클라이언트가 연결 요청을 하고 서버가 연결을 수락하면 통신 회선이 고정되고, 데이터는 고정 회선을 통해 전달된다. 그렇기 때문에 TCP는 보낸 데이터가 순서대로 전달되며 손실이 발생하지 않는다.
TCP는 IP와 함께 사용하기 때문에 TCP/IP라고도 한다. TCP는 웹 브라우저가 웹 서버에 연결할 때 사용되며 이메일 전송, 파일 전송, DB 연동에도 사용된다.

자바는 TCP 네트워킹을 위해 java.net 패키지에서 ServerSoket과 Soket 클래스를 제공하고 있다. ServerSocket은 클라이언트의 연결을 수락하는 서버 쪽 클래스이고, Socket은 클라이언트에서 연결 요청할 때와 클라이언트와 서버 양쪽에서 데이터를 주고 받을 때 사용되는 클래스이다.

ServerSocket을 생성할 때는 바인딩할 Port 번호를 지정해야 한다. 서버가 실행되면 클라이언트는 Socket을 이용해서 서버의 IP 주소와 Port 번호로 연결 요청을 할 수 있다. ServerSocket은 accept() 메소드로 연결 수락을 하고 통신용 Socket을 생성한다. 그리고 나서 클라이언트와 서버는 양쪽의 Socket을 이용해서 데이터를 주고 받는다.

#### TCP 서버
TCP 서버 프로그램을 개발하려면 우선 ServerSocket 객체를 생성해야한다. 
(만약 Port가 이미 다른 프로그램에서 사용중이라면 BindException이 발생한다. 이 경우에는 다른 Port로 바인딩 하거나 Port를 사용 중인 프로그램을 종료하고 다시 실행하면 된다.)

>```java
// ServeSocket 객체 생성 방법1
ServerSocket serverSocket = new ServerSocket(포트 번호);
>
// ServeSocket 객체 생성 방법2
ServerSocket serverSocket = new ServerSocket(); // 기본 생성자 생성
serverSocket.bind(new InetSoketAddress(포트번호));
>
// 특정 IP에서만 서비스를 하고 싶을 때
ServerSocket serverSocket = new ServerSocket();
serverSocket.bind( new InetSocketAddress("특정 IP주소", 포트번호) );
```

ServerSocket이 생성되었다면 연결 요청 수락을 위해 accept() 메소드를 실행해야 한다. accept()는 클라이언트가 연결 요청하기 전까지 블로킹 된다. 블로킹이란 실행을 멈춘 상태가 된다는 뜻이다. 클라이언트의 요청이 들어오면 블로킹이 해제되고 통신용 Socket을 리턴한다.

>```java
Socekt socket = serverSocket.accept();
```

만약 리턴된 Socket을 통해 연결된 클라이언트의 IP 주소와 Port 번호를 얻고 싶다면 방법은
getRemoteSocketAddress() 메소드를 호출해서 InetSocketAddress를 얻은 다음 getHostName()과 getPort() 메소드를 호출하면 된다.

>```java
InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
String clientIp = isa.getHostName();
String portNo = isa.getPort();
```

서버를 종료하려면 ServerSocket의 close() 메소드르 호출해서 Port 번호를 언바인딩시켜야 한다. 그래야 다른 프로그램에서 해당 Port 번호를 재사용할 수 있다.

>```java
serverSocket.close();
```

#### TCP 클라이언트 
클라이언트가 서버에 연결 요청을 하려면 Socket 객체를 생성할 때 생성자 매개값으로 서버 IP 주소와 Port 번호를 제공하면 된다. 로컬 컴퓨터에서 실행하는 서버로 연결 요청을 할 경우에는 IP 주소 대신 localhost를 사용할 수 있다.

>```java
Socket socket = new Socket( "IP", 포트번호 );
```


<br>

# 3. 데이터베이스 입출력
