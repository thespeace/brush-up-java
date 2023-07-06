package example.ch10;

import java.util.Calendar;

public class Datetime04 {
    /**
     *    - clear()는 Calendar 객체의 모든 필드를 초기화.
     *      {@code
     *          Calendar dt = Calendar.getInstance();
     *
     *          // Tue Aug 29 07:13:03 KST 2017
     *          System.out.println(new Date(dt.getTimeInMillis()));
     *
     *          dt.clear(); // 모든 필드를 초기화
     *          // Thu Jan 01 00:00:00 KST 1970 - Epoch Time.
     *          System.out.println(new Date(dt.getTimeInMillis()));
     *      }
     *
     *      claer(int field)는 Calendar 객체의 특정 필드를 초기화.
     *      {@code
     *          Calendar dt = Calendar.getInstance();
     *
     *          // Tue Aug 29 07:13:03 KST 2017
     *          System.out.println(new Date(dt.getTimeInMillis()));
     *
     *          dt.clear(Calendar.SECOND);      // 초를 초기화
     *          dt.clear(Calendar.MINUTE);      // 분을 초기화
     *          dt.clear(Calendar.HOUR_OF_DAY); // 시간을 초기화
     *          dt.clear(Calendar.HOUR);        // 시간을 초기화
     *
     *          // Tue Aug 29 00:00:00 KST 2017
     *          System.out.println(new Date(dt.getTimeInMillis()));
     *      }
     */

    //예제 3) 메서드 활용해 날짜 일 수 차이 구하기.
    static int getDayDiff(String yyyymmdd1, String yyyymmdd2) {
        int diff = 0;
        try {
            int year1 = Integer.parseInt(yyyymmdd1.substring(0, 4));
            int month1 = Integer.parseInt(yyyymmdd1.substring(4, 6)) - 1;
            int day1 = Integer.parseInt(yyyymmdd1.substring(6, 8));
            int year2 = Integer.parseInt(yyyymmdd2.substring(0, 4));
            int month2 = Integer.parseInt(yyyymmdd2.substring(4, 6)) - 1;
            int day2 = Integer.parseInt(yyyymmdd2.substring(6, 8));
            Calendar date1 = Calendar.getInstance();
            Calendar date2 = Calendar.getInstance(); // date1 과 date2 사이의 ms 차이가 발생. 때문에 아주 작은 오차가 발생.
            date1.clear(); // 위와 같은 이유때문에 초기화를 진행. <-> 만약 초기화를 해주지 않는다면, 원하는 정수를 얻지 못한다.
            date2.clear();
            date1.set(year1, month1, day1);
            date2.set(year2, month2, day2);
            //System.out.println(((date1.getTimeInMillis() - date2.getTimeInMillis()) / (24 * 60 * 60 * 1000f))); 초기화 하지 않으면 약간의 오차 발생.
            diff = (int) ((date1.getTimeInMillis() - date2.getTimeInMillis()) / (24 * 60 * 60 * 1000));
        } catch (Exception e){
            diff = 0; // substring(), parseInt()에서 예외가 발생하면 0을 반환한다.
        }
        return diff;
    }
    public static void main(String[] args){
        System.out.println(getDayDiff("20010103", "20010101"));
        System.out.println(getDayDiff("20010103", "20010103"));
        System.out.println(getDayDiff("20010103", "200103"));
    }
}
