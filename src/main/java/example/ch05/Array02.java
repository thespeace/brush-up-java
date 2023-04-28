package example.ch05;

public class Array02 {
    public static void main(String[] args){
        /**
         *    - 배열의 길이
         *      배열이름.length - 배열의 길이(int형 상수)
         *          "배열은 한번 생성하면 그 길이를 바꿀 수 없다."
         */

        int[] arr = new int[5];
        int tmp = arr.length;
        System.out.println("arr배열의 길이는 : " + tmp);

    }
}
