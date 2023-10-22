package example.ch15;

import java.io.*;

/**
 *      - 두 쓰레드가 PipedReader/PipedWriter를 이용해서 서로 메시지를 주고받는 예제.
 */
public class InputOutput05_Ex03 {
    public static void main(String[] args){
        InputThread inThread = new InputThread("InputThread");
        OutputThread outThread = new OutputThread("OutputThread");

        //PipedReader와 PipedWriter를 연결한다. 쓰레드를 시작하기 전에 PipedReader와 PipedWriter를 연결해야 한다는 것에 유의!
        inThread.connect(outThread.getOutput());

        inThread.start();
        outThread.start();

    }
}
class InputThread extends Thread {
    PipedReader  input = new PipedReader();
    StringWriter sw    = new StringWriter(); // StringWriter는 CharArrayWriter처럼 메모리를 사용하는 스트림으로
                                             // 내부적으로 String Buffer를 가지고 있어서 출력하는 내용이 여기에 저장된다.
    InputThread(String name) {
        super(name);    // Thread(String name);
    }

    public void run() {
        try {
            int data = 0;

            while((data=input.read()) != -1){
                sw.write(data);
            }
            System.out.println(getName() + " received : " + sw.toString());
        } catch (IOException e) { };
    }

    public PipedReader getInput() {
        return input;
    }

    public void connect(PipedWriter output) {
        try{
            input.connect(output);
        }catch(IOException e) { };
    }
}

class OutputThread extends Thread{
    PipedWriter output = new PipedWriter();
    OutputThread(String name){
        super(name);    // Thread(String name);
    }
    public void run() {
        try{
            String msg = "Hello";
            System.out.println(getName() + " sent : " + msg);
            output.write(msg);
            output.close();
        }catch (IOException e) { };
    }

    public PipedWriter getOutput() {
        return output;
    }

    public void connect(PipedReader input) {
        try{
            output.connect(input);
        }catch (IOException e) { };
    }
}