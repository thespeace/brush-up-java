package example.ch03;

public class Operator08 {
    public static void main(String[] args){
        /**
         *    - 논리 연산자( && || )
         *      "조건식을 연결할 때 사용하는 연산자"
         *          1) ||(OR 결합)  : 피연산자 중 어느 한 쪽이 true이면 true를 결과로 얻는다.
         *          2) &&(AND 결합) : 피연산자 양쪽 모두 true이어야 true를 결과로 얻는다.
         *
         *       |   x   |   y   |  x||y  |  x&&y  |
         *       |  true |  true |  true  |  true  |
         *       |  true | false |  true  |  false |
         *       | false |  true |  true  |  false |
         *       | false | false |  false |  false |
         */

        int x = 15, y = 20;

        //'x > 10'와 'x < 20'가 '그리고(and)'로 연결된 조건이므로 다음과 같이 쓸 수 있습니다.
        System.out.println("x : " + x);
        System.out.println("x는 10보다 크고, 25보다 작다 : " + (x > 10 && x < 20));

        //'x > 10'은 '10 < x'와 같으므로 다음과 같이 쓸 수도 있습니다. 보통은 변수를 왼쪽에 쓰지만 이런 경우 가독성측면에서 보면 아래의 식이 더 나을 수 있습니다.
        System.out.println("x는 10보다 크고, 25보다 작다 : " + (10 < x && x < 20)); // 10 < x < 20, 이와 같은 표현 식은 허용 되지 않는다.


        int i = 8;
        System.out.println("i : " + i);
        System.out.println("i는 2의 배수 또는 3의 배수이다 : " + (i % 2 == 0 || i % 3 == 0));
        /**  풀이 :
         *   i % 2 == 0 || i % 3 == 0
         *   8 % 2 == 0 || 8 % 3 == 0
         *       0 == 0 || 2 == 0
         *         true || false
         *             true
         */

        System.out.println("i는 2의 배수 또는 3의 배수지만 6의 배수는 아니다 : " + ((i % 2 == 0 || i % 3 == 0) && i % 6 != 0));
        //위의 식에서
    }
}
