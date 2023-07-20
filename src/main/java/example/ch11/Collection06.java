package example.ch11;

import java.util.*;

public class Collection06 {

    static Queue q = new LinkedList();// 링크드 리스트를 구현체로 사용해서 객체 생성.
    static final int MAX_SIZE = 5;	// Queue에 최대 5개까지만 저장되도록 한다.

    public static void main(String[] args) {
        /**
         *    - 스택과 큐(Stack & Queue)의 활용
         *      스택의 활용 예 : 수식계산, 수식괄호검사, 워드프로세서의 undo(취소)/redo(되돌리기).
         *                     웹브라우저의 뒤로/앞으로
         *      큐의 활용 예   : 최근사용문서, 인쇄작업 대기목록, 버퍼(buffer)
         */

        //예제
        System.out.println("=================Example1(Stack를 이용하여 수식 괄호 체크하기)=================");

        Stack st = new Stack();
        String expression = "((3+5)*8-2)";

        System.out.println("expression:" + expression);

        try {
            for (int i = 0; i < expression.length(); i++) {
                char ch = expression.charAt(i); // 한 글자씩 확인.

                if (ch == '(') {
                    st.push(ch + "");
                } else if (ch == ')') {
                    st.pop();
                }
            }

            if (st.isEmpty()) { // Stack이 비어있으면 Ok.
                System.out.println("괄호가 일치합니다.");
            } else {
                System.out.println("괄호가 일치하지 않습니다.");
            }
        } catch (EmptyStackException e) {
            System.out.println("괄호가 일치하지 않습니다.(예외처리)");
        }



        //예제
        System.out.println("=================Example2(Queue를 이용한 최근 5개의 명령어 이력(history) 확인)=================");
        System.out.println("help를 입력하면 도움말을 볼 수 있습니다.");

        while(true) {
            System.out.print(">>");
            try {
                // 화면으로부터 라인단위로 입력받는다.
                Scanner s = new Scanner(System.in);
                String input = s.nextLine().trim(); //trim으로 앞 뒤 공백을 제거.

                if("".equals(input)) continue;

                if(input.equalsIgnoreCase("q")) {
                    System.exit(0); //프로그램 종료.
                } else if(input.equalsIgnoreCase("help")) { //대소문자 구별X.
                    System.out.println(" help - 도움말을 보여줍니다.");
                    System.out.println(" q 또는 Q - 프로그램을 종료합니다.");
                    System.out.println(" history - 최근에 입력한 명령어를 "
                            + MAX_SIZE +"개 보여줍니다.");
                } else if(input.equalsIgnoreCase("history")) {
                    int i=0;
                    // 입력받은 명령어를 저장하고,
                    save(input);

                    // LinkedList의 내용을 보여준다.
                    LinkedList tmp = (LinkedList)q;
                    ListIterator it = tmp.listIterator();

                    while(it.hasNext())
                        System.out.println(++i+"."+it.next());
                } else {
                    save(input);
                    System.out.println(input);
                } // if(input.equalsIgnoreCase("q")) {
            } catch(Exception e) {
                System.out.println("입력오류입니다.");
            }
        } // while(true)

    }

    public static void save(String input) {
        // queue에 저장한다.
        if(!"".equals(input)) // if(input != null && !input.equals("")) 빈 문자열빼고 다 저장.
            q.offer(input); // Queue에 명령어를 저장.

        // queue의 최대크기를 넘으면 제일 처음 입력된 것을 삭제한다.
        if(q.size() > MAX_SIZE)  // size()는 Collection인터페이스에 정의
            q.remove(); // poll()을 써도 된다.
    }

}
