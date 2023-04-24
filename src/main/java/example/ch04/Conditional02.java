package example.ch04;
import java.util.Scanner;

public class Conditional02 {
    public static void main(String[] args){
        /**
         *    - if-else if문
         *      여러 개 중의 하나 - 여러 개의 조건식을 포함한 조건식.
         *
         *      if(조건식1){ <- 참(true)이면 해당 블럭만 실행되고 해당 조건문을 빠져나간다. 거짓(false)이면 다음 블럭으로 넘어가서 조건식을 수행한다.
         *          //조건식1의 연산결과가 참일 때 수행될 문장들을 적는다.
         *      }else if(조건식2){
         *          //조건식2의 연산결과가 참일 때 수행될 문장들을 적는다.
         *      }else if(조건식3){ <- 여러개의 else if문을 사용할 수 있다.
         *          //조건식3의 연산결과가 참일 때 수행될 문장들을 적는다.
         *      }else{
         *          //위의 어느 조건식도 만족하지 않을 때 수행될 문장들을 적는다.
         *      }
         */
        int score = 0;
        char grade;

        System.out.print("당신의 점수를 입력하세요 : ");
        Scanner scanner = new Scanner(System.in);
        score = scanner.nextInt();

        /*if(score >= 90){
            grade = 'A';
        } else if (80 <= score && score < 90) {
            grade = 'B';
        } else if (70 <= score && score < 80) {
            grade = 'C';
        } else {
            grade = 'D';
        }*/

        //if-else if문을 잘 이해하고 사용하면 위의 주석 처리된 조건문은 아래의 조건식으로 간략히 표현할 수 있습니다.
        if(score >= 90){
            grade = 'A';
        } else if (score >= 80) { //해당 조건식을 수행한 후, 조건식을 빠져나간다.
            grade = 'B';
        } else if (score >= 70) {
            grade = 'C';
        } else {
            grade = 'D';
        }
        System.out.println("당신의 학점은 " + grade + "입니다.");

        /**
         *    - 중첩 if문 - if문 안의 if
         *      중첩 횟수에 제약은 없습니다.
         *
         *      if(조건식1) {
         *          if(조건식2) {
         *              //조건식 1과 조건식 2가 모두 true일 때 수행될 문장들
         *          } else {
         *              //조건식 1이 true이고, 조건식2가 false일 때 수행되는 문장들
         *          }
         *      } else {
         *          //조건식1이 false일 때 수행되는 문장들
         *      }
         */
        int score2 = 0;
        char grade2 = 'D', opt = ' ';

        System.out.print("다시 한번 입력해주세요 : ");
        score2 = scanner.nextInt();
        if(score2 >= 90){
            grade2 = 'A';
            if (score2 >= 98){
                opt = '+';
            } else if (score2 < 94) {
                opt = '-';
            }
        } else if (score2 >= 80) { //해당 조건식을 수행한 후, 조건식을 빠져나간다.
            grade2 = 'B';
            if (score2 >= 88){
                opt = '+';
            } else if (score2 < 84) {
                opt = '-';
            }
        } else if (score2 >= 70) {
            grade2 = 'C';
        }

        System.out.println("당신의 학점은 "+ opt + grade2 + "입니다.");

    }
}
