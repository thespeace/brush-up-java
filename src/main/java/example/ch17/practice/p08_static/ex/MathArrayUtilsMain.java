package example.ch17.practice.p08_static.ex;

import static example.ch17.practice.p08_static.ex.MathArrayUtils.*; //static import

public class MathArrayUtilsMain {
    public static void main(String[] args) {
//        MathArrayUtils mathArrayUtils = new MathArrayUtils(); //어느정도의 제약 : 인스턴스 생성을 막아두면 개발자 입장에서 정적 메서드를 가지고 있다는 것을 알게된다.

        int[] values = {1, 2, 3, 4, 5};

        System.out.println("sum=" + sum(values));
        System.out.println("average=" + average(values));
        System.out.println("min=" + min(values));
        System.out.println("max=" + max(values));
    }
}
