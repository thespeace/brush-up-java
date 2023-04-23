package example.ch04;

public class Conditional01 {
    public static void main(String[] args){
        /**
         *    - 조건문과 반복문
         *      "프로그램의 실행 순서(default : 위에서 아래로)를 바꿔준다고 해서 *제어문(control flow statements)*이라고 합니다."
         *      조건문 : 조건을 만족할때만 {}를 수행(0~1번)
         *      반복문 : 조건을 만족하는 동안 {}를 수행(0~n번)
         *
         *    - if문
         *      "조건식이 참(true)일 때, 괄호 { } 안의 문장들을 수행한다."
         *      "조건식에는 boolean 타입만 반환할 수 있고, 다른 반환타입들을 에러가 납니다"
         *
         *      문법
         *          if(조건식) { <-시작
         *              //조건식이 참(true)일 때 수행될 문장들을 적는다.
         *          } <- 끝, 거짓이면 실행하지않고 다음 문장으로 넘어갑니다.
         */
        int score = 70;
        if (score > 60){
            System.out.println("합격입니다. 축하드립니다!");
        }

        //조건식의 다양한 예



        int i = 10;
        while(i-->0){
            System.out.println(i);
        }




    }
}
