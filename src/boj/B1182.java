package boj;

public class B1182 {
    static int N, S, result;
    static int[] numbers, used;

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        S = scan.nextInt();
        if (S == 0) {
            result--;
        }
        numbers = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            numbers[i] = scan.nextInt();
        }
    }

    static void reqFunc(int level, int currVal) {
        if(level == N + 1) {
            if(currVal == S) result++;
        }else {
            reqFunc(level + 1, currVal);
            reqFunc(level + 1, currVal + numbers[level]);
        }
    }

    public static void main(String[] args) {
        input();

        reqFunc(1, 0);
        System.out.println(result);
    }
}
