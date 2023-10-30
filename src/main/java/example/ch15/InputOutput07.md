# 표준입출력과 File
## 1. 표준입출력 - System.in, System.out, System.err
* 표준입출력은 콘솔(console, 도스창)을 통한 데이터 입력과 콘솔로의 데이터 출력을 의미합니다.
* 자바에서는 표준 입출력(standard I/O)를 위해 3가지 입출력 스트림, System.in, System.out, System.err를 제공하는데. 이 들은 자바 어플리케이션의 실행과 동시에 사용할 수 있게 자동으로 생성되기 때문에 개발자가 별도로 스트림을 생성하는 코드를 작성하지 않고도 사용 가능합니다.
* 자바를 처음 시작할 때부터 지금까지 줄 곧 사용해온 System.out을 스트림의 생성없이 사용할 수 있었던 것이 바로 이러한 이유 때문이다.<br><br>
* 자바에서의 표준입출력
  > **System.in**  : 콘솔로부터 데이터를 입력받는데 사용(InputStream)\
  > **System.out** : 콘솔로 데이터를 출력하는데 사용(PrintStream)\
  > **System.err** : 콘솔로 데이터를 출력하는데 사용(PrintStream)
* System클래스의 소스에서 알 수 있듯이 in, out, err은 System클래스에 선언된 클래스변수(static변수)이다.
* 선언부분만을 봐서는 out, err, in의 타입은 InputStream과 PrintStream이지만 실제로는 버퍼를 이용하는 BufferedInputStream과 BufferedOutputStream의 인스턴스를 사용한다.
  ```java
  public final class System {
    public final static InputStream in = nullInputStream();
    public final static PrintStream out = nullPrintStream();
    public final static PrintStream err = nullPrintStream();
    ...
  }
  ```

> 위 표준입출력을 이용한 간단한 예제 : [InputOutput07_Ex01.java](./InputOutput07_Ex01.java)

<br>

---
## 2. 표준입출력의 대상변경 : setOut(), setErr(), setIn()
* 초기에는 System.in, System.out, System.err의 입출력대상이 콘솔화면이지만, setIn(), setOut(), setErr()를 사용하면 입출력을 콘솔 이외에 다른 입출력 대상으로 변경하는 것이 가능하다.

| 메서드                                 | 설 명                                  |
|-------------------------------------|--------------------------------------|
| static void setOut(PrintStream out) | System.out의 출력을 지정된 PrintStream으로 변경 |
| static void setErr(PrintStream err) | System.err의 출력을 지정한 PrintStream으로 변경 |
| static void setIn(InputStream in)   | System.in의 입력을 지정한 InputStream으로 변경  |

* 그러나 JDK1.5부터는 Scanner클래스가 제공되면서 System.in으로부터 데이터를 입력받아 작업한느 것이 편리해졌다.
> 위 표준입출력을 이용한 예제 1 : [InputOutput07_Ex2.java](./InputOutput07_Ex02.java)\
> 위 표준입출력을 이용한 예제 2 : [InputOutput07_Ex3.java](./InputOutput07_Ex03.java)

<br>

---
## 3. RandomAccessFile
* 자바에서는 입력과 출력이 각각 분리되어 별도로 작업을 하도록 설계되어 있는데, RandomAccessFile만은 하나의 클래스로 파일에 대한 입력과 출력을 모두 할 수 있도록 되어 있다.
* InputStream이나 OutputStream으로부터 상속받지 않고, DataInput인터페이스와 DataOutput인터페이스를 모두 구현했기 때문에 읽기와 쓰기가 모두 가능하다.
  ![RandomAccessFile의 상속계층도](InputOutput07_randomaccessFile.png)
