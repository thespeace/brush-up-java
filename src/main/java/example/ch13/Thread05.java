package example.ch13;

import javax.swing.*;

public class Thread05 {
    public static void main(String[] args) throws Exception{
        /**
         *    - 쓰레드의 I/O 블락킹(blocking)
         *      쓰레드는 입출력시 작업이 중단되어서, 프로그램이 정지(멈추는) 상태가 되는 것을 뜻한다.
         *
         *    - 멀티쓰레드의 장점
         *      어떠한 한 작업이 수행되는 동안 다른 외부적인 요인에 의해서 멈춰있을 때에도 다른 쓰레드가 작업을 수행할 수 있어서 보다 효율적이고 빠른 프로그램을 만들 수 있다.
         *      I/O 블락킹(blocking)이 발생한 경우-
         *          싱글 쓰레드를 사용하면 아무 일도 하지 않고 기다려야 하는데-
         *          멀티 쓰레드를 사용한다면 만약 A작업이 수행되다가 I/O blocking이 발생했다면 이를 낭비하지않고 다른 쓰레드의 B작업을 수행하여-
         *          자원을 더 효율적으로 사용할 수 있고, 프로그램 소요시간을 줄일 수 있다.
         *      쉽게 풀어 설명하자면, cpu는 입출력속도가 굉장히 빠른데에 비해 다른 기기들을 file,print 등등과 입출력을 계속 수행하게 되는데, 그런 기기들은 cpu에 비해 상당히 느리기 때문에 cpu가 놀게 된다.
         *      그런 경우 멀티 쓰레드로 프로그래밍을 하면, 우리가 작성한 프로그램이 I/O때문에 지연되는 시간동안 다른 일들을 할 수 있기 때문에 더 효율적이고 빠르게 동작하게 되는 것이다.
         */

        System.out.println("=================Single Thread=================");
        String single_Input = JOptionPane.showInputDialog("아무 값이나 입력하세요."); // 싱글 쓰레드는 입출력에서 blocking이 발생하면, 다음 작업을 진행하지 못한다.
        System.out.println("입력하신 값은 " + single_Input + "입니다.");

        for(int i = 10; i > 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000); // 1초간 시간을 지연한다.
            }catch (Exception e){ }
        }

        System.out.println("\n\n=================Multi Thread=================");

        ThreadEx5_1 th1 = new ThreadEx5_1();

        th1.start();
        String multi_input = JOptionPane.showInputDialog("아무 값이나 입력하세요."); // 멀티 쓰레드의 장점 : 입력 받는 작업과 출력 작업을 분리, 입력을 하는 동안에 다른 작업 수행 가능.

        System.out.println("입력하신 값은 " + multi_input + "입니다.");
    }
}

class ThreadEx5_1 extends Thread {
    public void run() {
        for(int i=10; i > 0; i--) {
            System.out.println(i);
            try {
                sleep(1000);
            } catch(Exception e ) {}
        }
    }
}