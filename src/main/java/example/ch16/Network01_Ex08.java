package example.ch16;

import java.io.*;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *      - Socket클래스에 정의된 getPort()와 getLocalPort()를 사용해서 TCP/IP통신에서 소켓이 사용하고 있는 포트를 알아낼 수 있다.
 *        getPort()가 반환하는 값은 상대편 소켓(원격 소켓)이 사용하는 포트이고 getLocalPort()가 반환하는 값은 소켓 자신이 사용하는 포트이다.
 *
 *      - 해당 예제를 실행해보면 서버소켓이 7777번 포트를 사용하고 있어도, 서버소켓이 아닌 소켓은 7777번 포트를 사용할 수 있다는 것이다.
 *        클라이언트 프로그램의 소켓이 사용하는 포트는 사용가능한 임의의 포트가 선택된다.
 */
public class Network01_Ex08 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = null;

        try {
            // 서버소켓을 생성하여 7777번 포트와 결합(bind) 시킨다.
            serverSocket = new ServerSocket(7777);
            System.out.println(getTime() + "서버가 준비되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(true) {
            try {
                System.out.println(getTime() + "연결요청을 기다립니다.");
                Socket socket = serverSocket.accept();
                System.out.println(getTime() + socket.getInetAddress() + "로부터 연결요청이 들어왔습니다.");

                System.out.println("getPort() : " + socket.getPort());
                System.out.println("getLocalPort() : " + socket.getLocalPort());

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

    // 현재시간을 문자열로 반환하는 함수.
    static String getTime() {
        SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
        return f.format(new Date());
    }
}
