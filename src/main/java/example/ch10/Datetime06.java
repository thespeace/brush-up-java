package example.ch10;

import java.text.DecimalFormat;
import java.text.ParseException;

public class Datetime06 {

    /**
     *    - 형식화 클래스
     *      숫자와 날짜를 원하는 형식으로 쉽게 출력 가능(숫자, 날짜 -> 형식 문자열).
     *      java.text패키지의 DecimalFormat(10진수), SimpleDateFormat(날짜 형식화).
     *      {@code
     *          double number = 1234567.89; // 10진수.
     *          DecimalFormat df = new DecimalFormat("#.#E0"); // 지수 형식 표현으로 변환.
     *          String result = df.format(number); // 문자열 변환, result = "1.2E6" = 1.2 * 10의 6제곱.
     *      }
     *
     *      형식 문자열에서 숫자와 날짜를 뽑아내는 기능(형식 문자열 -> 숫자, 날짜)
     *      {@code
     *          DecimalFormat df = new DecimalFormat("#,###.##"); <- #은 형식만 표현한 것.
     *          Number num = df.parse("1,234,567.89");
     *          double d = num.doubleValue(); // 1234567.89
     *      }
     */
    public static void main(String[] args) throws ParseException {
        /**
         *    - DecimalFormat
         *      빈 문자열을 더해서 숫자를 문자로 변환할 수도 있지만, DecimalFormat은 다양한 형식으로 숫자를 변환할 수 있다.
         *
         *    - DecimalFormat 패턴
         *      기호 |          의 미         |        패턴       | 결과(1234567.89)
         *        0 | 10진수(값이 없을 때는 0) |          0        | 1234568
         *        0 | 10진수(값이 없을 때는 0) |         0.0       | 1234567.9
         *        0 | 10진수(값이 없을 때는 0) |  0000000000.0000  | 0001234567.8900  // 남는 부분은 0으로 채워 진다.
         *        # | 10진수                 |         #         | 1234568          // #은 10진수를 의미한다.
         *        # | 10진수                 |         #.#       | 1234567.9
         *        # | 10진수                 |  ##########.####  | 1234567.89       // 소수점 자리의 남는 부분은 사용되지 않는다. 0으로 채우고 싶다면 0000으로 사용.
         *        E | 지수기호                |  #.#E0            | 1.2E6            // E는 지수기호.
         *        E | 지수기호                |  0.0E0            | 1.2E6
         *        E | 지수기호                |  0.000000000E0    | 1.234567890E6
         *        E | 지수기호                |  00.00000000E0    | 12.34567890E5
         *        E | 지수기호                |  #.########E0     | 1.23456789E6
         *        E | 지수기호                |  ##.#######E0     | 1.23456789E6
         *
         *        + 위의 표를 참고해서 원하는 형식을 만들어서 사용하면 된다.(굳이 암기하지 않아도 됨)
         */

        //숫자를 형식화할 때 사용(숫자 -> 형식 문자열).
        double number = 1234567.89;
        DecimalFormat df = new DecimalFormat("#.#E0"); // 지수 형식의 패턴을 적어, 지수 형식으로 변환.
        String result = df.format(number);
        System.out.println(result);

        //특정 형식의 문자열을 숫자로 변환할 때도 사용(형식 문자열 -> 숫자)
        DecimalFormat df2 = new DecimalFormat("#,###.##");
        Number num = df2.parse("1,234,567.89"); // parse() : 문자열->Number타입 객체.  Number : 모든 숫자 래퍼클래스의 최고 조상.
        double d = num.doubleValue();
        System.out.println(d);

        // [참고] Integer.parseInt()는 콤마(,)가 포함된 문자열을 숫자로 변환 못함. == float.parseFloat()
    }
}
