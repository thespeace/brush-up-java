package example.ch10;

import java.util.*;
import java.text.*;

public class Datetime08 {

    /**
     *    - SimpleDateFormat(1/2)
     *      날짜와 시간을 다양한 형식으로 출력할 수 있게 해준다.
     *      {@code
     *          Date today = new Date();
     *          SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); // 년-월-일
     *          String result = df.format(today); // 오늘 날짜를 yyyy-MM-dd형태로 변환하여 반환한다.
     *      }
     *
     *    - SimpleDateFormat의 날짜 패턴 기호들.
     *      기호 |          의 미         | 보기
     *        G |       연대(BC,AD)      | AD
     *        y |           년도         | 2006
     *        M |  월(1~12 또는 1월~12월) | 10 또는 10월, OCT
     *        w |  년의 몇 번째 주(1~53)  | 50
     *        W |   월의 몇 번째 주(1~5)  | 4
     *        D |  년의 몇 번째 일(1~366) | 100
     *        d |  월의 몇 번째 일(1~31)  | 15
     *        F |  월의 몇 번째 요일(1~5)  | 1
     *        E |           요일         | 월
     *
     *
     *    - SimpleDateFormat(2/2)
     *      특정 형식으로 되어 있는 문자열에서 날짜와 시간을 뽑아낼 수도 있다.
     *      {@code
     *          DateFormat df  = new SimpleDateFormat("yyyy년 MM월 dd일"); // Date로 변경
     *          DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");
     *          Date d = df.parse("2015년 11월 23일"); // 문자열을 Date로 변환
     *          String result = df2.format(d); // Date를 문자열로 변환.
     *      }
     *
     *    - SimpleDateFormat의 시간 패턴 기호들.
     *      기호 |          의 미         | 보기
     *        a |        오전/오후(AM,PM)       | PM
     *        H |           시간(0~23)         | 20
     *        k |           시간(1~24)         | 13
     *        K |           시간(0~11)         | 10
     *        h |           시간(1~12)         | 11
     *        m |           분(0~59)           | 35
     *        s |           초(0~59)           | 55
     *        S |       천분의 일초(0~999)       | 253
     *        z | Time zone(General time zone) | GMT+9:00
     *        Z | Time zone(RFC 822 time zone) | +0900
     *        ' | escape문자(특수문자를 표현하는데 사용) | 없음
     */

    public static void main(String[] args) throws ParseException {

        System.out.println("=================Example1=================");
        Date today = new Date();

        SimpleDateFormat sdf1, sdf2, sdf3, sdf4;
        SimpleDateFormat sdf5, sdf6, sdf7, sdf8, sdf9;

        sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        sdf2 = new SimpleDateFormat("''yy년 MMM dd일 E요일");
        sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        sdf4 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");

        sdf5 = new SimpleDateFormat("오늘은 올 해의 D번째 날입니다.");
        sdf6 = new SimpleDateFormat("오늘은 이 달의 d번째 날입니다.");
        sdf7 = new SimpleDateFormat("오늘은 올 해의 w번째 주입니다.");
        sdf8 = new SimpleDateFormat("오늘은 이 달의 W번째 주입니다.");
        sdf9 = new SimpleDateFormat("오늘은 이 달의 F번째 E요일입니다.");

        System.out.println(sdf1.format(today));	// format(Date d)
        System.out.println(sdf2.format(today));
        System.out.println(sdf3.format(today));
        System.out.println(sdf4.format(today));
        System.out.println();
        System.out.println(sdf5.format(today));
        System.out.println(sdf6.format(today));
        System.out.println(sdf7.format(today));
        System.out.println(sdf8.format(today));
        System.out.println(sdf9.format(today));


        System.out.println("\n\n=================Example2=================");
        DateFormat df  = new SimpleDateFormat("yyyy년 MM월 dd일");
        DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");

        Date d = df.parse("2019년 11월 23일"); //문자열을 날짜로 변경.
        System.out.println(df2.format(d)); //날짜를 문자열로 변경하여 출력.

    }
}
