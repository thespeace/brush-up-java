package example.ch07;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inheritance24 {
    /**
     *    - 익명 클래스(anonymous class)
     *      이름이 없는 일회용 클래스.
     *      일반적인 클래스는 1)정의, 2)객체생성 하여 사용하지만, 익명 클래스는 이름이 없으니 조상의 이름을 빌려 정의와 생성을 동시에 수행. ex) new Object() { }
     *
     *      * 기본 문법 *
     *          new 조상클래스이름() {
     *              // 멤버 선언
     *          }
     *                  또는
     *          new 구현인터페이스이름() {
     *              // 멤버 선언
     *          }
     */
    Object iv = new Object(){ void method(){} };        // 익명 클래스.
    static Object cv = new Object(){ void method(){} }; // 익명 클래스.
    void myMethod(){
        Object lv = new Object(){ void method(){} };    // 익명 클래스, 호출 시 이름 대신 숫자가 붙어 주소값을 보여준다.
    }

    public static void main(String[] args){

        //예제) AWT(Java의 윈도우 프로그래밍).
        Button b = new Button("Start");
        b.addActionListener(new EventHandler()); //<- 해당 코드를 아래 익명클래스로 처리.

        b.addActionListener(new ActionListener() { // 일회성인 클래스를 없애고 익명클래스로 처리 가능.
            public void actionPerformed(ActionEvent e) {
                System.out.println("ActionEvent occurred!!!");
            }
        });
        b.addActionListener(new ActionListener() { // 클래스의 정의와 객체 생성을 동시에, 위의 익명클래스를 재사용한게 아니라 새로 생성한 것.
            public void actionPerformed(ActionEvent e) {
                System.out.println("ActionEvent occurred!!!");
            }
        });
    }
}
class EventHandler implements ActionListener { // <- 일회성, 때문에 익명클래스로 처리한다.
    public void actionPerformed(ActionEvent e){
        System.out.println("AutionEvent occurred!!!");
    }
}
