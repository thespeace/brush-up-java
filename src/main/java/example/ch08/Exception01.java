package example.ch08;
/**
 *    - 프로그램 오류
 *
 *      1. 컴파일 에러(compile-time error) : 컴파일 할 때 발생하는 에러.(실행불가)
 *          컴파일러(javac.exe)가 하는 일 : 1.구문체크, 2.번역, 3.최적화, 4.생략된코드추가 등등..
 *
 *      2. 런타임 에러(runtime error) : 실행 할 때 발생하는 에러.(실행은 가능하나 프로그램이 작동 종료될 수도 있다.)
 *          - java의 런타임 에러 : 에러는 어쩔 수 없지만, 예외는 처리하자.
 *              1. 에러(error)     : 프로그램 코드에 의해서 수습될 수 없는 심각한 오류. ex) OOME(Out Of Memory Error)...
 *              2. 예외(exception) : 프로그램 코드에 의해서 수습될 수 있는 다소 미약한 오류.
 *          - 예외처리(exception handling)의 정의와 목적
 *              1. 정의 : 프로그램 실행 시 발생할 수 있는 예외의 발생에 대비한 코드를 작성하는 것.
 *              2. 목적 : 프로그램의 비정상 종료를 막고, 정상적인 실행상태를 유지하는 것.
 *
 *      3. 논리적 에러(logical error) : 작성 의도와 다르게 동작.(실행, 프로그램은 정상작동하나 원하는 기능을 하지 않음.)
 *
 *    - 예외 클래스의 계층 구조
 *      Object(최고 조상) - Throwalbe(클래스, 모든 오류의 조상) - 1.Error(심각한 오류) - 1-1.OutOfMemoryError 등등..
 *                                                           2.Exception(미약한 오류) - 2-1.IOException(입출력 에러) : 2와 2-1 클래스들은 사용자의 실수와 같은 외적인 요인에 의해 발생하는 예외.
 *                                                                                    2-2.ClassNotFoundException(클래스 존재 에러)
 *                                                                                    2-3.RuntimeException : 2-3과 그 자손 클래스들은 프로그래머의 실수로 발생하는 예외.
 *                                                                                          2-3-1.ArithmeticException(산술계산예외)
 *                                                                                          2-3-2.ClassCastException(형변환예외)
 *                                                                                          2-3-3.NullPointException(Null을 사용하려할때 예외)
 *                                                                                          2-3-4.IndexOutOfBoundsException(배열범위로 인한 예외) 등등...
 *                                                                                    2-4. 기타 등등..
 */
public class Exception01 {
    public static void main(String[] args){
//        system.out.println(args[0]); // Compile Error! 대소문자로 인해 컴파일러(javac.exe) 해석 불가.
        System.out.println(args[0]);   // Runtime Error! 호출하려는 값이 존재하지 않아 발생.
    }
}
