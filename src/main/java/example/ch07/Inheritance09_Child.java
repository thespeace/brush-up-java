package example.ch07;

class MyChild extends Inheritance09_Parent{
    public void printMembers(){
        //System.out.println(prv); // Error. 같은 클래스만 접근 가능.
        //System.out.println(dft); // Error. 같은 패키지까지만 접근 가능.
        System.out.println(prt); // OK. 다른 패키지이지만 자손 클래스여서 접근 가능.
        System.out.println(pub); // OK. 접근 제한 없음.
    }
}

//해당 클래스는 다른 패키지에 있다고 가정.
public class Inheritance09_Child {
    public static void main(String[] args){
        Inheritance09_Parent p = new Inheritance09_Parent();
        //System.out.println(p.prv); // Error.
        //System.out.println(p.dft); // Error.
        //System.out.println(p.prt); // Error. 다른패키지여서 에러.
        System.out.println(p.pub); // OK. 접근 제한 없음.
    }
}
