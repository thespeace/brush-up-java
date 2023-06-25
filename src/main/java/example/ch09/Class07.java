package example.ch09;

public class Class07 {
    public static void main(String[] args){
        /**
         *    - join()과 StringJoiner
         */

        //join() : 여러 문자열 사이에 구분자를 넣어서 결합한다.
        String animals = "dog,cat,bear";
        String[] arr = animals.split(","); // 문자열을 ','를 구분자로 나눠서 배열에 저장
        String str = String.join("-",arr); // 배열의 문자열을 '-'로 구분해서 결합
        System.out.println(str);

        /**
         *    - 문자열과 기본형 간의 변환
         *
         *      boolean -> String   : String.valueOf(boolean b)
         *      char -> String      : String.valueOf(char c)
         *      int -> String       : String.valueOf(int i)
         *      long -> String      : String.valueOf(long l)
         *      float -> String     : String.valueOf(float f)
         *      double -> String    : String.valueOf(double d)
         *
         *      * byte, short를 문자열로 변경할 때는 String valueOf(int i)를 사용하면 된다.
         */

        //숫자를 문자열로 바꾸는 방법
        int i = 100;
        String str1 = i +"";            // 편리하다.
        String str2 = String.valueOf(i);// 속도가 빠르다.

        //문자열을 숫자로 바꾸는 방법
        int i1 = Integer.parseInt("100"); // "100"을 100으로 변환하는 방법1(예전 방법)
        int i2 = Integer.valueOf("100");  // "100"을 100으로 변환하는 방법2(새로운 방법)
        Integer i3 = Integer.valueOf("100"); // 큰 차이는 없지만 valueOf()는 원래는 반환 타입이 Integer.
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);

        //예제
        int iVal = 100;
        //String strVal = String.valueOf(iVal);
        String strVal = iVal + "";// int를 String으로 변환한다.

        double dVal = 200.0;
        String strVal2 = String.valueOf(dVal); // double을 String으로 변환.

        double sum = Integer.parseInt("+"+strVal)
                                            +Double.parseDouble(strVal2); // 예전 방식.
        double sum2 = Integer.valueOf(strVal) + Double.valueOf(strVal2); // 새로운 방식.
        System.out.println(String.join("",strVal,"+",strVal2,"=")+sum);
        System.out.println(strVal+"+"+strVal2+"="+sum2);
    }
}
