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


        /**
         *    - 배열의 활용 (3)
         *      배열의 요소의 순서를 반복해서 바꾼다.(숫자 섞기)
         */

        int[] numArr = {0,1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(numArr));

        for(int i = 0; i < 100; i++){ //100번 두 요소 값 바꾸기.
            // ex) int n = 3; // 해당 코드로 실행하면, 4번째 인덱스값과 0번째 인덱스 값이 바뀐다.
            int n = (int)(Math.random() * 10); // 0~9 중의 한 값을 임의로 얻는다.

            //numArr[0]과 numArr[n]의 값을 서로 바꾼다.
            int tmp = numArr[0];   // ex) numArr[0]의 값을 변수 tmp에 저장한다.
            numArr[0] = numArr[n]; // ex) numArr[3]의 값을 numArr[0]에 저장한다.
            numArr[n] = tmp;       // ex) tmp의 값을 numArr[3]에 저장한다.
            // 위의 로직을 예시를 들어 설명하자면, 우유가 든 컵과 물이 든 컵의 내용물을 바꾸려 한다면?
            // 빈 컵(tmp)하나를 준비하고 이를 활용해서 둘 중 하나를 옮겨 담아 서로의 내용물을 바꾸는 방식으로 생각하면 이해가 쉽다.
        }
        System.out.println(Arrays.toString(numArr));

        /**
         *    - 배열의 활용 (4)
         *      배열의 요소의 순서를 반복해서 바꾼다.(로또번호 생성)
         */

        // index : 0~45-1, 0~44
        int[] ball = new int[45]; // 45개의 정수값을 저장하기 위한 배열 생성.

        //배열의 각 요소에 1~45의 값을 저장한다.
        for(int i = 0; i < ball.length; i++)
            ball[i] = i + 1; // ball[0]에 1이 저장된다.

        System.out.println(Arrays.toString(ball));

        int tmp = 0; // 두 값을 바꾸는데 사용할 임시변수.
        int j = 0;   // 임의의 값을 얻어서 저장할 변수.

        // 배열의 i번째 요소와 임의의 요소에 저장된 값을 서로 바꿔서 값을 섞는다.
        // 0번째 부터 5번재 요소까지 모두 6개만 바꾼다.
        for(int i = 0; i < 6; i++) {
            j = (int)(Math.random() * 45); // 0~44범위의 임의의 값을 얻는다.
            tmp = ball[i];
            ball[i] = ball[j];
            ball[j] = tmp;
            System.out.println(Arrays.toString(ball));
        }

        //배열 ball의 앞에서부터 6개의 요소를 출력한다.
        for (int i = 0; i < 6; i++)
            System.out.printf("ball[%d]=%d%n", i, ball[i]);

    }
}
