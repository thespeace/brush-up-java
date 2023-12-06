package example.ch16;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *      - 간단한 TCP/IP서버를 구현한 예제.
 *
 *      - 이 예제를 실행하면 서버소켓이 7777번 포트에서 클라이언트 프로그램의 연결요청을 기다린다.
 *        클라이언트의 요청이 올 때까지 진행을 멈추고 계속 기다린다. 그러다가 클라이언트 프로그램이 서버에 연결을 요청하면-
 *        서버소켓은 새로운 소켓을 생성하여 클라이언트 프로그램의 소켓(원격소켓)과 연결한다.
 *
 *      - 새로 생성된 소켓은 "[Notice] Test Message1 from Server."라는 데이터를 원격소켓에 전송하고 연결을 종료한다. 그리고 서버소켓은 다시 클라이언트 프로그램의 요청을 기다린다.
 */
public class Network01_Ex06 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = null;

        try {
            // 서버소켓을 생성하여 7777번 포트와 결합(bind)시킨다.
            serverSocket = new ServerSocket(7777);
            System.out.println(getTime() + "서버가 준비되었습니다.");
        } catch (IOException e) { e.printStackTrace(); }

        while(true) {
            try {
                System.out.println(getTime() + "연결요청을 기다립니다.");
                // 서버소켓은 클라이언트의 연결요청이 올 때까지 실행을 멈추고 계속 기다린다.
                // 클라이언트의 연결요청이 오면 클라이언트 소켓과 통신할 새로운 소켓을 생성한다.
                Socket socket = serverSocket.accept();
                System.out.println(getTime() + socket.getInetAddress() + "로부터 연결요청이 들어왔습니다.");

                // 소켓의 출력스트림을 얻는다.
                OutputStream out = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(out);

                // 원격 소켓(remote socket)에 데이터를 보낸다.
                dos.writeUTF("[Notice] Test Message1 from Server.");
                System.out.println(getTime() + "데이터를 전송했습니다.");

                // 스트림과 소켓을 닫아준다.
                dos.close();
                socket.close();
            } catch (IOException e) { e.printStackTrace(); }
        }
    }

    static String getTime() {
        SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
        return f.format(new Date());
    }
}
