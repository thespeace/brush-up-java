package example.ch07;

/**
 *    - 추상 클래스의 작성 1.
 *      여러 클래스에 공통적으로 사용될 수 있는 추상클래스를 바로 작성하거나 기존 클래스의 공통 부분을 뽑아서 추상클래스를 만든다.
 */


//기존 클래스들의 공통부분을 뽑아서 추상클래스를 만드는 예.
/*class Marine{
    int x, y;
    void move(int x, int y) { *//* 지정된 위치로 이동 *//*}
    void stop()             { *//* 현재 위치에 정지 *//*  }
    void stimPack()         { *//* 스팀팩을 사용한다. *//*}
}
class Tank{
    int x, y;
    void move(int x, int y) { *//* 지정된 위치로 이동 *//*}
    void stop()             { *//* 현재 위치에 정지 *//*  }
    void changeMode()       { *//* 공격모드를 변환한다.*//*}
}
class Dropship{
    int x, y;
    void move(int x, int y) { *//* 지정된 위치로 이동 *//*}
    void stop()             { *//* 현재 위치에 정지 *//*  }
    void load()             { *//* 선택된 대상을 태운다*//*}
    void unload()           { *//* 선택된 대상을 내린다*//*}
}*/

// 공통 부분의 선언부만 뽑아내서 추상클래스 작성 ->

abstract class Unit{ // 공통 부분 추출, Unit 클래스로 정의
    int x, y;
    abstract void move(int x, int y);
    void stop(){ /* 현재 위치에 정지 */  }
}
class Marine extends Unit{ //보병
    void move(int x, int y) { /* 지정된 위치로 이동 */ System.out.println("Marine[x=" + x + ",y=" + y + "]");}
    void stimPack()         { /* 스팀팩을 사용한다. */}
}
class Tank extends Unit{ //탱크
    void move(int x, int y) { /* 지정된 위치로 이동 */ System.out.println("Tank[x=" + x + ",y=" + y + "]");}
    void changeMode()       { /* 공격모드를 변환한다.*/}
}
class Dropship extends Unit{ //수송선
    void move(int x, int y) { /* 지정된 위치로 이동 */ System.out.println("Dropship[x=" + x + ",y=" + y + "]");}
    void load()             { /* 선택된 대상을 태운다*/}
    void unload()           { /* 선택된 대상을 내린다*/}
}
// 코드의 중복을 제거함으로써 가독성이 향상되고 간결해졌다.(객체지향 언어의 장점)



public class Inheritance17 {
    public static void main(String[] args){

        /*Unit[] group = new Unit[3]; // 다형성, 하나의 배열에 여러 객체 그룹화 및 사용.
        group[0] = new Marine();
        group[1] = new Tank();
        group[2] = new Dropship();*/

        // 위 선언 및 초기화식과 같은 이치.
        Unit[] group = { new Marine(), new Tank(), new Dropship() }; // 객체 배열.

        for(int i=0; i<group.length; i++)
            group[i].move(100,200);

    }
}


/**
 *    - 추상 클래스의 장점.
 *      1. 미완성 설계도(추상클래스) : 자손클래스들이 부모의 설계도를 보고 완성된 설계도를 작성하기에 코드 작성이 수월, 새로운 객체 생성은 상속을 받으면 코드 작성이 쉬워진다.
 *      2. 추상클래스의 객체를 상속받기 때문에 중복을 제거하여 코드가 간결해지고, 관리(유지보수)가 용이해 진다.
 *      3. 추상클래스를 의미있는 단게별(조상 - 자손)로 상속하면서 구체적인 코드작성을 하면, 의미있는 단계에서 코드 변경이나 유지보수가 간편해진다.
 *      4.추상화 <-> 구체화 : 때로는 불명확한 것이 유리할 때가 있다. 즉 추상화된 코드는 구체화된 코드보다 유연하다. 변경에 유리.
 *          ex) GregorianCalendar cal = new GregorianCalendar(); // 구체적, 객체 생성.
 *              Calendar cal = Calendar.getInstance(); // 추상적, calendar의 자손 객체를 반환. 추상 클래스인 Calendar을 사용하여,
 *                                                               캘린더 타입(불교력,일본력,서양력)에 맞는 객체를 생성하여 반환 받을 수 있다.
 *
 *              "이처럼 구체적인 코드보다 추상적인 코드를 사용하면 보다 유연하고 변경에 유리한 코드를 작성할 수 있다"
 *              "추상화는 다형성과 관계가 깊다."
 */
