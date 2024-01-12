package example.ch17.practice.p06_access.b;

import example.ch17.practice.p06_access.a.AccessData;

public class AccessOuterMain {
    public static void main(String[] args) {
        AccessData data = new AccessData();

        //public 호출 가능
        data.publicField = 1;
        data.publicMethod();

        //다른 패키지 default 호출 불가
//        data.defaultField = 2;
//        data.defaultMethod();

        //private 호출 불가
//        data.privateFiled = 3;
//        data.privateMethod();

        data.innerAccess();
    }
}
