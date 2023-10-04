## 바이트기반 스트림
### InputStream과 OutputStream
* InputStream과 OutputStream은 모든 바이트기반의 스트림의 조상이며 다음과 같은 메서드가 선언되어 있다.
* InputStream의 메서드

    | 메서드명                                    | 설명                                                                                                                                      |
    |-----------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------|
    | int available()                         | 스트림으로부터 읽어 올 수 있는 데이터의 크기를 반환한다.                                                                                                        |
    | void close()                            | 스트림을 닫음으로써 사용하고 있던 자원을 반환한다.                                                                                                            |
    | boolean markSupported()                 | mark()와 reset()을 지원하는지를 알려 준다. mark()와 reset()기능<br>을 지원하는 것은 선택적이므로, mark()와 reset()을 사용하기 전에<br> markSupported()를 호출해서 지원여부를 확인해야 한다. |
    | abstract int read()                     | 1byte를 읽어 온다(0~255사이의 값). 더 이상 읽어 올 데이터가 없으면<br>-1을 반환한다. abstract메서드라서 InputStream의 자손들은 자신의 상황<br>에 알맞게 구현해야 한다.                      |
    | int read(byte[] b)                      | 배열 b의 크기만큼 읽어서 배열을 채우고 읽어 온 데이터의 수를 반환한<br>다. 반환하는 값은 항상 배열의 크기보다 작거나 같다.                                                               |
    | int read(byte[] b,<br>int off, int len) | 최대 len개의 byte를 읽어서, 배열 b의 지정된 위치(off)부터 저장한다. 실<br>제로 읽어 올 수 있는 데이터가 len개보다 적을 수 있다.                                                    |
    | void reset()                            | 스트림에서의 위치를 마지막으로 mark()이 호출되었던 위치로 되돌린다.                                                                                                |
    | long skip(long n)                       | 스트림에서 주어진 길이(n)만큼을 건너뛴다.                                                                                                                |
* OutputStream의 메서드

    | 메서드명                                      | 설명                                                       |
    |-------------------------------------------|----------------------------------------------------------|
    | void close()                              | 입력소스를 닫음으로써 사용하고 있던 자원을 반환한다.                            |
    | void flush()                              | 스트림의 버퍼에 있는 모든 내용을 출력소스에 쓴다                              |
    | abstract void write(int b)                | 주어진 값을 출력소스에 쓴다.                                         |
    | void write(byte[] b)                      | 주어진 배열 b에 저장된 모든 내용을 출력소스에 쓴다.                           |
    | void write(byte[] b,<br>int off, int len) | 주어진 배열 b에 저장된 내용 중에서 off번째부터 len개 만큼만을 읽어서<br> 출력소스에 쓴다. |
* 스트림의 종류에 따라서 mark()와 reset()을 사용하여 이미 읽은 데이터를 되돌려서 다시 읽을 수 있다. 이 기능을 지원하는 스트림인지 확인하는 markSupported()를 통해서 알 수 있다.
* flush()는 버퍼가 있는 출력스트림의 경우에만 의미가 있으며 OutputStream에 정의된 flush()는 아무런 일도 하지 않는다.
* 프로그램이 종료될 때, 사용하고 닫지 않은 스트림을 JVM이 자동적으로 닫아 주기는 하지만, 스트림을 사용해서 모든 작업을 마치고 난 후에는 close()를 호출해서 반드시 닫아 주어야 한다. 그러나 ByteArrayInputStream과 같이 메모리를 사용하는 스트림과 System.in, Systeam.out과 같은 표준 입출력 스트림은 닫아 주지 않아도 된다.

---
### ByteArrayInputStream과 ByteArrayOutputStream
* 메모리, 즉 바이트배열에 데이터를 입출력 하는데 사용되는 스트림으로 주로 다른 곳에 입출력하기 전에 데이터를 임시로 바이트배열에 담아서 변환 등의 작업을 하는데 사용된다.
* 주로 사용되지는 않지만 스트림을 이용한 입출력 방법을 보여주는 예제를 작성하기에는 적합.
    > 예제 : [InputOutput02_Ex01.java](./InputOutput02_Ex01.java)\
  > 예제 : [InputOutput02_Ex02.java](./InputOutput02_Ex02.java)\
  > 예제 : [InputOutput02_Ex03.java](./InputOutput02_Ex03.java)