package example.ch04;

public class Conditional01 {
    public static void main(String[] args){
        /**
         *    - 조건문과 반복문
         *      "프로그램의 실행 순서(default : 위에서 아래로)를 바꿔준다고 해서 *제어문(control flow statements)*이라고 합니다."
         *      조건문 : 조건을 만족할때만 {}를 수행(0~1번) ex) if문, if-else문, if-else if문, switch문.
         *      반복문 : 조건을 만족하는 동안 {}를 수행(0~n번) ex) for문, while문.
         *
         *    - 블럭 { }
         *      여러 문장을 하나로 묶어주는 것
         *      실행되는 코드는 가독성을 위해 탭(tap)에 의한 들여쓰기를 해줍니다.
         *
         *    - if문
         *      "조건식이 참(true)일 때, 괄호 { } 안의 문장들을 수행한다."
         *      "조건식에는 boolean 타입만 반환할 수 있고, 다른 반환타입들을 에러가 납니다"
         *
         *      문법
         *          if(조건식) { <-블럭의 시작
         *              //조건식이 참(true)일 때 수행될 문장들을 적는다.
         *          } <- 블럭의 끝, 거짓이면 실행하지않고 다음 문장으로 넘어갑니다.
         */
        int score = 70;
        if (score > 60)
            System.out.println("점수가 60을 초과하여, 합격입니다. 축하드립니다!"); // if문에 속한 문장이 *하나*이면, 블럭 {}을 생략할 수 있습니다.

        //반복문
        int i = 10;
        while(i-->0)
            System.out.println("반복문 출력 : "+i);

        //조건식의 다양한 예
        int a = 95;
        if(90 <= a && a <= 100){
            System.out.println("a는 정수 90이상 100이하입니다.");
        }

        int b = -1;
        if(b < 0 || b > 100){
            System.out.println("정수 b가 0보다 작거나 100보다 큰 수 입니다.");
        }

        int c = 9;
        if (c % 3 == 0 && c % 2 != 0){
            System.out.println("정수 c가 3의 배수지만, 2의 배수는 아닌 정수입니다.");
        }

        char d = 'Y';
        if (d == 'y' || d == 'Y'){
            System.out.println("문자 d는 'y' 이거나 'Y'인 문자입니다.");
        }

        char e = ' ';
        if (e == ' ' || e == '\t' || e == '\n'){
            System.out.println("문자 e는 공백이거나 탭 또는 개행 문자입니다.");
        }

        char f = 'G';
        if ('A' <= f && f <= 'Z' ){
            System.out.println("문자 f는 대문자입니다.");
        }

        char g = 'g';
        if ('a' <= g && g <= 'z' ){
            System.out.println("문자 g는 소문자입니다.");
        }

        char h = '7';
        if ('0' <= h && h <= '9' ){
            System.out.println("문자 h는 숫자입니다.");
        }

        String str = "yes";
        if (str.equals("yes")){
            System.out.println("문자열 str은 소문자 yes 문자열 입니다.");
        }

        if (str.equalsIgnoreCase("Yes")){
            System.out.println("문자열 str은 대문자여도 equalsIgnoreCase메소드를 사용하면 대소문자를 구별하지 않기때문에 YES 문자열도 참입니다.");
        }

        /**
        *       - if-else문
         *          둘 중의 하나 - 조건식이 참일 때와 거짓일 때로 나눠서 처리.
         *
         *          if(조건식){
         *              //조건식이 참(true)일 때 수행될 문장들을 적는다.
         *          } else {
         *              //조건식이 거짓(false)일 때 수행될 문장들을 적는다.
         *          }
        */
        int input = 1;
        if(input == 0){
            System.out.println("input은 0입니다.");
        }
        if(input != 0){
            System.out.println("input은 0이 아닙니다.");
        }

        // 위의 식보다는 아래의 코드가 더 효율적이고 조건식을 이해하기도 편리합니다.
        if (input == 0){
            System.out.println("input은 0입니다.");
        }else {
            System.out.println("input은 0이 아닙니다.");
        }



    }
}
