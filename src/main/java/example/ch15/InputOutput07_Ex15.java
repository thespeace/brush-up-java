package example.ch15;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *      - renameTo(File f)를 이용해서 파일의 이름을 바꾸는 예제.
 *        여기서는 파일명이 숫자로 되어 있을 때 앞에 '0000'을 붙인 다음 substring()으로 이름의 길이를 맞춰 주는 내용으로 작성.
 *
 *      - 파일이름이 '1.jpg','2.jpg'와 같이 숫자로 되어 있는 경우, 파일이름으로 정렬을 하면 '1.jpg' 다음에 '2.jpg'가 아닌 '11.jpg'가 오게 된다.
 *        이것을 바로 잡기위해 파일이름 앞에 '0000'을 붙이면, 파일이름으로 정렬하였을 때 '00001.jpg' 다음에 '00002.jpg'가 온다.
 *        이 예제는 이미지 뷰어를 통해서 파일명이 숫자인 이미지파일들을 슬라이드로 볼 때 순서를 바로잡을 수 있다.
 */
public class InputOutput07_Ex15 {
    public static void main(String[] args) throws IOException {
        if(args.length != 1) {
            System.out.println("Usage : java InputOutput07_Ex15 DIRECTORY");
            System.exit(0);
        }

        File dir = new File(args[0]);

        if(!dir.exists() || !dir.isDirectory()) {
            System.out.println("유효하지 않은 디렉토리입니다.");
            System.exit(0);
        }

        File[] list = dir.listFiles();

        for(int i = 0; i < list.length; i++) {
            String fileName = list[i].getName();
            // 파일명
            String newFileName = "0000" + fileName;
            newFileName = newFileName.substring(newFileName.length() - 7);
            list[i].renameTo(new File(dir, newFileName));
        }
    }
}