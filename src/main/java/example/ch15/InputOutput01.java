package example.ch15;

public class InputOutput01 {
    public static void main(String[] args){
        /**
         *
         *
         *          -입력스트림과 출력스트림의 종류(InputStream, OutputStream의 자손들)
         *              입력 스트림           |       출력스트림            |         입출력 대상의 종류
         *          FileInputStream         |    FileOutputStream       |     파일
         *          ByteArrayInputStream    |    ByteArrayOutputStream  |     메모리(byte배열)
         *          PipedInputStream        |    PipedOutputStream      |     프로세스(프로세스간의 통신)
         *          AudioInputStream        |    AudioOutputStream      |     오디오장치
         *
         *
         *          -InputStream과 OutputStream에 정의된 읽기와 쓰기를 수행하는 메서드
         *                  InputStream                     |               OutputStream
         *                          abstract int read()     |   abstract void write(int b)          // 반환 값이 byte가 아니라 int인 이유? read()의 반환 범위가 0~255, -1이기 때문.
         *                          int read(byte[] b)      |   void write(byte[] b)
         *           int read(byte[] b, int off, int len)   |   void write(byte[] b, int off, int len)
         *
         *      read()와 write(int b)를 이용해서 나머지 메서드들도 구현한 것이기 때문에 read(), write(int b)가 구현되어 있지 않으면 나머지 메서드들은 아무런 의미가 없다.
         *
         *          {@code : InputStream의 실제 소스코드의 일부를 이해하기 쉽게 변경한 코드.
         *              public abstract class InputStream {
         *                  ...
         *                  // 입력스트림으로부터 1 byte를 읽어서 반환한다. 읽을 수 없다면 -1을 반환한다.
         *                  abstract int read();
         *
         *                  // 입력스트림으로부터 len개의 byte를 읽어서 byte배열 b의 off위치부터 저장한다.
         *                  int read(byte[] b, int off, int len) {
         *                      ...
         *                      for(int i=off; i < off + len; i++
         *                              b[i] = (byte)read();    // read()를 호출해서 데이터를 읽어서 배열을 채운다.
         *                   }
         *                          ...
         *                   // 입력스트림으로부터 byte배열 b의 크기만큼 데이터를 읽어서 배열 b에 저장한다.
         *                   int read(byte[] b) {
         *                       return read(b, 0, b.length);
         *                   }
         *                      ...
         *              }
         *          }
         *          결론적으로 read()는 반드시 구현되어야하는 핵심적인 메서드이고, read()없이는 매개변수가 있는 read()메서드들도 의미가 없다는 것을 확인할 수 있다.
         *
         *
         *
         *    - 보조 스트림
         *      스트림의 기능을 보완하기 위한 보조스트림이 제공된다.
         *      데이터를 입출력할 수 있는 기능은 없지만, 스트림의 기능을 향상시키거나 새로운 기능을 추가할 수 있다.
         *      스트림을 먼저 생성한 다음에 이를 이용해서 보조스트림을 생성해야 한다.
         *
         *          {@code
         *              //먼저 기반스트림을 생성.
         *              FileInputStream fis = new FileInputStream("test.txt");
         *
         *              //기반스트림을 이용해서 보조스트림을 생성한다.
         *
         *
         *          }
         *
         */
    }
}
