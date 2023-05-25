package example.ch07;

public class Inheritance13 {
    public static void main(String[] args){
        /**
         *    - instanceof 연산자
         *      참조변수의 형변환 가능여부 확인에 사용. 가능하면 true 반환.
         *      형변환 전에 반드시 instanceof로 확인해야 한다.
         *          ex)
         *              void doWork(Car c) {                   // 1. 다형성으로 인해 매개변수로 조상 타입과 그의 모든 자손이 모두 기입 가능.
         *                  if(c instanceof FireEngine) {      // 2. 형변환이 가능한지 확인.
         *                      FireEngine fe = (FireEngine)c; // 3. 형변환, why? 인스턴스의 원래 기능을 모두 사용하기 위해 한다.
         *                                                           조상타입의 참조변수는 상속받지 않은 자손타입의 멤버변수를 사용할 수 없기 때문에 사용하기 위해서 참조변수 형변환을 해줘야 한다.
         *                      fe.water();
         *                      ...
         *
         */

    }
}
