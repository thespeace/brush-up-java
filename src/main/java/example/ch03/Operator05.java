package example.ch03;

public class Operator05 {
    public static void main(String[] args){
        /**
         *    - 산술 변환
         *      "연산 전에 피연산자의 타입을 일치시키는 것"
         *          1) 두 피연산자의 타입을 같게 일치시킨다.(보다 큰 타입으로 일치, 값 손실이 일어나지 않게 하기 위해서.)
         *              long(8) + int(4) -> long(8) + long(8) -> long(8)
         *              float(4) + int(4) -> float(4) + float(4) -> float(4)
         *              double(8) + float(4) -> double(8) + double(8) -> double(8)
         *              연산 할 때, 피연산자의 타입이 일치하지 않으면 먼저 일치를 시키고 연산해서 그 일치된 타입의 결과를 반환합니다.
         *          2) 피연산자의 타입이 int보다 작은 타입이면 int로 변환된다.
         *              byte(1) + short(2) -> int(4) + int(4) -> int(4)
         *              char(2) + short(2) -> int(4) + int(4) -> int(4)
         *                  * byte(-128~127), char(0~약 6만), short(+-3만)로 이 타입들은 범위가 좁기때문에,
         *                    범위를 넘어서면 Overflow가 발생하기 때문에, 원하는 계산 결과를 얻기위해 int로 변환됩니다.
         */

        int a = 10, b = 4;
        System.out.printf("%d + %d = %d%n", a, b, a + b);
        System.out.printf("%d - %d = %d%n", a, b, a - b);
        System.out.printf("%d * %d = %d%n", a, b, a * b);
        System.out.printf("%d / %d = %d%n", a, b, a / b); //소수점 이하는 버려진다.
        System.out.printf("%d / %f = %f%n", a, (float)b, a / (float)b); // 피연산자중에 한쪽을 형변환하면 원하는 실수의 값을 얻을 수 있습니다.

        int c = 1_000_000, d = 2_000_000;
        long e = c * d; // a * b = 2,000,000,000,000,  10의 12제곱인데 int형의 범위는 10의 9제곱이기때문에 범위를 넘어서서 Overflow가 발생.
        System.out.println("long타입에 담으려 했지만 integer Overflow가 발생한 값이 담겼다 : "+e);

        long f = (long)c * d;
        long g = c * (long)d;
        /*
        *  long g = 1000000 * (long)2000000;
        *  long g = 1000000 * 2000000L;
        *  long g = 1000000L * 2000000L;
        *  long g = 2000000000000L;
        * */
        System.out.println("피연산자 중 하나를 형변환하여 계산하면 산술 변환이 이루어져 원하는 값이 반환된다 : "+f);
        System.out.println("피연산자 중 하나를 형변환하여 계산하면 산술 변환이 이루어져 원하는 값이 반환된다 : "+g);

    }
}
