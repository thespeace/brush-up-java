package example.ch08;

import java.io.File;

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
 *
 *                                 static void startInstall() throws SpaceException, MemoryException { // startInstall메서드를 호출하면 두 가지 예외가 발생할 수 있음을 명시.
 *                                     if(!enoughSpace())   // 충분한 설치 공간이 없으면..
 *                                         throw new SpaceException("설치할 공간이 부족합니다.")
 *                                     if(!enoughMemory())   // 충분한 메모리가 없다면..
 *                                         throw new MemoryException("메모리가 부족합니다.")
 *                                 } // throws : 해당 함수가 처리할 수 있는 일은 처리하지만, 처리할 수 없는 것은 자신을 호출한 메서드에게 알려준다.
 */
public class Exception05 {
    public static void main(String[] args) throws Exception{ // 예외를 처리할 try-catch문이 없음으로 비정상 종료가 되면서 해당 예외는 JVM에게 넘긴다. 그러면 JVM 기본 예외 처리기가 예외가 발생했던 당시의 호출스택을 출력한다.
        method1(); // 같은 클래스내의 static멤버이므로 객체생성없이 직접 호출가능.
    }

    static void method1() throws Exception{
        method2(); // 자신을 호출한 main메서드에게 예외를 넘긴다.
    }
    static void method2() throws Exception{
        throw new Exception(); // 예외가 발생, 자신을 호출한 method1에게 예외를 넘긴다.
    }
}

class Exception05_1 {
    public static void main(String[] args){
        try{ // try-catch로 예외 처리.
            String testFile = "text.txt"; // 파일 생성.
//          String testFile = ""; // catch블럭에서 예외 처리.
            File f = createFile(testFile);
            System.out.println(f.getName() + "파일이 성공적으로 생성되었습니다.");
        } catch (Exception e){
            System.out.println(e.getMessage() + "다시 입력해 주시기 바랍니다.");
        }
    }

    static File createFile(String fileName) throws Exception { // 메인메서드에게 예외 처리를 떠넘기기. throws를 선언한 만으로 예외가 처리되는 것은 아니다.
        if(fileName==null || fileName.equals(""))
            throw new Exception("파일이름이 유효하지 않습니다.");
        File f = new File(fileName); // File클래스의 객체를 만든다.
        // File객체의 createNewFile메서드를 이용해서 실제 파일을 생성한다.
        f.createNewFile();
        return f; // 생성된 객체의 참조를 반환.
    }
}

/**
 *    - finally 블럭
 *      예외 발생여부와 관계없이 수행되어야 하는 코드를 넣는다. 코드의 중복을 제거할 수 있다.
 *      ex)
 *          try{
 *              // 예외가 발생할 가능성이 있는 문장들을 넣는다.
 *          } catch (Exception1 e1){
 *              // 예외처리를 위한 문장을 적는다.
 *          } finally {
 *              // 예외의 발생여부에 관계없이 항상 수행되어야하는 문장들을 넣는다.
 *              // finnaly 블럭은 try-catch문의 맨 마지막에 위치해야 한다.
 *          }
 *          + try블럭 안에 return문이 있어서 try블럭을 벗어나갈 때도 finally 블럭이 실행된다.
 */