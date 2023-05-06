package example.ch06;

public class OOP03 {
    public static void main(String[] args){
        /**
         *    - 하나의 소스파일에 여러 클래스 작성
         *      일반적으로는 하나의 소스파일에 하나의 클래스만 작성하는 것이 보통이지만(1:1), 하나의 소스파일에 여러 클래스를 작성할 때의 규칙들.
         *
         *      1) 올바른 작성 예
         *          파일 이름 : Hello2.java / 클래스 이름 : public class Hello2 { }, class Hello3 { }
         *          설명 : public class가 있는 경우, 소스파일의 이름은 반드시 public class의 이름과 일치해야 한다.
         *
         *          파일 이름 : Hello3.java / 클래스 이름 : class Hello2 { }, class Hello3 { }
         *          설명 : public class가 하나도 없는 경우, 소스파일의 이름은 'Hello2.java', 'Hello3.java' 둘 다 가능하다.
         *
         *      2) 잘못된 작성 예
         *          파일 이름 : Hello2.java / 클래스 이름 : public class Hello2 { }, public class Hello3 { }
         *          설명 : 하나의 소스파일에 둘 이상의 public class가 존재하면 안된다. 각 클래스를 별도의 소스파일에 나눠서 저장하던가 아니면 둘 중의 한 클래스에 public을 붙이지 않아야 한다.
         *
         *          파일 이름 : Hello3.java / 클래스 이름 : public class Hello2 { }, class Hello3 { }
         *          설명 : 소스파일의 이름이 public class의 이름과 일치하지 않는다. 소스파일의 이름을 'Hello2.java'로 변경해야 맞다.
         *
         *          파일 이름 : hello2.java / 클래스 이름 : public class Hello2 { }, class Hello3 { }
         *          설명 : 소스파일의 이름과 public class의 이름이 일치하지 않는다. 대소문자를 구분하므로 대소문자까지 일치해야 한다. 그래서, 소스파일의 이름에서 'h'를 'H'로 바꿔야 한다.
         *
         *
         *
         */

    }
}
//public class OOP03_1{ } // 하나의 소스파일에는 하나의 public Class만 허용
class OOP03_2{ } // public 클래스가 없다면 클래스파일의 어떠한 것을 파일 이름으로 작성해도 상관없다.
class oOP03_3{ } // 대소문자를 구분함으로 소스파일의 이름과 클래스파일의 이름이 일치해야 한다.