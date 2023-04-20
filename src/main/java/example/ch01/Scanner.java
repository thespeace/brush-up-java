package example.ch01;

public class Scanner {
    public static void main(String[] args) {

        /**
         *      1.Scanner?
         *          화면으로부터 데이터를 입력받는 기능을 제공하는 클래스
         *          화면뿐만아니라 파일로부터도 입력을 받을 수 있습니다.
         *
         *      2.Scanner를 사용하려면..?
         *          1) import문 추가
         *              ex) import java.util.*; (java util의 모든것을 사용),
         *                  Scanner만 사용하길 원한다면 import java.util.Scanner;
         *          2) Scanner 객체의 생성
         *              ex) Scanner scanner = new Scanner(System.in);
         *                  System.in : 화면 입력을 의미.
         *          3) Scanner 객체를 사용
         *              ex) int num = scanner.nextInt(); : 화면에서 입력받은 정수를 num에 저장
         *                                    nextFloat(); : 화면으로부터 실수를 입력받기.
         *                  nextInt를 사용한 위의 내용을 풀어서 설명하자면 아래 두 줄을 참고.
         *                      String input = scanner.nextLine(); : 화면에서 입력받은 문자열 한 행의 내용(줄바꿈 하기 전까지)을 input에 저장.
         *                      int num = Integer.parseInt(input); : 문자열(input)을 숫자(num)로 변환. <-> 숫자를 문자열로 변환? 숫자 +""(빈 문자열).
         *
         *      * 입출력 관련 객체들은 사용한 후 반드시 닫아줘야 하지만, 화면입력같은 경우에는 JVM에 의해 자동적으로 관리가 됩니다.
         */

        java.util.Scanner scanner = new java.util.Scanner(System.in);

        /*System.out.println("아무 숫자 두 번 입력하시오.");
        int num = scanner.nextInt();
        int num2 = scanner.nextInt();
        System.out.println(num);
        System.out.println(num2);*/

        //int num = scanner.nextInt(); 을 풀어서 적으면 아래와 같습니다.
        System.out.print("숫자를 입력하세요 : ");
        String input = scanner.nextLine(); //라인단위로 입력을 받습니다.
        int num = Integer.parseInt(input);

        System.out.println(num);
    }
}
