package example.ch13;

/**
 *    - suspend(), resume(), stop()
 *      쓰레드의 실행을 일시정지, 재개, 완전정지 시킨다.
 *
 *          void suspend() : 쓰레드를 일시정지 시킨다.
 *          void resume()  : suspend()에 의해 일시정지된 쓰레드를 실행대기상태로 만든다.
 *          void stop()    : 쓰레드를 즉시 종료시킨다.
 *
 *      해당 메서드들은 사용시 편리하지만, dead-lock(교착상태)를 일으킬 가능성이 있기때문에 deprecated(사용 권장하지 않음)되었다.
 *          + dead-lock ? 서로 다른 두 Thread가 자신에게 필요한 것들을 다른 쪽이 갖고 있어서 진행이 되지 않는 상태를 일컫는다.
 *
 *      {@code : 직접 구현해서 사용하기도 한다. 해당 예시는 간단하게 작성.
 *          class ThreadEx implements Runnable {
 *              boolean suspended = false; // 일시정지 상태? 변수.
 *              boolean stopped   = false; // 정지 상태? 변수.
 *
 *              public void run() {
 *                  while(!stopped) {
 *                      if(!suspended) {
 *                          쓰레드가 수행할 코드를 작성.
 *                      }
 *                  }
 *              }
 *              public void suspend() { suspended = true; }  //
 *              public void resume()  { suspended = false; } //
 *              public void stop()    { stopped = true; }
 *          }
 *      }
 */

public class Thread10 {
    public static void main(String[] args){

        MyThread th1 = new MyThread("*");
        MyThread th2 = new MyThread("**");
        MyThread th3 = new MyThread("***");
        th1.start();
        th2.start();
        th3.start();

        try {
            Thread.sleep(2000);
            th1.suspend();	// 쓰레드 th1을 잠시 중단시킨다.
            Thread.sleep(2000);
            th2.suspend();
            Thread.sleep(3000);
            th1.resume();	// 쓰레드 th1이 다시 동작하도록 한다.
            Thread.sleep(3000);
            th1.stop();		// 쓰레드 th1을 강제종료시킨다.
            th2.stop();
            Thread.sleep(2000);
            th3.stop();
        } catch (InterruptedException e) {}
    }
}

class MyThread implements Runnable {

    volatile boolean suspended = false; // 일시정지 상태? 변수.
    volatile boolean stopped   = false; // 정지 상태? 변수.
    // volatile ? 쉽게 바뀌는 변수를 체크할 때, 컴퓨터 프로세스상 복사본을 미리 준비해두고 빠르게 실행하려는 특성을 허용하지 않고 그때그때마다 확인 하라고 표시하는 것.(복사본 허용X)

    Thread th;

    MyThread(String name){
        th = new Thread(this, name); // Thread(Runnable r, String name)
    }

    void start(){ th.start(); }
    void stop(){ stopped = true; }
    void suspend(){ suspended = true; }
    void resume(){ suspended = false; }

    public void run() {
        while(!stopped) {
            if(!suspended){
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch(InterruptedException e) {}
            }
        }
    } // run()

}
