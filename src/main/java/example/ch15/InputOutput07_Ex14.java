package example.ch15;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 *      - 재귀호출을 이용해서 지정된 디렉토리와 하위 디렉토리에 있는 파일 중에서 지정된 확장자를 가진 파일을
 *        delete()를 호출해서 삭제한다. delete()는 해당 파일을 삭제하는데 성공하면 true를 실패하면 false를 반환한다.
 *
 *          {@code : 명령 프롬프트(cmd.exe)
 *              ...example>ch15> java InputOutput07_Ex14.java bak
 *              ...결과 출력...
 *          }
 *
 */
public class InputOutput07_Ex14 {
    static int deletedFiles = 0;
    public static void main(String[] args) throws IOException {
        if(args.length != 1) {
            System.out.println("USAGE : java InputOutput07_Ex14 Extension");
            System.exit(0);
        }

        String currDir = System.getProperty("user.dir");

        File dir = new File(currDir);
        String ext = "." + args[0];

        delete(dir, ext);
        System.out.println(deletedFiles + "개의 파일이 삭제되었습니다.");
    }

    public static void delete(File dir, String ext) {
        File[] files = dir.listFiles();

        for(int i = 0; i < files.length; i++) {
            if(files[i].isDirectory()) {
                delete(files[i], ext);
            } else {
                String filename = files[i].getAbsolutePath();

                if(filename.endsWith(ext)) {
                    System.out.println(filename);
                    if(files[i].delete()){
                        System.out.println(" - 삭제 성공");
                        deletedFiles++;
                    } else {
                        System.out.println(" - 삭제 실패");
                    }
                }
            }
        }
    }
}