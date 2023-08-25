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