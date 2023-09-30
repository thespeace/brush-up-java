package example.ch15;

/**
 *    - 입출력(I/0)란?
 *      컴퓨터 내부 또는 외부의 장치와 프로그램간의 데이터를 주고 받는 것을 말한다.
 *          Input Example  : 키보드로부터 데이터를 입력받는다.
 *          Output Example : System.out.println()을 이용해 화면에 출력한다.
 *
 *    - 스트림(Stream)
 *      두 대상을 연결하고 데이터를 전송할 수 있는 무언가가 필요하는데 이것을 스트림(Stream)이라고 정의한다.
 *      14장의 스트림과 같은 용어를 쓰지만 다른 개념이다.
 *
 *          "데이터를 운반하는데 사용되는 연결통로"
 *
 *      스트림은 단방향 통신만 가능하며, 입력과 출력을 동시에 수행하려면 입력스트림, 출력스트림. 모두 2개의 스트림이 필요하다.
 *      먼저 보낸 데이터를 먼저 받게 되어 있으며 중간에 건너뜀 없이 연속적으로 데이터를 주고 받는다. == queue, FIFO구조와 비슷.
 *
 *    - 바이트기반 스트림 : InputStream, OutputStream.
 *      스트림은 바이트단위로 데이터를 전송하며 입출력 대상에 따라 다음과 같은 입출력스트림이 있다.
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
 */

public class InputOutput01 {
    public static void main(String[] args){
    }
}
