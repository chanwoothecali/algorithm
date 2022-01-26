package boj;

public class B15652 {

    static int N, M;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();

    static void input() {
        FastReader reader = new FastReader();
        N = reader.nextInt();
        M = reader.nextInt();
        selected = new int[M + 1];
    }

    static void print(StringBuilder sb) {
        System.out.println(sb.toString());
    }

    static void reqFunc(int k) {
        if (k == M + 1) {
            for (int i = 1; i < k; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        }else {
            int start = selected[k-1]==0 ? 1:selected[k-1];
            for (int i = start; i <= N; i++) {
                selected[k] = i;
                reqFunc(k + 1);
                selected[k] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();

        reqFunc(1);
        print(sb);
    }
}
