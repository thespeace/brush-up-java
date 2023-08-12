package example.ch12;

import java.util.ArrayList;

public class Generics06 {
    public static void main(String[] args){
        /**
         *    - 와일드 카드 <?>
         *      하나의 참조 변수로 대입된 타입이 다른 객체를 참조 가능.
         *
         *      1. <? extends T> : 와일드 카드의 상한 제한, T와 그 자손들만 가능.
         *      2. <? super T>   : 와일드 카드의 하한 제한, T와 그 조상들만 가능.
         *      3. <?>           : 제한 없음. 모든 타입이 가능. <? extends Object>와 동일.
         *
         *      {@code example.
         *          ArrayList<? extends Product> list = new ArrayList<Tv>(); // OK.
         *          ArrayList<? extends Product> list = new ArrayList<Audio>(); // OK.
         *          ArrayList<Product> list = new ArrayList<Tv>(); // ERROR, 대입된 타입 불일치.
         *      }
         *
         *      메서드의 매개변수에 와일드 카드를 사용.(서로 대입된 제네릭 타입이 다른 객체들을 하나의 매개변수로 받을 수 있게 된다. 다형성!)
         *      {@code example.
         *          static Juice makeJuice(FruitBox<? extends Fruit> box) {
         *              String tmp = "";
         *              for(Fruit f : box.getList()) tmp += f + " ";
         *              return new Juice(tmp);
         *          }
         *
         *          System.out.println(Juicer.makeJuice(new FruitBox<Fruit>()));
         *          System.out.println(Juicer.makeJuice(new FruitBox<Apple>())); // Fruit의 자손인 Apple타입도 사용가능.
         *      }
         */


        // 와일드카드를 사용하여 Fruit2와 그 자손들(Apple, Grape).
        FruitBox2<Fruit2> fruitBox = new FruitBox2<Fruit2>();
        FruitBox2<Apple2> appleBox = new FruitBox2<Apple2>();

        fruitBox.add(new Apple2());
        fruitBox.add(new Grape2());
        appleBox.add(new Apple2());
        appleBox.add(new Apple2());

        System.out.println(Juicer.makeJuice(fruitBox));
        System.out.println(Juicer.makeJuice(appleBox));

        /* 하나의 참조변수로 대입된 지네릭타입이 다 다른 객체를 다 다룰수 있다.
        FruitBox2<? extends Fruit2> fruitBox2 = new FruitBox2<Apple2>();
        fruitBox2_1 = new FruitBox2<Fruit2>();
        fruitBox2_2 = new FruitBox2<Apple2>();
        fruitBox2_3 = new FruitBox2<Grape2>(); */

    }
}

class Fruit2                { public String toString() { return "Fruit"; } }
class Apple2 extends Fruit2 { public String toString() { return "Apple"; } }
class Grape2 extends Fruit2 { public String toString() { return "Grape"; } }

class FruitBox2<T extends Fruit2> extends Box2<T> { }

class Box2<T>{
    ArrayList<T> list = new ArrayList<T>();
    void add(T item) { list.add(item); }
    T get(int i) { return list.get(i); }
    ArrayList<T> getList() { return list; }
    int size() { return list.size(); }
    public String toString() { return list.toString(); }
}

class Juice {
    String name;
    Juice(String name)       { this.name = name + "Juice"; }
    public String toString() { return name; }
}

class Juicer {
    static Juice makeJuice(FruitBox2<? extends Fruit2> box) { // 와일드 카드 사용으로 Fruit2와 그 자손타입은 매개변수로 대입가능.
        String tmp = "";
        for(Fruit2 f : box.getList()) // 향상된 for문 사용.
            tmp += f + " ";
        return new Juice(tmp);
    }
}
