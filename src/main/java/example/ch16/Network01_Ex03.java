package example.ch16;

import java.net.*;

/**
 *      - URLConnection을 생성하고 get메서드들을 통해서 관련정보를 얻어서 출력하는 예제이다.
 *        예제의 결과를 보고 어떤 메서드를 통해 어떠한 정보를 얻을 수 있는지 확인해보자.
 */
public class Network01_Ex03 {
    public static void main(String[] args) throws Exception {
        URL url = null;
        String address = "https://www.naver.com";

        try {
            url = new URL(address);
            URLConnection conn = url.openConnection();

            System.out.println("conn.toString() : " + conn);
            System.out.println("getAllowUserInteraction() : " + conn.getAllowUserInteraction());
            System.out.println("getConnectTimeout() : " + conn.getConnectTimeout());
            System.out.println("getContent() : " + conn.getContent());
            System.out.println("getContentEncoding()" + conn.getContentEncoding());
            System.out.println("getContentLength()" + conn.getContentLength());
            System.out.println("getContentType()" + conn.getContentType());
            System.out.println("getDate()" + conn.getDate());
            System.out.println("getDefaultAllowUserInteraction()" + conn.getDefaultAllowUserInteraction());
            System.out.println("getDefaultUseCaches()" + conn.getDefaultUseCaches());
            System.out.println("getDoInput()" + conn.getDoInput());
            System.out.println("getDoOutput()" + conn.getDoOutput());
            System.out.println("getExpiration()" + conn.getExpiration());
            System.out.println("getHeaderFields()" + conn.getHeaderFields());
            System.out.println("getIfModifiedSince()" + conn.getIfModifiedSince());
            System.out.println("getLastModified()" + conn.getLastModified());
            System.out.println("getReadTimeout()" + conn.getReadTimeout());
            System.out.println("getURL()" + conn.getURL());
            System.out.println("getUseCaches()" + conn.getUseCaches());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
