package example.ch05;

import java.util.Arrays;
import java.util.Scanner;

public class Array10 {
    public static void main(String[] args){
        /**
         *    - Array로 배열 다루기
         *      Array 클래스 : 배열을 다루는데 유용한 method들을 제공.
         *          대표적 ex) 배열의 비교와 출력 - equals(), toString()
         */
        int[] arr = {0,1,2,3,4};
        int[][] arr2D = {
                {11,12},
                {21,22}
        };
        System.out.println("toString(1차원 배열) : " + Arrays.toString(arr)); // [0, 1, 2, 3, 4]
        System.out.println("deepToString(2차원 이상, 다차원 배열) : " + Arrays.deepToString(arr2D)); // [ [11,12] , [21,22] ]

    }
}
