package example.ch09;
/**
 *    - Object 클래스
 *      모든 클래스의 최고 조상으로 오직 11개의 메서드만을 가지고 있다.
 *      notify(), wait() 등은 쓰레드와 관련된 메서드입니다.
 *
 *      Object클래스의 메서드 : 설명
 *      protected Object clone() : 객체 자신의 복사본을 반환한다. 해당 메서드는 오버라이딩해서 public으로 변경해줘야 사용가능.
 *      public boolean equals(Object obj) : 객체 자신과 객체 obj가 같은 객체인지 알려준다.(같으면 true)
 *      protected void finalize() : 객체가 소멸될 때 가비지 컬렉터에 의해 자동적으로 호출된다. 이때 수행되어야하는 코드가 있을 때 오버라이딩 한다.(거의 사용 안함) 해당 메서드는 오버라이딩해서 public으로 변경해줘야 사용가능. <-> 생성자.
 *      public Class getClass() : 객체 자신의 클래스 정보를 담고 있는 Class인스턴스를 반환한다, Class : 클래스 정보를 담기 위한 클래스.
 *      public int hashCode() : 객체 자신의 해시코드를 반환한다.
 *      public String toString() : 객체 자신의 정보를 문자열로 반환한다.
 *      public void notify() : 객체 자신을 사용하려고 기다리는 쓰레드를 하나만 깨운다.
 *      public void notifyAll() : 객체 자신을 사용하려고 기다리는 모든 쓰레드를 깨운다.
 *      public void wait() : 다른 쓰레드가 notify()나 notifyAll()을 호출할 때까지 현재 쓰레드를 무한히 또는 지정된 시간(timeout, nanos)동안 기다리게 한다.(timeout은 천 분의 1초, nanos는 10의 9제곱 분의 1초)
 *      == public void wait(long timeout) , public void wait(long timeout, int nanos)
 *
 *    - equals(Object obj)
 *      객체 자신(this)과 주어진 객체(obj)를 비교한다. 같으면 true 다르면 false.
 *      Object 클래스의 equals()는 객체의 주소를 비교(참조변수 값 비교)
 *      ex) public boolean equals(object obj) {
 *              return (this == obj); // 주소 비교, 주소가 같아야 true.
 *          }
 */
class Value{
    int value;
    Value(int value){
        this.value = value;
    }
    //Object의 equals()를 오버라이딩해서 주소가 아닌 value를 비교하게 오버라이딩.
    public boolean equals(Object obj){
        // return this == obj; // 주소 비교, 서로 다른 객체는 항상 거짓.
        // 참조변수의 형변환 전에는 반드시 instanceof로 확인해야함.
        if(!(obj instanceof Value)) return false;

        Value v = (Value)obj; // obj를 value로 형변환

        return this.value==v.value;
    }
}
public class Class01 {
    public static void main(String[] args){
        Value v1 = new Value(10);
        Value v2 = new Value(10);

        if(v1.equals(v2)) // 서로 다른 두 객체는 주소값이 다르기때문에 false를 반환한다. 두 객체의 값을 비교하기 위해서는 Object조상의 equals메서드를 오버라이딩 해줘 사용 할 수 있다.
            System.out.println("v1과 v2는 같습니다.");
        else
            System.out.println("v1과 v2는 다릅니다.");

        Person p1 = new Person(8011081111222L);
        Person p2 = new Person(8011081111222L);

        if(p1.equals(p2))
            System.out.println("p1과 p2는 같은 사람입니다.");
        else
            System.out.println("p1과 p2는 다른 사람입니다.");
    }
}
/**
 *    - equals(Object obj)의 오버라이딩
 *      인스턴스 변수의 값을 비교하도록 equals()를 오버라이딩해야 한다.(객체마다 다르게 작용) <-> 클래스 변수는 객체마다 공통으로 작용하기 때문.
 */
 class Person {
    long id; //주민번호

    public boolean equals(Object obj){
        if(obj instanceof Person)
            return id ==((Person)obj).id; //obj가 Object타입이므로 id값을 참조하기 위해서는 Person타입으로 형변환이 필요하다.
        else
            return false; // 타입이 Person이 아니면 값을 비교할 필요도 없다.
    }
    Person(long id){
        this.id = id;
    }
}
