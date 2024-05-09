package boj;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B3052 {

    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            int anInt = scanner.nextInt();
            set.add(anInt % 42);
        }
        System.out.println(set.size());
    }
}
