package example.ch01;

public class Part02_Variable04 {
    public static void main(String[] args){
        char ch = 'A'; //하나의 문자를 '(작은 따옴표)를 사용해 선언 및 초기화.
        System.out.println("character : "+ ch);

        String str1 = "ABC"; //문자열 리터럴 : 하나 이상의 문자, 즉 연속된 문자를 "(큰 따옴표)를 사용해 String 타입 선언 및 초기화.
        String str2 = new String("AB"); //원래 클래스는 new 연산자를 써서 객체를 생성해야 하는데,
                                             //워낙 자주사용하기 때문에 String 클래스만 특별히 기본형 변수에 값을 저장하는 것과 같은 표현을 허용합니다.
        System.out.println("string : "+ str1 + "," + str2);

        String str3 = "A"; //문자가 하나만 있어도 선언 가능.
        String str4 = "";  //빈 문자열 선언 가능. <-> char ch = '';  Error 발생!
        System.out.println("One String : "+ str3 + ", empty String : " + str4);

        String str5 = "A" + "B"; //문자를 합치는 것이 아니라 결합 "AB"
        String str6 = "" + 7; //숫자를 빈 문자열과 결합하면 문자는 문자랑만 결합가능하기 때문에 숫자는 문자로 바뀌고 결합되어 최종적으로 문자 7이 됩니다.
        String str7 = "" + 7 + 7; //문자열 결합은 왼쪽에서 오른쪽으 진행되기 때문에 순서에 따라 전혀 다른 결과가 나올 수도 있습니다.
                                // 왼쪽이 먼저 진행되어 문자 7이 되고
        String str8 = 7 + 7 + ""; //7+7이 먼저 수행되고 숫자 14 + 빈 문자열이 되어 14가 됩니다.
        System.out.println("String + String : "+ str5);
        System.out.println("String + Int : "+ str6);
        System.out.println("String + Int + Int : "+ str7);
        System.out.println("Int + Int + String : "+ str8);

    }
}
