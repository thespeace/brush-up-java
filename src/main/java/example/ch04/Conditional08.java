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
         *    - 이름 붙은 반복문
         *      반복문에 이름을 붙여서 중첩된 경우 하나 이상의 반복문을 벗어날 수 있다.
         */

        // 구구단 * 5는 하지 않고 찍기.
        Loop1 : for(int x = 2; x <= 9; x++){ // <-Loop1이라는 이름의 for문.
            for(int y = 1; y <= 9; y++){
                if(y == 5)
                    break Loop1; //<- 변수 y로 돌아가는 for문만 벗어나는게 아니라 그 위의 이름이 붙은 반복문(Loop1)도 벗어난다.
//                  break; // 해당 반복문을 감싸는 반복문(Loop1)으로 나간다.
//                  continue Loop1; // 거의 쓰이지 않지만, Loop1반복문을 수행하러 해당 반복문을 벗어난다.
//                  continue; // 해당 반복문을 계속 진행한다.
                System.out.println(x + "*" + y + "=" + x * y);
            }// end of for y
            System.out.println();
        } // end of Loop1

        //위의 continue 예제인 메뉴 선택하기를 보충하여 이름 붙은 반복문으로 값 계산하기까지 추가한 예제.

        outer: //while문에 이름을 붙인다.
        while(true){//outer이라는 이름을 붙인 무한 반복문
            System.out.println("(1) square");
            System.out.println("(2) square root");
            System.out.println("(3) log");
            System.out.print("원하는 메뉴(1~3)를 선택하세요.(종료:0) : ");

            String tmp = scanner.nextLine();
            menu = Integer.parseInt(tmp);

            if(menu==0){
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (!(1 <= menu && menu <= 3)) {
                System.out.println("메뉴를 잘못 선택하셨습니다.(종료는 0)");
                continue;
            }

            for(;;){ //for문 무한 반복문
                System.out.println("계산할 값을 입력하세요.(계산 종료:0, 전체 종료:99) : ");
                tmp = scanner.nextLine();
                num = Integer.parseInt(tmp);

                if(num == 0)
                    break; // 계산 종료, for문을 벗어난다,

                if(num == 99)
                    break outer; // 계산 종료, for문과 while문을 모두 벗어난다.

                switch(menu) {
                    case 1:
                        System.out.println("result : " + num * num);
                        break;
                    case 2:
                        System.out.println("result : " + Math.sqrt(num));
                        break;
                    case 3:
                        System.out.println("result : " + Math.log(num));
                        break;
                }
            }//for(;;)의 끝
        }//while의 끝
        System.out.println("프로그램이 종료되었습니다.");

    }
}
