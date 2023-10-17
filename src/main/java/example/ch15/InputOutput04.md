# 바이트기반의 보조스트림
## 1. FilterInputStream과 FilterOutputStream
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
## 2. BufferedInputStream과 BufferedOutputStream
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

  > BufferedOutputStream을 이용한 예제 : [InputOutput04_Ex01.java](./InputOutput04_Ex01.java)

<br>

---
## 3. DataInputStream과 DataOutputStream
* 각각 FilterInputStream/FilterOutputStream의 자손.
* DataInputStream은 DataInput인터페이스를, DataOutputStream은 DataOutput인터페이스를 각각 구현하였기 때문에, 데이터를 읽고 쓰는데 있어서 byte단위가 아닌, 8가지 기본 자료형의 단위로 읽고 쓸 수 있다는 장점이 있다.
* DataOutputStream이 출력하는 형식은 각 기본 자료형 값을 16진수로 표현하여 저장한다.
  > int값을 출력한다면, 4byte의 16진수로 출력된다.
* 각 자료형의 크기가 다르므로, 출력한 데이터를 다시 읽어 올 때는 출력했을 때의 순서를 염두에 두어야 한다.<br><br>
* DataInputStream의 생성자와 메서드

    | 메서드 / 생성자                                                                                                                                                                                                                        | 설 명                                                                                                                              |
    |----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------|
    | DataInputStream(InputStream in)                                                                                                                                                                                                  | 주어진 InputStream인스턴스를 기반스트림으로 하는<br/>DataInputStream인스턴스를 생성한다.                                                                   |
    | boolean   readBoolean()<br/>byte readByte()<br/>char readChar()<br/>short readShort()<br/>int readInt()<br/>long readLong()<br/>float readFloat()<br/>double readDouble()<br/>int readUnsignedByte()<br/>int readUnsignedShort() | 각 타입에 맞게 값을 읽어 온다.<br/>더 이상 읽을 값이 없으면 EOFException을 발생시킨다.                                                                       |
    | void readFully(byte[] b)<br/>void readFully(byte[] b, int off, int len)                                                                                                                                                          | 입력스크림에서 지정된 배열의 크기만큼 또는 지정된 위<br/>치에서 len만큼 데이터를 읽어온다. 파일의 끝에 도달하면<br/>EOFException이 발생하고, I/O에러가 발생하면 IOException n<br/>이 발생한다. |
    | String readUTF()                                                                                                                                                                                                                 | UTF-8형식으로 쓰여진 문자를 읽는다.<br/>더 이상 읽을 값이 없으면 EOFException이 발생한다.                                                                    |
    | static String readUTF(DataInput in)                                                                                                                                                                                              | 입력스트림(in)에서 UTF-8형식의 유니코드를 읽어온다.                                                                                                 |
    | int skipBytes(int n)                                                                                                                                                                                                             | 현재 읽고 있는 위치에서 지정된 숫자(n) 만큼을 건너뛴다.                                                                                                |

<br/>

* DataOutputStream의 생성자와 메서드

    | 메서드 / 생성자                                                                                                                                                                                                                                                  | 설 명                                                              |
    |------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------|
    | DataOutputStream(OutputStream out)                                                                                                                                                                                                                         | 주어진 OutputStream인스턴스를 기반스트림으로 하는<br/>DataOutputStream인스턴스를 생성한다. |
    | void writeBoolean(boolean b)<br/>void writeByte(int b)<br/>void writeChar(int c)<br/>void writeChars(String s)<br/>void writeShort(int s)<br/>void writeInt(int i)<br/>void writeLong(long l)<br/>void writeFloadt(float f)<br/>void writeDouble(double d) | 각 자료형에 알맞은 값들을 출력한다.                                             |
    | void writeUTF(String s)                                                                                                                                                                                                                                    | UTF형식으로 문자를 출력한다.                                                |
    | void writeChars(String s)                                                                                                                                                                                                                                  | 주어진 문자열을 출력한다. writeChar(int c)메서드를 여러<br/>번 호출한 결과와 같다.         |
    | int size()                                                                                                                                                                                                                                                 | 지금까지 DataOutputStream에 쓰여진 byte의 수를 알려 준<br/>다.                       |

  > DataOutputStream을 이용한 간단한 예제 : [InputOutput04_Ex02.java](./InputOutput04_Ex02.java)\
  > ByteArrayOutputStream을 사용한 예제 : [InputOutput04_Ex03.java](./InputOutput04_Ex03.java)\
  > DataInputStream을 사용한 예제 : [InputOutput04_Ex04.java](./InputOutput04_Ex04.java)\
  > DataOutputStream을 이용한 예제 : [InputOutput04_Ex05.java](./InputOutput04_Ex05.java)\
  > DataInputStream을 이용한 예제 : [InputOutput04_Ex06.java](./InputOutput04_Ex06.java)\
  > DataInputStream을 이용한 예제 : [InputOutput04_Ex07.java](./InputOutput04_Ex07.java)

<br>

---

