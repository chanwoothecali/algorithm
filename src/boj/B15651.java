package boj;

public class B15651 {

    static int N, M;
    static int[] selected;

    static void input() {
        FastReader reader = new FastReader();
        N = reader.nextInt();
        M = reader.nextInt();
        selected = new int[M + 1];
    }

    //정답은 sb에 append 를 사용하여 출력
    //만약 개행까지 출력하고 싶으면 append('\n')을 추가
    static StringBuilder sb = new StringBuilder();

    static void req_funk(int k) {
        if(k == M+1) {
            for (int i = 1; i <= M; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        }else {
            for (int cand = 1; cand <= N; cand++) {
                selected[k] = cand;
                req_funk(k+1);
                // 0으로 초기화 (없어도 되긴 함)
                selected[k] = 0;
            }
        }
    }

    public static void main(String[] args) {
//        input();

        N = 3;
        M = 4;
        selected = new int[M+1];
        req_funk(1);
        System.out.println(sb.toString());
    }
}
