package example.ch02;

public class Variable07 {
    public static void main(String[] args){
        /**
         *    - 타입간의 변환 방법
         *      1. 문자와 숫자간의 변환
         *          1) 숫자 -> 문자 : 숫자 + '0'(문자 0)
         *          2) 문자 -> 숫자 : 문자 - 0(숫자 0)
         */
        int num = 1;
        char ch = '2';
        String str = "3";

        System.out.println("숫자 : " + num);
        System.out.println("문자 : " + ch);
        System.out.println("문자열 : " + str);
        System.out.println("숫자 -> 문자 : " + (num + '0')); // 문자 1과 문자 0이 합쳐져서 10.
        System.out.println("문자 -> 숫자 : " + (ch-'0')); // 문자 2는 아스키코드 50, 50-48이기때문에 2가 출력.

        /**
         *      2. 문자열로의 변환
         *          1) 숫자 -> 문자열 : 숫자 + ""(빈 문자열)
         *          2) 문자 -> 문자열 : 문자 + ""(빈 문자열)
         *          3) 문자열 -> 정수 타입 숫자 : Integer.parseInt("문자열")
         *          4) 문자열 -> 더블 타입 숫자 : Double.parseDouble("문자열")
         *          5) 문자열 -> 문자 : "문자열".CharAt(0);
         */
        System.out.println("숫자 -> 문자열 : " + (num+""));
        System.out.println("문자 -> 문자열 : " + (ch+""));
        System.out.println("문자열 -> 숫자 : " + Integer.parseInt(str));
        System.out.println("문자열 -> 문자 : " + str.charAt(0));

        System.out.println("문자열 -> 문자 -> 숫자 + 1 : " + (str.charAt(0) - '0' + 1) );

    }
}
