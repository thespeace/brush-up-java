package example.ch13;

/**
 *    - main 쓰레드.
 *      main메서드의 코드를 수행하는 쓰레드.
 *      Java 인터프리터가 해당 클래스의 main메서드를 호출 -> Call Stack 생성 후, 쓰레드가 메인메서드의 코드를 순서대로 실행.
 *      쓰레드는 '사용자 쓰레드'와 '데몬 쓰레드'(사용자 쓰레드를 보조해주는 쓰레드) 두 종류가 있다.
 *
 *          *** 실행 중인 사용자 쓰레드가 하나도 없을 때 프로그램은 종료된다. ***
 *          즉, 메인쓰레드가 종료되었다하더라도 다른 쓰레드가 실행중이라면 프로그램은 종료되지 않는다.
 *
 */

//예제, 두 개의 쓰레드를 만들어서 실행시키고, 시간을 재는 예제.
public class Thread03 {
    static long startTime = 0;
    public static void main(String[] args){
        ThreadEx2_1 th1 = new ThreadEx2_1();
        ThreadEx2_2 th2 = new ThreadEx2_2();
        th1.start();
        th2.start();
        startTime = System.currentTimeMillis();

        /*try{            // join() : 이 메서드는 다른 쓰레드가 하는일을 기다린다.
            th1.join(); // main쓰레드가 th1의 작업이 끝날 때까지 기다린다.
            th2.join(); // main쓰레드가 th2의 작업이 끝날 때까지 기다린다.
        }catch (InterruptedException e){ }*/

        System.out.println("소요시간 : " + (System.currentTimeMillis() - startTime));
    }
}

class ThreadEx2_1 extends Thread {
    public void run() {
        for(int i=0; i < 300; i ++)
            System.out.print(new String("-")); // 가로 작대기를 출력.
    }
}

class ThreadEx2_2 extends Thread {
    public void run() {
        for(int i=0; i < 300; i ++)
            System.out.print(new String("|")); // 세로 작대기를 출력.
    }
}