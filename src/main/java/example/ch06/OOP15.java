package example.ch06;

public class OOP15 {
    public static void main(String[] args){
        /**
         *    - 오버 로딩
         *      Overloading : 과적하다.
         *      한 클래스 안에 같은 이름의 메서드 여러 개 정의하는 것, 자바에서는 오버로딩을 지원하기 때문에 가능하다.
         *          "메서드 이름(1개) : 메서드(N개)"
         *          ex) 대표적인 예, println() : 매개변수의 타입을 확인하고 그 값에 맞는 메서드를 사용하여 출력해준다.
         *
         *    - 오버 로딩을 하는 이유?
         *      메서드의 이름은 대부분 어떠한 작업을 수행하기 때문에 보통 동사이다. ex) print, round, random, add ...
         *      여기에서 이름이 같다라는 것은 하는 작업이 같다는 뜻이다.
         *      의미상으로 같은 작업을 수행해야 하지만 매개변수의 타입이 다양하거나 다를 수 있는 경우, 주로 오버로딩을 하는 것이다.
         *      더불어 원래 정확한 명칭은 '메서드 오버로딩'이다
         *          + 참고! C++ 연산자 오버로딩, 자바에서도 존재한다. " + "(부호, 덧셈, 문자열 결합) : 사용자가 직접 연산자 오버로딩을 할 순 없지만 자바가 제공하는 것을 사용할 수 있다.
         *
         *    - 오버 로딩이 성립하기 위한 조건
         *      1. 메서드 이름이 같아야 한다.
         *      2. 매개변수의 개수 또는 타입이 달라야 한다.
         *      3. 반환 타입은 영향없다.
         */

        //대표 적인 자바 기본 제공 메서드 오버로딩 예시.
        System.out.println(0.123);
        System.out.println(123);
        System.out.println(9999999999999L);
        System.out.println(9999999999999D);
        System.out.println(true);
        System.out.println('C');
        System.out.println("Charter");


        Over o = new Over();
        System.out.println("o.add(3, 3) 결과 : " + o.add(3,3));
        System.out.println("o.add(3L, 3) 결과 : " + o.add(3L,3));
        System.out.println("o.add(3, 3L) 결과 : " + o.add(3,3L));

        MyMath3 mm = new MyMath3();
        int[] arr = {100, 200, 300};
        System.out.println("mm.add(배열) 결과 : " + mm.add(arr));


    }
}
//ambiguous(모호)하지만 오버로딩이 성립하기 위한 조건을 충족한 예.
class Over{
//    int add(int a, int b){ return a+b; }
//    long add(int a, int b){ return a+b; } <- 반환 타입은 아무 영향 없다. 또한 매개변수의 타입이 같기때문에 에러.
    int add(int a, int b){ return a+b; }
    long add(long a, int b){ return a+b; } // <- 매개변수 타입이 다르기 때문에 메서드를 구별할 수 있어 오버로딩이 성립. 호출 예 : add(3L, 3);
    long add(int a, long b){ return a+b; } // <- 매개변수 타입이 다르기 때문에 메서드를 구별할 수 있어 오버로딩이 성립. 호출 예 : add(3, 3L);
}

//오버로딩의 올바른 예 - 매개변수는 다르지만 같은 의미의 기능 수행.
class MyMath3{
    int add(int a, int b){
        System.out.println("int add(int a, int b) - ");
        return a+b;
    }
    long add(long a, long b){
        System.out.println("long add(long a, long b) - ");
        return a+b;
    }
    int add(int[] a){ // 배열의 모든 요소의 합을 결과로 돌려준다.
        System.out.print("int add(int[] a) - ");
        int result = 0;
        for(int i = 0; i < a.length; i++)
            result += a[i];
        return result;
    }
}
