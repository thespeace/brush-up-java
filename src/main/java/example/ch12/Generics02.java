package example.ch12;

import java.util.AbstractList;
import java.util.ArrayList;

public class Generics02 {
    public static void main(String[] args){
        /**
         *    - 타입 변수.
         *      지네릭스 클래스를 작성할 때, 일반 클래스의 Object타입 대신 지네릭 클래스 타입 변수(E)를 선언해서 사용.
         *
         *      {@code - 일반 클래스(지네릭스 클래스의 타입변수 사용 전).
         *          public class ArrayList extends AbstractList { //일부 생략
         *              private transient Object[] elementData;
         *              public boolean add(Object o) { 내용생략 }
         *              public Object get(int index) { 내용생략 }
         *                  ...
         *          }
         *      }
         *
         *      {@code - 지네릭스 클래스(지네릭스 클래스의 타입변수 사용 후).
         *          public class ArrayList<E> extends AbstractList<E> { // 타입변수 E 선언.
         *              private transient E[] elementData;
         *              public boolean add(E o) { 내용생략 }
         *              public E get(int index) { 내용생략 }
         *                  ...                             // Object 타입을 타입변수로 변경.
         *          }                                       // 타입변수는 Element를 뜻하는 E를 쓴것인데, 무엇을 사용하든 괜찮다. Type의 T도 많이 사용한다.
         *      }
         *
         *    - 타입 변수에 대입하기.
         *      객체를 생성시, 타입 변수(E) 대신 실제 타입(Tv)을 지정(대입)
         *      {@code
         *          // 타입 변수 E 대신에 실제 타입 Tv를 참조변수와 생성자에 대입, 일치하여야 한다.
         *          ArrayList<Tv> tvList = new ArrayList<Tv>();
         *      }
         *
         *      타입 변수 대신 실제 타입이 지정되면, 형변환 생략가능.
         */

        ArrayList<Tv> list = new ArrayList<Tv>(); // Tv타입의 객체만 저장가능.
        list.add(new Tv());
//        list.add(new Audio()); // 저장 불가.

//        Tv t = (Tv)list.get(0); // 예전에는 list의 반환타입이 Object여서 꼭 형변환을 해주어야만 했다.
        Tv t = list.get(0); // 타입 일치(형변환 불필요).
    }
}
class Tv {}
class Audio {}
