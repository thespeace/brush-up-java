package example.ch04;
import java.util.Scanner;

public class Conditional03 {
    public static void main(String[] args){
        /**
         *    - switch문
         *      처리해야 하는 경우의 수가 많을 때 유용한 조건문으로 if문의 조건식으로는 true,false만 반환받을 수 있지만,
         *
         *      1) 조건식을 계산한다.
         *      2) 조건식의 결과와 일치하는 case문으로 이동한다.
         *      3) 이후의 문장들을 수행한다.
         *      4) break문이나 switch문의 끝을 만나면 switch문 전체를 빠져나간다.
         *
         *      switch(조건식) {
         *          case 값1 :
         *              //조건식의 결과가 값1과 같을 경우 수행될 문장들
         *              //...
         *              break;
         *          case 값2 :
         *              //조건식의 결과가 값2와 같을 경우 수행될 문장들
         *              //...
         *              break; <- switch문을 벗어난다.
         *          //...
         *          default : <- default 생략 가능, switch문의 제일 마지막에 적기때문에 break; 생략 가능.
         *              //조건식의 결과와 일치하는 case문이 없을 때 수행될 문장들
         *              //...
         *      }
         *
         *    - if-else문 vs switch문
         *      if-else문은 조건식의 결과가 boolean타임만 가능, switch문은 조건식의 결과가 다양한 값(정수, 문자열)을 반환할 수 있습니다.
         *      if-else문은 조건식을 여러번 써야하지만 switch문은 한 번만 작성하면 되서 더 효율적이고 가독성이 더 좋습니다.
         *      하지만 switch문은 제약조건이 있기 때문에 사용이 불가능한 경우는 if- else문을 사용합니다.
         *
         *    - switch문의 제약 조건
         *      1) switch문의 조건식 결과는 정수 또는 문자열이어야 한다. * jdk1.7전에는 정수만 허용 가능했습니다.
         *      2) case문의 값은 정수 상수(문자 포함 / 변수X), 문자열만 가능하며, 중복되지 않아야 한다.
         *
         *      int num,result;
         *         final int ONE = 1;
         *
         *         switch (result){
         *             case '1' :
         *                 System.out.println("OK, 문자 리터럴(정수 49와 동일)");
         *             case ONE :
         *                 System.out.println("OK, 정수 상수");
         *             case "YES" :
         *                 System.out.println("OK, 문자열 리터럴, JDK 1.7부터 허용");
         *             case num :
         *                 System.out.println("ERROR, 변수는 불가");
         *             case 1.0 :
         *                 System.out.println("ERROR, 실수도 불가");
         *          }
         */

        System.out.print("현재 월을 입력하세요 : ");
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt(); // 화면을 통해 입력받은 정수를 month라는 변수에 저장.

        switch (month){
            case 3:
            case 4:
            case 5:
                System.out.println("현재의 계절은 봄입니다.");
                break; // 실수로 빼먹는다면 아래의 break;를 만나기 전까지 수행합니다. 조심!
            case 6: case 7: case 8:
                System.out.println("현재의 계절은 여름입니다.");
                break;
            case 9: case 10: case 11:
                System.out.println("현재의 계절은 가을입니다.");
                break;
            default:
//            case 12: case 1: case 2:
                System.out.println("현재의 계절은 겨울입니다.");
        }

    }
}
