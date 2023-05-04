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


        //배열의 비교와 출력 : toString(), deepToString().
        int[] arr = {0,1,2,3,4};
        int[][] arr2D = {
                {11,12},
                {21,22}
        };
        System.out.println("toString(1차원 배열을 문자열로 반환) : " + Arrays.toString(arr)); // [0, 1, 2, 3, 4]
        System.out.println("deepToString(2차원 이상, 다차원 배열을 문자열로 반환) : " + Arrays.deepToString(arr2D)); // [ [11,12] , [21,22] ]


        //배열의 비교와 출력 : equals(), deepequals().
        String[][] str2D = new String[][]{{"aaa","bbb"},{"AAA","BBB"}};
        String[][] str2D2 = new String[][]{{"aaa","bbb"},{"AAA","BBB"}};

        System.out.println("equals() : " + Arrays.equals(str2D, str2D2));         // false,
        System.out.println("deepEquals() : " + Arrays.deepEquals(str2D, str2D2)); // true, 2차원 배열이기 때문에 문자 하나하나 비교해야 한다. 관련 클래스 : deepEquals().


        //배열의 복사 : copyOf(), copyOfRange()
        int[] arr2 = {0,1,2,3,4};
        int[] arr3 = Arrays.copyOf(arr2, arr.length); // Arrays.copyOf(배열, 복사할 요소의 갯수);
        int[] arr4 = Arrays.copyOf(arr2, 3);
        int[] arr5 = Arrays.copyOf(arr2, 7); // 배열의 길이보다 큰 값을 복사하면 그 이상의 값은 기본값이 들어간다. integer타입이여서 0이 추가로 들어간다.
        int[] arr6 = Arrays.copyOfRange(arr2, 2, 4);
        int[] arr7 = Arrays.copyOfRange(arr2, 0, 7);
        System.out.println("배열의 길이만큼 복사(전체복사) : "+ Arrays.toString(arr3));
        System.out.println("앞에서부터 세 개만 복사 : "+ Arrays.toString(arr4));
        System.out.println("배열의 길이보다 2개 더 복사 : "+ Arrays.toString(arr5));
        System.out.println("배열의 처음과 끝을 정해서 잘라 복사 : "+ Arrays.toString(arr6));
        System.out.println("배열의 처음과 끝을 정해서 잘라 복사 : "+ Arrays.toString(arr7));


        //배열의 정렬 : sort()
        int[] sortArr = { 3, 2, 0, 1, 4};
        Arrays.sort(sortArr); // 배열 arr을 정렬한다. 오름차순으로 정렬된다.
        System.out.println("sort() 메소드를 사용해서 배열안의 값들이 오름차순으로 정렬 : " + Arrays.toString(sortArr));

    }
}
