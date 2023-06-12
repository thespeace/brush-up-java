package example.ch08;
/**
 *    - 메서드에 예외 선언하기.
 *      예외를 처리하는 방법 : 1) try-catch문
 *                          2) 예외 선언하기(예외 떠넘기기 혹은 알리기) : 메서드가 호출시 발생가능한 예외를 호출하는 쪽에 알리는 것.
 *
 *                             ex) void method() throws Exception1, Exception2, ... ExceptionN {
 *                                      //메서드의 내용
 *                                 }
 *                                 // method()에서 Exception과 그 자손 예외 발생 가능
 *                                 void method() throws Exception { <- 모든 예외의 최고 조상, 모든 종류 예외가 발생가능. 위의 예외처리보다 더 많은 예외 처리가 가능.
 *                                     // 메서드의 내용
 *                                 }
 *                                      + 예외를 발생시키는 키워드 [throw]와 예외를 메서드에 선언할 때 쓰이는 throws를 잘 구별하자.
 *                                      + 오버라이딩의 규칙 1)선언부 일치, 2)접근제어자의 범위를 더 좁게 불가, 3)조상보다 많은 예외 선언 X.
 */
public class Exception05 {
    public static void main(String[] args) throws Exception{
        method1(); // 같은 클래스내의 static멤버이므로 객체생성없이 직접 호출가능.
    }

    static void method1() throws Exception{
        method2();
    }
    static void method2() throws Exception{
        throw new Exception();
    }
}
