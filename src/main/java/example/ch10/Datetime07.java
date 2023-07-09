package example.ch10;

import java.text.DecimalFormat;
import java.text.ParseException;

public class Datetime07 {
    public static void main(String[] args) throws ParseException {
        /**
         *      하나의 double 값을 DecimalFormat의 다양한 패턴을 이용하여 콘솔에 찍기.
         *          + 단순히 어떠한 패턴을 적용했을 때, 어떠한 결과를 얻는지 보기 위함이니 원하는 패턴이 있다면 참고하여 직접 작성해보기.
         */
        System.out.println("=================Example1=================");
        double number = 1234567.89;
        String[] pattern = {
                "0",
                "#",
                "0.0",
                "#.#",
                "0000000000.0000",
                "##########.####",
                "#.#-",
                "-#.#",
                "#,###.##",
                "#,####.##",
                "#E0",
                "0E0",
                "##E0",
                "00E0",
                "####E0",
                "0000E0",
                "#.#E0",
                "0.0E0",
                "0.000000000E0",
                "00.00000000E0",
                "000.0000000E0",
                "#.#########E0",
                "##.########E0",
                "###.#######E0",
                "#,###.##+;#,###.##-",
                "#.#%",
                "#.#\u2030",
                "\u00A4 #,###",
                "'#'#,###",
                "''#,###",
        };

        for(int i=0; i < pattern.length; i++) {
            DecimalFormat df = new DecimalFormat(pattern[i]);
            System.out.printf("%19s : %s\n",pattern[i], df.format(number));
        }

        /**
         *      포맷 변경 예제
         */
        System.out.println("\n\n=================Example2=================");
        DecimalFormat df  = new DecimalFormat("#,###.##"); //원하는 패턴 작성.
        DecimalFormat df2 = new DecimalFormat("#.###E0");

        // System.out.println(Double.parseDouble("1,234,567.89")); // Error! parseInt, parseDouble, parseFloat는 ,(콤마)를 가지로 있는 문자열은 변환을 못해준다.
        Number num = df.parse("1,234,567.89"); // parse() : 형식 문자열에서 숫자로 변경.
        System.out.print("1,234,567.89" + " -> ");

        double d = num.doubleValue(); // 숫자를 지수 형식의 문자열로 변경.
        System.out.print(d + " -> ");

        System.out.println(df2.format(num)); // format() : 숫자를 형식 문자열로 변경.
    }
}
