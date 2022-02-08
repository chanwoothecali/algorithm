package boj;

import java.util.*;

public class B1181 {

    static FastReader scan = new FastReader();
    static int N;
    static String[] alphabets;

    static void input() {
        // 단어의 개수 N
        N = scan.nextInt();
        // 크기가 N인 배열을 생성 후 단어 저장
        alphabets = new String[N];
        for (int i = 0; i < N; i++) {
            alphabets[i] = scan.nextLine();
        }
    }

    static void solve() {
        // 익명 인터페이스를 이용한 정렬 조건 반영
        // 1. 길이가 짧은 것부터
        // 2. 길이가 같으면 사전 순으로
        Arrays.sort(alphabets, (o1, o2) -> {
            if(o1.length() == o2.length()) return o1.compareTo(o2);
            return o1.length() - o2.length();
        });

        // stream을 이용한 중복 제거
        String[] strings = Arrays.stream(alphabets).distinct().toArray(String[]::new);
        // 정답 출력
        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
