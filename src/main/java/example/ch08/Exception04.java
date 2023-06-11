package example.ch08;
/**
 *    - 예외 발생시키기
 *      1. 연산자 new를 이용해서 발생시키려는 예외 클래스의 객체를 만든 다음
 *          Exception e = new Exception("고의로 발생시킨 에러");
 *      2. 키워드 throw를 이용해서 예외를 발생시킨다.
 *          throw e;
 *
 *    - 예외의 종류 : checked예외, unchecked예외.
 */
public class Exception04 {
    public static void main(String[] args){
        try {
            Exception e = new Exception("고의로 발생시켰다.");
            throw e; // 예외를 발생시킴
//            throw new Exception("고의로 발생시켰다."); // 위의 두 줄을 한 줄로 줄여 쓸 수 있다.
        }catch(Exception e){
            System.out.println("에러 메시지 : " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("프로그램이 정상 종료되었다.");
    }
}
