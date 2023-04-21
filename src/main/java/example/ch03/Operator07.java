package example.ch03;

public class Operator07 {
    public static void main(String[] args){
        /**
         *    - 비교 연산자( > < >= <= == !=)
         *      "두 피연산자를 비교해서 true(참) 또는 false(거짓)을 반환
         *
         *      > : 좌변 값이 크면, true 아니면 false
         *      < : 좌변 값이 작으면, true 아니면 false
         *      >= : 좌변 값이 크거나 같으면, true 아니면 false
         *      <= : 좌변 값이 작거나 같으면, true 아니면 false
         *      == : 두 값이 같으면, true 아니면 false
         *      != : 두 값이 다르면, true 아니면 false
         *
         *    - 문자열의 비교
         *      문자열 비교에는 == 대신 equals()를 사용해야 한다.
         */

        //문자열 선언 및 비교에 대한 차이점에 대해 알고만 넘어가기 - ch06에서 학습.
        String str1 = "abc";
        String str2 = "abc";
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));

        String str3 = new String("abc");
        String str4 = new String("abc");
        System.out.println(str3 == str4);
        System.out.println(str3.equals(str4));

    }
}
