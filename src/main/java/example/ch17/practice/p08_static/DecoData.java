package example.ch17.practice.p08_static;

/**
 *  정적 메서드는 객체 생성없이 클래스에 있는 메서드를 바로 호출할 수 있다는 장점이 있다.
 *  하지만 정적 메서드는 언제나 사용할 수 있는 것이 아니다.
 *
 *  - 정적 메서드 사용법
 *    1. static 메서드는 static만 사용할 수 있다.
 *          클래스 내부의 기능을 사용할 때, 정적 메서드는 static이 붙은 정적 메서드나 정적 변수만 사용할 수 있다.
 *          클래스 내부의 기능을 사용할 때, 정적 메서드는 인스턴스 변수나, 인스턴스 메서드를 사용할 수 없다.
 *    2. 반대로 모든 곳에서 static을 호출할 수 있다.
 *          정적 메서드는 공용 기능이다. 따라서 접근 제어자만 허락한다면 클래스를 통해 모든 곳에서 static을 호출할 수 있다.
 * */
public class DecoData {
    private int instanceValue;
    private static int staticValue;

    public void instanceCall() { //인스턴스는 모든 곳에 접근 가능.
        staticValue++; //정적 변수 접근 가능
        staticMethod(); //정적 메서드 접근 가능

        instanceValue++; //인스턴스 변수 접근 가능
        instanceMethod(); //인스턴스 메서드 접근 가능
    }

    public static void staticCall(){ //static은 static 영역에만 접근 가능.
        staticValue++; //정적 변수 접근 가능
        staticMethod(); //정적 메서드 접근 가능

//        instanceValue++; //인스턴스 변수 접근 불가능, compile error(참조 값이 없기 때문)
//        instanceMethod(); //인스턴스 메서드 접근 불가능, compile error(참조 값이 없기 때문)
    }

    public static void staticCall(DecoData data){ //외부의 참조값을 직접 매개변수로 전달하면 정적 메서드도 인서턴스의 변수나 메서드를 호출할 수 있다.
        data.instanceValue++;
        data.instanceMethod();
    }

    private void instanceMethod() {
        System.out.println("instanceValue : " + instanceValue);
    }

    private static void staticMethod(){
        System.out.println("staticValue : " + staticValue);
    }
}

/**
 *  - 정적 메서드가 인스턴스의 기능을 사용할 수 없는 이유
 *    정적 메서드는 클래스의 이름을 통해 바로 호출할 수 있다. 그래서 인스턴스처럼 참조값의 개념이 없다.
 *    특정 인스턴스의 기능을 사용하려면 참조값을 알아야 하는데, 정적 메서드는 참조값 없이 호출한다.
 *    따라서 정적 메서드 내부에서 인스턴스 변수나 인스턴스 메서드를 사용할 수 없다.
 *
 *    물론 당연한 이야기지만 다음과 같이 객체의 참조값을 직접 매개변수로 전달하면 정적 메서드도 인서턴스의 변수나 메서드를 호출할 수 있다.
 *          {@code
 *              public static void staticCall(DecoData data) {
 *                  data.instanceValue++;
 *                  data.instanceMethod();
 *              }
 *          }
 *
 *
 *  - 용어 정리(멤버 메서드의 종류)
 *    1. 인스턴스 메서드 : static이 붙지 않은 멤버 메서드
 *    2. 클래스 메서드 : static이 붙은 멤버 메서드
 *                     클래스 메서드, 정적 메서드, static 메서드등으로 부른다.
 *
 *
 *  - 정적 메서드 활용
 *    객체 생성이 필요 없이 메서드의 호출만으로 필요한 기능을 수행할 때 주로 사용한다.
 *    예를 들어 간단한 메서드 하나로 끝나는 유틸리티성 메서드에 자주 사용한다.
 *    수학의 여러가지 기능을 담은 클래스를 만들 수 있는데, 이 경우 인스턴스 변수 없이 입력한 값을 계산하고 반환하는 것이 대부분이다.
 *    이럴 때 정적 메서드를 사용해서 유틸리티성 메서드를 만들면 좋다.
 * */