package example.ch09;

public class Class11 {
    public static void main(String[] args){
        /**
         *    - StringBuilder
         *      StringBuffer와 거의 비슷하지만, 딱 하나 다른점으로 Buffer은 동기화가 되어 있어서 멀티 쓰레드에 안전(thread-safe)하지만, Builder은 동기화가 되어있지 않다.
         *          + 싱글 쓰레드 : 한 번에 1개 작업.
         *            멀티 쓰레드 : 한 번에 n개 작업, 동시 진행. 요즘 프로그램들은 대부분 멀티 쓰레드이다.
         *                        멀티 쓰레드는 동시에 작업을 진행하다보니 데이터를 공유하게 되는데, 이때 데이터가 꼬여버릴 수도 있는데, 이를 막아주는 것을 "동기화(데이터 보호)"라고 한다.
         *
         *      멀티 쓰레드 프로그램이 아닌 경우, 동기화는 불필요한 성능저하를 일으킨다. 이럴 땐 StringBuffer대신 StringBuilder를 사용하면 성능을 향상 시킬 수 있다.
         *
         *      + 지금까지 작성해온 프로그램은 전부 싱글 쓰레드로 작성된 것이고, 멀티 쓰레드로 프로그램을 작성하는 방법은 ch13에서 다루게 될 것이다.
         *
         */
        StringBuffer sb;
        sb = new StringBuffer();
        sb.append("abc");
        System.out.println("StringBuffer(멀티쓰레드) : " + sb);

        StringBuilder sbd;
        sbd = new StringBuilder();
        sbd.append("abc");
        System.out.println("StringBuilder(싱글쓰레드) : " + sbd);


        /**
         *    - Math 클래스
         *      수학관련 static메서드의 집합.
         *
         *      round()로 원하는 소수점 아래 세 번째 자리에서 반올림하기.
         *          1. 원래 값에 100을 곱한다.
         *              90.7552 * 100 -> 9075.52
         *          2. 위의 결과에 Math.round()를 사용한다.
         *              Math.round(9075.52) -> 9076
         *          3. 위의 결과를 다시 100.0으로 나눈다.
         *              9076 / 100.0 -> 90.76 //실수로 나눠 소수점 도출.
         *              9076 / 100 -> 90
         */

        //상수.
        System.out.println(Math.E); // public static final double E = 2.7182818284590452354;   // 자연로그의 밑
        System.out.println(Math.PI); //public static final double PI = 3.14159265358979323846; // 원주율


        /**
         *    - Math 클래스의 메서드(1/2)
         */

        /**
         *    static double abs(double a)
         *    static float abs(float a)
         *    static int abs(int a)
         *    static long abs(long a)       : 주어진 값의 절대값을 반환한다.
         */
        int i = Math.abs(-10);
        double d = Math.abs(-10.0);
        System.out.println("Math.abs(-10) : " + i);
        System.out.println("Math.abs(-10.0) : " + d);

        //static double ceil(double a) : 주어진 값을 올림하여 반환한다.
        double d1 = Math.ceil(10.1);
        double d2 = Math.ceil(-10.1);
        double d3 = Math.ceil(10.000015);
        System.out.println("Math.ceil(10.1) : " + d1);
        System.out.println("Math.ceil(-10.1) : " + d2);
        System.out.println("Math.ceil(10.000015) : " + d3);

        //static double floor(double a) : 주어진 값을 버림하여 반환한다.
        double d4 = Math.floor(10.8);
        double d5 = Math.floor(-10.8);
        System.out.println("Math.floor(10.8) : " + d4);
        System.out.println("Math.floor(-10.8) : " + d5);

        /**
         *    static double max(double a, double b)
         *    static float max(float a, float b)
         *    static int max(int a, int b)
         *    static long max(long a, long b)       : 주어진 두 값을 비교하여 큰 쪽을 반환한다.
         */
        double d6 = Math.max(9.5, 9.50001);
        int i1 = Math.max(0, -1);
        System.out.println("Math.max(9.5, 9.50001) : "+ d6);
        System.out.println("Math.max(0, -1) : "+ i1);



    }
}
