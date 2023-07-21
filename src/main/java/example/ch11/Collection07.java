package example.ch11;

import java.util.*;

public class Collection07 {
    public static void main(String[] args) {
        /**
         *    - Iterator, ListIterator, Enumeration(Iterator의 구버전)
         *      컬렉션에 저장된 데이터를 접근하는데 사용되는 인터페이스, 중요한 기능은 "읽어오기"이다.
         *      컬렉션(list, set, map ...)에 저장된 요소들을 읽어오는 방법을 표준화한 것. 때문에 코드 변환에 자유룝다.(성능 이슈로 List -> HashSet으로 변경해야 할 경우 등등)
         *      컬렉션에 iterator()를 호출해서 Iterator를 구현한 객체를 얻어서 사용.
         *
         *      {@code
         *          public interface Collection {
         *              ...
         *              public Iterator iterator();
         *              // Collection 인터페이스에 정의되어 있는 것이라서 Collecton 인터페이스의 자손인 List와 set이 모두 가지고 있는 메서드, 해당 메서드만 호출하면 Iterator객체를 반환 받을 수 있다.
         *              ...
         *          }
         *      }
         */

        ArrayList list = new ArrayList(); // 다른 컬렉션으로 변경할 때는 이 부분만 고치면 된다.
        // Collection list = new ArrayList(); // Collection 인터페이스의 자손이라 다형성이 성립. 참조변수 타입을 Collection으로 변경가능.
        // Collection list = new HashSet(); // 해당 코드로 list를 HashSet으로 바꾸어도 Iterator객체를 사용하여 메서드가 동일하니 타입 변경에 자유롭다.
        // Collection list = new TreeSet(); // 위와 같이 Collection인터페이스가 가지고 있는 메서드만 사용하기에 아래의 코드를 확인할 필요가 없이 유연한 코드작성이 가능하다.
        list.add("1");
        list.add("2");
        list.add("3");


        /**
         *    - Iterator의 메서드와 설명.
         */

        Iterator iter = list.iterator();

        //boolean hasNext() : 확인, 읽어 올 요소가 남아있는지 확인한다. 있으면 true, 없으면 false를 반환한다.
        System.out.println(iter.hasNext());

        //Object next() : 읽기, 다음 요소를 읽어 온다. next()를 호출하기 전에 hasNext()를 호출해서 읽어 올 요소가 있는지 확인하는 것이 안전하다.
        while (iter.hasNext() == true) {
            String num = (String) iter.next();
            if (num == "3") {
                //void remove() : next()로 읽어 온 요소를 삭제한다. next()를 호출한 다음에 remove()를 호출해야 한다.(선택적 가능)
                iter.remove();
            }
            System.out.println("num = " + num);
        }

        System.out.println("-------------------");
        // iterator은 1회용이라 다 쓰고나면 다시 얻어와야 한다.
        iter = list.iterator(); //새로운 iterator객체를 얻는다.
        while(iter.hasNext() == true) {
            String num = (String) iter.next();
            System.out.println("num = " + num);
        }

        //void forEachRemaining(Consumer<? super E> action) : 컬렉션에 남아있는 요소들에 대해 지정된 작업(action)을 수행한다.
        //                                                    람다식을 사용하는 디폴트 메서드.(JDK1.8부터 추가)



        /**
         *    - Enumeration의 메서드와 설명.
         *      현재는 구버전으로 잘 사용되지 않지만 사용하는 곳도 있으니 알아두기.
         *      Iterator와 똑같다.
         *
         *      boolean hasMoreElements() : Iterator의 hasNext()와 같다.
         *      Object nextElement() : Iterator의 next()와 같다.
         *
         *
         *    - ListIterator 메서드와 설명.
         *      Iterator의 접근성을 향상시킨 것(단방향 -> 양방향)
         *      Iterator은 next()로 다음 요소만 읽어올 수 있지만, ListIterator은 previous()로 이전 요소도 읽어 올 수 있다.
         */



    }
}
