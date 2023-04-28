package example.ch05;
import java.util.Scanner;

public class array01 {
    public static void main(String[] args){
        /**
         *    - 배열이란?
         *      "배열은 같은 타입의 여러 변수를 하나의 묶음으로 다루는 것"
         */

        int class1,class2,class3,class4,class5; // 이처럼 번호를 매기며 변수에 저장공간을 할당하지만 예를 들어 100개를 생성하려면 끝이 없기 때문에 배열이 등장.
        int[] Class = new int[3]; // 정수형 배열을 참조변수에 선언, int값 5개를 저장할수 있는 이름이 없는 연속적으로 붙어있는 저장공간 선언.
                                  // 대신 이름대신 * 참조변수 *와 * 인덱스 *를 사용.
                                  // 같은 타입만 배열로 선언할 수 있다.
        System.out.println("참조변수 + 첫번째 인덱스 : " + Class[0]);
        System.out.println("참조변수 + 두번째 인덱스 : " + Class[1]);
        System.out.println("참조변수 + 세번째 인덱스 : " + Class[2]);


        /**
         *    - 배열의 선언과 생성
         *      배열의 선언 - 배열을 다루기 위한 참조변수의 선언
         *
         *    - 선언 방법
         *      1) 타입[] 참조변수이름;
         *          : 배열기호가 타입의 일부라고 보기때문에 해당 선언방법을 선호.
         *          ex) int[] score;  String[] name; (java 스타일)
         *      1) 타입 참조변수이름[];
         *          ex) int score[];  String name[]; (c언어 스타일)
         *
         *    - 생성 방법
         *      변수이름 = new 타입[길이];
         *          : 배열을 생성(실제 저장공간을 생성)
         *
         */
        int[] array;        // <- int타입의 배열을 다루기 위한 참조변수 array선언
        array = new int[5]; // <- int타입의 값 5개를 저장할 수 있는 배열(저장공간) 생성, 5개(0~4)
                            // 어딘가에 할당되어있는 저장공간의 주소값을 대입연산자에 의해서 참조변수에 주소값이 저장됩니다.
                            // 참조변수가 할당한 저장공간을 가리키고 있는 것입니다.

        /**
         *    - 배열의 인덱스
         *      각 요소(저장공간)에 자동으로 붙는 일련번호
         *          "인덱스(index)의 범위는 0부터 '배열길이 -1' 까지."
         *
         *      int[] score = new int[5]; // 길이가 5개인 int배열을 선언을 했으면, 각각의 저장공간인 *배열의 요소* 들의 연결로 배열이 생성이 되고, 0~4개 총 5개의 *배열의 인덱스*가 할당이 됩니다.
         *      score[3] = 100; // 배열 score의 4번째 요소에 100을 저장합니다.
         *      int value = score[3]; // 배열 score의 4번째 요소의 값을 읽어서 value에 저장. 기존의 변수를 사용하는 것과 똑같다.
         */

        // 배열을 생성하고 읽고 변수에 담아 출력하는 간단한 예제.
        //int[] score;        // 1. 배열 score를 선언(참조변수 선언)
        //score = new int[5]; // 2. 배열의 생성(int저장공간 * 5)
        int[] score = new int[5]; // 1+2. 배열의 선언과 생성을 동시에.
        score[3] = 100;
        System.out.println("score[0]="+score[0]);
        System.out.println("score[1]="+score[1]);
        System.out.println("score[2]="+score[2]);
        System.out.println("score[3]="+score[3]);
        System.out.println("score[4]="+score[4]);

        int value = score[3];
        System.out.println("value="+value);
    }
}
