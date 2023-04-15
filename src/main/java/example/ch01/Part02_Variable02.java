package example.ch01;

public class Part02_Variable02 {
    public static void main(String[] args){
        /**
         *  -변수의 타입?
         *  변수의 타입은 변수에 저장할 값의 타입에 의해 결정됩니다. 변수는 값을 저장하기 위해 필요한 것이기 때문입니다.
         *  저장할 값의 타입과 일치하는 타입으로 변수를 선언해야 합니다.
         *
         *  -값의 타입?
         *  변수의 타입을 알아보기에 앞서 값의 타입에 대해 알아보겠습니다.
         *
         *      1) 기본형 (Primitive type)
         *          - 값(data)의 종류와 크기
         *
         *              |  종류  |                                   설  명                                    |      크기(byte)      | * 1bit = 2진수 1자리( 0 or 1 ) -> 1byte = 8bit.
         *              | 논리형 | true와 false중 하나를 값으로 갖으며, 조건식과 논리적 계산에 사용된다.           |  boolean(1)         |
         *              | 문자형 | 문자를 저장하는데 사용되며, 변수 당 하나의 문자만을 저장할 수 있다.              |  char(2)            |
         *              |       |               <-> 여러문자(문자의 배열)는 String.                             |                     |
         *              | 정수형 | 정수 값을 저장하는데 사용된다. 주로 사용하는 것은 int와 long(아주 큰 정수)이며,   | byte(1), short(2)  | * integer 타입이 default 타입.
         *              |       | byte는 이진 데이터를 다루는데 사용되며, short는 c언어와의 호환을 위해 추가되었다. |  int(4), long(8)   |
         *              | 실수형 | 실수 값을 저장하는데 사용된다. float와 double이 있다.                          | float(4), double(8) | * double은 float보다 정밀도가 2배.
         *
         *              자바에서는 이와 같이 값의 종류에 따라 모두 8개의 타입을 정의할 수 있는데 이를 * 기본형 *이라고 합니다.
         *              값, 즉 데이터의 가장 기본이 되는 타입입니다.
         *              변수를 선언할때는 이중에서 변수에 저장할 값에 가장 적합한 것을 골라서 변수의 타입으로 지정하면 됩니다.
         *
         *          - 표현범위(1/3)
         *              1 bit = 0, 1 //2개
         *              2 bit = 00, 01, 10, 11 //4개
         *              그렇다면, n비트로 표현할 수 있는 값의 개수 : 2의 n제곱 갯수
         *                  8 bit = 2의 8제곱 = 즉, 256개의 값을 표현할 수 있습니다. 1~256
         *              n비트로 표현할 수 있는 부호없는 정수(양수)의 범위 : 0 ~ 2의 n제곱 - 1
         *                  8 bit = 0~255
         *              n비트로 표현할 수 있는 부호있는 정수의 범위 : 양수와 음수를 모두 표현할 수 있어야 하기 때문에, 표현할 수 있는 범위의 절반을 음수표현에 사용해야 합니다.
         *                  -2의 n-1제곱 ~ 2의 n-1제곱 -1 = -128~127
         *              * 자바에서 정수형은 모두 부호가 있어서 바로 위의 식과 타입의 크기만 알고있다면, 각 정수형의 범위를 쉽게 계산해 낼 수 있습니다. "2의 n-1제곱 ~ 2의 n-1제곱 -1" *
         *
         *          - 표현범위(2/3)
         *              이제, 각 정수형 타입의 변수에 저장할 수 있는 값의 범위를 직접 계산해서 확인해보겠습니다.
         *
         *              byte -2의 7제곱 ~ 2의 7제곱 - 1
         *                  S : 7 bit -> S를 부호비트(Sign bit)라 합니다.   0 이면 양수, 1이면 음수입니다.
         *
         *
         *
         *
         *      2) 참조형(Reference Type)
         *          기본형을 제외한 나머지는 * 참조형 *이라 합니다. ex) String, System 등등 추가해서 사용한다면 무한대입니다.
         *          기본형은 실제 값을 저장하지만 참조형을 메모리 주소를 저장합니다. ex) 4byte 또는 8byte ...
         *          참조형은 타입에 관계없이 변수의 크기가 항상 4byte입니다.
         *          4byte로 표현할 수 있는 크기는 대략 40억정도이기 때문에 4byte의 참조변수로는 약 40억 바이트 즉, 4GB를 다룰 수 있습니다.
         *          O.S와 JVM에 사용하는 부분을 제외하면 실제로 프로그램에서 사용할 수 있는 메모리는 4GB의 절반인 2GB도 안됩니다.
         *          이처럼 32bit JVM에서 참조변수의 크기는 4byte 즉 32bit지만, 64bit JVM에서는 참조변수의 크기를 8byte 즉, 64bit입니다.
         *          그래서 64bit JVM에서 다룰 수 있는 최대 메모리는 40억 * 40억 = 160경byte, 즉 1600만TB입니다.
         *          정말 어마어마하게 큰 값이지만 이것은 어디까지나 이론적인 계산에 의한 값이고, 실제로 사용할 수 있는 메로리는 TB단위 정도입니다.
         *          ex) Date Today; // 참조형 변수 today를 선언, 변수의 타입은 기본형 8개에 해당하지 않음으로 참조형인 것을 쉽게 알 수 있습니다.
         *              today = new Date(); // new Date()로 객체를 생성하고 생성된 * 객체의 주소를 참조변수 today에 저장 *, 이제 참조변수 today를 통해서 생성된 객체를 사용할 수 있습니다.
         */

        int age = 25; // int : 정수(integer)형 타입
        double pi = 3.14; // double : 실수형 타입
        char ch = '가'; // char : 문자(character)형 타입

        /**
         *  - 변수 , 상수, 리터럴
         *  변수(Variable) : 하나의 값을 저장하기 위한 공간
         *  상수(Constant) : * 한 번만 * 값을 저장 가능한 변수
         *  변수와 상수는 값을 하나만 저장할 수 있는 공간이라는 것은 같은데, 변수는 값을 저장했다하더라도 변경이 가능하지만, 상수는 값을 처음에 한 번 저장하고 나면 다음에 값을 변경할 수 없습니다.
         *  리터럴(literal) : 변수와 상수와 관계없이 * 값 그 자체 *를 의미하는 것입니다.
         *                   사실 상수와 완전히 같은 개념이지만, 굳이 리터럴이라고 표현하는 이유는 자바에서 상수를 한 번만 값을 저장 가능한 변수라고 정의했기 때문입니다.
         *                   이를 구별하기 위해서 어쩔 수 없이 리터럴이라는 용어를 사용하는 것입니다.
         */

        int score = 100; // 변수(score)에 100인 값을 초기화
            score = 200; // 새로운 값인 200이 저장됩니다.

        final int MAX = 100; // 상수(MAX) 선언, 상수에 100을 저장합니다. 상수를 선언하는 방법은 변수를 선언하는 방법과 똑같지만, 타입 앞에 * final *이라는 키워드를 붙여야만 합니다.
                  //MAX = 200; // 상수에는 이미 100이라는 값이 저장되어 있기떄문에 에러가 발생합니다.

        System.out.println("변수(score) : " + score);
        System.out.println("상수(MAX) : " + MAX);
    }
}
