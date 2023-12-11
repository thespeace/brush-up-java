package example.ch16;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 *      - 여러 클라이언트가 서버에 접속해서 채팅을 할 수 있는 멀티채팅서버 프로그램을 구현한 예제.
 *
 *      - 해당 클래스는 클라이언트 프로그램이다.
 *        아래의 클래스는 서버 프로그램이다.
 *        @see Network01_Ex13
 */

public class Network01_Ex14 {
    public static void main(String args[]){
        if(args.length!=1){
            System.out.println("USAGE : java Network01_Ex14 대화명");
            System.exit(0);
        }

        try {
            String serverIp = "127.0.0.1";
            // 소켓을 생성하여 연결을 요청한다.
            Socket socket = new Socket(serverIp, 7777);
            System.out.println("서버에 연결되었습니다.");
            Thread sender = new Thread(new ClientSender(socket, args[0]));
            Thread receiver = new Thread(new ClientReceiver(socket));
        } catch (ConnectException ce) {
            ce.printStackTrace();
        } catch (Exception e) {}
    }

    static class ClientSender extends Thread {
        Socket socket;
        DataOutputStream out;
        String name;

        ClientSender(Socket socket, String name) {
            this.socket = socket;
            try {
                out = new DataOutputStream(socket.getOutputStream());
                this.name = name;
            } catch(Exception e) {}
        }

        public void run() {
            Scanner scanner = new Scanner(System.in);
            try {
                if(out != null) {
                    out.writeUTF(name);
                }
                while(out != null)
                    out.writeUTF("[" + name + "]" + scanner.nextLine());
            } catch (IOException e) {}
        }
    }

    static class ClientReceiver extends Thread {
        Socket socket;
        DataInputStream in;

        ClientReceiver(Socket socket) {
            this.socket = socket;
            try {
                in = new DataInputStream(socket.getInputStream());
            } catch (IOException e) {}
        }

        public void run() {
            while(in != null) {
                try {
                    System.out.println(in.readUTF());
                } catch (IOException e) {}
            }
        }
    }
}
