## 입출력(I/0)란?
* 컴퓨터 내부 또는 외부의 장치와 프로그램간의 데이터를 주고 받는 것을 말한다.
    > Input Example  : 키보드로부터 데이터를 입력받는다.\
      Output Example : System.out.println()을 이용해 화면에 출력한다.
---
## 스트림(Stream)
* 두 대상을 연결하고 데이터를 전송할 수 있는 무언가로 데이터를 운반하는데 사용되는 연결통로.
* 14장의 스트림과 같은 용어를 쓰지만 다른 개념이다.
* 스트림은 단방향 통신만 가능하며, 입력과 출력을 동시에 수행하려면 입력스트림, 출력스트림. 모두 2개의 스트림이 필요하다.
* 먼저 보낸 데이터를 먼저 받게 되어 있으며 중간에 건너뜀 없이 연속적으로 데이터를 주고 받는다. == queue, FIFO구조와 비슷하다.
---
## 바이트기반 스트림 : ```InputStream```, ```OutputStream```
* 스트림은 바이트단위로 데이터를 전송하며 입출력 대상에 따라 다음과 같은 입출력스트림이 있다.
### 입력스트림과 출력스트림의 종류(InputStream, OutputStream의 자손들)
*
  | 입력 스트림 | 출력 스트림 | 입출력 대상의 종류 |
  |--------|--------|------------|
  |FileInputStream|FileOutputStream|파일|
  |ByteArrayInputStream|ByteArrayInputStream|메모리(byte배열)|
  |PipedInputStream|PipedOutputStream|프로세스(프로세스간의 통신)|
  |AudioInputStream|AudioOutputStream|오디오장치|

### InputStream과 OutputStream에 정의된 읽기와 쓰기를 수행하는 메서드
* 
  |InputStream| OutputStream              |
  |-|---------------------------|
  |abstract int read()| abstract void write(int b)|
  |int read(byte[] b)| void write(byte[] b)|
  |int read(byte[] b, int off, int len)| void write(byte[] b, int off, int len)|

+반환 값이 byte가 아니라 int인 이유? read()의 반환 범위가 0~255, -1이기 때문.
#### read()와 write(int b)를 이용해서 나머지 메서드들도 구현한 것이기 때문에 read(), write(int b)가 구현되어 있지 않으면 나머지 메서드들은 아무런 의미가 없다.

* InputStream의 실제 소스코드의 일부를 이해하기 쉽게 변경한 코드.
  ```java
  public abstract class InputStream {
      ...
      // 입력스트림으로부터 1 byte를 읽어서 반환한다. 읽을 수 없다면 -1을 반환한다.
      abstract int read();
  
      // 입력스트림으로부터 len개의 byte를 읽어서 byte배열 b의 off위치부터 저장한다.
      int read(byte[] b, int off, int len) {
          ...
          for(int i=off; i < off + len; i++
              b[i] = (byte)read();    // read()를 호출해서 데이터를 읽어서 배열을 채운다.
      }
          ...
      // 입력스트림으로부터 byte배열 b의 크기만큼 데이터를 읽어서 배열 b에 저장한다.
      int read(byte[] b) {
          return read(b, 0, b.length);
      }
          ...
  }
  ```
  * 결론적으로 read()는 반드시 구현되어야하는 핵심적인 메서드이고, read()없이는 매개변수가 있는 read()메서드들도 의미가 없다는 것을 확인할 수 있다.
---
## 보조 스트림
* 스트림의 기능을 보완하기 위한 보조스트림이 제공된다.
* 데이터를 입출력할 수 있는 기능은 없지만, 스트림의 기능을 향상시키거나 새로운 기능을 추가할 수 있다.
* 스트림을 먼저 생성한 다음에 이를 이용해서 보조스트림을 생성해야 한다.
  ```java
  //먼저 기반스트림을 생성.
  FileInputStream fis = new FileInputStream("test.txt");
  
  //기반스트림을 이용해서 보조스트림을 생성한다.
  BufferedInputStream bis = new BufferedInputStream(fis);
  
  bis.read(); // 보조스트림인 BufferedInputStream으로부터 데이터를 읽는다.
  ```
  * 실제 입력기능은 FileInputStream이 수행하고, 보조스트림인 BufferedInputStream은 버퍼만을 제공, 버퍼를 사용한 입출력과 사용하지 않은 입출력간의 성능차이는 상당하기 때문에 대부분의 경우에 버퍼를 이용한 보조 스트림을 사용한다.
