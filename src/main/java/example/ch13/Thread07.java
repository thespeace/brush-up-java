package example.ch13;

/**
 *    - 데몬 쓰레드(deamon thread)
 *
 *      일반 쓰레드(non-daemon thread)의 작업을 돕는 보조적인 역할을 수행.
 *      일반 쓰레드가 모두 종료되면 자동적으로 종료된다.
 *      가비지 컬렉터, 자동저장, 화면 자동갱신 등에 사용된다.
 *      무한루프와 조건문을 이용해서 실행 후 대기하다가 특정조건이 만족되면 작업을 수행하고 다시 대기하도록 작성한다.
 *
 *      {@code - 무란루프와 조건문을 이용 해서 Thread를 deamon thread로 만드는 코드.
 *          public void run() {
 *              while(true) {
 *                  try {
 *                      Thread.sleep(3 * 1000); // 3초마다
 *                  } catch(InterruptedException e) { }
 *
 *                  // autoSave의 값이 true이면 autoSave()를 호출한다.
 *                  if(autoSave) {
 *                      autoSave();
 *                  }
 *              }
 *          }
 *      }
 *
 *      {@code - daemon thread 메서드.
 *          boolean isDaemon() : 쓰레드가 데몬 쓰레드인지 확인한다. 데몬 쓰레드이면 ture를 반환.
 *          void setDaemon(boolean on) : 쓰레드를 데몬 쓰레드로 또는 사용자 쓰레드로 변경.
 *                                       매개변수 on을 ture로 지정하면 데몬 쓰레드가 된다.
 *          //setDaemon(boolean on)은 반드시 start()를 호출하기 전에 실행되어야 한다.
 *          // 그렇지 않으면 IllegalThreadStateException이 발생한다.
 *      }
 */

class Thread07 implements Runnable  { // Runnable을 구현, 해당 클래스에 run()메서드가 작성되어 있다는 뜻.
    static boolean autoSave = false;

    public static void main(String[] args) {
        Thread t = new Thread(new Thread07()); // 생성자를 호출할 때, Runnable 인터페이스를 구현한 클래스 객체를 넣어 주어야 한다.
        t.setDaemon(true);		// 데몬쓰레드로 설정, 이 부분이 없으면 종료되지 않는다.
        t.start();

        for(int i=1; i <= 10; i++) {
            try{
                Thread.sleep(1000);
            } catch(InterruptedException e) {}
            System.out.println(i);

            if(i==5) autoSave = true;
        }

        System.out.println("프로그램을 종료합니다.");
    }

    public void run() {
        while(true) { //무한루프일지라도 main쓰레드(일반쓰레드)가 종료가 되면 같이 종료된다.
            try {
                Thread.sleep(3 * 1000); // 3초마다 확인-
            } catch(InterruptedException e) {}

            // autoSave의 값이 true이면 autoSave()를 호출.
            if(autoSave) autoSave();
        }
    }

    public void autoSave() {
        System.out.println("작업파일이 자동저장되었습니다.");
    }
}

/**
 *    - 쓰레드의 상태
 *
 *      NEW           : 쓰레드가 생성되고 아직 start()가 호출되지 않은 상태.
 *      RUNNABLE      : 실행 중 또는 실행 가능한 상태.
 *      BLOCKED       : 동기화블럭에 의해서 일시정지된 상태(lock이 풀릴 때까지 기다리는 상태)
 *      WAITING,
 *      TIMED_WAITING : 쓰레드의 작업이 종료되지는 않았지만 실행가능하지 않은(unrunnable) 일시정지상태, TIMED_WAITING은 일시정지 시간이 지정된 경우를 의미.
 *      TERMINATED    : 쓰레드의 작업이 종료된 상태.
 *
 *      쓰레드가 생성(NEW)되고 start()를 하게 되면 이미 실행되고 있는 쓰레드가 있다면 줄을 서서 자신의 차례를 기다렸다가 수행을 하고 다시 맨 뒤로 줄을 서고 실행을 반복하게 된다.
 *      이를 RUNNABLE(실행, 실행대기)라고 한다. 그리고 자신의 할 일을 다 끝마쳤거나 stop()메서드를 만난다면 소멸(TERMINATED) 된다.
 *      이러한 과정 중, 작업을 하다가 잠깐 잠깐 멈추는 과정을 일시정지(WAITING, BLOCK)이라고 한다.
 *
 *
 *    - 쓰레드의 실행제어
 *      쓰레드의 실행을 제어할 수 있는 메서드가 제공된다.
 *      이 들을 활용해서 보다 효율적인 프로그램의 작성을 할 수 있다.
 *
 *      static void sleep(long millis)
 *      static void sleep(long millis, int nanos)  : 지정된 시간(천분의 일초 단위)동안 쓰레드를 일시정지(잠들게)시킨다. 지정한 시간이 지나고 나면, 자동적으로 다시 실행대기상태가 된다.
 *
 *      void join()
 *      void join(long millis)
 *      void join(long millis, int nanos) : 다른 쓰레드 기다리기, 지정된 시간동안 쓰레드가 실행되도록 한다. 지정된 시간이 지나거나 작업이 종료되면 join()을 호출한 쓰레드로 다시 돌아와 실행을 계속한다.
 *
 *      void interrupt() : 쓰레드 깨우기, sleep()이나 join()에 의해 일시정지상태인 쓰레드를 깨워서 실행대기상태로 만든다. 해당 쓰레드에서는 interrupted Exception이 발생함으로써 일시정지 상태를 벗어나게 된다.
 *
 *      void stop() : 쓰레드를 즉시 종료시킨다.
 *
 *      void suspend() : 쓰레드를 일시정지시킨다. resume()을 호출하면 다시 실행대기상태가 된다.
 *
 *      void resume() : suspend()에 의해 일시정지상태에 있는 쓰레드를 실행대기상태로 만든다.
 *
 *      static void yield() : 실행 중에 자신에게 주어진 실행시간을 다른 쓰레드에게 양보(yield)하고 자신은 실행대기상태가 된다.
 *
 *      * static 메서드가 붙은 메서드는 쓰레드 자기 자신에게만 호출, 적용 가능.
 */