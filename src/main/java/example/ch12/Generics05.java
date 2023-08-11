package example.ch12;

import java.util.ArrayList;

public class Generics05 {
    public static void main(String[] args){
        /**
         *    - 제한된 지네릭 클래스.
         *
         *      extends로 대입할 수 있는 타입을 제한.
         *      {@code
         *          class FruitBox<T extends Fruit> { // Fruit의 자손만 타입으로 지정가능.
         *              ArrayList<T> list = new ArrayList<T>();
         *              ...
         *          }
         *
         *          //Apple은 Fruit의 자손을 가정.
         *          FruitBox<Apple> appleBox = new FruitBox<Apple>(); // OK.
         *          FruitBox<Toy>   toyBox = new FruitBox<Toy>();     // ERROR, Toy는 Fruit의 자손이 아니다.
         *      }
         *
         *      인터페이스인 경우에도 extends를 사용.(implements X)
         *      {@code
         *          interface Eatable {}
         *          class FruitBox<T extends Eatable> { ... }
         *      }
         */

        //예제(제약 조건)
        FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
        FruitBox<Apple> appleBox = new FruitBox<Apple>();
        FruitBox<Grape> grapeBox = new FruitBox<Grape>();
//        FruitBox<Grape> grapeBox = new FruitBox<Apple>();   // ERROR, 참조변수 대입타입과 생성자 대입타입의 불일치.
//        FruitBox<Toy> toyBox = new FruitBox<Toy>(); // ERROR, 제약 조건에 충족하지 못함.
        Box<Toy> toyBox = new Box<Toy>(); // OK, 제약 조건이 없다.

        fruitBox.add(new Fruit());
        fruitBox.add(new Apple());
        fruitBox.add(new Grape());
        appleBox.add(new Apple());
//        appleBox.add(new Grape()); // ERROR, Grape는 Apple의 자손이 아니기 때문.
        grapeBox.add(new Grape());

        System.out.println("fruitBox : " + fruitBox);
        System.out.println("appleBox : " + appleBox);
        System.out.println("grapeBox : " + grapeBox);
    }
}
interface Eatable { }
class Fruit implements Eatable {
    public String toString() { return "Fruit"; }
}
class Apple extends Fruit { public String toString() { return "Apple"; }}
class Grape extends Fruit { public String toString() { return "Grape"; }}
class Toy                 { public String toString() { return "Toy";   }}

class FruitBox<T extends Fruit & Eatable> extends Box<T> {} // FruitBox에는 Fruit의 자손이면서 Eatable인터페이스를 구현한 클래스만 생성할 수 있다.

class Box<T> {
    ArrayList<T> list = new ArrayList<T>();  // item을 저장할 list.
    void add(T item) { list.add(item);     } // 박스에 item을 추가.
    T get(int i)     { return list.get(i); } // 박스에서 item을 꺼낼때.
    int size()       { return list.size(); }
    public String toString() { return list.toString();}
}



/**
 *    - 지네릭스의 제약.
 *
 *      타입 변수에 대입은 인스턴스 별로 다르게 가능.
 *      {@code
 *          Box<Apple> appleBox = new Box<Apple>(); // OK, Apple객체만 저장가능.
 *          Box<Grape> grapeBox = new Box<Grape>(); // OK, Grape객체만 저장가능.
 *      }
 *
 *      1. static멤버에 타입 변수 사용 불가 : static 멤버는 모든 인스턴스의 공통이기 때문에 사용 불가.
 *      {@code
 *          class Box<T> {
 *              static T item; // ERROR.
 *              static int compare(T t1, T t2) { ... } // ERROR.
 *                  ..
 *          }
 *      }
 *
 *      2.배열 생성할 때 타입 변수 사용불가 <-> 타입 변수로 배열 선언은 가능.
 *      {@code
 *          class Box<T> {
 *              T[] itemArr; // OK, T타입의 배열을 위한 참조변수.
 *
 *              T[] toArray() {
 *                  T[] tmpArr = new T[itemArr.length]; // ERROR, 제네릭 배열 생성불가, new 뒤에는 확정된 타입이 들어와야한다.
 *                                                      // 제네릭은 무슨 타입이 들어올지 모르기 때문에, 객체, 배열 생성 불가.(new 연산자 다음에는 제네릭 타입 변수 사용 불가!)
 *              }
 *          }
 *      }
 */
