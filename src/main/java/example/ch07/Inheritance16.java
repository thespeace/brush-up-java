package example.ch07;

public class Inheritance16 {
    public static void main(String[] args){
        /**
         *    - 추상 클래스(abstract class)
         *      미완성 설계도, 미완성 메서드를 갖고 있는 클래스.( == 구현부인 블럭 {} 이 없는 메서드 )
         *          ex) abstract class Player {  // 추상 클래스(미완성 클래스) : 미완성 메서드(추상 메서드)를 가지고 있는 클래스.
         *                " abstract 리턴타입 메서드이름(); "
         *                  abstract void play(int pos);  // 추상 메서드(몸통{}이 없는 미완성 메서드).
         *                  abstract void stop();         // 추상 메서드.
         *              }
         *
         *      다른 클래스 작성에 도움을 주기 위한 것. 인스턴스 생성 불가.
         *          ex) Player p = new Player(); // Error, 추상 클래스의 인스턴스 생성 불가.
         *
         *      상속을 통해 추상 메서드를 완성해야 인스턴스 생성가능.
         *          ex) class AudioPlayer extends Player {
         *                  void play(int pos) { ... } // 추상 메서드를 구현( == {} 블럭 구현. )
         *                  void stop() { ... }        // 추상 메서드를 구현
         *              }
         *
         *              AudioPlayer ap = new AudioPlayer(); // OK.
         *
         *      꼭 필요하지만 자손마다 다르게 구현될 것으로 예상되는 경우 사용한다.
         *          ex) class AudioPlayer extends Player {
         *                  void play(int pos) { ... } // 조상 클래스에 상속받은 모든 메서드를 구현하지 않고, 한개만 구현했기 때문에 미완성 클래스 메서드이다.
         *              }
         */
        Player ap = new AudioPlayer(); //다형성
        ap.play(100);
        ap.stop();
    }
}
abstract class Player{
    boolean pause;   // 일시정지 상태를 저장하기 위한 변수.
    int currentPos;  // 현재 play되고 있는 위치를 저장하기 위한 변수.

    Player(){        // 추상클래스도 생성자가 있어야 한다.
        pause = false;
        currentPos = 0;
    }
    /** 지정된 위치(pos)에서 재생을 시작하는 기능이 수행하도록 작성되어야 한다.*/
    abstract  void play(int pos);   // 추상메서드.
    /** 재생을 즉시 멈추는 기능을 수행하도록 작성되어야 한다.*/
    abstract  void stop();          // 추상메서드.
    void play() {
        play(currentPos);           // 추상 메서드를 사용할 수 있다, 메서드는 선언부만 알면 호출가능하므로 추상메서드도 호출 가능!!
    }                               // 이후 1.상속을 통해 구현부를 완성, 2.자손 객체 생성 후에 호출하여 사용 가능.

    // abstract를 사용하여 필수기능으로 작성하게 할 수 있다. 해당 메서드를 구현하기를 강제할 수 있는 것이다.(필수 & 중요한 기능)
}
class AudioPlayer extends Player{
    void play(int pos) {
        System.out.println(pos + "위치 부터 play합니다.");
    }
    void stop(){
        System.out.println("재생을 멈춥니다.");
    }
}
