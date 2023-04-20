package example.ch03;

public class Operator03 {
    public static void main(String[] args){
        /**
         *    - 증감 연산자
         *      1) 증가 연산자(++) 피연산자의 값을 1 증가시킨다.
         *      2) 감소 연산자(--) 피연산자의 값을 1 감소시킨다.
         *
         *      | 타 입  |            설 명            |  사용 예  |
         *      | 전위형 | 값이 참조되기 "전에" 증가시킨다 | j = ++i; |
         *      | 후위형 | 값이 참조된 "후에" 증가시킨다   | j = ++i; |
         *
         *      전위형과 후위형의 차이점? "증감 연산자가 독립적으로 사용된 경우, 전위형과 후위형의 차이가 없다. 하지만 식에서 사용된다면 위의 표처럼의 차이가 있습니다."
         */

        int i = 1, j = 0;

        //증감 연산자가 포함된 식을 이해하기 어려울 때는 다음과 같이 증감 연산자를 따로 떼어내면 이해하기가 쉬워진다. 전위형의 경우 증감 연산자를 식의 이전으로 떼어내면 된다.
        // 전위형 : j = ++i;
        System.out.println("증가 전 i : "+i);
        ++i; //증가 후에
        j = i; // 참조하여 대입
        System.out.println("j에 대입 결과 : "+j);

        //후위형의 경우 증감 연산자를 식의 이후로 떼어내면 된다.
        System.out.println("증가 전 i : "+i);
        j= i;
        i++;
        System.out.println("증가 후 i : "+i);
        System.out.println("j에 대입 결과 : "+j);


        /**
         *    - 부호 연산자
         *      1) '-'는 피연산자의 부호를 반대로 변경
         *      2) '+'는 아무런 일도 하지 않는다.(실제로 사용하지 않는다)
         *
         */

        int minus = -10;
        minus = +minus;
        System.out.println("부호 연산자 +를 사용 : "+minus); // 아무 변화가 없다.

        minus = -minus;
        System.out.println("부호 연산자 -를 사용 : "+minus); // 부호가 반대로 변경.

    }
}
