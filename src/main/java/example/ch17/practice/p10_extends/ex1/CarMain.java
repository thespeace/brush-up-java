package example.ch17.practice.p10_extends.ex1;

public class CarMain {
    public static void main(String[] args) {
        ElectricCar electricCar = new ElectricCar();
        electricCar.move();
        electricCar.charge();

        GasCar car = new GasCar();
        car.move();
        car.fillUp();
    }
}

/**
 *  - 단일 상속
 *    자바는 다중 상속을 지원하지 않는다.
 *    다중 상속을 사용하게 되면 부모클래스들에 같은 메서드가 존재할 때 어떤 것을 사용해야 할지 애매해지는 문제가 발생하기 때문이다.(다이아몬드 문제)
 *    또한 클래스 계층 구조가 매우 복잡해질 수 있기때문에 단일 상속만 가능하다.
 *    대신 인터페이스의 다중 구현을 이용해서 다중 상속을 흉내낼 수 있다.
 * */