package example.ch03;

public class Operator02 {
    public static void main(String[] args){
        /**
         *    - 연산자의 우선순위
         *      "하나의 식(expression)에 연산자가 둘 이상 있을때 어떤 연산을 먼저 수행할지를 자동 결정하는 것"
         *                                                                          <-> 수동 결정할 경우 괄호()를 사용.
         *
         *      |    종 류    | 결합규칙 |                 연산자               | 우선순위 |
         *      |  단항 연산자 |  <---  |         ++ -- + - ~ ! (type)        |  높 음  |  * 단항? 이항? : 단항 연산자는 피연산자가 하나인 연산자이고, 이항 연산자는 피연산자가 두개인 연산자이다.
         *      |  산술 연산자 |  --->  |                 * / %               |        |
         *      |            |  --->  |                 +   -               |        | * 덧셈이나 뺄셈이 이항연산자라 할 수 있다.
         *      |            |  --->  |                 << >>               |        |
         *      |  비교 연산자 |  --->  |         < > <= >= instanceof        |        |
         *      |            |  --->  |                 == !=               |        |
         *      |  논리 연산자 |  --->  |                   &                 |        |
         *      |            |  --->  |                   ^                 |        |
         *      |            |  --->  |                   |                 |        |
         *      |            |  --->  |                  &&                 |        |
         *      |            |  --->  |                  ||                 |        |
         *      |  삼항 연산자 |  --->  |                   ?:                |        |
         *      |  대입 연산자 |  <---  |  = += -= *= /= %= <<= >>= &= ^= |=  |  낮 음  |
         *
         *    - 연산자의 결합규칙
         *      "우선순위가 같은 연산자가 있을 때, 어떤 것을 먼저 계산해야 할까?"
         *      "대입과 단항 연산자를 제외하면, 모두 왼쪽 -> 오른쪽!"
         *
         *    * 모든 연산자는 연산 결과를 반환.
         *      연산자의 우선순위와 결합법칙은 "세 가지만 기억하자"
         *      1. 산술 > 비교 > 논리 > 대입. 대입은 제일 마지막에 수행된다.
         *      2. 단항(1) > 이항(2) > 삼항(3). 단항 연산자의 우선순위가 이항 연산자보다 높다.
         *      3. 단항 연산자와 대입 연산자를 제외한 모든 연산의 진행방향은 왼쪽에서 오른쪽이다.
         */

        int x = 1, y = 2;

        //단항 연산자가 이항 연산자보다 우선순위가 높다. 그래서 x의 부호를 바꾼 다음 덧셈이 수행된다. 여기서 '-'는 뺄셈 연산자가 아니라 부호 연산자이다.
        System.out.println(-x + 3);

        //곱셈과 나눗셈이 덧셈과 뺄셈보다 우선순위가 높다. 그래서 '3 * y'가 먼저 계산된다.
        System.out.println(x + 3 * y);

        //비교 연산자(>)보다 산술 연산자 '+'와 '-'가 먼저 수행된다. 그래서 'x+3'과 'y-2'가 먼저 계산된 다음에 '>'가 수행된다.
        System.out.println(x + 3 > y - 2);

        //논리 연산자 '&&'보다 비교 연산자가 먼저 수행된다. 그래서 'x > 3'와 'x < 5'가 먼저 계산된 다음에 '&&'가 수행된다. 식의 의미는 'x가 3보다 크고 5보다 작다'이다.
        System.out.println(x > 3 && x < 5);

        //대입 연산자는 연산자 중에서 제일 우선순위가 낮다. 그래서 우변의 최종 연산결과가 변수 result에 저장된다.
        int result = 0;
        result = x + y * 3;
        System.out.println(result);
    }
}
