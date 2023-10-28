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
> 위 표준입출력을 이용한 예제 1 : [InputOutput07_Ex2.java](./InputOutput07_Ex02.java) 