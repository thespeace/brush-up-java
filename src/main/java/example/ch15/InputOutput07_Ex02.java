package example.ch15;

public class InputOutput07_Ex02 {
    public static void main(String[] args){

        // System.out, System.err 모두 출력대상이 콘솔이기 때문에 System.out대신 System.err를 사용해도 같은 결과를 얻는다.
        System.out.println("out : Hello World!");
        System.err.println("out : Hello World!");
    }
}

/**
 *      - setOut()과 같은 메서도를 사용하는 방법외에도 커맨드라인에서 표준입출력의 대상을 간단히 바꿀 수 있는 방법.
 *
 *          {@code : 명령 프롬프트(cmd.exe)
 *              ...example>ch15> java InputOutput07_Ex02.java
 *              out : Hello World!
 *              err : Hello World!
 *
 *
 *              // 콘솔이 아닌 output.txt로 지정하여 출력하는 것을 output.txt에 저장, 기존에 output.txt파일이 있었다면 기존의 내용은 삭제된다.
 *              ...example>ch15> java InputOutput07_Ex02.java > output.txt
 *              err : Hello World!
 *
 *              ...example>ch15> type output.txt
 *              out : Hello World!
 *
 *
 *              // 커맨드라인에서 '>'를 사용했을 때와는 달리 '>>'는 기존 내용의 마지막에 새로운 내용이 추가된다.
 *              ...example>ch15> java InputOutput07_Ex02.java >> output.txt
 *              err : Hello World!
 *
 *              ...example>ch15> type output.txt
 *              out : Hello World!
 *              out : Hello World!
 *
 *              // 표준입력을 output.txt로 지정하여 콘솔이 아닌 output.txt로부터 데이터를 입력받는다.
 *              ...example>ch15> java InputOutput07_Ex02.java < output.txt
 *              out : Hello World!
 *              out : Hello World!
 *          }
 */