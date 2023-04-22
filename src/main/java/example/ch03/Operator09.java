package example.ch03;

public class Operator09 {
    public static void main(String[] args){
        /**
         *    - 조건 연산자( ? : )
         *      조건 연산자는 유일한 삼항 연산자(피연산자가 3개)입니다.
         *      조건식의 결과에 따라 연산결과를 달리하는데, 기본 문법은 아래와 같다.
         *
         *      문법 : 조건식 ? 식1 : 식2 -> 조건식이 true(참)이면 식1이 실행되고, false(거짓)이면 식2가 실행된다.
         *
         *    - 삼항 연산자는 if문을 간단히 쓸 수 있게 고안된 연산자입니다.
         */

        int x = 5, y = 3;
        int result = (x > y) ? x : y;
        System.out.println("(x > y) ? x : y -> " + result);

        if( x > y )
            result = x; // x > y가 true일 때
        else
            result = y ; // x < y가 false일 때
        System.out.println("위의 식을 if else문으로 : " + result);
        /*
        *   result = (5 > 3) ? 5 : 3 ;
        *   result = (true) ? 5 : 3 ;
        *   result = 5 ;
        * */

        /*
        *   - 대입 연산자
        *     lvalue = 대입 연산자의 왼쪽 피연산자
        *     rvalue = 대입 연산자의 오른쪽 피연산자
        *
        *   - 복합 대입 연산자
        *     대입 연산자와 다른 연산자를 하나로 축약
        *
        *       |       op=     |       =       |
        *       | i += 3; | i = i + 3; |
        *
        * */
    }
}
