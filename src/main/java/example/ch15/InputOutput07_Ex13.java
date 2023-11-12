package example.ch15;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *      - FilenameFilter를 구현해서 String[] list(FilenameFilter filter)와 함께 사용해서 특정 조건에 맞는
 *        파일의 목록을 얻는 방법을 보여 주는 예제.
 *
 *          {@code : 명령 프롬프트(cmd.exe)
 *              ...example>ch15> java InputOutput07_Ex13.java FileEx
 *              ...결과 출력...
 *          }
 *
 *
 *      - FilenameFilter의 내용은 다음과 같이 accept메서드 하나만 선언되어 있으며 이 메서드만 구현해 주면 된다.
 *          {@code
 *              public interface FilenameFilter {
 *                  boolean accept(File dir, String name);
 *              }
 *          }
 */
public class InputOutput07_Ex13 {
    public static void main(String[] args) throws IOException {
        if(args.length != 1) {
            System.out.println("USAGE : java InputOutput07_Ex13 pattern");
            System.exit(0);
        }

        String currDir = System.getProperty("user.dir");

        File dir = new File(currDir);
        final String pattern = args[0];

        //String[] list (FilenameFilter filter)
        String[] files = dir.list(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.indexOf(pattern) != -1;
            }
        });

        for(int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }
    }
}