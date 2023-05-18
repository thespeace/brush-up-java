package example.ch07;

/**
 *    - 오버라이딩(overriding)
 *      overriding : "덮어쓰다"
 *      상속받은 조상의 메서드를 자신에 맞게 변경하는 것, 정확히는 메서드 오버라이딩이라고 한다.
 */
//오버라이딩의 간단한 예시.
class Point2{
    int x;
    int y;
    String getLocation(){ return "x :" + x + ", y :" + y; }
}

class Point3D2 extends Point2 {
    int z;
    String getLocation(){ return "x :" + x + ", y :" + y + ", z :" + z; } //조상의 같은 이름의 메서드를 오버라이딩. z를 포함하여 내용만 변경. 선언부는 변경불가! 구현부( {} )만 변경가능.

    public String toString(){//Object클래스의 toString()을 오버라이딩
        return "x :" + x + ", y :" + y + ", z :" + z;
    }
    Point3D2(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
// 왜 오버라이딩? 의미상 같은 작업을 해야하기 때문에 새로운 메서드를 만들기보다는 조상의 메서드를 자신에 맞게 변경하는 것이 더 좋다.

public class Inheritance04 {
    public static void main(String[] args){
        Point3D2 p = new Point3D2(3,5,7);
//        Point3D2 p = new Point3D2(); 생성자 함수를 사용하여 해당 초기화코드를 위의 코드로 간결하게 작성 가능.
//        p.x = 3;
//        p.y = 5;
//        p.z = 7;
        System.out.println(p.getLocation());
        System.out.println(p.toString());
        System.out.println(p);
    }
}

/**
 *    - 오버라이딩의 조건
 *      1. 선언부가 조상 클래스의 메서드와 일치해야 한다.
 *         선언부 : 반환타입, 메서드이름, 매개변수 목록.
 *      2. 접근 제어자를 조상 클래스의 메서드보다 좁은 범위로 변경할 수 없다.
 *         접근 제어자 : public, protected, private.
 *      3. 예외는 조상 클래스의 메서드보다 많이 선언할 수 없다.
 *         예외 선언 ex) throws IOException, SQLException ...
 *
 *    - 오버로딩 vs 오버라이딩
 *      오버로딩(overloading) : 기존에 없는 새로운 메서드를 정의하는 것(new)
 *      오버라이딩(overriding) : 상속받은 메서드의 내용을 변경하는 것(change, modify)
 */

class Parent1{
    void parentMethod(){}
}
class Child2 extends Parent1{
    void parentMethod(){} // 오버라이딩
    void parentMethod(int i){} // 오버로딩

    void childMethod(){} // 새로운 메서드 정의
    void childMethod(int i){} // 오버로딩
//    void childMethod(){} //에러, 중복정의

}