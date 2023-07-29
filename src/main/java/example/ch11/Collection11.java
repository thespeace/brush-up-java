package example.ch11;

import java.util.*;

public class Collection11 {
    public static void main(String[] args) {
        /**
         *    - HashSet 예제 3.
         *
         *      HashSet은 순서를 유지하지 않고 중복을 허용하지 않기 때문에, 객체를 저장하기 전에 기존에 같은 객체가 있는지 확인 해야한다.
         *          같은 객체가 없으면 저장하고, 있으면 저장하지 않는다.
         *
         *      boolean add(Object o)는 저장할 객체의 equals()와 hashCode()를 호출하여 사용, 오버라이딩 되어있지 않으면, 중복을 제대로 확인할 수 없기 때문에, HashSet이 제대로 동작하지 않는다.
         *          따라서 equals()와 hashCode()가 오버라이딩 되어 있어야 한다.(보통 equals()만 오버라이딩 하면 되는데, hashCode()도 오버라이딩하는게 정석이다.)
         *              왜냐하면 hash가 붙은 클래스들은 내부적으로 hashCode()를 이용하는데, 이런 클래스들을 우리가 자주 쓰기때문에 오버라이딩해주면 좋다.
         *
         *      오버라이딩 예시.
         *      {@code
         *          class Person {
         *              String name;
         *              int age;
         *
         *              Person(String name, int age) {
         *                  this.name = name;
         *                  this.age = age;
         *              }
         *              public String toString() {
         *                  return name + ":" + age;
         *              }
         *          }
         *
         *          public boolean equals(Object obj) {
         *              if(!(obj instanceof Person)) return false;      // 형변환 전, 타입 체크.
         *
         *              Person tmp = (Person)obj;                       // 형변환.
         *
         *              return name.equals(tmp.name) && age == tmp.age; // this(객체 자신)와 obj(매개변수로 지정된 객체)를 비교.
         *          }
         *          public int hashCode() {
         *              return (name+age).hashCode();       // String 클래스의 HashCode메서드를 사용해서 호출.(예전 방식)
         *              return Objects.hash(name, age);     // 새로운 방식. Objects의 hash메서드를 사용.
         *          }
         *      }
         */








        System.out.println("==============예제 3=============");

    }
}
