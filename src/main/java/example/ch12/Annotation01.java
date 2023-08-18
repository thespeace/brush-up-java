package example.ch12;

public class Annotation01 {
    public static void main(String[] args){
        /**
         *    - javaDoc?
         *      예전에는 소스코드(*.java)를 작성하면 그 프로그램에 대한 문서를 따로 작성을 했다.
         *      따라서 소스코드를 변경하면 문서도 변경을 해야했다. 하지만 ASAP로 소스코드를 변경하는 둥 문서 업데이트에 신경을 쓰지 못하면 "버전 불일치가 발생"했다.
         *      떼문에 관리를 쉽게 하기 위해서 문서와 소스코드를 합치기로 한 것. - JavaDoc 사용.
         *      javaDoc.exe로 문서로 추출 가능.
         *
         *
         *    - 애너테이션(Annotation) 이란?
         *      javaDoc처럼 프로그래밍 언어에 영향을 미치지 않으며, 특정 프로그램에게 유용한 정보를 제공.
         *          + 프로그램의 소스코드(*.java)의 설정파일(*.xml)도 따로 분리되어 있다보니 버전 일치에 어려움이 생겼다.
         *            때문에 javaDoc과 마찬가지로 합치기로 한 것. - Annotation.
         *            또한 xml파일을 많은 사람들이 공유해야 하기 때문에 업데이트 등등 많은 문제점이 생겼다.
         *            @설정에대한정보 이처럼 설정에 대한 정보를 넣기로 한 것.
         *            기존 문법을 바꾸지 않아도 되고, 다른 프로그램에 영향을 미치지 않고 JUnit이라는 특정 프로그램을 위한 것(정보제공 :설정정보).
         *            javaDoc 그 자체는 애너테이션이 아니지만 유용한 정보를 제공한다는 개념에서는 애너테이션과 똑같은 것.
         *            @see docs.oracle.com/javase/8/docs/api/java/lang/annotation/Annotation.html
         *
         *
         *    - 애너테이션(Annotation)의 사용예.
         *      {@code
         *          @Test // 이 메서드가 테스트 대상임을 테스트 프로그램에게 알린다.
         *          public void method() {
         *              ...
         *          }
         *          // JUnit이라는 단위 테스트 프로그램을 통해 테스트를 할 수 있는데, 테스트 대상과 아닌 대상을 구별하기 위해 @Test 애너테이션을 사용한다.(프로그램에게 정보제공)
         *      }
         */
    }
}
