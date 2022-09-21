package java8.lambda;

public class MethodReferenceClass {

    private String name;

    public MethodReferenceClass() {
    }

    public MethodReferenceClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String hello(String name) {
        return "hello " + name;
    }

    public static String hi(String name) {
        return "hi " + name;
    }
}
