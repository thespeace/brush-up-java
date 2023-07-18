package example.ch11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Collection05 {
    public static void main(String[] args) {
        /**
         *    - 스택과 큐(Stack & Queue)
         *      1. 스택(Stack) : LIFO(Last In First Out)구조, 마지막에 저장된 것을 제일 먼저 꺼내게 된다. ex) 밑이 막힌 Box.
         *                      저장(push), 추출(pop)의 순서가 반대이다.
         *                      위로만 넣고 뺄 수 있다.
         *                      스택을 구현하기 위해서는 배열이 적합하여 효율적이다.(순차적 추가/삭제)
         *
         *      2. 큐(Queue) : FIFO(First In First Out)구조, 제일 먼저 저장한 것을 제일 먼저 꺼내게 된다. ex) 줄서기, 양 끝이 뚫린 상자.
         *                    저장(offer), 추출(poll)의 순서는 일치한다.
         *                    큐를 구현하기 위해서는 링크드 리스트가 적합하여 효율적이다.(요소의 추가/삭제시 요소간의 자리 이동이 필요가 없음으로 적합하다)
         *
         *    - 스택과 큐의 메서드
         *      아래의 주석(설명)과 코드(메서드)로 확인.
         */

        //스택(Stack) 클래스 사용 예시
        Stack st = new Stack();

        /**
         *    - 스택(Stack)의 메서드들.
         */

        // boolean empty() : Stack이 비어있는지 알려준다.
        System.out.println(st.empty());

        //Object push(Object item) : Stack에 "객체(item)를 저장"한다.
        st.push("0");
        st.push("1");
        st.push("2");


        //Object peek() : Stack의 맨 위에 저장된 객체를 반환. pop()과 달리 Stack에서 객체를 꺼내지는 않음.(꺼내지않고 바라만 보는 것, 비었을 때는 EmptyStackException 발생)
        System.out.println(st.peek());

        System.out.println("= Stack =");
        while(!st.empty()) { //비었는지 확인
            //Object pop() : Stack의 맨 위에 저장된 "객체를 추출"한다.(비었을 때는 EmptyStackException 발생)
            System.out.println(st.pop()); // 스택에서 요소 하나를 꺼내서 출력
        }

        //int search(Object o) : Stack에서 주어진 객체(o)를 찾아서 그 위치를 반환. 못찾으면 -1을 반환.(배열과 달리 위치는 0이 아닌 1부터 시작) == ArrayList의 indexOf()와 비슷하지만 차이점은 search()는 1부터 시작.
        System.out.println(st.search("1"));



        /**
         *    - 큐(Queue)의 메서드들.
         *      인터페이스인 큐(Queue)를 구현한 클래스의 목록을 찾아 사용하면 된다.
         *      해당 클래스들을 사용하면 큐(Queue)가 가지고 있는 추상메서드들을 모두 사용할 수 있다.
         *      @apiNote https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html
         */

        //큐(Queue) 인터페이스 사용 예시.
        Queue<Integer> queueInteger = new LinkedList<>(); //int형 queue 선언, linkedlist 이용
        Queue<String> queueString = new LinkedList<>(); //String형 queue 선언, linkedlist 이용

        Queue q = new LinkedList(); // Queue인터페이스의 구현체인 LinkedList를 사용.
                                    // 참조변수 Queue로 지정시 장점 : Queue인터페이스에 정의되어있는 메서드만 사용한 것이 확실해지니, 나중에 다른 클래스로 바꾸기에도 문제없다.

        //boolean add(Object o) : 지정된 객체를 Queue에 추가한다. 성공하면 true를 반환. 저장공간이 부족하 면 illegalStateException발생.
        q.add(9);

        //Object element() : 삭제없이 요소를 읽어온다. peek와 달리 Queue가 비었을 때 NoSuchElementException발생.
        System.out.println(q.element());

        //Object remove() : Queue에서 객체를 꺼내 반환, 비어있으면 NoSuchElementException 발생. + try - catch 처리.
        q.remove(1);

        //위의 메서드는 예외발생 O, 아래의 메서드는 예외발생 X.

        //boolean offer(Object o) : 추가, Queue에 객체를 저장, 성공하면 true, 실패하면 false를 반환.
        q.offer(9);

        System.out.println("= Queue =");
        while(!q.isEmpty()) { //비었는지 확인
            //Object poll() : 삭제, Queue에서 객체를 꺼내서 반환, 비어있으면 null을 반환. + if(obj == null).
            System.out.println(q.poll()); // 큐에서 요소 하나를 꺼내서 출력
        }

        //Object peek() : 삭제없이 요소를 읽어 온다(꺼내지않고 바라만 보는 것). Queue가 비어있으면 null을 반환.
        q.peek();

    }
}
