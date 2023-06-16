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
 *
 *     void install() throws InstallException {
 *     try {
 *         startInstall(); // SpaceException 발생(A)
 *         copyFiles();
 *     } catch (SpaceException e) {
 *         InstallException ie = new InstallException("설치중 공간 부족으로 예외 발생") // 예외 생성(B), A 예외를 생성된 예외에 담아서 반환.
 *         ie.initCause(e);
 *         throw ie;
 *     } catch (MemoryException me) {
 *         InstallException ie = new InstallException("설치중 메모리 부족으로 예외 발생") // 예외 생성(B), 새로운 예외를 담아서 반환.
 *         ie.initCause(e);
 *         throw ie;
 *         ...
 *
 *    - 연결된 예외를 사용하는 이유.
 *      1. 여러 예외를 하나로 묶어서 다루기 위해서, 즉 캐치블럭을 줄일 수 있기 때문.
 *      2. checked예외를 unchecked예외로 변경하려 할 때
 *          ex)
 *              static void startInstall() throws SpaceException, MemoryException {
 *                  if(!enoughSpace())
 *                      throw new SpaceException("설치할 공간이 부족합니다.");
 *                  if(!enoughMemory())
 *                      throw new MemoryException("메모리가 부족합니다.");
 *              }
 *
 *              --MemoryException을 unchecked예외로 변경-->
 *
 *              static void startInstall() throws SpaceException{
 *                  if(!enoughSpace())
 *                      throw new SpaceException("설치할 공간이 부족합니다.");
 *                  if(!enoughMemory())
 *                      throw new RuntimeException(new MemoryException("메모리가 부족합니다.")); // RuntimeException을 만들고 그 안에 원인예외로 등록.
 *              }
 */

public class Exception07 {
    public static void main(String[] args){
        System.out.println("연결된 예외를 간단히 설명하면 어떤 예외를 다른 예외로 감싸는 것으로 세부적인 예외들을 포괄적인 예외로 감쌀때와 필수예외처리를 선택예외처리로 변경할 때 사용하곤 합니다.");
    }
}
