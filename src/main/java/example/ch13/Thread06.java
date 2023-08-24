package example.ch13;

/**
 *    - 쓰레드의 우선순위(priority of thread)
 *      작업의 중요도에 따라 쓰레드의 우선순위를 다르게 하여 특정 쓰레드가 더 많은 작업시간을 갖게 할 수 있다.
 *      자바에서는 JVM으로 쓰레드의 우선순위를 1~10까지 보유할 수 있게 할 수 있고, 높은 숫자가 더 많은 시간과 우선순위를 갖는다.
 *      하지만 윈도우OS의 우선순위는 32단계로 우리가 정한 우선순위는 JVM이 윈도우 스케줄러에게 전하는 희망사항일 뿐이다.(OS에서 실행되고있는 수많은 프로세스와 쓰레드들을 무시할 수 없기때문)
 *      우선수위가 그대로 적용되지는 않지만 확률은 조금 높아진다.
 *
 *      {@code
 *          void setPriority(int newPriority) 쓰레드의 우선순위를 지정한 값으로 변경한다.
 *          int  getPriority()                쓰레드의 우선순위를 반환한다.
 *
 *          public static final int MAX_PRIORITY  = 10  //최대우선순위
 *          public static final int MIN_PRIORITY  = 1   //최소우선순위
 *          public static final int NORM_PRIORITY = 5   //보통우선(default)
 *      }
 */

public class Thread06 {
    public static void main(String[] args){

        ThreadEx6_1 th1 = new ThreadEx6_1();
        ThreadEx6_2 th2 = new ThreadEx6_2();

//        th1.setPriority(5); // default 값이기때문에 우선순위를 주지않으면, 우선순위 5를 가지고 있는 것과 같다.(생략가능)
        th2.setPriority(9);

        System.out.println("Priority of th1(-) : " + th1.getPriority());
        System.out.println("Priority of th2(|) : " + th2.getPriority());
        th1.start();
        th2.start();
    }
}

class ThreadEx6_1 extends Thread {
    public void run() {
        for(int i=0; i < 300; i++) {
            System.out.print("-");
            for(int x=0; x < 10000000; x++); // 시간 지연용 for문.
        }
    }
}

class ThreadEx6_2 extends Thread {
    public void run() {
        for(int i=0; i < 300; i++) {
            System.out.print("|");
            for(int x=0; x < 10000000; x++); // 시간 지연용 for문.
        }
    }
}

/**
 *    - 쓰레드 그룹.
 *      서로 관련된 쓰레드를 그룹으로 묶어서 다루기 위한 것.
 *      모든 쓰레드는 반드시 하나의 쓰레드 그룹에 포함되어 있어야 한다.
 *      쓰레드 그룹을 지정하지 않고 생성한 쓰레드는 'main쓰레드 그룹'에 속한다.
 *      자신을 생성한 쓰레드(부모 쓰레드)의 그룹과 우선순위(5)를 상속받는다.
 *
 *      {@code - 쓰레드의 생성자
 *          Thread(ThreadGroup group, String name)
 *          Thread(ThreadGroup group, Runnable target)
 *          Thread(ThreadGroup group, Runnable target, String name)
 *          Thread(ThreadGroup group, Runnable target, String name, long stackSize)
 *      }
 *
 *      {@code - 관련된 메서드.
 *          ThreadGroup getThreadGroup() Thread.class의 메서드로 쓰레드 자신이 속한 쓰레드 그룹을 반환한다.
 *          void uncaughtException(Thread t, Throwable e) ThreadGroup.class의 메서드로 처리되지 않은 예외에 의해 쓰레드 그룹의 쓰레드가 실행이 종료되었을 때, JVM에 의해 이 메서드가 자동적으로 호출된다.
 *      }
 *
 *
 *
 *    - 쓰레드 그룹의 메서드
 *      ThreadGroup(String name)                           : 지정된 이름의 새로운 쓰레드 그룹을 생성.
 *      ThreadGroup(ThreadGroup parent, String name)       : 지정된 쓰레드 그룹에 포함되는 새로운 쓰레드 그룹을 생성.
 *      int activeCount()                                  : 쓰레드 그룹에 포함된 활성상태(작업중)에 있는 쓰레드의 수를 반환.
 *      int activeGroupCount()                             : 쓰레드 그룹에 포함된 활성상태에 있는 쓰레드 그룹의 수를 반환.
 *      void checkAccess()                                 : 현재 실행중인 쓰레드가 쓰레드 그룹을 변경할 권한이 있는지 체크.
 *      void destroy()                                     : 쓰레드 그룹과 하위 쓰레드 그룹까지 모두 삭제한다. 단, 비어있어야 삭제 가능.
 *      int enumerate(Thread[] list)
 *      int enumerate(Thread[] list, boolean recurse)
 *      int enumerate(ThreadGroup[] list)
 *      int enumerate(ThreadGroup[] list, boolean recurse) : 쓰레드 그룹에 속한 쓰레드 또는 하위 쓰레드 그룹의 목록을 지정된 배열에 담고 그 개수를 반환.
 *                                                           두 번째 매개변수인 recurse의 값을 true로 하면 쓰레드 그룹에 속한 하위 쓰레드 그룹에 쓰레드 또는 쓰레드 그룹까지 배열에 담는다.
 *      int getMaxPriority()                               : 쓰레드 그룹의 최대우선순위르 반환.
 *      String getName()                                   : 쓰레드 그룹의 이름을 반환.
 *      ThreadGroup getParent()                            : 쓰레드 그룹의 상위 쓰레드 그룹을 반환.
 *      void interrupt()                                   : 쓰레드 그룹에 속한 모든 쓰레드를 interrupt.
 *      boolean isDaemon()                                 : 쓰레드 그룹이 데몬 쓰레드 그룹인지 확인.
 *      boolean isDestroyed()                              : 쓰레드 그룹이 삭제되었는지 확인.
 *      void list()                                        : 쓰레드 그룹에 속한 쓰레드와 하위 쓰레드 그룹에 대한 정보를 출력.
 *      boolean parentOf(ThreadGroup g)                    : 지정된 쓰레드 그룹의 상위 쓰레드 그룹인지 확인.
 *      void setDaemon(boolean daemon)                     : 쓰레드 그룹을 데몬 쓰레드 그룹으로 설정/해제.
 *      void setMaxPriority(int pri)                       : 쓰레드 그룹의 최대 우선순의를 설정.
 */