<br><br>
* InputStream, OutputStream -(자손)-> FilterInputStream -(자손)-> BufferedInputStream,DataInputStream,DigestInputStream,LineNumberInputStream,PushbackInputStream

  | 입력                    | 출력                   | 설명                                                            |
  |-----------------------|----------------------|---------------------------------------------------------------|
  | FilterInputStream     | FilterOutputStream   | 필터를 이용한 입출력 처리                                                |
  | BufferedInputStream   | BufferedOutputStream | 버퍼를 이용한 입출력 성능향상                                              |
  | DataInputStream       | DataOutputStream     | int, float와 같은 기본형 단위(private tye)로 <br>데이터를 처리하는 기능          |
  | SequenceInputStream   | 없음                   | 두 개의 스트림을 하나로 연결                                              |
  | LineNumberInputStream | 없음                   | 읽어 온 데이터의 라인 번호를 카운트<br>(JDK1.1부터 LineNumberReader로 대체)       |
  | ObjectInputStream     | ObjectOutputStream   | 데이터를 객체단위로 읽고 쓰는데 사용.<br>주로 파일을 이용하며 객체 직렬화와 관련있음             |
  | 없음                    | PrintStream          | 버퍼를 이용하며, 추가적인 print관련 기능<br>(print, printf, println메서드)      |
  | PushbackInputStream   | 없음                   | 버퍼를 이용해서 읽어 온 데이터를 다시 되돌리는<br>기능(unread, push back to buffer) |
---
## 문자기반 스트림 : ```Reader```, ```Writer```
* 지금까지 알아온 스트림은 모두 바이트기반의 스트림으로 입출력 단위가 1byte라는 뜻이다. 다만 Java에서는 C언어와는 달리 char형이 2byte이기 때문에 바이트기반의 스트림으로 2byte인 문자를 처리하는 데는 어려움이 있다.
* 이 점을 보완하기 위해 문자기반의 스트림이 제공된다. 문자데이터를 입출력할 때는 바이트기반 스트림 대신 문자기반 스트림을 사용하자.
> InputStream --> Reader\
> OutputStream --> Writer

* 바이트기반 스트림과 문자기반 스트림의 비교

  | 바이트기반 스트림                                     | 문자기반 스트림                           |
  |-----------------------------------------------|------------------------------------|
  | FileInputStream<br>FileOutputStream           | FileReader<br>FileWriter           |
  | ByteArrayInputStream<br>ByteArrayOutputStream | CharArrayReader<br>CharArrayWriter |
  | PipedInputStream<br>PipedOutputStream         | PipedReader<br>PipedWriter |
  | StringBufferInputStream<br>StringBufferOutputStream  | StringBufferReader<br>StringBufferWriter |

  |참고| StringBufferInputStream/OutputStream은 StringReader/Writer로 대체되어 더 이상 사용되지 않는다.<br><br>
  
* 바이트기반 스트림과 문자기반 스트림의 읽고 쓰는 메서드 비교
  
  | InputStream                                                                       | Reader                                                                                  |
  |-----------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------|
  | abstract int read()<br>int read(byte[] b)<br>int read(byte[] b, int off, int len) | int read()<br>int read(char[] cbuf)<br>abstract int read(char[] cbuf, int off, int len) |
  
  | OutputStream                                                                                 | Writer                                                                                                                                                                   |
  |----------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
  | abstract void write(int b)<br>void write(byte[] b)<br>void write(byte[] b, int off, int len) | void write(int c)<br>void write(char[] cbuf)<br>abstract void write(char[] cbuf, int off, int len)<br>void write(String str)<br>void write(String str, int off, int len) |

* 바이트기반 보조스트림과 문자기반 보조스트림

  | 바이트기반 보조스트림                                 | 문자기반 보조스트림                       |
  |---------------------------------------------|----------------------------------|
  | BufferedInputStream<br>BufferedOutputStream | BufferedReader<br>BufferedWriter |
  | FilterInputStream<br>FilterOutputStream     | FilterReader<br>FilterWriter     |
  | LineNumberInputStream(deprecated)           | LineNumberReader                 |
  | PrintStream                                 | PrintWriter                      |
  | PushbackInputStream                         | PushbackReader                   |
* Reader, Writer에서도 역시 추상메서드가 아닌 메서드들은 추상메서드를 이용해서 작성되었으며, 프로그래밍적인 관점에서 볼 때 read()를 추상메서드로 하는 것보다 int read(char[] cbuf, int off, int len)을 추상메서드로 하는 것이 더 바람직하다.
* 바이트기반 스트림과 문자기반 스트림은 이름만 조금 다를 뿐 활용방법은 거의 같다.
자바에서의 입출력