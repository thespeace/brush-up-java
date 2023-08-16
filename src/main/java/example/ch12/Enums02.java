package example.ch12;

/**
 *    - 열거형에 멤버 추가하기.
 *      불연속적인 열거형 상수의 경우, 원하는 값을 괄호()안에 적는다. 값은 여러개도 가능하다.
 *
 *          enum Direction { EAST(1), SOUTH(5), WEST(-1), NORTH(10) }
 */

// 괄호()를 사용하려면, 인스턴스 변수와 생성자를 새로 추가해 줘야 한다.
enum example {
    EAST(1), SOUTH(5), WEST(-1), NORTH(10); // 끝에 ';'를 추가해야 한다.
    private final int value; //정수를 저장할 필드(인스턴스 변수)를 추가, 값의 갯수만큼 인스턴스변수 선언 필요.
    example(int value) { this.value = value; } // 값을 받을 수 있는 생성자를 추가. 생성자는 항상 private이기 때문에 생략된 것.
    public int getValue() { return value; }
}

// 열거형의 생성자는 묵시적으로 private이므로, 외부에서 객체생성 불가.
//Direction2 d = new Direction2(1); // ERROR, 열거형의 생성자는 외부에서 호출불가

enum Direction2 {
    EAST(1, ">"), SOUTH(2,"V"), WEST(3, "<"), NORTH(4,"^");

    private static final Direction2[] DIR_ARR = Direction2.values(); // 열거형의 값을 배열에 담기.
    private final int value;
    private final String symbol;

    Direction2(int value, String symbol) { // 생성자 추가, 접근 제어자 private이 생략됨.
        this.value  = value;
        this.symbol = symbol;
    }

    // 인스턴스 변수를 반환 할 수 있는 getter.
    public int getValue()     { return value;  }
    public String getSymbol() { return symbol; }

    public static Direction2 of(int dir) { // 상수 반환을 위한 메서드.
        if (dir < 1 || dir > 4) // 0~3범위를 벗어나면 예외발생.
            throw new IllegalArgumentException("Invalid value :" + dir);

        return DIR_ARR[dir - 1];
    }

    // 방향을 회전시키는 메서드. num의 값만큼 90도씩 시계방향으로 회전한다.
    public Direction2 rotate(int num) {
        num = num % 4;

        if(num < 0) num +=4; // num이 음수일 때는 시계반대 방향으로 회전

        return DIR_ARR[(value-1+num) % 4];
    }

    public String toString() {
        return name()+getSymbol();
    }
} // enum Direction2


public class Enums02 {
    public static void main(String[] args){
        for(Direction2 d : Direction2.values())  // 열거형이 가지고있는 모든 상수를 반환.
            System.out.printf("%s=%d%n", d.name(), d.getValue());

        Direction2 d1 = Direction2.EAST;
        Direction2 d2 = Direction2.of(1);

        System.out.printf("d1=%s, %d%n", d1.name(), d1.getValue());
        System.out.printf("d2=%s, %d%n", d2.name(), d2.getValue());
        System.out.println(Direction2.EAST.rotate(1));
        System.out.println(Direction2.EAST.rotate(2));
        System.out.println(Direction2.EAST.rotate(-1));
        System.out.println(Direction2.EAST.rotate(-2));
    }
}
