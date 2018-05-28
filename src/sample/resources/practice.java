package sample.resources;

import sample.functions;

import java.util.Arrays;

public class practice {

    static public void main(String[] args) {
        String[] v = new String[]{"a","b","c"};
        String[] b = new String[]{"d","e","f"};
        v = functions.extend(v, b);
        System.out.println(Arrays.toString(v));
    }
}
