package example.ch17.practice.p10_extends.access;

import example.ch17.practice.p10_extends.access.child.Child;

public class ExtendsAccessMain {
    public static void main(String[] args) {
        Child child = new Child();
        child.call();
    }
}

/**
 *  - 접근 제어와 메모리 구조
 *    1. 본인 타입(child)에서 찾기.
 *    2. 본인 타입에 없으면 부모 타입(parent)에서 찾기.
 *
 *    본인 타입에 없으면 부모 타입에서 기능을 찾는데, 이때 접근 제어자가 영향을 준다. 왜냐하면 객체 내부에서는 자식과 부모가 구분되어 있기 때문이다.
 *    결국 자식 타입에서 부모 타입의 기능을 호출할 때, 부모 입장에서 보면 외부에서 호출한 것과 같다.(내부에서는 분리되어 있기 때문)
 * */