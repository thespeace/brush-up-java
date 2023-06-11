package example.ch08;
/**
 *    - printStackTrace() 와 getMessage().
 *      printStackTrace() : 예외발생 당시의 호출스택(Call Stack)에 있었던 메서드의 정보와 예외 메시지를 콘솔창에 출력한다.
 *      getMessage() : 발생한 예외클래스의 인스턴스에 저장된 메시지를 얻을 수 있다.
 *
 *    - try-catch블럭의 예외 발생 시 일어나는 일.
 *      1.try블럭에서 예외 발생
 *      2.해당 예외의 객체 생성 -> 발생한 예외에 대한 정보를 예외 객체에서 다양한 메서드들(getMessage() 등등..)을 통해 꺼내올 수 있다.
 *      3.catch블럭에서 예외객체와 일치하는지 확인(instance of 연산자 사용) 후, 해당 블럭에서 예외객체의 메서드 실행 가능.
 *
 *    - 멀티 catch 블럭
 *      내용이 같은 catch블럭을 하나로 합친 것(JDK1.7 부터)
 *          ex) try {
 *                  ...
 *              }catch(ExceptionA | ExceptionB e) {
 *                  e.methodA(); // Error, ExceptionA에 선언된 methodA()는 호출불가, 즉! ExceptionA와 ExceptionB의 공통 멤버만 사용 가능.
 *                               // 하나의 catch 블럭으로 여러 예외를 처리하는 것이기 때문에 해당 약점이 생길 수 밖에 없다.
 *                  if(e instanceof ExceptionA) { //위와 같은 약점은 if문으로 해당 에러인지 확인 후 -
 *                      ExceptionA e1 = (ExceptionA) e; // 형변환을 통해 사용 가능.
 *                      e1.methodA(); // OK, ExceptionA에 선언된 메서드 호출 가능.
 *                  } else { // if(e instanceof ExceptionB)
 *                      ...
 *                  }
 *              }
 *      멀티 catch블럭은 최대한 처리할 메서드가 동일할 때 사용하는 것을 추천.
 */
public class Exception03 {
    public static void main(String[] args){
        System.out.println(1);
        System.out.println(2);
        try{
            System.out.println(3);
            System.out.println(0/0);
            System.out.println(4);
        }catch (ArithmeticException ae){ // 참조변수 ae를 통해, 생성된 ArithmeticException 인스턴스에 접근 할 수 있다.
            ae.printStackTrace(); // 생성된 ArithmeticException 인스턴스의 메소드를 사용해 에러 정보를 호출.
            System.out.println("예외 메시지 : " + ae.getMessage());
        }
        System.out.println(5);
    }
}
