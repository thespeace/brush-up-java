package example.ch05;

import java.util.Arrays;

public class Array06 {
    public static void main(String[] args){
        /**
         *    - String 클래스
         *
         *      1. String 클래스는 char[]와 메서드(기능)를 결합한 것
         *          " String 클래스 = char[] + 메서드(기능) "
         *          String(문자열)은 char(문자)의 나열.
         *
         *      2. String 클래스는 내용을 변경할 수 없다.(read only)
         *          ex) String a = "a";
         *              String b = "b";
         *              a = a + b; //위의 a,b라는 참조변수는 "a"가 저장되어 있는 0x100이라는 저장공간을 가리키고 있는 것이고, b라는 참조변수도 마찬가지로 0x200이라는 저장공간을 가리키고 있다.
         *                         //a + b 값인 "ab"가 a에 대입되는 것은 a참조변수가 가리키던 0x100의 저장공간의 값이 "ab"로 바뀌는 것이 아니라, 0x300이라는 새로운 저장공간에 "ab"값을 담고,
         *                         //그 저장공간(0x300)을 a라는 참조변수가 가리키게 되는것이다.
         *
         *    - String 클래스의 주요 메서드
         *      상당히 많은 메서드 중 자주 쓰이는 몇 가지만 소개하겠습니다.
         */

        // 1. char charAt(int index) : 문자열에서 해당 위치(index)에 있는 문자를 반환한다.
        String str = "ABCDE";
        char ch = str.charAt(3); // 문자열 str의 4번째 문자 'D'를 ch에 저장.
        System.out.println("charAt() : " + ch);

        // 2. int length() : 문자열의 길이를 반환한다.
        System.out.println("length() : " + str.length()); // 5문자.

        // 3. String substring(int from, int to) : 문자열에서 해당 범위(from~to)의 문자열을 반환한다.(to는 포함 안 됨)
        String tmp = str.substring(1,4); // str에서 index범위 1~4의 문자들을 반환
        System.out.println("substring() : " + tmp);

        // 4. boolean equals (Object obj) : 문자열의 내용이 같은지 확인한다. 같으면 결과는 true, 다르면 false 반환.
        System.out.println("equals() : " + str.equals("ABCDE"));
        System.out.println("equals() : " + str.equals("ABCD"));

        // 5. char[] toCharArray() : 문자열을 문자배열(char[])로 변환해서 반환한다.
        char[] charArray= str.toCharArray();
        for (int i = 0; i < charArray.length; i++){
            System.out.println("str.toCharArray(), char["+ i + "] : " + charArray[i]);
        }

    }
}
