package example.ch15;

import java.io.File;
import java.io.IOException;

/**
 *      - 지정한 디렉토리(폴더)에 포함된 파일과 디렉토리의 목록을 보여주는 예제.
 *
 *          {@code : 명령 프롬프트(cmd.exe)
 *              ...example>ch15> java InputOutput07_Ex08.java
 *              USAGE :  java InputOutput07_Ex08 DIRECTORY
 *
 *              ...example>ch15> java InputOutput07_Ex08.java work
 *              유효하지 않은 디렉토리입니다.
 *
 *              ...example>ch15> java InputOutput07_Ex08.java c:\jdk1.8
 *              [bin]
 *              COPYRIGHT
 *              [db]
 *              ...(등등 생략)
 *          }
 */
public class InputOutput07_Ex08 {
    public static void main(String[] args) throws IOException {
        if(args.length != 1) {
            System.out.println("USAGE :  java InputOutput07_Ex08 DIRECTORY");
            System.exit(0);
        }

        File f = new File(args[0]);

        if(!f.exists() || !f.isDirectory()) {
            System.out.println("유효하지 않은 디렉토리입니다.");
            System.exit(0);
        }

        File[] files = f.listFiles();

        for(int i = 0; i < files.length; i++){
            String fileName = files[i].getName();
            System.out.println( files[i].isDirectory() ? "[" + fileName + "]" : fileName);
        }
    }
}