package example.ch01;

public class Part01_Print {
    public static void main(String[] args) {

        // System.out : *표준 출력 스트림*으로 전달 받은 데이터를 스트림을 통해 출력 장치로 전달되어 사용자에게 출력.
        System.out.println("Hello world!");

        /**
         *      1. print() : 출력 후, 줄바꿈 안함. println() : 출력 후 줄바꿈.
         *          단점 1)출력형식 지정불가!
         *              2)10진수로만 출력된다.
         *                  8진수, 16진수로 출력하려면?
         */
        System.out.println("정수/정수 ? "+10/3+"(정수)");
        System.out.println("실수/정수 ? "+10.0/3+"(실수)");
        System.out.println("16진수 값인 1A를 출력하면 ? "+0x1A+"(10진수로 변환되어 출력)");

        /**      2. Printf() : 출력 형식 지정 가능.
         *          괄호안에 지시자, 출력값을 입력하여 원하는 출력형식을 지정하여 출력 할 수 있습니다. ex) ("지시자", 출력값);
         *          자동으로 줄바꿈이 되지 않는다. 때문에 \n이나 %n을 사용해서 줄바꿈을 해줘야하는데, %n는 os에 관계없이 공통으로 쓰여지기 때문에 %n을 사용하는 것이 좋다.
         *
         *          지시자의 형태?
         *              정수형 : %b, %d, %o, %x/%X
         *              실수형 : %f, %e/%E
         *              문자,문자열 : %c, %s
         *              그 외의 지시자의 형태는 Java공식문서 -> Formatter에서 확인.
         *
         *          | 지시자 |                 설   명                   |
         *          |  %b  |      불리언(*b*oolean) 형식으로 출력          |
         *          |  %d  |     10진(*d*ecimal) 정수의 형식으로 출력      |
         *          |  %o  |     8진(*o*ctal) 정수의 형식으로 출력         |
         *          |%x, %X|    16진(he*x*a-decimal) 정수의 형식으로 출력  |
         *          |  %f  | 부동 소수점(*f*loating-point)의 형식으로 출력  |
         *          |%e, %E|    지수(*e*xponent)표현식의 형식으로 출력      |
         *          |  %c  |           문자(*c*haracter)로 출력          |
         *          |  %s  |          문자열(*s*tring)로 출력            |
         *          |2진출력| 지시자는 없고, Integer.toBinaryString메서드로 2진 문자열로 출력 |
         *
         */
        System.out.printf("실수형 출력 :%.2f\n", 10.0/3);
        System.out.printf("10진수로 출력 :%d%n", 0x1A);
        System.out.printf("16진수로 출력 :%X%n", 0x1A);
        System.out.printf("두가지 지시자를 사용 : age:%d year:%d%n", 14 , 2023);

        // 8진수와 16진수에 접두사 붙이기 (#)
        System.out.printf("#을 붙여 8진수 접두사 출력 :%#o%n", 15);
        System.out.printf("#을 붙여 16진수 접두사 출력 :%#x%n", 15);
        System.out.printf("#을 붙여 16진수 접두사 출력 :%#X%n", 15);

        //실수 출력을 위한 지시자
        float f = 123.4567890f;
        System.out.printf("실수의 소수점아래 6자리까지 출력 : %f%n", f); //정밀도 7자리까지는 정확하지만(123.4567), 그이후의 숫자는 의미없는 숫자입니다.
        System.out.printf("실수를 지수형식으로 출력 : %e%n", f); // e+02 : 10의 2제곱, 마지막 값의 반올림은 의미가 없이 그냥 보여주는 것이고, 실제 저장된 값은 같습니다.
        System.out.printf("실수를 간략한 형식으로 출력 : %g%n", 123.456789); // 간략한 형식, 7자리, 마지막 숫자는 반올림
        System.out.printf("실수를 간략한 형식으로 출력 : %g%n", 0.00000001);

        //지시자에 숫자를 붙이면 출력되는 자릿수를 조절할 수 있습니다.
        System.out.printf("정수의 자릿수를 지정하여 출력 : [%5d]%n", 10); //지정한 자릿수는 5자리인데, 출력할 값이 2자리밖에 안되니까 나머지는 공백이 출력.
        System.out.printf("정수의 자릿수에서 왼쪽정렬로 출력 : [%-5d]%n", 10); //왼쪽 정렬로 바꾸기 위해서는 지시자앞에 - 를 붙여주면 됩니다.
        System.out.printf("공백대신 숫자 0으로 치환하여 출력 : [%05d]%n", 10); //지시자 앞에 0 을 붙이면 공백대신에 0으로 채워줍니다.

        //실수 자릿수 조절 : %전체자리.소수점아래자리f
        System.out.printf("실수 자릿수 조절하여 출력 : d=[%14.10f]%n", 1.23456789); //전체 14자리 중 소수점 아래 10자리 / 1.소수점자리의 공백을 0으로 채우고, 전체 자리의 빈자리는 공백으로 채웁니다.

        // 문자열 자릿수 조절
        String url = "www.thespeace.com";
        System.out.printf("지시자를 이용한 문자열 출력 : [%s]%n", url);
        System.out.printf("출력 공간을 지정하여 문자열 출력 : [%20s]%n", url);
        System.out.printf("출력 공간을 지정하여 문자열 왼쪽 정렬 출력 : [%-20s]%n", url);
        System.out.printf(".과 숫자를 이용하여 전체 중 일부 문자열만 출력 : [%.8s]%n", url); // . 과 숫자를 붙이면 전체 문자열의 일부만 출력할 수 있습니다.

        // TODO System 클래스의 표준 에러 출력(err)은 다음에 알아 보도록 하자.

    }
}
