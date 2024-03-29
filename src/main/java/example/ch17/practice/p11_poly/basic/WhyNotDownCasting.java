package example.ch17.practice.p11_poly.basic;

//다운캐스팅을 자동으로 하지 않는 이유
public class WhyNotDownCasting {
    public static void main(String[] args) {
        Parent parent1 = new Child();
        Child child1 = (Child) parent1;
        child1.childMethod(); //문제 없음.

        Parent parent2 = new Parent();
        Child child2 = (Child) parent2; //런타임 오류 - ClassCastException, 메모리 상에 존재하지 않는 인스턴스를 호출하려 했다.
        child2.childMethod(); //실행 불가.
    }
}

/**
 *  - 업캐스팅이 안전하고 다운캐스팅이 위험한 이유
 *    업캐스팅의 경우 위와 같은 문제가 절대로 발생하지 않는다.
 *    왜냐하면 객체를 생성하면 해당 타입의 상위 부모 타입은 모두 함게 생성된다.
 *    따라서 위로만 타입을 변경하는 업캐스팅은 메모리 상에 인스턴스가 모두 존재하기 때문에 항상 안전하다. 따라서 캐스팅을 생략할 수 있다.
 *    반면에 다운캐스팅의 경우 인스턴스에 존재하지 않는 하위 타입으로 캐스팅하는 문제가 발생할 수 있다.
 *    왜냐하면 객체를 생성하면 부모 타입은 모두 함께 생성되지만 자식 타입은 생성되지 않는다.
 *    따라서 개발자가 이런 문제를 인지하고 사용해야 한다는 의미로 명시적으로 캐스팅을 해주어야 한다.
 *
 *      {@code
 *          C c = new B() : 하위 타입은 대입할 수 없음, 컴파일 오류
 *          C c = (C) new B() : 하위 타입으로 강제 다운캐스팅, 하지만 B 인스턴스에 C와 관련된 부분이 없으므로 잘못된 캐스팅, ClassCastException 런타임 오류 발생.
 *      }
 *      + 참고 : 컴파일 오류 vs 런타임 오류
 *              컴파일 오류는 변수명 오타, 잘못된 클래스 이름 사용등 자바 프로그램을 실행하기 전에 발생하는 오류이다.
 *              이런 오류는 IDE에서 즉시 확인할 수 있기 때문에 안전하고 좋은 오류이다.
 *              반면에 런타임 오류는 이름 그대로 프로그램이 실행되고 있는 시점에 발생하는 오류이다.
 *              런타임 오류는 매우 안좋은 오류이다. 왜냐하면 보통 고객이 해당 프로그램을 실행하는 도중에 발생하기 때문이다.
 * */
