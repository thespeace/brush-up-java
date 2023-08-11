package example.ch12;

import java.util.ArrayList;

class Product1 {}
class Tv1 extends Product1 {}
class Audio1 extends Product1 {}

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
         *          List<Tv> list = new ArrayList<Tv>(); // OK. 다형성, ArrayList(자손)가 List(조상)를 구현.
         *          List<Tv> list = new LinkedList<Tv>(); // OK. 다형성, LinkedList(자손)가 List(조상)를 구현.
         *      }
         *
         *      매개변수의 다형성도 성립.
         *      {@code
         *          ArrayList<Product> list = new ArrayList<Product>();
         *          list.add(new Product());
         *          list.add(new Tv());      // OK, Product 자손.
         *          list.add(new Audio());   // OK, Product 자손.
         *
         *          //Product 클래스와 그 자손 객체 사용 가능.
         *          boolean add(E e) { ... }    -->     boolean add(Product e) { ... }
         *
         *          Product p = list.get(0);
         *          Tv t = (Tv)list.get(1); // Product타입의 자손이어도 형변환은 필요하다.
         *      }
         */

        ArrayList<Product1> productList = new ArrayList<Product1>();
        ArrayList<Tv1>      tvList = new ArrayList<Tv1>();
//  	ArrayList<Product1> tvList = new ArrayList<Tv1>(); // 에러, 대입된 제네릭 타입이 다르다.(조상 - 자손이어도 불가)
// 		List<Tv1>           tvList = new ArrayList<Tv1>(); // OK. 다형성

        productList.add(new Tv1());     // public boolean add(Product e) { ... } : 다형성, 해당 타입과 그의 자손들도 OK.
        productList.add(new Audio1());

        tvList.add(new Tv1());
//        tvList.add(new Audio1()); // ERROR, Tv1과 그의 자손만 사용 가능.

        printAll(productList);
//        printAll(tvList); // 컴파일 에러가 발생한다, 참조변수에 대입된 <Product1>하고 생성자에 대입된 타입이 불일치하기 때문.
    }

    public static void printAll(ArrayList<Product1> list) {
        for (Product1 p : list)
            System.out.println(p);
    }

}
