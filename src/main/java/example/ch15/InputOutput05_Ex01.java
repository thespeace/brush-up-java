package example.ch15;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 *      - 바이트기반 스트림인 FileInputStream과 문자기반 스트림인 FileReader의 차이점을 보여 주기 위한 예제.
 *
 *      {@code : 명령 프롬프트(cmd.exe)
 *          example>ch15> type test.txt
 *                        Hello, 안녕하세요?
 *      }
 */
public class InputOutput05_Ex01 {
    public static void main(String[] args){
        try {
            String fileName = "test.txt";
            FileInputStream fis = new FileInputStream(fileName);
            FileReader fr = new FileReader(fileName);

            int data = 0;
            // FileInputStream을 이용해서 파일내용을 읽어 화면에 출력한다.(한글이 깨져서 출력)
            while((data=fis.read()) != -1) {
                System.out.print((char)data);
            }
            System.out.println();
            fis.close();

            //FileReader를 이용해서 파일내용을 읽어 화면에 출력한다.
            while((data=fr.read()) != -1) {
                System.out.print((char)data);
            }
            System.out.println();
            fr.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}