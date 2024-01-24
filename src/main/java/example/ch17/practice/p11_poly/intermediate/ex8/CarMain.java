package example.ch17.practice.p11_poly.intermediate.ex8;

/**
 *  - OCP(Open-closed Principle) 원칙
 *    좋은 객체 지향 설계 원칙 중 하나로 OCP 원칙이라는 것이 있다.
 *      1.Open for extension : 새로운 기능의 추가나 변경 사항이 생겼을 때, 기존 코드는 확장할 수 있어야 한다.
 *      2.Closed for modification : 기존의 코드는 수정되지 않아야 한다.
 *
 *    확장에는 열려있고, 변경에는 닫혀 있다는 뜻인데, 쉽게 이야기해서 기존의 코드 수정 없이 새로운 기능을 추가할 수 있다는 의미다.
 * */
public class CarMain {
    public static void main(String[] args) {
        Driver driver = new Driver();

        //차량 선택(k3)
        K3Car k3Car = new K3Car();
        driver.setCar(k3Car);
        driver.drive();

        //차량 변경(k3 -> model3)
        Model3Car model3Car = new Model3Car();
        driver.setCar(model3Car);
        driver.drive();

        //차량 변경(model3 -> newCar)
        NewCar newCar = new NewCar();
        driver.setCar(newCar);
        driver.drive();

        /**
         *  자동차를 쓰는 핵심 클라이언트 코드인 Driver.java 코드를 변경하지 않아도 확장이 가능하다.(OCP 원칙을 지켰다)
         *  변하는 부분으로는 main()과 같이 새로운 차를 생성하고 Driver에게 필요한 차를 전달해주는 역할은 당연히 코드 수정이 발생한다.
         *  main()은 전체 프로그램을 설정하고 조율하는 역할이라 OCP를 지켜도 변경이 필요하다.
         *
         *
         *  - 전략 패턴(Strategy Pattern)
         *    디자인 패턴 중에 가장 중요한 패턴을 하나 뽑으라고 하면 전략 패턴을 뽑을 수 있다.
         *    전략 패턴은 알고리즘을 클라이언트 코드의 변경 없이 쉽게 교체할 수 있다.
         *    현재 예시 코드가 바로 전략 패턴을 사용한 코드이다.
         *    Car 인터페이스가 바로 전략을 정의하는 인터페이스가 되고, 각각의 차량이 전략의 구체적인 구현이 된다.
         *    그리고 전략을 클라이언트 코드(Driver)의 변경 없이 손쉽게 교체할 수 있다.
         *    전략 패턴은 다형성을 이용했는데 그 이외의 디자인 패턴도 절반 이상은 다형성을 이용했다.(다형성의 중요성)
         * */
    }
}
