## 바이트기반의 보조스트림
### 1.FilterInputStream과 FilterOutputStream
* FilterInputStream/FilterOutputStream은 InputStream/OutputStream의 자손이면서 **모든 보조스트림의 조상**이다.
* 보조스트림은 자체적으로 입출력을 수행할 수 없기 때문에 기반스트림을 필요로 한다.
* FilterInputStream/FilterOutputStream의 생성자
    ```java
    protected FilterInputStream(InputStream in)
    public    FilterOuputStream(OutputStream out)
    ```
* FilterInputStream/FilterOutputStream의 모든 메서드는 단순히 기반스트림의 메서드를 그대로 호출할 뿐, 그 자체로는 아무런 일도 하지 않는다.
<br><br><br>
* FilterInputStream/FilterOutputStream은 상속을 통해 원하는 작업을 수행하도록 읽고 쓰는 메서드를 오버라이딩해야 한다.
    ```java
    public class FilterInputStream extends InputStream{
        protected volatile InputStream in;
        protected java.io.FilterInputStream(InputStream in){
            this.in = in;
        }
  
        public int read() throws IOException {
            return in.read();
        } 
        ...
    }
    ```
* 생성자 FilterInputStream(InputStream in)는 접근 제어자가 protected이기 때문에 Filter InputStream의 인스턴스를 생성해서 사용할 수 없고 상속을 통해서 오버라이딩되어야 한다.
* FilterInputStream/FilterOutputStream을 상속받아서 기반스트림에 보조기능을 추가한 보조스트림 클래스는 다음과 같다.
    ```markdown
    FilterInputStream의 자손   BufferedInputStream, DataInputStream, PushbackInputStream 등
    FilterOutputStream의 자손  BufferedOutputStream, DataOutputStream, PrintStream 등
    ```
  <br>
---
### 2.BufferedInputStream과 BufferedOutputStream
* BufferedInputStream/BufferedOutputStream은 스트림의 입출력 효율을 높이기 위해 버퍼를 사용하는 보조스트림이다.
* 한 바이트씩 입출력하는것 보다는 버퍼(바이트배열)를 이용해서 한 번에 여러 바이트를 입출력하는 것이 빠르기 때문에 대부분의 입출력 작업에 사용된다.
* BufferedInputStream의 생성자

    | 생성자                                          | 설 명                                                                                                        |
    |----------------------------------------------|------------------------------------------------------------------------------------------------------------|
    | BufferedInputStream(InputStream in,<br/>int size) | 주어진 InputStream인스턴스를 입력소스(input source)로<br/>하며 지정된 크기(byte단위)의 버퍼를 갖는 BufferedInput<br/>Stream인스턴스를 생성한다. |
    | BufferedInputStream(InputStream in)          | 주어진 InputStream인스턴스를 입력소스(Input source)로<br/>하며 버퍼의 크기를 지정해주지 않으므로 기본적으로 8192<br/>byte 크기의 버퍼를 갖게 된다.      |

* BufferedInputStream의 버퍼크기는 입력소스로부터 한 번에 가져올 수 있는 데이터의 크기로 지정하는 것이 좋으며, 버퍼의 크기를 변경해가면서 테스트하면 최적의 버퍼크기를 알아낼 수 있다.
* BufferedInputStream/BufferedOutputStream가 입출력 효율을 높일 수 있는 동작원리
    >1.프로그램에서 입력소스로부터 데이터를 읽기 위해 처음으로 read메서드를 호출하면, BufferedInputStream은 입력소스로 부터 버퍼 크기만큼의 데이터를 읽어다 자신의 내부 버퍼에 저장한다.<br> 2.이제 프로그램에서는 BufferedInputStream의 버퍼에 저장된 데이터를 읽으면 되는 것이다.<br>3.외부의 입력소스로 부터 읽는 것보다 내부의 버퍼로 부터 읽는 것이 훨씬 빠르기 때문에 그만큼 작업 효율이 높아진다.<br>4.프로그램에서 버퍼에 저장된 모든 데이터를 다 읽고 그 다음 데이터를 읽기위해 read메서드가 호출되면, BufferedInputStream은 입력소스로부터 다시 버퍼크기 만큼의 데이터를 읽어다 버퍼에 저장해 놓는다.<br>5.이와 같은 작업이 계속 반복된다. 

* BufferedOutputStream의 생성자와 메서드

    | 메서드/생성자                                             | 설 명                                                                                                        |
    |-----------------------------------------------------|------------------------------------------------------------------------------------------------------------|
    | BufferedOutputStream(OutputStream out,<br>int size) | 주어진 OutputStream인스턴스를 출력소스(output<br>source)로하며 지정된 크기(단위 byte)의 버퍼를 갖는<br>BufferedOutputStream인스턴스를 생성한다. |
    | BufferedOutputStream(OutputStream out)              | 주어진 OutputStream인스턴스를 출력소스(output source)<br>로하며 버퍼의 크기를 지정해주지 않으므로 기본적으로<br>8192 byte 크기의 버퍼를 갖게 된다.      |
    | flush()                                             | 버퍼의 모든 내용을 출력소스에 출력한 다음, 버퍼를 비운<br>다.                                                                      |
    | close()                                             | flush()를 호출해서 버퍼의 모든 내용을 출력소스에 출력하고, BufferedOutputStream인스턴스가 사용하던 모든 자원을 반환한다.                           |

* BufferedOutputStream 역시 버퍼를 이용해서 출력소스와 작업하게 되는데, 입력소스로부터 데이터를 읽을 때와는 반대로, 프로그램에서 write메서드를 이용한 출력이 BufferedOutputStream의 버퍼에 저장된다.
* 버퍼가 가득 차면, 그 때 버퍼의 모든 내용을 출력소스에 출력한다. 그리고는 버퍼를 비우고 다시 프로그램으로부터의 출력을 저장할 준비를 한다.
* 버퍼가 가득 찼을 때만 출력소스에 출력을 하기 때문에, 마지막 출력부분이 출력소스에 쓰이지 못하고 BufferedOutputStream의 버퍼에 남아있는 채로 프로그램이 종료될 수 있다는 점을 주의해야 한다.
* 그래서 프로그램에서 모든 출력작업을 마친 후 BufferedOutputStream에 close()나 flush()를 호출해서 마지막에 버퍼에 있는 모든 내용이 출력소스에 출력되도록 해야 한다.
    > BufferedOutputStream의 close()는 flush()를 호출하여 버퍼의 내용을 출력스트림에 쓰도록 한 후, BufferedOutputStream인스턴스의 참조변수에 null을 지정함으로써 사용하던 자원들이 반환되게 한다.