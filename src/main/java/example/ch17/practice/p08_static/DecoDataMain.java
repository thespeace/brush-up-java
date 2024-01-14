package example.ch17.practice.p08_static;

public class DecoDataMain {
    public static void main(String[] args) {
        System.out.println("1. 정적 호출");
        DecoData.staticCall();

        System.out.println("2. 인스턴스 호출1");
        DecoData data1 = new DecoData();
        data1.instanceCall();

        System.out.println("3. 인스턴스 호출2");
        DecoData data2 = new DecoData();
        data2.instanceCall();
    }
}

/**
 *  - main() 메서드는 정적 메서드
 *    인스턴스 생성 없이 실행하는 가장 대표적인 메서드가 바로 main() 메서드이다.
 *    main() 메서드는 프로그램을 시작하는 시작점이 되는데, 생각해보면 객체를 생성하지 않아도 main()메서드가 작동했다. 이것은 main()메서드가 static 이기 때문이다.
 *    정적 메서드는 정적 메서드만 호출 할 수 있다는 점을 기억해보면 main()메서드도 마찬가지이다.
 * */