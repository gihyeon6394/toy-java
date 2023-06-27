package generics;

import java.util.ArrayList;
import java.util.List;

public class Foo6 {

    public static void main(String[] args) {

        List<Parent> parentList = new ArrayList<>();
        List<Child> childList = new ArrayList<>();

        // parentList = childList; // java: incompatible types: java.util.List<generics.Foo.Child> cannot be converted to java.util.List<generics.Foo.Parent>

        List<? extends Parent> parents = new ArrayList<>();
        List<? extends Child> childs = new ArrayList<>();

        parents = childs; // enable
    }

    private static class Parent {

    }

    private static class Child extends Parent {

    }
}
