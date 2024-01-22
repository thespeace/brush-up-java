package example.ch17.practice.p11_poly.basic;

public class OverridingChild extends OverridingParent{

    public String value = "child";

    @Override
    public void method() {
        System.out.println("OverridingChild.method");
    }
}
