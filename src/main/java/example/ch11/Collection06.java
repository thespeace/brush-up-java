package example.ch11;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Collection06 {
    public static void main(String[] args) {
        /**
         *    - 스택과 큐(Stack & Queue)의 활용
         *      스택의 활용 예 : 수식계산, 수식괄호검사, 워드프로세서의 undo(취소)/redo(되돌리기).
         *                     웹브라우저의 뒤로/앞으로
         *      큐의 활용 예   : 최근사용문서, 인쇄작업 대기목록, 버퍼(buffer)
         */

        //예제

        Stack st = new Stack();
        String expression = "((3+5)*8-2)";

        System.out.println("expression:" + expression);

        try {
            for (int i = 0; i < expression.length(); i++) {
                char ch = expression.charAt(i);

                if (ch == '(') {
                    st.push(ch + "");
                } else if (ch == ')') {
                    st.pop();
                }
            }

            if (st.isEmpty()) { // Stack이 비어있으면 --
                System.out.println("괄호가 일치합니다.");
            } else {
                System.out.println("괄호가 일치하지 않습니다.");
            }
        } catch (EmptyStackException e) {
            System.out.println("괄호가 일치하지 않습니다.");
        }
    }
}
