package example.ch16;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 *      - InetAddress의 주요 메서드들을 활용하는 예제.
 *
 *      - 하나의 도메인명(www.naver.com)에 여러 IP주소가 맵핑될 수도 있고, 또 그 반대의 경우도 가능하기 때문에
 *        전자의 경우 getAllByName()을 통해 모든 IP주소를 얻을 수 있다.
 *        그리고 getLocalHost()를 사용하면 호스트명과 IP주소를 알아낼 수 있다.
 */
public class Network01_Ex01 {
    public static void main(String[] args){
        InetAddress ip = null;
        InetAddress[] ipArr = null;

        try {
            ip = InetAddress.getByName("www.naver.com");
            System.out.println("getHostName() : " + ip.getHostName());
            System.out.println("getHostAddress() : " + ip.getHostAddress());
            System.out.println("toString() : " + ip.toString());

            byte[] ipAddr = ip.getAddress();
            System.out.println("getAddress() : " + Arrays.toString(ipAddr));

            String result = "";
            for(int i = 0; i < ipAddr.length; i++) {
                result += (ipAddr[i] < 0) ? ipAddr[i] + 256 : ipAddr[i];
                result += ".";
            }
            System.out.println("getAddress() + 256" + result);
            System.out.println();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        try {
            ip = InetAddress.getLocalHost();
            System.out.println("getHostName() : " + ip.getHostName());
            System.out.println("getHostAddress() : " + ip.getHostAddress());
            System.out.println();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        try {
            ipArr = InetAddress.getAllByName("www.naver.com");

            for(int i = 0; i < ipArr.length; i++) {
                System.out.println("ipArr["+i+"] : " + ipArr[i]);
            }
        }catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
