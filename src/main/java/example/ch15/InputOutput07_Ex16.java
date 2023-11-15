package example.ch15;

import java.io.*;

/**
 *      - 지정한 파일을 지정한 크기로 잘라서 여러 개의 파일로 만드는 예제.
 *
 *          {@code : 명령 프롬프트(cmd.exe)
 *              ...example>ch15> java InputOutput07_Ex16 temp.dat 1000
 *
 *              ...example>ch15> dir temp.dat*
 *              ...결과 출력...
 *          }
 */
public class InputOutput07_Ex16 {
    public static void main(String[] args) throws IOException {
        if(args.length < 2) {
            System.out.println("USAGE : java InputOutput07_Ex16 filename SIZE_KB");
            System.exit(0);
        }

        final int VOLUME = Integer.parseInt(args[1]) * 1000;

        try {
            String filename = args[0];

            FileInputStream     fis = new FileInputStream(filename);
            BufferedInputStream bis = new BufferedInputStream(fis);

            FileOutputStream fos = null;
            BufferedOutputStream bos = null;

            int data = 0;
            int i = 0;
            int number = 0;

            while((data = bis.read()) != -1) {
                if(i%VOLUME == 0) {
                    if(i != 0) {
                        bos.close();
                    }
                    fos = new FileOutputStream(filename + "_." + number);
                    bos = new BufferedOutputStream(fos);
                }
                bos.write(data);
                i++;
            }

            bis.close();
            bos.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}