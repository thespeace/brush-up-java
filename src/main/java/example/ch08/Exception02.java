package example.ch08;
/**
 *    - 예외 처리하기(exception handling) : try-catch 문.
 *      1.정의 : 프로그램 실행 시 발생할 수 있는 예외의 발생에 대비한 코드를 작성하는 것
 *      2.목적 : 프로그램의 비정상 종료를 막고, 정상적인 실행상태를 유지하는 것
 *
 *      ex) try {
 *              //예외가 발생할 가능성이 있는 문장들을 넣는다.
 *          } catch (Exception1 e1) {
 *              //Exception1이 발생했을 경우, 이를 처리하기 위한 문장을 적는다.
 *          } catch (Exception2 e2) {
 *              //Exception2가 발생했을 경우, 이를 처리하기 위한 문장을 적는다.
 *          } catch (ExceptionN eN) {
 *              //ExceptionN이 발생했을 경우, 이를 처리하기 위한 문장을 적는다.
 *          }
 *          + if문과 달리, try블럭이나 catch블럭 내에 포함된 문장이 하나뿐이어도 괄호{}를 생략할 수 없다.
 *
 *    - try-catch문에서의 흐름
 *      1.try블럭 내에서 예외가 발생한 경우.
 *          1)발생한 예외와 일치하는 catch블럭이 있는지 확인한다.
 *          2)일치하는 catch블럭을 찾게 되면, 그 catch블럭 내의 문장들을 수행하고 전체 try-catch문을 빠져나가서 그 다음 문장을 계속해서 수행한다.
 *            만일 일치하는 catch블럭을 찾지 못하면, 예외는 처리되지 못한다. 따라서 비정상적으로 프로그램은 종료될 수 밖에 없다.
 *      2.try블럭 내에서 예외가 발생하지 않은 경우.
 *          1)catch블럭을 거치지 않고 전체 try-catch문을 빠져나가서 수행을 계속한다.
 *
 *    - 예외의 발생과 catch 블럭
 *      예외가 발생하면, 이를 처리할 catch블럭을 찾아 내려간다.
 *      일치하는 catch블럭이 없으면, 예외는 처리 안된다.
 *      Exception이 선언된 catch블럭은 모든 예외를 처리(보통 마지막 catch블럭으로 사용).
 */
public class Exception02 {
    public static void main(String[] args){
        System.out.println(1);
        System.out.println(2);
        try{
            System.out.println(0/0); // 0은 0으로 나눌 수 없다. 예외 발생 시, 수학 관련 예외 처리가 필요함으로 해당 catch문으로 이동하여 구현부를 실행.
            System.out.println(3);
            System.out.println(args[0]); // 위의 연산을 주석처리하면 배열관련된 예외처리 확인 가능.
            System.out.println(4); // 위 코드가 예외가 발생한 경우, 예외가 발생한 코드 이후의 코드들은 실행되지 않는다.
        }catch (ArithmeticException ae){
            System.out.println("ArithmeticException");
        }catch (ArrayIndexOutOfBoundsException ai){
            System.out.println("ArrayIndexOutOfBoundsException");
        }catch(Exception e){ // 모든 예외 처리의 최고 조상, ArithmeticException을 제외한 모든 예외를 처리한다. 보통 마지막에 최후의 방어수단으로 해당 예외를 처리한다.
            System.out.println("Exception"); // 예외가 발생하였을때 실행.
        } // try-catch의 끝
        System.out.println(5);
    }
}
