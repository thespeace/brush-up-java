package example.ch15;

import java.io.*;

/**
 *      - (커맨드라인으로부터) 입력받은 파일의 내용을 읽어서 그대로 화면에 출력하는 클래스 : FileViewer.java
 *                          커맨드 실행&확인 : ...\example\ch15> java FileViewer.java FileViewer.java
 *
 *      - read()의 반환값이 int형(4 byte)이긴 하지만, 더 이상 입력값이 없음을 알리는 -1을 제외하고는 0~255(1 byte)범위의 정수값이기 때문에,
 *        char형(2 byte)으로 변환한다 해도 손실되는 값은 없다.
 *
 *      - read()가 한 번에 1 byte씩 파일로부터 데이터를 읽어 들이긴 하지만, 데이터의 범위가 십진수로 0~255(16진수로는 0x00~0xff)범위의 정수값이고,
 *        또 읽을 수 있는 입력값이 더 이상 없음을 알릴 수 있는 값(-1)도 필요하다. 그래서 다소 크긴 하지만 정수형 중에서는 연산이 가장 효율적이고 빠른 int형 값을 반환하도록 한 것이다.
 */
public class FileViewer {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        int data = 0;

        while((data=fis.read()) != -1) {
            char c = (char)data;
            System.out.print(c);
        }
    }
}