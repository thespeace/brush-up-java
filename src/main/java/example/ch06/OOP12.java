package example.ch06;

public class OOP12 {
    public static void main(String[] args){
        /**
         *      호출 스택(call stack)은 모든 프로그래밍 언어에서 공통적인 것이고, 매우 중요한 개념입니다.
         *      호출 스택을 이해하지 못하면 기본형 매개변수와 참조형 매개변수의 차이, 예외처리 같은 개념들을 이해하기가 쉽지 않습니다.
         *
         *      스택(stack) : 밑이 막힌 상자. 위에 차곡차곡 쌓인다.
         *                   넣을 때 1,2,3,4 순서로 넣었다면 꺼낼때는 4,3,2,1순서로 꺼낼 수 있다.
         *                   이처럼 위에 뚫린 공간으로만 넣거나 뺄 수 있습니다.
         *
         *    - 호출 스택(call Stack)
         *      메서드 수행(작업 수행)에 필요한 메모리가 제공되는 공간.
         *      메서드가 호출되면 호출스택에 메모리 할당, 종료되면 해제(호출스택에서 사용하던 메모리 공간 제거).
         *      아래 있는(먼저 쌓인) 메서드가 위의 메서드를 호출, 맨 위의 * 메서드 하나만 실행 중, 나머지는 대기 중 *.
         */

        System.out.println("Hello");

        // 1. 메인 메서드 호출 (main 실행 중)
        // 2. println메서드 호출 (println 실행 중, main 대기 중)
        // 3. 메인 메서드로 돌아옴 (main 실행 중)
        // 4. 프로그램 종료 ( stack이 비워짐 )

    }
}
