package java8.changedInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class InterfaceBasic {

    public static void main(String[] args) {
        ParentInterfaceImpl parentInterface = new ParentInterfaceImpl("chanwoo");
        parentInterface.printName();
        parentInterface.printUppercaseName();

        ChildInterfaceImpl childInterface = new ChildInterfaceImpl();
        childInterface.printUppercaseName();

        ParentInterface.printAnything();
    }
}
