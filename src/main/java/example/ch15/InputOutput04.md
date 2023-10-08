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
