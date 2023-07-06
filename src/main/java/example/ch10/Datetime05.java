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
     *          date.add(Calendar.DATE, 1); // 날짜(DATE)에 1을 더한다.
     *          date.add(Calendar.MONTH, -8); // 월(MONTH)에서 8을 뺀다.
     *      }
     */

    public static void main(String[] args){
        System.out.println("Hello, World!");
    }
}
