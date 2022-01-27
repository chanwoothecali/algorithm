package boj;

public class B14888 {
    static int N, max, min;
    static int[] numbers, order;
    static int[] operators = new int[4];

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        numbers = new int[N + 1];
        order = new int[N];
        for (int i = 1; i <= N; i++) {
            numbers[i] = scan.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            operators[i] = scan.nextInt();
        }

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }

    static void reqFunc(int k) {
        if(k == N) {
            int result = calculate();
            if(max < result) {
                max = result;
            }
            if(min > result) {
                min = result;
            }
        }else {
            for (int i = 0; i < 4; i++) {
                if(operators[i] == 0){
                    continue;
                }else {
                    order[k] = i;
                    operators[i] -= 1;
                    reqFunc(k + 1);
                    operators[i] += 1;
                    order[k] = 0;
                }
            }
        }
    }

    private static int calculate() {
        int result = numbers[1];
        for (int i = 1; i < N; i++) {
            switch (order[i]) {
                case 0:
                    result += numbers[i+1];
                    break;
                case 1:
                    result -= numbers[i+1];
                    break;
                case 2:
                    result *= numbers[i+1];
                    break;
                case 3:
                    result /= numbers[i+1];
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        input();

        reqFunc(1);
        System.out.println(max);
        System.out.println(min);
    }
}
