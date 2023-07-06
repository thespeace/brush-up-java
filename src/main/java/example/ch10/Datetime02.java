package example.ch10;

import java.util.Calendar;

public class Datetime02 {
    public static void main(String[] args){
        /**
         *    - set() 메서드를 이용해서 원하는 날짜와 시간 지정하기.
         *
         *      {@code 제공 되는 메서드.
         *          void set(int field, int value)
         *          void set(int year, int month, int date)
         *          void set(int year, int month, int date, int hourOfDay, int minute)
         *          void set(int year, int month, int date, int hourOfDay, int minute, int second)
         *      }
         *
         *      날짜 지정할 때, 월(MONTH)이 0부터 시작한다는 점에 주의.
         *      {@code
         *          Calendar date1 = Calendar.getInstance();
         *          date1.set(2017, 7, 15); // 2017년 8월 15일(7월 아님)
         *          //date1.set(Calendar.YEAR, 2017);
         *          //date1.set(Calendar.MONTH, 7);
         *          //date1.set(Calendar.DATE, 15);
         *      }
         *
         *      시간 지정 하는 방법.
         *      {@code
         *          Calendar Time1 = Calendar.getInstance();
         *          time1.set(Calendar.HOUR_OF_DAY, 10); // time1을 10시 20분 30초로 설정.
         *          time1.set(Calendar.MINUTE, 20);
         *          time1.set(Calendar.SECOND, 30);
         *      }
         */

        //예제 1

        //요일은 1부터 시작하기 때문에, DAY_OF_WEEK[0]을 비워두었다.
        final String[] DAY_OF_WEEK = {"","일","월","화","수","목","금","토"};

        Calendar date1 = Calendar.getInstance();
        Calendar date2 = Calendar.getInstance();

        //month의 경우 0부터 시작하기 때문에 4월인 경우, 3으로 지정해야 한다.
        //date1.set(2019, Calendar.APRIL, 29); 와 같이 할 수도 있다.
        date1.set(2019, 3, 29); //2019년 4월 29일로 날짜를 설정한다.
        System.out.println("date1은 " + toString(date1) + "월"+"요일이고,");
        System.out.println("오늘(date2)은 " + toString(date2) + DAY_OF_WEEK[date2.get(Calendar.DAY_OF_WEEK)] + "요일입니다.");

        //두 날짜간의 차이를 얻으려면, getTimeInMillis() 천분의 일초 단위로 변환해야 한다.
        long difference =  (date2.getTimeInMillis() - date1.getTimeInMillis())/1000;
        System.out.println("그 날(date1)부터 지금(date2)까지 " + difference + "초가 지났습니다.");
        System.out.println("일(day)로 계산하면 " + difference/(24*60*60) + "일 입니다."); // 1일 = 24 * 60 * 60

    }

    public static String toString(Calendar date) {
        return date.get(Calendar.YEAR)+"년 "+(date.get(Calendar.MONTH) +1)+"월 "+date.get(Calendar.DATE)+"일 ";
    }

}
