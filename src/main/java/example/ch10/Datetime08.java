package example.ch10;

import example.ch07.D;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
     */

    /**
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
     *        a |      오전/오후(AM,PM)   | AD
     *        ...
     */
    public static void main(String[] args) throws ParseException {
        System.out.println("Hello, world!");
    }
}
