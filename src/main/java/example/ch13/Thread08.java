package example.ch13;

/**
 *    - sleep()
 *      현재 쓰레드를 지정된 시간동안 멈추게 한다.
 *      sleep()은 static메서드여서 항상 현재 쓰레드에 대해서 동작을 한다.
 *          +Thread 실행제어 메서드 중 static 메서드는 ? 1.sleep(), 2.yield()
 *           해당 메서드들은 자기 자신에게만 동작한다!
 *
 *      {@code
 *          static void sleep(long millis)              // 천분의 일초 단위.
 *          static void sleep(long millis, int nanos)   // 천분의 일초(10의 -3제곱) + 나노초(10의 -9제곱).
 *      }
 *
 *      예외처리를 해야 한다.(InterruptedException이 발생하면 깨어남)
 *      {@code
 *          try{
 *              Thread.sleep(1, 500000); // 쓰레드를 0.0015초 동안 멈추게 한다.
 *          } catch(InterruptedException e) { } // Exception의 자손, 예외 처리가 필수이다.
 *      }
 *          + 쓰레드를 깨우는 방법 : 1.time up : 시간종료
 *                               2.Interrupted : 깨우는 것, 예외와 try-catch문을 활용해서 잠자는 상태를 벗어나게 만들어 놓은 것.(지극히 정상)
 *
 *      항상 예외 처리를 해주어야 하니, 따로 메소드 생성하여 흔히 사용한다.
 *      {@code
 *          void delay(long millis) {
 *              try{
 *                  Thread.sleep(millis);
 *              } catch(InterruptedException e) { } // { }안에는 아무것도 작성안해도 된다.
 *          }
 *      }
 *
 *      특정 쓰레드를 지정해서 멈추게 하는 것은 불가능하다.
 *      {@code
 *          try{
 *              th1.sleep(2000);    // OK. 하지만 원레 자기자신만 잠자게 할 수 있는 것을 다른 쓰레드를 잠재우는 것처럼 오해할 수 있기때문에-
 *            //Thread.sleep(2000); // 참조변수보다는 주석된 이 코드처럼 클래스이름을 작성해야 한다.
 *          }catch(InterruptedException e) { }
 *      }
 */

public class Thread08{
    public static void main(String[] args) {
        ThreadEx8_1 th1 = new ThreadEx8_1();
        ThreadEx8_2 th2 = new ThreadEx8_2();
        th1.start(); th2.start();

        try {
//            th1.sleep(2000); // th1을 2초동안 잠자게 하는 것이 맞는가? NO. 해당 코드를 실행하는 Main Thread가 잠는다.
            Thread.sleep(2000);
        } catch(InterruptedException e) {}

        delay(2*1000); // 매번 예외처리를 하는것보다 깔끔해졌다.

        System.out.print("<<main 종료>>");
    }

    static void delay(long millis){
        try {
            Thread.sleep(millis);
        } catch(InterruptedException e) {}
    }
}
class ThreadEx8_1 extends Thread {
    public void run() {
        for(int i=0; i < 300; i++) System.out.print("-");
        System.out.print("<<th1 종료>>");
    } // run()
}

class ThreadEx8_2 extends Thread {
    public void run() {
        for(int i=0; i < 300; i++) System.out.print("|");
        System.out.print("<<th2 종료>>");
    } // run()
}