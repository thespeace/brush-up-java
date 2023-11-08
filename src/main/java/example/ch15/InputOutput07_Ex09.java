package example.ch15;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *       @see InputOutput07_Ex08
 *      - 위의 이전 예제를 발전시켜서 서브디렉토리와 그에 포함된 파일과 디렉토리의 목록까지 보여주는 예제.
 *
 *      - printFileList(File dir)는 디렉토리에 포함된 파일과
 *
 *          {@code : 명령 프롬프트(cmd.exe)
 *              ...example>ch15> java InputOutput07_Ex09.java c:\jdk1.8\work\ch15(예시경로)
 *              ...결과 출력...
 *          }
 */
public class InputOutput07_Ex09 {
    static int totalFiles = 0;
    static int totalDirs = 0;
    public static void main(String[] args) throws IOException {
        if(args.length != 1) {
            System.out.println("USAGE :  java InputOutput07_Ex09 DIRECTORY");
            System.exit(0);
        }

        File dir = new File(args[0]);

        if(!dir.exists() || !dir.isDirectory()) {
            System.out.println("유효하지 않은 디렉토리입니다.");
            System.exit(0);
        }

        printFileList(dir);

        System.out.println();
        System.out.println("총 : " + totalFiles + "개의 파일");
        System.out.println("총 : " + totalDirs + "개의 디렉토리");
    }

    public static void printFileList(File dir){ // 디렉토리에 포함된 파일과 디렉토리의 목록을 출력하는 메서드로 재귀호출을 이용하였다.
        System.out.println(dir.getAbsolutePath()+" 디렉토리");
        File[] files = dir.listFiles();

        // 파일의 목록을 출력하고 디렉토리인 경우 ArrayList에 담았다가 각 디렉토리에 대해 printFileList(File dir)를 재귀호출한다.
        // ArrayList에 담지 않고 재귀호출만을 이용해도 처리가 가능하나 보다 정돈된 형태로 출력하기 위해 ArrayList를 이용하였다.
        ArrayList subDir = new ArrayList();

        for(int i = 0; i < files.length; i++){
            String filename = files[i].getName();

            if(files[i].isDirectory()) {
                filename = "[" + filename + "]";
                subDir.add(i+"");
            }
            System.out.println(filename);
        }

        int dirNum = subDir.size();
        int fileNum = files.length - dirNum;

        totalFiles += fileNum;
        totalDirs += dirNum;

        System.out.println(fileNum + "개의 파일, " + dirNum + "개의 디렉토리");
        System.out.println();

        for(int i = 0; i < subDir.size(); i++) {
            int index = Integer.parseInt((String)subDir.get(i));
            printFileList(files[index]);
        }
    }
}