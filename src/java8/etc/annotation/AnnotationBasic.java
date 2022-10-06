package java8.etc.annotation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Chicken("닭")
@Chicken("오골계")
public class AnnotationBasic {

    public static void main(@Chicken("닭") String[] args) throws @Chicken("닭") RuntimeException {
        List<@Chicken("닭") String> names = new ArrayList<>();

        /**
         * 중복 어노테이션 사용 방법
         */
        Chicken[] chickens = AnnotationBasic.class.getAnnotationsByType(Chicken.class);
        Arrays.stream(chickens).forEach(c -> {
            System.out.println("c = " + c);
        });

        ChickenContainer chickenContainer = AnnotationBasic.class.getAnnotation(ChickenContainer.class);
        Arrays.stream(chickenContainer.value()).forEach(c -> {
            System.out.println("c = " + c);
        });
    }

    static class FeelsLikeChicken<@Chicken("닭") T> {

        /**
         * void 앞에 나오는 C가 타입 파라미터, 매개변수에 있는 C는 타입
         * @Target(ElementType.TYPE_PARAMETER)는 타입파라미터만 가능하고 매개변수에는 쓸 수 없다.
         * @Target(ElementType.TYPE_USE)는 둘 다 사용 가능하게 해준다.
         */
        public static <@Chicken("닭") C> void print(@Chicken("닭") C c) {

        }
    }
}
