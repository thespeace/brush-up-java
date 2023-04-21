package example.ch03;

public class Operator06 {
    public static void main(String[] args){
        /**
         *    - Math 클래스
         *      "수학과 관련된 Method(메서드)들을 가지고 있는 클래스"
         *
         *    - Math.round() : 반올림
         *      실수를 소수점 첫 째자리에서 반올림한 정수를 반환
         *
         *      * round()이외에도 Math 클래스의 메소드는 매우 다양합니다.
         * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html">공식문서</a>
         */

        System.out.println("실수 4.52를 반올림 : "+Math.round(4.52));

        // 실수를 소수점 4번째, 5번째 자리에서 반올림으로 변경해보는 예제.
        double pi = 3.141592;
        double shortpi1 = Math.round(pi * 1000) / 1000.0;
        double shortpi2 = Math.round(pi * 10000) / 10000.0;
        /*
        *   Math.round(3.141592 * 1000) / 1000.0;
        *   Math.round(3141.592) / 1000.0;
        *   3141 / 1000.0;                      integer / double -> double 반환
        * */
        System.out.println("소수점 4번째에서 반올림 : "+shortpi1);
        System.out.println("소수점 5번째에서 반올림 : "+shortpi2);

        //반대로 소수점 아래의 값을 버리기 위해서는?
        double shortpi3 = ((int)(pi*1000)/1000.0);
        System.out.println("소수점 4번째이하는 버리기 : "+shortpi3);

        /*
        *     - 나머지 연산자 %
        *       오른쪽 피연산자로 나누고 남은 나머지를 반환
        *       나누는 피연산자는 0이 아닌 정수만 허용(부호는 무시됨)
        * */

        int x = 10;
        int y = 8;

        System.out.printf("%d을 %d로 나누면, ", x, y);
        System.out.printf("몫은 %d이고, 나머지는 %d입니다.%n", x / y, x % y);

        System.out.println("피연산자는 0이 아닌 정수만 허용.(부호는 무시됩니다)");
        System.out.println("10 % 8 : " + (x % y));
        System.out.println("10 % -8 : " + (x % -y));
    }
}
