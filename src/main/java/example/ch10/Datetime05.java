package example.ch10;

import java.util.Calendar;

public class Datetime05 {

    /**
     *    - add()는 특정 필드의 값을 증가 또는 감소시킨다.(다른 필드에 영향 O)
     *      {@code
     *          Calendar date = Calendar.getInstance();
     *          date.claer(); // 모든 필드를 초기화
     *          date.set(2020, 7, 31); // 2020년 8월 31일로 설정
     *
     *          date.add(Calendar.DATE, 1); // 증가, 날짜(DATE)에 1을 더한다. -> 9월 1일로 설정(다른 필드에 영향을 미친다.)
     *          date.add(Calendar.MONTH, -8); // 감소, 월(MONTH)에서 8을 뺀다.
     *      }
     *
     *    - roll()은 특정 필드의 값을 증가 또는 감소시킨다.(다른 필드에 영향 X)
     *      {@code
     *          date.set(2020, 7, 31); // 2020년 8월 31일로 설정
     *          // add()와 달리 roll()은 다른 필드에 영향을 미치지 않는다.
     *          date.roll(Calendar.DATE, 1);   // 날짜(DATE)에 1을 더한다. -> 8월 1일로 설정(다른 필드에 영향을 미치지 않는다.)
     *          date.roll(Calendar.MONTH, -8); // 월(MONTH)에서 8을 뺀다.
     *      }
     */
    public static void main(String[] args){

        //예제 1) add(), roll()
        Calendar date = Calendar.getInstance();
        date.set(2019, 7, 31); // 2019년 8월 31일

        System.out.println(toString(date));
        date.add(Calendar.DATE, 1);
        System.out.println("1일 후 : " + toString(date));

        date.add(Calendar.MONTH, -6);
        System.out.println("6달 전 : " + toString(date));

        //add()와 달리 roll()은 다른 필드에 영향을 주지 않는다.
        date.roll(Calendar.DATE, 31);
        System.out.println("31일 후(roll) : " + toString(date));

        date.add(Calendar.DATE, 31);
        System.out.println("31일 후(add) : " + toString(date));


        /**
         *    예제 2) 달력 찍기.
         *           1. 말일 구하기 (다음달 1일 -1)
         *           2. 1일의 요일 구하기.
         */
        int year = 2019;
        int month = 9;
        int START_DAY_OF_WEEK = 0;
        int END_DAY = 0;

        Calendar sDay = Calendar.getInstance(); //시작일
        Calendar eDay = Calendar.getInstance(); //끝일

        //월의 경우 0부터 11까지의 값을 가지므로 1을 빼주어야 한다.
        //예를 들어, 2019년 11월 1일은 sDay.set(2019, 10, 1);과 같이 해줘야 한다.
        sDay.set(year, 8, 1); // 2019.9.1
        eDay.set(year, 9, 1); // 2019.10.1

        //다음달의 첫날(12월 1일)에서 하루를 빼면 현재달의 마지막 날(11월 30일)이 된다.
        eDay.add(Calendar.DATE, -1); // 2019.9.30

        //첫 번째 요일이 무슨 요일인지 알아낸다. 1일이 무슨 요일인지 알아낸다.
        START_DAY_OF_WEEK = sDay.get(Calendar.DAY_OF_WEEK);

        //eDay에 지정한 날짜를 얻어온다.
        END_DAY = eDay.get(Calendar.DATE);

        System.out.println("      " + year +"년 " + month +"월");
        System.out.println(" SU MO TU WE TH FR SA");

        // 해당 월의 1일이 어느 요일인지에 따라서 공백을 출력한다.
        // 만일 1일이 수요일이라면 공백을 세 번 찍는다.(일요일부터 시작)
        for(int i=1; i < START_DAY_OF_WEEK; i++)
            System.out.print("   ");

        for(int i=1, n=START_DAY_OF_WEEK ; i <= END_DAY; i++, n++) {
            System.out.print((i < 10)? "  "+i : " "+i );
            if(n%7==0) System.out.println(); // 토요일이 될 때마다 줄바꿈.
        }
    }
    public static String toString(Calendar date) {
        return date.get(Calendar.YEAR)+"년 "+(date.get(Calendar.MONTH) +1)+"월 "+date.get(Calendar.DATE)+"일 ";
    }
}
