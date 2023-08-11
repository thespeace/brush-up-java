package example.ch12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Generics04 {
    public static void main(String[] args){

        /**
         *    - 지네릭 클래스의 사용 예.
         */

        // Iterator<E> : 클래스를 작성할 때, Object타입 대신 T와 같은 타입 변수를 사용.
        System.out.println("==============예제 1(Iterator<E>)=============");

        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("홍길동", 1, 1));
        list.add(new Student("각시탈", 1, 1));
        list.add(new Student("안중근", 1, 1));

        Iterator<Student> it = list.iterator();
//        Iterator it = list.iterator(); // 지네릭스를 사용하지 않으면 -
        while(it.hasNext()){
//            Student s = (Student) it.next(); // 형변환 필요.

            /*Student s = it.next();
            System.out.println(s.name);*/
            System.out.println(it.next().name); // 형변환 생략으로 인해 가독성 증가.
        }



        // HashMap<K,V> : 여러 개의 타입 변수가 필요한 경우, 콤마(,)를 구분자로 선언.(갯수 제한 없음)
        System.out.println("\n==============예제 2(HashMap<K,V>)=============");

        HashMap<String, Teacher> map = new HashMap<>(); // JDK1.7부터 생성자에 타입 지정 생략 가능, 이를 다이아몬드 연산자로고도 한다.
        map.put("아이언맨", new Teacher("아이언맨",1, 1, 100, 100, 100));
        map.put("스파이더맨", new Teacher("스파이더맨",2, 2, 0, 0, 0));

        Teacher t = map.get("아이언맨");
        Teacher t1 = map.get("스파이더맨");

        System.out.println(t.name);
        System.out.println(t1.name);

    }
}

class Student {
    String name = "";
    int ban, no;  // 반, 번호

    Student(String name, int ban, int no){
        this.name = name;
        this.ban = ban;
        this.no = no;
    }
}

class Teacher {
    String name = "";
    int ban, no, kor, eng, math;
    Teacher(String name, int ban, int no, int kor, int eng, int math){
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }
}
