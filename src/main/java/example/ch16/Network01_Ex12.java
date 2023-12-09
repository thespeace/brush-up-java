package example.ch16;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

/**
 *      - 소켓으로 데이터를 송신하는 작업과 수신하는 작업을 별도의 쓰레드 Sender와 Receiver가 처리하도록 하여 송신과 수신이 동시에 이루어지도록 하는 예제.
 *
 *      - 해당 클래스는 클라이언트 프로그램이다.
 *        아래의 클래스는 서버 프로그램.
 *        @see Network01_Ex11
 */
public class Network01_Ex12 {
    public static void main(String[] args) throws Exception {
        try {
            String serverIp = "127.0.0.1";
            // 소켓을 생성하여 연결을 요청한다.
            Socket socket = new Socket(serverIp, 7777);

            System.out.println("서버에 연결되었습니다.");
            Sender sender = new Sender(socket);
            Receiver receiver = new Receiver(socket);

            sender.start();
            receiver.start();
        } catch (ConnectException ce) {
            ce.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
