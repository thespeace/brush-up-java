package example.ch13;

/**
 *    - join()
 *      지정된 시간동안 특정 쓰레드가 작업하는 것을 기다린다.
 *
 *          void join()                         : 작업이 모두 끝날 때까지.
 *          void join(long millis)              : 천분의 일초 동안.
 *          void join(long millis,int nanos)    : 천분의 일초 + 나노초 동안.
 *
 *      예외처리를 해야 한다.(InterruptedException이 발생하면 작업 재개)
 *      {@code
 *          public static void main(String args[]) {
 *              ThreadEx_1 th1 = new ThreadEx_1();
 *              ThreadEx_2 th2 = new ThreadEx_2();
 *              th1.start();
 *              th2.start();
 *              startTime = System.currentTimeMillis();
 *
 *              try {
 *                  th1.join(); // main쓰레드가 th1의 작업이 끝날 때까지 기다린다.
 *                  th2.join(); // main쓰레드가 th2의 작업이 끝날 때까지 기다린다.
 *              } catch(InterruptedException e) { }
 *
 *              System.out.print("소요시간 : " + (System.currentTimeMillis() - ThreadEx.startTime());
 *          }
 *      }
 *
 *
 *      {@code : join() 예시 케이스.
 *          public void run() {
 *              while(true){ // daemon Thread, 일반쓰레드가 없으면 자동 종료.
 *                  try{
 *                      Thread.sleep(10 * 1000); // 10초를 기다린다.
 *                  }catch(InterruptedException e){
 *                      System.out.println("Awaken by interrupt().");
 *                  }
 *                  gc(); // garbage collection을 수행한다. 사용하지 않는 객체 제거.
 *                  System.out.println("Garbage Collected. Free Memory : " + freeMemory());
 *              }
 *          }
 *
 *          for(int i = 0; i < 20; i++) {
 *              requiredMemory = (int)(Math.random() * 10) * 20;
 *              //필요한 메모리가 사용할 수 있는 양보다 적거나 전체 메모리의 60%이상 사용했을 경우 gc를 깨운다.
 *              if(gc.freeMemory() < requiredMemory ||
 *                 gc.freeMemory() < gc.totalMemory() * 0.4) // 1_1.메모리가 부족한 경우 -
 *                 {
 *                     gc.interrupt(); // 잠자고 있는 쓰레드 gc를 깨운다.
 *
 *                     try{
 *                         gc.join(100); // 1_2.gc가 작업할 시간을 줘야한다.
 *                     } catch(InterruptedException e) {}
 *                 }
 *              gc.usedMemory += requiredMemory; // 2.메모리 사용.
 *              System.out.println("usedMemory : " + gc.usedMemory);
 *          }
 *      }
 */

public class Thread11 {
    static long startTime = 0;

    public static void main(String[] args) {
        ThreadEx11_1 th1 = new ThreadEx11_1();
        ThreadEx11_2 th2 = new ThreadEx11_2();
        th1.start();
        th2.start();
        startTime = System.currentTimeMillis(); //시작 시간.

        try {
            th1.join();	// main쓰레드가 th1의 작업이 끝날 때까지 기다린다.
            th2.join();	// main쓰레드가 th2의 작업이 끝날 때까지 기다린다.
        } catch(InterruptedException e) {}

        System.out.print("소요시간:" + (System.currentTimeMillis() - Thread11.startTime)); // 시작 시간 - 종료 시간.
    }
}

class ThreadEx11_1 extends Thread {
    public void run() {
        for(int i=0; i < 300; i++) {
            System.out.print(new String("-"));
        }
    } // run()
}

class ThreadEx11_2 extends Thread {
    public void run() {
        for(int i=0; i < 300; i++) {
            System.out.print(new String("|"));
        }
    } // run()
}