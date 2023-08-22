package example.ch13;

/**
 *    - 쓰레드의 구현과 실행
 *      1. Thread클래스를 상속.
 *         {@code - Thread클래스를 상속 예시.
 *             class MyThread extends Thread {
 *                 public void run() { // Thread클래스의 run()을 오버라이딩.
 *                     ...작업내용 작성...
 *                 }
 *             }
 *         }
 *         {@code - 상속 Thread 사용 예시.
 *             MyThread t1 = new MyThread(); // 쓰레드의 생성
 *             t1.start(); // 쓰레드의 실행
 *         }
 *
 *      2. Runnable 인터페이스를 구현.
 *         {@code - Runnable 인터페이스 구현 예시.
 *             class MyThread2 implements Runnable {
 *                 public void run() { // Runnable인터페이스의 추상메서드 run()을 구현.
 *                     ...작업내용 작성...
 *                 }
 *             }
 *         }
 *         {@code - Runnable 인터페이스 구현 Thread 사용 예시.
 *             Runnable r = new MyThread2();
 *             Thread t2 = new Thread(r); // Thread(Runnable r) : run(){} 메서드의 구현체를 r이라는 매개변수라는 외부의 매개변수로 받는 것.
 *             //Thread t2 = new Thread(new MyThread2()); // 위의 두줄을 한줄로 축소.
 *             t2.start();
 *         }
 *
 *         " 자바는 단일 상속만 허용, Thread를 상속받으면 다른 클래스를 상속받기 어려우니까 인터페이스로 구현하는게 좋고, 다른 클래스를 상속받기도 쉬우니 유연하다. "
 *         {@code - Runnable 인터페이스.
 *             public interface Runnable {
 *                 public abstract void run(); // run()메서드 하나만 가지고 있고, 어렵게 생각할 필요 없이 Java 클래스의 main() { 작업내용 } 과 같이 run메서드에 작업 내용을 작성 후 사용하면 된다.
 *             }
 *         }
 *
 *
 *    - start()와 run()
 *      우리가 작성한 것은 run()이지만 왜 start()를 호출해야 하는지 살펴보자.
 *      {@code - main메서드와 호출스택(Call Stack).
 *          class ThreadTest {
 *              public static void main(String args[]){
 *                  MyThread t1 = new MyThread(); // 1.쓰레드 생성
 *                  t1.start(); // 2.실행
 *              }
 *          }
 *
 *          1. Call stack1 : main - start                       //start()가 새로운 Call stack 생성.
 *          2. Call stack1 : main - start | Call stack2 : run
 *          3. Call stack1 : main | Call stack2 : run           //start()메서드는 할 일을 다 했으니 종료.
 *          //각각의 쓰레드가 자기만의 호출스택을 가지고 실행을 하는 것, 따라서 서로 독립적으로 작업 수행. 즉, start()는 쓰레드 실행(새로운 호출스택 생성)으로 말할 수 있다.
 *
 *          <-> start()메서드가 아니라 run()메서드로 실행했다면 하나의 호출스택을 하나의 쓰레드가 실행하는 것.(싱글 쓰레드 프로세스)
 *      }
 */

public class Thread02 {
    public static void main(String[] args){
        ThreadEx1_1 t1 = new ThreadEx1_1();

        Runnable r = new ThreadEx1_2();
        Thread t2 = new Thread(r); // 생성자 Thread(Runnable target)

        /**
         *    쓰레드를 생성한 후에, start()를 호출해야 쓰레드가 작업을 시작한다.
         *    쓰레드를 실행(start())하면 실행 가능한 상태가 되는 것이지 바로 실행되지 않는다.
         *    언제 실행될지는 OS의 스케쥴러가 실행 순서를 결정한다.
         *    OS에는 많은 프로세스와 쓰레드가 있는데, 그것들 중에 어떤 순서로 누가 먼저 얼마의 시간동안 실행될지를 결정하는 것이 OS의 스케쥴러이다.
         *    OS에서 돌아가는 하나의 프로세스일 뿐인 JVM을 OS스케쥴러에게 이래라 저래라 지시할 수 없어서 무조건 결정해주는대로 따라야한다.
         *    따라서 ** 1. start()했다고 즉시 실행되는 것이 아니고, 2.먼저 start()했다고 먼저 실행되는건 꼭 아니라는 것을 명심해야 한다. **
         *    때문에 쓰레드가 OS에 의존적인 면을 가지고 있다. 원래 JVM이 OS에 독립적이라고 이야기를 하지만 몇가지 종속적인 것이 몇가지 있다. 그중의 하나가 쓰레드이다.
         */
        t1.start();
        t2.start();
        //t1과 t2중 어느것이 먼저 동작할 것인지는 OS스케쥴링 로직에 결정 될뿐 예측할 수 없다. 이러한 "불확실성"이 있다.
    }
}

class ThreadEx1_1 extends Thread { // 1. Thread클래스를 상속해서 쓰레드를 구현.
    public void run() { // 쓰레드가 수행할 작업을 작성.
        for(int i=0; i < 5; i++) {
            System.out.println(getName()); // 조상인 Thread의 this.getName()을 호출.
        }
    }
}

class ThreadEx1_2 implements Runnable { // 2. Runnable인터페이스를 구현해서 쓰레드를 구현.
    public void run() { // 쓰레드가 수행할 작업을 작성.
        for(int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()); // Thread.currentThread() - 현재 실행중인 Thread를 반환한다.
        }
    }
}

// 쓰레드의 순서를 더 정확히 확인하려면 아래의 코드의 주석을 풀고 쓰레드 클래스(ThreadEx1_1, ThreadEx1_2)를 교체한 다음에 확인해볼 것.
/*class ThreadEx1_1 extends Thread {
    public void run() {
        for(int i=0; i < 500; i++)
            System.out.print(0);
    }
}

class ThreadEx1_2 implements Runnable {
    public void run() {
        for(int i = 0; i < 500; i++)
            System.out.print(1);
    }
}*/
