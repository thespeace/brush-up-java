package example.ch16;

import java.io.*;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *      @see Network01_Ex06
 *      - 이 예제는 위의 이전 예제인 TCP/IP와 통신하기 위한 클라이언트 프로그램이다.
 *        연결하고자 하는 서버의 IP와 포트번호를 가지고 소켓을 생성하면 자동적으로 서버에 연결요청을 하게 된다.
 */
public class Network01_Ex07 {
    public static void main(String[] args) throws Exception {
        try {
            String serverIp = "127.0.0.1";

            System.out.println("서버에 연결중입니다. 서버IP : " + serverIp);

            // 소켓을 생성하여 연결을 요청한다.
            Socket socket = new Socket(serverIp, 7777);

            // 소켓의 입력스트림을 얻는다.
            InputStream in = socket.getInputStream();
            DataInputStream dis = new DataInputStream(in);

            // 소켓으로 부터 받은 데이터를 출력한다.
            System.out.println("서버로부터 받은 메시지 : " + dis.readUTF());
            System.out.println("연결을 종료합니다.");

            // 스트림과 소켓을 닫는다.
            dis.close();
            socket.close();
            System.out.println("연결이 종료되었습니다.");
        } catch (ConnectException ce) { // 서버프로그램이 실행되고 있지 않거나 서버의 전원이 꺼져있어서 서버와 연결을 실패하면 해당 예외가 발생한다.
            ce.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
