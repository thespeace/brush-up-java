package example.ch03;

public class Operator01 {
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
        System.out.println("y = " + y);

        /**
         *
         *    - 연산자의 종류
         *
         *    |    종 류   |          연산자       |                          설 명                         |
         *    | 산술 연산자 |    + - * / % << >>   | 사칙 연산과 나머지 연산(%), 비트연산자를 잘 사용되지 않는다.   |
         *    | 비교 연산자 |    > < >= <= == !=   | 크고 작음과 같고 다름을 비교                               |
         *    | 논리 연산자 |    && || ! & | ^ ~   | '그리고(AND)'와 '또는(OR)'으로 조건을 연결                 |
         *    | 대입 연산자 |           =          | 우변의 값을 좌변에 저장                                   |
         *    |   기 타    | (type) ?: instanceof | 형변환 연산자, 삼항 연산자, instanceof 연산자              |
         */

    }
}
