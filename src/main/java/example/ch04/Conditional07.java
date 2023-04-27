package example.ch04;
import java.util.Scanner;

public class Conditional07 {
    public static void main(String[] args){
        /**
         *    - While문
         *      조건을 만족시키는 동안 블럭{}을 반복 - 반복횟수 모를 때 <-> 반복횟수를 알때는 for문
         *
         *    - 문법
         *      while(조건식(1)) { <- 거짓(false)일때 while문을 빠져나간다.(3)
         *          수행될 문장(2) // 조건식의 연산결과가 참(true)인 동안, 반복될 문장들을 적는다.
         *      }
         *
         *      반복문의 원조는 while문! while문의 문법을 간결하게 만든 것이 for문이다.
         *      while문와 for은 100% 호환이 가능하다. <-> if문과 switch문은 100% 호환은 불가.
         *      아래의 예시 참고.
         */

        int j = 0; //초기화
        while(j < 10){ //조건식
            System.out.println("while문 : " + j);
            j++; //증감식
        }

        //초기화, 조건식, 증감식
        for(int i = 0; i < 10; i++){
            System.out.println("for문 : " + i);
        }

        System.out.println("=============================");

        //조건식 + 증감식.
        int a = 5; //반복 횟수 초기화 변수 선언.
        while(a-- != 0){
            System.out.println(a + " : " + "조건식과 증감식을 합칠 수 있다.");
        }

        System.out.println("=============================");

        //변수에 증가된 값을 더하기.
        int sum = 0;
        int b = 0;
        while(sum <= 100){
            System.out.printf("%d - %d%n", b, sum);
            sum += ++b;
        }

        System.out.println("=============================");

        //각 자리수의 합 구하기.
        int num = 12345, sumNum = 0;
        while(num > 0){
            System.out.println("sumNum = " + sumNum + ", num % 10 : " + num % 10); // 10으로 나머지 연산을 하면 마지막 자리의 값을 얻는다.
            sumNum += num % 10;
            num = num / 10;
        }
        System.out.println("각 자리수의 합 : " + sumNum);

        System.out.println("=============================");


        /**
         *    - Do-While문
         *      While문의 변형, 블럭{}을 최소한 * 한 번 * 이상 반복 - 사용자 입력받을 때 유용
         *
         *    - 문법
         *      do {
         *          (1) // 조건식의 연산결과가 참일 때 수행될 문장들을 적는다.(처음 한 번은 무조건 실행)
         *      } while (조건식(2)); <- 끝에 ';'을 잊지 않도록 주의!
         *
         *      * While문은 조건문이 처음부터 거짓(false)이면 아예 실행이 안될수도(0번 ~ n번 반복) 있는 반면, Do-While문은 꼭 한번은 실행됩니다.(1번 ~ n번 반복)
         */

        //랜덤한 값을 사용자가 1부터 100사이의 정수를 입력받아 맞추는 예제.
        int input = 0, answer = 0;

        answer = (int)(Math.random() * 100) + 1; // 1 ~ 100사이의 랜덤한 값 생성
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("1과 100사이의 정수를 입력하세요 : ");
            input = scanner.nextInt();

            if(input > answer){
                System.out.println("더 작은 수로 다시 시도해보세요.");
            }else if(input < answer){
                System.out.println("더 큰 수로 다시 시도해보세요.");
            }
        } while (input != answer);
        System.out.println("축하합니다. 정답입니다!");

        //while으로 해당 코드를 프로그래밍하면 코드의 중복이 발생할 수 있다. 사용자로부터 입력을 받을 때에 사용하기 적합하다.

    }
}
