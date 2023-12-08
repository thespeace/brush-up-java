package example.ch16;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *      - 여러 개의 쓰레드를 생성해서 클라이언트의 요청을 동시에 처리하도록 한 예제.
 *
 *      - 서버에 접속하는 클라이언트의 수가 많을 때는 쓰레드를 이용해서 클라이언트의 요청을 병렬적으로 처리하는 것이 좋다.
 *        그렇지 않으면 서버가 접속을 요청한 순서대로 처리하기 때문에 늦게 접속을 요청한 클라이언트는 오랜 시간을 기다릴 수 있다.
 */
public class Network01_Ex10 implements Runnable{
    ServerSocket serverSocket;
    Thread[] threadArr;

    public static void main(String[] args) throws Exception {
        // 5개의 쓰레드를 생성하는 서버를 생성한다.
        Network01_Ex10 server = new Network01_Ex10(5);
        server.start();
    }

    public Network01_Ex10(int num) {
        try {
            // 서버소켓을 생성하여 7777번 포트와 결합(bind) 시킨다.
            serverSocket = new ServerSocket(7777);
            System.out.println(getTime() + "서버가 준비되었습니다.");

            threadArr = new Thread[num];
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        for(int i = 0; i < threadArr.length; i++) {
            threadArr[i] = new Thread(this);
            threadArr[i].start();
        }
    }

    public void run(){
        while(true) {
            try {
                System.out.println(getTime() + "연결요청을 기다립니다.");

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
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 현재시간을 문자열로 반환하는 함수.
    static String getTime() {
        SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
        return f.format(new Date());
    }
}
