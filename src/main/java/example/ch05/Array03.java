package example.ch05;

import java.util.Arrays;

public class Array03 {
    public static void main(String[] args){
        /**
         *    - 배열의 출력
         */

        int[] iArr = { 100, 95, 80, 70, 60 };
        System.out.println("integer 타입의 배열의 참조변수 출력시 : "+iArr); //배열을 가리키는 참조변수 iArr의 값을 출력.
        // [I@14318bb와 같은 형식의 문자열이 출력된다. 해당 출력문의 뜻은 첫 글자인 " [ " 는 배열을 의미하고, 다음의 " I "는 integer타입을 의미합니다.
        // " @ " 는 위치를 의미하고, 다음의 숫자와 문자들은 주소를 의미한다고 생각하시면 됩니다.

        //예외적으로는 character 배열인 경우에는 참조변수를 출력한다면 해당 참조변수의 배열들의 값들이 출력이 됩니다.
        char[] characterArr = { 'a', 'b', 'c', 'd' };
        System.out.println("character 배열의 참조변수 출력시 : " + characterArr);

        //일반적으로 배열의 모든 요소를 출력.(for문 사용)
        for (int i = 0; i < iArr.length; i++){ // 0~5(0,1,2,3,4) 배열의 요소를 순서대로 하나씩 출력
            System.out.println("iArr["+ i +"] : "+iArr[i]);
        }

        //위의 for문 말고 간단하게 출력
        System.out.println(Arrays.toString(iArr)); // Arrays Class는 배열을 다루는데 필요한 methods(메서드)들을 제공. toString 메서드를 이용하면 배열의 참조변수 이름을 넣어주면 문자열로 만들어서 반환.


        //예제
        int[] iArr1 = new int[10];
        int[] iArr2 = new int[10];
//        int[] iArr3 = new int[]{100, 95, 80, 70, 60}; 아래의 식을 해당 선언 초기화식 처럼도 가능.
        int[] iArr3 = {100, 95, 80, 70, 60};
        char[] chArr = {'a', 'b', 'c', 'd'};

        for (int i = 0; i < iArr1.length; i++){
            iArr1[i] = i + 1; // 1~10의 숫자를 순서대료 배열
        }

        for (int i = 0; i < iArr2.length; i++){
            iArr2[i] = (int)(Math.random()*10) +1; // 1~10사이의 난수로 iArr2를 채움.
        }

        //배열에 저장된 값들을 출력한다.
        for (int i = 0; i < iArr1.length; i++){
            System.out.println(iArr1[i]+","); //
        }

        System.out.println();

        System.out.println("Arrays 클래스를 사용하여 출력 : " + Arrays.toString(iArr2));
        System.out.println("Arrays 클래스를 사용하여 출력 : " + Arrays.toString(iArr3));
        System.out.println("Arrays 클래스를 사용하여 출력 : " + Arrays.toString(chArr));
        System.out.println("해당 타입인 인트형 배열과 주소값을 보여줌 : " + iArr3);
        System.out.print("문자열 배열 그대로 출력 : ");
        System.out.println(chArr);

    }
}
