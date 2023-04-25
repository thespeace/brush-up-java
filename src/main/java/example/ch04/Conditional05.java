package example.ch04;

public class Conditional05 {
    public static void main(String[] args){
        /**
         *    - 반복문 for문(~하는 동안)
         *      조건을 만족하는 동안 블럭{}을 반복 - 반복횟수를 알 때 적합 <-> 반복횟수를 모른다면 while문을 사용.
         *
         *    - 문법
         *          for(초기화(1); 조건식(2); 증감식(4)){
         *              수행될 문장(3, 조건식이 참이면 수행.)
         *          } <- 조건식이 거짓이면 해당 for문을 빠져나온다.
         *
         *      예) for(int i = 1(1부터); i <= 5(5까지); i++(1씩 증가)){ <- i = 1, 2, 3, 4, 5 / 5번 실행.
         *              System.out.println("I can do it.");
         *          }
         *
         *      * 반복문의 조건식을 유의하여 작성을 해주어야 합니다.
         */

        for(int i = 11; i <= 15; i++){ //괄호 {}안의 문장을 5번 반복
            System.out.println(i + " : Hi");
        }
        System.out.println("============================");
        for(int i = 1; i <= 5; i=i+2){ // i를 2씩 증가하여 3번 반복
            System.out.println(i + " : Bye");
        }
        System.out.println("============================");
        for(int i = 1; i <= 10; i=i*2){ // i를 2의 배수로 증가하여 반복
            System.out.println(i + " : Hello");
        }
        System.out.println("============================");
        for(int i = 10; i >= 1; i--){ // i를 2의 배수로 증가하여 반복
            System.out.println(i + " : World");
        }
        System.out.println("============================");
        for(int i = 1,j = 10; i <= 10; i++, j--){ // for문에 같은 타입의 변수 2개를 사용할 수 있습니다.
            System.out.println("i=" + i + " j=" + j);
        }
        System.out.println("============================");
        int x; // 변수의 scope(범위)를 더 넓힐 수 있습니다만, 변수의 scope는 좁을 수록 좋습니다. 왜냐하면 유지보수를 위해 딱 필요한 만큼만 사용하는 것이 좋습니다.
               // 변수의 scope? 선언 위치부터 선언된 블럭의 끝까지.
        for(x = 1; x <= 3; x++){ //괄호 {}안의 문장을 5번 반복
            System.out.println("x=" + x);
        }
        System.out.println("x : "+ x); // 출력을 마치고 마지막 증감식을 실행한 후 조건식에서 거짓을 만나 for문 안의 수행문을 수행하지 못하고 빠져나왔다.

        //무한 루프
        /*for (;;){ // = for(;true;)
            System.out.println("계속 반복");
        }
        System.out.println("hi"); // 위의 for문이 무한반복되기때문에 아래의 코드는 실행되지 않기 때문에, 에러!*/


        //합계 구하기 예제.
        int sum = 0; //합계를 저장하기 위한 변수.

        /*sum += 1;
        sum += 2;
        sum += 3;
        sum += 4;
        sum += 5;*/

        for (int i = 1; i <= 5; i++){
            sum += i; //sum = sum + i;
            System.out.printf("1부터 %2d 까지의 합 : %2d%n", i, sum);
        }
    }
}
