package example.ch16;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 *      - URL에 연결하여 그 내용을 텍스트 데이터가 아닌 이진 데이터를 읽어서 파일에 저장하는 예제.
 */
public class Network01_Ex05 {
    public static void main(String[] args) throws Exception {
        URL url = null;
        InputStream in = null;
        FileOutputStream out = null; // 텍스트 데이터가 아니라 이진 데이터를 저장해야하기에 FileReader가 아닌 FileOutputStream을 사용하였다.
        String address = "https://www.naver.com";

        int ch = 0;

        try {
            url = new URL(address);
            in = url.openStream();
            out = new FileOutputStream("java.zip");

            while ((ch=in.read()) != -1) {
                out.write(ch);
            }
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
