package example.ch07;

/**
 *    - 추상클래스의 작성
 *      여러 클래스에 공통적으로 사용될 수 있는 추상클래스를 바로 작성하거나 기존 클래스의 공통 부분을 뽑아서 추상클래스를 만든다.
 *
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
