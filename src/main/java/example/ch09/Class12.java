package example.ch09;

/** - Math클래스의 반올림 예제 : round() vs rint() */
public class Class12 {
    public static void main(String[] args){

        double sum = 0;
        double sum1 = 0;
        double sum2 = 0;

        for(double d = 1.5; d <= 10.5; d++ ) { // 1.5에서 10.5까지 1씩 증가.
            double d1 = Math.round(d);
            double d2 = Math.rint(d);

            System.out.printf("%4.1f %4.1f %4.1f%n", d, d1, d2); // 차이점 : round()는 HALF_UP.5 일 때 무조건 올림 <-> rint()는 round even으로 반올림.
                                                                 //         둘 다 반올림이지만 round()는 무조건 올림, rint()는 홀수일때는 짝수로 올림하고, 짝수일때는 소수점을 버린다.

            sum += d;
            sum1 += d1;
            sum2 += d2;
        }

        System.out.println("================");
        System.out.printf("%4.1f %4.1f %4.1f%n", sum, sum1, sum2);
        /** 원래 값(sum)과의 차이점을 확인해보자.
         *  rint()가 더 정확한 값을 도출해냈다. 그 이유는 n.5라는 값을 딱 중간이기때문에 올리기도 애매하고 내리기도 애매하다.
         *  그래서 round()를 사용해서 무조건 올림을 하면 오차가 커진다. 그래서 이 오차를 줄이기 위해 등장한게 round even인 rint() 메서드이다.
         *  rint()는 홀수일때는 짝수로 올림하고, 짝수일때는 소수점을 버리는 방식을 사용해서 오차를 줄일 수 있다.
         */
    }
}
