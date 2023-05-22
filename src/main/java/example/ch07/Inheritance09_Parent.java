package example.ch07;

class Myparent{
    private   int prv; // 같은 클래스 접근 가능.
              int dft;
    protected int prt;
    public    int pub;

    public void printMembers(){
        System.out.println(prv); // OK
        System.out.println(dft); // OK
        System.out.println(prt); // OK
        System.out.println(pub); // OK
    }
}

public class Inheritance09_Parent {
    private   int prv;
              int dft; // 같은 패키지 접근 가능.
    protected int prt; // 같은 패키지 + 자손(다른 패키지) 접근 가능.
    public    int pub; // 접근제한 없음.

    public void printMembers(){
        System.out.println(prv); // OK
        System.out.println(dft); // OK
        System.out.println(prt); // OK
        System.out.println(pub); // OK
    }

    public static void main(String[] args){

        Myparent p2 = new Myparent();
        //System.out.println(p2.prv); // private는 같은 클래스 내에서만 사용 가능하기 때문에 사용 불가.
        System.out.println(p2.dft); // OK
        System.out.println(p2.prt); // OK
        System.out.println(p2.pub); // OK
        p2.printMembers();
    }
}
