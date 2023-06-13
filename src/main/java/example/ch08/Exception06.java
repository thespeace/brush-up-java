package example.ch08;
/**
 *    - 사용자 정의 예외 만들기
 *      1. 우리가 직접 예외 클래스를 정의할 수 있다.
 *         조상은 Exception과 RuntimeException중에서 선택.
 *
 *          class MyException extends Exception {
 *            2) MyException(String msg){ // 문자열을 매개변수로 받는 생성자를 꼭 작성해주어야 한다.
 *                  super(msg); // 조상인 Exception클래스의 생성자를 호출한다.
 *              }
 *          }
 */

class MyException extends Exception { // Exception이기 때문에 필수처리 예외라는 것을 알 수 있다. <-> RuntimeException은 선택처리!
    //에러 코드 값을 저장하기 위한 필드를 추가 했다.
    private final int ERR_CODE; // 생성자를 통해 초기화 한다.

    MyException(String msg, int errCode) { //생성자
        super(msg);
        ERR_CODE = errCode;
    }

    MyException(String msg){ // 생성자
        this(msg, 100);      // ERR_CODE를 100(기본값)으로 초기화한다.
    }

    public int getErrCode() { // 에러 코드를 얻을 수 있는 메서드도 추가했다.
        return ERR_CODE;      // 이 메서드는 주로 getMessage()와 함께 사용될 것이다.
    }
}

/**
 *    - 예외 되던지기(exception re-throwing)
 *      예외를 처리한 후에 다시 예외를 발생시키는 것
 */

public class Exception06 {
    public static void main(String[] args){

    }
}
