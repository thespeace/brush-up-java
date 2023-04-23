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
        *     "모든 연산자는 결과값을 반환"
        *     "으론쪽 피연산자(rvalue)를 왼쪽 피연산자(lvalue, 저장 공간)에 저장 후 저장된 값을 반환한다."
        *        변수의 타입 앞에 * final을 붙이면 상수 *가 된다.
        **/
        final int MAX = 3;
        //MAX = 10; 상수에 새로운 값을 저장할 수 없다.
        System.out.println("상수 : "+ MAX);


        /*   - 복합 대입 연산자
        *     대입 연산자와 다른 연산자를 하나로 축약
        *
        *       |      op=     |       =       |
        *       |    i += 3;   |   i = i + 3;  |
        *       |    i -= 3;   |   i = i - 3;  |
        *       |    i *= 3;   |   i = i * 3;  |
        *       |    i /= 3;   |   i = i / 3;  |
        *       |    i %= 3;   |   i = i % 3;  |
        *       |    i <<= 3;  |   i = i << 3; |
        *       |    i >>= 3;  |   i = i >> 3; |
        *       |    i &= 3;   |   i = i & 3;  |
        *       |    i ^= 3;   |   i = i ^ 3;  |
        *       |    i |= 3;   |   i = i | 3;  |
        *       | i *= 10 + j; | i = i * (10 + j); |  * 피연산자가 두 개인 경우, 꼭 괄호를 적어줘야한다. i *= (10 + j);
        * */
    }
}
