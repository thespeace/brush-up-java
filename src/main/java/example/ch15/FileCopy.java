package example.ch15;

import java.io.*;

/**
 *      - FileInputStream과 FileOutputStream을 사용해서 FileCopy.java파일의 내용을 그대로 FileCopy.bak으로 복사하는 예제.
 *                          커맨드 실행&확인 : ...\example\ch15> java FileCopy.java FileCopy.java FileCopy.bak
 *
 *      - 기존의 파일에 새로운 내용을 추가하려면, FileOutputStream fos = new FileOutputStream(args[1], true); 와 같이 생성자의 두번째 매개변수의 값을 true로 해야한다.
 *
 *      - 이처럼 텍스트 파일을 다루는 경우에는 FileInputStream/FileOutputStream보다 문자기반의 스트림인 FileReader/FileWriter을 사용하는 것이 좋다.
 */
public class FileCopy {
    public static void main(String[] args){
        try{
            FileInputStream  fis = new FileInputStream(args[0]);
            FileOutputStream fos = new FileOutputStream(args[1]);

            int data = 0;
            while((data=fis.read()) != -1){
                fos.write(data);    // void write(int b)
            }
            fis.close();
            fos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
