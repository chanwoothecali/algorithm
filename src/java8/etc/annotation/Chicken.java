package java8.etc.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
/**
 * JAVA 8 부터 도입된 Target 대상
 * AnnotationBasic class에 쓰인 것을 보면 알겠지만 제네릭 타입 파라미터에 사용이 가능하게 만들어준다.
 */
//@Target(ElementType.TYPE_PARAMETER)
/**
 * JAVA 8 부터 도입된 Target 대상
 * 타입 파라미터를 포함해 타입을 사용하는 모든 곳에 선언이 가능하다.
 */
@Target(ElementType.TYPE_USE)
/**
 * 어노테이션을 중복으로 사용 가능하게 해주는 기능
 * -> '중복 사용할 어노테이션'과 '컨테이너 어노테이션'이 필요하다.
 * 컨테이너 어노테이션은 중복 어노테이션보다 사용범위(Target)와 적용범위(Retention)가 같거나 커야한다.
 * 그리고 컨테이너 어노테이션 내에 중복 어노테이션을 배열로 가지고 있어야 함.
 */
@Repeatable(ChickenContainer.class)
public @interface Chicken {
    String value();
}

