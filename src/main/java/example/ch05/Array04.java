package example.ch05;

import java.util.Arrays;

public class Array04 {
    public static void main(String[] args){
        /**
         *    - 배열의 활용 (1)
         *      배열의 모든 요소를 더해서 총합과 평균을 구하기.
         */

        int sum = 0;        //총합을 저장하기 위한 변수.
        float average = 0f; // 평균을 저장하기 위한 변수.

        int[] score1 = {100, 88, 100, 100, 90};

        for(int i = 0; i < score1.length; i ++){ // 반복문을 이용해서 배열에 저장되어 있는 값들을 모두 더한다.
            sum += score1[i];
        }
        average = sum / (float)score1.length; //평균 = 더한 숫자 / 개수.
                                             //계산결과를 float 타입으로 변환하여 소수점자리 숫자까지 얻으려 형변환! 크기가 큰 float를 한쪽에 형변환해주면 자동으로 크기가 큰 타입으로 둘 다 형변환되어 계산!
                                             // (int)478 / (int)5 -> (int)95
                                             // (int)478 / (float)5 -> (float)478.0f / (float)5.0f -> 95.6f

        System.out.println("총합 : " + sum);
        System.out.println("평균 : " + average);

        /**
         *    - 배열의 활용 (2)
         *      배열의 요소 중에서 제일 큰 값과 제일 작은 값을 찾기.
         */

        int[] score2 = { 79, 88, 91, 33, 100, 55, 95};

        int max = score2[0]; //배열의 첫 번째 값으로 최대값을 초기화 한다.
        int min = score2[0]; //배열의 첫 번째 값으로 최소값을 초기화 한다.

        for(int i = 1; i < score2.length; i++){ //배열의 두 번째 요소부터 읽기 위해서 변수 i의 값을 1로 초기화했다.
            if(score2[i] > max){
                max = score2[i];
            } else if(score2[i] < min) {
                min = score2[i];
            }
        } //end of for

        System.out.println("최대값 : " + max);
        System.out.println("최소값 : " + min);

    }
}
