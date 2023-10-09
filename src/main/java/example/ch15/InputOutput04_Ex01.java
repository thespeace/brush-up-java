package example.ch15;

import java.io.*;

/**
 *      - 크기가 5인 BufferedOutputStream을 이용해서 파일 123.txt에 1부터 9까지 출력하는 예제.
 *
 *      - 결과를 보면 5까지만 출력되는데, 그 이유는 버퍼에 남아있는 데이터는 버퍼를 가득 채우지 못하여서 출력되지 못한 상태로 프로그램이 종료되었기 때문이다.
 */
public class InputOutput04_Ex01 {
    public static void main(String[] args){
        try{
            FileOutputStream fos = new FileOutputStream("123.txt");
            // BufferedOutputStream의 버퍼 크기를 5로 한다.
            BufferedOutputStream bos = new BufferedOutputStream(fos, 5);
            // 파일 123.txt에 1 부터 9까지 출력한다.
            for(int i ='1'; i <= '9'; i++) {
                bos.write(i);
            }

//            fos.close(); // 스트림을 닫아주기는 했지만, 이렇게 해서는 BufferedOutputStream의 버퍼에 있는 내용이 출력되지 않는다.
            bos.close(); // BufferedOutputStream의 close()를 호출해 주어야 버퍼에 남아있던 모든 내용이 출력된다.
                         // BufferedOutputStream의 close()는 기반 스트림인 FileOutputStream의 close()를 호출하기 때문에
                         // FileOutputStream의 close()나 flush()를 호출할 필요없이 단순히 보조스트림의 close()를 호출하기만 하면 된다.
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

/**
 *      - BufferedOutputStream의 조상인 FileOutputStream의 소스코드
 *          {@code :
 *              public class FilterOutputStream extends OutputStream {
 *                  protected OutputStream out;
 *                  public FilterOutputStream(OutputStream out) {
 *                      this.out = out;
 *                  }
 *                  ...
 *                  public void close() throws IOException {
 *                      try {
 *                          flush();
 *                      } catch (IOException ignored) {}
 *                      out.close(); // 기반 스트림의 close()를 호출한다.
 *                  }
 *              }
 *          }
 *
 *      - FilterOutputStream에 정의된 close()는 flush()를 호출한 다음에 기반 스트림의 close()를 호출하는 것을 알 수 있다.
 *
 *      - BufferedOutputStream은 FilterOutputStream의 close()를 오버라이딩 없이 그대로 상속받는다.
 */