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
    String getLocation(){ return "x :" + x + ", y :" + y + ", z :" + z; } //오버라이딩. z를 포함하여 내용만 변경. 선언부는 변경불가! 구현부( {} )만 변경가능.
}
// 왜 오버라이딩? 의미상 같은 작업을 해야하기 때문에 새로운 메서드를 만들기보다는 조상의 메서드를 자신에 맞게 변경하는 것이 더 좋다.

public class Inheritance04 {
    public static void main(String[] args){

    }
}
