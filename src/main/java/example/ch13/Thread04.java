package example.ch13;

public class Thread04 {

    static long startTime2 = 0;

    public static void main(String[] args){

        /**
         *    - 싱글 쓰레드.
         *      순차 실행.
         *      메인 쓰레드 하나만 가지고 작업을 처리한다. A를 먼저 수행해야만 B를 수행 할 수 있다.
         */
        System.out.println("=================Single Thread=================");
        long startTime = System.currentTimeMillis();

        for(int i=0; i < 300; i++)
            System.out.printf("%s", new String("-"));

        System.out.print("소요시간1 : " +(System.currentTimeMillis()- startTime));

        for(int i=0; i < 300; i++)
            System.out.printf("%s", new String("|"));

        System.out.print("소요시간2 : "+(System.currentTimeMillis() - startTime));



        /**
         *    - 멀티 쓰레드.
         *      실행 순서와 소요 시간은 OS의 스케쥴러에 의해 결정되기 때문에 불규칙하게 실행.
         *
         *      프로그램 수행 시간이 싱글 쓰레드보다 더 걸리는데, 아무래도 한 작업을 쭉 수행하는 것보다 번갈아가면서 작업을 수행하면 Context Swiching 발생으로 인해 시간이 더 소요된다.
         *          -Context Swiching
         *          프로그램을 수행하기 위해 A쓰레드 작업에서 B쓰레드 작업으로 넘어가는 것을 Context Swiching, 문맥 전환이라 한다.
         *      즉, 속도는 늦어지더라도 동시에 여러 작업을 수행가능 하다는 점이 단점을 상쇄해준다.
         */
        System.out.println("\n\n=================Multi Thread=================");

        ThreadEx3_1 th1 = new ThreadEx3_1();
        th1.start();
        startTime2 = System.currentTimeMillis();

        for(int i=0; i < 300; i++)
            System.out.printf("%s", new String("-"));

        System.out.print("소요시간 1 : " + (System.currentTimeMillis() - Thread04.startTime2));

    }
}

class ThreadEx3_1 extends Thread {
    public void run() {
        for(int i=0; i < 300; i++)
            System.out.printf("%s", new String("|"));

        System.out.print("소요시간 2 : " + (System.currentTimeMillis() - Thread04.startTime2));
    }
}