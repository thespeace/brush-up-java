package example.ch16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 *      - URL에 연결하여 그 내용을 읽어오는 예제.
 *
 *      - 만일 URL이 유효하지 않으면 Malformed- URLException이 발생한다. 읽어올 데이터가 문자데이터이기 때문에 BufferedReader을 사용하였다.
 *        openStream()을 호출해서 URL의 InputStream을 얻은 이후로는 파일로 부터 데이터를 읽는 것과 다르지 않다.
 *
 *      - openStream()은 openConnection()을 호출해서 URLConnection을 얻은 다음 여기에 다시 getInputStream()을 호출한 것과 같다.
 *        즉, URL에 연결해서 InputStream을 얻어온다.
 *
 *        {@code
 *            InputStream in = url.openStream();
 *            ->
 *            URLConnection conn = url.openConnection();
 *            InputStream in = conn.getInputStream();
 *        }
 */
public class Network01_Ex04 {
    public static void main(String[] args) throws Exception {
        URL url = null;
        BufferedReader input = null;
        String address = "https://www.naver.com";
        String line = "";

        try {
            url = new URL(address);
            input = new BufferedReader(new InputStreamReader(url.openStream()));

            while((line=input.readLine()) != null) {
                System.out.println(line);
            }
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
