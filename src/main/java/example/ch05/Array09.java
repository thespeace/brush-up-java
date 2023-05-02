package example.ch05;

import java.util.Scanner;

public class Array09 {
    public static void main(String[] args){
        /**
         *    - 2차원 배열 예제(1)
         */

        int[][] score1 = {
                { 100, 100, 100 },
                { 20, 20, 20 },
                { 30, 30, 30 },
                { 40, 40, 40 }
        }; // new int[4][3] : 4행 3열.

        int sum1 = 0;

        for (int i = 0; i < score1.length; i++){ //4행
            for (int j = 0; j < score1[i].length; j++){ //3열
                System.out.printf("score[%d][%d]=%d%n", i, j, score1[i][j]);

                sum1 += score1[i][j];
            }
        }
        System.out.println("sum=" + sum1);


        /**
         *    - 2차원 배열 예제(2)
         */

        int[][] score2 = {
                { 100, 100, 100 },
                { 20, 20, 20 },
                { 30, 30, 30 },
                { 40, 40, 40 },
                { 50, 50, 50 }
        }; // new int[5][3] : 5행 3열.

        //과목별 총점
        int korTotal = 0, engTotal = 0, mathTotal = 0;

        System.out.println("번호 국어 영어 수학 총점 평균");
        System.out.println("=============================");

        for (int i = 0; i < score2.length; i++){
            int sum2 = 0;     // 개인별 총점
            float avg = 0.0f; // 개인별 평균

            korTotal += score2[i][0]; // 국어 총점
            engTotal += score2[i][1]; // 영어 총점
            mathTotal += score2[i][2]; // 수학 총점
            System.out.printf("%3d", i+1);
            for (int j = 0; j < score2[i].length; j++){
                sum2 += score2[i][j];
                System.out.printf("%5d", score2[i][j]);
            }
            avg = sum2/(float)score2[i].length; //평균
            System.out.printf("%5d %5.1f%n", sum2, avg);
        }
        System.out.println("=============================");
    System.out.printf("총점:%3d %4d %4d%n", korTotal, engTotal, mathTotal);


        /**
         *    - 2차원 배열 예제(3)
         */

        String[][] words = {
                { "chair", "의자" },      // words[0][0], words[0][1]
                { "computer", "컴퓨터" }, // words[1][0], words[1][1]
                { "integer", "정수" }     // words[2][0], words[2][1]
        };

        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < words.length; i++){
            System.out.printf("Q%d. %s의 뜻은? ", i+1, words[i][0]);

            String tmp = scanner.nextLine();

            if(tmp.equals(words[i][1])) {
                System.out.printf("정답입니다.%n%n");
            } else {
                System.out.printf("틀렸습니다. 정담은 %s입니다. %n%n", words[i][1]);
            }
        }

    }
}
