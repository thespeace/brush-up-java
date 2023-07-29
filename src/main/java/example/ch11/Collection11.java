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

        HashSet set = new HashSet();

        set.add("abc");
        set.add("abc"); // 중복이라 저장안됨.
        set.add(new Person("David",10));
        set.add(new Person("David",10));

        System.out.println(set);


        System.out.println("==============예제 4=============");
        HashSet setA   = new HashSet();
        HashSet setB   = new HashSet();
        HashSet setKyo = new HashSet();
        HashSet setHab = new HashSet();
        HashSet setCha = new HashSet();

        setA.add("1");	 setA.add("2");  setA.add("3");
        setA.add("4");  setA.add("5");
        System.out.println("A = "+setA);

        setB.add("4");	 setB.add("5");  setB.add("6");
        setB.add("7");  setB.add("8");
        System.out.println("B = "+setB);

        Iterator it = setB.iterator();

        //교집합 구하기.
        while(it.hasNext()) {
            Object tmp = it.next();
            if(setA.contains(tmp))
                setKyo.add(tmp);
        }
//        setA.retainAll(setB); //교집합, 공통된 요소만 남기고 setA에  삭제.
//        setKyo.addAll(setA);

        //합집합 구하기.
        it = setA.iterator();
        while(it.hasNext())
            setHab.add(it.next());

        it = setB.iterator();
        while(it.hasNext())
            setHab.add(it.next());
//        setA.addAll(setB); // 합집합, setB의 모든 요소를 setA에 추가(중복 제외)
//        System.out.println(setA);


        //차집합 구하기.
        it = setA.iterator();
        while(it.hasNext()) {
            Object tmp = it.next();
            if(!setB.contains(tmp))
                setCha.add(tmp);
        }
//        setA.removeAll(setB); // 차집합, setB와 공통 요소를 제거하고 setA에 저장.
//        System.out.println(setA);

        System.out.println("A ∩ B = " + setKyo);  // 한글 ㄷ을 누르고 한자키
        System.out.println("A U B = " + setHab);  // 한글 ㄷ을 누르고 한자키
        System.out.println("A - B = " + setCha);

    }
}

//equals()와 hashCode()를 오버라이딩해야 hashSet이 올바르게 동작.(중복 제거 ...)
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return name +":"+ age;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person)) return false;
        Person p = (Person)o;
        //나자신(this)의 이름과 나이를 p와 비교.
        return this.name.equals(p.name) && this.age == p.age;
    }
    @Override
    public int hashCode() {
        //int hash(Object... values); //가변인자 : 매개변수의 제한이 없다.
        return Objects.hash(name, age);
    }
}