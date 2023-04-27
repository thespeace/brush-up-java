package example.ch04;
import java.util.Scanner;

public class Conditional08 {
    public static void main(String[] args){
        /**
         *    - break문
         *      자신이 포함된 하나의 반복문을 벗어난다.
         */

        int sum = 0;
        int i   = 0;
        while(true){ // <- 무한 반복문, true 생략 불가. = for문 무한 반복문으로 대체가능 : for(;;){}  <- 생략 가능.
            if(sum > 100) // <- 무한 반복을 하면서 해당 식에 해당되면 벗어나는 식.
                break; // break문이 수행되면 반복문 안의 코드인 아래의 코드는 실행되지 않고 while문을 완전히 벗어난다.
            ++i;
            sum += i;
        } //end of while

        System.out.println("i   = " + i);
        System.out.println("sum = " + sum);


        /**
         *    - continue문
         *      자신이 포함된 반복문의 끝으로 이동 - 다음 반복으로 넘어감.
         *      전체 반복 중에서 특정 조건시 반복을 건너뛸 때 유용
         */

        //3의 배수는 건너뛰기
        for(int j = 0; j< 10; j++){
            if(j%3==0) // 3의 배수, 0 % 3 = 0이기에 0도 건너뜀.
                continue; // <- 조건식이 참이 되어 continue문이 수행되면 블럭의 끝으로 이동한다. break문과 달리 반복문을 벗어나지 않는다.
            System.out.println(j); // <- 어떠한 작업을 하기전에 continue문을 사용하면 해당 작업을 실행하지 않고 블럭{}을 벗어난다.
        }

        //메뉴 선택하기.
        int menu = 0;
        int num  = 0;

        Scanner scanner = new Scanner(System.in);

        while(true){//무한 반복문
            System.out.println("(1) square");
            System.out.println("(2) square root");
            System.out.println("(3) log");
            System.out.print("원하는 메뉴(1~3)를 선택하세요.(종료:0) : ");

            String tmp = scanner.nextLine(); // 화면에서 입력받은 내용을 tmp에 저장
            menu = Integer.parseInt(tmp);    // 입력받은 문자열(tmp)을 숫자로 변환

            if(menu==0){
                System.out.println("프로그램을 종료합니다.");
                break; //<- 무한 반복문을 벗어난다.
            } else if (!(1 <= menu && menu <= 3)) {
                System.out.println("메뉴를 잘못 선택하셨습니다.(종료는 0)");
                continue; //<- 무한 반복문을 계속 반복
            }

            System.out.println("선택하신 메뉴는 " + menu + "번입니다.");
        }

        /**
         *    -
         */


    }
}
