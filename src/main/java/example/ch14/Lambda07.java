package example.ch14;

import java.util.function.*;

/**
 *    - 메서드 참조(method reference) == 클래스이름::메서드이름.
 *      하나의 메서드만 호출하는 람다식은 '메서드 참조'로 더 간단히 할 수 있다.
 *
 *              종류                    |               람다              |       메서드 참조
 *          static메서드 참조            | (x) -> ClassName.method(x)     | ClassName::method
 *          인스턴스메서드 참조           | (obj, x) -> obj.method(x)       | ClassName::method
 *          특정 객체 인스턴스 메서드 참조 | (x) -> obj.method(x)            | obj::method           -- 거의 쓰지 않는다.
 *
 *      static 메서드 참조.
 *          {@code
 *              Integer method(String s) {      // 그저 Integer.parseInt(String s)만 호출.
 *                  return Integer.parseInt(s);
 *              }
 *
 *              //람다식
 *              Function<String, Integer> f = (String s) -> Integer.parseInt(s);
 *
 *              //함수형 인터페이스에 정보가 다 있기때문에, 더 간단히 "메서드 참조"
 *              Function<String, Integer> f = Integer::parseInt;
 *          }
 */

public class Lambda07 {
    public static void main(String[] args){
//        Function<String,Integer> f = (String s) -> Integer.parseInt(s);
        Function<String,Integer> f = Integer::parseInt; // 메서드 참조, 클래스이름::메서드이름;
        System.out.println(f.apply("100")+200);

        /**
         *    - 생성자의 메서드 참조
         *
         *          생성자와 메서드 참조
         *          {@code
         *              //매개변수가 없는 경우.
         *              Supplier<MyClass> s = () -> new MyClass();  //매개변수 X, 반환값만 있다. 이 예시에서는 MyClass객체.
         *              Supplier<MyClass> s = MyClass::new;
         *
         *              //매개변수가 하나 있는 경우.
         *              Function<Integer, MyClass> s = (i) -> new MyClass(i);
         *              Function<Integer, MyClass> s = MyClass::new;
         *          }
         *
         *          배열과 메서드 참조
         *          {@code
         *              Function<Integer, int[]> f = x -> new int[x]; // 람다식.
         *              Function<Integer, int[]> f2 = int[]::new;     // 메서드 참조.
         *          }
         */

        //매개변수가 없는 생성자와 메서드 참조 예시.
//        Supplier<MyClass> s = () -> new MyClass(); //람다식.
        Supplier<MyClass> s = MyClass::new;          //메서드 참조.

        MyClass mc = s.get();
        System.out.println(mc); // 객체 생성.
        System.out.println(s.get()); // 새로운 객체 생성.



        //매개변수가 있는 생성자와 메서드 참조 예시.
//        Function<Integer, MyClass2> s2 = (i) -> new MyClass2(i); //람다식.
        Function<Integer, MyClass2> f2 = MyClass2::new;            //메서드 참조.

        MyClass2 mc2 = f2.apply(100);
        System.out.println(mc2.iv);
        System.out.println(f2.apply(200).iv);



        //배열과 메서드 참조 예시.
//        Function<Integer, int[]> f3 = (i) -> new int[i]; // 람다식.
        Function<Integer, int[]> f3 = int[]::new;          // 메서드 참조.

        System.out.println("생성된 배열의 길이 : " + f3.apply(100).length);

        /*int[] arr = f3.apply(100);
        System.out.println("배열의 길이 : " + arr.length);*/
    }
}

class MyClass{}
class MyClass2{
    int iv;
    MyClass2(int iv){ this.iv = iv; }
}
