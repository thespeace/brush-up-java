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
 *            만일 일치하는 catch블럭을 찾지 못하면, 예외는 처리되지 못한다.
 *      2.try블럭 내에서 예외가 발생하지 않은 경우.
 *          1)catch블럭을 거치지 않고 전체 try-catch문을 빠져나가서 수행을 계속한다.
 */
public class Exception02 {
    public static void main(String[] args){
        System.out.println(1);
        try{
            System.out.println(2);
            System.out.println(3);
        }catch(Exception e){
            System.out.println(4);
        } // try-catch의 끝
        System.out.println(5);
    }
}
