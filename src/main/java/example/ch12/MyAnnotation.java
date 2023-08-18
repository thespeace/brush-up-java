package example.ch12;

import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({FIELD, TYPE, TYPE_USE})    // 적용 대상이 FIELD, TYPE, TYPE_USE.
public @interface MyAnnotation { }  // MyAnnotation을 정의.
