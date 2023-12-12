package example.ch16;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *      - 서버로부터 서버시간을 전송받아 출력하는 간단한 UDP소켓 서버 프로그램.
 *        아래의 클래스는 클라이언트 프로그램이다.
 *        @see Network01_Ex15
 *
 *      - 클라이언트로부터 전송받은 DatagramPacket의 getAddress(), getPort()를 호출해서 클라이언트의 정보를 얻어서
 *        서버시간을 DatagramPacket에 담아서 전송한다.
 */
public class Network01_Ex16 {
    public void start() throws IOException {
        // 포트 7777번을 사용하는 소켓을 생성한다.
        DatagramSocket socket = new DatagramSocket(7777);
        DatagramPacket inPacket, outPacket;

        byte[] inMsg = new byte[10];
        byte[] outMsg;

        while(true) {
            // 데이터를 수신하기 위한 패킷을 생성한다.
            inPacket = new DatagramPacket(inMsg, inMsg.length);

            // 패킷을 통해 데이터를 수신(receive)한다.
            socket.receive(inPacket);

            // 수신한 패킷으로 부터 client의 IP주소와 Port를 얻는다.
            InetAddress address = inPacket.getAddress();
            int port = inPacket.getPort();

            // 서버의 현재 시간을 시분초 형태([hh:mm:ss])로 반환한다.
            SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss]");
            String time = sdf.format(new Date());
            outMsg = time.getBytes(); // time을 byte배열로 반환한다.

            // 패킷을 생성해서 client에게 전송(send)한다.
            outPacket = new DatagramPacket(outMsg, outMsg.length, address, port);
            socket.send(outPacket);
        }
    }

    public static void main(String[] args){
        try {
            // UDP서버를 실행시킨다.
            new Network01_Ex16().start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