## 4. SequenceInputStream
* SequenceInputStream은 여러 개의 입력스트림을 연속적으로 연결해서 하나의 스트림으로부터 데이터를 읽는 것과 같이 처리할 수 있도록 도와준다.
* SequenceInputStream의 생성자를 제외하고 나머지 작업은 다른 입력스트림과 다르지 않다. 큰 파일을 여러 개의 작은 파일로 나누었다가 하나의 파일로 합치는 것과 같은 작업을 수행할 때 사용하면 좋을 것이다.
  
  +SequenceInputStream은 다른 보조스트림과는 달리 FilterInputStream의 자손이 아닌 InputStream을 바로 상속받아 구현하였다.<br><br>
* SequenceInputStream의 생성자

    | 메서드 / 생성자                                               | 설 명                                               |
    |---------------------------------------------------------|---------------------------------------------------|
    | SequenceInputStream(Enumeration e)                      | Enumeration에 저장된 순서대로 입력스트림을 하나의 스<br/>트림으로 연결한다. |
    | SequenceInputStream(InputStream s1,<br/>InputStream s2) | 두 개의 입력스트림을 하나로 연결한다.                             |

<br/>

* Vector에 연결할 입력스트림들을 저장한 다음 Vector의 Enumeration elements()를 호출해서 생성자의 매개변수로 사용한다.
    ```java
    // 사용 예 1
    Vector files = new Vector();
    files.add(new FileInputStream("file.001"));
    files.add(new FileInputStream("file.002"));
    SequenceInputStream in = new SequenceInputStream(files.elements());
  
    // 사용 예 2
    FileInputStream file1 = new FileInputStream("file.001");
    FileInputStream file2 = new FileInputStream("file.002");
    SequenceInputStream in = new SequenceInputStream(file1, file2);
    ```

  > SequenceInputStream을 이용한 간단한 예제 : [InputOutput04_Ex08.java](./InputOutput04_Ex08.java)\
 
<br/>

---
## 5. PrintStream
* PrintStream은 데이터를 기반스트림에 다양한 형태로 출력할 수 있는 print,println, printf와 같은 메서드를 오버로딩하여 제공한다.
* PrintStream은 데이터를 적절한 문자로 출력하는 것이기 때문에 문자기반 스트림의 역할을 수행한다. 그래서 JDK1.1에서 부터 PrintStream보다 향상된 기능의 문자기반 스트림인 PrintWriter가 추가되었으나 그 동안 매우 빈번히 사용되면 Systeam.out이 PrintStream이다 보니 둘 다 사용할 수 밖에 없게 되었다.
* PrintStream과 PrintWriter는 거의 같은 기능을 가지고 있지만 PrintWriter가 PrintStream에 비해 다양한 언어의 문자를 처리하는데 적합하기 때문에 가능하면 PrintWriter를 사용하는 것이 좋다.
* PrintStream은 우리가 지금까지 알게 모르게 많이 사용해 왔다. System클래스의 static멤버인 out과 err, 즉 System.out, System.err가 PrintStream이다.<br/><br/>
* PrintStream의 생성자와 메서드

| 생성자 / 메서드                                                                                                                                                                                                                                                                                                        | 설 명                                                                                                                                     |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------|
| PrintStream(File file)<br/>PrintStream(File file, String csn)<br/>PrintStream(OutputStream out)<br/>PrintStream(OutputStream out,<br/>boolean autoFlush)<br/>PrintStream(OutputStream out,<br/>boolean autoFlush, String encoding)<br/>PrintStream(String fileName)<br/>PrintStream(String fileName, String csn) | 지정된 출력스트림을 기반으로 하는 PrintStream인<br/>스턴스를 생성한다. autoFlush의 값을 true로 하면<br/>println메서드가 호출되거나 개행문자가 출력될 때<br/>자동으로 flush된다. 기본값은 false이다. |
| boolean checkError()                                                                                                                                                                                                                                                                                             | 스트림을 flush하고 에러가 발생했는지를 알려 준다.                                                                                                          |
| void print(boolean b)<br/>void print(char c)<br/>void print(char[] c)<br/>void print(double d)<br/>void print(float f)<br/>void print(int i)<br/>void print(long l)<br/>void print(Object o)<br/>void print(String s)                                                                                            | 인자로 주어진 값을 출력소스에 문자로 출력한다.<br/>println메서드는 출력 후 줄바꿈을 하고, print메서드<br/>는 줄을 바꾸지 않는다.                                                     |
| void println()                                                                                                                                                                                                                                                                                                   | 줄바꿈 문자(line separator)를 출력함으로써 줄을<br/>바꾼다.                                                                                              |
| PrintStream printf(String format, Object... args)                                                                                                                                                                                                                                                                | 정형화된(formatted) 출력을 가능하게 한다.                                                                                                            |
| protected void setError()                                                                                                                                                                                                                                                                                        | 작업 중에 오류가 발생했음을 알린다.<br/>(setError()를 호출한 후에, checkError()를 호출하<br/>면 true를 반환한다.)                                                      |

