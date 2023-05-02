package example.ch05;

public class Array07 {
    public static void main(String[] args){ // 사용자가 커멘트라인에 입력한 값을 문자열 배열로 args라는 참조변수로 받아서 사용할 수 있다.
        /**
         *    - 커맨드 라인을 통해 입력받기
         *      커맨드 라인에 입력한 값이 문자열 배열에 담겨서 전달된다.
         *
         *      ex) brush-up-java/src/main/java/example/ch05 > java Array06.java abc 123 "Hello World"
         *          String 배열 args[0] : abc, args[1] : 123, args[2] : Hello World 를 매개변수로 받아 사용할 수 있다.
         *
         *      이처럼 커맨드 라인에 매개변수를 주는 방법으로 프로그램을 만들 수 있다. ex) 윈도우 커멘드 명령어 type 등등..
         */

        // brush-up-java/src/main/java/example/ch05 > java Array06.java   // <- 매개변수를 입력하지 않았다.
        System.out.println("매개변수의 개수 : " + args.length); // null값이 아니라 아무 내용이 없는 배열이 만들어져서 넘어간다.
                                                             // 자바에서는 배열의 길이 0을 허용한다. "" 빈문자열 == 길이가 0인 배열.
        for (int i = 0; i < args.length; i++){
            System.out.println("args[" + i + "] = \"" + args[i] + "\"");
        }

    }
}
