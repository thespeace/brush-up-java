package example.ch05;

public class Array03 {
    public static void main(String[] args){
        /**
         *    - 배열의 출력
         *
         */

        int[] iArr = { 100, 95, 80, 70, 60 };
        System.out.println("integer 타입의 배열의 참조변수 출력시 : "+iArr); //배열을 가리키는 참조변수 iArr의 값을 출력.
        // [I@14318bb와 같은 형식의 문자열이 출력된다. 해당 출력문의 뜻은 첫 글자인 " [ " 는 배열을 의미하고, 다음의 " I "는 integer타입을 의미합니다.
        // " @ " 는 위치를 의미하고, 다음의 숫자와 문자들은 주소를 의미한다고 생각하시면 됩니다.

        //예외적으로는 character 배열인 경우에는 참조변수를 출력한다면 해당 참조변수의 배열들의 값들이 출력이 됩니다.
        char[] chArr = { 'a', 'b', 'c', 'd' };
        System.out.println("character 배열의 참조변수 출력시 : " + chArr);

    }
}
