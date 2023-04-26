package example.ch04;

public class Conditional06 {
    public static void main(String[] args){
        /**
         *    - 중첩 for문
         *      for문 내에 또 다른 for문을 포함시킬 수 있다.
         */

        //구구단
        for(int i = 2; i <= 9; i++){
            for(int j = 1; j <= 9; j++){
                System.out.println(i + " * " + j + " = " + (i * j));
            }
            System.out.println("=============");
        }

        //별 찍기
        for(int i = 0; i < 5; i++){ //i = 0, 1, 2, 3, 4 / 5번 {}안의 내용을 반복
            for(int j = 0; j < 10; j++){ //j = 0~9  / 10번 {}안의 내용을 반복
                System.out.print("*");
            }
            System.out.println(); // 10번 반복한 후 줄바꿈
        }

        /**
         *    - 별 계단 만들기
         *      | i | j |
         *      | 1 | 1 |
         *      | 2 | 2 |
         *      | 3 | 3 |
         *      | 4 | 4 |
         *      | 5 | 5 |
         *
         *      한 행(i)당 하나 씩(j) 늘어나면 된다.
         * */
        for(int i = 0; i < 5; i++){ //i = 0, 1, 2, 3, 4 / 5번 {}안의 내용을 반복
            for(int j = 0; j <= i; j++){ //j = 0~9  / 10번 {}안의 내용을 반복
                System.out.print("*");
            }
            System.out.println(); // 10번 반복한 후 줄바꿈
        }
    }
}
