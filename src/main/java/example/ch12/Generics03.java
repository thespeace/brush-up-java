package example.ch12;

import java.util.ArrayList;

public class Generics03 {
    public static void main(String[] args){
        /**
         *    - 지네릭스 용어.
         *
         *      클래스이름<타입변수'T'선언> : 지네릭 클레스. ex) Box<T> : 'T의 Box' 또는 'T Box'라고 읽는다.
         *      T      : 타입 변수 또는 타입 매개변수.(T는 타입 문자).
         *      Box    : 원시 타입(raw type), 즉 일반 클래스.
         *
         *      {@code
         *          // 지네릭클래스 선언.
         *          class Box<T> { }        //지네릭 클래스 선언 = 원시타입 + 타입변수.
         *
         *          // 지네릭클래스 객체 생성.(대입된 타입, 매개변수화된 타입, parameterized type)
         *          Box<String> b = new Box<String>();      //타입변수 <T>에 String 대입, 이를 대입된 타입이라 한다.
         *                                                  //객체를 만들때마다 타입은 변경 가능하다. 메서드에 매개변수를 달리하는 것과 같다. ex) new Box<Tv>();
         *      }
         *
         *    - 지네릭 타입과 다형성.
         *
         *      참조 변수와 생성자의 대입된 타입은 일치해야 한다.
         *      {@code
         *          ArrayList<Tv>      list = new ArrayList<Tv>(); // OK, 대입된 타입 일치.
         *          ArrayList<Product> list = new ArrayList<Tv>(); // ERROR, 대입된 타입 불일치.
         *
         *          // 조상 - 자식 관계여도 불가.
         *          class Product { }
         *          class Tv extends Product { }
         *          class Audio extends Product { }
         *      }
         *
         *      지네릭 클래스간의 다형성은 성립.(여전히 대입된 타입은 일치해야)
         *      {@code
         *
         *      }
         *
         */

    }
}
