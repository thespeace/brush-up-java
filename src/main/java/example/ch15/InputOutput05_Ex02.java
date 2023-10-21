package example.ch15;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *      - FileReader와 FileWriter를 이용하여 파일의 공백을 모두 없애는 예제.(읽은 데이터를 변환해서 출력스트림에 쓰는 작업의 예)
 *
 *          {@code : 명령 프롬프트(cmd.exe)
 *              example>ch15> java InputOutput05_Ex02.java InputOutput05_Ex02.java convert.txt
 *
 *              example>ch15> type convert.txt
 *                            ...결과출력...
 *          }
 */
public class InputOutput05_Ex02 {
    public static void main(String[] args){
        try {
            FileReader fr = new FileReader(args[0]);
            FileWriter fw = new FileWriter(args[1]);

            int data = 0;
            while((data=fr.read()) != -1) {
                if(data!='\t' && data!='\n' && data!=' ' && data!='\r')
                    fw.write(data);
            }
            fr.close();
            fw.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}