* 사실 DataInputStream은 DataInput인터페이스를, DataOutputStream은 DataOutput인터페이스를 구현했다. 이 두 클래스의 기본 자료형(primitive data type)을 읽고 쓰기위한 메서드들은 모두 이 2개의 인터페이스에 정의되어있는 것들이다.
* 따라서, RandomAccessFile클래스도 DataInputStream과 DataOutputStream처럼 기본자료형 단위로 데이터를 읽고 쓸 수 있다.
* 그래도 역시 RandomAccessFile클래스의 가장 큰 장점은 파일의 어느 위치에나 읽기/쓰기가 가능하다는 것이다. 다른 입출력 클래스들은 입출력소스에 순차적으로 읽기/쓰기를 하기 때문에 읽기와 쓰기가 제한적인데 반해서 RandomAccessFile클래스는 파일에 읽고 쓰는 위치에 제한이 없다.
* 이것을 가능하게 하기 위해서 내부적으로 파일 포인터를 사용하는데, 입출력 시에 작업이 수행되는 곳이 바로 파일 포인터가 위치한 곳이 된다.
* 파일 포인터의 위치는 파일의 제일 첫 부분(0부터 시작)이며, 읽기 또는 쓰기를 수행할때 마다 작업이 수행된 다음 위치로 이동하게 된다. 순차적으로 읽기나 쓰기를 한다면, 파일 포인터를 이동시키기 위해 별도의 작업이 필요하지 않지만, 파일의 임의의 위치에 있는 내용에 대해서 작업하고자 한다면, 먼저 파일 포인터를 원하는 위치로 옮긴 다음 작업을 해야 한다.

  | 생성자 / 메서드                                                                                       | 설 명                                                                                                                                                                                                                                                                            |
  |-------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
  | RandomAccessFile(File file, String mode)<br/>RandomAccessFile(String fileName, String<br/>mode) | 주어진 file에 읽기 또는 읽기와 쓰기를 하기 위한<br/>RandomAccessFile인스턴스를 생성한다. mode의 값<br/>은 "r","rw","rws","rwd"가 지정가능하다.<br/>"r" - 파일로부터 읽기(r)만을 수행할 때<br/>"rw" - 파일에 읽기(r)와 쓰기(w)<br/>"rws"와 "rwd"는 기본적으로 "rw"와 같은데, 출력내용<br/>이 파일에 지연 없이 바로 쓰이게 한다. "rwd"는 파일<br/>내용만, "rws"는 파일의 메타정보도 포함. |
  | FileChannel getChannel()                                                                        | 파일의 파일 채널을 반환한다.                                                                                                                                                                                                                                                               |
  | FileDescriptor getFD()                                                                          | 파일의 파일 디스크립터를 반환                                                                                                                                                                                                                                                               |
  | long getFilePointer()                                                                           | 파일 포인터의 위치를 알려준다.                                                                                                                                                                                                                                                              |
  | long length()                                                                                   | 파일의 크기를 얻을 수 있다(단위 byte)                                                                                                                                                                                                                                                       |
  | void seek(long pos)                                                                             | 파일 포인터의 위치를 변경한다. 위치는 파일의 첫 부<br/>분부터 pos크기만큼 떨어진 곳이다.(단위 byte)                                                                                                                                                                                                                |
  | void setLength(long newLength)                                                                  | 파일의 크기를 지정된 길이로 변경한다.(byte단위)                                                                                                                                                                                                                                                  |
  | int skipBytes(int n)                                                                            | 지정된 수만큼의 byte를 건너뛴다.                                                                                                                                                                                                                                                           |
  * 사실 모든 입출력에 사용되는 클래스들은 입출력 시 다음 작업이 이루어질 위치를 저장학 ㅗ있는 포인터를 내부적으로 갖고 있다. 다만 내부적으로만 사용될 수 있기 때문에 작업자가 포인터의 위치를 마음대로 변경할 수 없다는 것이 RandomAccessFile과 다른점이다.
  * RandomAccessFile의 인스턴스를 "rw" mode로 생성할 때, 지정된 파일이 없으면 새로운 파일을 생성한다.