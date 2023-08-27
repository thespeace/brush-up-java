package example.ch13;

import javax.swing.JOptionPane;

/**
 *    - interrupt()
 *      대기상태(WAITING)인 쓰레드를 실행대기 상태(RUNNABLE)로 만든다.
 *          ex) 대기상태(sleep(),join(),wait()) -> interrupt()로 깨운다.
 *
 *          void interrupt()             : 쓰레드의 interrupted상태를 false에서 true로 변경.
 *          boolean isInterrupted()      : 쓰레드의 interrupted상태를 반환.
 *          static boolean interrupted() : 현재 쓰레드의 interrupted상태를 알려주고, false로 초기화.
 *
 *      {@code : Thread 클래스를 알기 쉽게 변경한 코드.
 *          class Thread {
 *                  ...
 *              boolean interrupted = false; // Thread가 interrupted인 상태인지를 저장하는 변수.
 *                  ...
 *              boolean isInterrupted() {
 *                  return interrupted;
 *              }
 *
 *              boolean interrupt() {        // 호출 시, true로 변경.
 *                  interrupted = true;
 *              }
 *          }
 *      }
 *
 *      {@code : 메소드 사용 예시.
 *          public static void main(String[] args) {
 *              ThreadEx th1 = new ThreadEx();
 *              th1.start();
 *                  ...
 *              th1.interrupt(); // interrupt()를 호출하면, interrupted상태가 true가 된다.
 *                  ...
 *              System.out.println("isInterrupted() : " + th1.isInterrupted()); // true.
 *          }
 *      }
 *
 *      {@code : interrupt()메서드 사용 예시.
 *          class Thread extends Thread {
 *              public void run() {
 *                  ...
 *                  while( downloaded && !isInterrupted())
 *                      // downloaded를 실행한다.
 *                  }
 *
 *                  System.out.println("다운로드가 끝났습니다.");
 *              }
 *              // 다운로드가 진행중일 때, 사용자가 [취소] 버튼을 누르면 interrupt() 메서드가 실행, while문의 조건에 부합하여 멈추게 된다.
 *          }
 *      }
 */

public class Thread09 {
    public static void main(String[] args){

        ThreadEx9_1 th1 = new ThreadEx9_1();
        th1.start();

        System.out.println("isInterrupted():"+ th1.isInterrupted()); // false

        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("입력하신 값은 " + input + "입니다.");
        th1.interrupt();  // interrupt()를 호출하면, interrupted상태가 true가 된다.
        System.out.println("isInterrupted():"+ th1.isInterrupted()); // true

        //main쓰레드가 interrupt되었는지 확인.
        System.out.println("interrupted():"+ Thread.interrupted()); // false, main Thread는 interrupt 한적이 없기때문에 false!

    }
}

class ThreadEx9_1 extends Thread { // 카운트 다운.
    public void run() {
        int i = 10;

        while(i!=0 && !isInterrupted()) {
            System.out.println(i--);
            for(long x=0;x<2500000000L;x++); // 시간 지연
        }

        System.out.println("ThreadEx9_1.isInterrupted():"+ this.isInterrupted()); // true.
        System.out.println("ThreadEx9_1.interrupted():"+ Thread.interrupted()); // true.
        System.out.println("ThreadEx9_1.interrupted():"+ Thread.interrupted()); // false, 바로 위 코드에서 확인한 후, 상태변수 interrupted를 false로 초기화.

        System.out.println("카운트가 종료되었습니다.");
    }
}
