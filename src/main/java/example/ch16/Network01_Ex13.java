package example.ch16;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 *      - 여러 클라이언트가 서버에 접속해서 채팅을 할 수 있는 멀티채팅서버 프로그램을 구현한 예제.
 *
 *      - 해당 클래스는 서버 프로그램이다.
 *        아래의 클래스는 클라이언트 프로그램이다.
 *        @see Network01_Ex14
 */
public class Network01_Ex13 {
    HashMap clients;

    Network01_Ex13() {
        clients = new HashMap();
        Collections.synchronizedMap(clients);
    }

    public void start() {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(7777);
            System.out.println("서버가 시작되었습니다.");

            while(true) {
                socket = serverSocket.accept();
                System.out.println("[" + socket.getInetAddress() + ":" + socket.getPort() + "]" +"에서 접속하였습니다.");
                ServerReceiver thread = new ServerReceiver(socket);
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void sendToAll(String msg) {
        Iterator it = clients.keySet().iterator();

        while(it.hasNext()) {
            try {
                DataOutputStream out = (DataOutputStream) clients.get(it.next());
                out.writeUTF(msg);
            } catch (IOException e) { }
        }
    }

    public static void main(String args[]) {
        new Network01_Ex13().start();
    }

    class ServerReceiver extends Thread {
        Socket socket;
        DataInputStream in;
        DataOutputStream out;

        ServerReceiver(Socket socket){
            this.socket = socket;
            try {
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) { }
        }

        public void run() {
            String name = "";

            try {
                name = in.readUTF();
                sendToAll("#"+name+"님이 들어오셨습니다.");

                clients.put(name, out);
                System.out.println("현재 서버접속자 수는 " + clients.size() + "입니다.");

                while(in!=null) {
                    sendToAll(in.readUTF());
                }
            } catch (IOException e) {
                // ignore
            } finally {
                sendToAll("#"+name+"님이 나가셨습니다.");
                clients.remove(name);
                System.out.println("["+socket.getInetAddress()+":"+socket.getPort()+"]"+"에서 접속을 종료하였습니다.");
                System.out.println("현재 서버접속자 수는 " + clients.size() + "입니다.");
            }
        }
    }

}
