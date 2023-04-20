package example.ch03;

public class Operator04 {
    public static void main(String[] args){
        /**
         *    - 형변환 연산자
         *      "변수 또는 상수의 타입을 다른 타입으로 변환하는 것"
         *          방법 : * (타입)피연산자 *
         */

        int num = 65;
        char ch = 'A';
        float f = 1.6f;

        System.out.println("int -> char : "+(char)num); //65는 유니코드 문자표에 의해 A로 바뀝니다.
        System.out.println("char -> int : "+(int)ch);
        System.out.println("float -> int : "+(int)f); //정수형은 소수점을 저장할 수 없기 때문에, 소수점 이하는 버려집니다.
        System.out.println("int -> float : "+(float)num);


        /**
         *    - 자동 형변환
         *      형변환을 하는 이유는 주로 서로 다른 두 타입을 일치시키기 위함인데, 형변환을 생략하면 컴파일러가 알아서 자동으로 형변환을 한다.
         *          "기존의 값을 최대한 보존할 수 있는 타입으로 자동 형변환된다."
         *      그래서 표현범위가 좁은 타입에서 넓은 타입으로 형변환하는 경우에는 값 손실이 없으므로 두 타입 중에서 표현범위가 더 넓은 쪽으로 형변환된다.
         *
         *      [ byte(1byte) -> short(2byte), char(2byte, char은 부호비트가 없어서 byte에서 자동형변환이 불가능하다. 즉 양수만 존재하기 때문. 값의 범위가 다르다.)
         *                                                                              -> int(4byte) -> long(8byte) -> float(4byte) -> double(8byte) ]
         */

        float autoF = 1234; // (float)생략, integer타입이 float타입보다 크기가 작기 때문에 자동으로 담는 것에 문제가 없다.
        System.out.println("자동형변환 : "+autoF);
        //int i = 3.14f; 에러, float 범위가 integer 범위보다 넓기 때문에 * 값손실 *(값이 짤릴 수도 있어서)이 발생할 수 있어 에러가 납니다.
        int i = (int)3.14f;// 수동형변환을 해주어야 합니다.
        System.out.println("수동형변환 : "+i);

        //예를 통해 자세히 살펴보자.
        byte b = 10; // 1byte
        int integer = b; // 4byte
        System.out.println("byte -> int : " + integer); // 1byte는 4byte에 담는 것에 값손실이 없기때문에 자동 형변환가능. 2진수의 빈자리는 0으로 채워진다.

        int integer2 = 300;
        byte b2 = (byte)integer2; //갑손실이 발생할 것 같은 경우는 수동형변환, 생략 불가.
        System.out.println("int -> byte : " + b2); // 4byte를 1byte를 담으려 하니 값손실 발생!

        byte b3 = 100; //예외도 존재, byte타입의 범위(-128 ~ 127)내에 정수타입의 "리터럴(값 100)"을 대입시켜도 범위내에 존재함으로 자동형변환 가능.
        int integer3 = 100;
        System.out.println("큰 값 타입을 작은 값 타입에 자동형변환할 수 있는 예외의 경우 : " + integer3);

        byte b4 = (byte)integer3; //변수는 그 안의 값을 컴파일러가 확신할 수 없기때문에 에러를 일으킵니다. 때문에 수동형변환을 해주어야 합니다.
        System.out.println("리터럴은 가능하지만, 타입은 불가. 컴파일러에게 알려줘야 자동형변환 가능 : " + b4);

        byte b5 = (byte)1000; // 리터럴이어도 byte타입의 값의 범위를 벗어난 값이라 수동 형변환 해주어야 합니다.
        System.out.println("값의 범위를 벗어난 값을 수동으로 형변환 할 경우 값 손실이 발생 : " + b5);
    }
}
