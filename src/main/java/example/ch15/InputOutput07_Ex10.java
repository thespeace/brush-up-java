package example.ch15;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *      - 현재 디렉토리에 속한 파일과 디렉토리의 이름과 크기 등 상세정보를 보여주는 예제.
 *
 *          {@code : 명령 프롬프트(cmd.exe)
 *              ...example>ch15> java InputOutput07_Ex10.java
 *              ...결과 출력...
 *          }
 */
public class InputOutput07_Ex10 {
    public static void main(String[] args) throws IOException {
        String currDir = System.getProperty("user.dir");
        File dir = new File(currDir);

        File[] files = dir.listFiles();

        for(int i = 0; i < files.length; i++) {
            File f = files[i];
            String name = f.getName();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mma");
            String attribute = "";
            String size = "";

            if(files[i].isDirectory()) {
                attribute = "DIR";
            } else {
                size = f.length() + "";
                attribute = f.canRead()   ? "R" : " ";
                attribute += f.canWrite() ? "W" : " ";
                attribute += f.isHidden() ? "H" : " ";
            }
            System.out.printf("%s %3s %6s %s\n", df.format(new Date(f.lastModified())), attribute, size, name);
        }
    }
}