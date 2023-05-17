package example.ch07;

/**
*    - 단일 상속(Single Inheritance)
*      하나의 부모로부터만 상속받을 수 있다.
*      Java는 단일 상속만을 허용한다. <-> C++은 다중상속 허용
*          ex) class TvDVD extends Tv, DVD { // Error, 조상은 하나만 허용된다.
*                  //...
*              }
*
*      Java는 다중상속의 문제점(상속의 충돌 등)으로 인해 단일 상속만 사용하기로 결정.
*      하지만, 인터페이스(Interface)를 사용하면 문제점들을 보완한 다중 상속과 같은 효과를 낼 수있는 방법들을 제공한다.
*      그러나, 인터페이스를 쓰지않고도 다중 상속처럼 편리하게 작성하는 방법은 " 비중이 높은 클래스 하나만 상속관계로, 나머지는 포함관계로 하는 것이다.
*      아래의 예시를 통해 상속&포함관계를 함께사용하여 다중 상속을 사용해 보자.
*/

//상속&포함관계를 둘 다 사용하는 예시.
class MyTv{
    boolean power;
    int channel;

    void power()       { power = !power; }
    void channelUp()   { ++channel; }
    void channelDown() { --channel; }
}
class MyDVD{
    boolean power;

    void power()       { power = !power; }
    void play()   {  }
    void stop()   {  }
    void rew()   {  }
    void ff()   {  }
}
class TvDVD extends MyTv{ // MyTv를 상속관계로 관계를 형성.
    MyDVD dvd = new MyDVD(); // MyDVD는 포함관계로 관계를 형성.
    void play(){ dvd.play(); } // 껍데기만 만들어 놓고, MyDVD객체를 사용.
    void stop(){ dvd.stop(); }
    void rew(){ dvd.rew(); }
    void ff(){ dvd.ff(); }
}


/**
 *    - Object클래스 - 모든 클래스의 조상
 *      부모가 없는 클래스는 자동적으로 Object클래스를 상속받게 된다.
 *          ex) class Tv extends Object { <- 부모가 없는 클래스는 컴파일러가 자동으로 " extends Object "를 상속받게 해준다.
 *                  // ...
 *              }
 *      때문에 모든 클래스는 Object클래스에 정의된 11개의 메서드를 상속받는다.
 *      모든 메서드를 알 필요는 없고, 대표적으로는 toString(), equals(Object obj), hashCode(), ... 가 있다.
 *
 *    - 상속계층도(클래스간의 상속관계를 그림으로 작성한 것)
 *      Object(모든 클래스의 조상) -> class -> class extends class -> ...
 */

public class Inheritance03 {
    public static void main(String[] args) {
        TvDVD t = new TvDVD();
        System.out.println(t.toString()); // 클래스의이름@객체의주소값 반환, 최고 조상인 Object로부터 상속받았기 때문에 작성하지 않았어도 사용가능.
        TvDVD t2 = new TvDVD();
        System.out.println(t2); // println(참조변수)가 들어오면 내부적으로 toString()을 호출한다. 객체마다 주소값이 다르다는것을 확인할 수 있다.
    }
}