package example.ch07;

/**
 *    - 클래스들의 관계
 *      크게 두 가지로 나눌수 있다 : 1.상속  2.포함
 *
 *    - 포함(Composite)이란?
 *      클래스의 멤버로 참조변수를 선언하는 것.
 *          ex) class Car { <- 작은 단위의 클래스를 만들고, 이 들을 조합해서 클래스를 만든다.
 *                  Engine e = new Engine(); // 엔진
 *                  Door[] d = new Door[4];  // 문, 문의 개수를 넷으로 가정하고 배열로 처리했다.
 *              }
 *      포함하는 것의 이점으로는 복잡도가 줄어들고, 재사용성의 증가로 인해 생산성이 증가한다.
 */
//예시
class Point_For_Circle {
    int x; // 원점의 x좌표
    int y; // 원점의 y좌표
}
class Circle{ //Circle 클래스가 Point_For_Circle 클래스를 포함.
    Point_For_Circle p = new Point_For_Circle(); // 원점 객체 생성(참조변수의 초기화)
    Circle(){
        p = new Point_For_Circle(); // 혹은 생성자 초기화하여 저장공간 생성.
    }
    int r; // 반지름(radius)
}

public class Inheritance02 {
    public static void main(String[] args){
        Circle c = new Circle();
        c.p.x = 1; // 포함관계의 객체 초기화.
        c.p.y = 2;
        c.r = 3;

        System.out.println("c.p.x : " + c.p.x);
        System.out.println("c.p.y : " + c.p.y);
        System.out.println("c.r : " + c.r);
    }
}

/**
 *    - 클래스 간의 관계 결정하기
 *      클래스 간의 관계를 결정할 때, 상속, 포함 중 어떤 관계를 선택해야 하는지는 아래의 문장에 대입하여 결정할 수 있다.
 *      상속관계 : 'A은 B이다. (A is-a B)'
 *      포함관계 : 'A은 B을 가지고 있다.(A has-a B)'
 *          ex) 원(Circle)은 점(Point)이다.          - Circle is a Point.
 *              원(Circle)은 점(Point)을 가지고 있다.  - Circle has a Point. 이것이 더 자연스러움으로 포함관계로 결정할 수 있다.
 *
 *      대부분의 경우 90%이상이 포함관계를 채택한다. 상속은 여러가지 제약이 많기 때문에 꼭 필요할때만 사용한다.
 */