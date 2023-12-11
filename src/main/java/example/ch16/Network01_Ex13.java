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

    // 서버 프로그램(Network01_Ex13.java)에서 서버에 접속한 클라이언트(Network01_Ex14)를 HashMap에 저장해서 관리하고 있다.
    // 클라이언트가 멀티채팅서버에 접속하면 HashMap에 저장되고 접속을 해제하면 HashMap에서 제거한다.
    Network01_Ex13() {
        clients = new HashMap();
        Collections.synchronizedMap(clients); // 동기화 처리.
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

    // 클라이언트가 데이터를 입력하면, 멀티채팅서버는 HashMap에 저장된 모든 클라이언트에게 데이터를 전송한다.
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

    // ServerReciver쓰레드는 클라이언트가 추가될 때마다 생성되며 클라이언트의 입력을 서버에 접속된 모든 클라이언트에게 전송하는 일을 한다.
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

                clients.put(name, out); // 클라이언트의 이름을 key로 클라이언트의 출력스트림을 HashMap인 clients에 저장해서 다른 클라이언트가 입력한 데이터를 전송하는데 사용한다.
                System.out.println("현재 서버접속자 수는 " + clients.size() + "입니다.");

                while(in!=null) { // 클라이언트가 종료되어 클라이언트의 입력스트림(in)이 null이 되면 while문을 빠져나가서-
                    sendToAll(in.readUTF());
                }
            } catch (IOException e) {
                // ignore
            } finally {
                sendToAll("#"+name+"님이 나가셨습니다.");
                clients.remove(name); // clients의 목록에서 해당 클라이언트를 제거한다.
                System.out.println("["+socket.getInetAddress()+":"+socket.getPort()+"]"+"에서 접속을 종료하였습니다.");
                System.out.println("현재 서버접속자 수는 " + clients.size() + "입니다.");
            }
        }
    }

}
