package boj;

import java.util.Arrays;

public class B2805 {
    private final FastReader scan = new FastReader();
    // 1 <= N <= 백만
    private int N;
    // 1 <= M <= 20억, int의 범위는 24억가량
    private int M;
    // 0 <= H <= 10억
    private int H;

    private int[] trees;

    private void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        trees = new int[N];
        for (int i = 0; i < N; i++) {
            trees[i] = scan.nextInt();
        }
    }

    private void solve() {
        Arrays.sort(trees);

        int left = 0, right = trees[N - 1];

        while (left <= right) {
            int mid = (left + right) / 2;
            if (satisfyNeeds(mid)) {
                left = mid + 1;
                H = mid;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(H);
    }

    private boolean satisfyNeeds(int jawHeight) {
        long cuttingTrees = 0;
        for (int tree : trees) {
            if (tree <= jawHeight) continue;
            cuttingTrees += tree - jawHeight;
        }
        return cuttingTrees >= M;
    }

    public void main() {
        input();
        solve();
    }

    public static void main(String[] args) {
        B2805 main = new B2805();
        main.main();
    }
}
