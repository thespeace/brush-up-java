package example.ch17.practice.p09_final;

public class FinalFieldMain {
    public static void main(String[] args) {
        //final 필드 - 생성자 초기화
        System.out.println("생성자 초기화");
        ConstructInit constructInit1 = new ConstructInit(10); //생성자를 통해 딱 한번만 초기화 가능.
        ConstructInit constructInit2 = new ConstructInit(20);
        System.out.println(constructInit1.value);
        System.out.println(constructInit2.value);

        //final 필드 - 필드 초기화
        System.out.println("필드 초기화");
        FieldInit fieldInit1 = new FieldInit();
        FieldInit fieldInit2 = new FieldInit();
        FieldInit fieldInit3 = new FieldInit();
        System.out.println(fieldInit1.value);
        System.out.println(fieldInit2.value);
        System.out.println(fieldInit3.value);

        /**
         *  필드 초기화를 통한 FieldInit 인스턴스의 value값은 10으로 미리 정해져 있다.
         *  그래서 FieldInit의 객체를 3개 만든다면 모든 인스턴스가 같은 값을 사용하기 때문에 결과적으로 메모리를 낭비하게 된다.
         *  또 메모리 낭비를 떠나서 같은 값이 계속 생성되는 것은 개발자가 보기에 명확한 중복이다.
         *  이럴 때 사용하면 좋은 것이 바로 static 영역이다.
         *
         *  `static final` : static 영역에 존재해서 공용 변수이자 바뀌지 않는 변수, 즉 상수.
         *                   위 예시의 value 변수는 JVM 상에서 하나만 존재하게 되므로 중복과 메모리 비효율 문제를 모두 해결할 수 있다.
         *                   이런 이유로 필드에 final + 필드 초기화를 사용하는 경우 static을 붙여서 사용하는 것이 효과적이다.
         * */

        //상수
        System.out.println("상수");
        System.out.println(FieldInit.CONST_VALUE);
    }
}
