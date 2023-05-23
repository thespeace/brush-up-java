package example.ch07;

/**
 *    - 캡슐화와 접근 제어자
 *      Q. 접근 제어자를 사용하는 이유?
 *         외부로부터 데이터를 보호하기 위해서.(캡슐화)
 *         외부에는 불필요한, 내부적으로만 사용되는, 부분을 감추기 위해서.(접근제어자의 범위는 좁을 수록 좋다)
 */

public class Inheritance10 {

    public int hour1;
    public int minute1;
    public int second1;

    /** public 은 접근 제한이 없기 때문에, 멤버 변수에 직접 접근 가능. ex) t.hour = 25;
     *  int 범위는 +-20억으로 범위 안의 수는 어떠한 값을 대입 가능하다. 하지만 위와 같은 변수는 hour은 시간을 뜻하기 때문에 1~23, minute는 1~59, second도 1~59의 숫자만 대입하여 사용할 것이다.
     *  이처럼 범위안의 값들도 해당 변수가 유지가 되어야 하는데, public 접근제어자를 사용하여서 대입연산자를 사용해 직접 접근이 가능하게 해놓는다면, 변수의 범위 이외의 값이 들어가는 것을 막을 수가 없다.
     *  즉! 데이터 보호가 되지 않는 것.
     *  때문에 데이터를 보호하기 위해서 아래와 같이 private 접근 제어자를 사용하여 작성하는 것이 좋다.
     */

    private int hour2;
    private int minute2;
    private int second2; // private를 사용해서 외부의 접근을 막는다. 대신 -

    public int getHour(){ return hour2; } // public 메서드를 통해서 변수에 간접 적으로 접근하게 하는 것이 데이터 보호에 유리하다.(간접 접근 허용)
    public void setHour(int hour2) {
        if ( hour2 < 0 || hour2 > 23) return; // if문으로 값을 보호.
        this.hour2 = hour2;
    }

    public static void main(String[] args){ }
}