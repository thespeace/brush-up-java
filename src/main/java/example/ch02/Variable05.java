package example.ch02;

public class Variable05 {
    public static void main(String[] args){
        /**
         *    두 변수의 값 교환하기.
         */

        int x1 = 10, y1 = 20;
        x1 = y1; //y의 값을 x에 저장, x는 y로 대체.
        System.out.println("x1 : " + x1 + ", y1 : " + y1);
        y1 = x1; // x의 값을 y에 저장, y는 x로 대체.
        System.out.println("x1 : " + x1 + ", y1 : " + y1); //결국 두 값은 같아져 버렸습니다.

        int x2 = 30, y2 = 40;
        int tmp; //빈 값을 가진 변수.
        tmp = x2; //x2의 값을 tmp에 저장.
        x2 = y2; //x2의 값을 y2에 저장.
        y2 = tmp; //tmp의 값을 y2에 저장.
        System.out.println("x2 : " + x2 + ", y2 : " + y2); //두 값을 바꾸었습니다.

    }
}
