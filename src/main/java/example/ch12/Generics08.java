package example.ch12;

public class Generics08 {
    public static void main(String[] args){
        /**
         *    - 지네릭 타입의 형변환
         *      지네릭 타입과 원시 타입 간의 형변환은 바람직 하지 않다.(경고 발생)
         *
         *      {@code
         *          Box<Object> objBox = null; // 지네릭 타입의 참조변수 objBox.
         *          Box box = (Box)objBox;     // OK, 지네릭 타입 -> 원시 타입. 경고 발생.
         *          objBox = (Box<Object>)box; // OK, 원시 타입 -> 지네릭 타입. 경고 발생.
         *      }
         */
        Box b1 = new Box<String>();     // 원시타입으로 제네릭 타입 객체를 가리키는 게 가능하다. 생성자 앞에 (Box) 생략되어 있다.
        b1.add(new Integer(100)); // Box<String>이지만 참조변수가 원시타입이라 정수형을 넣는게 가능. 하지만 바람직하지 않기떄문에, 원시타입과 제네릭타입은 섞어쓰지 않는게 좋다.

        Box b2 = null;
        Box<String> bStr = null;

        b2 = (Box)bStr;          // Box<String> -> Box, 가능하지만 경고.
        bStr = (Box<String>)b2;  // Box -> Box<String>, 가능하지만 경고.



        /**
         *    - 지네릭 타입의 형변환
         *      서로 다른 타입이 대입된 제네릭타입끼리는 형변환이 안된다.
         */
        Box<Object> objBox = null;
        Box<String> strBox = null;

//        strBox = (Box<String>)objBox; // ERROR, Box<Object> -> Box<String> 불가!
//        objBox = (Box<Object>)strBox; // ERROR, Box<String> -> Box<Object> 불가!

//        Box<String> b3 = new Box<Object>(); // ERROR, 해당 코드와 같은 맥락으로 보면 된다.



        /**
         *    - 와일드 카드가 사용된 지네릭 타입으로는 형변환 가능.
         */
//        Box<Object> objBox2 = (Box<Object>)new Box<String>(); // ERROR, 형변환 불가능.
        Box<? extends Object> wBox  = (Box<? extends Object>)new Box<String>(); // OK. Object와 그 자손간 형변환.
        Box<? extends Object> wBox2 = new Box<String>(); // OK, 위 문장과 동일, 생략된 코드 : (Box<? extends Object>)

        // Example.
        FruitBox<Fruit> fBox = new FruitBox<Fruit>();
        FruitBox<Apple> aBox = new FruitBox<Apple>(); // 일치하는게 정석.

        FruitBox<? extends Fruit> fBox2 = (FruitBox<? extends Fruit>) new FruitBox<Fruit>(); // 와일드카드를 사용하여 참조변수타입과 생성자 타입이 다를 경우-

        // FruitBox<Apple> -> FruitBox<? extends Fruit> 가능.
        FruitBox<? extends Apple> aBox2 = (FruitBox<? extends Apple>) new FruitBox<Apple>(); // 형변환이 필요하지만 컴파일러가 자동으로 해준다.

        // FruitBox<? extends Fruit> -> FruitBox<Apple> 가능, 하지만 경고 발생. 왜냐면 와일드카드가 대입된 타입(불명확)을 명확한 타입으로 바꾸려고 하니까 경고.
        FruitBox<Apple> appleBox = (FruitBox<Apple>) aBox2;




        /**
         *    - 지네릭 타입의 제거.
         *      컴파일러는 지네릭 타입을 제거하고, 필요한 곳에 형변환을 넣는다.
         *      즉, 제일 중요한 점은 컴파일타임(Compiletime)에 지네릭 타입이 없어진다는 사실이 가장 중요하다.
         *          예를 들자면 아래에도 설명이 있듯이 Object를 타입변수 <T>로 바꾸었지만 컴파일한 후에는 다시 <T>가 Object타입으로 바뀐후, 적절한 타입으로 바뀐다.
         *          또한 지네릭스 덕분에 형변환을 생략할 수 있고 필요에 의해 형변환이 자동으로 추가된다.
         *
         *      1. 지네릭 타입의 경계(bound)를 제거.
         *
         *      {@code 컴파일러 동작.
         *          class Box<T extends Fruit> { // Object -> <T>
         *              void add(T t) {
         *                  ...
         *              }
         *          }
         *          
         *          =(컴파일 시, 컴파일러가 지네릭 타입을 제거하고 적절한 타입을 넣는다.)=>
         *
         *          class Box {
         *              void add(Fruit t) {     // <T> -> Object -> 제네릭으로 제한된 경우에는 제한된 타입으로 바뀐다.(Fruit)
         *                  ...
         *              }
         *          }
         *      }
         *      * 하위호환성(JDK1.5이전 버전과 호환성, 즉 지네릭 등장 이전버전과의 호환성)을 위해 제거하기로 결정. *
         *
         *      2. 지네릭 타입 제거 후에 타입이 불일치하면, 형변환을 추가.
         *      {@code
         *          T get(int i) {
         *              return list.get(i);
         *          }
         *
         *          =(컴파일 시, 컴파일러가 필요한 경우라 판단되면 형변환 추가.)=>
         *
         *          Fruit get(int i) {
         *              return (Fruit)list.get(i);
         *          }
         *      }
         *
         *      3.와일드 카드가 포함된 경우, 적절한 타입으로 형변환 추가.
         *      {@code
         *          static Juice makeJuice(FruitBox<? extends Fruit> box) {
         *              String tmp = "";
         *              for(Fruit f : box.getList()) // Fruit와 그 자손.
         *                  tmp += f + " ";
         *              return new Juice(tmp);
         *          }
         *
         *          =(컴파일 시, 적절히 바뀐다.)=>
         *
         *          static Juice makeJuice(FruitBox box) {      // 컴파일시 와일드카드가 없어지기때문에, 코드가 조금 복잡해지고 형변환이 필요하다.
         *              String tmp = "";
         *              Iterator it = box.getList().iterator();
         *              while(it.hasNext()) {
         *                  tmp += (Fruit)it.next() + " "l      // it.next()의 반환값은 Object이기 때문에 형변환 추가.
         *              }
         *              return new Juice(tmp);
         *          }
         *      }
         */
    }
}
