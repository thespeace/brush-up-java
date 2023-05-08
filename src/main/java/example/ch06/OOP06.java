package example.ch06;

public class OOP06 {
    public static void main(String[] args){
        /**
         *    - 클래스의 정의(1)
         *      클래스는 앞선 예시를 통해 설계도와 같다고 말씀드렸습니다.
         *      하지만 다른 관점에서 보면 클래스는 데이터와 함수의 결합이라고도 볼 수 있습니다.
         *
         *      "클래스 == 데이터 + 함수"
         *
         *          1. 변수 : 하나의 데이터를 저장할 수 있는 공간
         *          2. 배열 : 같은 종류의 여러 데이터를 하나로 묶어서 저장할 수 있는 공간, 같은 타입만 저장할 수 있다.
         *          3. 구조체 : 서로 관련된 여러 데이터(종류 관계 X)를 하나로 저장할 수 있는 공간, 다른 타입도 하나로 묶어서 저장할 수 있다. 서로 관계있는 변수들을 묶어 저장.
         *          4. 클래스 : 데이터와 함수의 결합(구조체 + 함수), 서로 관련있는 변수 뿐만 아니라 함수(메서드)들도 함께 묶어서 저장.
         *                     ex) 데이터를 가지고 작업, 계산을 할 때 데이터와 관련있는 함수는 같이 묶어놓는게 편리.
         *
         *      또한 사용자 정의타입이라고도 할 수 있습니다.
         *      사용자 정의 타입 : 원하는 타입을 직접 만들 수 있습니다. 그 타입이 바로 * 클래스 * 입니다.
         *          ex) 만약 시간을 다루기 위해 클래스를 찾아봤지만, 제공 클래스가 없어 사용할 수 있는 메서드가 없다면, 클래스를 생성하여 사용할 수 있다.
         *
         *          장점 : 코드가 간결해지고, 관련된 관계있는 객체들끼리 강하게 묶이기 때문에 객체지향적인 프로그래밍이 가능해집니다. 때문에 객체지향의 이점을 사용할 수 있습니다.
         *
         */

        int hour;
        int minute;
        int second;
        // -->
        Time t = new Time(); //위와 같은 코드이지만 훨씬 간결하게 작성할 수 있다.


        int hour1, hour2, hour3;
        int minute1, minute2, minute3;
        int second1, second2, second3;
        // -->
        Time t1 = new Time();
        Time t2 = new Time();
        Time t3 = new Time();//위 코드와 같은 용도로 객체를 사용할 수 있다.


        int[] hourArr = new int[3];
        int[] minuteArr = new int[3];
        int[] secondArr = new int[3];
        // -->
        Time[] tArr = new Time[3];
        tArr[0] = new Time();
        tArr[1] = new Time();
        tArr[2] = new Time(); // 객체 배열로 바꾸어 시,분,초가 따로 묶이는 일이 없어져서 원하는 관계를 강하게 만들어 사용할 수 있다.


        hour = 12;
        minute = 34;
        second = 56; // 비 객체지향적 코드
        // -->
        t.hour = 12;
        t.minute = 34;
        t.second = 56; // 객체지향적 코드, 자바와 같은 객체지향 언어에서는 객체지향적 코드를 작성하는 것이 더 바람직하다.

    }
}
class Time{
    int hour;
    int minute;
    int second;
}
