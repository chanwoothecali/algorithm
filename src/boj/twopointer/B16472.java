package boj.twopointer;

import boj.FastReader;

import java.util.StringTokenizer;

public class B16472 {

    private final FastReader scan = new FastReader();
    // 1 ~ 26
    private int N;
    // 1 ~ 10만 길이
    private char[] words;
    private int[] used = new int[26];

    public void main() {
        input();
        solve();
    }

    private void input() {
        N = scan.nextInt();
        String text = scan.nextLine();

        words = text.toCharArray();
    }

    private void solve() {

        int kind = 0, ans = Integer.MIN_VALUE;
        for (int left = 0, right = 0; right < words.length; right++) {
            if (used[words[right] - 'a'] == 0) {
                kind++;
            }
            used[words[right] - 'a']++;

            while (kind > N) {
                used[words[left] - 'a']--;
                if (used[words[left] - 'a'] == 0) {
                    kind--;
                }
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        B16472 main = new B16472();
        main.main();
    }
}
