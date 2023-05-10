package example.ch06;

public class OOP11 {
    public static void main(String[] args){
        /**
         *    - return문
         *      실행 중인 메서드를 종료하고 호출한 곳으로 되돌아간다.
         *
         *    - 반환값
         *      "return 반환값;"
         *      메서드의 타입이 void가 아닌 반환 타입을 작성했다면 해당 타입과 타입이 일치하는 값 또는 자동형변환이 가능한 값을 return문 뒤에 작성해줘야 한다.
         */

        gugudan gu = new gugudan();
        gu.printGugudan(1);
        gu.printGugudan(2);
    }
}

class gugudan{
    void printGugudan(int dan){
        if(!(2 <= dan && dan <= 9))
            return; // dan의 값이 2~9가 아닌 경우, 호출한 곳으로 그냥 되돌아간다.
        for(int i = 1; i <= 9; i++)
            System.out.printf("%d * %d = %d%n", dan, i, dan * i);
        return; // 반환 타입이 void이므로 생략가능. 컴파일러가 자동추가.
    }

    int max(int x, int y){
        if(x > y)
            return x + y; // 조건식이 참일 때 실행된다. 반환 타입이 void가 아니므로 생략불가.
        else
            return x + y; // 조건식이 거짓일 때 실행된다.
    }
}