* print()나 println()을 이용해서 출력하는 중에 PrintStream의 기반스트림에서 IOException이 발생하면 checkError()를 통해서 인지할 수 있다. println()이나 print()는 예외를 던지지 않고 내부에서 처리하도록 정의하였는데, 그 이유는 println()과 같은 메서드가 매우 자주 사용되는 것이기 때문이다.
* 만일 println()이 예외를 던지도록 정의되었다면 println()을 사용하는 모든 곳에 try-catch문을 사용해야 할 것이다.
    ```java
    public class PrintStream extends FilterOutputStream implements Appendable, Closeable {
        ...
        private boolean trouble = false;
  
        public void print(int i) {
            write(String.valueOf(i)); // write(i+"");와 같다.
        }
  
        private void write(String s) {
            try {
                ...
            } catch(IOException x) {
                trouble = true;
            }
        }
        ...
        public boolean checkError() {
            if(out != null) flush();
            return trouble;
        }
    }
    ```
  + i+""와 String.valueOf(i)는 같은 결과를 얻지만, String.valueOf(i)가 더 성능이 좋다.

<br>

* printf()는 JDK1.5부터 추가된 것으로, C언어와 같이 편리한 형식화된 출력을 지원하게 되었다.
* printf()에 사용될 수 있는 옵션은 꽤나 다양한데 그에 대한 자세한 내용은 Java API문서에서 Formatter클래스를 참고하면 된다.
<br><br>
* 정수의 출력에 사용될 수 있는 옵션(자주 사용되는 욥션들)

    | format | 설 명                           | 결 과(int i = 65) |
    |--------|-------------------------------|-----------------|
    | %d     | 10진수(decimal integer)         | 65              |
    | %o     | 8진수(octal integer)            | 101             |
    | %x     | 16진수(hexadecimal integer)     | 41              |
    | %c     | 문자                            | A               |
    | %s     | 문자열                           | 65              |
    | %5d    | 5자리 숫자, 빈자리는 공백으로 채운다.        | 　65             |
    | %-5d   | 5자리 숫자, 빈자리는 공백으로 채운다.(왼쪽 정렬) | 65              |
    | %05d   | 5자리 숫자, 빈자리는 0으로 채운다.         | 00065           |
<br>

* 문자열의 출력에 사용될 수 있는 옵션

    | format | 설 명                            | 결 과(String str = "ABC") |
    |--------|--------------------------------|-------------------------|
    | %s     | 문자열(string)                    | ABC                     |
    | %5s    | 5자리 문자열, 빈자리는 공백으로 채운다.        | 　ABC                     |
    | %-5s   | 5자리 문자열, 빈자리는 공백으로 채운다.(왼쪽 정렬) | ABC                     |
<br>

* 실수의 출력에 사용될 수 있는 옵션

    | format | 설 명                                                                                               | 결 과(float f = 1234.56789f) |
    |--------|---------------------------------------------------------------------------------------------------|----------------------------|
    | %e     | 지수형태표현(exponent)                                                                                  | 1.234568e+03               |
    | %f     | 10진수(decimal float)                                                                               | 1234.56789                 |
    | %3.1f  | 출력될 자리수를 최소 3자리(소수점포함), 소수점 이하 1자리<br/>(2번째 자리에서 반올림)                                             | 1234.6                     |
    | %8.1f  | 소수점이상 최소 6자리, 소수점 이하 1자리.<br/>출력될 자리수를 최소 8자리(소수점포함)를 확보한다. 빈자리<br/>는 공백으로 채워진다.(오른쪽 정렬)          | 　1234.6                     |
    | %08.0f | 소수점이상 최소 6자리, 소수점 이하 1자리.<br/>출력될 자리수를 최소 8자리(소수점포함)를 확보한다. 빈자리<br/>는 0으로 채워진다.                   | 001234.6                   |
    | %-8.1f | 소수점이상 최소 6자리, 소수점 이하 1자리.<br/>출력될 자리수를 최소 8자리(소수점포함)를 확보한다. 빈자리<br/>는 공백으로 채워진다.(왼쪽 정렬) | 1234.6                     |
<br>

* 특수문자를 출력하는 옵션

    | format | 설 명              |
    |--------|------------------|
    | \t     | 탭(tab)           |
    | %n     | 줄바꿈 문자(new line) |
    | %%     | %                |
<br>

* 날짜와 시간의 출력에 사용될 수 있는 옵션

    | format              | 설 명       | 결 과                       |
    |---------------------|-----------|---------------------------|
    | %tR<br/>%tH:%tM     | 시분(24시간)  | 21:05<br/>21:05           |
    | %tT<br/>%tH:%tM:%tS | 시분초(24시간) | 21:05:33<br/>21:05:33     |
    | %tD<br/>%tm/%td/%ty | 월일년       | 11/16/15<br/>11/16/15     |
    | %tF<br/>%tY-%tm-%td | 년월일       | 2015-11-16<br/>2015-11-16 |

> PrintStream을 이용한 간단한 예제 : [InputOutput04_Ex09.java](./InputOutput04_Ex09.java)