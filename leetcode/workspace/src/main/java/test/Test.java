package test;

import java.time.LocalDateTime;

public class Test {
    public static void main(String[] args) {
        String str = "3+4i";
        String[] strs = str.split("\\+|i");
        System.out.println(strs[0]);
    }
}
