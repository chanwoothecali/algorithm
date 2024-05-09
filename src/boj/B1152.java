package boj;

import java.util.Scanner;

public class B1152 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine().trim();
        int length = text.split(" ").length;
        if (text.isEmpty()) {
            length = 0;
        }
        System.out.println(length);
    }
}
