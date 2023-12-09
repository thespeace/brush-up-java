package example.ch16;

import java.net.*;
import java.io.*;
import java.util.Scanner;


/**
 *      - 소켓으로 데이터를 송신하는 작업과 수신하는 작업을 별도의 쓰레드 Sender와 Receiver가 처리하도록 하여 송신과 수신이 동시에 이루어지도록 하는 예제.
 *
 *      - 해당 클래스는 서버 프로그램이다.
 *        아래의 클래스는 클라이언트 프로그램.
 *        @see Network01_Ex12
 */
public class Network01_Ex11{
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // 서버소켓을 생성하여 7777번 포트와 결합(bind)시킨다.
            serverSocket = new ServerSocket(7777);
            System.out.println("서버가 준비되었습니다.");

            socket = serverSocket.accept();

            Sender sender = new Sender(socket);
            Receiver receiver = new Receiver(socket);

            sender.start();
            receiver.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Sender extends Thread {
    Socket socket;
    DataOutputStream out;
    String name;

    Sender(Socket socket) {
        this.socket = socket;
        try {
            out = new DataOutputStream(socket.getOutputStream());
            name = "[" + socket.getInetAddress() + ":" + socket.getPort() + "]";
        } catch (Exception e) {}
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while(out != null) {
            try {
                out.writeUTF(name + scanner.nextLine());
            } catch (IOException e) { }
        }
    }
}

class Receiver extends Thread {
    Socket socket;
    DataInputStream in;

    Receiver(Socket socket) {
        this.socket = socket;
        try {
            in = new DataInputStream(socket.getInputStream());
        } catch (IOException e) { e.printStackTrace(); }
    }
    public void run(){
        while(in != null) {
            try {
                System.out.println(in.readUTF());
            } catch (IOException e) { }
        }
    }
}
