package example.ch15;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *      - 재귀호출을 이용해서 지정한 디렉토리와 서브디렉토리에 포함된, 확장자가 'java', 'txt', 'bak'인
 *        모든 파일의 내용을 읽어서 지정한 키워드가 포함된 라인을 출력하는 예제.
 *
 *          {@code : 명령 프롬프트(cmd.exe)
 *              ...example>ch15> java InputOutput07_Ex12.java C:\jdk1.8\work\ch15\text exit
 *              ...결과 출력...
 *          }
 */
public class InputOutput07_Ex12 {
    static int found = 0;
    public static void main(String[] args) throws IOException {
        if(args.length != 2) {
            System.out.println("USAGE : java InputOutput07_Ex12 DIRECTORY KEYWORD");
            System.exit(0);
        }

        File dir = new File(args[0]);
        String keyword = args[1];

        if(!dir.exists() || !dir.isDirectory()) {
            System.out.println("유효하지 않은 디렉토리입니다.");
            System.exit(0);
        }

        try {
            findInFiles(dir, keyword);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("총 : " + found + "개의 라인에서 '" + keyword + "'을/를 발견하였습니다. ");
    }

    public static void findInFiles(File dir, String keyword) throws IOException {
        File[] files = dir.listFiles();

        for(int i = 0; i < files.length; i++){
            if(files[i].isDirectory()){
                findInFiles(files[i], keyword);
            } else {
                String filename = files[i].getName();
                String extension = filename.substring(filename.lastIndexOf(".")+1);

                //구분자를 ','로 하여 확장자를 붙여서 문자열을 만든 다음, indexOf()를 이용해서 이 문자열에 확장자가 포함되었는지 확인하고 없으면 넘어가도록 되어있다.
                //확장자의 뒤쪽이나 앞쪽에만 구분자를 붙이면 확장자가 'ava'와 같이 부분적으로 일치하는 경우에 문제가 생긴다.
                extension = "," + extension + ",";

                if(",java,txt,bak,".indexOf(extension) == -1) continue;

                filename = dir.getAbsolutePath() + File.separator + filename;

                FileReader fr = new FileReader(files[i]);
                BufferedReader br = new BufferedReader(fr); // 파일의 내용을 라인단위로 읽기 위해 BufferedReader의 readLine()을 이용.

                String data = "";
                int lineNum = 0;

                while((data=br.readLine()) != null){
                    lineNum++;

                    if(data.indexOf(keyword) != -1) {
                        found++;
                        System.out.println("["+filename+"("+lineNum+")"+"]"+data);
                    }
                }
                br.close();
            }
        }
    }
}