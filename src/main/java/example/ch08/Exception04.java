package example.ch08;
/**
 *    - 예외 발생시키기
 *      1. 연산자 new를 이용해서 발생시키려는 예외 클래스의 객체를 만든 다음
 *          Exception e = new Exception("고의로 발생시킨 에러");
 *      2. 키워드 throw를 이용해서 예외를 발생시킨다.
 *          throw e;
 *
 *    - 예외의 종류 : checked예외, unchecked예외.
 *      checked예외 : 컴파일러가 예외 처리 여부를 체크(예외 처리 필수). ex) Exception과 그 자손.
 *      unchecked예외 : 컴파일러가 예외 처리 여부를 체크 안함(예외 처리 선택). ex) Runtime Exception과 그 자손.
 */
public class Exception04 {
    public static void main(String[] args){
        try {
            Exception e = new Exception("고의로 발생시켰다.");
            throw e; // 예외를 발생시킴, 해당 예외처리를 실행하려면 try-catch문이 필수적이다. 없다면 컴파일조차 안된다.(컴파일 에러)
//            throw new Exception("고의로 발생시켰다."); // 위의 두 줄을 한 줄로 줄여 쓸 수 있다.
        }catch(Exception e){
            System.out.println("에러 메시지 : " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("프로그램이 정상 종료되었다.");

        throw new RuntimeException("try-catch문이 없어도 예외처리 가능."); // 고의로 예외 발생, 예외처리가 선택적이여서 try-catch문이 없어도 컴파일 가능하지만, 예외가 발생하는 것은 명백하기때문에 프로그램은 비정상 종료된다.

//        System.out.println("컴파일이 되었다고 예외가 발생하지 않는 것은 아니다. 예외처리를 해주어야 함.");
    }
}
