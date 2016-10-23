package com.bhargo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bhargo on 23/10/16.
 */
public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        Immutable im = new Immutable(2,list);

        /**
         * The following lines will affect the code if we dont make defensive copies
         * list.add("vvvv");
         im.getList().add(1,"c");
         */
        im.getList().forEach(System.out::println);
    }
}

final class Immutable {
    private int in;
    private List<String> list;

    //its important to make defensive copies of the object references
    public Immutable(int in, List<String> list) {
        this.in = in;
        this.list = new ArrayList<>(list);
    }

    public int getIn() {
        return in;
    }

    //its important to make defensive copies of the object references
    public List<String> getList() {
        return new ArrayList<>(list);
    }
}
