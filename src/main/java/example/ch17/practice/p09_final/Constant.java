package example.ch17.practice.p09_final;

// 상수, 상수는 기능이 아니라 고정된 값 자체를 사용하는 것이 목적이다. 그래서 변경할 수 없다.
public class Constant {
    //수학 상수
    public static final double PI = 3.14;

    //시간 상수
    public static final int HOURS_IN_DAY = 24;
    public static final int MINUTES_IN_HOUR = 60;
    public static final int SECONDS_IN_MINUTE = 60;

    //애플리케이션 설정 상수
    public static final int MAX_USERS = 1000;
}

/**
 *  보통 이런 상수들은 애플리케이션 전반에서 사용되기 때문에 public을 자주 사용한다. 물론 특정 위치에서만 사용된다면 다른 접근 제어자를 사용하면 된다.
 *  상수는 중앙에서 값을 하나로 관리할 수 있다는 장점도 있다.
 *  상수는 런타임에 변경할 수 없다. 상수를 변경하려면 프로그램을 종료하고, 코드를 변경한 다음에 프로그램을 다시 실행해야 한다.
 * */
