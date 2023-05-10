package example.ch06;

public class OOP10 {
    public static void main(String[] args){
        /**
         *    - 메서드의 호출
         *      메서드이름(값1, 값2, ...(매개변수 혹은 parameter)); // 메서드를 호출하는 방법.
         *          ex) printSomething();       // void printSomething()을 호출.
         *              int result = add(3, 5); // int add(int x, int y)를 호출하고, 결과를 result에 저장
         */
        MyMath mm = new MyMath(); // 객체 생성
        long result1 = mm.add(5L, 3L); // add 메서드 호출
        long result2 = mm.subtract(5L, 3L);
        long result3 = mm.multiply(5L, 3L);
        double result4 = mm.divide(5L, 3L);
        long result5 = mm.max(5L, 3L);

        System.out.println("add(5L, 3L) = " + result1);
        System.out.println("subtract(5L, 3L) = " + result2);
        System.out.println("multiply(5L, 3L) = " + result3);
        System.out.println("divide(5L, 3L) = " + result4);
        System.out.println("max(5L, 3L) = " + result5);

    }
}

class MyMath { // 객체 작성
    long add(long a, long b){
            /*long result = a + b;
            return result; 아래의 한 줄로 간단히 작성 할 수 있다.*/
        return a + b;
    }
    long subtract(long a, long b) { return a - b; }
    long multiply(long a, long b) { return a * b; }
    double divide(double a, double b) {
        return a / b;
    }
    long max(long a, long b){ // 둘 중에 큰 값을 반환하는 메서드
        return a > b ? a : b;
    }
}

/**
 *    - 메서드의 실행 흐름
 *      1. main메서드에서 메서드 add를 호출한다. 인수 1L과 2L이 메서드 add의 매개변수 a,b에 각각 복사(대입)된다.
 *      2. 메서드 add의 괄호 {}안에 있는 문장들이 순서대로 수행된다.
 *      3. 메서드 add의 모든 문장이 실행되거나 return문을 만나면, 호출한 메서드(main메서드)로 되돌아와서 이후의 문장들을 실행한다.
 */
