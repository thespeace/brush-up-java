package example.ch16;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *      - 서버로부터 서버시간을 전송받아 출력하는 간단한 UDP소켓 클라이언트 프로그램.
 *        아래의 클래스는 서버 프로그램이다.
 *        @see Network01_Ex16
 *
 *      - DatagramPacket을 생성해서 DatagramSocket으로 서버에 전송한다.
 */
public class Network01_Ex15 {
    public void start() throws IOException, UnknownHostException {
        DatagramSocket datagramSocket = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName("127.0.0.1");

        // 데이터가 저장될 공간으로 byte배열을 생성한다.
        byte[] msg = new byte[100];

        DatagramPacket outPacket = new DatagramPacket(msg, 1, serverAddress, 7777);
        DatagramPacket inPacket = new DatagramPacket(msg, msg.length);

        datagramSocket.send(outPacket);   // DatagramPacket을 전송한다.
        datagramSocket.receive(inPacket); // DatagramPacket을 수신한다.

        System.out.println("current server time : " + new String(inPacket.getData()));
        datagramSocket.close();
    }
    public static void main(String[] args){
        try {
            new Network01_Ex15().start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
