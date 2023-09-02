package example.ch14;

/**
 *    - 함수형 인터페이스
 *
 *      단 하나의 추상 메서드만 선언된 인터페이스
 *      {@code
 *          @FunctionalInterface //애너테이션을 안 붙여도 에러는 나지않지만, 컴파일러가 확인을 해주기때문에 붙여주는 것이 좋다..
 *          interface MyFunction { //함수형 인터페이스 선언.
 *              public abstract int max(int a, int b); // 단 하나만.
 *          }
 *
 *          ==(구현)==>
 *
 *          //Object 타입 대신 MyFunction타입을 사용.
 *          MyFunction f = new MyFunction() {   // 익명클래스, 클래스 선언 + 객체 생성을 동시에 하는 것.
 *                             public int max(int a, int b) {
 *                                 return a > b ? a : b ;
 *                             }
 *                         }
 *
 *          int value = f.max(3,5); // OK, MyFunction에 max()가 있다.
 *      }
 *
 *      함수형 인터페이스 타입의 참조변수로 람다식을 참조할 수 있다.
 *          (단, 함수형 인터페이스의 메서드와 람다식의 매개변수 개수와 반환타입이 일치해야 한다)
 *      {@code
 *          MyFunction f = (a , b) -> a > b ? a : b; // 함수형 인터페이스 타입의 참조변수를 가지고 람다식을 다룬다. 즉, 함수형 인터페이스는 람다식을 다루기 위해 사용.
 *          int value = f.max(3,5); // 실제로는 람다식(익명 함수)이 호출됨.
 *      }
 */

@FunctionalInterface // 함수형 인터페이스는 단 하나의 추상 메서드만 가져야 한다. 애너테이션을 사용하면 이를 어길 시 컴파일러가 체크해준다.
interface Myfunction2 {
//    public abstract int max(int a, int b);
    int max(int a, int b); // interface의 모든 메서드는 public이면서 동시에 abstract이기 때문에 생략 가능하다.
}

public class Lambda02 {
    public static void main(String[] args){
        /*Myfunction2 f = new Myfunction2() {
            @Override
            public int max(int a, int b) { //오버라이딩 : 접근제어자는 좁게 못바꾼다는 법칙으로 인해 public을 붙이지 않으면 defalut가 되기 때문에 작성해야 한다.
                return a > b ? a : b;
            }
        };*/

        //위 익명클래스를 람다식으로 익명객체 작성.
        //람다식(익명객체)을 다루기 위한 참조변수의 타입은 함수형 인터페이스로 한다.
        //      단, 함수형 인터페이스와 람다식의 매개변수와 반환타입이 같아야 한다. 그리고 함수형인터페이스를 람다식으로 호출한다고 생각하면 비교적 간단하게 이해할 수 있다.
        Myfunction2 f = (a , b) -> a > b ? a : b;

        int value = f.max(3,5);
        System.out.println(value);
    }
}