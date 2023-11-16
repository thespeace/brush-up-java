package example.ch15;

import java.io.*;

/**
 *      @see InputOutput07_Ex16
 *      - 위의 이전 예제에서 나눈 파일을 다시 합치는 예제.
 *        작업할 임시파일을 새로 만들고 프로그램 종료시 자동 삭제 되도록 했다. 프로그램의 실행도중에 사용자에 의해 중단되거나 했을 때,
 *        파일이 합쳐지는 과정에서 생성된 불완전한 파일이 생성되는 것을 막기위해서 임시파일을 사용하는 것이다.
 */
public class InputOutput07_Ex17 {
    public static void main(String[] args) throws IOException {
        if(args.length != 1) {
            System.out.println("USAGE : java InputOutput07_Ex17 filename");
            System.exit(0);
        }

        String mergeFilename = args[0];

        try {

            // 파일을 합치는 작업을 온전히 마치고 나면, 기존 파일을 삭제하고 임시파일의 이름을 기존 파일의 이름으로 변경한다.
            File tempFile = File.createTempFile("~mergetemp", ".tmp");
            tempFile.deleteOnExit();

            FileOutputStream     fos = new FileOutputStream(tempFile);
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            BufferedInputStream bis = null;

            int number = 1;

            File f = new File(mergeFilename + "_." + number);

            while(f.exists()) {
                f.setReadOnly(); // 작업중에 파일의 내용이 변경되지 않도록 한다.
                bis = new BufferedInputStream(new FileInputStream(f));

                int data = 0;
                while((data = bis.read()) != -1) {
                    bos.write(data);
                }

                bis.close();

                f = new File(mergeFilename + "_." + ++number);
            }

            bos.close();

            // 임시파일이 생성되는 곳은 createTempFile메서드에서 지정할 수도 있지만, 지정하지 않으면, 시스템 속성인 'java.io.tmpdir'에 지정된 디렉토리가 된다.
            //      + System.getProperty("java.io.tmpdir")을 출력해보면 임시 디렉토리의 위치를 확인할 수 있다.
            File oldFile = new File(mergeFilename);
            if(oldFile.exists())
                oldFile.delete();
            tempFile.renameTo(oldFile); // 작업을 마치고 나면 기존 파일을 삭제하고 임시파일의 이름을 기존 파일의 이름으로 변경한다.
        } catch (IOException e) { }
    }
}