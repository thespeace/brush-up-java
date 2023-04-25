package example.ch04;
import java.util.Scanner;

public class Conditional04 {
    public static void main(String[] args){
        /**
         *    - 난수(임의의 정수 || 실수) 만들기
         *      " 0.0 <= Math.random() < 1.0 "  : 0.0 ~ 0.99999...
         *      Math.random() - 0.0과 1.0사이의 임의의 double 값을 반환.
         */

        // 예제 1. 1~3 사이의 랜덤한 정수를 얻기.
        int num = 5;
        while(num-->0) {
            System.out.println(Math.random() * 3); // 1) 각 변에 3을 곱한다. Math.random() * 개별 값의 갯수 0.0 ~ 2.999...
            System.out.println((int)(Math.random() * 3)); // 2) 각 변을 int형으로 변환한다. 정수로 형변환하면서 소수점을 버린다. 0 ~ 2
            System.out.println("1~3 사이의 랜덤한 정수값 : "+ ((int)(Math.random() * 3) + 1)); // 3) 각 변에 1을 더한다. 1 ~ 3
        }

        // 예제 2. 1~10사이의 난수를 10개 출력하기.
        for (int i = 1; i <= 10; i++){
            System.out.println(i + " : " + ((int)(Math.random()*10) + 1)); // 1 <= x < 10, 1 ~ 9
        }

        // 예제 2. -5~5사이의 난수를 10개 출력하기.
        for (int i = 1; i <= 10; i++){
            System.out.println((int)(Math.random()*11)); // 0 <= x < 11, 0 ~ 10
            System.out.println(i + " : " + ((int)(Math.random()*11) -5) ); // -5 <= x < 6, -5 ~ 5
        }

        /**
         *    - 정리
         *      1. * 개별값 개수.
         *      2. 형변환을 통해서 소수점을 없애기.
         *      2. +, - 을 이용해서 범위를 바꾸어주기.
         *
         *
         *
         * */

    }
}
