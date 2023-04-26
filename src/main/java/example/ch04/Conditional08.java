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

    }
}
