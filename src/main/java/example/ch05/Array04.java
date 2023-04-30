package example.ch05;

import java.util.Arrays;

public class Array04 {
    public static void main(String[] args){
        /**
         *    - 배열의 활용 (1)
         */

        //배열의 모든 요소를 더해서 총합과 평균을 구한다.
        int sum = 0;        //총합을 저장하기 위한 변수.
        float average = 0f; // 평균을 저장하기 위한 변수.

        int[] score = {100, 88, 100, 100, 90};

        for(int i = 0; i < score.length; i ++){ // 반복문을 이용해서 배열에 저장되어 있는 값들을 모두 더한다.
            sum += score[i];
        }
        average = sum / (float)score.length; //평균 = 더한 숫자 / 개수.
                                             //계산결과를 float 타입으로 변환하여 소수점자리 숫자까지 얻으려 형변환! 크기가 큰 float를 한쪽에 형변환해주면 자동으로 크기가 큰 타입으로 둘 다 형변환되어 계산!
                                             // (int)478 / (int)5 -> (int)95
                                             // (int)478 / (float)5 -> (float)478.0f / (float)5.0f -> 95.6f

        System.out.println("총합 : " + sum);
        System.out.println("평균 : " + average);

    }
}
