package example.ch05;

import java.util.Arrays;

public class Array05 {
    public static void main(String[] args){
        /**
         *    - String 배열의 선언과 생성
         *      "여러개의 문자열을 저장 할 수 있는 배열"
         *
         *          ex) String[] name = new String[3]; // 3개의 문자열을 담을 수 있는 배열을 생성한다.
         *              참조변수 name -> name[0] : null, name[1] : null, name[2] : null
         *              참조변수의 기본값은 * null *이다.
         *
         *          ex) name[0] = "Kim";
         *              name[1] = "Park";
         *              name[2] = "Yi";
         *              참조변수 name -> name[0] : Kim, name[1] : Park, name[2] : Yi
         *
         *
         *          |       자료형      |        기본값      |
         *          |     boolean      |        false     |
         *          |       char       |      '\u0000'    |
         *          | byte, short, int |          0       |
         *          |        long      |         0L       |
         *          |       float      |        0.0f      |
         *          |      double      |   0.0d 또는 0.0   |
         *          |      참조형       |        null      |
         */

        String[] strArr = { "가위", "바위", "보" };
        System.out.println(Arrays.toString(strArr));

        for(int i = 0; i < 10; i ++) {
            int tmp = (int)(Math.random() * 3 );
            System.out.println(strArr[tmp]);
        }
    }
}
