package example.ch05;

import java.util.Arrays;

public class Array07 {
    public static void main(String[] args){
        /**
         *    - 2차원 배열
         *      테이블 형태의 데이터를 저장하기 위한 배열, 간단히 말해 1차원 배열(여러 열이 모인 하나의 행)이 여러개 모인 것을 2차원 배열(여러 열과 여러 행)이라 한다.
         *      ex) int[][] score = new int[4][3]; // 4행 3열의 2차원 배열을 생성한다. 4 * 3 = 12개의 저장 공간이 생성. 값은 integer의 기본값인 0.
         *
         *      <------- 열 index( 0 ~ 열의 길이 -1 ) ------>
         *      | score[0][0] | score[0][1] | score[0][2] |
         *      | score[1][0] | score[1][1] | score[1][2] |   <- 행 index( 0 ~ 행의 길이 -1 )
         *      | score[2][0] | score[2][1] | score[2][2] |
         *      | score[3][0] | score[3][1] | score[3][2] |
         *
         *      score[0][0] = 100; // 1행 1열에 값을 저장.
         *      System.out.println(score[0][0]); // 1행 1열에 값을 출력.
         */


        /**
         *    - 2차원 배열의 초기화
         */
        int[][] arr1 = new int[][]{ {1, 2, 3}, {4, 5, 6} };
        int[][] arr2 = { {1, 2, 3}, {4, 5, 6} }; // new int[][] 생략 가능. 해당 초기화식이 훨씬 더 많이 사용.

        int[][] arr3 = {  //위 식보다는 꼬부랑 괄호를 이와 같이 사용하는 것이 가독성면에서 훨씬 좋다.
                {1, 2, 3},
                {4, 5, 6}
        };
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));

    }
}
