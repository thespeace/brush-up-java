package example.ch09;

public class Class03 {
    public static void main(String[] args){
        /**
         *    - String 클래스
         *      " 데이터(char[]) + 메서드(문자열 관련) "
         *      내용을 변경할 수 없는 불변(immutable) 클래스
         *          ex) String a = "a";
         *              String b = "b";
         *              a = a + b;       덧셈 연산자(+)를 이용한 문자열 결합은 성능이 떨어진다.
         *                               why? 문자열은 내용을 변경할 수 없기 때문에.
         *                                    위의 예시 처럼 문자열 결합으로 생성된 "새로운 문자열은 새로운 객체 주소값"을 가지게 되고, 대입 연산자에 의해 결합된 문자열이 들어가는 변수 a값의 주소값이 변경되게 된다.
         *                                    때문에 문자열 결합이나 변경이 잦다면, 내용을 변경가능한 StringBuffer를 사용
         *
         *    - 문자열의 비교
         *      String str = "abc";(문자열 리터럴)와 String str = new String("abc");(new 연산자)의 비교.
         *      ex) String str1 = "abc"; // 문자열 리터럴 "abc"의 주소가 str1에 저장됨
         *          String str2 = "abc"; // 문자열 리터럴 "abc"의 주소가 str2에 저장됨
         *          String str3 = new String("abc"); // 새로운 String 인스턴스를 생성
         *          String str4 = new String("abc"); // 새로운 String 인스턴스를 생성
         *
         *          문자열 리터럴로 생성된 str1, str2의 참조 변수는 하나의 값(하나의 주소값)을 서로 공유를 한다.
         *          str1(0x100) == str2(0x100), true
         *
         *          new연산자로 생성된 str3, str4 변수는 항상 새로운 문자열이 만들어져, 각자 다른 주소값을 가진다.
         *          str3(0x200) == str4(0x300), false
         *
         *          문자열은 내용이 변경 불가이기 때문에, 어차피 내용을 변경 불가하기 때문에 하나의 주소값을 여러 참조변수가 공유하여도 문제가 없다.
         *          특별한 경우를 제외하고는 new 연산자로 객체를 생성하는 것보다 리터럴을 사용하는 것이 효율적이다.
         *
         *          그리고 같고 다름을 비교할때는 대입연산자(주소 비교)말고 equals() 메소드를 사용해야 값 비교가 가능하다.
         *          str1.equals(str2) ? true  /  str3.equals(str4) ? true
         *
         *    - 문자열 리터럴
         *      문자열 리터럴은 프로그램 실행시 자동으로 생성된다.(new연산자 자동 사용, constant pool에 저장)
         *      같은 내용의 문자열 리터럴(상수)은 하나의 주소값에 만들어진다.
         *      String str1 = ""; String str2 = ""; String str3 = ""; // 하나의 빈 문자열 객체 한개로 다 공유하여 사용하니 new 연산자 보다는 리터럴을 사용!
         *
         *    - 빈 문자열("", empty string)
         *      내용이 없는 문자열, 크기가 0인 char형 배열을 저장하는 문자열.
         *          ex) String str = ""; // str을 빈 문자열로 초기화
         *      크기가 0인 배열을 생성하는 것은 어느 타입이나 가능.
         *          ex) char[] chArr = new char[0]; // 길이가 0인 char배열
         *              int[]  iArr = {};           // 길이가 0인 int배열
         *      왜 사용하는가?
         *          1. 숫자를 문자로 바꿀 때 ex) "" + 5 -> "5"
         *          2. 배열 초기화할 때 null로 하는 것보다 빈 문자열로 하는게 더 유용.
         *      문자(char)와 문자열(String)의 초기화
         *          ex) String s = "";// 빈 문자열로 초기화  -> 잘못된 사용법 : String s = null;
         *              char c = ' '; // 공백으로 초기화     -> 잘못된 사용법 : char c = '\u0000'; // 유니코드 첫번째 문자.
         */
    }
}
