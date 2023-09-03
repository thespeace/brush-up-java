package example.ch14;

/**
 *    - 함수형 인터페이스가 사용된 예시.
 *      1. 익명 객체를 람다식으로 대체
 *
 *          {@code Comparator 인터페이스.
 *              @FunctionalInterface
 *              interface Comparator<T> {
 *                  int compare(T o1, T o2);
 *              }
 *          }
 *
 *          {@code 람다식 사용 예시
 *              List<String> list = Arrays.asList("abc", "aaa", "bbb", "ddd", "aaa");
 *
 *              Collections.sort(list, new Comparator<String>() {
 *                                         public int compare(String s1, String s2) {
 *                                             return s2.compareTo(s1);
 *                                         }
 *                                     }
 *              // 예전에는 리스트를 정렬할 때, Comparator을 위와같이 작성하여 사용했는데 람다식으로 교체.
 *
 *              Collections.sort(list, (s1, s2) -> s2.compareTo(s1)); // 복잡한 코드를 간단하게 작성.
 *          }
 *
 *
 *
 *    - 함수형 인터페이스 타입의 매개변수, 반환타입
 *
 *      함수형 인터페이스 타입의 매개변수
 *      {@code
 *          @FunctionalInterface
 *          interface MyFunction {        // 람다식에 -
 *              void myMethod();          // 이름을 붙여주고 -
 *          }
 *
 *          void aMethod (MyFunction f) { // 람다식을 매개변수로 받아-
 *              f.myMethod(); // MyFunction에 정의된 메서드(람다식) 호출.
 *          }
 *
 *          //사용
 *          Myfunction f = () -> System.out.println("myMthod()"); // 람다식을 참조변수에 담고-
 *          aMethod(f);     //참조변수를 매개변수로 넣어 호출.
 *
 *          aMethod(()-> System.out.println("myMthod()")); // 람다식을 직접 매개변수로 넣어 호출.
 *      }
 *
 *      함수형 인터페이스 타입의 반환타입
 *      {@code
 *          MyFunction myMethod() {
 *              MyFunction f = () -> {} ;
 *              return f;
 *
 *              return ()->{}; //위 코드를 줄여서 한줄로 작성 가능.
 *          }
 *      }
 */

@FunctionalInterface
interface MyFunction{
    void run(); // public abstract void run();
}

public class Lambda03 {

    static void execute(MyFunction f) { // 매개변수의 타입이 MyFunction인 메서드.
        f.run();
    }

    static MyFunction getMyFunction() { // 반환 타입이 MyFunction인 메서드.
        return () -> System.out.println("f3.run()");
    }

    public static void main(String[] args){
        // 람다식으로 MyFunction의 run()을 구현, 매개변수와 반환식이 일치해야 한다.
        MyFunction f1 = () -> System.out.println("f1.run()");

        MyFunction f2 = new MyFunction() { // 익명 클래스로 run()을 구현, 함수형 인터페이스를 직접 구현.
            @Override
            public void run() { // public을 반드시 붙여야 한다.
                System.out.println("f2.run()");
            }
        };

        MyFunction f3 = getMyFunction(); // getMyFunction()으로 람다식을 반환받아 사용.

        f1.run();
        f2.run();
        f3.run();

        execute(f1); // execute() 참조변수에 담긴 람다식을 매개변수로 받아서 호출.
        execute(() -> System.out.println("run()")); // 람다식을 직접 매개변수로 넘겨줌.
    }
}