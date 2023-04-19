package example.ch01;

public class Part04_Operator01 {
    public static void main(String[] args){
        /**
         *    - 연산자와 피연산자
         *      1) 연산자 : 연산을 수행하는 기호(+, -, *, /)
         *      2) 피연산자 : 연산자의 연산 수행 대상
         *          ex) x + 3 : +는 연산자, x와 3은 피연산자
         *      "모든 연산자는 연산결과를 반환한다."
         */

        int x = 5 , y = 0;
        System.out.println("y = 4 * x + 3 = " + (4 * x + 3));
        y = 4 * x + 3;// 대입연산자
        System.out.println("대입연산자 : y = " + y);

    }
}
