package example.ch12;

import java.util.ArrayList;

public class Generics07 {
    public static void main(String[] args){
        /**
         *    - 지네릭 메서드
         *
         *      지네릭 타입이 선언된 메서드(타입 변수는 메서드 내에서만 유효).
         *      메서드 레벨에서 타입변수가 선언된 것.
         *      {@code
         *          static <T> void sort(List<T> list, Comparator<? super T> c)
         *      }
         *
         *      클래스의 타입 매개변수 <T>와 메서드의 타입 매개변수 <T>는 별개.
         *      {@code
         *          class FruitBox<T> { // 지네릭 클래스.
         *              ...
         *              static <T> void sort(List<T> list, Comparator<? super T> c) { // 지네릭 메서드, 메서드의 지네릭타입은 클래스와 별개! 메서드 지네릭타입은 해당 메서드 안에서만 사용할 수 있다.
         *                  ...
         *              }
         *          }
         *      }
         *
         *      ** 메서드를 호출할 때마다 타입을 대입해야 ** (대부분 생략 가능)
         *      {@code
         *          FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
         *          FruitBox<Apple> appleBox = new FruitBox<Apple>();
         *              ...
         *          System.out.println(Juicer.<Fruit>makeJuice(fruitBox));
         *          System.out.println(Juicer.<Apple>makeJuice(AppleBox));
         *
         *          //지네릭 메서드
         *          static <T extends Fruit> Juice makeJuice(FruitBox<T> box) {
         *              String tmp = "";
         *              for(Fruit f : box.getList()) tmp += f + " ";
         *              return new Juice(tmp);
         *          }
         *
         *          //와일드카드 메서드
         *          static Juice makeJuice(FruitBox<? extends Fruit> box) {
         *              String tmp = "";
         *              for(Fruit f : box.getList()) tmp += f + " ";
         *              return new Juice(tmp);
         *          }
         *
         *          제네릭 메서드 vs 와일드카드 메서드.
         *          와일드카드는 하나의 참조변수로 대입된 여러 타입의 지네릭 객체를 다루기 위한 것이고,
         *          제네릭 메서드는 호출할 때마다 다른 지네릭 타입을 대입할 수 있게 한 것으로 용도가 조금 다르다.
         *          그리고 와일드카드를 사용하지 못할 때, 제네릭 메서드를 많이 사용한다.
         *      }
         *
         *      메서드를 호출할 때 타입을 생략하지 않을 때는 클래스 이름 생략 불가.(드물다)
         *      {@code
         *          System.out.println(<Fruit>makeJuice(fruitBox));        // ERROR, 클래스 이름 생략불가.
         *          System.out.println(this.<Fruit>makeJuice(fruitBox));   // OK.
         *          System.out.println(Juicer.<Fruit>makeJuice(fruitBox)); // OK.
         *      }
         *
         */

    }
}
