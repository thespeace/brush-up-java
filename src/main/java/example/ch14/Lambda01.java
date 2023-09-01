package example.ch14;

/**
 *      자바는 OOP언어로 객체지향 언어인 동시에 JDK1.8부터 함수형 언어(FP)의 기능을 추가한 언어이다.
 *      유명한 함수형 언어로는 Haskell, Evlang, Scala 등등이 있는데, 빅데이터가 뜨면서 엄청난 양의 데이터를 처리하기 위해서 함수형 언어를 많이 사용하게 되었다.
 *
 *
 *    - 람다식(Lambda Expression)
 *
 *      함수(메서드)를 간단한 '식(expression)'으로 표현하는 방법
 *      {@code
 *          int max(int a, int b) {
 *              return a > b ? a : b;   ->    (a, b) -> a > b ? a : b
 *          }
 *      }
 *
 *      익명 함수(이름이 없는 함수, anonymous function)
 *      {@code
 *          int max(int a, int b) {            (int a, int b) -> {          // 반환타입과 이름을 지우면 람다식이 된다.
 *              return a > b ? a : b;   ->         return a > b ? a : b;
 *          }                                   }
 *      }
 *
 *      함수와 메서드의 차이
 *          - 근본적으로 동일하지만, 함수는 일반적 용어, 메서드는 객체지향개념 용어.
 *          - 함수는 클래스에 독립적, 메서드는 클래스에 종속적.
 *
 *
 *
 *    - 람다식 작성하기.
 *      1. 메서드의 이름과 반환타입을 제거하고 '->'를 블록{} 앞에 추가한다.
 *          {@code
 *              int max(int a, int b) {            (int a, int b) -> {
 *                  return a > b ? a : b;   ->         return a > b ? a : b;
 *              }                                   }
 *          }
 *      2. 반환값이 있는 경우, 식이나 값만 적고 return문 생략 가능(끝에 ';' 안 붙임)
 *          {@code
 *              (int a, int b) -> {
 *                  return a > b ? a : b;   ->    (int a, int b) -> a > b ? a : b
 *              }
 *          }
 *      3. 매개변수의 타입이 추론 가능하면 생략가능(대부분의 경우 생략가능)
 *          {@code
 *              (int a, int b) -> a > b ? a : b     ->      (a, b) -> a > b ? a : b
 *          }
 *
 *
 *    - 작성 시 주의사항.
 *      1. 매개변수가 하나인 경우, 괄호() 생략가능(타입이 없을 때만)
 *          {@code
 *              (a) -> a * a        ->       a -> a * a  //OK.
 *          (int a) -> a * a        ->   int a -> a * a  //ERROR.
 *          }
 *      2. 블록 안의 문장이 하나뿐 일 때, 괄호 {} 생략 가능(끝에 ';' 안 붙임)
 *          {@code
 *              (int i) -> {
 *                  System.out.println(i);      ->      (int i) -> System.out.println(i)
 *              }
 *          }
 *
 *          + 단, 하나뿐인 문장이 return문이면 괄호 {} 생략불가
 *              {@code
 *                  (int a, int b) -> { return a > b ? a : b; }     //OK.
 *                  (int a, int b) ->   return a > b ? a : b        //ERROR.
 *              }
 */

public class Lambda01 {
    public static void main(String[] args){

        //람다식은 익명 함수? 익명 객체! 자바에서는 람다식은 익명 함수가 아니라 익명 객체이다.
        new Object(){   // 익명 객체(익명 클래스의 객체), 객체의 선언과 생성을 동시에 하는 것.
            int max(int a, int b){
                return a > b ? a : b;           // (a, b) -> a > b ? a : b
            }
        };


        //람다식(익명 객체)을 다루기 위한 참조변수가 필요. 참조변수의 타입은?
        Object obj = new Object() {
            int max(int a, int b) {
                return a > b ? a : b;           // 타입 obj = (a, b) -> a > b ? a : b ;  // 어떤 타입?
            }
        };

//        int value = obj.max(3,5); // Error, Object클래스에 max()가 없음.(실제로 객체가 메서드를 가지고 있어도 호출 불가)
        //Object타입으로는 할 수 있는게 없기 때문에, 사용하기 위해서 무언가가 필요한데 이때 필요한게 "함수형 인터페이스"가 필요.



        /**
         *      -간단 정리
         *       익명 객체가 있을때, 익명 객체에서 메소드 부분을 표현한 것이 "람다식"이다.
         *       사실은 메서드만 있으면 되는데, 자바에서의 규칙이 메서드만 존재할 수 없기 때문에, 자바언어의 특성한 모든 언어는 객체안에 있어야 하기 때문에 익명 객체안에 넣어서 표현을 해야한다.
         *       그래서 람다식은 단순히 메서드가 아니라 익명 "객체"이다.
         *       람다식을 포함한 익명 객체를 다루기 위해 "함수형 인터페이스"에 대해 확인해보자. Lambda02.java=>
         */

    }
}
