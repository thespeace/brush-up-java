package example.ch10;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Datetime01 {
    public static void main(String[] args){
        /**
         *    - 날짜와 시간
         *      해당 타입은 문자열만큼이나 중요한 타입.
         *
         *      java.util.Date
         *          날짜와 시간을 다룰 목적으로 만들어진 클래스(JDK1.0, 1995년)
         *          Date의 메서드는 거의 deprecated(앞으로 사용 X)되었지만, 여전히 쓰이고 있다.
         *
         *      java.util.Calendar
         *          Date클래스를 개선한 새로운 클래스(JDK1.1, 1997년). 여전히 단점이 존재(날짜와 시간을 같이 다뤄야만 했다.)
         *          하지만 17년이라는 긴 시간동안 사용되어지다보니 현재 실무에서도 쓰이고 있는 곳이 많다.
         *
         *      ** java.Time 패키지 **
         *          Date와 Calendar의 단점을 개선한 새로운 클래스들을 제공(JDK1.8, 2014년).
         *          날짜와 시간을 분리하여 다룰 수 있게 되어 LocalDate로는 날짜를 LocalTime으로는 시간을 LocalDateTime으로는 날짜와 시간을 다룰 수 있게 되었다.
         *
         *
         *    - Calendar 클래스
         *      추상 클래스이므로 객체를 생성할 수 없기에, getInstance()를 통해 구현된 객체를 얻어야 한다.
         *      {@code
         *          Calendar cal = new Calendar(); // Error, 추상클래스는 인스턴스를 생성할 수 없다.
         *
         *          Calendar cal = Calendar.getInstance(); // OK, getInstance() 메서드는 Calendar클래스를 구현한 클래스의 인스턴스를 반환한다.
         *      }
         */

        // Calendar cal = new GregorianCalendar(); 이처럼 서양력으로 캘린더를 지정해줄 수도 있지만, 경우에 따라 해당 코드를 변경해야 할 수 있다.
        // 때문에 메서드를 통해서 상황에 맞는 객체를 반환하도록 하는게 더 좋은 코드이고, 이걸 추상화라고 한다.

        Calendar today = Calendar.getInstance(); // Calendar객체를 생성하여, 현재 날짜와 시간으로 셋팅.
        // 해당 메서드가 사용자의 시스템에 있는 정보를 읽어와서 어떤 캘린더를 사용하는지 판단(서양력/불교력/일본력)하여 객체를 반환해준다.


        //get()으로 날짜와 시간 필드 가져오기 - int get(int field)
        System.out.println("이 해의 년도 : " + today.get(Calendar.YEAR)); // 올해가 몇년도인지 알아낸다.
        System.out.println("월(0~11, 0:1월) : " + today.get(Calendar.MONTH)); // 올해가 몇월인지 알아낸다.(0부터 시작, 따라서 1월은 0)
        System.out.println("이 해의 몇 째 주 : " + today.get(Calendar.WEEK_OF_YEAR)); // 1월 1일부터 지금까지 몇주가 지난지 알아낼 수 있다.
        System.out.println("이 달의 몇 째 주 : " + today.get(Calendar.WEEK_OF_MONTH)); // 이번달의 몇번째 주인지 알아낸다.

        // DATE와 DAY_OF_MONTH는 같다.
        System.out.println("이 달의 몇 일 : " + today.get(Calendar.DATE)); // 이번달의 몇일인지 알아낸다.
        System.out.println("이 달의 몇 일 : " + today.get(Calendar.DAY_OF_MONTH)); // 이번달의 몇일인지 알아낸다.
        System.out.println("이 해의 몇 일 : " + today.get(Calendar.DAY_OF_YEAR)); // 1월 1일부터 몇일이 지났는지 알아낸다.
        System.out.println("요일(1~7, 1:일요일) : " + today.get(Calendar.DAY_OF_WEEK)); // 오늘은 무슨 요일인지 알아낸다. 1 : 일요일, 2:월요일, ... 7:토요일.
        System.out.println("이 달의 몇 째 요일 : " + today.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println("오전_오후(0:오전, 1:오후) : " + today.get(Calendar.AM_PM));
        System.out.println("시간(0~11) : " + today.get(Calendar.HOUR));
        System.out.println("시간(0~23) : " + today.get(Calendar.HOUR_OF_DAY));
        System.out.println("분(0~59) : " + today.get(Calendar.MINUTE));
        System.out.println("초(0~59) : " + today.get(Calendar.SECOND));
        System.out.println("1000분의 1초(0~999) : " + today.get(Calendar.MILLISECOND)); //천분의 1초를 시간으로 표시하기 위해 3600000으로 나누었다.(1시간 = 60 * 60초)
        System.out.println("TimeZone(-12 ~ +12) : " + (today.get(Calendar.ZONE_OFFSET)/(60*60*1000))); // 한국은 GMT보다 9시간 빠르다. +9
        System.out.println("이 달의 마지막 날짜 : " + today.getActualMaximum(Calendar.DATE)); //이 달의 마지막 일을 알아 낸다.

        //만일 다른날자로 변경하고 싶으면 Set()으로 필드값을 변경할 수 있다. Datetime02.java에서 알아보자.
    }
}
