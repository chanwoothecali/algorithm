package java8.changedInterface;

public class ParentInterfaceImpl implements ParentInterface {

    public ParentInterfaceImpl(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public void printName() {
        System.out.println(this.getName());
    }

    @Override
    public String getName() {
        return this.name;
    }
}
