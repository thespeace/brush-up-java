package example.ch07;

public class Inheritance11 {
    public static void main(String[] args){
        /**
         *    - 다형성(polymorphism)                                   ** 중요, 다형성을 이해하지 못한다면 나아가 추상클래스, 인터페이스 등을 이해하기 힘들 수 있다. **
         *      여러 가지 형태를 가질 수 있는 능력.
         *      ** 조상 타입 참조 변수로 자손 타입 객체를 다루는 것. **
         */
        Tv t = new SmartTv(); // 타입 불일치해도 가능, Tv라는 조상 타입을 t라는 조상 타입 참조 변수로 SmartTv라는 자손 타입 객체를 다루는 것을 "다형성"이라고 한다.

        /**
         *    - 다형성의 장점
         *      Q.객체와 참조변수의 타입이 일차할 때와 일치하지 않을 때의 차이?
         */
    }
}
