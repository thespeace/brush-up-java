package example.ch07;

public class Inheritance05 {
    public static void main(String[] args){
        /**
         *    - 참조변수 super.
         *      객체 자신을 가리키는 참조변수로 this와 거의 같은 기능을 한다.
         *      인스턴스 메서드(생성자)내에만 존재한다. <-> static 메서드 내에서 사용 불가
         *      this는 인스턴스 변수와 지역변수를 구별에 사용했다면, super은 조상의 멤버를 자신의 멤버와 구별할 때 사용합니다.
         */
        Child3 c = new Child3();
        c.method();

    }
}
//참조변수 super을 사용한 간단한 예시
class Parent3 { int x = 10; /* super.x */ }
class Child3 extends Parent3 {
    int x = 20; // this.x

    void method(){
        System.out.println("x = " + x);
        System.out.println("this.x = " + this.x);
        System.out.println("super.x = " + super.x); // 변수 이름이 겹칠땐 * 참조변수 super *을 붙히면 조상의 변수를 불러올 수 있다.
    }
}
/**
 *    - super() - 조상의 생성자.
 *      조상의 생성자를 호출할 때 사용. ex) 생성자, 초기화 블럭은 상속이 되지않기 때문에,,
 *      조상의 멤버는 조상의 생성자를 호출해서 초기화.
 */

//super()의 간단한 예시
class SuperEx{
    int x, y;
    SuperEx(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class SuperExChild extends SuperEx{
    int z;
    SuperExChild(int x, int y, int z) {
        //this.x = x; <- 조상의 멤버를 초기화
        //this.y = y; <- 조상의 멤버를 초기화
        super(x, y); // 조상클래스의 생성자 SuperEx(int x, int y)를 호출하는 것이 올바른 방법.
        this.z = z;  //자신의 멤버를 초기화
    }
}

/**
 *    - super() - 조상의 생성자.
 *      ** 생성자의 첫 줄에 반드시 생성자를 호출해야 한다. **
 *      그렇지 않으면 컴파일러가 생성자의 첫 줄에 super();를 삽입.
 *          ex)
 *              class Point //extends Object//{   <- 컴파일러에 의해 자동삽입으로 인한 코드는 //해당 처리//
 *                  int x;
 *                  int y;
 *
 *                  Point(){
 *                      this(0,0); <- 생성자 호출, 조건 만족. 정상 작동.
 *                  }
 *
 *                  Point(int x, int y){
 *                      //super();//  <- Object(); : 조상 기본 생성자 호출, 컴파일러에 의해 자동삽입. 생성자의 첫 줄에 반디스 생성자 호출 필수!
 *                      this.x = x;
 *                      this.y = y;
 *                  }
 *              }
 */