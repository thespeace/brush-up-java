package example.ch07;

public class Inheritance16 {
    public static void main(String[] args){
        /**
         *    - 추상 클래스(abstract class)
         *      미완성 설계도, 미완성 메서드를 갖고 있는 클래스.( == 구현부인 블럭 {} 이 없는 메서드 )
         *          ex) abstract class Player {  // 추상 클래스(미완성 클래스) : 미완성 메서드(추상 메서드)를 가지고 있는 클래스.
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
         */

    }
}
