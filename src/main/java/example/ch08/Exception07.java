package example.ch08;

import java.io.Serializable;

/**
 *    - 연결된 예외(chained exception)
 *      한 예외가 다른 예외를 발생시킬 수 있다.
 *      예외 A가 예외 B를 발생시키면, A는 B의 원인 에외(cause exception).
 *      
 *          Throwable initCause(Throwable cause) : 지정한 예외를 원인 예외(A)로 등록
 *          Throwable getCause() : 원인 예외를 반환
 *          Throwable : Exception과 Error의 조상.
 *
 *     ex)
 *     class Throwable implements Serializable {
 *          ...
 *          private Throwable cause = this; // 객체 자신(this)를 원인 예외로 등록, 즉 원인 예외를 저장하기 위한 인스턴스 변수 생성.
 *          ...
 *          public synchronized Throwable initCause(Throwable cause) {
 *              ...
 *              this.cause = cause; // cause를 원인 예외로 등록
 *              return this;
 *          }
 *          ...
 *     }
 */


public class Exception07 {
    public static void main(String[] args){

    }
}
