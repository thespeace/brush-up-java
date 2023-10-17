package example.ch15;

import java.util.Date;

/**
 *      - PrintStream을 이용한 간단한 예제.
 */
public class InputOutput04_Ex09 {
    public static void main(String[] args){
        int i = 65;
        float f = 1234.56789f;

        Date d = new Date();

        System.out.printf("문자 %c의 코드는 %d%n", i, i);
        System.out.printf("%d는 8진수로 %o, 16진수로 %x%n", i, i, i);
        System.out.printf("%3d%3d%3d\n", 100, 90, 80);
        System.out.println();
        System.out.printf("123456789012345678901234567890%n");
        System.out.printf("%s%-5s%5s%n", "123", "123", "123");
        System.out.println();
        System.out.printf("%-8.1f%8.1f %e%n", f, f, f);
        System.out.println();
        System.out.printf("오늘은 %tY년 %tm월 %td일 입니다.%n", d, d, d);
        System.out.printf("지금은 %tH시 %tM분 %tS초 입니다.%n", d, d, d);
        System.out.printf("지금은 %1$tH시 %1$tM분 %1$tS초 입니다. %n", d); // '숫자$'를 옵션앞에 붙여줌으로써 출력된 매개변수를 지정해 줄 수있다.
                                                                        //  ex) 1$ 는 첫 번째 매개변수를 의미한다.
/**
 *      - 매개변수(argument)의 개수와 형식화된 문자열에 사용된 옵션의 개수와 일치하도록 신경써서 작성해야 한다.
 */
    }
}