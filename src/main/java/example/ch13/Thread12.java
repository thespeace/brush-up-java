package example.ch13;

public class Thread12 {
    public static void main(String[] args){
        /**
         *    - yield()
         *      남은 시간을 다음 쓰레드에게 양보하고, 자신(현재 쓰레드)은 실행대기한다.
         *      yield()와 interrupt()를 적절히 사용하면, 응답성과 효율을 높일 수 있다.
         *      {@code
         *          class MyThreadEx implements Runnable {
         *              boolean suspended = false;
         *              boolean stopped = false;
         *
         *              Thread th;
         *
         *              MyThreadEx(String name) {
         *                  th = new Thread(this, name);
         *              }
         *
         *              public void run(){
         *                  while(!stopped) {
         *                      if(!suspended){     // false, 일시정지 상태가 되면 while문은 하릴없이 계속 돌게 되는데, 이를 "busy-waiting"이라 한다.
         *                          ...작업수행...
         *                          try{
         *                              Thread.sleep(1000);
         *                          } catch(InterruptedException e) {}
         *                      } else {
         *                          Thread.yield(); // yield()를 사용함으로써 양보, 하지만 OS 스케줄러에게 통보함으로써 반드시 동작한다는 보장은 없다. 큰 차이는 없지만 조금은 빠른편.
         *                      }
         *                  }
         *              }
         *          }
         *      }
         */
    }
}
