package example.ch15;

import java.io.*;

public class InputOutput07_Ex03 {
    public static void main(String[] args){
        PrintStream ps = null;
        FileOutputStream fos = null;

        try{
            fos = new FileOutputStream("test.txt");
            ps = new PrintStream(fos);
            System.setOut(ps); // System.out의 출력대상을 test.txt파일로 변경
        } catch (FileNotFoundException e){
            System.out.println("File not found.");
        }
        System.out.println("Hello by System.out");
        System.err.println("Hello by System.err");
    }
}

/**
 *          {@code : 명령 프롬프트(cmd.exe)
 *              ...example>ch15> java InputOutput07_Ex03.java
 *              Hello by System.err
 *
 *              ...example>ch15> type test.txt
 *              Hello by System.out
 *
 *              ...example>ch15>
 *          }
 *
 *      - System.out의 출력소스를 test.txt파일로 변경하였기 때문에 System.out을 이용한 출력은 모두 test.txt파일에 저장된다.
 *        그래서 실행결과에는 System.err를 이용한 출력만 나타난다.
 *
 *      - setOut()과 같은 메소드를 사용하는 방법 외에도 커맨드라인에서 표준입출력의 대상을 간단히 바꿀 수 있는 방법들이 있다.
 *        @see example.ch15.InputOutput07_Ex02
 */