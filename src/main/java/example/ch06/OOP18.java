package example.ch06;

public class OOP18 {
    public static void main(String[] args){
        /**
         *    - 변수의 초기화
         *      지역변수는 수동 초기화(직접 초기화) 해야 된다.(** 사용 전 꼭!! **)
         *      멤버변수(인스턴스, 클래스)는 자동 초기화된다.
         */
    }
}
class InitTest{
    int x;      // 인스턴스 변수.
    int y = x;  // 인스턴스 변수.

    void method1(){
        int i;      // 지역변수.
//        int j = i;  // 에러, 지역변수를 초기화하지 않고 사용.
    }
}
