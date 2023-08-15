package example.ch12;

/**
 *    - 열거형(enum)
 *      관련된 상수들을 같이 묶어 놓은 것.
 *      Java는 " 타입에 안전한 열거형을 제공(값&타입 체크) ". <-> C언어 열거형 : 값만 체크.
 */

class Card {

    //무늬
    static final int CLOVER = 0;
    static final int HEART = 1;
    static final int DIAMOND = 2;
    static final int SPADE = 3;

    //숫자
    static final int TWO = 0;
    static final int THREE = 1;
    static final int FOUR = 2;

    final int Kind = 0;
    final int num = 0;
}

class EnumCard { //    0       1       2       3
    enum Kind  { CLOVER, HEART, DIAMOND, SPADE } // 열거형 Kimd를 정의
    enum Value { TWO, THREE, FOUR }              // 열거형 Value를 정의

    final Kind  kind = null;    // 타입이 int가 아닌 Kind임에 유의하자.
    final Value value = null;
}

/**
 *    - 열거형의 정의와 사용
 *
 *      {@code - 열거형을 정의하는 방법.
 *          // enum 열거형이름 { 상수명1, 상수명2, ... }
 *          enum Direction { EAST, SOUTH, WEST, NORTH }
 *      }
 *
 *      {@code - 열거형 타입의 변수를 선언하고 사용하는 방법.
 *          class Unit {
 *              int x, y;      // 유닛의 위치
 *              Direction dir; // 열거형 인스턴스 변수를 선언
 *
 *              void init() {
 *                  dir = Direction.EAST; // 유닛의 방향을 EAST로 초기화.
 *              }
 *          }
 *      }
 *
 *      {@code - 열거형 상수의 비교에 ==와 compareTo() 사용 가능.
 *          if(dir == Direction.EAST) {
 *              x++;
 *          } else if(dir > Direction.WEST) { // ERROR, 열거형 상수에 비교연산자 사용불가.
 *              ...
 *          } else if(dir.compareTo(Direction.WEST) > 0) { // compareTo()는 가능.
 *              ///
 *          }
 *      }
 *
 *
 *    - 열거형의 조상 : java.lang.Enum
 *      모든 열거형은 Enum의 자손이며, 아래의 메서드를 상속받는다.
 *
 *          Class<E> getDeclaringClass() : 열거형의 Class객체를 반환.
 *          String name() : 열거형 상수의 이름을 문자열로 반환.
 *          int ordinal() : 열거형 상수가 정의된 순서를 반환(0부터 시작).
 *          T valueOf(Class<T> enumType, String name) : 지정된 열거형에서 name과 일치하는 열거형 상수를 반환.
 *
 *          {@code values(), valueOf()는 컴파일러가 자동으로 추가.
 *              static E[] values()
 *              static E valueOf(String name)
 *
 *              Direction[] dArr = Direction.values();   // 열거형 상수가 가지고 있는 모든 상수를 배열로 반환.
 *              Direction d = Direction.valueOf("WEST"); // 문자열을 가지고 열거형 상수의 이름을 얻을 수 있다.
 *
 *              for(Direction d : dArr) // for(Direction d : Direction.values())
 *                  System.out.println("%s=%d%n", d.name(), d.ordinal());  // 각 열거형 상수의 이름과 순서를 출력.
 *          }
 */

//                0      1     2      3
enum Direction { EAST, SOUTH, WEST, NORTH }

public class Enums01 {
    public static void main(String[] args){
        System.out.println(Card.CLOVER == Card.TWO); // true지만 false이어야 의미상 맞음.(값은 같지만 사용되는 의미(타입)가 다르기 때문.)
//        System.out.println(EnumCard.Kind.CLOVER == EnumCard.Value.TWO); // Compile ERROR! 값은 같지만 타입이 불일치하여 비교 불가.
                                                                        // 이처럼 Java의 열거형은 값&타입 모두 체크하는 장점이 있다.

        //Example.
        System.out.println("\n==============Example1=============");

        //열거형 상수를 얻어보는 3가지 방법.
        Direction d1 = Direction.EAST;                              // 1.열거형타입.상수이름
        Direction d2 = Direction.valueOf("WEST");             // 2.열거형타입.valueOf(문자열)
        Direction d3 = Enum.valueOf(Direction.class, "EAST"); // 3.모든 열거형 최고 조상Enum.valueOf(열거형타입, 문자열)

        System.out.println("d1="+d1);
        System.out.println("d2="+d2);
        System.out.println("d3="+d3);

        //열거형 상수 비교.
        System.out.println("d1==d2 ? "+ (d1==d2)); // false
        System.out.println("d1==d3 ? "+ (d1==d3)); // true
        System.out.println("d1.equals(d3) ? "+ d1.equals(d3)); // equals() 사용 가능, 사실은 열거형 상수는 단순한 기본형 값이 아닌 객체이다.
//		System.out.println("d2 > d3 ? "+ (d1 > d3)); // ERROR, 열거형 상수는 객체이기 때문에 비교 불가.
        System.out.println("d1.compareTo(d3) ? "+ (d1.compareTo(d3))); // compareTo() 사용 가능.
        System.out.println("d1.compareTo(d2) ? "+ (d1.compareTo(d2)));

        switch(d1) {
            case EAST: // Direction.EAST라고 쓸 수 있다.(문법, 열거형 타입X 상수 이름만!)
                System.out.println("The direction is EAST."); break;
            case SOUTH:
                System.out.println("The direction is SOUTH."); break;
            case WEST:
                System.out.println("The direction is WEST."); break;
            case NORTH:
                System.out.println("The direction is NORTH."); break;
            default:
                System.out.println("Invalid direction."); break;
        }

        Direction[] dArr = Direction.values(); // 열거형의 모든 상수를 배열로 반환.

        for(Direction d : dArr)  // for(Direction d : Direction.values())
            System.out.printf("%s=%d%n", d.name(), d.ordinal()); // 이름과 순서(값과 무관) 출력.
    }
}
열거형 기초
